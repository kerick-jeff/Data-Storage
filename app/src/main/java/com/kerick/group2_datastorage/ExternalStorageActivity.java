/*
 *  University of Buea
 *  Faculty of Engineering and Technology
 *  Department of Computer Engineering
 *  Course Title: Java Mobile Programing
 *  Course Code: CEF402
 *  Course Instructor: Mme. Fani Michelle
 *
 *  Group2 group members
 *  1. Fru Kerick Jheff Buahab         FE14A083
 *  2. Tafang Joshua Ngufor Nkongho    FE14A201
 *  3. Tigpezeghe Rodrige Kwenchu      FE14A214
 *  4. James Takor Ako-Egbe JR.        FE13A097
 *
 **/

package com.kerick.group2_datastorage;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExternalStorageActivity extends AppCompatActivity {
    private static final String FILENAME = "extfile.txt"; // textfile to write/read data on external storage
    private EditText editTextData;
    private TextView textViewData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_storage);

        editTextData = (EditText) findViewById(R.id.editTextData);
        textViewData = (TextView) findViewById(R.id.textViewData);
    }

    // write data to extfile.txt on external storage device(memory card)
    public void writeToFile(View view) {
        if(isExternalStorageWritable()) {
            try {
                File extFile = new File(Environment.getExternalStorageDirectory(), FILENAME);
                FileOutputStream fileOutputStream = new FileOutputStream(extFile);
                fileOutputStream.write(editTextData.getText().toString().getBytes());
                fileOutputStream.close();
            } catch (IOException ex) {
                Toast.makeText(ExternalStorageActivity.this, ex.getMessage(), Toast.LENGTH_LONG).show();
            } finally {
                editTextData.setText("");
            }
        } else {
            Toast.makeText(this, "Cannot write to external storage", Toast.LENGTH_LONG).show();
        }
    }

    // read data from extfile.txt on external storage device(memory card)
    public void readFromFile(View view) {
        if(isExternalStorageReadable()) {
            StringBuilder stringBuilder = new StringBuilder();

            try {
                File extFile = new File(Environment.getExternalStorageDirectory(), FILENAME);
                FileInputStream fileInputStream = new FileInputStream(extFile);

                if(fileInputStream != null) {
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String newLine = null;

                    while((newLine = bufferedReader.readLine()) != null) {
                        stringBuilder.append(newLine + "\n");
                    }

                    fileInputStream.close();
                }
            } catch (IOException ex) {
                Toast.makeText(ExternalStorageActivity.this, ex.getMessage(), Toast.LENGTH_LONG).show();
            } finally {
                textViewData.setText(stringBuilder);
            }
        } else {
            Toast.makeText(this, "Cannot read from external storage", Toast.LENGTH_LONG).show();
        }
    }

    // Check if external storage is writable
    private boolean isExternalStorageWritable() {
        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            return true;
        }

        return false;
    }

    // check if external storage is readable
    private boolean isExternalStorageReadable() {
        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || Environment.MEDIA_MOUNTED_READ_ONLY.equals(Environment.getExternalStorageState())) {
            return true;
        }

        return false;
    }
}
