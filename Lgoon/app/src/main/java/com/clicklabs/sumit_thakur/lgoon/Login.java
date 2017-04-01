package com.clicklabs.sumit_thakur.lgoon;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.inputmethod.InputMethodManager;
import android.os.Bundle;

import com.clicklabs.sumit_thakur.lgoon.Model.UserInfo;

public class Login extends AppCompatActivity {

    private EditText ContactEmail, ContactPassword;
    private Button login, register;
    private int flag = 0;
    private int REQUEST_CODE = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = onLoginPressed();
                if (flag == 1) {
                    Intent intent = new Intent(Login.this, HomeLgoon.class);
                    startActivity(intent);
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //onRegisterPressed();
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
               // startActivityForResult(intent, REQUEST_CODE);

            }
        });
    }


//    @Override
  //  public boolean onCreateOptionMenu(Menu menu){
    //    return true;
    //}


    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent intent){
        super.onActivityResult(requestCode,resultCode,intent);
        if(requestCode==REQUEST_CODE){
            Toast.makeText(getBaseContext(), "Request Code is Matched", Toast.LENGTH_LONG).show();
            UserInfo obj=intent.getParcelableExtra("UserInformation");
            String data=obj.getEmailId();
            ContactEmail.setText(data);
        }

    }

    public void init() {

        ContactEmail = (EditText) findViewById(R.id.edit_text);
        ContactPassword = (EditText) findViewById(R.id.text_password_create);
        login = (Button) findViewById(R.id.btn_login);
        register = (Button) findViewById(R.id.btn_register);

    }


    public int onLoginPressed() {
        String Email = ContactEmail.getText().toString();
        String Password = ContactPassword.getText().toString();

        if (Email.isEmpty() || Password.isEmpty()) {
            Toast.makeText(getBaseContext(), "All fields are required.", Toast.LENGTH_LONG).show();
            return 0;
        } else {
            if (Email.equals("sumit") && Password.equals("sumit")) {
                Toast.makeText(getBaseContext(), "Login Sucessfully.", Toast.LENGTH_LONG).show();
                ContactEmail.setText("");
                ContactPassword.setText("");
                return 1;
            } else {
                Toast.makeText(getBaseContext(), "Error", Toast.LENGTH_LONG).show();
                return 0;
            }
        }

    }

    /*
       @Override
        protected void onResume() {
            super.onResume();
            answer_et.postDelayed(new Runnable() {
                @Override
                public void run() {
                    InputMethodManager imm = (InputMethodManager) getSystemService(
                            Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edit_text.getWindowToken(), 0);
                }
            }, 100);

        }


    */
    /*class KeyBoard {

        void show(Activity activity) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(0, InputMethodManager.HIDE_IMPLICIT_ONLY); // show
        }

        void hide(Activity activity) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0); // hide
        }

        void toggle(Activity activity) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            if (imm.isActive()) {
                hide(activity);
            } else {
                show(activity);
            }
        }
    }
*/

}






