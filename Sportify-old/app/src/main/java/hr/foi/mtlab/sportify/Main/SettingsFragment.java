package hr.foi.mtlab.sportify.Main;

import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

import hr.foi.mtlab.sportify.R;

/**
 * Created by Alen on 3.5.2016..
 */
    public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);
    }

    

}

