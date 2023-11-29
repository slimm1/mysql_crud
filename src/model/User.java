package model;

import java.util.Date;

/**
 *
 * @author Martin Ramonda
 */
public class User {
    private String username;
    private String password;
    private Date birthDate;
    private String email;
    private int id;
    private int show_id;
    
    public User(int id, String username, String password, String email, Date birthDate, int show_id){
        this.id=id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthDate = birthDate;
        this.show_id = show_id;
    }
    
    public User(String username){
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public int getShow_id() {
        return show_id;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){return false;}
        if(!(obj instanceof User)){return false;}
        User u = (User)obj;
        if(u.getUsername().equalsIgnoreCase(this.username)){return true;}
        return false;
    }
    
    
}
