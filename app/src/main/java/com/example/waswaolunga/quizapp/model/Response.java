package com.example.waswaolunga.quizapp.model;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * The Response class describes
 * the functionality related to the true and false
 * response buttons in the UI
 *
 * @author Waswa Olunga
 */

public class Response {

    private final String TAG = "Quiz App";
    private final int X_OFFSET = 0;
    private final int Y_OFFSET = 500;

    private Context appContext;


    public Response(Context appContext) {
        this.appContext = appContext;
    }


    public void addResponseButtonFunctionality(Button btn, final String RESPONSE) {

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                outputButtonResponse(RESPONSE);
            }
        });
    }

    private void outputButtonResponse(String response) {
        Toast toast = Toast.makeText(appContext, response, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, X_OFFSET, Y_OFFSET);
        toast.show();

        Log.i(TAG, response);
    }

}