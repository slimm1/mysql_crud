package control.controller;

import control.sqlConnect.DbManager;
import javax.swing.table.DefaultTableModel;
import model.User;
import model.UserList;
import view.User_Frame;

/**
 * @author Martin Ramonda
 */
public class User_Frame_Controller {
    
    private User_Frame window;
    private DbManager db;
    private UserList userList;
    
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
    
    public void launchWindow(){
        this.window = new User_Frame();
        loadTable();
    }
    
    public void loadTable(){
        DefaultTableModel model = (DefaultTableModel) window.getMainUserTable().getModel();
        model.setRowCount(0);
        this.userList = new UserList(db.loadUserList());
        for(User u: userList.getUserList()){
            model.addRow(new String[]{String.valueOf(u.getId()),u.getUsername(),u.getPassword(),u.getEmail(),u.getBirthDate().toString()});
        }
    }
}
