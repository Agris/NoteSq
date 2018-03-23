package com.example.agris.notesq;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {

    private PointCollector pointCollector = new PointCollector();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        addTouchListener();
        showPrompt();
    }

    private void showPrompt(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.setTitle("Create Your Passpoint Sequence");
        builder.setMessage("Touch four points on image to set the passpoint sequence. You must click the same points in future to gain access to your notes.");

        AlertDialog dlg = builder.create();

        dlg.show();

    }

    private void addTouchListener(){
    ImageView image = (ImageView) findViewById(R.id.touch_image);

   image.setOnTouchListener(pointCollector);
    }
}
