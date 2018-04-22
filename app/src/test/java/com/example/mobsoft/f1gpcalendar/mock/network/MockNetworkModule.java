package com.example.mobsoft.f1gpcalendar.mock.network;

import com.example.mobsoft.f1gpcalendar.network.GrandsPrixApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class MockNetworkModule {
    @Provides
    @Singleton
    public Retrofit.Builder provideRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create());
    }

    @Provides
    @Singleton
    public GrandsPrixApi provideGrandPrixApi(Retrofit.Builder retrofitBuilder) {
        return new MockGrandsPrixApi();
    }
}
