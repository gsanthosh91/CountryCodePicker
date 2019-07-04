package com.gsanthosh91.spincountrypicker;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends BaseAdapter implements Filterable {

    private List<Country> originalData = new ArrayList<>();
    private List<Country> filteredData = new ArrayList<>();
    private LayoutInflater mInflater;
    private ItemFilter mFilter = new ItemFilter();


    public CountryAdapter(Context context, List<Country> countries) {
        this.filteredData = countries;
        this.originalData = countries;
        mInflater = LayoutInflater.from(context);

    }

    public int getCount() {
        return filteredData.size();
    }

    public Country getItem(int position) {
        return filteredData.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        ViewHolder holder;


        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_country, null);

            // Creates a ViewHolder and store references to the two children views
            // we want to bind data to.
            holder = new ViewHolder();
            holder.tvName = convertView.findViewById(R.id.name);
            holder.tvDialCode = convertView.findViewById(R.id.dialCode);
            holder.tvflag = convertView.findViewById(R.id.flag);

            // Bind the data efficiently with the holder.

            convertView.setTag(holder);
        } else {
            // Get the ViewHolder back to get fast access to the TextView
            // and the ImageView.
            holder = (ViewHolder) convertView.getTag();
        }

        Country country = filteredData.get(position);

        holder.tvName.setText(String.format("%s (%s)", country.getName(), country.getCode()));
        holder.tvDialCode.setText(country.getDialCode());
        holder.tvflag.setText(country.getFlag());
        return convertView;
    }

    static class ViewHolder {
        TextView tvName;
        TextView tvDialCode;
        TextView tvflag;
    }

    public Filter getFilter() {
        return mFilter;
    }


    private class ItemFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            String filterString = constraint.toString().toLowerCase();

            FilterResults results = new FilterResults();

            final List<Country> list = originalData;

            int count = list.size();
            final ArrayList<Country> nlist = new ArrayList<>(count);

            for (Country item : list) {
                if (item.getName().toLowerCase().contains(filterString) || item.getCode().toLowerCase().contains(filterString) || item.getDialCode().toLowerCase().contains(filterString)) {
                    nlist.add(item);
                }
            }

            results.values = nlist;
            results.count = nlist.size();

            return results;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filteredData = (ArrayList<Country>) results.values;
            notifyDataSetChanged();
        }

    }

}
