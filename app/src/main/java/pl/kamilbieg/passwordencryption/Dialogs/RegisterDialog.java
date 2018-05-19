package pl.kamilbieg.passwordencryption.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

import pl.kamilbieg.passwordencryption.R;

public class RegisterDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setTitle(getResources().getString(R.string.register_dialog_title))
                .create();
    }
}
