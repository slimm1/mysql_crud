package control.sqlConnect;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 * @author Martin Ramonda
 * Clase intermediaria para operaciones de añadir, eliminar o actualizar usuarios.
 */
public class UserCrud {
    
    public static void insertData(Connection conn,String username, String password, String email, Date birthDate,int showId){
        try {
            String query = "INSERT INTO user_(user_name,user_pass,user_email,birthDate,upcoming_show) VALUES (?,?,?,?,?);";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, username);
            st.setString(2, password);
            st.setString(3, email);
            st.setDate(4, new java.sql.Date(birthDate.getTime()));
            if(showId==0){st.setNull(5, java.sql.Types.INTEGER);}
            else{st.setInt(5, showId);}
            st.execute();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "SQLEXCEPTION", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void deleteData(Connection conn, int user_id){
        try {
            String query = "DELETE FROM user_ WHERE user_id = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, user_id);
            st.execute();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "SQLEXCEPTION", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void updateData(Connection conn, String username, String password, String email, Date birthDate, int showId, int userId){
        try {
            String query = "UPDATE user_ SET user_name = ?, user_pass = ?, user_email = ?, birthDate = ?, upcoming_show = ? WHERE user_id = ?;";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, username);
            st.setString(2,password);
            st.setString(3, email);
            st.setDate(4, new java.sql.Date(birthDate.getTime()));
            if(showId==0){st.setNull(5, java.sql.Types.INTEGER);}
            else{st.setInt(5, showId);}
            st.setInt(6, userId);
            st.execute();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "SQLEXCEPTION", JOptionPane.ERROR_MESSAGE);
        }
    }
}
