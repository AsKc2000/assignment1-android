package com.example.assignment1.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.assignment1.Models.ListItem;
import com.example.assignment1.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.Viewholder> {
    private Context context;
    private List<ListItem> itemList;

    public RecyclerViewAdapter(Context context, List<ListItem> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.list_item, viewGroup, false);
        Viewholder holder = new Viewholder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.Viewholder viewHolder, int i) {
        ListItem listItem = itemList.get(i);

        viewHolder.name.setText(listItem.getName());
        viewHolder.desc.setText(listItem.getDesc());
        viewHolder.imageView.setImageResource(listItem.getImage_res_id());


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class DatabaseHandler {
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView name, desc;
        ImageView imageView;
        LinearLayout linearLayout;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.name);
            this.desc = itemView.findViewById(R.id.desc);
            this.imageView = itemView.findViewById(R.id.imageView);
            this.linearLayout = itemView.findViewById(R.id.linearview);
        }
    }
}
