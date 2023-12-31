package control.listeners;

import control.ValidationUtilities;
import control.controller.Show_Frame_Controller;
import control.controller.User_Frame_Controller;
import control.sqlConnect.ShowCrud;
import control.sqlConnect.UserCrud;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import model.User;
import view.Show_Frame;
import view.User_Frame;

/**
 * @author Martin Ramonda
 * Listener para la acción de añadir. Detecta desde que frame se ha lanzado y actúa en consecuencia.
 */
public class AddButtonListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame buttonFrame = (JFrame)((JButton) e.getSource()).getParent().getParent().getParent().getParent();
        if(buttonFrame.getTitle().equalsIgnoreCase("users")){
            addUser();
        }
        else{addShow();}
    }

    // accede a la instancia de Show_Frame y extrae los datos de los fields. Si pasa la validación, se insertan los datos en la bd
    // a través de la clase ShowCrud y se actualizan la tabla y el comboBox de show.
    private void addShow() {
        Show_Frame frame = Show_Frame_Controller.getInstance().getFrame();
        String showname = frame.getNameField().getText();
        String genre = (String)frame.getGenreComboBox().getSelectedItem();
        String hour = frame.getTimeField().getText();
        Date showDate = frame.getShow_Datepicker().getDate();
        if(ValidationUtilities.validateAddShow(showname, hour, showDate)){
            ShowCrud.insertData(User_Frame_Controller.getInstance().getDb().connectDb(),showname,showDate,hour,genre);
            Show_Frame_Controller.getInstance().loadTable();
            User_Frame_Controller.getInstance().loadShowsComboBox();
        }
    }
    
    // similar al anterior. Si pasa la validación se insertan los datos y actualiza la tabla de usuarios.
    private void addUser() {
        User_Frame window = User_Frame_Controller.getInstance().getFrame();
        String username = window.getNameField().getText();
        String email = window.getEmailField().getText();
        String password = window.getPassField().getText();
        Date birthDate = window.getDatePicker().getDate();
        User newUser = new User(username);
        if(ValidationUtilities.validateAddUser(newUser, username,email, password,birthDate)){
            UserCrud.insertData(User_Frame_Controller.getInstance().getDb().connectDb(), username, password, email, birthDate, window.getShow_combo().getSelectedIndex());
            User_Frame_Controller.getInstance().loadTable();
        }
    }
}
