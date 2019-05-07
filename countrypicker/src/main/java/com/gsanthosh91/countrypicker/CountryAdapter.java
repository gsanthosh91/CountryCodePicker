package com.gsanthosh91.countrypicker;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends ArrayAdapter<Country> {

    public CountryAdapter(Context context, List<Country> countries) {
        super(context, 0, countries);
    }

    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        Country country = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_country, parent, false);
        }

        TextView tvName = convertView.findViewById(R.id.name);
        TextView tvDialCode = convertView.findViewById(R.id.dialCode);
        TextView tvflag = convertView.findViewById(R.id.flag);
        tvName.setText(country.getName());
        tvDialCode.setText(country.getDialCode());
        tvflag.setText(country.getFlag());
        return convertView;
    }

}
