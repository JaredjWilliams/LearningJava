package com.models;

import com.google.gson.annotations.SerializedName;

public class Jokes {
    @SerializedName("Jokes")
    private Joke[] jokes;

    public Joke[] getJokes() { return jokes; }
}
