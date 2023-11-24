package control.listeners;

import control.App_Constants;
import control.controller.User_Frame_Controller;
import control.sqlConnect.UserCrud;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.regex.Matcher;
import javax.swing.JOptionPane;
import model.User;
import view.User_Frame;

/**
 * @author Martin Ramonda
 */
public class AddUserButtonListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        addUser();
    }
    
    private void addUser() {
        User_Frame window = User_Frame_Controller.getInstance().getFrame();
        String username = window.getNameField().getText();
        String email = window.getEmailField().getText();
        String password = window.getPassField().getText();
        Date birthDate = window.getDatePicker().getDate();
        User newUser = new User(username,email);
        if(validateAddUser(newUser, username,email, password,birthDate)){
            UserCrud.insertData(User_Frame_Controller.getInstance().getDb().connectDb());
            User_Frame_Controller.getInstance().loadTable();
        }
    }
    
    public boolean validateAddUser(User newUser, String username, String email, String password, Date birthDate){
        if(checkEmptyFields(username, password, email, birthDate)){
            JOptionPane.showMessageDialog(null, "Some field is empty in the form", "Empty field error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(!emailChecker(email)){
            JOptionPane.showMessageDialog(null, "invalid e-mail format", "e-mail error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(User_Frame_Controller.getInstance().getUserListModel().getUserList().contains(newUser)){
            JOptionPane.showMessageDialog(null, "invalid name or email. This user already exists", "name/email error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{return true;}
    }
    
    public boolean emailChecker(String email){
        Matcher matcher = App_Constants.VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.matches();    
    }
    
    public boolean checkEmptyFields(String username, String password, String email, Date birth){
        if(email.isEmpty()){
           return true;
        }
        else if(username.isEmpty()){
            return true;
        }
        else if(birth == null){
           return true;
        }
        else if(password.isEmpty()){
           return true;
        }
        return false;
    }
    
    public boolean equalFields(String username, String password, String email, Date birthDate, User selectedUser){
        boolean nameBool, emailBool, passwordBool, dateBool;
        nameBool = username.equalsIgnoreCase(selectedUser.getUsername());
        emailBool = email.equalsIgnoreCase(selectedUser.getEmail());
        passwordBool = password.equalsIgnoreCase(selectedUser.getPassword());
        dateBool = birthDate.equals(selectedUser.getBirthDate());
        if(nameBool && emailBool && passwordBool && dateBool){return false;}
        return true;
    }
}
