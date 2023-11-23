package model;

import java.util.ArrayList;

/**
 * @author Martin Ramonda
 */
public class ShowList {
    public ArrayList <Show> showList;
    
    public ShowList(ArrayList<Show> showList){
        this.showList = showList;
        if(this.showList == null){
            this.showList = new ArrayList();
        } 
    }

    public ArrayList<Show> getShowList() {
        return showList;
    }
}
