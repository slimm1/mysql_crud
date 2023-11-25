package control.sqlConnect;

import control.App_Constants;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Show;
import model.User;
/**
 * @author Martin Ramonda
 */
public class DbManager {
    
    private Connection conn;
    
    public DbManager(){
        this.conn = connectDb();
        if(conn == null){
            createDb();          
        }
    }
    
    public Connection connectDb(){
        try {
            Connection c = DriverManager.getConnection(App_Constants.connectString+App_Constants.dbName,App_Constants.dbUser,App_Constants.dbPass);
            return c;
        } catch (SQLException ex) {
            return null;
        }
    }

    private void createDb() {
        try {
            this.conn = DriverManager.getConnection(App_Constants.newDbConnection,App_Constants.dbUser,App_Constants.dbPass);
            Statement create = conn.createStatement();
            create.executeUpdate("CREATE DATABASE app_data;");
            this.conn = connectDb();
            runCreationScript();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "SQLEXCEPTION", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void runCreationScript(){
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("CREATE OR REPLACE TABLE user_"
                    + "(user_id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,user_name VARCHAR(20) NOT NULL,"
                    + "user_pass VARCHAR(50) NOT NULL,user_email VARCHAR(50) NOT NULL,birthDate DATE NOT NULL,"
                    + "upcoming_show INT UNSIGNED);");
            st.executeUpdate("CREATE OR REPLACE TABLE show_"
                    + "(show_id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,show_name VARCHAR(50) NOT NULL,"
                    + "show_datetime DATETIME NOT NULL,"
                    + "genre VARCHAR(20));");
            st.execute("ALTER TABLE user_ ADD CONSTRAINT fk_user_show FOREIGN KEY(upcoming_show) "
                    + "REFERENCES show_(show_id);");
            st.execute("INSERT INTO show_(show_name, show_datetime, genre) "
                    + "VALUES('El rey león', '2024-04-19 13:08:00', 'Musical'), "
                    + "('El amanecer de los tuertos', '2024-04-19 13:08:00', 'Comedia');");
            st.execute("insert into user_(user_name,user_pass,user_email, birthDate, upcoming_show) "
                    + "values('chinasky','jeje123','chinaskyboss@yahoo.es','1991-05-26',null), "
                    + "('slimm1','1234','tini.ramonda@gmail.com','1996-01-18',2); ");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "SQLEXCEPTION", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void closeConnection(){
        try {
            this.conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "SQLEXCEPTION", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList<User> loadUserList(){
        ArrayList<User> dbList = new ArrayList();
        try {
            Statement st = conn.createStatement();
            ResultSet result = st.executeQuery("SELECT * FROM user_;");
            while(result.next()){
                dbList.add(new User(result.getInt("user_id"),result.getString("user_name"),
                        result.getString("user_pass"), result.getString("user_email"),
                        result.getDate("birthDate"),result.getInt("upcoming_show")));
            }
            return dbList;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "SQLEXCEPTION", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public ArrayList<Show> loadShowList(){
        ArrayList<Show> dbList = new ArrayList();
        try {
            Statement st = conn.createStatement();
            ResultSet result = st.executeQuery("SELECT * FROM show_;");
            while(result.next()){
                dbList.add(new Show(result.getInt("show_id"),result.getString("show_name"),
                        result.getTimestamp("show_datetime").toLocalDateTime(),result.getString("genre")));
            }
            return dbList;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "SQLEXCEPTION", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
