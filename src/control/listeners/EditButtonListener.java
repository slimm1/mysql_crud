package control.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Martin Ramonda
 */
public class EditButtonListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame buttonFrame = (JFrame)((JButton) e.getSource()).getParent().getParent().getParent().getParent();
        if(buttonFrame.getTitle().equalsIgnoreCase("users")){
            editUser();
        }
        else{editShow();}
    }

    private void editShow() {
        
    }

    private void editUser() {
        
    }
    
    
    
}
