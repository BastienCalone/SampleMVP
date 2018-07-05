package com.calone.vpgilt.Utils;

import android.text.format.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by babas on 03/07/18.
 */

public class DateFormatUtils {

    public static String getFormatedDate(String unformated) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.FRANCE);
        try {
            Date date = sdf.parse(unformated);
            return DateFormat.format("EEEE", date) + " " + DateFormat.format("dd", date)
                    + " " + DateFormat.format("MMM", date) + " à " + DateFormat.format("HH", date)
                    + ":" + DateFormat.format("mm", date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static String getConcatenedDate(String dateBegin, String dateEnd) {
        return DateFormatUtils.getFormatedDate(dateBegin) + " - "
                + DateFormatUtils.getFormatedDate(dateEnd);
    }
}
