package com.app.retrofit.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by djlophu on 02/03/15.
 */

public class Rooms {
    @SerializedName("scheduleItems")
    public ArrayList<String> scheduleItems;
    @SerializedName("title")
    public String title;
    @SerializedName("colorCode")
    public String colorCode;
    @SerializedName("eventId")
    public int eventId;
    @SerializedName("id")
    public int id;
    @SerializedName("updatedAt")
    public String updatedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<String> getScheduleItems() {
        return scheduleItems;
    }

    public void setScheduleItems(ArrayList<String> scheduleItems) {
        this.scheduleItems = scheduleItems;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
