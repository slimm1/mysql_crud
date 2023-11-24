/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control.listeners;

import control.controller.Show_Frame_Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Show;
import view.Show_Frame;

/**
 * @author Martin Ramonda
 */
public class AddShowButtonListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        addShow();
    }

    private void addShow() {
        Show_Frame frame = Show_Frame_Controller.getInstance().getFrame();
        String showname = frame.getNameField().getText();
        String genre = (String)frame.getGenreComboBox().getSelectedItem();
        String hour = frame.getTimeField().getText();
        Date showDate = frame.getShow_Datepicker().getDate();
        Show newShow = new Show(showname);
        System.out.println(showDate.toString()+hour);
        if(validateAddShow(newShow, showname, hour, showDate)){
            
        }
    }
    
    private boolean validateAddShow(Show newShow, String showname, String hour, Date showDate){
        if(checkEmptyFields(showname, hour, showDate)){
            JOptionPane.showMessageDialog(null, "Some field is empty in the form", "Empty field error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(Show_Frame_Controller.getInstance().getListModel().getShowList().contains(newShow)){
            JOptionPane.showMessageDialog(null, "Same show is programmed at this DateTime", "add show error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    public boolean checkEmptyFields(String showName, String hour, Date showDate){
        if(showName.isEmpty()){
           return true;
        }
        else if(showDate == null){
           return true;
        }
        else if(hour.isEmpty()){
           return true;
        }
        return false;
    }
    
}