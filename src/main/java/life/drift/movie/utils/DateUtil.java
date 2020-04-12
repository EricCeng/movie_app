package life.drift.movie.utils;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

public class DateUtil {
    public static final String STANDARD = "yyyy-MM-dd HH:mm:ss";

    //字符串转date
    public static Date string2Date(String strDate) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(STANDARD);
        DateTime dateTime = dateTimeFormatter.parseDateTime(strDate);
        return dateTime.toDate();
    }

    public static Date string2Date(String strDate, String format) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(format);
        DateTime dateTime = dateTimeFormatter.parseDateTime(strDate);
        return dateTime.toDate();
    }

    //date转字符串

    public static String date2String(Date date) {
        if (date == null) {
            return StringUtils.EMPTY;
        }

        DateTime dateTime = new DateTime(date);
        return dateTime.toString(STANDARD);
    }
}
