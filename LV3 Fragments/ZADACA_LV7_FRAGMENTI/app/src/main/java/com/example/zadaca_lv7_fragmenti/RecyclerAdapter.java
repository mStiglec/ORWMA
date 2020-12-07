package com.example.zadaca_lv7_fragmenti;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private static final String TAG="CustomAdapter";
    private List<String> dataList;
    private onClickListener ClickListener;

    public RecyclerAdapter(List<String> dataList,onClickListener clickListener) {
        //Log.d(TAG,"CustomAdapter()");
        this.dataList = dataList;
        this.ClickListener=clickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_list_item,parent,false);

        //Log.d(TAG,"onCreateViewHolder()");
        return new MyViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.text.setText(dataList.get(position));

        //primjer kada se odma pri povezivanju podataka sa ViewHolderom postavlja
        //i click listener na ViewHolder

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onClick()" + position);
                ClickListener.onButtonDelete(position);
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
            notifyDataSetChanged();
            //notifyItemRemoved(position);  --->ne radi dobro
        }
    }

    public void addCell(int position,String StudentName){
        if(dataList.size()>=position){
            this.dataList.add(position,StudentName);
            notifyDataSetChanged();
            //notifyItemInserted(position);  -->ne radi dobro
        }
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView text;
        private final Button button;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.textView);
            button=itemView.findViewById(R.id.deleteBtn);

        }

    }

}