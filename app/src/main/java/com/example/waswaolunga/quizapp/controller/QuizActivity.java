package com.example.waswaolunga.quizapp.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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

    private static final int INIT_QUESTION = -1;
    private static final String INIT_MESSAGE = "Click Next";

    private Response response;
    private List<Question> questions;
    private TextView questionTextView;
    private int currentQuestionIndex = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        addQuestions();

        questionTextView = (TextView) findViewById(R.id.question_text);
        questionTextView.setText(R.string.init_question);

        response = new Response(getApplicationContext());
        
        Button trueBtn = (Button) findViewById(R.id.true_btn);
        addResponseButtonFunctionality(trueBtn, R.string.correct_response, R.string.incorrect_response);

        Button falseBtn = (Button) findViewById(R.id.false_btn);
        addResponseButtonFunctionality(falseBtn, R.string.incorrect_response, R.string.correct_response);

        Button nextBtn = (Button) findViewById(R.id.next_btn);
        addNextButtonFunctionality(nextBtn);
    }

    private void addQuestions(){

        questions = new ArrayList<>();

        questions.add(new Question(R.string.fruit_question));
        questions.add(new Question(R.string.toilet_question));
        questions.add(new Question(R.string.fact_question));
        questions.add(new Question(R.string.sneeze_question));
    }

    public void addNextButtonFunctionality(Button nextBtn) {

        nextBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                updateQuestion();
            }
        });
    }

    private void updateQuestion() {
        currentQuestionIndex = (currentQuestionIndex + 1) % questions.size();
        int questionResourceID = questions.get(currentQuestionIndex).getQuestionResourceID();
        questionTextView.setText(questionResourceID);
    }

    public void addResponseButtonFunctionality(Button btn, final int correctResponseID,
                                               final int incorrectResponseID) {

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (currentQuestionIndex == INIT_QUESTION){
                    Response.outputButtonResponse(getApplicationContext(), INIT_MESSAGE);
                } else {
                    findAppropriateResponse(correctResponseID, incorrectResponseID);
                    updateQuestion();
                }
            }
        });
    }

    private void findAppropriateResponse(int correctResponseID, int incorrectResponseID) {

        switch (questions.get(currentQuestionIndex).getQuestionResourceID()) {

            case R.string.fact_question:
            case R.string.fruit_question:
                Response.outputButtonResponse(getApplicationContext(),
                        getString(correctResponseID));
                break;

            case R.string.toilet_question:
            case R.string.sneeze_question:
                Response.outputButtonResponse(getApplicationContext(),
                        getString(incorrectResponseID));
                break;

            default:
                throw new RuntimeException("Not a valid question");
        }
    }

}