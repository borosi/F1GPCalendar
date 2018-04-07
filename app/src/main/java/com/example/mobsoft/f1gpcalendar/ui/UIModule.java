package com.example.mobsoft.f1gpcalendar.ui;

import android.content.Context;

import com.example.mobsoft.f1gpcalendar.ui.guesses.GuessesPresenter;
import com.example.mobsoft.f1gpcalendar.ui.main.MainPresenter;
import com.example.mobsoft.f1gpcalendar.ui.newguess.NewGuessPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) { this.context = context; }

    @Provides
    public Context provideContext() { return context; }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() { return new MainPresenter(); }

    @Provides
    @Singleton
    public GuessesPresenter provideGuessesPresenter() { return new GuessesPresenter(); }

    @Provides
    @Singleton
    public NewGuessPresenter provideNewGuessPresenter() { return new NewGuessPresenter(); }
}
