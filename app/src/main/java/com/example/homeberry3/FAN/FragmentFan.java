package com.example.homeberry3.FAN;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.homeberry3.BoardDefaults;
import com.example.homeberry3.MainActivity;
import com.example.homeberry3.R;
import com.google.android.things.contrib.driver.button.Button;
import com.google.android.things.pio.Gpio;
import com.google.android.things.pio.PeripheralManager;

import java.io.IOException;

import static com.example.homeberry3.BoardDefaults.MOTOR_PIN;

public class FragmentFan extends Fragment {

    View view;
    ImageButton fanBtn;

    private static final String TAG = MainActivity.class.getSimpleName();
      private Gpio myMotorGpio;
      boolean state = false;

    public FragmentFan() {
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate( R.layout.fragment_fragment_fan, container, false);

        PeripheralManager pioService = PeripheralManager.getInstance();

        try {
                Log.i(TAG, "Configuring GPIO pins");
            myMotorGpio = pioService.openGpio(BoardDefaults.MOTOR_PIN);
            myMotorGpio.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
            } catch (IOException e) {
                Log.e(TAG, "Error configuring GPIO pins", e);
            }


        fanBtn = view.findViewById(R.id.btnFan);

        fanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if(state == false) {
                   state = true;
                   setMotorValue(true);
               }
               else {
                   state = false;
                   setMotorValue(false);
               }
            }
        });

        return view;
    }
    private void setMotorValue(boolean value) {
        try {
            myMotorGpio.setValue(value);
        } catch (IOException e) {
            Log.e(TAG, "Error updating GPIO value", e);
        }
    }

}