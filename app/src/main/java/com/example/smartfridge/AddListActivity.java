package com.example.smartfridge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class AddListActivity extends AppCompatActivity {
    EditText listTitle, listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_list);

        listTitle = (EditText) findViewById(R.id.listTitle);
        listItems = (EditText) findViewById(R.id.listItems);
    }
}