package dev.jcrystal.crystalfash.ui.contact;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import dev.jcrystal.crystalfash.R;
import dev.jcrystal.crystalfash.models.Product;
import dev.jcrystal.crystalfash.ui.home.ProductAdapter;
import jcrystal.mobile.entities.ProductNormal;
import jcrystal.mobile.net.controllers.ManagerContact;
import jcrystal.mobile.net.controllers.ManagerProduct;
import jcrystal.mobile.net.utils.OnErrorListener;
import jcrystal.mobile.net.utils.RequestError;

public class ContactFragment extends Fragment implements OnErrorListener {

    Button btnContact;
    EditText editName, editEmail, editMessage;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_contact, container, false);
        btnContact = root.findViewById(R.id.btn_contact_id);
        editName = root.findViewById(R.id.txt_name_id);
        editEmail = root.findViewById(R.id.txt_email_id);
        editMessage = root.findViewById(R.id.txt_message_id);



        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ManagerContact.contact(getActivity(), editName.getText().toString(),editEmail.getText().toString(),editMessage.getText().toString(),() -> {
                    Toast.makeText(getContext(), "Message send to server", Toast.LENGTH_LONG).show();
                }, error -> {
                    Toast.makeText(getContext(), "Error Message send to server", Toast.LENGTH_LONG).show();

                });
                //TODO send message
            }
        });
        return root;
    }

    @Override
    public void onError(RequestError error) {

    }

}