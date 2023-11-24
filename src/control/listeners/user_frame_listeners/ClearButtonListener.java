/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control.listeners;

import control.controller.User_Frame_Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.User_Frame;

/**
 *
 * @author marti
 */
public class ClearButtonListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        User_Frame window = User_Frame_Controller.getInstance().getFrame();
        window.getMainUserTable().clearSelection();
        window.getNameField().setText("");
        window.getEmailField().setText("");
        window.getPassField().setText("");
        window.getDatePicker().setDate(null);
        System.out.println("out");
    }

}
