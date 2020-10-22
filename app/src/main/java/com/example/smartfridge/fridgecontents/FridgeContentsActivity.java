package com.example.smartfridge.fridgecontents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.smartfridge.R;

public class FridgeContentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fridge_contents);
    }

    /** Called when the user clicks on the view fridge contents button from the home screen */
    public void displayAddFoodToFridge(View view) {
        //Binds this Activity (in fridge home) to another Activity (add food page)
        Intent intent = new Intent(this, AddFoodInsideActivity.class);

        //Launches the Fridge Contents Screen
        startActivity(intent);
    }

    /** Called when the user clicks on the view fridge contents button from the home screen */
    public void seeFoodInside(View view) {
        //Binds this Activity (in fridge home) to another Activity (see existing food inside)
        Intent intent = new Intent(this, SeeInsideActivity.class);

        //Launches the Fridge Contents Screen
        startActivity(intent);
    }

}