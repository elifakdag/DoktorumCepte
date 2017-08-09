package com.doktorumcepte.doktorumcepte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

import Model.TansiyonDegeri;

public class data_entry_pressure extends AppCompatActivity implements  View.OnClickListener {
    Button degeriKaydet;
    EditText stansiyon;
    EditText btansiyon;
    private static String TAG = "data_pressure_entry";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry_pressure);

        degeriKaydet = (Button) findViewById(R.id.tansiyonbuton);
        btansiyon   = (EditText)findViewById(R.id.btansiyon);
        stansiyon   = (EditText)findViewById(R.id.stansiyon);
        degeriKaydet.setOnClickListener(this);

        Intent intent = getIntent();
    }
    public void onClick(View v) {
        //Log.v("EditText", mEdit.getText().toString());
        switch (v.getId()) {
            case R.id.tansiyonbuton:
                DegeriKaydet("user5     ",Integer.valueOf(stansiyon.getText().toString()),Integer.valueOf(btansiyon.getText().toString()));
                break;
        }
    }
    private void DegeriKaydet(String userId, int stansiyon, int btansiyon){
        //To Date
        Calendar c = Calendar.getInstance();
        int minute = c.get(Calendar.MINUTE);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int day = c.get(Calendar.DATE);
        TansiyonDegeri obje  = new TansiyonDegeri(userId, stansiyon, btansiyon, minute, hour, day);
        Toast.makeText(this, "Data Saved!", Toast.LENGTH_SHORT).show();
    }
}
