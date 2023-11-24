package model;

import java.time.LocalDateTime;

/**
 * @author Martin Ramonda
 */
public class Show {
    private int id;
    private String showName;
    private LocalDateTime showTime;
    private String genre;
    
    public Show(int id, String showName, LocalDateTime showTime, String genre){
        this.id = id;
        this.showName = showName;
        this.showTime = showTime;
        this.genre = genre;
    }
    
    public Show(String showName){
        this.showName = showName;
    }

    public int getId() {
        return id;
    }

    public String getShowName() {
        return showName;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){return false;}
        if(!(obj instanceof Show)){return false;}
        Show s = (Show) obj;
        if(s.getShowName().equalsIgnoreCase(this.showName) && s.getShowTime().equals(this.showTime) ){return true;}
        return false;
    }
        
}
