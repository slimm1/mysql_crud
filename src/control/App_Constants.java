package control;

import java.util.regex.Pattern;

/**
 * @author Martin Ramonda
 * Clase con variables constantes para esta aplicación.
 */
public class App_Constants {
    public static String connectString = "jdbc:mariadb://localhost:3306/";
    public static String dbUser= "root";
    public static String dbPass = "slimm1";
    public static String dbName = "app_data";
    public static String newDbConnection = "jdbc:mariadb://localhost:3306/";
    public static String[] showGenres = {"<null>","Musical","Comedia","Drama","Monólogo","Tragedia"};
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
}
