package com.example.recycleview;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Item> items = new ArrayList<>();
    private Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    EditText writeName, writeNum;
    Button addNum, delNum;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);
        addNum = findViewById(R.id.addNum);
        writeName = findViewById(R.id.wName);
        writeNum = findViewById(R.id.wNumber);
        delNum = findViewById(R.id.delNum);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        items = new ArrayList<Item>();


        addNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = writeName.getText().toString();
                String number = writeNum.getText().toString();


                if (!name.isEmpty() && !number.isEmpty()) {
                    adapter = new Adapter(items);
                    adapter.addItem(new Item(name,number));
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                } else {
                    Toast.makeText(getApplicationContext(), "비어잇습니다", Toast.LENGTH_SHORT).show();

                }
            }
        });

        delNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.delItem(adapter.getPosition());
                for (Item data : items) {
                    Log.d("TestData", "" + data);

                }

            }
        });

    }
}