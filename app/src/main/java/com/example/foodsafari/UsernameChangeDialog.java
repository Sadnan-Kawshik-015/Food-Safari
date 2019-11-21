package com.example.logintest;

/*import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class UsernameChangeDialog extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_user_name_change);
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

public class UsernameChangeDialog extends AppCompatDialogFragment {
    private EditText user_name_et;
    private UsernameChangeDialogListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_user_name_change, null);
        builder.setView(view).setTitle("Change User Name").setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        })
                .setPositiveButton("CONFIRM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        String username = user_name_et.getText().toString();
                        listener.applyTexts(username);

                    }
                });
        user_name_et = view.findViewById(R.id.et_new_user_name);
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (UsernameChangeDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()+"must implement UserNameChangeDialogListener");
        }
    }

    public interface UsernameChangeDialogListener {
        void applyTexts(String username);
    }
}