package com.example.homeberry3.DOORS;

        import android.os.Bundle;
        import android.support.annotation.NonNull;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.ImageButton;

        import com.example.homeberry3.BoardDefaults;
        import com.example.homeberry3.MainActivity;
        import com.example.homeberry3.R;
        import com.google.android.things.contrib.driver.pwmservo.Servo;
        import com.google.android.things.pio.Gpio;
        import com.google.android.things.pio.PeripheralManager;
        import com.google.android.things.pio.Pwm;

        import java.io.IOException;

public class FragmentDoor extends Fragment {
    private static final String TAG = MainActivity.class.getSimpleName();

    private static final double MIN_ANGLE_DOOR_CLOSED = 1;
    private static final double MAX_ANGLE_DOOR_OPEN = 2;
    private static final double PULSE_PERIOD_MS = 20;  // Frequency of 50Hz (1000/20)

    private Pwm mPwm;
    private boolean mIsOpen = true;
    private double mDoorActionPWMDuration;

    View view;
    Button btnOpen;
    Button btnClose;

    public FragmentDoor() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate( R.layout.fragment_fragment_door, container, false);


        setupPwmDoor();

        btnOpen = view.findViewById(R.id.btnDoorEntrance);
        btnClose = view.findViewById(R.id.btnDoorEntrance);

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPwmAction();
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPwmAction();
            }
        });

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        try {
            mPwm.close();
        } catch (IOException e) {
            Log.e(TAG, "Error on PeripheralIO API", e);
        } finally {
            mPwm = null;
        }
    }

    public void setupPwmDoor() {
        try {
            String pinName = "PWM0";
            mDoorActionPWMDuration = MIN_ANGLE_DOOR_CLOSED;

            mPwm = PeripheralManager.getInstance().openPwm(pinName);

            // Always set frequency and initial duty cycle before enabling PWM
            mPwm.setPwmFrequencyHz(1000 / PULSE_PERIOD_MS);
            mPwm.setPwmDutyCycle(mDoorActionPWMDuration);
            mPwm.setEnabled(true);
        } catch (IOException e) {
            Log.e(TAG, "Error on PeripheralIO API", e);
        }
    }

    public void setPwmAction() {
        if (mPwm == null) {
            Log.w(TAG, "Stopping runnable since mPwm is null");
            return;
        }

        if (mIsOpen) {
            mDoorActionPWMDuration = MAX_ANGLE_DOOR_OPEN;
            mIsOpen = false;
        } else {
            mDoorActionPWMDuration = MIN_ANGLE_DOOR_CLOSED;
            mIsOpen = true;
        }

        try {
            mPwm.setPwmDutyCycle(100 * mDoorActionPWMDuration / PULSE_PERIOD_MS);
        } catch (IOException e) {
            Log.e(TAG, "Error on PeripheralIO API", e);
        }
    }
}
