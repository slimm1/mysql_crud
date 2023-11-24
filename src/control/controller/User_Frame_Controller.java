package control.controller;

import control.sqlConnect.DbManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import model.Show;
import model.ShowList;
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
    
    public void launchWindow(){
        this.window = new User_Frame();
        loadTable();
        loadShowsComboBox();
    }
    
    public void loadTable(){
        DefaultTableModel model = (DefaultTableModel) window.getMainUserTable().getModel();
        model.setRowCount(0);
        this.userList = new UserList(db.loadUserList());
        for(User u: userList.getUserList()){
            model.addRow(new String[]{String.valueOf(u.getId()),u.getUsername(),u.getPassword(),u.getEmail(),getFormatedDate(u.getBirthDate())});
        }
    }
    
    public void loadShowsComboBox(){
        this.showList = new ShowList(db.loadShowList());
        window.getShow_combo().addItem("<null>");
        for(Show s:showList.getShowList()){
            window.getShow_combo().addItem(s.getShowName());
        }
    }
    
    private String getFormatedDate(Date d){
        SimpleDateFormat formater = new SimpleDateFormat("dd MMM yyyy");
        return formater.format(d);
    }
}
