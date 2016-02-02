package com.boya.commons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class TimeUitls {
    // Variable 'sd' must be private and have accessor methods.
    private static SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static SimpleDateFormat sd2 = new SimpleDateFormat("yy年MM月dd日");
    private static SimpleDateFormat sdTime = new SimpleDateFormat("HH:mm");

    private TimeUitls() {

    }

    public static String formatTime(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(time);
        String sDateTime = sdf.format(date);
        return sDateTime;
    }

    public static long formatDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long l = System.currentTimeMillis();
        try {
            l = sdf.parse(date).getTime();
        } catch (ParseException e) {
        }
        return l;
    }

    public static String getInterval(long target) {
        long currentSeconds = System.currentTimeMillis();
        long timeGap = (currentSeconds - target) / 1000;//与现在时间相差秒数
        String timeStr = null;
        if (timeGap >= 24 * 60 * 60) {//1天以上
            timeStr = timeGap / (24 * 60 * 60) + "天前";
            if (timeGap / (24 * 60 * 60) == 1) {
                timeStr = "昨天 " + sdTime.format(new Date(target));
            }
            if (timeGap / (24 * 60 * 60) == 2) {
                timeStr = "前天 " + sdTime.format(new Date(target));
            }
            if (timeGap / (24 * 60 * 60) > 10) {
                //timeStr =
                timeStr = sd2.format(new Date(target));
            }
        } else if (timeGap > 60 * 60) {//1小时-24小时
            timeStr = timeGap / (60 * 60) + "小时前";
        } else if (timeGap > 60) {//1分钟-59分钟
            timeStr = timeGap / 60 + "分钟前";
        } else {//1秒钟-59秒钟
            timeStr = "刚刚";
        }
        return timeStr;

    }

    public static String gap(long createtime) {
        String interval = null;
        // Date().getTime()减去以前的时间距离1970年的时间间隔d1.getTime()得出的就是以前的时间与现在时间的时间间隔
        long time = new Date().getTime() - createtime;// 得出的时间间隔是毫秒
        if (time / 1000 < 10 && time / 1000 >= 0) {
            // 如果时间间隔小于10秒则显示“刚刚”time/10得出的时间间隔的单位是秒
            interval = "刚刚";

        } else if (time / 3600000 < 24 && time / 3600000 > 0) {
            // 如果时间间隔小于24小时则显示多少小时前
            int h = (int) (time / 3600000);// 得出的时间间隔的单位是小时
            interval = h + "小时前";

        } else if (time / 60000 < 60 && time / 60000 > 0) {
            // 如果时间间隔小于60分钟则显示多少分钟前
            int m = (int) ((time % 3600000) / 60000);// 得出的时间间隔的单位是分钟
            interval = m + "分钟前";

        } else if (time / 1000 < 60 && time / 1000 > 0) {
            // 如果时间间隔小于60秒则显示多少秒前
            int se = (int) ((time % 60000) / 1000);
            interval = se + "秒前";

        } else if (time / 3600000 >= 24 && time / 3600000 < 48) {
            // 大于24小时，则显示正常的时间，但是不显示秒
            interval = "昨天";

        } else if (time / 3600000 > 24 && time / 3600000 <= 48) {
            // 大于24小时，则显示正常的时间，但是不显示秒
            interval = "前天";

        } else {
            Date d2 = new Date(createtime);
            interval = sd.format(d2);
        }
        return interval;
    }
}
