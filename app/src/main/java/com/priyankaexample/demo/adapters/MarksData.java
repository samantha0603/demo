package com.priyankaexample.demo.adapters;

import com.google.gson.annotations.SerializedName;

public class MarksData {
    @SerializedName("name")
    private String  name;
    @SerializedName("id")
    private String id;
    @SerializedName("cgpa")
    private String cgpa;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }

    public MarksData(String name, String id, String cgpa) {

        this.name = name;
        this.id = id;
        this.cgpa = cgpa;
    }
}
