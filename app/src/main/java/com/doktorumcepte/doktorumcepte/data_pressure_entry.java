package com.doktorumcepte.doktorumcepte;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Calendar;

import Model.SekerDegeri;

public class data_pressure_entry extends AppCompatActivity implements View.OnClickListener {
    Button degeriKaydet;
    EditText mEdit;
    //FirebaseUser user;
    //private FirebaseAuth mAuth;
    //private FirebaseAuth.AuthStateListener mAuthListener;
    private static String TAG = "data_pressure_entry";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_pressure_entry);
        degeriKaydet = (Button) findViewById(R.id.degeriKaydetButton);
        mEdit   = (EditText)findViewById(R.id.entry_value);
        degeriKaydet.setOnClickListener(this);
    }
    public void onClick(View v) {
        //Log.v("EditText", mEdit.getText().toString());
        switch (v.getId()) {
            case R.id.degeriKaydetButton:
                DegeriKaydet("user5     ",Integer.valueOf(mEdit.getText().toString()));
                break;
        }
    }
    private void DegeriKaydet(String userId, int sekerDegeri){
        //To Date
        Calendar c = Calendar.getInstance();
        int minute = c.get(Calendar.MINUTE);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int day = c.get(Calendar.DATE);
        SekerDegeri obje  = new SekerDegeri(userId, sekerDegeri, minute, hour, day);
        Toast.makeText(this, "Data Saved!", Toast.LENGTH_SHORT).show();
    }
}
