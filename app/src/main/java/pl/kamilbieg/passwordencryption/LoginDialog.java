package pl.kamilbieg.passwordencryption;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class LoginDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setView(R.layout.dialog_login)
                .setTitle(getResources().getString(R.string.login_dialog_title))
                .setPositiveButton(getResources().getString(R.string.dialog_login_accept_btn),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SqlHelper sqlHelper = new SqlHelper(getActivity());
                                SQLiteDatabase db = sqlHelper.getReadableDatabase();
                            }
                        })
                .create();
    }
}
