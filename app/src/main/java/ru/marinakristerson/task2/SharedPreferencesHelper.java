package ru.marinakristerson.task2;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public class SharedPreferencesHelper {

    public static final String SHARED_PREF_NAME = "SHARED_PREF_NAME";
    public static final String STRING_VALUE = "SETTING_VALUE";

    private SharedPreferences mSharedPreferences;
    private Context context;

    public SharedPreferencesHelper(Context context) {
        mSharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        this.context = context;
    }

    public void saveValue(String s) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(STRING_VALUE, s);
        editor.commit();
        //Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
    }

    public String loadValue() {
        String setValue = mSharedPreferences.getString(STRING_VALUE, "");
        return setValue;
    }
}
