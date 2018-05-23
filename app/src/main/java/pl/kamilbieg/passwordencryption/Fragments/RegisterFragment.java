package pl.kamilbieg.passwordencryption.Fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.kamilbieg.passwordencryption.Database.SqlFunctions;
import pl.kamilbieg.passwordencryption.Database.SqlHelper;
import pl.kamilbieg.passwordencryption.R;
import pl.kamilbieg.passwordencryption.User;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {

    @BindView(R.id.editName)
    EditText editName;

    @BindView(R.id.editPassword)
    EditText editPassword;

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btnAccept)
    public void onClick() {
        if (editName.getText().toString().isEmpty())
            Toast.makeText(getContext(), "Set name!", Toast.LENGTH_SHORT).show();
        else if (editPassword.getText().toString().length() < 8)
            Toast.makeText(getContext(), "Password is too short!", Toast.LENGTH_SHORT).show();
        else {
            User user = User.builder()
                    .name(editName.getText().toString())
                    .password(editPassword.getText().toString())
                    .build();
            SqlHelper sqlHelper = new SqlHelper(getContext());
            SqlFunctions sqlFunctions = new SqlFunctions(sqlHelper.getWritableDatabase());
            sqlFunctions.addUserToDatabase(user);
            Toast.makeText(getContext(), "Profile created!", Toast.LENGTH_SHORT).show();
        }

    }

}
