package com.gsanthosh91.countrycodepicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.gsanthosh91.spincountrypicker.SpinCountryView;


public class MainActivity extends AppCompatActivity  {


    SpinCountryView spinCountryView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinCountryView = findViewById(R.id.spindialCode);

        Toast.makeText(this, spinCountryView.getCountry().getDialCode(), Toast.LENGTH_SHORT).show();


    }
}