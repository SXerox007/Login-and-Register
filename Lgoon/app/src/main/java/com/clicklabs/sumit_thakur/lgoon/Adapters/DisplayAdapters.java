package com.clicklabs.sumit_thakur.lgoon.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.clicklabs.sumit_thakur.lgoon.Model.UserInfo;
import com.clicklabs.sumit_thakur.lgoon.R;

import java.util.ArrayList;

/**
 * Created by SUMIT_THAKUR on 31/03/17.
 */

public class DisplayAdapters extends BaseAdapter {

    private Context context;
    private ArrayList<UserInfo> userInfos;

    public DisplayAdapters(Context context, ArrayList<UserInfo> userInfos) {
        this.context = context;
        this.userInfos = userInfos;
    }

    @Override
    public int getCount() {
        return userInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return userInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_list_view_data, parent, false);
        }

        UserInfo userInfo = (UserInfo) getItem(position);

        TextView tvFName = (TextView) convertView.findViewById(R.id.firstName);
        TextView tvLName = (TextView) convertView.findViewById(R.id.lastName);
        TextView tvEmailId = (TextView) convertView.findViewById(R.id.emaiId);
        TextView tvContact = (TextView) convertView.findViewById(R.id.mobileNumber);
        TextView tvGender = (TextView) convertView.findViewById(R.id.gender);

        tvFName.setText(userInfo.getFirstName());
        tvLName.setText(userInfo.getLastName());
        tvEmailId.setText(userInfo.getEmailId());
        tvContact.setText(userInfo.getContactNumber());
        tvGender.setText(userInfo.getGenderSelect());

        return convertView;
    }
}
