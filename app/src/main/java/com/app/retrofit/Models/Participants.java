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
@Table(name = "Participants",id="_id")
public class Participants extends Model {

   //JUST FOR JSON to  POJO....
    @SerializedName("tags")
    public List<Integer> tags;

    public List<Integer> getTags() {
        return tags;
    }

    public void setTags(List<Integer> tags) {
        this.tags = tags;
    }

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
    @Column(name="participantId")
    public int participantId;
    @Expose
    @Column(name="updatedAt")
    public String updatedAt;

    public Participants(){
        //this is important for ActiveAndroid....
        super();
    }

}

