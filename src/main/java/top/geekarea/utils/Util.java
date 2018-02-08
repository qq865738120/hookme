package top.geekarea.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 公共工具类
 */
public class Util {

    /**
     * 计算时间差，返回天数
     * @param fromDate 开始时间
     * @param toDate 结束时间
     * @param dateFormat 时间格式
     * @return
     */
    public static int timeDifferenceForDay(Date fromDate, String toDate, String dateFormat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        try {
            long from = fromDate.getTime();
            long to = simpleDateFormat.parse(toDate).getTime();
            return (int) ((to - from)/(1000 * 60 * 60 * 24));
        }catch (Exception e) {
            e.getLocalizedMessage();
        }
        return -1;
    }

    /**
     * 计算时间差，返回小时数
     * @param fromDate 开始时间
     * @param toDate 结束时间
     * @param dateFormat 时间格式
     * @return
     */
    public static int timeDifferenceForHour(Date fromDate, String toDate, String dateFormat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        try {
            long from = fromDate.getTime();
            long to = simpleDateFormat.parse(toDate).getTime();
            return (int) ((to - from)/(1000 * 60 * 60));
        }catch (Exception e) {
            e.getLocalizedMessage();
        }
        return -1;
    }

//    public static int toNowDifferenceForDay(String fromDate, Date toDate, String dateFormat) {
//
//    }
}
