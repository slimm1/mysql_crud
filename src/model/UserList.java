package model;

import java.util.ArrayList;

/**
 * @author Martin Ramonda
 */
public class UserList {
    public ArrayList <User> userList;
    
    public UserList(ArrayList<User> userList){
        this.userList = userList;
        if(this.userList == null){
            this.userList = new ArrayList();
        } 
    }

    public ArrayList<User> getUserList() {
        return userList;
    }
    
    public User getUserById(int id){
        for(User u: userList){
            if(u.getId() == id){
                return u;
            }
        }
        return null;
    } 
}
