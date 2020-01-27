package hr.foi.mtlab.sportify.Facebook;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import hr.foi.mtlab.sportify.Main.MainActivity;
import hr.foi.mtlab.sportify.R;


public class SplashActivity extends AppCompatActivity implements FacebookLoginFragmentInterface {
    private static int SPLASH_TIME_OUT = 3000;
    Handler handler;
    private SplashActivity splashActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        handler = new Handler();
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        sharedPref.getBoolean("user_logged_in", false);
        if (sharedPref.getBoolean("user_logged_in", false)) {
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }, SPLASH_TIME_OUT);
        }
        else {
            FacebookLoginFragment facebookLoginFragment =new FacebookLoginFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.facebook_container, facebookLoginFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }


    }

    public void kill()
    {
        Intent MainActivity = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(MainActivity);
        finish();
    }

    @Override
    public void onFacebookLoginAttempted(boolean success) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("user_logged_in", success);
        editor.apply();
        if ((success)==true){
            kill();
        }
    }
}

