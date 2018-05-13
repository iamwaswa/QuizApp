package com.example.waswaolunga.quizapp.model;


/**
 * The Question class describes
 * the list of questions to ask
 * the user
 *
 * @author Waswa Olunga
 */

public class Question {

    private String questionContent;

    public Question(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getQuestionContent() {
        return questionContent;
    }

}
