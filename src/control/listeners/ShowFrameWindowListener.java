package control.listeners;

import control.controller.User_Frame_Controller;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Martin Ramonda
 * Listenert para la acción de cerrar ventana llamado desde Show_Frame.
 * Al cerrar Show_Frame activa User_Frame 
 */
public class ShowFrameWindowListener extends WindowAdapter{

    @Override
    public void windowClosing(WindowEvent e) {
        User_Frame_Controller.getInstance().getFrame().setEnabled(true);
    }    
}