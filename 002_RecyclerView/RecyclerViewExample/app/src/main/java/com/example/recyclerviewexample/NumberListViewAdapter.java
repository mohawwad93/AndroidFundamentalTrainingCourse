package com.example.recyclerviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class NumberListViewAdapter extends ArrayAdapter<Number> {


    public NumberListViewAdapter(@NonNull Context context, @NonNull Number[] data) {
        super(context, 0, data);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View recycleView, @NonNull ViewGroup parent) {

        // View
        if(recycleView == null){
            recycleView = LayoutInflater.from(getContext()).inflate(R.layout.item_number, parent, false);
        }

        TextView textView = recycleView.findViewById(R.id.num_textview);
        ImageView imageView = recycleView.findViewById(R.id.num_imageview);

        Number number = getItem(position);
        textView.setText(String.valueOf(number.getNumber()));


        return recycleView;
    }
}
