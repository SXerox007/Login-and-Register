package com.clicklabs.sumit_thakur.lgoon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.clicklabs.sumit_thakur.lgoon.Model.UserInfo;


public class detailDisplay extends AppCompatActivity {

     TextView fName,lName,email,sgender,mNUmber;
     String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_display);
        init();
        bundleFetchdata();
    }


    public void init(){
        fName = (TextView)findViewById(R.id.firstName);
        lName = (TextView)findViewById(R.id.lastName);
        email = (TextView)findViewById(R.id.emaiId);
        sgender = (TextView)findViewById(R.id.gender);
        mNUmber= (TextView)findViewById(R.id.mobileNumber);
    }


    public void bundleFetchdata(){

        /*
        Intent iin= getIntent();
        Bundle bundle = iin.getExtras();
        if(bundle!=null)
        {
            String data =bundle.getString("FirstName");
            fName.setText(data);
            data=bundle.getString("LastName");
            lName.setText(data);
            data=bundle.getString("EmailId");
            email.setText(data);
            data = bundle.getString("Gender");
            sgender.setText(data);
            data=bundle.getString("MobileNumber");
            mNUmber.setText(data);

        }
        else{
            Toast.makeText(getBaseContext(), "No data Found", Toast.LENGTH_LONG).show();
        }
        */


        UserInfo obj=getIntent().getParcelableExtra("UserInformation");


        data=obj.getFirstName();
        fName.setText(data);

        data=obj.getLastName();
        lName.setText(data);

        data=obj.getEmailId();
        email.setText(data);

        data=obj.getContactNumber();
        mNUmber.setText(data);

        data=obj.getGenderSelect();
        sgender.setText(data);




    }
}
