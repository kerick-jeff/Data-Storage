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

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DataStorageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);

        // Get the reference to the ListView item in the activity_data_storage.xml layout
        ListView listViewMenu = (ListView) findViewById(R.id.listViewMenu);

        // Create an array of strings and populate it with the items from the string array declared in strings.xml
        String[] menuItems = getResources().getStringArray(R.array.menu_items);

        // Create an array adapter to create the menu with the list items being laid out as per list_item.xml and the item names from the items[] array created above
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, menuItems);
        listViewMenu.setAdapter(arrayAdapter);

        // Make the menu items actionable by declaring an OnItemClickListener for each of them.
        // An Intent object will be used to switch to another activity depending on the menu item clicked
        listViewMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View itemClicked, int position, long id) {
                switch (position) { // Select the appropriate activity to start
                    case 0:
                        startActivity(new Intent(DataStorageActivity.this, PreferencesActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(DataStorageActivity.this, InternalStorageActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(DataStorageActivity.this, ExternalStorageActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(DataStorageActivity.this, SavingStateActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(DataStorageActivity.this, AboutActivity.class));
                        break;
                }
            }
        });
    }
}
