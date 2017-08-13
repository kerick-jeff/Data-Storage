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

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InternalStorageActivity extends AppCompatActivity {
    private static final String FILENAME = "intfile.txt"; // textfile to write/read data on internal storage
    private EditText editTextData;
    private TextView textViewData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);

        editTextData = (EditText) findViewById(R.id.editTextData);
        textViewData = (TextView) findViewById(R.id.textViewData);
    }

    // write data to intfile.txt on internal storage
    public void writeToFile(View view) {
        try {
            FileOutputStream fileOutputStream = openFileOutput(FILENAME, MODE_PRIVATE);
            fileOutputStream.write(editTextData.getText().toString().getBytes());
            fileOutputStream.close();
        } catch (IOException ex) {
            Toast.makeText(InternalStorageActivity.this, ex.getMessage(), Toast.LENGTH_LONG).show();
        } finally {
            editTextData.setText("");
        }
    }

    // Read data from intfile.txt on internal storage
    public void readFromFile(View view) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            InputStream inputStream = openFileInput(FILENAME);

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String newLine = null;

                while ((newLine = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(newLine + "\n");
                }

                inputStream.close();
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        } finally {
            textViewData.setText(stringBuilder);
        }
    }
}
