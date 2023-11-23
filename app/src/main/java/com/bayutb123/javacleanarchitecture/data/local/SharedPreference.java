package com.bayutb123.javacleanarchitecture.data.local;


import android.content.SharedPreferences;

import com.bayutb123.javacleanarchitecture.domain.model.User;

import javax.inject.Inject;

public class SharedPreference {
    public static String KEY_USER_NAME = "pref_user_name";
    public static String KEY_USER_AGE = "pref_user_age";
    private final SharedPreferences preferences;

    @Inject
    public SharedPreference(SharedPreferences preferences) {
        this.preferences = preferences;
    }

    public void setUser(User user) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_USER_NAME, user.getUserName());
        editor.putInt(KEY_USER_AGE, user.getUserAge());
        editor.apply();
    }

    public User getUser() {
        return new User(preferences.getString(KEY_USER_NAME, ""), preferences.getInt(KEY_USER_AGE, 0));
    }
}