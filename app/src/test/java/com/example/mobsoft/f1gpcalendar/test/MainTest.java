package com.example.mobsoft.f1gpcalendar.test;

import android.app.Activity;

import com.example.mobsoft.f1gpcalendar.BuildConfig;
import com.example.mobsoft.f1gpcalendar.ui.main.MainPresenter;
import com.example.mobsoft.f1gpcalendar.ui.main.MainScreen;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import static com.example.mobsoft.f1gpcalendar.TestHelper.setTestInjector;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainTest {

    private MainPresenter mainPresenter;
    private MainScreen mainScreen;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        mainScreen = mock(MainScreen.class);
        mainPresenter = new MainPresenter();
        mainPresenter.attachScreen(mainScreen);
    }

    @Test
    public void testLoadGrandsPrix() {
        mainPresenter.loadGrandsPrix();

        ArgumentCaptor<List> grandsPrixCaptor = ArgumentCaptor.forClass(List.class);
        verify(mainScreen).showGrandsPrix(grandsPrixCaptor.capture());
        assertTrue(grandsPrixCaptor.getValue().size() > 0);
    }

    @After
    public void tearDown() {
        mainPresenter.detachScreen();
    }

}
