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
        
}
