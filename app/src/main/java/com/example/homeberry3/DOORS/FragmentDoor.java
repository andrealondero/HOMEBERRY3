package com.example.homeberry3.DOORS;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.homeberry3.R;

public class FragmentDoor extends Fragment {

    View view;
    ImageButton entranceDoor;

//    private static final String TAG = MainActivity.class.getSimpleName();
//    private Gpio mLedGpio;
//    boolean state = false;

    public FragmentDoor() {
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate( R.layout.fragment_fragment_door, container, false);
        /*        PeripheralManager pioService = PeripheralManager.getInstance();
        try {
            Log.i(TAG, "Configuring GPIO pins");
            mLedGpio = pioService.openGpio( BoardDefaults.LED_RED);
            mLedGpio.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
        } catch (IOException e) {
            Log.e(TAG, "Error configuring GPIO pins", e);
        } */
        entranceDoor = view.findViewById(R.id.btnDoorEntrance);

        entranceDoor.setOnClickListener(new View.OnClickListener() {
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
/*    private void setLedValue(boolean value) {
        try {
            mLedGpio.setValue(value);
        } catch (IOException e) {
            Log.e(TAG, "Error updating GPIO value", e);
        }
    } */

}
