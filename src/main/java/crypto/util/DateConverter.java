package crypto.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by aaron on 8/26/17.
 */
public class DateConverter {

    public String currentTimeToString(){

        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy  HH:mm:ss");

        df.setCalendar(calendar);

        String time = df.format(calendar.getTime());

        return time;
    }

}
