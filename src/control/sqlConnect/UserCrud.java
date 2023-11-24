package control.sqlConnect;

import control.controller.User_Frame_Controller;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.User_Frame;
/**
 * @author Martin Ramonda
 */
public class UserCrud {
    
    public static void insertData(Connection conn){
        try {
            User_Frame frame = User_Frame_Controller.getInstance().getFrame();
            String query = "INSERT INTO user_(user_name,user_pass,user_email,birthDate,upcoming_show) VALUES (?,?,?,?,?);";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, frame.getNameField().getText());
            st.setString(2, frame.getPassField().getText());
            st.setString(3, frame.getEmailField().getText());
            st.setDate(4, new java.sql.Date(frame.getDatePicker().getDate().getTime()));
            if(frame.getShow_combo().getSelectedIndex()==0){st.setNull(5, java.sql.Types.INTEGER);}
            else{st.setInt(5, frame.getShow_combo().getSelectedIndex());}
            st.execute();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
