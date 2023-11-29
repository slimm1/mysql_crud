package control.listeners;

import control.DateTimeUtilities;
import control.controller.Show_Frame_Controller;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.Show;
import view.Show_Frame;

/**
 * @author Martin Ramonda
 * Listener para la acción de seleccionar una fila en la tabla de Show_Frame.
 * Al cambiar de fila, setea todos los fields con los datos del objeto seleccionado.
 */
public class ShowTableRowSelectionListener implements ListSelectionListener{

    @Override
    public void valueChanged(ListSelectionEvent e) {
        Show_Frame window = Show_Frame_Controller.getInstance().getFrame();
        if(window.getShow_table().getSelectedRow()>-1){
            int selectedId = Integer.parseInt((String)window.getShow_table().getValueAt(window.getShow_table().getSelectedRow(), 0));
            Show selectedShow = Show_Frame_Controller.getInstance().getListModel().getShowById(selectedId);
            window.getNameField().setText(selectedShow.getShowName());
            if(selectedShow.getGenre()==null){window.getGenreComboBox().setSelectedIndex(0);}
            else{window.getGenreComboBox().setSelectedItem(selectedShow.getGenre());}
            window.getShow_Datepicker().setDate(DateTimeUtilities.getDateFromLocalDT(selectedShow.getShowTime()));
            window.getTimeField().setText(DateTimeUtilities.extractTimeFromLDT(selectedShow.getShowTime()));
        }
    }
}
