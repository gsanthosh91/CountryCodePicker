package com.gsanthosh91.countrycodepicker;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.gsanthosh91.countrypicker.Country;
import com.gsanthosh91.countrypicker.CountryPickerActivity;
import com.gsanthosh91.countrypicker.CountryView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    CountryView dialCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialCode = findViewById(R.id.dialCode);

        dialCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CountryPickerActivity.class);
                startActivityForResult(intent, 11);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 11) {
            if (resultCode == Activity.RESULT_OK) {
                Country country = (Country) data.getSerializableExtra("country");
                initCountry(country);
            }
        }
    }


    void initCountry(Country country) {
        dialCode.setCountry(country.getCode());
    }

}