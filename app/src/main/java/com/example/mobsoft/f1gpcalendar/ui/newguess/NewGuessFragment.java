package com.example.mobsoft.f1gpcalendar.ui.newguess;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobsoft.f1gpcalendar.F1GPCalendarApplication;
import com.example.mobsoft.f1gpcalendar.R;
import com.example.mobsoft.f1gpcalendar.model.GetDriversInSeason.Driver;
import com.example.mobsoft.f1gpcalendar.model.Guess;
import com.example.mobsoft.f1gpcalendar.model.Race;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class NewGuessFragment extends Fragment implements NewGuessScreen {

    @Inject
    NewGuessPresenter newGuessPresenter;

    private Race race;
    private List<Driver> drivers;

    private TextView raceName;
    private AutoCompleteTextView firstDriverName;
    private AutoCompleteTextView secondDriverName;
    private AutoCompleteTextView thirdDriverName;
    private Button btnSaveGuess;

    private ArrayList<String> driversAutoComplete = new ArrayList<String>();

    public NewGuessFragment() {
        F1GPCalendarApplication.injector.inject(this);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_guess, container, false);

        raceName = (TextView) view.findViewById(R.id.raceName);

        firstDriverName = (AutoCompleteTextView) view.findViewById(R.id.firstDriverName);
        firstDriverName.setThreshold(1);

        secondDriverName = (AutoCompleteTextView) view.findViewById(R.id.secondDriverName);
        secondDriverName.setThreshold(1);

        thirdDriverName = (AutoCompleteTextView) view.findViewById(R.id.thirdDriverName);
        thirdDriverName.setThreshold(1);

        btnSaveGuess = (Button) view.findViewById(R.id.button2);
        btnSaveGuess.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Driver first = getDriverByName(((EditText)firstDriverName).getText().toString());
                Driver second = getDriverByName(((EditText)secondDriverName).getText().toString());
                Driver third = getDriverByName(((EditText)thirdDriverName).getText().toString());
                if(first == null || second == null || third == null)
                    showSaveError("One of the names is invalid");
                Guess guess = new Guess();
                guess.setFirst(first);
                guess.setSecond(second);
                guess.setThird(third);
                newGuessPresenter.saveGuess(guess);
            }
        });

        return view;
    }

    private Driver getDriverByName(String name) {
        for(Driver d : this.drivers) {
            if((d.getGivenName() + " " + d.getFamilyName()).equalsIgnoreCase(name.trim()))
                return d;
        }
        return null;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        newGuessPresenter.attachScreen(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        newGuessPresenter.getNextRace();
        newGuessPresenter.loadDrivers();
    }

    @Override
    public void onDetach() {
        newGuessPresenter.detachScreen();
        super.onDetach();
    }

    @Override
    public void showSaveSuccess() {
        Toast.makeText(getContext(), "Guess saved successfully", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showSaveError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showNetworkError(String message) {
        Toast.makeText(getContext(), "Error getting drivers", Toast.LENGTH_LONG).show();
    }

    @Override
    public void setNextRace(Race nextRace) {
        race = nextRace;
        raceName.setText(race.getRaceName());
    }

    @Override
    public void storeDrivers(List<Driver> drivers) {
        this.drivers = drivers;

        for(Driver d : this.drivers) {
            driversAutoComplete.add(d.getGivenName() + " " + d.getFamilyName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.select_dialog_item, driversAutoComplete);
        firstDriverName.setAdapter(adapter);
        secondDriverName.setAdapter(adapter);
        thirdDriverName.setAdapter(adapter);

//        List<Guess> guesses = Guess.listAll(Guess.class);
//        Toast.makeText(getContext(), guesses.get(1).getFirst().getFamilyName(), Toast.LENGTH_LONG).show();
    }
}
