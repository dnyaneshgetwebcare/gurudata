package com.example.gurudata.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gurudata.DriverManagement;
import com.example.gurudata.R;
import com.example.gurudata.databinding.ActivityAddDriverBinding;
import com.example.gurudata.db.DatabaseApplication;
import com.example.gurudata.db.models.DriverMaster;
import com.google.android.material.snackbar.Snackbar;

public class AddDriver extends AppCompatActivity {
Button saveButton;
EditText ed_name,ed_address,ed_contact;
ActivityAddDriverBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* setContentView(R.layout.activity_add_driver);*/
        binding = ActivityAddDriverBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ed_name = binding.edDriverName;
        ed_address = binding.edDriverAddress;
        ed_contact = binding.edContact;
        saveButton =binding.btnSaveDriver;

        ed_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String driver_name= ed_name.getText().toString();
               String driver_add= ed_address.getText().toString();
               String driver_contact= ed_contact.getText().toString();
               String error=null;
               if(driver_name.isEmpty()){

               }
               if(error==null){
                   if(savedriver(driver_name,driver_add,driver_contact)) {

                       Snackbar.make(v, "Driver data saved", Snackbar.LENGTH_LONG)
                               .setAction("Action", null).show();
                       Intent i = new Intent(getApplicationContext(), DriverManagement.class);
                       startActivity(i);
                   }else{
                       Snackbar.make(v, "Driver details Failed to save", Snackbar.LENGTH_LONG)
                               .setAction("Action", null).show();
                   }

               }
            }
        });

    }

    private boolean savedriver(String driver_name, String driver_add, String driver_contact) {
        try {
            DriverMaster driverMaster = new DriverMaster();
            driverMaster.driverName = driver_name;
            driverMaster.address = driver_add;
            driverMaster.contactno = driver_contact;
            DatabaseApplication.getInstance(getApplicationContext()).getMyDatabase().driverMasterDao()
                    .insertAll(driverMaster);
        }catch (Exception ex){
            return false;
        }
        return true;
    }

}
