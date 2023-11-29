package control.sqlConnect;

import control.DateTimeUtilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * @author Martin Ramonda
 * Clase intermediaria para acciones de añadir, eliminar o editar shows.
 */
public class ShowCrud {
    
    // Inserta los datos proporcionados por parámetros en la base de datos a través de la conexion de la clase DbManager.
    public static void insertData(Connection conn, String showName,Date showDate, String showTime, String genre){
        try {
            String query = "INSERT INTO show_(show_name,Show_datetime,genre) VALUES(?,?,?);";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, showName);
            st.setTimestamp(2, java.sql.Timestamp.valueOf(DateTimeUtilities.getLocalDateTimeFrom(showDate,showTime)));
            if(genre.equalsIgnoreCase("<null>")){st.setNull(3, java.sql.Types.VARCHAR);}
            else{st.setString(3, genre);}
            st.execute();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "SQLEXCEPTION", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //elimina en la base de datos el show que coincida con el proporcionado en los parametros.
    public static void deleteData(Connection conn, int show_id){
        try {
            String query = "DELETE FROM show_ WHERE show_id = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, show_id);
            st.execute();
            conn.close();
        } catch (SQLException ex) {
            if(ex.getErrorCode()==1451){JOptionPane.showMessageDialog(null, "PARA BORRAR ESTE REGISTRO DEBES ELIMINAR TODAS LAS REFERENCIAS AL MISMO", "SQLEXCEPTION", JOptionPane.ERROR_MESSAGE);}
            else{JOptionPane.showMessageDialog(null, ex.getMessage(), "SQLEXCEPTION", JOptionPane.ERROR_MESSAGE);}
        }
    }
    
    //actualiza los datos en la bd a través de las variables proporcionadas por parametros.
    public static void updateData(Connection conn, String showname, LocalDateTime ldt, String genre, int showId){
        try {
            String query = "UPDATE show_ SET show_name = ?, show_datetime = ?, genre = ? WHERE show_id = ?;";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, showname);
            st.setTimestamp(2, java.sql.Timestamp.valueOf(ldt));
            if(genre==null || genre.equalsIgnoreCase("<null>")){st.setNull(3, java.sql.Types.VARCHAR);}
            else{st.setString(3, genre);}
            st.setInt(4, showId);
            st.execute();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "SQLEXCEPTION", JOptionPane.ERROR_MESSAGE);
        }
    }
}
