package control;

import control.controller.Show_Frame_Controller;
import control.controller.User_Frame_Controller;
import java.util.Date;
import java.util.regex.Matcher;
import javax.swing.JOptionPane;
import model.Show;
import model.User;

/**
 * @author Martin Ramonda
 */
public class ValidationUtilities {
    
    // SHOW VALIDATION
    // Valida la acción de añadir show y lanza mensajes para orientar al usuario
    public static boolean validateAddShow(String showname, String hour, Date showDate){
        if(checkEmptyFields(showname, hour, showDate)){
            JOptionPane.showMessageDialog(null, "Some field is empty in the form", "Empty field error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        Show newShow = new Show(showname,DateTimeUtilities.getLocalDateTimeFrom(showDate,hour));
        if(Show_Frame_Controller.getInstance().getListModel().getShowList().contains(newShow)){
            JOptionPane.showMessageDialog(null, "Same show is programmed at this DateTime", "add show error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    // Valida la acción de eliminar show
    public static boolean validateDeleteShow(int selectedRow){
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(null, "You must select a show to delete", "NO ITEM SELECTED", JOptionPane.ERROR_MESSAGE);            
            return false;
        }
        else if(JOptionPane.showConfirmDialog(null, "ARE YOU SURE YOU WANT TO DELETE THIS SHOW?","WAIT", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION){
            return false;
        }
        return true;
    }
    
    //valida la acción de actualizar show
    public static boolean validateUpdateShow(Show s, String showname, Date showdate,String hour, String genre){
        if(checkEmptyFields(showname, genre, Show_Frame_Controller.getInstance().getFrame().getShow_Datepicker().getDate())){
            JOptionPane.showMessageDialog(null, "Some field is empty in the form", "Empty field error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        Show newShow = new Show(showname,DateTimeUtilities.getLocalDateTimeFrom(showdate,hour));
        if(Show_Frame_Controller.getInstance().getListModel().getShowList().contains(newShow)){
            JOptionPane.showMessageDialog(null, "Same show is programmed at this DateTime", "add show error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
   
    // USER VALIDATION
    //valida la acción de añadir usuario
    public static boolean validateAddUser(User newUser, String username, String email, String password, Date birthDate){
        if(checkEmptyFields(username, password, email, birthDate)){
            JOptionPane.showMessageDialog(null, "Some field is empty in the form", "Empty field error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(!emailChecker(email)){
            JOptionPane.showMessageDialog(null, "invalid e-mail format", "e-mail error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(User_Frame_Controller.getInstance().getUserListModel().getUserList().contains(newUser)){
            JOptionPane.showMessageDialog(null, "invalid name. This user already exists", "name error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    // valida la acción de eliminar usuario
    public static boolean validateDeleteUser(int selectedRow){
        if(!selectedItem(selectedRow)){
            return false;
        }
        else if(JOptionPane.showConfirmDialog(null, "ARE YOU SURE YOU WANT TO DELETE THIS USER?","WAIT", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION){
            return false;
        }
        return true;
    }
    
    //valida la acción de actualizar usuario
    public static boolean validateUpdateUser(User u, String username, String password, String email, Date d, int showId){
        if(checkEmptyFields(username, password, email, d)){
            JOptionPane.showMessageDialog(null, "Some field is empty in the form", "Empty field error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(!emailChecker(email)){
            JOptionPane.showMessageDialog(null, "invalid e-mail format", "e-mail error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(equalFields(username, password, email, d, showId ,u)){
            JOptionPane.showMessageDialog(null, "program did not detect any changes to upload", "NO CHANGES MADE", JOptionPane.ERROR_MESSAGE);
            return false;
        }        
        else if(User_Frame_Controller.getInstance().getUserListModel().getUserList().contains(new User(username)) && (!username.equalsIgnoreCase(u.getUsername()))){
            JOptionPane.showMessageDialog(null, "An user with this username already exists on db", "UPLOAD ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    // VALIDATION UTILS
    //valida que haya un determinado item seleccionado en la lista
    public static boolean selectedItem(int selectedRow){
        if(selectedRow == -1){
            JOptionPane.showMessageDialog(null, "You must select an item to update", "NO ITEM SELECTED", JOptionPane.ERROR_MESSAGE);            
            return false;
        }
        return true;
    }
    
    //valida que los datos en los textfields no sean los mismos que los del usuario seleccionado
    private static boolean equalFields(String username, String password, String email, Date birthDate,int showId, User selectedUser){
        boolean nameBool, emailBool, passwordBool, dateBool, showIdBool;
        nameBool = username.equalsIgnoreCase(selectedUser.getUsername());
        emailBool = email.equalsIgnoreCase(selectedUser.getEmail());
        passwordBool = password.equalsIgnoreCase(selectedUser.getPassword());
        dateBool = birthDate.equals(selectedUser.getBirthDate());
        showIdBool = showId == selectedUser.getShow_id();
        if(nameBool && emailBool && passwordBool && dateBool && showIdBool){return true;}
        return false;
    }    
    
    // valida que no haya ningun field vacío para user
    private static boolean checkEmptyFields(String username, String password, String email, Date birth){
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
    
    // sobreescritura del método anterior para show
    private static boolean checkEmptyFields(String showName, String hour, Date showDate){
        if(showName.isEmpty()){
           return true;
        }
        else if(showDate == null){
           return true;
        }
        else if(hour.isEmpty()){
           return true;
        }
        return false;
    }
    
    // valida el email a través de una expresión regular.
    private static boolean emailChecker(String email){
        Matcher matcher = App_Constants.VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.matches();    
    }
}
