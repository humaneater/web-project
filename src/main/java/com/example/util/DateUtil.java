package com.example.util;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: peng.c.zhang
 * @DATE: 2021/2/24 11:36
 */
public class DateUtil {
    public static final String YEAR_MONTH_DAY = "YYYY-MM-dd";
    public static final String HOUR_MIN_SEC = "HH-mm-ss";

    public static String dateFormat(Date date, String pattern) {
        return DateFormatUtils.format(date, pattern);
    }
}
