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
    public void connectDb(){
        try {
            Connection c = DriverManager.getConnection(App_Constants.connectString+"information_schema","root","slimm1");
            DatabaseMetaData metaData = c.getMetaData();
            System.out.println(metaData.getDriverName());
            Statement stmt = c.createStatement();
            //Retrieving the data
            ResultSet rs = stmt.executeQuery("Show tables");
            System.out.println("Tables in the current database: ");
            while(rs.next()) {
            System.out.print(rs.getString(1));
            System.out.println();
      }
        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
