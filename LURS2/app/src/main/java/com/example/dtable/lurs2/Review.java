package com.example.dtable.lurs2;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.view.View;

@Entity(tableName = "Review")
public  class Review {


    public Review(){}
    public Review(String name,String address){
        this.locationName=name;
        this.Address=address;
    }
    public Review(String name,String address,String Categ){
        this.locationName=name;
        this.Address=address;
        this.Category=Categ;
    }


    @PrimaryKey
    @NonNull
    @ColumnInfo(name="Location_Name")
    public String locationName;

    @ColumnInfo(name="Address")
    public String Address;

    @ColumnInfo(name="Category")
    public String Category;


    @ColumnInfo(name="Rating")
    public float Rating;


    @ColumnInfo(name="Reviews")
    public String Reviews;

    public String getLocationName(){
        return this.locationName;
    }
    public String getAddress(){
        return this.Address;
    }
    public void setAddress(String add){
        this.Address=add;
    }
    public void setLocationName(String name){
        this.locationName=name;
    }


}
