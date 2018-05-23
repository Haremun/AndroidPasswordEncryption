package pl.kamilbieg.passwordencryption.Fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import pl.kamilbieg.passwordencryption.EncryptionRSA;
import pl.kamilbieg.passwordencryption.R;
import pl.kamilbieg.passwordencryption.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    @BindView(R.id.textName)
    TextView textName;
    @BindView(R.id.textPassword)
    TextView textPass;
    @BindView(R.id.textPublicKey)
    TextView textPublicKey;
    @BindView(R.id.textPrivateKey)
    TextView textPrivateKey;
    @BindView(R.id.textPassEncrypted)
    TextView textPassEncrypterd;
    @BindView(R.id.textPassDecrypted)
    TextView textPassDecrypted;

    private User mUser;
    private Unbinder unbinder;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        unbinder = ButterKnife.bind(this, view);
        EncryptionRSA encryptionRSA = new EncryptionRSA();
        textName.setText(mUser.getName());
        textPass.setText(mUser.getPassword());
        textPublicKey.setText(encryptionRSA.getPublicKey().toString());
        textPrivateKey.setText(encryptionRSA.getPrivateKey().toString());
        try {
            String cipherText = encryptionRSA.encrypt(mUser.getPassword());
            textPassEncrypterd.setText(cipherText);
            textPassDecrypted.setText(encryptionRSA.decrypt(cipherText));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }

    public void setUser(User user) {
        this.mUser = user;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
