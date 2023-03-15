package com.models;


import com.google.gson.annotations.SerializedName;

public class Joke {

    @SerializedName("type")
    private String type;

    @SerializedName("setup")
    private String setup;

    @SerializedName("punchline")
    private String punchline;

    @SerializedName("id")
    private String id;

    public String getType() {
        return type;
    }

    public String getSetup() {
        return setup;
    }

    public String getPunchline() {
        return punchline;
    }

    public String getId() {
        return id;
    }
}
