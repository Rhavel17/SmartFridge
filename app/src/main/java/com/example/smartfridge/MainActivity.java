package com.example.smartfridge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user clicks on the shopping list button from home screen */
    public void displayShoppingList(View view) {
        //Binds this Activity (Home screen) to another Activity (Shopping List screen)
        Intent intent = new Intent(this, ShoppingListActivity.class);

        //Launches the Shopping List Screen
        startActivity(intent);
    }

    /** Called when the user clicks on the view fridge contents button from the home screen */
    public void displayFridgeContents(View view) {
        //Binds this Activity (Home screen) to another Activity (Fridge Contents Screen)
        Intent intent = new Intent(this, FridgeContentsActivity.class);

        //Launches the Fridge Contents Screen
        startActivity(intent);
    }

    /** Called when the user clicks on the view recipes button from the home screen */
    public void displayRecipes(View view) {
        //Binds this Activity (Home screen) to another Activity (Recipes Screen)
        Intent intent = new Intent(this, RecipesActivity.class);

        //Launches the Recipes Screen
        startActivity(intent);
    }

    /** Called when the user clicks on the messages button from the home screen */
    public void displayMessages(View view) {
        //Binds this Activity (Home screen) to another Activity (Messages Screen)
        Intent intent = new Intent(this, MessagesActivity.class);

        //Launches the Messages Screen
        startActivity(intent);
    }

    /** Called when the user clicks on the control center button from the home screen */
    public void displayControlCenter(View view) {
        //Binds this Activity (Home screen) to another Activity (Control Center Screen)
        Intent intent = new Intent(this, ControlCenterActivity.class);

        //Launches the Control Center Screen
        startActivity(intent);
    }

    /** Called when the user clicks on the photo album button from the home screen */
    public void displayPhotos(View view) {
        //Binds this Activity (Home screen) to another Activity (Photo Album Screen)
        Intent intent = new Intent(this, PhotosActivity.class);

        //Launches the Photo Album Screen
        startActivity(intent);
    }
}