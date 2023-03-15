package com.joke.learningjava;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learningjava.R;
import com.google.gson.Gson;
import com.models.Joke;
import com.models.Jokes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class TenJokeFragment extends Fragment {

    public TenJokeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_ten_joke, container, false);

        return view;
    }
}

class TenJokeFetcher extends Async <Void, Void, String> {
    public TenJokeFetcher() {}

    @Override
    protected String[] doInBackground(Void... voids) {
        String[] jokes = null;

        try {
            URL url = new URL("https://official-joke-api.appspot.com/random_ten");
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.setRequests
        }
    }
}

class JokeAdapter extends RecyclerView.Adapter<JokeAdapter.ViewHolder> {
    private List<Joke> tenJokes;

    public JokeAdapter(List<Joke> jokes) {
        tenJokes = jokes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_ten_joke, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Joke joke = tenJokes.get(position);
        holder.bind(joke);
    }

    @Override
    public int getItemCount() {
        return tenJokes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView jokeSetUpText;
        private TextView jokePunchLineText;

        public ViewHolder(View itemView) {
            super(itemView);
            jokeSetUpText = itemView.findViewById(R.id.joke_setup);
            jokePunchLineText = itemView.findViewById(R.id.punchline_text);
        }
        public void bind(Joke joke) {
            jokeSetUpText.setText(joke.getSetup());
            jokePunchLineText.setText(joke.getPunchline());
        }
    }

}
