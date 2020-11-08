package com.example.smartfridge.insidefridge;


        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.view.MenuItem;
        import android.widget.EditText;

        import com.example.smartfridge.R;

        import java.util.Calendar;
        import java.util.Random;

public class AddFoodActivity extends AppCompatActivity {
    EditText listTitle2;
    EditText foodAmount2;
    Calendar c;
    String currentDate;
    int UPPER_BOUND = 10000;
    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        //Link the two UI components for food title and items to the local variables
        listTitle2 = (EditText) findViewById(R.id.listTitle2);
        foodAmount2 = (EditText) findViewById(R.id.foodAmount2);

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
            //Create Shopping List (ShopList) object
            FoodList list = new FoodList(listTitle2.getText().toString(),Integer.parseInt(foodAmount2.getText().toString()), currentDate, rand.nextInt(UPPER_BOUND));
                //list.setTitle(listTitle2.getText().toString());
            //Add object to static ArrayList<ShopList> variable in ShoppingListActivity class
            FoodListActivity.lists.add(list);

            //Returns user to previous screen (Activity)
            onBackPressed();
            return true;
        } else if(item.getItemId() == R.id.delete) {
            //Returns user to previous screen (Activity)
            onBackPressed();
            return true;
        }

        return false;
    }
}