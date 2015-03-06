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
@Table(name="Speakers")
public class Speakers extends Model {
    //Just for getting value from JSON to POJO...
    @SerializedName("tags")
    public List<Integer> tags;
    @SerializedName("scheduleItems")
    public List<Integer> scheduleItems;

    public List<Integer> getTags() {
        return tags;
    }
    public void setTags(List<Integer> tags) {
        this.tags = tags;
    }
    public List<Integer> getScheduleItems() {
        return scheduleItems;
    }
    public void setScheduleItems(List<Integer> scheduleItems) {
        this.scheduleItems = scheduleItems;
    }

    //tags...  Tags for Speakers..SpeakersTags Class....
    //scheduleItems...  SpeakerScheduleItems Class...

    @Expose
    @Column(name="firstName")
    public String firstName;
    @Expose
    @Column(name="lastName")
    public String lastName;
    @Expose
    @Column(name="companyName")
    public String companyName;
    @Expose
    @Column(name="position")
    public String position;
    @Expose
    @Column(name="imageUrl")
    public String imageUrl;
    @Expose
    @Column(name="description")
    public String description;
    @Expose
    @Column(name="mobile")
    public String mobile;
    @Expose
    @Column(name="twitter")
    public String twitter;
    @Expose
    @Column(name="email")
    public String email;
    @Expose
    @Column(name="linkedIn")
    public String linkedIn;

    @SerializedName("id")
    @Column(name="speakerId",unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    public int speakerId;

    @Expose
    @Column(name="updatedAt")
    public String updatedAt;

    public Speakers() {super();}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public int getSpeakerId() {
        return speakerId;
    }

    public void setSpeakerId(int speakerId) {
        this.speakerId = speakerId;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
