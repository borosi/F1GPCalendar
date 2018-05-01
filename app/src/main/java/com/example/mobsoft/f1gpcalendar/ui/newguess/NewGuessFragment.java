package com.example.mobsoft.f1gpcalendar.ui.newguess;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mobsoft.f1gpcalendar.F1GPCalendarApplication;
import com.example.mobsoft.f1gpcalendar.R;

import javax.inject.Inject;

public class NewGuessFragment extends Fragment implements NewGuessScreen{

    @Inject
    NewGuessPresenter newGuessPresenter;


    public NewGuessFragment() {
        F1GPCalendarApplication.injector.inject(this);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_guess, container, false);
    }

    @Override
    public void showSaveSuccess() {
        Toast.makeText(getContext(), "Guess saved sucessfully", Toast.LENGTH_LONG);
    }

    @Override
    public void showSaveError() {
        Toast.makeText(getContext(), "Error during save", Toast.LENGTH_LONG);
    }
}
