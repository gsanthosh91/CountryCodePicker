package com.gsanthosh91.spincountrypicker;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class SpinCountryView extends android.support.v7.widget.AppCompatTextView {

    Context context;
    private String countryCode = "AD";
    private CountryCodeDialog mCountryCodeDialog;
    private Country countryObj = new Country();

    public SpinCountryView(Context context) {
        super(context);
    }

    public SpinCountryView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public SpinCountryView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }


    private void init(Context context, AttributeSet attrs) {
        this.context = context;
        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.SpinCountryView, 0, 0);
        String spinCountryCode = arr.getString(R.styleable.SpinCountryView_country);
        initCountry(spinCountryCode);

        setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClickable()) {
                    if (mCountryCodeDialog == null) {
                        mCountryCodeDialog = new CountryCodeDialog(SpinCountryView.this);
                    }

                    mCountryCodeDialog.show();
                }
            }
        });

        arr.recycle();
    }

    void initCountry(String localCountryCode) {
        Country country = countryObj.getCountryByCode(localCountryCode != null ? localCountryCode : countryCode);
        if (country != null) {
            this.countryCode = country.getCode();
            setText(String.format("%s %s", country.getFlag(), country.getDialCode()));
        }
    }

    public void setCountryByCode(String countryCode) {

        TypedArray arr = context.obtainStyledAttributes(null, R.styleable.SpinCountryView, 0, 0);

        initCountry(countryCode);

        arr.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public Country getCountry() {
        return countryObj.getCountryByCode(countryCode);
    }

}
