package tools.com.hellolibrary.hello_date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 2016年5月23日 by lee for：
 */
public class DateUtil {
    private static Calendar cl = Calendar.getInstance();
    @NonNull
    private static DecimalFormat mFormat = new DecimalFormat("00");

    /**
     * @return 获取年
     */
    @NonNull
    public static String getCurYear() {
        return "" + cl.get(Calendar.YEAR);
    }

    /**
     * @return 获取月
     */
    public static String getCurMonth() {
        return mFormat.format(cl.get(Calendar.MONTH) + 1);
    }

    /**
     * @return 获取日
     */
    public static String getCurDay() {
        return mFormat.format(cl.get(Calendar.DAY_OF_MONTH));
    }

    /**
     * @return 获取时
     */
    public static String getCurHour() {
        return mFormat.format(cl.get(Calendar.HOUR_OF_DAY));
    }

    /**
     * @return 获取分
     */
    public static String getCurMinue() {
        return mFormat.format(cl.get(Calendar.MINUTE));
    }

    /**
     * @return 获取秒
     */
    public static String getCurSeconds() {
        return mFormat.format(cl.get(Calendar.SECOND));
    }

    /**
     * 格式化当前日期和时间并且输出
     * such as :DateUtil.getCurDTByPattern("/", " ", ":")
     * output:2016/05/23 13:38:15
     *
     * @param datePattern
     * @param middlePattern
     * @param timePattern
     * @return
     */
    @NonNull
    public static String getCurDateTimeByPattern(String datePattern,
                                                 String middlePattern, String timePattern) {
        return getCurDateByPattern(datePattern) + middlePattern + getCurTimeByPattern(timePattern);
    }

    /**
     * 格式化当期那日期
     * such as: DateUtil.getCurDateByPattern(":")
     * output :2016:05:23
     *
     * @param datePattern
     * @return
     */
    @NonNull
    public static String getCurDateByPattern(String datePattern) {
        return "" + getCurYear() + datePattern + getCurMonth() + datePattern
                + getCurDay();
    }

    /**
     * 格式化当前的时间
     * such as: DateUtil.getCurTimeByPattern(":")
     * output :13:44:35
     *
     * @param timePattern
     * @return
     */
    @NonNull
    public static String getCurTimeByPattern(String timePattern) {
        return "" + getCurHour() + timePattern + getCurMinue() + timePattern + getCurSeconds();
    }


    /**
     * 通过年月日获取时间毫秒值
     * such as 2016-05-15;
     * return ;
     *
     * @param
     * @return
     */
    public static long getTimeMilli(String year, String month, String day) {
        Date date = new Date(Integer.valueOf(year), Integer.valueOf(month) - 1, Integer.valueOf(day));
        return date.getTime();
    }

    /**
     * 通过年月日时分获取毫秒值
     *
     * @param year
     * @param month
     * @param day
     * @param hour
     * @param minute
     * @return
     */
    public static long getTimeMilli(String year, String month, String day, String hour, String minute) {
        Date date = new Date(Integer.valueOf(year), Integer.valueOf(month) - 1, Integer.valueOf(day), Integer.valueOf(hour), Integer.valueOf(minute));
        return date.getTime();
    }


    /**
     * 通过年月日时分秒获取毫秒值
     *
     * @param year
     * @param month
     * @param day
     * @param hour
     * @param minute
     * @param seconds
     * @return
     */
    public static long getTimeMilli(String year, String month, String day, String hour, String minute, String seconds) {
        Date date = new Date(Integer.valueOf(year), Integer.valueOf(month) - 1, Integer.valueOf(day), Integer.valueOf(hour), Integer.valueOf(minute), Integer.valueOf(seconds));
        return date.getTime();
    }

    @NonNull
    public static int[] getTimeByMilli(long pTimeMilli) {
        Calendar lCalendar = Calendar.getInstance();
        lCalendar.setTimeInMillis(pTimeMilli);
        int year = lCalendar.get(Calendar.YEAR);
        int month = lCalendar.get(Calendar.MONTH) + 1;
        int day = lCalendar.get(Calendar.DAY_OF_MONTH);
        int hour = lCalendar.get(Calendar.HOUR_OF_DAY);
        int minute = lCalendar.get(Calendar.MINUTE);
        int second = lCalendar.get(Calendar.SECOND);
        return new int[]{year, month, day, hour, minute, second};
    }

    public static String getDateByMilli(long pTimeMilli) {
        int infos[] = getTimeByMilli(pTimeMilli);
        String year = infos[0] + "";
        String month = infos[1] + "";
        String day = infos[2] + "";
        String hour = infos[3] + "";
        String minue = infos[4] + "";
        String second = infos[5] + "";
        return year.concat("-").concat(month).concat("-").concat(day)
                .concat(" ").concat(hour).concat(":").concat(minue).concat(":").concat(second);
    }

    /**
     * 功能描述：格式化输出日期
     *
     * @param date
     *            Date 日期
     * @param format
     *            String 格式
     * @return 返回字符型日期
     */
    public static String format(@Nullable Date date, @NonNull String format) {
        String result = "";
        try {
            if (date != null) {
                DateFormat dateFormat = new SimpleDateFormat(format);
                result = dateFormat.format(date);
            }
        } catch (Exception e) {

        }
        return result;
    }

    /**
     * 功能描述：返回字符型日期时间
     *
     * @param date
     *            Date 日期
     * @return 返回字符型日期时间 yyyy-MM-dd HH:mm:ss 格式
     */
    public static String getDateTime(Date date) {
        return format(date, "yyyy-MM-dd HH:mm:ss");
    }
}
