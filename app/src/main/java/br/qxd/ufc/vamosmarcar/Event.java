package br.qxd.ufc.vamosmarcar;

import com.google.gson.Gson;

import java.util.List;

public class Event {
    private static int code = 0;

    private int id;
    private String name;
    private Local local;
    private Datetime datetime;
    private List<SuggestionDatetime> suggestions;
    private int stageEvent;

    public Event(String name, Local local) {
        this.id = ++code;
        this.name = name;
        this.local = local;
        this.stageEvent = StageEvent.PROCESSING;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Local getLocal() {
        return this.local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Datetime getDatetime() {
        return this.datetime;
    }

    public void setDatetime(Datetime datetime) {
        this.datetime = datetime;
    }

    public List<SuggestionDatetime> getSuggestions() {
        return this.suggestions;
    }

    public void setSuggestions(List<SuggestionDatetime> suggestions) {
        this.suggestions = suggestions;
    }

    public int getStageEvent() {
        return this.stageEvent;
    }

    public void setIsOpen(StageEvent stageEvent) {
        // TO IMPLEMENT
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
