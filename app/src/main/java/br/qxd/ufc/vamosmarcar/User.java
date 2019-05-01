package br.qxd.ufc.vamosmarcar;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static int code = 0;

    private int id;
    private String phoneNumber;
    private String username;
    private String pathPhoto;
    private List<Event> events;

    public User(String username, String phoneNumber) {
        this.id = ++code;
        this.username = username;
        this.phoneNumber  = phoneNumber;
        this.events = new ArrayList<>();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPathPhoto() {
        return this.pathPhoto;
    }

    public void setPathPhoto(String pathPhoto) {
        this.pathPhoto = pathPhoto;
    }

    public List<Event> getEvents() {
        return this.events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
