package com.example.mobsoft.f1gpcalendar.mock.db;

import com.example.mobsoft.f1gpcalendar.db.GuessDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MockDbModule {
    @Provides
    @Singleton
    public GuessDataSource provideGuessDataSource() { return new MockGuessDataSourceImpl(); }
}
