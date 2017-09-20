package crypto.util;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by tanerali on 27/08/2017.
 */
@Component
public class DateUnix {

    //Taner
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
    public static String currentTimeToString(){

        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy  HH:mm:ss");

        df.setCalendar(calendar);

        String time = df.format(calendar.getTime());

        return time;
    }

    /**
     * @author
     * @return Changes the current datetime to unix timestamp
     */
    public static long currentTimeToSecs(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        Date curDate;

        long currentSecs = 0;

        currentSecs = date.getTime()/1000;

        return currentSecs;

    }

    /**
     * @author Nicola
     * @return The unix timestamp for one hour in the past
     */
    public static long oneHourInPastInSecs(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        Date curDate;

        long currentSecs = 0;

        currentSecs = date.getTime()/1000;
        //3600
        long oneHourInPast = currentSecs-345600;

        return oneHourInPast;

    }

    /**
     * @author Nicola
     * @return The unix timestamp for one day in the past.
     */
    public static long oneDayInPastInSecs(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        Date curDate;

        long currentSecs = 0;

        currentSecs = date.getTime()/1000;

        long oneHourInPast = currentSecs-86400;

        return oneHourInPast;

    }

    /**
     * @author Nicola
     * @return The unix timestamp for one week in the past.
     */
    public static long oneWeekInPastInSecs(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        Date curDate;

        long currentSecs = 0;

        currentSecs = date.getTime()/1000;
        long oneHourInPast = currentSecs-604800;

        return oneHourInPast;

    }
}

