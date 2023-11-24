package control.sqlConnect;

import control.Utilities;
import control.controller.Show_Frame_Controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
            st.setDate(2, java.sql.Date.valueOf(Utilities.getLocalDateTimeFrom(frame.getShow_Datepicker().getDate(),frame.getTimeField().getText()).toLocalDate()));
            if(frame.getGenreComboBox().getSelectedIndex()==0){st.setNull(3, java.sql.Types.VARCHAR);}
            else{st.setString(3, (String)frame.getGenreComboBox().getSelectedItem());}
            st.execute();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ShowCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
