package com.bayutb123.javacleanarchitecture.domain.usecase;

import androidx.lifecycle.LiveData;

import com.bayutb123.javacleanarchitecture.domain.model.User;
import com.bayutb123.javacleanarchitecture.domain.repository.PrefRepository;

import javax.inject.Inject;

public class PrefUseCase {
    private final PrefRepository prefRepository;

    @Inject
    public PrefUseCase(PrefRepository prefRepository){
        this.prefRepository = prefRepository;
    }
    public void setUser(User user) {
        prefRepository.setUser(user);
    }

    public LiveData<User> getUser() {
        return prefRepository.getUser();
    }
}
