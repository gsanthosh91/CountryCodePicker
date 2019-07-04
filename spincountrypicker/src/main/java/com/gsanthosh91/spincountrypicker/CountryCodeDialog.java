package com.gsanthosh91.spincountrypicker;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CountryCodeDialog extends Dialog {

    List<Country> countryList = new ArrayList<>();
    SpinCountryView countryView;
    Context context;

    CountryCodeDialog(SpinCountryView countryView) {
        super(countryView.getContext());
        this.countryView = countryView;
        context = countryView.getContext();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.country_dialog);

        ListView countryListView = findViewById(R.id.countryListView);
        countryList = new Utils().getAllCountries();

        final CountryAdapter adapter = new CountryAdapter(getContext(), countryList);
        countryListView.setAdapter(adapter);
        countryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Country country = adapter.getItem(position);
                countryView.setCountryByCode(country.getCode());
                dismiss();
            }
        });

        EditText searchEditText = findViewById(R.id.searchEditText);
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


    }

}
