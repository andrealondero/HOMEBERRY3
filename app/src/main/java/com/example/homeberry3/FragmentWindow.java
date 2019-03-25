package com.example.homeberry3;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.util.Log;
import java.io.IOException;
import android.app.Activity;
import android.os.Bundle;


import com.google.android.things.pio.Gpio;
import com.google.android.things.pio.GpioCallback;
import com.google.android.things.pio.PeripheralManager;

import java.io.IOException;

import static com.example.homeberry3.BoardDefaults.PIR_PIN;

public class FragmentWindow extends Fragment {
    View view;
    private static final String TAG = MainActivity.class.getSimpleName();

    private Gpio mPirGpio;


    public FragmentWindow() {
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fragment_window, container, false);

        PeripheralManager manager = PeripheralManager.getInstance();
        try {
            // set PIR sensor as button for LED
            // Create GPIO connection.
            mPirGpio = manager.openGpio(PIR_PIN);
            // Configure as an input.
            mPirGpio.setDirection(Gpio.DIRECTION_IN);
            mPirGpio.setActiveType(Gpio.ACTIVE_HIGH);

            // Enable edge trigger events for both falling and rising edges. This will make it a toggle button.
            mPirGpio.setEdgeTriggerType(Gpio.EDGE_RISING);
            // Register an event callback.
            mPirGpio.registerGpioCallback(mSetLEDCallback);


        } catch (IOException e) {
            Log.e(TAG, "Error on PeripheralIO API", e);
        }

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Close the resource
        if (mPirGpio != null) {
            mPirGpio.unregisterGpioCallback(mSetLEDCallback);
            try {
                mPirGpio.close();
            } catch (IOException e) {
                Log.e(TAG, "Error on PeripheralIO API", e);
            }
        }
    }

    // Register an event callback.
    private GpioCallback mSetLEDCallback = new GpioCallback() {
        @Override
        public boolean onGpioEdge(Gpio gpio) {
            try {
                Log.i(TAG, "GPIO callback -->" + gpio.getValue());
                // set the LED state to opposite of input state
            } catch (IOException e) {
                Log.e(TAG, "Error on PeripheralIO API", e);
            }
            // Return true to keep callback active.
            return true;
        }
    };


}


