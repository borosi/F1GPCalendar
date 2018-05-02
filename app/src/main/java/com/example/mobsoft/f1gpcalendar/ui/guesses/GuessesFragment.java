package com.example.mobsoft.f1gpcalendar.ui.guesses;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.mobsoft.f1gpcalendar.F1GPCalendarApplication;
import com.example.mobsoft.f1gpcalendar.R;
import com.example.mobsoft.f1gpcalendar.model.Guess;
import com.example.mobsoft.f1gpcalendar.ui.main.MainActivity;
import com.example.mobsoft.f1gpcalendar.ui.newguess.NewGuessActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class GuessesFragment extends Fragment implements GuessesScreen {

    @Inject
    GuessesPresenter guessesPresenter;

    private List<Guess> guessList;
    private GuessesAdapter guessesAdapter;
    private RecyclerView recyclerViewGuesses;
    private Button btnGuessNextRace;

    public GuessesFragment() {
        F1GPCalendarApplication.injector.inject(this);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_guesses, container, false);

        // Set up recyclerView
        recyclerViewGuesses = (RecyclerView) view.findViewById(R.id.recyclerViewGuesses);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewGuesses.setLayoutManager(llm);

        guessList = new ArrayList<Guess>();
        guessesAdapter = new GuessesAdapter(getContext(), guessList);
        recyclerViewGuesses.setAdapter(guessesAdapter);

        btnGuessNextRace = (Button) view.findViewById(R.id.guessNextRace);
        btnGuessNextRace.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                guessesPresenter.showNewGuessScreen();
            }
        });


        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        guessesPresenter.attachScreen(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        guessesPresenter.queryGuesses();
    }

    @Override
    public void onDetach() {
        guessesPresenter.detachScreen();
        super.onDetach();
    }

    @Override
    public void showGuesses(List<Guess> guesses) {
        guessList.clear();
        guessList.addAll(guesses);
        guessesAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showNewGuessScreen() {
        Intent intent = new Intent(getActivity(), NewGuessActivity.class);
        intent.putExtra("lastRaceSaved", guessList.get(guessList.size() - 1).getRace().getRaceName());
        startActivity(intent);
    }
}
