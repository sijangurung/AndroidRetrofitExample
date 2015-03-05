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
@Table(name = "Participants")
public class Participants extends Model {

   //JUST FOR JSON to  POJO....
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

    //tags relating to  participant to Tags....ParticipantsTags Class......
    //scheduleItems to paricipants... ParticipantScheduleItems Class...
    @Expose
    @Column(name="firstName")
    public String firstName;
    @Expose
    @Column(name="lastName")
    public String lastName;
    @Expose
    @Column(name="email")
    public String email;
    @Expose
    @Column(name="description")
    public String description;
    @Expose
    @Column(name="imageUrl")
    public String imageUrl;
    @Expose
    @Column(name="mobile")
    public String mobile;
    @Expose
    @Column(name="twitter")
    public String twitter;
    @Expose
    @Column(name="linkedIn")
    public String linkedIn;
    @Expose
    @Column(name="companyName")
    public String companyName;
    @Expose
    @Column(name="position")
    public String position;

    @SerializedName("id")
    @Column(name="participantId",unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    public int participantId;
    @Expose
    @Column(name="updatedAt")
    public String updatedAt;

    public Participants(){
        //this is important for ActiveAndroid....
        super();
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
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

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}

