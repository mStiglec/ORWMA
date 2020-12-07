package com.example.lv4_zadaca_api;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private List<Product> productData;

    public CustomAdapter(List<Product> productData){
        this.productData=productData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.tvProductName.setText(productData.get(position).getName());
            holder.tvProductPrice.setText(String.valueOf(productData.get(position).getPrice()));
            holder.tvProductRating.setText(String.valueOf(productData.get(position).getRating()));

            String description = productData.get(position).getDescription();
            description = description.replaceAll("\n","");
            description = description.replaceAll("\t","");

            holder.tvProductDescription.setText(description);
            Picasso.get().load(productData.get(position).getImageLink()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return productData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvProductName,tvProductPrice,tvProductRating,tvProductDescription;
        private ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvProductName = (TextView) itemView.findViewById(R.id.tvproductName);
            tvProductPrice = (TextView) itemView.findViewById(R.id.tvproductPrice);
            tvProductRating = (TextView) itemView.findViewById(R.id.tvproductRating);
            tvProductDescription = (TextView) itemView.findViewById(R.id.tvproductDescription);
            image = (ImageView) itemView.findViewById(R.id.image);


        }
    }
}
