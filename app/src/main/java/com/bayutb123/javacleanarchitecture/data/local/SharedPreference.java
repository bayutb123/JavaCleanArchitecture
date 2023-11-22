package com.bayutb123.javacleanarchitecture.data.local;


import android.content.SharedPreferences;

import androidx.annotation.Nullable;

import java.util.Set;

import javax.inject.Inject;

public class SharedPreference {
    private final SharedPreferences preferences;

    @Inject
    public SharedPreference(SharedPreferences preferences) {
        this.preferences = preferences;
    }

    public void setData(String data) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("name", data);
        editor.apply();
    }

    public String getName() {
        return preferences.getString("name", "Not available");
    }
}