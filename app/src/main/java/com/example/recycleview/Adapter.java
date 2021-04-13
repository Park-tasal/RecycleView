package com.example.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {
    private ArrayList<Item> items;
    private int position;
    public Adapter(ArrayList<Item> list){
        this.items = list;
    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //  리싸이클러 뷰에서 보여즐 레이아웃 인플레이트
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view  = inflater.inflate(R.layout.item_view, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {


        holder.name.setText(items.get(position).getName());
        holder.number.setText(items.get(position).getNumber());

    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Item peopleData){
        items.add(peopleData);
        notifyDataSetChanged();

    }
    public void delItem(int position){
        items.remove(position);
        notifyItemRemoved(position);
        notifyDataSetChanged();

    }
    public int getPosition(){
        return  position;
    }
   public class Holder extends RecyclerView.ViewHolder{ // 리사이클러 뷰에서 보여 질 아이템
        TextView name;
        TextView number;

        public Holder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.peopleName);
           number = itemView.findViewById(R.id.peopleNumber);
        }

    }
}

