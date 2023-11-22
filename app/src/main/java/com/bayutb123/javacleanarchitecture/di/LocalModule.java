package com.bayutb123.javacleanarchitecture.di;

import android.content.Context;
import android.content.SharedPreferences;

import com.bayutb123.javacleanarchitecture.Application;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class LocalModule {

    @Provides
    public static SharedPreferences provideSharedPreference(
           @ApplicationContext Context context
    ) {
        return context.getSharedPreferences("LocalPref", Context.MODE_PRIVATE);
    }
}
