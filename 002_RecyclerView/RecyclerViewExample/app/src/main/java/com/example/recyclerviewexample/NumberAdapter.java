package com.example.recyclerviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NumberAdapter extends RecyclerView.Adapter<NumberAdapter.NumberVH> {

    private Context mContext;
    private Number[] mData;

    public NumberAdapter(Context context, Number[] data){
        mContext = context;
        mData = data;
    }

    @NonNull
    @Override
    public NumberVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(mContext).inflate(R.layout.item_number, parent, false);
       return new NumberVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NumberVH holder, int position) {

        Number number = mData[position];
        holder.textView.setText(String.valueOf(number.getNumber()));
        holder.imageView.setImageResource(number.getImageId());
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    class NumberVH extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;
        public NumberVH(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.num_textview);
            imageView = itemView.findViewById(R.id.num_imageview);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();
                    Number number = mData[position];

                    Toast.makeText(mContext, String.valueOf(number.getNumber()), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
