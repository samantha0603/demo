package com.priyankaexample.demo.adapters;

import android.support.v7.widget.RecyclerView;

import com.google.gson.annotations.SerializedName;

public class CourseData {
    @SerializedName("subject")
    private String subject;

    @SerializedName("course")
    private String course;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public CourseData(String subject, String course) {

        this.subject = subject;
        this.course = course;
    }
}
