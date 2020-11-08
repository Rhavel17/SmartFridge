package com.example.smartfridge.insidefridge;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.smartfridge.R;

import java.util.ArrayList;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    LayoutInflater inflater;
    ArrayList<FoodList> lists;

    public Adapter(Context context, ArrayList<FoodList> lists) {
        this.inflater = LayoutInflater.from(context);
        this.lists = lists;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.food_list_view, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        String title, date;

        //Gets the title and date from each shopping list
        title = lists.get(position).getTitle();
        date = lists.get(position).getDate();

        //Sets the UI components' values
        holder.title.setText(title);
        holder.date.setText(date);

    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleOfList);
            date = itemView.findViewById(R.id.dateOfList);

            itemView.setOnClickListener(new View.OnClickListener() {
                //This method is run when user clicks on an existing
                // shopping list (i.e. cardview element w/in RecyclerView in ShoppingListActivity.java)
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(view.getContext(), ViewFoodListActivity.class);

                    //Add ID of the shopping list that the user clicked on to the Intent
                    i.putExtra("ID", lists.get(getAdapterPosition()).getID());

                    view.getContext().startActivity(i);
                }
            });
        }
    }
}


