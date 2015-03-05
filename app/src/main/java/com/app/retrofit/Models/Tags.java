package com.app.retrofit.Models;


import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Created by djlophu on 02/03/15.
 */
@Table(name = "Tags", id = "_id")
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


   }
