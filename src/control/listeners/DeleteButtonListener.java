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
 * Listener para la acción de eliminar. Detecta frame y actúa según origen de llamada.
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

    // Detecta la fila de la tabla seleccionada. Si pasa la validación elimina de bd a través de UserCrud y actualiza la tabla.
    private void deleteUser() {
        int row = User_Frame_Controller.getInstance().getFrame().getMainUserTable().getSelectedRow();
        if(ValidationUtilities.validateDeleteUser(row)){
            int userId = Integer.parseInt((String)User_Frame_Controller.getInstance().getFrame().getMainUserTable().getValueAt(row, 0));
            UserCrud.deleteData(User_Frame_Controller.getInstance().getDb().connectDb(), userId);
            User_Frame_Controller.getInstance().loadTable();
        }
    }

    // Similar al anterior para show. Al eliminar de la bd actualiza la tabla shows y el comboBox de user
    private void deleteShow() {
        int row = Show_Frame_Controller.getInstance().getFrame().getShow_table().getSelectedRow();
        if(ValidationUtilities.validateDeleteShow(row)){
            int showId = Integer.parseInt((String)Show_Frame_Controller.getInstance().getFrame().getShow_table().getValueAt(row, 0));
            ShowCrud.deleteData(User_Frame_Controller.getInstance().getDb().connectDb(), showId);
            Show_Frame_Controller.getInstance().loadTable();
            User_Frame_Controller.getInstance().loadShowsComboBox();
        }
    }
    
}
