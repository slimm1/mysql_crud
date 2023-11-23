/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author Martin Ramonda
 */
public class App_Constants {
    public static String connectString = "jdbc:mariadb://localhost:3306/";
    public static String dbUser= "root";
    public static String dbPass = "slimm1";
    public static String dbName = "app_data";
    public static String newDbConnection = "jdbc:mariadb://localhost:3306/";
    
    public static void setCurrentDb(String currentDb){
        dbName = currentDb;
    }
}
