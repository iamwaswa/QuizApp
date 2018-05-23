package com.example.waswaolunga.quizapp.controller;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

/**
 * The Response class describes
 * the functionality related to the true and false
 * response buttons in the UI
 *
 * @author Waswa Olunga
 */

public class Response {

    private static final String TAG = "Quiz App";
    private static final int X_OFFSET = 0;
    private static final int Y_OFFSET = 500;

    public static void outputButtonResponse(Context appContext, String response) {
        Toast toast = Toast.makeText(appContext, response, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, X_OFFSET, Y_OFFSET);
        toast.show();

        Log.i(TAG, response);
    }

}