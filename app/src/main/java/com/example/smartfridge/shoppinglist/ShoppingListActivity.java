package com.example.smartfridge.shoppinglist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.example.smartfridge.R;
import com.example.smartfridge.shoppinglist.AddListActivity;
import com.example.smartfridge.shoppinglist.ShopList;

import java.util.ArrayList;


public class ShoppingListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    public static ArrayList<ShopList> lists = new ArrayList<ShopList>();
    public Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        //Link the UI RecyclerView component with local variable
        recyclerView = findViewById(R.id.shoppingLists);

        //Create the LayoutManager for our recyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Creates the Adapter for recyclerView
        adapter = new Adapter(this, lists);

        recyclerView.setAdapter(adapter);
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
            Intent intent = new Intent(this, AddListActivity.class);
            startActivity(intent);
            return true;
        }

        return false;
    }
}