package control.listeners;

import control.ValidationUtilities;
import control.controller.Show_Frame_Controller;
import control.controller.User_Frame_Controller;
import control.sqlConnect.ShowCrud;
import control.sqlConnect.UserCrud;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author Martin Ramonda
 */
public class DeleteButtonListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame buttonFrame = (JFrame)((JButton) e.getSource()).getParent().getParent().getParent().getParent();
        if(buttonFrame.getTitle().equalsIgnoreCase("users")){
            deleteUser();
        }
        else{deleteShow();}
    }

    private void deleteUser() {
        int row = User_Frame_Controller.getInstance().getFrame().getMainUserTable().getSelectedRow();
        if(ValidationUtilities.validateDeleteUser(row)){
            int userId = Integer.parseInt((String)User_Frame_Controller.getInstance().getFrame().getMainUserTable().getModel().getValueAt(row, 0));
            UserCrud.deleteData(User_Frame_Controller.getInstance().getDb().connectDb(), userId);
            User_Frame_Controller.getInstance().loadTable();
        }
    }

    private void deleteShow() {
        int row = Show_Frame_Controller.getInstance().getFrame().getShow_table().getSelectedRow();
        if(ValidationUtilities.validateDeleteShow(row)){
            int showId = Integer.parseInt((String)Show_Frame_Controller.getInstance().getFrame().getShow_table().getModel().getValueAt(row, 0));
            ShowCrud.deleteData(User_Frame_Controller.getInstance().getDb().connectDb(), showId);
            Show_Frame_Controller.getInstance().loadTable();
            User_Frame_Controller.getInstance().loadShowsComboBox();
        }
    }
    
}
