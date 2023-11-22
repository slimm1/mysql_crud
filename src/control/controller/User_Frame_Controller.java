/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control.controller;

import control.sqlConnect.DbManager;
import view.User_Frame;

/**
 *
 * @author Martin Ramonda
 */
public class User_Frame_Controller {
    
    private User_Frame window;
    private DbManager db;
    
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
    }
}
