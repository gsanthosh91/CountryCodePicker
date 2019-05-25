package com.gsanthosh91.countrypicker;


import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.view.View;

public class CountryView extends android.support.v7.widget.AppCompatTextView {

    private Context mContext;
    String countryCode = "AD";
    private View.OnClickListener mCountryCodeHolderClickListener;
    private CountryCodeDialog mCountryCodeDialog;


    public CountryView(Context context) {
        super(context);
        this.mContext = context;
        init(null);

    }

    public CountryView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;

        init(attrs);

    }

    public CountryView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;

        init(attrs);

    }


    private void init(AttributeSet attrs) {
        TypedArray arr = mContext.obtainStyledAttributes(attrs, R.styleable.CountryView, 0, 0);
        countryCode = arr.getString(R.styleable.CountryView_country);
        if (countryCode != null) {
            Country country = Country.getCountryByCode(countryCode);
            setText(String.format("%s %s", country.getFlag(), country.getDialCode()));
        }

        mCountryCodeHolderClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClickable()) {
                    if (mCountryCodeDialog == null) {
                        mCountryCodeDialog = new CountryCodeDialog(CountryView.this);
                    }

                    mCountryCodeDialog.show();
                }
            }
        };

        setOnClickListener(mCountryCodeHolderClickListener);


        arr.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public Country getCountry() {
        return Country.getCountryByCode(countryCode);
    }

    public String getCountryCode() {
        return countryCode;
    }


    public void setCountry(String countryCode) {
        this.countryCode = countryCode;
        TypedArray arr = mContext.obtainStyledAttributes(null, R.styleable.CountryView, 0, 0);
        if (countryCode != null) {
            Country country = Country.getCountryByCode(countryCode);
            setText(String.format("%s %s", country.getFlag(), country.getDialCode()));
        }
        arr.recycle();
    }

    @SuppressWarnings("unused")
    private OnClickListener getCountryCodeHolderClickListener() {
        return mCountryCodeHolderClickListener;
    }
}
