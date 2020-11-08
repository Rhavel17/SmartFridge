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

import com.example.smartfridge.R;

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
        recyclerView = findViewById(R.id.foodLists);

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

    //Search through ArrayList of shopping lists and return ShopList with matching ID
    protected static ShopList findListById(String id) {
        for(ShopList currList : lists) {
            if(currList.getID().equals(id)) {
                return currList;
            }
        }

        //This method should never have to return null
        //Only searching for ShopList objects with an ID that we know exists within the ArrayList
        return null;
    }

    //Removes ShopList with specified ID from ArrayList<ShopList>
    protected static boolean removeById(String id) {
        for(int i = 0; i < lists.size(); i++) {
            if(lists.get(i).hasSameId(id)) {
                lists.remove(i);

                return true;
            }
        }

        return false;
    }

    //Update specified shopping list while maintaining original ID
    protected static boolean updateList(String id, String title, String content, String date) {
        for(int i = 0; i < lists.size(); i++) {
            if(lists.get(i).hasSameId(id)) {
                lists.get(i).setTitle(title);
                lists.get(i).setContent(content);
                lists.get(i).setDate(date);

                return true;
            }
        }

        return false;
    }
}