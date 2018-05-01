package com.example.mobsoft.f1gpcalendar.ui.main;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mobsoft.f1gpcalendar.R;
import com.example.mobsoft.f1gpcalendar.model.Race;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.xml.datatype.Duration;

public class RacesAdapter extends RecyclerView.Adapter<RacesAdapter.ViewHolder> {

    private Context context;
    private List<Race> races;

    public RacesAdapter(Context context, List<Race> races) {
        this.context = context;
        this.races = races;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_race, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Race race = races.get(position);
        holder.tvRaceName.setText(race.getRaceName());

        DateFormat df = new SimpleDateFormat("dd MMM", Locale.US);

        Calendar cal = Calendar.getInstance();
        cal.setTime(race.getDate());
        cal.add(Calendar.DATE, -2);

        holder.tvRaceDate.setText(df.format(cal.getTime()) + "-" + df.format(race.getDate()));

        if(race.getDate().before(new Date())) {
            holder.tvDaysUntilRace.setText("ENDED");
        }
        else {
            long diffInMillies = Math.abs(new Date().getTime() - race.getDate().getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

            holder.tvDaysUntilRace.setText("in " + diff + " days");
        }
    }

    @Override
    public int getItemCount() {
        return races.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvRaceName;
        public TextView tvRaceDate;
        public TextView tvDaysUntilRace;

        public ViewHolder(View itemView) {
            super(itemView);
            tvRaceName = (TextView) itemView.findViewById(R.id.raceName);
            tvRaceDate = (TextView) itemView.findViewById(R.id.raceDate);
            tvDaysUntilRace = (TextView) itemView.findViewById(R.id.daysToRace);
        }
    }
}
