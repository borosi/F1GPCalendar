package com.example.mobsoft.f1gpcalendar.ui.guesses;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mobsoft.f1gpcalendar.R;
import com.example.mobsoft.f1gpcalendar.model.Guess;

import java.util.List;


public class GuessesAdapter extends RecyclerView.Adapter<GuessesAdapter.ViewHolder> {

    private Context context;
    private List<Guess> guessList;

    public GuessesAdapter(Context context, List<Guess> guessList) {
        this.context = context;
        this.guessList = guessList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_guess, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Guess guess = guessList.get(position);

        if(guess.getRace() == null)
            holder.raceName.setText("Example race");
        else
            holder.raceName.setText(guess.getRace().getRaceName());

        if(guess.getFirst() == null)
            holder.firstGuess.setText("Example first");
        else
            holder.firstGuess.setText(guess.getFirst().getGivenName() + " " + guess.getFirst().getFamilyName());

        if(guess.getSecond() == null)
            holder.secondGuess.setText("Example second");
        else
            holder.secondGuess.setText(guess.getSecond().getGivenName() + " " + guess.getSecond().getFamilyName());

        if(guess.getThird() == null)
            holder.thirdGuess.setText("Example third");
        else
            holder.thirdGuess.setText(guess.getThird().getGivenName() + " " + guess.getThird().getFamilyName());
    }

    @Override
    public int getItemCount() {
        return guessList.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {

        public TextView raceName;
        public TextView firstGuess;
        public TextView secondGuess;
        public TextView thirdGuess;

        public ViewHolder(View itemView) {
            super(itemView);
            raceName = (TextView) itemView.findViewById(R.id.raceName);
            firstGuess = (TextView) itemView.findViewById(R.id.firstGuess);
            secondGuess = (TextView) itemView.findViewById(R.id.secondGuess);
            thirdGuess = (TextView) itemView.findViewById(R.id.thirdGuess);
        }
    }
}
