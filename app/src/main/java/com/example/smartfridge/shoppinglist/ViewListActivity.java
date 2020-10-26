package com.example.smartfridge.shoppinglist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.smartfridge.R;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class ViewListActivity extends AppCompatActivity {
    TextView listContent;
    ShopList shoppingList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list);
        listContent = findViewById(R.id.detailsOfList);

        //Get all of the information regarding the selected shopping list
        Intent i = getIntent();
        String listID = i.getStringExtra("ID");
        shoppingList = ShoppingListActivity.findListById(listID);

        //Update various parts of this activity with values from the selected shopping list
        getSupportActionBar().setTitle(shoppingList.getTitle());
        listContent.setText(shoppingList.getContent());
        listContent.setMovementMethod(new ScrollingMovementMethod());
    }

    /** Replaces the default app menu (action bar) with res/menu/add_lists_menu */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.edit_lists_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    /** Responds to user clicking on a menu (action bar) button e.g. add shopping list */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        if(item.getItemId() == R.id.deleteList) {
            //Removes Shopping List from ArrayList<ShopList>
            ShoppingListActivity.removeById(shoppingList.getID());

            //Notifies user on screen that list has been deleted
            Toast.makeText(this, "Deleted Shopping List", Toast.LENGTH_SHORT).show();

            //Brings user back to shopping list screen (ShoppingListActivity.class)
            startActivity(new Intent(this, ShoppingListActivity.class));

            return true;
        } else if(item.getItemId() == R.id.editList) {
            Intent i = new Intent(this, EditListActivity.class);
            i.putExtra("ID", shoppingList.getID());

            startActivity(i);
            Toast.makeText(this, "Edit List", Toast.LENGTH_SHORT).show();

            return true;
        }

        return false;
    }

}