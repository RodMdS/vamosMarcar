package br.qxd.ufc.vamosmarcar;

import com.google.gson.Gson;

import java.util.Calendar;

public class Datetime {
    private static int code = 0;

    private int id;
    private Calendar datetime;

    public Datetime(Calendar datetime) {
        this.datetime = datetime;
    }

    public Calendar getDatetime() {
        return datetime;
    }

    public void setDatetime(Calendar datetime) {
        this.datetime = datetime;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
