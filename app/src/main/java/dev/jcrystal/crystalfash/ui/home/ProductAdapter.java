package dev.jcrystal.crystalfash.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.List;

import dev.jcrystal.crystalfash.R;
import dev.jcrystal.crystalfash.models.Product;
import dev.jcrystal.crystalfash.ui.product.ProductActivity;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {
    private Context mContext ;
    private List<Product> mData ;


    public ProductAdapter(Context mContext, List<Product> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item_product,parent,false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.txtName.setText(mData.get(position).getName());
        holder.txtCategory.setText(mData.get(position).getCategory());

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        holder.txtPrice.setText(formatter.format(mData.get(position).getPrice()));
        holder.txtOldPrice.setText(formatter.format(mData.get(position).getOldPrice()));

        Picasso.get().load(mData.get(position).getImage()).into(holder.imgProduct);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, ProductActivity.class);

                intent.putExtra("idProduct",mData.get(position).getId());

                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtName,txtCategory, txtPrice, txtOldPrice;
        ImageView imgProduct;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            txtName = (TextView) itemView.findViewById(R.id.product_name_id) ;
            txtCategory = (TextView) itemView.findViewById(R.id.product_category_id) ;
            txtPrice = (TextView) itemView.findViewById(R.id.product_price_id) ;
            txtOldPrice = (TextView) itemView.findViewById(R.id.product_old_price_id) ;
            imgProduct = (ImageView) itemView.findViewById(R.id.product_img_id);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);


        }
    }


}
