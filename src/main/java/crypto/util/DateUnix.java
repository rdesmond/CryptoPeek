package crypto.util;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by tanerali on 27/08/2017.
 * Used for converting dates from/to Unix time and for other
 * things related to dates and time
 */
@Component
public class DateUnix {

    //Taner
    //converts time in seconds from parameter to MM/dd/yyyy HH:mm:ss format
    public static String secondsToSpecificTime (long timeInSecs) {

//        Date dateOb = new Date(timeInSecs*1000);

        Calendar calendarOb = new GregorianCalendar();
        calendarOb.setTimeInMillis(timeInSecs*1000);

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        df.setCalendar(calendarOb);

        String time = df.format(calendarOb.getTime());

        return time;
    }

    //Aaron
    //returns String that contains current time in yyyy-MM-dd  HH:mm:ss format
    public static String currentTimeToString(){

        Calendar calendar = Calendar.getInstance();

        //this specific format necessary if DATETIME data type going to
        //be used in MySQL DB
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");

        df.setCalendar(calendar);

        String time = df.format(calendar.getTime());

        return time;
    }

    // Author: Nicola
    public static long currentTimeToSecs(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        Date curDate;

        long currentSecs = 0;

        currentSecs = date.getTime()/1000;

        return currentSecs;

    }

    //Taner
    public static long toPreviousWholeMinute() {
        Date date = new Date();

        Calendar calendar = new GregorianCalendar();

        calendar.setTime(date);

        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);

        System.out.println(calendar.getTimeInMillis()/1000);

        return calendar.getTimeInMillis()/1000;
    }

    public static long toPreviousWholeHour() {
        Date date = new Date();

        Calendar calendar = new GregorianCalendar();

        calendar.setTime(date);

        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);

        System.out.println(calendar.getTimeInMillis()/1000);

        return calendar.getTimeInMillis()/1000;
    }

    public static long toPreviousWholeDay() {
        Date date = new Date();

        Calendar calendar = new GregorianCalendar();

        calendar.setTime(date);

        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        calendar.set(Calendar.AM_PM, Calendar.AM);
        calendar.set(Calendar.ZONE_OFFSET, 0);
        calendar.set(Calendar.DST_OFFSET, 0);
        calendar.set(Calendar.HOUR, 0);


        System.out.println(calendar.getTimeInMillis()/1000);

        return calendar.getTimeInMillis()/1000;
    }
}

