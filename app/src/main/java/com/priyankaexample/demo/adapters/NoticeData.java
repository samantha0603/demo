package com.priyankaexample.demo.adapters;

import com.google.gson.annotations.SerializedName;

public class NoticeData {
    @SerializedName("heading")
    private String heading;

    @SerializedName("details")
    private String details;

    public NoticeData(String heading, String details) {
        this.heading = heading;
        this.details = details;
    }

    public String getHeading() {

        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
