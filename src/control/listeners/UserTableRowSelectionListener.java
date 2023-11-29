package control.listeners;

import control.controller.User_Frame_Controller;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.Show;
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
            User selectedUser = User_Frame_Controller.getInstance().getUserListModel().getUserById(selectedId);
            window.getNameField().setText(selectedUser.getUsername());
            window.getEmailField().setText(selectedUser.getEmail());
            window.getPassField().setText(selectedUser.getPassword());
            window.getDatePicker().setDate(selectedUser.getBirthDate());
            window.getShow_combo().setSelectedIndex(getComboIndexByShowId(selectedUser.getShow_id(), window));
        }
    }
    
    private int getComboIndexByShowId(int id, User_Frame window){
        Show s = User_Frame_Controller.getInstance().getShowListModel().getShowById(id);
        if(s == null){
            return 0;
        }
        else{
            for(int i = 0; i < window.getShow_combo().getItemCount(); i++){
                if((s.getId()+":"+s.getShowName()).equalsIgnoreCase(window.getShow_combo().getItemAt(i))){
                    return i;
                }
            }
        }
        return -1;
    }
}
