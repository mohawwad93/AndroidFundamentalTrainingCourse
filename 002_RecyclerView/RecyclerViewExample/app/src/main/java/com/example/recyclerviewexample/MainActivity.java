package com.example.recyclerviewexample;

import androidx.annotation.Dimension;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final static int ELEMENT_SIZE = 6;
    // 25 MB
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //listUsingLinearLayout();
        // listUsingListView();


        Number[] data = new Number[ELEMENT_SIZE];
        data[0] = new Number(1, R.drawable.one);
        data[1] = new Number(2, R.drawable.two);
        data[2] = new Number(3, R.drawable.three);
        data[3] = new Number(4, R.drawable.four);
        data[4] = new Number(5, R.drawable.five);
        data[5] = new Number(6, R.drawable.six);


        NumberAdapter numberAdapter = new NumberAdapter(this, data);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(numberAdapter);


    }

    private void listUsingListView(){

        Number[] data = new Number[ELEMENT_SIZE];
        for(int i = 0; i<ELEMENT_SIZE; i++){
            data[i] = new Number(i);
        }
        ListView listView = findViewById(R.id.listview);
        NumberListViewAdapter adapter = new NumberListViewAdapter(this, data);
        listView.setAdapter(adapter);
    }
    private void listUsingLinearLayout(){
        // 81 - 25 = 56MB
        LinearLayout linearLayout = findViewById(R.id.linearlayout);
        for(int i = 0; i< ELEMENT_SIZE; i++){
            TextView view = new TextView(this);
            view.setText(String.valueOf(i));
            view.setTextSize(Dimension.SP, 30);
            linearLayout.addView(view);
        }
    }
}
