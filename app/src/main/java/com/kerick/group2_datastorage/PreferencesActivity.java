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

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class PreferencesActivity extends AppCompatActivity {
    private static final String NAME = "NAME";
    private SharedPreferences preferences;

    private TextView textViewName;
    private EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        preferences = getPreferences(MODE_PRIVATE);

        // Reference views in layout
        textViewName = (TextView) findViewById(R.id.textViewName);
        editTextName = (EditText) findViewById(R.id.editTextName);

        // Holds value of an already set preference or null if it has not yet been set
        String name = preferences.getString(NAME, null);

        if(name == null) {
            textViewName.setText("Hello");
        } else {
            textViewName.setText("Hello, " + name + ".\nThank you for trying out this demo!");
        }
    }

    /**
     *  Store name value as a shared preference
     *  Edit the preferences using an Editor object
    */
    public void saveName(View view) {
        SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
        editor.putString(NAME, editTextName.getText().toString());
        editor.commit(); // effect the newly made changes with Editor
        textViewName.setText("Hello, " + preferences.getString(NAME, null) + ".\nThank you for trying out this demo!");
        editTextName.setText("");
    }

    // clear preferences
    public void resetName(View view) {
        SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
        editor.clear(); // clear contents of Editor
        editor.apply(); // commit the newly made changes after clearing the contents of the Editor
        textViewName.setText("Hello");
    }
}
