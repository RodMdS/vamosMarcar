package br.qxd.ufc.vamosmarcar;

import android.os.Bundle;
import android.app.Activity;
import android.app.DialogFragment;
import android.widget.TextView;

import java.util.Calendar;

import android.view.View;

public class Main4Activity extends Activity  {

    private DialogFragment dialogFragmentDate, dialogFragmentTime;
    private TextView txtDate, txtTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        inicializaListeners();
        final Calendar cal = Calendar.getInstance();
        dialogFragmentDate = new DatePickerFragment(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), txtDate);

        dialogFragmentTime = new TimePickerFragment(cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE), txtTime);
    }

    public void inicializaListeners() {
        txtDate = (TextView) findViewById(R.id.txtDate);
        txtTime = (TextView) findViewById(R.id.txtTime);
    }

    public void MostrarData(View v) {
        dialogFragmentDate.show(getFragmentManager(), "datepicker");
    }

    public void MostrarHora(View v) {
        dialogFragmentTime.show(getFragmentManager(), "timepicker");
    }
}



