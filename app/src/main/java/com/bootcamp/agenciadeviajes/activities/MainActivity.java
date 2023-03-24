package com.bootcamp.agenciadeviajes.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.bootcamp.agenciadeviajes.R;


public class MainActivity extends AppCompatActivity {
    private static final String HOLA_STATE_KEY = "HOLA_KEY";
    private static final String TEXT_VIEW_KEY = "TEXT_KEY";
    private static final String TAG = "MainActivity";
    TextView textView;
    String holaState;
    String textViewText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        textViewText = getResources().getString(R.string.textView_text);
        holaState = "0";

        if (savedInstanceState != null) {
            holaState = savedInstanceState.getString(HOLA_STATE_KEY);
            textViewText = savedInstanceState.getString(TEXT_VIEW_KEY);

        }
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        textView.setText(textViewText);

        Button myButton = (Button) findViewById(R.id.my_button);

        myButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int holaStateInt = Integer.parseInt(holaState);
                holaStateInt++;
                textViewText = textViewText.split(" - ")[0] + " - " + holaStateInt;
                holaState = String.valueOf(holaStateInt);
                textView.setText(textViewText);
            }
        });
    }


    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

        holaState = savedInstanceState.getString(HOLA_STATE_KEY);

        Log.d(TAG, "onRestoreInstanceState:: holastate: " + holaState);
        textViewText = savedInstanceState.getString(TEXT_VIEW_KEY);
        textView.setText(textViewText);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(HOLA_STATE_KEY, holaState);
        Log.d(TAG, "onSaveInstanceState:: holaState: " + holaState);
        outState.putString(TEXT_VIEW_KEY, textViewText);
        super.onSaveInstanceState(outState);
    }
}