package control;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * * @author Martin Ramonda
 * Clase con utilidades para conversiones de fechas.
 */
public class DateTimeUtilities {
    
    //Convierte un objeto date y un string que representa la hora a un objeto localdatetime. 
    //Útil para la extracción de los campos del formulario.
    public static LocalDateTime getLocalDateTimeFrom(Date date, String time){
        String pattern = "yyyy-MM-dd";
        DateFormat formater = new SimpleDateFormat(pattern);
        String dateString = formater.format(date);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateString+" "+time+":00", formatter);
        return dateTime;
    }
    
    // extrae la fecha en forma de Date desde un objeto LocalDateTime
    public static Date getDateFromLocalDT(LocalDateTime ldt){
        return Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
    }
    
    //extrae el tiempo en forma de String desde un objeto de la clase LocalDateTime
    public static String extractTimeFromLDT(LocalDateTime ldt){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return ldt.format(formatter);
    }
    
    //obtiene un String que es la fecha y hora formateadas de un objeto LocalDateTime
    public static String getFormatedDateTime(LocalDateTime date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm");
        return date.format(formatter);
    }
    
    //Da formato en forma de String a un objeto Date.
    public static String getFormatedDate(Date d){
        SimpleDateFormat formater = new SimpleDateFormat("dd MMM yyyy");
        return formater.format(d);
    }
}
