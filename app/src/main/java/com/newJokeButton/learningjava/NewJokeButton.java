package com.newJokeButton.learningjava;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.joke.learningjava.JokeFragment;

public class NewJokeButton extends androidx.appcompat.widget.AppCompatButton {

    public NewJokeButton(Context context) {
        super(context);
        init();
    }

    public NewJokeButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NewJokeButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        // Set the button properties and behavior
        setText("Click Me!");
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                new JokeFragment();
            }
        });
    }

}
