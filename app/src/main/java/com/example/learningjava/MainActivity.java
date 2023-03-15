package com.example.learningjava;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.joke.learningjava.JokeFragment;
import com.joke.learningjava.TenJokeFragment;

import java.util.Objects;

public class MainActivity extends AppCompatActivity  {

    String[] courses = { "get 1 joke", "get 10 jokes" };


    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar jokeToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(jokeToolbar);
        Objects.requireNonNull(getSupportActionBar()).setDefaultDisplayHomeAsUpEnabled(true);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, courses);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(adapter);

        JokeFragment jokeFragment = new JokeFragment();
        TenJokeFragment tenJokeFragment = new TenJokeFragment();
        FragmentManager fragmentManger = getSupportFragmentManager();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String selectedNumberOfJokes = parent.getItemAtPosition(position).toString();
                FragmentTransaction fragmentTransaction = fragmentManger.beginTransaction();

                if (selectedNumberOfJokes.equals("get 1 joke")) {

                    Fragment previousFragment = fragmentManger.findFragmentById(R.id.ten_joke_container);

                    if (previousFragment != null) {
                        fragmentTransaction.remove(previousFragment).commit();
                    }
                    Log.println(Log.ERROR, "test", "1 working");
                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.joke_container, jokeFragment)
                            .commit();

                } else if (selectedNumberOfJokes.equals("get 10 jokes")) {

                    Fragment previousFragment = fragmentManger.findFragmentById(R.id.joke_container);

                    if (previousFragment != null) {
                        fragmentTransaction.remove(previousFragment).commit();
                    }

                    Log.println(Log.ERROR, "test", "10 working");
                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.ten_joke_container, tenJokeFragment)
                            .commit();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle no selection
            }
        });
    }

}

