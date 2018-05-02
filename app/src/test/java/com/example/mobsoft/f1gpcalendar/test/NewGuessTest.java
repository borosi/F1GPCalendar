package com.example.mobsoft.f1gpcalendar.test;

import com.example.mobsoft.f1gpcalendar.BuildConfig;
import com.example.mobsoft.f1gpcalendar.model.Guess;
import com.example.mobsoft.f1gpcalendar.model.Race;
import com.example.mobsoft.f1gpcalendar.ui.newguess.NewGuessPresenter;
import com.example.mobsoft.f1gpcalendar.ui.newguess.NewGuessScreen;
import com.example.mobsoft.f1gpcalendar.utils.DbData;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import static com.example.mobsoft.f1gpcalendar.TestHelper.setTestInjector;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class NewGuessTest {

    private NewGuessPresenter newGuessPresenter;
    private NewGuessScreen newGuessScreen;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        newGuessScreen = mock(NewGuessScreen.class);
        newGuessPresenter = new NewGuessPresenter();
        newGuessPresenter.attachScreen(newGuessScreen);
    }

    @Test
    public void testLoadDrivers() {
        newGuessPresenter.loadDrivers();

        ArgumentCaptor<List> driversCaptor = ArgumentCaptor.forClass(List.class);
        verify(newGuessScreen).storeDrivers(driversCaptor.capture());
        assertTrue(driversCaptor.getValue().size() > 0);
    }

    @Test
    public void testGetNextRace() {
        newGuessPresenter.getNextRace();
        ArgumentCaptor<Race> raceCaptor = ArgumentCaptor.forClass(Race.class);
        verify(newGuessScreen).setNextRace(raceCaptor.capture());
        assertNotNull(raceCaptor);
    }


    @Test
    public void testSaveGuessSuccess() {
        Guess guess = DbData.getExampleGuess();
        newGuessPresenter.saveGuess(guess);
        verify(newGuessScreen).showSaveSuccess();
    }

    @Test
    public void testSaveGuessError() {
        newGuessPresenter.saveGuess(null);
        ArgumentCaptor<String> errorMessageCaptor = ArgumentCaptor.forClass(String.class);
        verify(newGuessScreen).showSaveError(errorMessageCaptor.capture());
        assertNotNull(errorMessageCaptor.getValue());
    }

    @After
    public void tearDown(){ newGuessPresenter.detachScreen(); }

}
