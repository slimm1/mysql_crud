package control.listeners;

import control.controller.Show_Frame_Controller;
import control.controller.User_Frame_Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import view.Show_Frame;
import view.User_Frame;

/**
 * @author Martin Ramonda
 */
public class ClearButtonListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame buttonFrame = (JFrame)((JButton) e.getSource()).getParent().getParent().getParent().getParent();
        if(buttonFrame.getTitle().equalsIgnoreCase("users")){
            clearUsers();
        }
        else{ clearShows(); }
    }
    
    private void clearUsers(){
        User_Frame window = User_Frame_Controller.getInstance().getFrame();
        window.getMainUserTable().clearSelection();
        window.getNameField().setText("");
        window.getEmailField().setText("");
        window.getPassField().setText("");
        window.getDatePicker().setDate(null);
        window.getShow_combo().setSelectedIndex(0);
    }
    
    private void clearShows(){
        Show_Frame window = Show_Frame_Controller.getInstance().getFrame();
        window.getShow_table().clearSelection();
        window.getNameField().setText("");
        window.getShow_Datepicker().setDate(null);
        window.getTimeField().setText("");
        window.getGenreComboBox().setSelectedIndex(0);
    }

}