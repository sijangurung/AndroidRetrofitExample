package com.app.retrofit.Models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.List;

/**
 * Created by djlophu on 04/03/15.
 */
@Table(name = "Categories")
public class Category extends Model {
    @Column(name = "Name")
    public String name;

    // This method is optional, does not affect the foreign key creation.
    public List<Item> items() {
        return getMany(Item.class, "Category");
    }

    public Category() {
        super();
    }
}