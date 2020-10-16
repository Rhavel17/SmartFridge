package com.example.smartfridge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


public class ShoppingListActivity extends AppCompatActivity {
    android.widget.Toolbar toolbar;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        //toolbar = findViewById(R.id.toolbar);

        //Sets toolbar to act as the ActionBar for this Activity window (ShoppingListActivity)
        //setSupportActionBar(toolbar);
        //setActionBar(toolbar);
        recyclerView = findViewById(R.id.shoppingLists);
    }

    /** Replaces the default app menu (action bar) with res/menu/add_lists_menu */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_lists_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    /** Responds to user clicking on a menu (action bar) button e.g. add shopping list */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        if(item.getItemId() == R.id.add) {
            Intent intent = new Intent(getApplicationContext(), AddListActivity.class);
            startActivity(intent);
            return true;
        }

        return false;
    }
}