package com.okunan.tunahan.mycriminalintent;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import java.util.Date;
import java.util.UUID;

@Table(name="Crimes")
public class Crime extends Model {

    @Column(name = "mID")
    private UUID mID;
    @Column(name = "mTitle")
    private String mTitle;
    @Column(name = "mDate")
    private Date mDate;
    @Column(name = "mSolved")
    private boolean mSolved;
    @Column(name = "mSuspect")
    private String mSuspect;
    public Crime(){
        mID=UUID.randomUUID();
        mDate=new Date();
    }

    public UUID getID() {
        return mID;
    }

    public void setID(UUID ID) {
        mID = ID;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public String getSuspect() {
        return mSuspect;
    }

    public void setSuspect(String suspect) {
        mSuspect = suspect;
    }

    public  String getPhotoFileName(){
        return "IMG"+getID().toString()+".jpg";
    }
}
