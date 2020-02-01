package dev.jcrystal.crystalfash.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dev.jcrystal.crystalfash.R;
import dev.jcrystal.crystalfash.models.Product;
import jcrystal.mobile.entities.ProductNormal;
import jcrystal.mobile.net.controllers.ManagerProduct;
import jcrystal.mobile.net.utils.OnErrorListener;
import jcrystal.mobile.net.utils.RequestError;

public class HomeFragment extends Fragment implements OnErrorListener{

    private List<Product> lstProducts;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //TODO list of products from ws
        lstProducts = new ArrayList<>();
      //  for(int i=0;i<30;i++){
        //    lstProducts.add(new Product("Sweater 1", "MEN", "soft sweater", "https://imgur.com/OqgIsqf.jpg", 13, 28));
        //}






        View root = inflater.inflate(R.layout.fragment_home, container, false);

        ManagerProduct.getProducts(this, resp -> {
            for(ProductNormal p : resp){
                lstProducts.add(new Product(p.name(),p.category().getName(),p.description(),p.image(),p.price(),p.oldPrice(),p.id()));
            }

            RecyclerView myrv = (RecyclerView) root.findViewById(R.id.recyclerview_id);
            ProductAdapter myAdapter = new ProductAdapter(getContext(),lstProducts);
            myrv.setLayoutManager(new GridLayoutManager(getContext(),2));
            myrv.setAdapter(myAdapter);
        });

    //    Toast.makeText(getActivity(),lstProducts.size(), Toast.LENGTH_SHORT).show();








        // TODO get list of categories
        List<String> categories = new ArrayList<>();

        ManagerProduct.getCategories(this, resp -> {
            RecyclerView rv_category = (RecyclerView) root.findViewById(R.id.recyclerview_category_id);
            CategoryAdapter categoryAdapter = new CategoryAdapter(getContext(),resp);
            rv_category.setLayoutManager(new GridLayoutManager(getContext(),3));
            rv_category.setAdapter(categoryAdapter);
        });


        return root;
    }

    @Override
    public void onError(RequestError error) {

    }
}