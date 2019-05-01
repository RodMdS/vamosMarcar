package br.qxd.ufc.vamosmarcar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private int ano, mes, dia;
    private TextView txtDate;

    public DatePickerFragment(int ano, int mes, int dia, TextView txtDate) {
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
        this.txtDate = txtDate;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar calendario = Calendar.getInstance();
        ano = calendario.get(Calendar.YEAR);
        mes = calendario.get(Calendar.MONTH);
        dia = calendario.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, ano, mes, dia);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        ano = year;
        mes = month;
        dia = day;
        atualizarData();
    }

    private void atualizarData() {
        txtDate.setText(new StringBuilder().append(dia).append("/").append(mes + 1).append("/").append(ano).append(" "));
    }

    @Override
    public int show(FragmentTransaction transaction, String tag) {
        return super.show(transaction, tag);
    }
}