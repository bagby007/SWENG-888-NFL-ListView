package com.example.listview.models;

import java.io.Serializable;

public class Team implements Serializable {
    private final String name;
    private final String division;
    private final String record;
    private final int logoResId;

    public Team(String name, String division, String record, int logoResId) {
        this.name = name;
        this.division = division;
        this.record = record;
        this.logoResId = logoResId;
    }

    public String getName() { return name; }
    public String getDivision() { return division; }
    public String getRecord() { return record; }
    public int getLogoResId() { return logoResId; }
}
