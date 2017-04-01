package com.clicklabs.sumit_thakur.lgoon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.clicklabs.sumit_thakur.lgoon.Adapters.DisplayAdapters;
import com.clicklabs.sumit_thakur.lgoon.Model.UserInfo;

import java.util.ArrayList;

public class DisplayListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ArrayList<UserInfo> userInfos = getIntent().getParcelableArrayListExtra("UserInformation");
        DisplayAdapters  displayAdapters = new DisplayAdapters(this,userInfos);
        ListView listView = (ListView) findViewById(R.id.lvUserInfo);
        listView.setAdapter(displayAdapters);
    }

}
