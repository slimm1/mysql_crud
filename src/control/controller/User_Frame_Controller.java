package control.controller;

import control.DateTimeUtilities;
import control.sqlConnect.DbManager;
import javax.swing.table.DefaultTableModel;
import model.Show;
import model.ShowList;
import model.User;
import model.UserList;
import view.User_Frame;

/**
 * @author Martin Ramonda
 * Controlador para User_Frame instanciado con patrón singleton para acceso global a la misma instancia.
 * Inicia un nuevo DbManager en el constructor.
 */
public class User_Frame_Controller {
    
    private User_Frame window;
    private DbManager db;
    private UserList userList;
    private ShowList showList;
    
    private static User_Frame_Controller _instance = new User_Frame_Controller();
    
    private User_Frame_Controller(){
        db = new DbManager();
    }
    
    public static User_Frame_Controller getInstance(){
        return _instance;
    }
    
    public DbManager getDb(){
        return db;
    }
    
    public User_Frame getFrame(){
        return window;
    }
    
    public UserList getUserListModel(){
        return userList;
    }
    
    public ShowList getShowListModel(){
        return showList;
    }
    
    //lanza la ventana, carga la tabla y el comboBox de shows
    public void launchWindow(){
        this.window = new User_Frame();
        loadTable();
        loadShowsComboBox();
    }
    
    //Carga la tabla a través de un DefaultTableModel y una lista cargada desde la base de datos.
    public void loadTable(){
        DefaultTableModel model = (DefaultTableModel) window.getMainUserTable().getModel();
        model.setRowCount(0);
        this.userList = new UserList(db.loadUserList());
        for(User u: userList.getUserList()){
            model.addRow(new String[]{String.valueOf(u.getId()),u.getUsername(),u.getPassword(),u.getEmail(),DateTimeUtilities.getFormatedDate(u.getBirthDate())});
        }
    }
    
    //Carga el comboBox a través de la lista de shows, cargada en memoria a través de la base de datos.
    public void loadShowsComboBox(){
        this.showList = new ShowList(db.loadShowList());
        window.getShow_combo().removeAllItems();
        window.getShow_combo().addItem("<null>");
        for(Show s:showList.getShowList()){
            window.getShow_combo().addItem(s.getId()+":"+s.getShowName());
        }
    }
}
