package control.controller;

import control.App_Constants;
import control.DateTimeUtilities;
import control.sqlConnect.DbManager;
import javax.swing.table.DefaultTableModel;
import model.Show;
import model.ShowList;
import view.Show_Frame;

/**
 * @author Martin Ramonda
 * Controlador para el frame de shows instanciado con el patrón singleton para acceso global a la misma instancia.
 * Inicia la variable DbManager con la misma instancia que utiliza el controlador de User_Frame.
 */
public class Show_Frame_Controller {
    private Show_Frame window;
    private DbManager db;
    private ShowList showList;
    private static Show_Frame_Controller _instance = new Show_Frame_Controller(User_Frame_Controller.getInstance().getDb());
    
    private Show_Frame_Controller(DbManager db){
        this.db = db;
    }
    
    public Show_Frame getFrame(){
        return window;
    }
    
    public ShowList getListModel(){
        return showList;
    }
    
    public static Show_Frame_Controller getInstance(){
        return _instance;
    }
    //lanza la ventana y carga el comboBox y la tabla.
    public void launchWindow(){
        window = new Show_Frame();
        loadGenreComboBox();
        loadTable();
    }
    
    // Carga la tabla a través de un DefaultTableModel y una lista cargada desde la clase DbManager. 
    //Cada fila se carga con los datos de un objeto Show.
    public void loadTable(){
        DefaultTableModel model = (DefaultTableModel) window.getShow_table().getModel();
        model.setRowCount(0);
        this.showList = new ShowList(db.loadShowList());
        for(Show s: showList.getShowList()){
            model.addRow(new String[]{String.valueOf(s.getId()),s.getShowName(),DateTimeUtilities.getFormatedDateTime(s.getShowTime()),s.getGenre()});
        }
    }
    
    //Carga el comboBox de géneros con los datos almacenados en las App_Constants
    public void loadGenreComboBox(){
        for(String genre: App_Constants.showGenres){
            window.getGenreComboBox().addItem(genre);
        }
    }
}
