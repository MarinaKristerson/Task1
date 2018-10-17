package ru.marinakristerson.task2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class SearchFragment extends Fragment {

    private SharedPreferencesHelper mSharedPreferencesHelper;

    private  String settings;


    private EditText mUserText;
    private Button mSearchButton;
    private String url;

    private boolean isTextEmprty () {
        return !TextUtils.isEmpty(mUserText.getText());
    }

    private View.OnClickListener mOnBtnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (isTextEmprty()) {
                Uri searchingPage = Uri.parse(url + mUserText.getText());
                Intent startSearchingIntent = new Intent(Intent.ACTION_VIEW, searchingPage);
                startActivity(startSearchingIntent);
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fr_search, container, false);

        mSharedPreferencesHelper = new SharedPreferencesHelper(getActivity());
        settings = mSharedPreferencesHelper.loadValue();


        mUserText = v.findViewById(R.id.et_search_text);
        mSearchButton = v.findViewById(R.id.search_btn);


        if (("Google").equals(settings)) {
            url = "http://google.com/search?q=";
        } else if (("Яндекс").equals(settings)) {
            url = "http://yandex.ru/search?text=";
        } else if (("Bing").equals(settings)) {
            url = "http://bing.com/search?q=";
        }

        mSearchButton.setOnClickListener(mOnBtnClickListener);

        return v;
    }
}
