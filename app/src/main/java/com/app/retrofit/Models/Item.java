package com.app.retrofit.Models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by djlophu on 04/03/15.
 */
@Table(name = "Items")
public class Item extends Model {

    @Column(name = "Name")
    public String name;

    @Column(name = "Category")
    public Category category;

    public Item() {
        super();
    }
}