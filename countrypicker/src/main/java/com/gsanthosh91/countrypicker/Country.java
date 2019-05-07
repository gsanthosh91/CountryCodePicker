package com.gsanthosh91.countrypicker;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/**
 * Created by mukesh on 25/04/16.
 */

public class Country implements Serializable {


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

    public Country() {
    }


    public String getDialCode() {
        return dialCode;
    }

    public void setDialCode(String dialCode) {
        this.dialCode = dialCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
        if (TextUtils.isEmpty(name)) {
            name = new Locale("", code).getDisplayName();
        }
    }

    public String getName() {
        return name;
    }


    public List<Country> getAllCountries() {


        Country[] COUNTRIES = {
                new Country("AD", "Andorra", "+376", getEmojiByUnicode(0x1F1E6, 0x1F1E9)),
                new Country("AE", "United Arab Emirates", "+971", getEmojiByUnicode(0x1F1E6, 0x1F1EA)),
                new Country("AF", "Afghanistan", "+93", getEmojiByUnicode(0x1F1E6, 0x1F1EB)),
                new Country("AG", "Antigua and Barbuda", "+1", getEmojiByUnicode(0x1F1E6, 0x1F1EC)),
                new Country("AI", "Anguilla", "+1", getEmojiByUnicode(0x1F1E6, 0x1F1EE)),
                new Country("AL", "Albania", "+355", getEmojiByUnicode(0x1F1E6, 0x1F1F1)),
                new Country("AM", "Armenia", "+374", getEmojiByUnicode(0x1F1E6, 0x1F1F2)),
                new Country("AO", "Angola", "+244", getEmojiByUnicode(0x1F1E6, 0x1F1F4)),
                new Country("AQ", "Antarctica", "+672", getEmojiByUnicode(0x1F1E6, 0x1F1F6)),
                new Country("AR", "Argentina", "+54", getEmojiByUnicode(0x1F1E6, 0x1F1F7)),
                new Country("AS", "AmericanSamoa", "+1", getEmojiByUnicode(0x1F1E6, 0x1F1F8)),
                new Country("AT", "Austria", "+43", getEmojiByUnicode(0x1F1E6, 0x1F1F9)),
                new Country("AU", "Australia", "+61", getEmojiByUnicode(0x1F1E6, 0x1F1FA)),
                new Country("AW", "Aruba", "+297", getEmojiByUnicode(0x1F1E6, 0x1F1FC)),
                new Country("AX", "Åland Islands", "+358", getEmojiByUnicode(0x1F1E6, 0x1F1FD)),
                new Country("AZ", "Azerbaijan", "+994", getEmojiByUnicode(0x1F1E6, 0x1F1FF)),
                new Country("BA", "Bosnia and Herzegovina", "+387", getEmojiByUnicode(0x1F1E7, 0x1F1E6)),
                new Country("BB", "Barbados", "+1", getEmojiByUnicode(0x1F1E7, 0x1F1E7)),
                new Country("BD", "Bangladesh", "+880", getEmojiByUnicode(0x1F1E7, 0x1F1E9)),
                new Country("BE", "Belgium", "+32", getEmojiByUnicode(0x1F1E7, 0x1F1EA)),
                new Country("BF", "Burkina Faso", "+226", getEmojiByUnicode(0x1F1E7, 0x1F1EB)),
                new Country("BG", "Bulgaria", "+359", getEmojiByUnicode(0x1F1E7, 0x1F1EC)),
                new Country("BH", "Bahrain", "+973", getEmojiByUnicode(0x1F1E7, 0x1F1ED)),
                new Country("BI", "Burundi", "+257", getEmojiByUnicode(0x1F1E7, 0x1F1EE)),
                new Country("BJ", "Benin", "+229", getEmojiByUnicode(0x1F1E7, 0x1F1EF)),
                new Country("BL", "Saint Barthélemy", "+590", getEmojiByUnicode(0x1F1E7, 0x1F1F1)),
                new Country("BM", "Bermuda", "+1", getEmojiByUnicode(0x1F1E7, 0x1F1F2)),
                new Country("BN", "Brunei Darussalam", "+673", getEmojiByUnicode(0x1F1E7, 0x1F1F3)),
                new Country("BO", "Bolivia, Plurinational State of", "+591", getEmojiByUnicode(0x1F1E7, 0x1F1F4)),
                new Country("BQ", "Bonaire", "+599", getEmojiByUnicode(0x1F1E7, 0x1F1F6)),
                new Country("BR", "Brazil", "+55", getEmojiByUnicode(0x1F1E7, 0x1F1F7)),
                new Country("BS", "Bahamas", "+1", getEmojiByUnicode(0x1F1E7, 0x1F1F8)),
                new Country("BT", "Bhutan", "+975", getEmojiByUnicode(0x1F1E7, 0x1F1F9)),
                new Country("BV", "Bouvet Island", "+47", getEmojiByUnicode(0x1F1E7, 0x1F1FB)),
                new Country("BW", "Botswana", "+267", getEmojiByUnicode(0x1F1E7, 0x1F1FC)),
                new Country("BY", "Belarus", "+375", getEmojiByUnicode(0x1F1E7, 0x1F1FE)),
                new Country("BZ", "Belize", "+501", getEmojiByUnicode(0x1F1E7, 0x1F1FF)),
                new Country("CA", "Canada", "+1", getEmojiByUnicode(0x1F1E8, 0x1F1E6)),
                new Country("CC", "Cocos (Keeling) Islands", "+61", getEmojiByUnicode(0x1F1E8, 0x1F1E8)),
                new Country("CD", "Congo, The Democratic Republic of the", "+243", getEmojiByUnicode(0x1F1E8, 0x1F1E9)),
                new Country("CF", "Central African Republic", "+236", getEmojiByUnicode(0x1F1E8, 0x1F1EB)),
                new Country("CG", "Congo", "+242", getEmojiByUnicode(0x1F1E8, 0x1F1EC)),
                new Country("CH", "Switzerland", "+41", getEmojiByUnicode(0x1F1E8, 0x1F1ED)),
                new Country("CI", "Ivory Coast", "+225", getEmojiByUnicode(0x1F1E8, 0x1F1EE)),
                new Country("CK", "Cook Islands", "+682", getEmojiByUnicode(0x1F1E8, 0x1F1F0)),
                new Country("CL", "Chile", "+56", getEmojiByUnicode(0x1F1E8, 0x1F1F1)),
                new Country("CM", "Cameroon", "+237", getEmojiByUnicode(0x1F1E8, 0x1F1F2)),
                new Country("CN", "China", "+86", getEmojiByUnicode(0x1F1E8, 0x1F1F3)),
                new Country("CO", "Colombia", "+57", getEmojiByUnicode(0x1F1E8, 0x1F1F4)),
                new Country("CR", "Costa Rica", "+506", getEmojiByUnicode(0x1F1E8, 0x1F1F7)),
                new Country("CU", "Cuba", "+53", getEmojiByUnicode(0x1F1E8, 0x1F1FA)),
                new Country("CV", "Cape Verde", "+238", getEmojiByUnicode(0x1F1E8, 0x1F1FB)),
                new Country("CW", "Curacao", "+599", getEmojiByUnicode(0x1F1E8, 0x1F1FC)),
                new Country("CX", "Christmas Island", "+61", getEmojiByUnicode(0x1F1E8, 0x1F1FD)),
                new Country("CY", "Cyprus", "+357", getEmojiByUnicode(0x1F1E8, 0x1F1FE)),
                new Country("CZ", "Czech Republic", "+420", getEmojiByUnicode(0x1F1E8, 0x1F1FF)),
                new Country("DE", "Germany", "+49", getEmojiByUnicode(0x1F1E9, 0x1F1EA)),

                new Country("DJ", "Djibouti", "+253", getEmojiByUnicode(0x1F1E9, 0x1F1EF)),
                new Country("DK", "Denmark", "+45", getEmojiByUnicode(0x1F1E9, 0x1F1F0)),
                new Country("DM", "Dominica", "+1", getEmojiByUnicode(0x1F1E9, 0x1F1F2)),
                new Country("DO", "Dominican Republic", "+1", getEmojiByUnicode(0x1F1E9, 0x1F1F4)),
                new Country("DZ", "Algeria", "+213", getEmojiByUnicode(0x1F1E9, 0x1F1FF)),

                new Country("EC", "Ecuador", "+593", getEmojiByUnicode(0x1F1EA, 0x1F1E8)),
                new Country("EE", "Estonia", "+372", getEmojiByUnicode(0x1F1EA, 0x1F1EA)),
                new Country("EG", "Egypt", "+20", getEmojiByUnicode(0x1F1EA, 0x1F1EC)),
                new Country("EH", "Western Sahara", "+212", getEmojiByUnicode(0x1F1EA, 0x1F1ED)),
                new Country("ER", "Eritrea", "+291", getEmojiByUnicode(0x1F1EA, 0x1F1F7)),
                new Country("ES", "Spain", "+34", getEmojiByUnicode(0x1F1EA, 0x1F1F8)),
                new Country("ET", "Ethiopia", "+251", getEmojiByUnicode(0x1F1EA, 0x1F1F9)),

                new Country("FI", "Finland", "+358", getEmojiByUnicode(0x1F1EB, 0x1F1EE)),
                new Country("FJ", "Fiji", "+679", getEmojiByUnicode(0x1F1EB, 0x1F1EF)),
                new Country("FK", "Falkland Islands (Malvinas)", "+500", getEmojiByUnicode(0x1F1EB, 0x1F1F0)),
                new Country("FM", "Micronesia, Federated States of", "+691", getEmojiByUnicode(0x1F1EB, 0x1F1F2)),
                new Country("FO", "Faroe Islands", "+298", getEmojiByUnicode(0x1F1EB, 0x1F1F4)),
                new Country("FR", "France", "+33", getEmojiByUnicode(0x1F1EB, 0x1F1F7)),
                new Country("GA", "Gabon", "+241", getEmojiByUnicode(0x1F1EC, 0x1F1E6)),
                new Country("GB", "United Kingdom", "+44", getEmojiByUnicode(0x1F1EC, 0x1F1E7)),
                new Country("GD", "Grenada", "+1", getEmojiByUnicode(0x1F1EC, 0x1F1E9)),
                new Country("GE", "Georgia", "+995", getEmojiByUnicode(0x1F1EC, 0x1F1EA)),
                new Country("GF", "French Guiana", "+594", getEmojiByUnicode(0x1F1EC, 0x1F1EB)),
                new Country("GG", "Guernsey", "+44", getEmojiByUnicode(0x1F1EC, 0x1F1EC)),
                new Country("GH", "Ghana", "+233", getEmojiByUnicode(0x1F1EC, 0x1F1ED)),
                new Country("GI", "Gibraltar", "+350", getEmojiByUnicode(0x1F1EC, 0x1F1EE)),
                new Country("GL", "Greenland", "+299", getEmojiByUnicode(0x1F1EC, 0x1F1F1)),
                new Country("GM", "Gambia", "+220", getEmojiByUnicode(0x1F1EC, 0x1F1F2)),
                new Country("GN", "Guinea", "+224", getEmojiByUnicode(0x1F1EC, 0x1F1F3)),
                new Country("GP", "Guadeloupe", "+590", getEmojiByUnicode(0x1F1EC, 0x1F1F5)),
                new Country("GQ", "Equatorial Guinea", "+240", getEmojiByUnicode(0x1F1EC, 0x1F1F6)),
                new Country("GR", "Greece", "+30", getEmojiByUnicode(0x1F1EC, 0x1F1F7)),
                new Country("GS", "South Georgia and the South Sandwich Islands", "+500", getEmojiByUnicode(0x1F1EC, 0x1F1F8)),
                new Country("GT", "Guatemala", "+502", getEmojiByUnicode(0x1F1EC, 0x1F1F9)),
                new Country("GU", "Guam", "+1", getEmojiByUnicode(0x1F1EC, 0x1F1FA)),
                new Country("GW", "Guinea-Bissau", "+245", getEmojiByUnicode(0x1F1EC, 0x1F1FC)),
                new Country("GY", "Guyana", "+595", getEmojiByUnicode(0x1F1EC, 0x1F1FE)),
                new Country("HK", "Hong Kong", "+852", getEmojiByUnicode(0x1F1ED, 0x1F1F0)),
                new Country("HM", "Heard Island and McDonald Islands", "", getEmojiByUnicode(0x1F1ED, 0x1F1F2)),
                new Country("HN", "Honduras", "+504", getEmojiByUnicode(0x1F1ED, 0x1F1F3)),
                new Country("HR", "Croatia", "+385", getEmojiByUnicode(0x1F1ED, 0x1F1F7)),
                new Country("HT", "Haiti", "+509", getEmojiByUnicode(0x1F1ED, 0x1F1F9)),
                new Country("HU", "Hungary", "+36", getEmojiByUnicode(0x1F1ED, 0x1F1FA)),

                new Country("ID", "Indonesia", "+62", getEmojiByUnicode(0x1F1EE, 0x1F1E9)),
                new Country("IE", "Ireland", "+353", getEmojiByUnicode(0x1F1EE, 0x1F1EA)),
                new Country("IL", "Israel", "+972", getEmojiByUnicode(0x1F1EE, 0x1F1F1)),
                new Country("IM", "Isle of Man", "+44", getEmojiByUnicode(0x1F1EE, 0x1F1F2)),
                new Country("IN", "India", "+91", getEmojiByUnicode(0x1F1EE, 0x1F1F3)),
                new Country("IO", "British Indian Ocean Territory", "+246", getEmojiByUnicode(0x1F1EE, 0x1F1F4)),
                new Country("IQ", "Iraq", "+964", getEmojiByUnicode(0x1F1EE, 0x1F1F6)),
                new Country("IR", "Iran, Islamic Republic of", "+98", getEmojiByUnicode(0x1F1EE, 0x1F1F7)),
                new Country("IS", "Iceland", "+354", getEmojiByUnicode(0x1F1EE, 0x1F1F8)),
                new Country("IT", "Italy", "+39", getEmojiByUnicode(0x1F1EE, 0x1F1F9)),
                new Country("JE", "Jersey", "+44", getEmojiByUnicode(0x1F1EF, 0x1F1EA)),
                new Country("JM", "Jamaica", "+1", getEmojiByUnicode(0x1F1EF, 0x1F1F2)),
                new Country("JO", "Jordan", "+962", getEmojiByUnicode(0x1F1EF, 0x1F1F4)),
                new Country("JP", "Japan", "+81", getEmojiByUnicode(0x1F1EF, 0x1F1F5)),
                new Country("KE", "Kenya", "+254", getEmojiByUnicode(0x1F1F0, 0x1F1EA)),
                new Country("KG", "Kyrgyzstan", "+996", getEmojiByUnicode(0x1F1F0, 0x1F1EC)),
                new Country("KH", "Cambodia", "+855", getEmojiByUnicode(0x1F1F0, 0x1F1ED)),
                new Country("KI", "Kiribati", "+686", getEmojiByUnicode(0x1F1F0, 0x1F1EE)),
                new Country("KM", "Comoros", "+269", getEmojiByUnicode(0x1F1F0, 0x1F1F2)),
                new Country("KN", "Saint Kitts and Nevis", "+1", getEmojiByUnicode(0x1F1F0, 0x1F1F3)),
                new Country("KP", "North Korea", "+850", getEmojiByUnicode(0x1F1F0, 0x1F1F5)),
                new Country("KR", "South Korea", "+82", getEmojiByUnicode(0x1F1F0, 0x1F1F7)),
                new Country("KW", "Kuwait", "+965", getEmojiByUnicode(0x1F1F0, 0x1F1FC)),
                new Country("KY", "Cayman Islands", "+345", getEmojiByUnicode(0x1F1F0, 0x1F1FE)),
                new Country("KZ", "Kazakhstan", "+7", getEmojiByUnicode(0x1F1F0, 0x1F1FF)),
                new Country("LA", "Lao People's Democratic Republic", "+856", getEmojiByUnicode(0x1F1F1, 0x1F1E6)),
                new Country("LB", "Lebanon", "+961", getEmojiByUnicode(0x1F1F1, 0x1F1E7)),
                new Country("LC", "Saint Lucia", "+1", getEmojiByUnicode(0x1F1F1, 0x1F1E8)),
                new Country("LI", "Liechtenstein", "+423", getEmojiByUnicode(0x1F1F1, 0x1F1EE)),
                new Country("LK", "Sri Lanka", "+94", getEmojiByUnicode(0x1F1F1, 0x1F1F0)),
                new Country("LR", "Liberia", "+231", getEmojiByUnicode(0x1F1F1, 0x1F1F7)),
                new Country("LS", "Lesotho", "+266", getEmojiByUnicode(0x1F1F1, 0x1F1F8)),
                new Country("LT", "Lithuania", "+370", getEmojiByUnicode(0x1F1F1, 0x1F1F9)),
                new Country("LU", "Luxembourg", "+352", getEmojiByUnicode(0x1F1F1, 0x1F1FA)),
                new Country("LV", "Latvia", "+371", getEmojiByUnicode(0x1F1F1, 0x1F1FB)),
                new Country("LY", "Libyan Arab Jamahiriya", "+218", getEmojiByUnicode(0x1F1F1, 0x1F1FE)),
                new Country("MA", "Morocco", "+212", getEmojiByUnicode(0x1F1F2, 0x1F1E6)),
                new Country("MC", "Monaco", "+377", getEmojiByUnicode(0x1F1F2, 0x1F1E8)),
                new Country("MD", "Moldova, Republic of", "+373", getEmojiByUnicode(0x1F1F2, 0x1F1E9)),
                new Country("ME", "Montenegro", "+382", getEmojiByUnicode(0x1F1F2, 0x1F1EA)),
                new Country("MF", "Saint Martin", "+590", getEmojiByUnicode(0x1F1F2, 0x1F1EB)),
                new Country("MG", "Madagascar", "+261", getEmojiByUnicode(0x1F1F2, 0x1F1EC)),
                new Country("MH", "Marshall Islands", "+692", getEmojiByUnicode(0x1F1F2, 0x1F1ED)),
                new Country("MK", "Macedonia, The Former Yugoslav Republic of", "+389", getEmojiByUnicode(0x1F1F2, 0x1F1F0)),
                new Country("ML", "Mali", "+223", getEmojiByUnicode(0x1F1F2, 0x1F1F1)),
                new Country("MM", "Myanmar", "+95", getEmojiByUnicode(0x1F1F2, 0x1F1F2)),
                new Country("MN", "Mongolia", "+976", getEmojiByUnicode(0x1F1F2, 0x1F1F3)),
                new Country("MO", "Macao", "+853", getEmojiByUnicode(0x1F1F2, 0x1F1F4)),
                new Country("MP", "Northern Mariana Islands", "+1", getEmojiByUnicode(0x1F1F2, 0x1F1F5)),
                new Country("MQ", "Martinique", "+596", getEmojiByUnicode(0x1F1F2, 0x1F1F6)),
                new Country("MR", "Mauritania", "+222", getEmojiByUnicode(0x1F1F2, 0x1F1F7)),
                new Country("MS", "Montserrat", "+1", getEmojiByUnicode(0x1F1F2, 0x1F1F8)),
                new Country("MT", "Malta", "+356", getEmojiByUnicode(0x1F1F2, 0x1F1F9)),
                new Country("MU", "Mauritius", "+230", getEmojiByUnicode(0x1F1F2, 0x1F1FA)),
                new Country("MV", "Maldives", "+960", getEmojiByUnicode(0x1F1F2, 0x1F1FB)),
                new Country("MW", "Malawi", "+265", getEmojiByUnicode(0x1F1F2, 0x1F1FC)),
                new Country("MX", "Mexico", "+52", getEmojiByUnicode(0x1F1F2, 0x1F1FD)),
                new Country("MY", "Malaysia", "+60", getEmojiByUnicode(0x1F1F2, 0x1F1FE)),
                new Country("MZ", "Mozambique", "+258", getEmojiByUnicode(0x1F1F2, 0x1F1FF)),
                new Country("NA", "Namibia", "+264", getEmojiByUnicode(0x1F1F3, 0x1F1E6)),
                new Country("NC", "New Caledonia", "+687", getEmojiByUnicode(0x1F1F3, 0x1F1E8)),
                new Country("NE", "Niger", "+227", getEmojiByUnicode(0x1F1F3, 0x1F1EA)),
                new Country("NF", "Norfolk Island", "+672", getEmojiByUnicode(0x1F1F3, 0x1F1EB)),
                new Country("NG", "Nigeria", "+234", getEmojiByUnicode(0x1F1F3, 0x1F1EC)),
                new Country("NI", "Nicaragua", "+505", getEmojiByUnicode(0x1F1F3, 0x1F1EE)),
                new Country("NL", "Netherlands", "+31", getEmojiByUnicode(0x1F1F3, 0x1F1F1)),
                new Country("NO", "Norway", "+47", getEmojiByUnicode(0x1F1F3, 0x1F1F4)),
                new Country("NP", "Nepal", "+977", getEmojiByUnicode(0x1F1F3, 0x1F1F5)),
                new Country("NR", "Nauru", "+674", getEmojiByUnicode(0x1F1F3, 0x1F1F7)),
                new Country("NU", "Niue", "+683", getEmojiByUnicode(0x1F1F3, 0x1F1FA)),
                new Country("NZ", "New Zealand", "+64", getEmojiByUnicode(0x1F1F3, 0x1F1FF)),
                new Country("OM", "Oman", "+968", getEmojiByUnicode(0x1F1F4, 0x1F1F2)),
                new Country("PA", "Panama", "+507", getEmojiByUnicode(0x1F1F5, 0x1F1E6)),
                new Country("PE", "Peru", "+51", getEmojiByUnicode(0x1F1F5, 0x1F1EA)),
                new Country("PF", "French Polynesia", "+689", getEmojiByUnicode(0x1F1F5, 0x1F1EB)),
                new Country("PG", "Papua New Guinea", "+675", getEmojiByUnicode(0x1F1F5, 0x1F1EC)),
                new Country("PH", "Philippines", "+63", getEmojiByUnicode(0x1F1F5, 0x1F1ED)),
                new Country("PK", "Pakistan", "+92", getEmojiByUnicode(0x1F1F5, 0x1F1F0)),
                new Country("PL", "Poland", "+48", getEmojiByUnicode(0x1F1F5, 0x1F1F1)),
                new Country("PM", "Saint Pierre and Miquelon", "+508", getEmojiByUnicode(0x1F1F5, 0x1F1F2)),
                new Country("PN", "Pitcairn", "+872", getEmojiByUnicode(0x1F1F5, 0x1F1F3)),
                new Country("PR", "Puerto Rico", "+1", getEmojiByUnicode(0x1F1F5, 0x1F1F7)),
                new Country("PS", "Palestinian Territory, Occupied", "+970", getEmojiByUnicode(0x1F1F5, 0x1F1F8)),
                new Country("PT", "Portugal", "+351", getEmojiByUnicode(0x1F1F5, 0x1F1F9)),
                new Country("PW", "Palau", "+680", getEmojiByUnicode(0x1F1F5, 0x1F1FC)),
                new Country("PY", "Paraguay", "+595", getEmojiByUnicode(0x1F1F5, 0x1F1FE)),
                new Country("QA", "Qatar", "+974", getEmojiByUnicode(0x1F1F6, 0x1F1E6)),
                new Country("RE", "Réunion", "+262", getEmojiByUnicode(0x1F1F7, 0x1F1EA)),
                new Country("RO", "Romania", "+40", getEmojiByUnicode(0x1F1F7, 0x1F1F4)),
                new Country("RS", "Serbia", "+381", getEmojiByUnicode(0x1F1F7, 0x1F1F8)),
                new Country("RU", "Russia", "+7", getEmojiByUnicode(0x1F1F7, 0x1F1FA)),
                new Country("RW", "Rwanda", "+250", getEmojiByUnicode(0x1F1F7, 0x1F1FC)),
                new Country("SA", "Saudi Arabia", "+966", getEmojiByUnicode(0x1F1F8, 0x1F1E6)),
                new Country("SB", "Solomon Islands", "+677", getEmojiByUnicode(0x1F1F8, 0x1F1E7)),
                new Country("SC", "Seychelles", "+248", getEmojiByUnicode(0x1F1F8, 0x1F1E8)),
                new Country("SD", "Sudan", "+249", getEmojiByUnicode(0x1F1F8, 0x1F1E9)),
                new Country("SE", "Sweden", "+46", getEmojiByUnicode(0x1F1F8, 0x1F1EA)),
                new Country("SG", "Singapore", "+65", getEmojiByUnicode(0x1F1F8, 0x1F1EC)),
                new Country("SH", "Saint Helena, Ascension and Tristan Da Cunha", "+290", getEmojiByUnicode(0x1F1F8, 0x1F1ED)),
                new Country("SI", "Slovenia", "+386", getEmojiByUnicode(0x1F1F8, 0x1F1EE)),
                new Country("SJ", "Svalbard and Jan Mayen", "+47", getEmojiByUnicode(0x1F1F8, 0x1F1EF)),
                new Country("SK", "Slovakia", "+421", getEmojiByUnicode(0x1F1F8, 0x1F1F0)),
                new Country("SL", "Sierra Leone", "+232", getEmojiByUnicode(0x1F1F8, 0x1F1F1)),
                new Country("SM", "San Marino", "+378", getEmojiByUnicode(0x1F1F8, 0x1F1F2)),
                new Country("SN", "Senegal", "+221", getEmojiByUnicode(0x1F1F8, 0x1F1F3)),
                new Country("SO", "Somalia", "+252", getEmojiByUnicode(0x1F1F8, 0x1F1F4)),
                new Country("SR", "Suriname", "+597", getEmojiByUnicode(0x1F1F8, 0x1F1F7)),
                new Country("SS", "South Sudan", "+211", getEmojiByUnicode(0x1F1F8, 0x1F1F8)),
                new Country("ST", "Sao Tome and Principe", "+239", getEmojiByUnicode(0x1F1F8, 0x1F1F9)),
                new Country("SV", "El Salvador", "+503", getEmojiByUnicode(0x1F1F8, 0x1F1FB)),
                new Country("SX", "Sint Maarten", "+1", getEmojiByUnicode(0x1F1F8, 0x1F1FD)),
                new Country("SY", "Syrian Arab Republic", "+963", getEmojiByUnicode(0x1F1F8, 0x1F1FE)),
                new Country("SZ", "Swaziland", "+268", getEmojiByUnicode(0x1F1F8, 0x1F1FF)),

                new Country("TC", "Turks and Caicos Islands", "+1", getEmojiByUnicode(0x1F1F9, 0x1F1E8)),
                new Country("TD", "Chad", "+235", getEmojiByUnicode(0x1F1F9, 0x1F1E9)),
                new Country("TF", "French Southern Territories", "+262", getEmojiByUnicode(0x1F1F9, 0x1F1EB)),
                new Country("TG", "Togo", "+228", getEmojiByUnicode(0x1F1F9, 0x1F1EC)),
                new Country("TH", "Thailand", "+66", getEmojiByUnicode(0x1F1F9, 0x1F1ED)),
                new Country("TJ", "Tajikistan", "+992", getEmojiByUnicode(0x1F1F9, 0x1F1EF)),
                new Country("TK", "Tokelau", "+690", getEmojiByUnicode(0x1F1F9, 0x1F1F0)),
                new Country("TL", "East Timor", "+670", getEmojiByUnicode(0x1F1F9, 0x1F1F1)),
                new Country("TM", "Turkmenistan", "+993", getEmojiByUnicode(0x1F1F9, 0x1F1F2)),
                new Country("TN", "Tunisia", "+216", getEmojiByUnicode(0x1F1F9, 0x1F1F3)),
                new Country("TO", "Tonga", "+676", getEmojiByUnicode(0x1F1F9, 0x1F1F4)),
                new Country("TR", "Turkey", "+90", getEmojiByUnicode(0x1F1F9, 0x1F1F7)),
                new Country("TT", "Trinidad and Tobago", "+1", getEmojiByUnicode(0x1F1F9, 0x1F1F9)),
                new Country("TV", "Tuvalu", "+688", getEmojiByUnicode(0x1F1F9, 0x1F1FB)),
                new Country("TW", "Taiwan", "+886", getEmojiByUnicode(0x1F1F9, 0x1F1FC)),
                new Country("TZ", "Tanzania, United Republic of", "+255", getEmojiByUnicode(0x1F1F9, 0x1F1FF)),
                new Country("UA", "Ukraine", "+380", getEmojiByUnicode(0x1F1FA, 0x1F1E6)),
                new Country("UG", "Uganda", "+256", getEmojiByUnicode(0x1F1FA, 0x1F1EC)),
                new Country("UM", "U.S. Minor Outlying Islands", "", getEmojiByUnicode(0x1F1FA, 0x1F1F2)),
                new Country("US", "United States", "+1", getEmojiByUnicode(0x1F1FA, 0x1F1F8)),
                new Country("UY", "Uruguay", "+598", getEmojiByUnicode(0x1F1FA, 0x1F1FE)),
                new Country("UZ", "Uzbekistan", "+998", getEmojiByUnicode(0x1F1FA, 0x1F1FF)),
                new Country("VA", "Holy See (Vatican City State)", "+379", getEmojiByUnicode(0x1F1FB, 0x1F1E6)),
                new Country("VC", "Saint Vincent and the Grenadines", "+1", getEmojiByUnicode(0x1F1FB, 0x1F1E8)),
                new Country("VE", "Venezuela, Bolivarian Republic of", "+58", getEmojiByUnicode(0x1F1FB, 0x1F1EA)),
                new Country("VG", "Virgin Islands, British", "+1", getEmojiByUnicode(0x1F1FB, 0x1F1EC)),
                new Country("VI", "Virgin Islands, U.S.", "+1", getEmojiByUnicode(0x1F1FB, 0x1F1EE)),
                new Country("VN", "Viet Nam", "+84", getEmojiByUnicode(0x1F1FB, 0x1F1F3)),
                new Country("VU", "Vanuatu", "+678", getEmojiByUnicode(0x1F1FB, 0x1F1FA)),
                new Country("WF", "Wallis and Futuna", "+681", getEmojiByUnicode(0x1F1FC, 0x1F1EB)),
                new Country("WS", "Samoa", "+685", getEmojiByUnicode(0x1F1FC, 0x1F1F8)),
                new Country("XK", "Kosovo", "+383", getEmojiByUnicode(0x1F1FD, 0x1F1F0)),
                new Country("YE", "Yemen", "+967", getEmojiByUnicode(0x1F1FE, 0x1F1EA)),
                new Country("YT", "Mayotte", "+262", getEmojiByUnicode(0x1F1FE, 0x1F1F9)),
                new Country("ZA", "South Africa", "+27", getEmojiByUnicode(0x1F1FF, 0x1F1E6)),
                new Country("ZM", "Zambia", "+260", getEmojiByUnicode(0x1F1FF, 0x1F1F2)),
                new Country("ZW", "Zimbabwe", "+263", getEmojiByUnicode(0x1F1FF, 0x1F1FC)),
        };

        return Arrays.asList(COUNTRIES);
    }

    public String getEmojiByUnicode(int unicode1, int unicode2) {
        return new String(Character.toChars(unicode1)) + new String(Character.toChars(unicode2));
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}