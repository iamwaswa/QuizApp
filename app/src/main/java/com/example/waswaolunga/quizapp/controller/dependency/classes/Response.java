package com.example.waswaolunga.quizapp.controller.dependency.classes;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.waswaolunga.quizapp.R;
import com.example.waswaolunga.quizapp.controller.QuizActivity;
import com.example.waswaolunga.quizapp.model.Question;

import java.util.List;

/**
 * The Response class describes
 * the functionality related to click events
 * of the buttons in the UI
 *
 * @author Waswa Olunga
 */

public class Response {

    private static final String INIT_MESSAGE = "Click the arrows";
    private static final String TAG = "Quiz App";
    private static final int X_OFFSET = 0;
    private static final int Y_OFFSET = 500;

    private int currentQuestionIndex;

    public Response(int currentQuestionIndex) {
        this.currentQuestionIndex = currentQuestionIndex;
    }

    public void respondToAnswer(Context context, List<Question> questions, TextView questionTextView,
                                String correctResponse, String incorrectResponse) {

        if (currentQuestionIndex == QuizActivity.INIT_QUESTION){
            Response.outputButtonResponse(context, INIT_MESSAGE);
        } else {
            findAppropriateResponse(context, questions, correctResponse, incorrectResponse);
            advanceToNextQuestion(questions, questionTextView);
        }
    }

    public static void outputButtonResponse(Context appContext, String response) {
        Toast toast = Toast.makeText(appContext, response, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, X_OFFSET, Y_OFFSET);
        toast.show();

        Log.i(TAG, response);
    }

    private void findAppropriateResponse(Context context, List<Question> questions,
                                         String correctResponse, String incorrectResponse) {

        switch (questions.get(currentQuestionIndex).getQuestionResourceID()) {

            case R.string.fact_question:
            case R.string.fruit_question:
                Response.outputButtonResponse(context, correctResponse);
                break;

            case R.string.toilet_question:
            case R.string.sneeze_question:
                Response.outputButtonResponse(context, incorrectResponse);
                break;

            default:
                throw new RuntimeException("Not a valid question");
        }
    }

    public void advanceToNextQuestion(List<Question> questions, TextView questionTextView) {
        currentQuestionIndex = (currentQuestionIndex + 1) % questions.size();
        updateQuestion(questions, questionTextView);
    }

    private void updateQuestion(List<Question> questions, TextView questionTextView) {
        int questionResourceID = questions.get(currentQuestionIndex).getQuestionResourceID();
        questionTextView.setText(questionResourceID);
    }

    public void reverseToPreviousQuestion(List<Question> questions, TextView questionTextView) {
        currentQuestionIndex = (currentQuestionIndex - 1 < 0) ? questions.size() - 1 : currentQuestionIndex - 1;
        updateQuestion(questions, questionTextView);
    }

}