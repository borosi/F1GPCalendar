package com.example.mobsoft.f1gpcalendar.test;

import com.example.mobsoft.f1gpcalendar.BuildConfig;
import com.example.mobsoft.f1gpcalendar.F1GPCalendarApplication;
import com.example.mobsoft.f1gpcalendar.TestComponent;
import com.example.mobsoft.f1gpcalendar.db.GuessDataSource;
import com.example.mobsoft.f1gpcalendar.mock.db.MockGuessDataSourceImpl;
import com.example.mobsoft.f1gpcalendar.model.Circuit;
import com.example.mobsoft.f1gpcalendar.model.GetDriversInSeason.Driver;
import com.example.mobsoft.f1gpcalendar.model.Guess;
import com.example.mobsoft.f1gpcalendar.model.Location;
import com.example.mobsoft.f1gpcalendar.model.Race;
import com.example.mobsoft.f1gpcalendar.ui.guesses.GuessesPresenter;
import com.example.mobsoft.f1gpcalendar.ui.guesses.GuessesScreen;
import com.example.mobsoft.f1gpcalendar.ui.main.MainPresenter;
import com.example.mobsoft.f1gpcalendar.ui.main.MainScreen;
import com.example.mobsoft.f1gpcalendar.utils.DbData;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import static com.example.mobsoft.f1gpcalendar.TestHelper.setTestInjector;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class GuessesTest {

    @Inject
    GuessDataSource guessDataSource;

    private GuessesPresenter guessesPresenter;
    private GuessesScreen guessesScreen;

    @Before
    public void setup() throws Exception {
        setTestInjector().inject(this);
        guessesScreen = mock(GuessesScreen.class);
        guessesPresenter = new GuessesPresenter();
        guessesPresenter.attachScreen(guessesScreen);

        guessDataSource.saveGuess(DbData.getExampleGuess());
    }

    @Test
    public void testQueryGuesses() {
        guessesPresenter.queryGuesses();

        ArgumentCaptor<List>  guessesCaptor = ArgumentCaptor.forClass(List.class);
        verify(guessesScreen).showGuesses(guessesCaptor.capture());
        assertTrue(guessesCaptor.getValue().size() > 0);
    }

    @Test
    public void testShowNewGuessScreen() {
        guessesPresenter.showNewGuessScreen();
        verify(guessesScreen).showNewGuessScreen();
    }

    @After
    public void tearDown() {
        guessesPresenter.detachScreen();
    }

}
