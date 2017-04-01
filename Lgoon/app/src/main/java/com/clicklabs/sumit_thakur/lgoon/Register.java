package com.clicklabs.sumit_thakur.lgoon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.clicklabs.sumit_thakur.lgoon.Model.UserInfo;

import java.util.ArrayList;


public class Register extends AppCompatActivity {

    private EditText Email, password, rePassword, firstName, lastName, mNumber;
    private Button register;
    private TextView alreadyAccount;
    private RadioButton male, female, other;
    private CheckBox termsAndCondition;
    private String checkGender;
    private UserInfo infoCoustomer;
    private ArrayList<UserInfo> userInfos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        onClickFuntions();
    }


    public void onClickFuntions() {
        alreadyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(Register.this, Login.class);
                //startActivity(intent);
                finish();
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                genderSelect();
                int flag;
                flag = onRegisterPressed();
                if (flag == 1) {
                    boolean termCondition = termsAndCondition.isChecked();
                    if (termCondition == true) {
                        Toast.makeText(getBaseContext(), "Register Sucessfully", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Register.this, DisplayListView.class);
                        userInfos.add(infoCoustomer);
                        intent.putExtra("UserInformation", userInfos);
                        startActivity(intent);

                       /* Intent intent = new Intent();
                        intent.putExtra("UserInformation",infoCoustomer);
                        setResult(2,intent);
                        finish();
                        */

                    } else {
                        Toast.makeText(getBaseContext(), "Term's and Condition are not Checked", Toast.LENGTH_LONG).show();
                    }

                }
                if (flag == 0) {
                    Toast.makeText(getBaseContext(), "Password Doesn't Match", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    public void genderSelect() {
        if (onRadioButtonClicked(male))
            checkGender = male.getText().toString();
        else if (onRadioButtonClicked(female))
            checkGender = female.getText().toString();
        else if (onRadioButtonClicked(other))
            checkGender = other.getText().toString();
    }


    public int onRegisterPressed() {
        String userEmail = Email.getText().toString();
        String userPassword = password.getText().toString();
        String repassword = rePassword.getText().toString();
        String fName = firstName.getText().toString();
        String lName = lastName.getText().toString();
        String mobNumber = mNumber.getText().toString();

        if (userEmail.isEmpty() || userPassword.isEmpty() || repassword.isEmpty() || fName.isEmpty() || lName.isEmpty() || checkGender.isEmpty() || mobNumber.isEmpty()) {
            Toast.makeText(getBaseContext(), "All field Mendatatory", Toast.LENGTH_LONG).show();
            return 2;
        } else if (userPassword.equals(repassword)) {
            boolean flag = isValidEmail(userEmail);
            if (!flag) {
                Toast.makeText(getBaseContext(), "Email not Valid..!!!  Please Enter the valid Email.", Toast.LENGTH_LONG).show();
            } else {
                setDataUserInfo(userEmail, fName, lName, mobNumber);
                return 1;
            }
        }

        return 0;
    }


    public void setDataUserInfo(String userEmail, String fName, String lName, String mobNumber) {
        infoCoustomer = new UserInfo();
        infoCoustomer.setEmailId(userEmail);
        infoCoustomer.setContactNumber(mobNumber);
        infoCoustomer.setFirstName(fName);
        infoCoustomer.setLastName(lName);
        infoCoustomer.setGenderSelect(checkGender);
    }

    public boolean onRadioButtonClicked(View view) {
        boolean flag = ((RadioButton) view).isChecked();
        return flag;
    }


    private static boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }


    public void init() {
        setContentView(R.layout.activity_register);
        firstName = (EditText) findViewById(R.id.textFirstName);
        lastName = (EditText) findViewById(R.id.textLastName);
        Email = (EditText) findViewById(R.id.text_id);
        password = (EditText) findViewById(R.id.text_password);
        rePassword = (EditText) findViewById(R.id.text_re_password);
        register = (Button) findViewById(R.id.btn_register);
        alreadyAccount = (TextView) findViewById(R.id.txt_already_Account);
        male = (RadioButton) findViewById(R.id.radio_male);
        female = (RadioButton) findViewById(R.id.radio_female);
        other = (RadioButton) findViewById(R.id.radio_others);
        termsAndCondition = (CheckBox) findViewById(R.id.termsAndCondition);
        mNumber = (EditText) findViewById(R.id.mobileNumber);
        checkGender = "";
        userInfos = new ArrayList<>();

    }
}
