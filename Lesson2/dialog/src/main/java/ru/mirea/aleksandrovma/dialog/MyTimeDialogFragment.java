package ru.mirea.aleksandrovma.dialog;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class MyTimeDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar c = Calendar.getInstance();
        return new TimePickerDialog(getActivity(), (view, hour, minute) -> {
            Toast.makeText(getActivity(), "Время: " + hour + ":" + minute, Toast.LENGTH_SHORT).show();
        }, c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), true);
    }
}