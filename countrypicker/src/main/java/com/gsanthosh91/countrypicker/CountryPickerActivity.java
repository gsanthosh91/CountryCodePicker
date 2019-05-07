package com.gsanthosh91.countrypicker;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CountryPickerActivity extends AppCompatActivity {

    List<Country> countryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_picker);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView countryListView = findViewById(R.id.countryListView);

        Country country = new Country();

        countryList = country.getAllCountries();
        CountryAdapter adapter = new CountryAdapter(this, countryList);
        countryListView.setAdapter(adapter);
        countryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Country country = countryList.get(position);
                finishResult(country);
            }
        });

    }

    private void finishResult(Country country) {
        Intent intent = getIntent();
        intent.putExtra("country", country);
        setResult(Activity.RESULT_OK, getIntent());
        finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
