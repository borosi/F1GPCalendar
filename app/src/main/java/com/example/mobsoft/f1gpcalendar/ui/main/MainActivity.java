package com.example.mobsoft.f1gpcalendar.ui.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.mobsoft.f1gpcalendar.F1GPCalendarApplication;
import com.example.mobsoft.f1gpcalendar.R;
import com.example.mobsoft.f1gpcalendar.model.Race;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainScreen {

    @Inject
    MainPresenter mainPresenter;

    private List<Race> races;
    private RacesAdapter racesAdapter;
    private RecyclerView recyclerViewRaces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        F1GPCalendarApplication.injector.inject(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerViewRaces = (RecyclerView) findViewById(R.id.recyclerViewRaces);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewRaces.setLayoutManager(llm);

        races = new ArrayList<Race>();
        racesAdapter = new RacesAdapter(this, races);
        recyclerViewRaces.setAdapter(racesAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.loadGrandsPrix();
    }

    @Override
    protected void onStop() {
        mainPresenter.detachScreen();
        super.onStop();
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
        this.races.clear();
        this.races.addAll(races);
        racesAdapter.notifyDataSetChanged();

//        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showNetworkError(String errorMsg) {
        Toast.makeText(getApplicationContext(), errorMsg, Toast.LENGTH_LONG).show();
    }
}
