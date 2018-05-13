package com.example.waswaolunga.quizapp.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.waswaolunga.quizapp.R;

public class QuizActivity extends AppCompatActivity {

    private final String TAG = "Quiz App";
    private final int X_OFFSET = 0;
    private final int Y_OFFSET = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Button true_btn = (Button) findViewById(R.id.true_btn);

        true_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonResponse(R.string.correct_response);
            }
        });

        Button false_btn = (Button) findViewById(R.id.false_btn);

        false_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonResponse(R.string.incorrect_response);
            }
        });

    }

    private void buttonResponse(int responseID) {
        Toast toast = Toast.makeText(getApplicationContext(), responseID, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, X_OFFSET, Y_OFFSET);
        toast.show();

        Log.i(TAG, getString(responseID));
    }
}