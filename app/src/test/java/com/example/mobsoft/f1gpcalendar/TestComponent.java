package com.example.mobsoft.f1gpcalendar;

import com.example.mobsoft.f1gpcalendar.interactor.InteractorModule;
import com.example.mobsoft.f1gpcalendar.mock.db.MockDbModule;
import com.example.mobsoft.f1gpcalendar.mock.network.MockNetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class, MockDbModule.class, InteractorModule.class})
public interface TestComponent extends F1GPCalendarApplicationComponent {
}
