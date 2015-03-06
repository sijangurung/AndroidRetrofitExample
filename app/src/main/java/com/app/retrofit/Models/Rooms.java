package com.app.retrofit.Models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by djlophu on 02/03/15.
 */
@Table(name="Rooms")
public class Rooms extends Model {

    //This is just for JSON to POJO-.....
    @SerializedName("scheduleItems")
    public List<Integer> scheduleItems;

    public List<Integer> getScheduleItems() {
        return scheduleItems;
    }
    public void setScheduleItems(List<Integer> scheduleItems) {
        this.scheduleItems = scheduleItems;
    }

    //scheduleItems.... relations by RoomScheduleItems Class.....

    @Expose
    @Column(name="title")
    public String title;
    @Expose
    @Column(name="colorCode")
    public String colorCode;
    @Expose
    @Column(name="eventId")
    public int eventId;

    @SerializedName("id")
    @Column(name="roomId",unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    public int roomId;

    @Expose
    @Column(name="updatedAt")
    public String updatedAt;

    public Rooms(){super();} //For Database.....

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

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
