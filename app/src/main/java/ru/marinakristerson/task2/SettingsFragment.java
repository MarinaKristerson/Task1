package ru.marinakristerson.task2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Toast;

public class SettingsFragment extends Fragment {

    private RadioButton mRadioButton;
    private RadioButton mRadioButtonGoogle;
    private RadioButton mRadioButtonYandex;
    private RadioButton mRadioButtonBing;

    private SharedPreferencesHelper mSharedPreferencesHelper;
    private  String settings;


    View.OnClickListener radioButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            mRadioButton = (RadioButton) view;

            switch (mRadioButton.getId()) {
                case R.id.google:
                    mSharedPreferencesHelper.saveValue(mRadioButton.getText().toString());
                    break;
                case R.id.yandex:
                    mSharedPreferencesHelper.saveValue(mRadioButton.getText().toString());
                    break;
                case R.id.bing:
                    mSharedPreferencesHelper.saveValue(mRadioButton.getText().toString());
                    break;

                default:
                    break;
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fr_settings, container, false);

        mRadioButtonGoogle = v.findViewById(R.id.google);
        mRadioButtonYandex = v.findViewById(R.id.yandex);
        mRadioButtonBing = v.findViewById(R.id.bing);

        mRadioButtonGoogle.setOnClickListener(radioButtonClickListener);
        mRadioButtonYandex.setOnClickListener(radioButtonClickListener);
        mRadioButtonBing.setOnClickListener(radioButtonClickListener);

        mSharedPreferencesHelper = new SharedPreferencesHelper(getActivity());
        settings = mSharedPreferencesHelper.loadValue();
        

        if ((mRadioButtonGoogle.getText().toString()).equals(settings)) {
            mRadioButtonGoogle.setChecked(true);
        } else if ((mRadioButtonYandex.getText().toString()).equals(settings)) {
            mRadioButtonYandex.setChecked(true);
        } else if ((mRadioButtonBing.getText().toString()).equals(settings)) {
            mRadioButtonBing.setChecked(true);
        }

        return v;
    }
}
