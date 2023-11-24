package control.sqlConnect;

import control.controller.Show_Frame_Controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.Show_Frame;

/**
 * @author Martin Ramonda
 */
public class ShowCrud {
    public static void insertData(Connection conn){
        try {
            Show_Frame frame = Show_Frame_Controller.getInstance().getFrame();
            String query = "INSERT INTO show_(show_name,Show_datetime,genre) VALUES(?,?,?);";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, frame.getNameField().getText());
            //st.setDate(0, java.sql.Date sqlDate = java.sql.Date.valueOf(frame.get.toLocalDate()));
        } catch (SQLException ex) {
            Logger.getLogger(ShowCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private LocalDateTime getFromForm(Date date, String time){
        String datetime = date.toString()+time;
        System.out.println(datetime);
        return null;
    }
}
