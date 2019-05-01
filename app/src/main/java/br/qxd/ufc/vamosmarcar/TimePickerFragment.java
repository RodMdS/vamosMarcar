package br.qxd.ufc.vamosmarcar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;


import java.util.Calendar;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    private int hora, minuto;
    private TextView txtTime;


    public TimePickerFragment (int hora, int minuto, TextView txtTime) {
        this.hora = hora;
        this.minuto = minuto;
        this.txtTime = txtTime;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        final Calendar calendario = Calendar.getInstance();
        hora = calendario.get(Calendar.HOUR_OF_DAY);
        minuto = calendario.get(Calendar.MINUTE);
        return new TimePickerDialog(
                getActivity(),
                this,
                hora,
                minuto,
                DateFormat.is24HourFormat(getActivity())
        );
    }


    private void AtualizarHora() {
        txtTime.setText(new StringBuilder().append(hora).append(":").append(minuto));
    }


    @Override
    public int show(FragmentTransaction transaction, String tag) {
        return super.show(transaction, tag);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        hora = hourOfDay;
        minuto = minute;
        AtualizarHora();
    }
}