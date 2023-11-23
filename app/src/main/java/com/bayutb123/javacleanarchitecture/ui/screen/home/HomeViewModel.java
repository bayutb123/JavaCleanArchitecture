package com.bayutb123.javacleanarchitecture.ui.screen.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bayutb123.javacleanarchitecture.domain.model.User;
import com.bayutb123.javacleanarchitecture.domain.usecase.PrefUseCase;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class HomeViewModel extends ViewModel {

    private final PrefUseCase prefUseCase;

    @Inject
    public HomeViewModel(PrefUseCase prefUseCase) {
        this.prefUseCase = prefUseCase;
    }

    public LiveData<User> userLiveData() {
        return prefUseCase.getUser();
    }

    public void setUser(User user) {
        prefUseCase.setUser(user);
    }

}
