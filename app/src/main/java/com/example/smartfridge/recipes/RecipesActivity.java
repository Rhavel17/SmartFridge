package com.example.smartfridge.recipes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.smartfridge.R;

public class RecipesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
    }

    /** Called when the user clicks on the view recipes button from the home screen */
    public void displayPBJ(View view) {
        //Binds this Activity (Home screen) to another Activity (Recipes Screen)
        Intent intent = new Intent(this, pbj_recipe.class);

        //Launches the Recipes Screen
        startActivity(intent);
    }

    /** Called when the user clicks on the view recipes button from the home screen */
    public void displayLasagna(View view) {
        //Binds this Activity (Home screen) to another Activity (Recipes Screen)
        Intent intent = new Intent(this, lasagna_recipe.class);

        //Launches the Recipes Screen
        startActivity(intent);
    }

    /** Called when the user clicks on the view recipes button from the home screen */
    public void displayCookie(View view) {
        //Binds this Activity (Home screen) to another Activity (Recipes Screen)
        Intent intent = new Intent(this, cookie_recipe.class);

        //Launches the Recipes Screen
        startActivity(intent);
    }

    /** Called when the user clicks on the view recipes button from the home screen */
    public void displayFries(View view) {
        //Binds this Activity (Home screen) to another Activity (Recipes Screen)
        Intent intent = new Intent(this, fries_recipe.class);

        //Launches the Recipes Screen
        startActivity(intent);
    }
}