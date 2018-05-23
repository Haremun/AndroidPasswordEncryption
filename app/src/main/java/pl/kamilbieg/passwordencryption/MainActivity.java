package pl.kamilbieg.passwordencryption;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.kamilbieg.passwordencryption.Dialogs.LoginDialog;
import pl.kamilbieg.passwordencryption.Fragments.ProfileFragment;
import pl.kamilbieg.passwordencryption.Fragments.RegisterFragment;
import pl.kamilbieg.passwordencryption.Listeners.DialogResultListener;

public class MainActivity extends AppCompatActivity implements DialogResultListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        RegisterFragment registerFragment = new RegisterFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, registerFragment);
        transaction.commit();


    }

    @OnClick(R.id.btnLogin)
    public void onClick(){
        DialogFragment loginDialog = new LoginDialog();
        loginDialog.show(getFragmentManager(), "LoginDialog");

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onDialogResult(User user) {
        ProfileFragment profileFragment = new ProfileFragment();
        profileFragment.setUser(user);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, profileFragment);
        transaction.commit();

    }
}
