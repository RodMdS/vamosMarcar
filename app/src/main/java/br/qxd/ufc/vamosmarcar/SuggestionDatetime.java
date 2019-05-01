package br.qxd.ufc.vamosmarcar;

import com.google.gson.Gson;

import java.util.Calendar;

public class SuggestionDatetime {
    private static int code = 0;

    private int id;
    private Calendar datetime;
    private int qttVotes = 0;

    public SuggestionDatetime(Calendar datetime) {
        this.id = ++code;
        this.datetime = datetime;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getDatetime() {
        return this.datetime;
    }

    public void setDatetime(Calendar datetime) {
        this.datetime = datetime;
    }

    public int getQttVotes() {
        return this.qttVotes;
    }

    public void vote() {
        this.qttVotes++;
    }

    public String toString() {
        return new Gson().toJson(this);
    }

}
