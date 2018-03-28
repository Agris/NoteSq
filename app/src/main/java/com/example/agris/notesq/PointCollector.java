package com.example.agris.notesq;

import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by agris.nerets on 23.03.2018.
 */

public class PointCollector implements View.OnTouchListener{

    private  PointCollecterListener listener;
    private List <Point> points = new ArrayList<Point>();




    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        int x = Math.round(motionEvent.getX());
        int y = Math.round(motionEvent.getY());

        String message = String.format("Coordinates: (%d, %d)", x, y);

        Log.d(MainActivity.DEBUGTAG, message);

        points.add(new Point(x, y));

        if(points.size() == 4) {

            if (listener != null) {
                listener.pointsCollected(points);
                points.clear();
            }

        }



        return false;
}

    public void setListener(PointCollecterListener listener) {
        this.listener = listener;
    }


}
