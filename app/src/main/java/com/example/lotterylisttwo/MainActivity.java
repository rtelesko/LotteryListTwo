package com.example.lotterylisttwo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // GUI controls
    private ListView lvTips;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get reference to the ListView
        lvTips = findViewById(R.id.lvTips);

        // Initializing a new String Array
        String[] tips = new String[]{"Tip 1", "Tip 2", "Tip 3", "Tip 4", "Tip 5", "Tip 6", "Tip 7", "Tip 8", "Tip 9", "Tip 10",
        };

        /*
        What are possible Adapters ind Android?
        BaseAdapter is a very generic adapter that allows you to do pretty much whatever you want.
        However, you have to do a bit more coding yourself to get it working.
        ArrayAdapter is a more complete implementation that works well for data in arrays or ArrayLists.
        Similarly, there is a related CursorAdapter that you should use if your data is in a Cursor (e.g. in a database).
        Both of these extend BaseAdapter.
        */

        // Create an ArrayAdapter from the List
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, tips);

        // Populate the ListView with items from ArrayAdapter
        lvTips.setAdapter(arrayAdapter);

        // Set an item click Listener for ListView
        lvTips.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item text from the ListView
                String selectedItem = (String) parent.getItemAtPosition(position);

                // Display the selected item text with a Toast message
                Toast.makeText(getApplicationContext(), selectedItem + " selected", Toast.LENGTH_LONG).show();
            }
        });
    }
}
