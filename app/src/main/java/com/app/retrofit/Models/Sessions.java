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
@Table(name="Sessions")
public class Sessions extends Model {
    @Expose
    @Column(name="roomId")
    public int roomId;

    //Just for getting value from JSON to POJO...
    @SerializedName("tags")
    public List<Integer> tags;
    //Just for getting value from JSON to POJO...
    @SerializedName("speakers")
    public List<Integer> speakers;

    public List<Integer> getTags() {
        return tags;
    }
    public void setTags(List<Integer> tags) {
        this.tags = tags;
    }
    public List<Integer> getSpeakers() {
        return speakers;
    }
    public void setSpeakers(List<Integer> speakers) {
        this.speakers = speakers;
    }

    //tags....relations by SessionTags Class.....
    //speakers...relations by SessionSpeakers Class..

    @Expose
    @Column(name="title")
    public String title;
    @Expose
    @Column(name="startTime")
    public String startTime;
    @Expose
    @Column(name="endTime")
    public String endTime;
    @Expose
    @Column(name="description")
    public String description;
    @Expose
    @Column(name="imageUrl")
    public String imageUrl;
    @Expose
    @Column(name="isAttend")
    public Boolean isAttend;

    @SerializedName("id")
    @Column(name="sessionId",unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    public int sessionId;

    @Expose
    @Column(name="updatedAt")
    public String updatedAt;

    public Sessions(){super();} //for Database...

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getIsAttend() {
        return isAttend;
    }

    public void setIsAttend(Boolean isAttend) {
        this.isAttend = isAttend;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
