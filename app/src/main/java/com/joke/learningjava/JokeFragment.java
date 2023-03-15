package com.joke.learningjava;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.learningjava.R;
import com.google.gson.Gson;
import com.models.Joke;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;



public class JokeFragment extends Fragment {

    public JokeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_joke, container, false);
        TextView setupTextView = view.findViewById(R.id.joke_text_view);
        TextView punchLineTextView = view.findViewById(R.id.punch_line_text_view);
        Button NewJokeButton = view.findViewById(R.id.new_joke_button);
        new JokeFetcher(setupTextView, punchLineTextView).execute();
        NewJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new JokeFetcher(setupTextView, punchLineTextView).execute();
            }
        });
        return view;
    }
}

class JokeFetcher extends AsyncTask <Void, Void, String> {

    private TextView setupTextView;
    private TextView punchLineTextView;

    public JokeFetcher(TextView setupTextView, TextView punchLineTextView) {
        this.setupTextView = setupTextView;
        this.punchLineTextView = punchLineTextView;
    }

    @SuppressLint("LongLogTag")
    @Override
    protected java.lang.String doInBackground(Void... voids) {
        String joke = null;
        try {
            URL url = new URL("https://official-joke-api.appspot.com/random_joke");
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                joke = response.toString();
        } catch (Exception e) {
            Log.e("com.joke.learning java.JokeFetcher", "Error fetching joke: " + e.getMessage());
        }
        return joke;
    }

    @Override
            protected void onPostExecute(String joke) {
        if (joke != null) {
            System.out.print(joke);
            Gson gson = new Gson();
            Joke interpretedJoke = gson.fromJson(joke, Joke.class);
            setupTextView.setText(interpretedJoke.getSetup());
            punchLineTextView.setText(interpretedJoke.getPunchline());
        } else {
            setupTextView.setText("Error fetching joke");
        }
    }
}


