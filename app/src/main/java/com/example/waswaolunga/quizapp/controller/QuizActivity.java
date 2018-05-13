package com.example.waswaolunga.quizapp.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import com.example.waswaolunga.quizapp.R;
import com.example.waswaolunga.quizapp.model.Question;
import com.example.waswaolunga.quizapp.model.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * The QuizActivity class describes the activity object
 * for the Quiz App
 *
 * @author Waswa Olunga
 */

public class QuizActivity extends AppCompatActivity {

    private Response responseBtn = new Response(getApplicationContext());
    private List<Question> questions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        addQuestions();

        Button trueBtn = (Button) findViewById(R.id.true_btn);
        responseBtn.addResponseButtonFunctionality(trueBtn, getString(R.string.correct_response));

        Button falseBtn = (Button) findViewById(R.id.false_btn);
        responseBtn.addResponseButtonFunctionality(falseBtn, getString(R.string.incorrect_response));

    }

    private void addQuestions(){
        questions.add(new Question(getString(R.string.fruit_question)));
        questions.add(new Question(getString(R.string.toilet_question)));
        questions.add(new Question(getString(R.string.america_question)));
        questions.add(new Question(getString(R.string.sneeze_question)));
    }
}