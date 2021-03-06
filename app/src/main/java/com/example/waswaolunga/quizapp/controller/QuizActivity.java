package com.example.waswaolunga.quizapp.controller;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.example.waswaolunga.quizapp.R;
import com.example.waswaolunga.quizapp.controller.dependency.classes.Response;
import com.example.waswaolunga.quizapp.model.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * The QuizActivity class describes the activity object
 * for the Quiz App
 *
 * @author Waswa Olunga
 */

public class QuizActivity extends AppCompatActivity {

    public static final int INIT_QUESTION = -1;
    private static String QUESTION_KEY_INDEX = "com.example.waswaolunga.quizapp.controller - Current Question Key";
    private static final String TAG = "QuizActivity";

    private List<Question> questions;
    private TextView questionTextView;
    private Response response = new Response(INIT_QUESTION);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        if (savedInstanceState != null){
            int currentQuestionIndex = savedInstanceState.getInt(QUESTION_KEY_INDEX, INIT_QUESTION);
            response.setCurrentQuestionIndex(currentQuestionIndex);
        }

        addQuestions();

        questionTextView = (TextView) findViewById(R.id.question_text);

        int currentQuestionIndex = response.getCurrentQuestionIndex();
        if (currentQuestionIndex != INIT_QUESTION) {
            questionTextView.setText(questions.get(currentQuestionIndex).getQuestionResourceID());
        } else {
            questionTextView.setText(R.string.init_question);
        }

        Button trueBtn = (Button) findViewById(R.id.true_btn);
        Button falseBtn = (Button) findViewById(R.id.false_btn);
        ImageButton nextBtn = (ImageButton) findViewById(R.id.next_btn);
        ImageButton previousBtn = (ImageButton) findViewById(R.id.previous_btn);

        addResponseButtonFunctionality(trueBtn, falseBtn, previousBtn, nextBtn);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        String currentQuestion = questionTextView.getText().toString();
        String question;

        if (!currentQuestion.equals(getString(R.string.init_question))){

            int questionNumber = -1;
            do {

                questionNumber++;
                question = getString(questions.get(questionNumber).getQuestionResourceID());

            } while (!question.equals(currentQuestion));

            int currentQuestionIndex = questionNumber;

            savedInstanceState.putInt(QUESTION_KEY_INDEX, currentQuestionIndex);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void addQuestions(){

        questions = new ArrayList<>();

        questions.add(new Question(R.string.fruit_question));
        questions.add(new Question(R.string.toilet_question));
        questions.add(new Question(R.string.fact_question));
        questions.add(new Question(R.string.sneeze_question));
    }

    public void addResponseButtonFunctionality(Button trueBtn, Button falseBtn,
                                               ImageButton previousBtn, ImageButton nextBtn) {

        final Context context = QuizActivity.this;

        trueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                response.respondToAnswer(context, questions, questionTextView,
                                         getString(R.string.correct_response),
                                         getString(R.string.incorrect_response));
            }
        });

        falseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                response.respondToAnswer(context, questions, questionTextView,
                                         getString(R.string.incorrect_response),
                                         getString(R.string.correct_response));
            }
        });

        previousBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                response.reverseToPreviousQuestion(questions, questionTextView);
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                response.advanceToNextQuestion(questions, questionTextView);
            }
        });
    }

}