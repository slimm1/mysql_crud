package control;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * * @author Martin Ramonda
 */
public class Utilities {
    public static LocalDateTime getLocalDateTimeFrom(Date date, String time){
        System.out.println(time);
        String pattern = "yyyy-MM-dd";
        DateFormat formater = new SimpleDateFormat(pattern);
        String dateString = formater.format(date);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateString+" "+time+":00", formatter);
        return dateTime;
    }
}
