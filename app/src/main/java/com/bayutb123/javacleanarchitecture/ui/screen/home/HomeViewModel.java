package com.bayutb123.javacleanarchitecture.ui.screen.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.bayutb123.javacleanarchitecture.domain.model.User;
import com.bayutb123.javacleanarchitecture.domain.usecase.PrefUseCase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class HomeViewModel extends ViewModel {

    private final PrefUseCase prefUseCase;
    private final ExecutorService backgroundExecutor = Executors.newSingleThreadExecutor();
    @Inject
    public HomeViewModel(PrefUseCase prefUseCase) {
        this.prefUseCase = prefUseCase;
    }

    public LiveData<User> userLiveData() {
        return prefUseCase.getUser();
    }

    public void setUser(User user) {
        backgroundExecutor.execute(() -> {
            try {
                Thread.sleep(2000);
                prefUseCase.setUser(user);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
