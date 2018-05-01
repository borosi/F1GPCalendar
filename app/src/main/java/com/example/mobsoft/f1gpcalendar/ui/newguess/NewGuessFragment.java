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
import android.widget.Filter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobsoft.f1gpcalendar.F1GPCalendarApplication;
import com.example.mobsoft.f1gpcalendar.R;
import com.example.mobsoft.f1gpcalendar.model.GetDriversInSeason.Driver;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class NewGuessFragment extends Fragment implements NewGuessScreen {

    @Inject
    NewGuessPresenter newGuessPresenter;

    private List<Driver> drivers;

    private AutoCompleteTextView firstDriverName;
    private AutoCompleteTextView secondDriverName;
    private AutoCompleteTextView thirdDriverName;

    private ArrayList<String> driversAutoComplete = new ArrayList<String>();

    public NewGuessFragment() {
        F1GPCalendarApplication.injector.inject(this);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_guess, container, false);

        firstDriverName = (AutoCompleteTextView) view.findViewById(R.id.firstDriverName);
        firstDriverName.setThreshold(1);

        secondDriverName = (AutoCompleteTextView) view.findViewById(R.id.secondDriverName);
        secondDriverName.setThreshold(1);

        thirdDriverName = (AutoCompleteTextView) view.findViewById(R.id.thirdDriverName);
        thirdDriverName.setThreshold(1);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        newGuessPresenter.attachScreen(this);
    }

    @Override
    public void onResume() {
        super.onResume();
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
    public void showSaveError() {
        Toast.makeText(getContext(), "Error during save", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showNetworkError(String message) {
        Toast.makeText(getContext(), "Error getting drivers", Toast.LENGTH_LONG).show();
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
    }

    protected class DriversAdapter extends ArrayAdapter<Driver> {

        private LayoutInflater layoutInflater;
        private List<Driver> driversList;

        private Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();

                if(constraint != null){
                    ArrayList<Driver> suggestions = new ArrayList<Driver>();
                    for(Driver d : driversList){
                        String name = d.getGivenName() + " " + d.getFamilyName();
                        if(name.toLowerCase().contains(constraint.toString().toLowerCase())) {
                            suggestions.add(d);
                        }
                    }

                    results.values = suggestions;
                    results.count = suggestions.size();
                }

                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                clear();
                if(results != null && results.count > 0)
                    addAll((ArrayList<Driver>) results.values);
                else
                    addAll(driversList);
                notifyDataSetChanged();
            }

            @Override
            public CharSequence convertResultToString(Object resultValue) {
                Driver d = (Driver)resultValue;
                return d.getGivenName() + " " + d.getFamilyName();
            }
        };

        public DriversAdapter(@NonNull Context context, int textViewResourceId, @NonNull List<Driver> drivers) {
            super(context, textViewResourceId, drivers);
            driversList = new ArrayList<Driver>();
            driversList.addAll(drivers);
            layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            Driver driver = driversList.get(position);

//            if(convertView == null)
//                convertView = layoutInflater.inflate(, null);

            ((AutoCompleteTextView)convertView.findViewById(R.id.firstDriverName)).setText(driver.getGivenName() + " " + driver.getFamilyName());

            return convertView;
        }

        @NonNull
        @Override
        public Filter getFilter() {
            return filter;
        }
    }
}
