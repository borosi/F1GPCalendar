package com.example.mobsoft.f1gpcalendar.ui.main;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mobsoft.f1gpcalendar.F1GPCalendarApplication;
import com.example.mobsoft.f1gpcalendar.R;
import com.example.mobsoft.f1gpcalendar.model.Race;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class MainFragment extends Fragment implements MainScreen {

    @Inject
    MainPresenter mainPresenter;

    private List<Race> raceList;
    private RacesAdapter racesAdapter;
    private RecyclerView recyclerViewRaces;

    public MainFragment() {
        F1GPCalendarApplication.injector.inject(this);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_main, container, false);

        // Set up recyclerView
        recyclerViewRaces = (RecyclerView) view.findViewById(R.id.recyclerViewRaces);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewRaces.setLayoutManager(llm);

        raceList = new ArrayList<Race>();
        racesAdapter = new RacesAdapter(getContext(), raceList);
        recyclerViewRaces.setAdapter(racesAdapter);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainPresenter.attachScreen(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        mainPresenter.loadGrandsPrix();
    }

    @Override
    public void onDetach() {
        mainPresenter.detachScreen();
        super.onDetach();
    }

    @Override
    public void showGrandsPrix(List<Race> races) {
        //Toast.makeText(getApplicationContext(), races.get(1).getRaceName(), Toast.LENGTH_LONG).show();
//        races.get(15).save();
//        List<Race> race = Race.listAll(Race.class);
//        String s = "";
//        for(Race r : race) {
//            Log.i("DB", "showGrandsPrix: " + r.getRaceName());
//            s += r.getRaceName();
//            s += "\n";
//        }
        Log.d("RACE", "showGrandsPrix: " + races.size());
        raceList.clear();
        raceList.addAll(races);
        racesAdapter.notifyDataSetChanged();

//        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showNetworkError(String errorMsg) {
        Toast.makeText(getContext(), errorMsg, Toast.LENGTH_LONG).show();
    }
}
