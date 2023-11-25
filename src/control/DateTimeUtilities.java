package control;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * * @author Martin Ramonda
 */
public class DateTimeUtilities {
    
    public static LocalDateTime getLocalDateTimeFrom(Date date, String time){
        String pattern = "yyyy-MM-dd";
        DateFormat formater = new SimpleDateFormat(pattern);
        String dateString = formater.format(date);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateString+" "+time+":00", formatter);
        return dateTime;
    }
    
    public static Date getDateFromLocalDT(LocalDateTime ldt){
        return Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
    }
    
    public static String extractTimeFromLDT(LocalDateTime ldt){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return ldt.format(formatter);
    }
    
    public static String getFormatedDateTime(LocalDateTime date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm");
        return date.format(formatter);
    }
    
    public static String getFormatedDate(Date d){
        SimpleDateFormat formater = new SimpleDateFormat("dd MMM yyyy");
        return formater.format(d);
    }
}
