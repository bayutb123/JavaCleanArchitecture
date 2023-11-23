package com.bayutb123.javacleanarchitecture.di;

import android.content.Context;
import android.content.SharedPreferences;

import com.bayutb123.javacleanarchitecture.Application;
import com.bayutb123.javacleanarchitecture.data.local.SharedPreference;
import com.bayutb123.javacleanarchitecture.data.repository.PrefRepositoryImpl;
import com.bayutb123.javacleanarchitecture.domain.repository.PrefRepository;
import com.bayutb123.javacleanarchitecture.domain.usecase.PrefUseCase;

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

    @Provides
    public static PrefRepository providePrefRepository(
            SharedPreference sharedPreference
    ) {
        return new PrefRepositoryImpl(sharedPreference);
    }

    @Provides
    public static PrefUseCase providePrefUseCase(
            PrefRepository prefRepository
    ) {
        return new PrefUseCase(prefRepository);
    }
}
