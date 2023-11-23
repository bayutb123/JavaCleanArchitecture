package com.bayutb123.javacleanarchitecture.data.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.bayutb123.javacleanarchitecture.data.local.SharedPreference;
import com.bayutb123.javacleanarchitecture.domain.model.User;
import com.bayutb123.javacleanarchitecture.domain.repository.PrefRepository;

import javax.inject.Inject;

public class PrefRepositoryImpl implements PrefRepository {

    private final SharedPreference preference;
    private final MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();

    @Inject
    public PrefRepositoryImpl(SharedPreference sharedPreference) {
        this.preference = sharedPreference;

        userMutableLiveData.setValue(preference.getUser());
    }

    @Override
    public void setUser(User user) {
        preference.setUser(user);
        userMutableLiveData.postValue(user);
    }

    @Override
    public LiveData<User> getUser() {
        return userMutableLiveData;
    }

}
