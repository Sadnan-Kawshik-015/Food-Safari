package com.example.logintest;

/*import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PasswordChangeDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_user_password_change);
    }
}
*/
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class PasswordChangeDialog extends AppCompatDialogFragment {
    EditText user_password_et;
    private PasswordChangeDialogListener listener;
    @NonNull
    @Override

    /**Dialog box for password change check change location for details**/
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        LayoutInflater inflater=getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.layout_user_password_change, null);
        builder.setView(view).setTitle("Change User Password").setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        })
                .setPositiveButton("CONFIRM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        String password=user_password_et.getText().toString();
                        listener.applyText(password);
                    }
                });
        user_password_et = view.findViewById(R.id.et_new_user_password);
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (PasswordChangeDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()+"must implement PasswordChangeDialogListener");
        }
    }
    public interface PasswordChangeDialogListener {
        void applyText(String password);
    }
}