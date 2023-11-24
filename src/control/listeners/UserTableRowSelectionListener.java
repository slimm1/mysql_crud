package control.listeners;

import control.controller.User_Frame_Controller;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.User;
import view.User_Frame;

/**
 * @author Martin Ramonda
 */
public class UserTableRowSelectionListener implements ListSelectionListener{

    @Override
    public void valueChanged(ListSelectionEvent e) {
        User_Frame window = User_Frame_Controller.getInstance().getFrame();
        if(window.getMainUserTable().getSelectedRow()>-1){
            int selectedId = Integer.parseInt((String)window.getMainUserTable().getValueAt(window.getMainUserTable().getSelectedRow(), 0));
            User selectedUser = User_Frame_Controller.getInstance().getListModel().getUserById(selectedId);
            window.getNameField().setText(selectedUser.getUsername());
            window.getEmailField().setText(selectedUser.getEmail());
            window.getPassField().setText(selectedUser.getPassword());
            window.getDatePicker().setDate(selectedUser.getBirthDate());
        }
    }
    
}
