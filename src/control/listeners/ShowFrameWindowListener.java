package control.listeners;

import control.controller.User_Frame_Controller;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Martin Ramonda
 */
public class ShowFrameWindowListener extends WindowAdapter{

    @Override
    public void windowClosing(WindowEvent e) {
        User_Frame_Controller.getInstance().getFrame().setEnabled(true);
    }    
}