package pl.kamilbieg.passwordencryption.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

import pl.kamilbieg.passwordencryption.Database.SqlFunctions;
import pl.kamilbieg.passwordencryption.Listeners.DialogResultListener;
import pl.kamilbieg.passwordencryption.R;
import pl.kamilbieg.passwordencryption.Database.SqlHelper;
import pl.kamilbieg.passwordencryption.User;

public class LoginDialog extends DialogFragment {

    private DialogResultListener dialogResultListener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = Objects.requireNonNull(getActivity()).getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_login, null);
        final EditText editName = view.findViewById(R.id.editLoginName);

        return new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle(getResources().getString(R.string.login_dialog_title))
                .setPositiveButton(getResources().getString(R.string.dialog_login_accept_btn),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SqlHelper sqlHelper = new SqlHelper(getActivity());
                                SQLiteDatabase db = sqlHelper.getReadableDatabase();
                                SqlFunctions functions = new SqlFunctions(db);
                                User user = functions.searchForUser(editName.getText().toString());
                                if (user != null) {
                                    //Toast.makeText(getActivity(), user.getName(), Toast.LENGTH_SHORT).show();
                                    dialogResultListener.onDialogResult(user);
                                } else
                                    Toast.makeText(getActivity(), "Wrong name", Toast.LENGTH_SHORT).show();

                            }
                        })
                .create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        dialogResultListener = (DialogResultListener) context;
    }
}
