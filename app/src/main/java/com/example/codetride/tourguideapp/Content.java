package com.example.codetride.tourguideapp;

import java.io.Serializable;

/**
 * Created by CodeTride on 2017/08/16.
 */

public class Content implements Serializable{
    private String mName, mShortDesc, mPlace, mNumber;
    private int mFull;
    private int mImageResourceId=No_IMAGE;
    private static final int No_IMAGE = -1;

    //empty constructor
    public Content(){
    }

    //constructor that has all the contacts
    public Content(String mName, String mNumber, String mShortDesc, int mImageResourceId, int mfull) {
        this.mName = mName;
        this.mNumber = mNumber;
        this.mShortDesc = mShortDesc;
        this.mImageResourceId = mImageResourceId;
        this.mFull = mfull;
    }

    public Content(String mName, String mNumber, String mShortDesc, int mImageResourceId) {
        this.mName = mName;
        this.mShortDesc = mShortDesc;
        this.mNumber = mNumber;
        this.mImageResourceId = mImageResourceId;
    }

    //constructor for the main activity
    public Content(String mName, int mImageResourceId) {
        this.mName = mName;
        this.mImageResourceId = mImageResourceId;
    }

    //constructor for the gallery activity
    public Content(int mImageResourceId, String mPlace) {
        this.mImageResourceId = mImageResourceId;
        this.mPlace = mPlace;
    }

    public Content(String Name, String ShortDesc, String Place) {
        this.mName = Name;
        this.mShortDesc = ShortDesc;
        this.mPlace = Place;
    }

    public String getName() {
        return mName;
    }

    public String getShortDesc() {
        return mShortDesc;
    }

    public String getPlace() {
        return mPlace;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage(){
        return mImageResourceId != No_IMAGE;
    }

    public boolean hasDescs(){
        return mShortDesc != null;
    }

    public boolean hasPlace(){
        return mPlace != null;
    }

    public String getmNumber() {
        return mNumber;
    }

    public int getmFull() {
        return mFull;
    }

    public boolean hasFull(){
        return mFull != -1;
    }
}
