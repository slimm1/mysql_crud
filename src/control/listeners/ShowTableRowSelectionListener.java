package control.listeners;

import control.controller.Show_Frame_Controller;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.Show;
import view.Show_Frame;

/**
 * @author Martin Ramonda
 */
public class ShowTableRowSelectionListener implements ListSelectionListener{

    @Override
    public void valueChanged(ListSelectionEvent e) {
        Show_Frame window = Show_Frame_Controller.getInstance().getFrame();
        if(window.getShow_table().getSelectedRow()>-1){
            int selectedId = Integer.parseInt((String)window.getShow_table().getValueAt(window.getShow_table().getSelectedRow(), 0));
            Show selectedShow = Show_Frame_Controller.getInstance().getListModel().getShowById(selectedId);
            window.getNameField().setText(selectedShow.getShowName());
            window.getGenreComboBox().setSelectedItem(selectedShow.getGenre());
            window.getShow_Datepicker().setDate(getDateFromLocalDT(selectedShow.getShowTime()));
            window.getTimeField().setText(getTimeFromLDT(selectedShow.getShowTime()));
        }
    }
    
    public Date getDateFromLocalDT(LocalDateTime ldt){
        return Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
    }
    
    public String getTimeFromLDT(LocalDateTime ldt){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return ldt.format(formatter);
    }
}
