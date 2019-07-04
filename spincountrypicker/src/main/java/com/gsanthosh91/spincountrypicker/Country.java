package com.gsanthosh91.spincountrypicker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Country extends Utils {


    private List<Country> COUNTRIES = new ArrayList<>();


    public Country() {
        COUNTRIES = getAllCountries();
    }

    public Country(String countryCode) {
        this.code = countryCode;
    }


    private String code;
    private String name;
    private String dialCode;
    private String flag;

    public Country(String code, String name, String dialCode, String flag) {
        this.code = code;
        this.name = name;
        this.dialCode = dialCode;
        this.flag = flag;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getDialCode() {
        return dialCode;
    }

    public void setDialCode(String dialCode) {
        this.dialCode = dialCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public Country getCountryByCode(String countryCode) {
        Country country = new Country(countryCode);
        int index = Collections.binarySearch(COUNTRIES, country, new CountryCodeComparator());
        if (index >= 0) {
            return COUNTRIES.get(index);
        } else {
            return COUNTRIES.get(0);
        }
    }


}
