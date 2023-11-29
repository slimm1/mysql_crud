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
 * Listener para la acción de botón clear.
 * Detecta desde que frame se ha llamado a la acción y actúa en consecuencia.
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
    
    //Accede a la instancia de User_Frame y setea los fields en blanco o null. Limpia la selección de la tabla
    private void clearUsers(){
        User_Frame window = User_Frame_Controller.getInstance().getFrame();
        window.getMainUserTable().clearSelection();
        window.getNameField().setText("");
        window.getEmailField().setText("");
        window.getPassField().setText("");
        window.getDatePicker().setDate(null);
        window.getShow_combo().setSelectedIndex(0);
    }
    
    // Igual que el anterior pero para Show_Frame
    private void clearShows(){
        Show_Frame window = Show_Frame_Controller.getInstance().getFrame();
        window.getShow_table().clearSelection();
        window.getNameField().setText("");
        window.getShow_Datepicker().setDate(null);
        window.getTimeField().setText("");
        window.getGenreComboBox().setSelectedIndex(0);
    }

}