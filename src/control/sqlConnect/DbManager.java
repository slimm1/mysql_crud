/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control.sqlConnect;

import control.App_Constants;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DatabaseMetaData;

/**
 * @author Martin Ramonda
 */
public class DbManager {
    
    private Connection conn;
    
    public DbManager(){
        this.conn = connectDb();
    }
    
    private Connection connectDb(){
        try {
            Connection c = DriverManager.getConnection(App_Constants.connectString+App_Constants.dbName,App_Constants.dbUser,App_Constants.dbPass);
            System.out.println("connected");
            /*Statement stmt = c.createStatement();
            //Retrieving the data
            ResultSet rs = stmt.executeQuery("Show tables");
            System.out.println("Tables in the current database: ");
            while (rs.next()) {
                System.out.print(rs.getString(1));
                System.out.println();
            }*/
            return c;
        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
