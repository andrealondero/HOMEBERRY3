package com.example.homeberry3.LIGHTS;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.homeberry3.R;
import com.google.android.things.pio.Gpio;

import java.io.IOException;

public class FragmentLight extends Fragment {

    View view;
    ImageButton entranceLight;

//    private static final String TAG = MainActivity.class.getSimpleName();
//    private Gpio mLedGpio;
//    boolean state = false;

    //public static final String PIR_PIN = "BCM17"; //physical pin #11
    //public static final String LED_PIN = "BCM13"; //physical pin #33

    private Gpio mPirGpio;
    private Gpio mLed2Gpio;

    public FragmentLight() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate( R.layout.fragment_fragment_light, container, false);

/*        PeripheralManager pioService = PeripheralManager.getInstance();
        try {
            Log.i(TAG, "Configuring GPIO pins");
        // set PIR sensor as button for LED
            // Create GPIO connection.
            mPirGpio = service.openGpio(PIR_PIN);
            // Configure as an input.
            mPirGpio.setDirection(Gpio.DIRECTION_IN);
            // Enable edge trigger events for both falling and rising edges. This will make it a toggle button.
            mPirGpio.setEdgeTriggerType(Gpio.EDGE_BOTH);
            // Register an event callback.
            mPirGpio.registerGpioCallback(mSetLEDCallback);

            // set LED as output
            // Create GPIO connection.
            mLed2Gpio = service.openGpio(LED_PIN);
            // Configure as an output.
            mLed2Gpio.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);



            mLedGpio = pioService.openGpio( BoardDefaults.LED_RED);
            mLedGpio.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
        } catch (IOException e) {
            Log.e(TAG, "Error configuring GPIO pins", e);
        } */

   /*     if(!getPirState())
            setLedValue2(false);
        else setLedValue2(true);*/

        entranceLight = view.findViewById(R.id.btnEntrance);

        entranceLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

/*               if(state == false) {
                   state = true;
                   setLedValue(true);
               }
               else {
                   state = false;
                   setLedValue(false);
               } */
            }
        });

        return view;
    }
/*
    private boolean getPirState(){
        try {
            return mPirGpio.getValue();
        } catch (IOException e){
            Log.e(TAG, "Error getting GPIO value", e);
        }
        return false;
    }

    private void setLedValue2(boolean value) {
        try {
            mLedGpio.setValue(value);
        } catch (IOException e) {
            Log.e(TAG, "Error updating GPIO value", e);
        }
    }
/*    private void setLedValue(boolean value) {
        try {
            mLedGpio.setValue(value);
        } catch (IOException e) {
            Log.e(TAG, "Error updating GPIO value", e);
        }
    } */

}
