package crypto.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by tanerali on 27/08/2017.
 * Used for converting dates from/to Unix time and for other
 * things related to dates and time
 */
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
}
