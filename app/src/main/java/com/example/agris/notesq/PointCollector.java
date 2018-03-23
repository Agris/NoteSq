package com.example.agris.notesq;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by agris.nerets on 23.03.2018.
 */

public class PointCollector implements View.OnTouchListener{
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        float x = motionEvent.getX();
        float y = motionEvent.getY();

        String message = String.format("Coordinates: (%.2f, %.2f)", x, y);

        Log.d(MainActivity.DEBUGTAG, message);



        return false;
}}
