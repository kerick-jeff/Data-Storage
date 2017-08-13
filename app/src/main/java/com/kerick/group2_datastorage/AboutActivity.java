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
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Get the reference to the ListView item in the activity_about.xml layout
        ListView listViewNames = (ListView) findViewById(R.id.listViewNames);

        // Create an array of strings and populate it with the items from the string array declared in strings.xml
        String[] names = getResources().getStringArray(R.array.names);

        // Create an array adapter to create the menu with the list items being laid out as per list_item.xml and the item names from the items[] array created above
        ArrayAdapter<String> arrayAdapterNames = new ArrayAdapter<String>(this, R.layout.list_item, names);
        listViewNames.setAdapter(arrayAdapterNames);
    }
}
