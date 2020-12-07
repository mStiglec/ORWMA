package com.example.vjezbalv2;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.TextView;

public class NameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private TextView tvName;
    private NameClickListener clickListener;

    public NameViewHolder(@NonNull View itemView, NameClickListener clickListener){
        super(itemView);
        this.clickListener=clickListener;
        tvName=itemView.findViewById(R.id.tvName);
        itemView.setOnClickListener(this);
    }

    public void setName(String name){
        tvName.setText(name);
    }

    @Override
    public void onClick(View v) {
        clickListener.OnNameClick(getAdapterPosition());
    }
}
