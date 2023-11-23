package com.bayutb123.javacleanarchitecture.domain.repository;

import androidx.lifecycle.LiveData;

import com.bayutb123.javacleanarchitecture.domain.model.User;

public interface PrefRepository {
    void setUser(User user);
    LiveData<User> getUser();
}
