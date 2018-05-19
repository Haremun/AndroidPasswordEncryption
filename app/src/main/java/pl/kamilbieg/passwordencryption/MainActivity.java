package pl.kamilbieg.passwordencryption;

import android.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.kamilbieg.passwordencryption.Dialogs.LoginDialog;
import pl.kamilbieg.passwordencryption.Dialogs.RegisterDialog;

public class MainActivity extends AppCompatActivity {


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
}
