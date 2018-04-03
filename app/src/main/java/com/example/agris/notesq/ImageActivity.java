package com.example.agris.notesq;

import android.content.DialogInterface;
import android.graphics.Point;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

public class ImageActivity extends AppCompatActivity implements PointCollecterListener{

    private PointCollector pointCollector = new PointCollector();
    private Database db = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        addTouchListener();
        showPrompt();

        pointCollector.setListener(this);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.activity_image, menu);
        return true;
    }



    public void pointsCollected(List<Point> points) {
        Log.d(MainActivity.DEBUGTAG, "Collected points: " + points.size());

        db.storePoints(points);

        List <Point> list = db.getPoints();

        for (Point point :list) {
            Log.d(MainActivity.DEBUGTAG, String.format("Got point: (%d, %d)", point.x, point.y));
        }

    }
}
