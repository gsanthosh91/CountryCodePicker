package com.gsanthosh91.countrycodepicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gsanthosh91.countrypicker.Country;
import com.gsanthosh91.countrypicker.CountryView;


public class MainActivity extends AppCompatActivity {

    CountryView dialCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialCode = findViewById(R.id.dialCode);
    }

}