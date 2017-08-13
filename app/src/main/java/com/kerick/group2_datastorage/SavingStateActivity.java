package com.kerick.group2_datastorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SavingStateActivity extends AppCompatActivity {
    private static final String COUNTER = "COUNTER";
    private static int counter = 0;

    TextView textViewCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saving_state);

        if(savedInstanceState != null) {
            counter = savedInstanceState.getInt(COUNTER, 0);
        }

        textViewCounter = (TextView) findViewById(R.id.textViewCounter);
        textViewCounter.setText("counter: " + counter);
    }

    // Perform counting by incrementing the value of the counter field by 1
    public void count(View view) {
        counter++;
        textViewCounter.setText("counter: " + counter);
    }

    // Save the activity's state onPause
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNTER, counter);
    }

    // Restore the activity's state onResume
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        counter = savedInstanceState.getInt(COUNTER, 0);
    }
}
