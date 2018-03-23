package com.example.agris.notesq;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        addTouchListener();
    }
    private void addTouchListener(){
    ImageView image = (ImageView) findViewById(R.id.touch_image);

   image.setOnTouchListener(new View.OnTouchListener() {
       @Override
       public boolean onTouch(View view, MotionEvent motionEvent) {
           return false;
       }
   });
    }
}
