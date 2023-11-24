package control.controller;

import control.sqlConnect.DbManager;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.table.DefaultTableModel;
import model.Show;
import model.ShowList;
import view.Show_Frame;

/**
 *
 * @author Martin Ramonda
 */
public class Show_Frame_Controller {
    private Show_Frame window;
    private DbManager db;
    private ShowList showList;
    private static Show_Frame_Controller _instance = new Show_Frame_Controller(User_Frame_Controller.getInstance().getDb());
    
    private Show_Frame_Controller(DbManager db){
        this.db = db;
    }
    
    public Show_Frame getWindow(){
        return window;
    }
    
    public ShowList getListModel(){
        return showList;
    }
    
    public static Show_Frame_Controller getInstance(){
        return _instance;
    }
    
    public void launchWindow(){
        window = new Show_Frame();
        loadTable();
    }
    
    public void loadTable(){
        DefaultTableModel model = (DefaultTableModel) window.getShow_table().getModel();
        model.setRowCount(0);
        this.showList = new ShowList(db.loadShowList());
        for(Show s: showList.getShowList()){
            model.addRow(new String[]{String.valueOf(s.getId()),s.getShowName(),getFormatedDateTime(s.getShowTime()),s.getGenre()});
        }
    }
    
    private String getFormatedDateTime(LocalDateTime date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm");
        return date.format(formatter);
    }
}
