package com.example.waswaolunga.quizapp.model;

/**
 * The Question class describes
 * the list of questions to ask
 * the user
 *
 * @author Waswa Olunga
 */

public class Question {

    private int questionResourceID;

    public Question(int questionResourceID) {
        this.questionResourceID = questionResourceID;
    }

    public int getQuestionResourceID() {
        return questionResourceID;
    }

}