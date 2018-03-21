package com.example.agris.notesq;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    public static final String DEBUGTAG = "ANE";
    public static final String TEXTFILE = "notesq.txt";
    public static final String FILESAVED = "FileSaved";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addSaveButtonListener();
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        boolean fileSaved = prefs.getBoolean(FILESAVED, false);

        if(fileSaved) {
            loadSavedFile();
        }
        }


    private void loadSavedFile(){
        try {



           FileInputStream fis = openFileInput(TEXTFILE);

            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new DataInputStream(fis)));

            EditText editText = (EditText) findViewById (R.id.text);
            String line;
            while((line = reader.readLine()) !=null){
                editText.append(line);
                editText.append("\n");
            }
            fis.close();

        } catch (Exception e) {
            Log.d(DEBUGTAG, "Unable to read file");
        }

    }
    private void addSaveButtonListener(){
        Button saveBtn = (Button) findViewById(R.id.save);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                EditText editText = (EditText) findViewById (R.id.text);
                String text = editText.getText().toString();

                try {/*
                    FileOutputStream fos = openFileOutput(TEXTFILE,
                            Context.MODE_PRIVATE);
                    fos.write(text.getBytes());
                    fos.close();

                    SharedPreferences prefs = getPreferences(MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean(FILESAVED, true);
                    editor.commit();
*/
                    Toast.makeText(MainActivity.this,getString(R.string.toast_cant_save), Toast.LENGTH_LONG).show();
                } catch (Exception e){

                    Log.d(DEBUGTAG, "Unable to save file");
                }



            }
        });

    }
}
