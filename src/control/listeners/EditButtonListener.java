package control.listeners;

import control.DateTimeUtilities;
import control.ValidationUtilities;
import control.controller.Show_Frame_Controller;
import control.controller.User_Frame_Controller;
import control.sqlConnect.ShowCrud;
import control.sqlConnect.UserCrud;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import model.Show;
import model.User;
import view.Show_Frame;
import view.User_Frame;

/**
 * @author Martin Ramonda
 */
public class EditButtonListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame buttonFrame = (JFrame)((JButton) e.getSource()).getParent().getParent().getParent().getParent();
        if(buttonFrame.getTitle().equalsIgnoreCase("users")){
            editUser();
        }
        else{editShow();}
    }

    private void editShow() {
        Show_Frame frame = Show_Frame_Controller.getInstance().getFrame();
        int row = frame.getShow_table().getSelectedRow();
        if(ValidationUtilities.selectedItem(row)){
            int selectedId = Integer.parseInt((String)frame.getShow_table().getValueAt(row, 0));
            String showname = frame.getNameField().getText();
            Date showdate = frame.getShow_Datepicker().getDate();
            String hour = frame.getTimeField().getText();
            String genre = (String)frame.getGenreComboBox().getSelectedItem();
            Show selectedShow = Show_Frame_Controller.getInstance().getListModel().getShowById(selectedId);
            if(ValidationUtilities.validateUpdateShow(selectedShow, showname,showdate,hour,genre)){
                LocalDateTime ldt = DateTimeUtilities.getLocalDateTimeFrom(showdate, hour);
                ShowCrud.updateData(User_Frame_Controller.getInstance().getDb().connectDb(), showname, ldt, genre, selectedShow.getId());  
                Show_Frame_Controller.getInstance().loadTable();
                User_Frame_Controller.getInstance().loadShowsComboBox();
            }
        }
    }

    private void editUser(){
        User_Frame frame = User_Frame_Controller.getInstance().getFrame();
        int row = frame.getMainUserTable().getSelectedRow();
        if(ValidationUtilities.selectedItem(row)){
            int selectedId = Integer.parseInt((String)frame.getMainUserTable().getValueAt(row, 0));
            User selectedUser = User_Frame_Controller.getInstance().getUserListModel().getUserById(selectedId);
            String username = frame.getNameField().getText();
            String password = frame.getPassField().getText();
            String email = frame.getEmailField().getText();
            Date birthDate = frame.getDatePicker().getDate();
            int showId = Integer.parseInt(((String)frame.getShow_combo().getSelectedItem()).split(":")[0].equals("<null>")?"0":((String)frame.getShow_combo().getSelectedItem()).split(":")[0]);
            if(ValidationUtilities.validateUpdateUser(selectedUser, username, password, email, birthDate, showId)){
                UserCrud.updateData(User_Frame_Controller.getInstance().getDb().connectDb(), username, password, email, birthDate, showId, selectedId);
                User_Frame_Controller.getInstance().loadTable();
            }
        }
    }
    
    
    
}
