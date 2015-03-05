package com.app.retrofit.Models;


import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Created by djlophu on 02/03/15.
 */
@Table(name = "Tags")
public class Tags extends Model {


    @Expose
    @Column(name="title")
    public String title;


    @SerializedName("id")
    @Column(name="tagid", unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    public int tagid;

    @Expose
    @Column(name="updatedAt")
    public String updatedAt;


    public Tags(){
        //We have to call super in each constructor to create the table...
        super();}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTagid() {
        return tagid;
    }

    public void setTagid(int tagid) {
        this.tagid = tagid;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
