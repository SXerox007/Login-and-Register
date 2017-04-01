package com.clicklabs.sumit_thakur.lgoon.Model;

/**
 * Created by SUMIT_THAKUR on 30/03/17.
 */

import android.os.Parcel;
import android.os.Parcelable;
/**
 * Created by SUMIT_THAKUR on 30/03/17.
 */

public class UserInfo implements Parcelable {
    public String firstName,lastName,emailId,contactNumber,genderSelect;
    public UserInfo(){
        firstName="";
        lastName="";
        emailId="";
        contactNumber="";
        genderSelect="";
    }

    protected UserInfo(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        emailId = in.readString();
        contactNumber = in.readString();
        genderSelect = in.readString();
    }

    public static final Creator<UserInfo> CREATOR = new Creator<UserInfo>() {
        @Override
        public UserInfo createFromParcel(Parcel in) {
            return new UserInfo(in);
        }

        @Override
        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    };

    public void setGenderSelect(String genderSelect){
        this.genderSelect=genderSelect;
    }


    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public  void setLastName(String lastName){
        this.lastName=lastName;
    }

    public  void  setEmailId(String emailId){
        this.emailId=emailId;
    }

    public  void  setContactNumber(String contactNumber){ this.contactNumber=contactNumber; }
    public  String getFirstName(){
        return  firstName;
    }
    public  String getLastName(){
        return  lastName;
    }
    public String getEmailId(){
        return  emailId;
    }
    public  String getContactNumber(){
        return contactNumber;
    }
    public  String getGenderSelect(){
        return  genderSelect;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(emailId);
        dest.writeString(contactNumber);
        dest.writeString(genderSelect);
    }
}

