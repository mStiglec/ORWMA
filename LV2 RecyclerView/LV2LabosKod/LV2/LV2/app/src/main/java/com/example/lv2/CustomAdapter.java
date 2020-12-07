package com.example.lv2;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private static final String TAG="CustomAdapter";
    private List<String> dataList;
    private NameClickListener nameClickListener;

    public CustomAdapter(List<String> dataList,NameClickListener nameListener) {
        //Log.d(TAG,"CustomAdapter()");
        this.dataList = dataList;
        this.nameClickListener=nameListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);

            //Log.d(TAG,"onCreateViewHolder()");
        return new MyViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
            holder.textView.setText(dataList.get(position));

            holder.layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Log.d(TAG,"onClick()" + dataList.get(position));
                    nameClickListener.onNameClick(position);
                }
            });

            //Log.d(TAG,"onBindViewHolder()");
    }

    @Override
    public int getItemCount() {
        //Log.d(TAG,"getItemCount()");
        return dataList.size();

    }

    public void removeCell(int position){
        if(dataList.size()>position){
            this.dataList.remove(position);
            notifyItemRemoved(position);
        }
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView;
        private final FrameLayout layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);

            layout=itemView.findViewById(R.id.frame_layout);


        }


    }

}
