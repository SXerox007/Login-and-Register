package com.example.sumit_thakur.datatransfer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private EditText valueEnter;
    private Button pressButton;
    private int REQUEST_CODE=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
        Intent intent = getIntent();
        final String data = intent.getStringExtra("Data");
        pressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                intent.putExtra("Data",valueEnter.getText().toString().concat(data));
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }




    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent intent){
        super.onActivityResult(requestCode,resultCode,intent);
        if(requestCode==REQUEST_CODE){
            Toast.makeText(getBaseContext(), "Request Code is Matched", Toast.LENGTH_LONG).show();
            String data=intent.getStringExtra("Data");
            intent = new Intent();
            intent.putExtra("Data",data.toString());
            setResult(REQUEST_CODE,intent);
            finish();
        }

    }





    public void init(){
        valueEnter=(EditText)findViewById(R.id.textEnter);
        pressButton=(Button)findViewById(R.id.btn_enter);
    }

}
