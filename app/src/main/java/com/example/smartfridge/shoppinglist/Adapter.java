package com.example.smartfridge.shoppinglist;

import android.content.Context;
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
    ArrayList<ShopList> lists;

    public Adapter(Context context, ArrayList<ShopList> lists) {
        this.inflater = LayoutInflater.from(context);
        this.lists = lists;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.shop_lists_view, parent, false);

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
        }
    }
}
