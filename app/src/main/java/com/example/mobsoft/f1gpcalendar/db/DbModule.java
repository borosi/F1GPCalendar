package com.example.mobsoft.f1gpcalendar.db;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DbModule {
    @Provides
    @Singleton
    public GuessDataSource provideGuessDataSource() { return new GuessDataSourceImpl(); }
}
