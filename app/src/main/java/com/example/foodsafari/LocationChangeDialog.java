package com.example.logintest;

/*import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class LocationChangeDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_user_location_change);
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

public class LocationChangeDialog extends AppCompatDialogFragment {
    private  EditText user_location_et;
    private LocationChangeDialogListener listener;
    @NonNull
    @Override
    /**It is used for taking location  in the dialog box as text field and save it in the database
     * Though sir suggested us for a location type dialog **/
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_user_location_change, null);
        builder.setView(view).setTitle("Change Location").setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        })
                .setPositiveButton("CONFIRM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        String location = user_location_et.getText().toString();
                        /**Getting the value from edit text as text**/
                        listener.applyLocation(location);

                    }
                });
        user_location_et = view.findViewById(R.id.et_new_user_location);
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (LocationChangeDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()+"must implement LocationChangeDialogListener");
        }
    }
    public interface LocationChangeDialogListener {
        void applyLocation(String location);
    }
}