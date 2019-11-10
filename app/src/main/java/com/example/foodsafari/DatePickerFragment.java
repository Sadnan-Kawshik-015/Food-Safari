package com.example.logintest;

/*import androidx.fragment.app.Fragment;

public class DatePickerFragment extends Fragment {
}
*/

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.Calendar;

/**This class is for date picking activity in restaurant dashboard.
 * For more of this check out https://www.youtube.com/watch?v=33BFCdL0Di0
 * I have followed this link**/


/**Check all the java folders,drawable,layout,menu,values and build.gradle(app) also manifest for changes.
 * Hope we will finish this. Anything you needs me to change just let me know**/

public class DatePickerFragment extends AppCompatDialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        Calendar c= Calendar.getInstance();
        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH);
        int day=c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(),(DatePickerDialog.OnDateSetListener)getActivity(),year,month,day);
    }
}