
package control.listeners;

import control.controller.Show_Frame_Controller;
import control.controller.User_Frame_Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Martin Ramonda
 */
public class ShowsButtonActionListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        Show_Frame_Controller.getInstance().launchWindow();
        User_Frame_Controller.getInstance().getFrame().setEnabled(false);
    }
}
