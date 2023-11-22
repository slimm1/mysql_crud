package control.controller;

import control.sqlConnect.DbManager;
import view.Show_Frame;

/**
 *
 * @author Martin Ramonda
 */
public class Show_Frame_Controller {
    private Show_Frame window;
    private DbManager db;
    private static Show_Frame_Controller _instance = new Show_Frame_Controller(User_Frame_Controller.getInstance().getDb());
    
    private Show_Frame_Controller(DbManager db){
        this.db = db;
    }
    
    public static Show_Frame_Controller getInstance(){
        return _instance;
    }
    
    public void loadWindow(){
        window = new Show_Frame();
    }
}
