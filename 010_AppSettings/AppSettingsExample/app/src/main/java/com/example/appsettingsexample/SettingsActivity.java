package com.example.appsettingsexample;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import androidx.preference.SwitchPreference;
import androidx.preference.SwitchPreferenceCompat;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settings, new SettingsFragment())
                .commit();

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);

            final SwitchPreferenceCompat sync = findPreference("sync");
            boolean syncValue = PreferenceManager.getDefaultSharedPreferences(getActivity()).getBoolean(sync.getKey(), false);
            if(syncValue){
                sync.setSummary("Enabled");
            }else{
                sync.setSummary("Disabled");
            }

            sync.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    Boolean newBoolean = (Boolean) newValue;
                    if(newBoolean){
                        sync.setSummary("Enabled");
                    }else{
                        sync.setSummary("Disabled");
                    }
                    return true;
                }
            });
        }
    }
}