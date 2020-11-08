package com.example.smartfridge.insidefridge;


        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;
        import com.example.smartfridge.R;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.view.MenuItem;
        import android.widget.EditText;
        import android.widget.Toast;

        import java.util.Calendar;
        import java.util.Random;

public class EditFoodActivity extends AppCompatActivity {
    EditText listTitle, amount;
    Calendar c;
    String currentDate;
    int UPPER_BOUND = 10000;
    Random rand = new Random();
    FoodList foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_foods);

        Intent i = getIntent();
        String listID = i.getStringExtra("ID");

        foodList = FoodListActivity.findListById(listID);

        getSupportActionBar().setTitle(foodList.getTitle());

        //Link the two UI components for Shopping List title and items to the local variables
        listTitle = (EditText) findViewById(R.id.listTitle3);
        amount = (EditText) findViewById(R.id.listItems3);

        //Set values for listTitle and listItems based on selected shopping list
        listTitle.setText(foodList.getTitle());
        amount.setText(foodList.getAmount().toString());


        //Get the current date
        c = Calendar.getInstance();
        currentDate = (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.DAY_OF_MONTH) + "/" + c.get(Calendar.YEAR);


    }

    /** Replaces the default app menu (action bar) with res/menu/add_lists_menu */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.save_lists_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    /** Responds to user clicking on a menu (action bar) button e.g. add shopping list */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        if(item.getItemId() == R.id.save) {
            //Extract the current values for listTitle and listContent
            String newTitle = listTitle.getText().toString();
            int newContent = Integer.parseInt( amount.getText().toString() ); //NumberFormatException if user inputs a non-integer string

            //Update the title, content
           FoodListActivity.updateList(foodList.getID(), newTitle, newContent, currentDate);

            //Go back to ShoppingListActivity
            startActivity(new Intent(this, FoodListActivity.class));

            return true;
        } else if(item.getItemId() == R.id.delete) {
            //Returns user to previous screen (Activity)
            onBackPressed();
            return true;
        }

        return false;
    }
}