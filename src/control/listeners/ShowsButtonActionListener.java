
package control.listeners;

import control.controller.Show_Frame_Controller;
import control.controller.User_Frame_Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Martin Ramonda
 * Listener para la acción de botón SHOWS en User_Frame. Al pulsar, desactiva User_Frame y abre ventana Show_Frame
 */
public class ShowsButtonActionListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        Show_Frame_Controller.getInstance().launchWindow();
        User_Frame_Controller.getInstance().getFrame().setEnabled(false);
    }
}
