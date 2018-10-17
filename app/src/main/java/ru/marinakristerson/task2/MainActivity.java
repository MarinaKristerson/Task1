package ru.marinakristerson.task2;

import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private MainFragment mainFragment;
    private SettingsFragment settingsFragment;
    private SearchFragment searchFragment;

    private void replaceFragment (int idFragment, Fragment fragment){
        String backStackName = fragment.getClass().getName();

        FragmentManager fragmentManager = getSupportFragmentManager();
        boolean fragmentPopped = fragmentManager.popBackStackImmediate (backStackName, 0);

        if (!fragmentPopped){ //fragment not in back stack, create it.
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(idFragment, fragment);
            fragmentTransaction.addToBackStack(backStackName);
            fragmentTransaction.commit();
        }
    }


    //Toast
    public void toastShow (@StringRes int text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.settings:
                toastShow(R.string.settings);

                replaceFragment(R.id.fragmentContainer, settingsFragment);

                return true;
            case R.id.search:
                toastShow(R.string.search);

                replaceFragment(R.id.fragmentContainer, searchFragment);

                return true;
            case R.id.exit:
                toastShow(R.string.exit);

                finish();
                System.exit(0);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFragment = new MainFragment();
        settingsFragment = new SettingsFragment();
        searchFragment = new SearchFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        fragmentTransaction.add(R.id.fragmentContainer, mainFragment);
        fragmentTransaction.commit();
    }
}
