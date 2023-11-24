/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import com.toedter.calendar.JDateChooser;
import control.listeners.AddUserButtonListener;
import control.listeners.ClearButtonListener;
import control.listeners.DeleteUserButtonListener;
import control.listeners.EditUserButtonListener;
import control.listeners.ShowsButtonActionListener;
import control.listeners.UserTableRowSelectionListener;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Martin Ramonda
 */
public class User_Frame extends javax.swing.JFrame {

    /**
     * Creates new form User_Frame
     */
    public User_Frame() {
        initComponents();
        this.setListeners();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    
    public void setListeners(){
        this.AddButton.addActionListener(new AddUserButtonListener());
        this.DeleteButton.addActionListener(new DeleteUserButtonListener());
        this.EditButton.addActionListener(new EditUserButtonListener());
        this.showsButton.addActionListener(new ShowsButtonActionListener());
        this.MainUserTable.getSelectionModel().addListSelectionListener(new UserTableRowSelectionListener());
        this.ClearButton.addActionListener(new ClearButtonListener());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        DatePicker = new com.toedter.calendar.JDateChooser();
        NameField = new javax.swing.JTextField();
        PassField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        MainUserTable = new javax.swing.JTable();
        nameLabel = new javax.swing.JLabel();
        passLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        birthLabel = new javax.swing.JLabel();
        AddButton = new javax.swing.JButton();
        EditButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        show_combo = new javax.swing.JComboBox<>();
        showsLabel = new javax.swing.JLabel();
        showsButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();
        signLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("MainFrame"); // NOI18N

        MainUserTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "user_id", "user_name", "user_pass", "user_email", "birthDate"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(MainUserTable);
        if (MainUserTable.getColumnModel().getColumnCount() > 0) {
            MainUserTable.getColumnModel().getColumn(0).setResizable(false);
            MainUserTable.getColumnModel().getColumn(1).setResizable(false);
            MainUserTable.getColumnModel().getColumn(2).setResizable(false);
            MainUserTable.getColumnModel().getColumn(3).setResizable(false);
            MainUserTable.getColumnModel().getColumn(4).setResizable(false);
        }

        nameLabel.setText("username:");

        passLabel.setText("password");

        emailLabel.setText("e-mail");

        birthLabel.setText("fecha nacimiento:");

        AddButton.setText("ADD");

        EditButton.setText("EDIT");

        DeleteButton.setText("DELETE");

        show_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "item 1" }));

        showsLabel.setText("available shows:");

        showsButton.setText("SHOWS");

        ClearButton.setText("CLEAR");

        signLabel.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        signLabel.setText("powered by slimm1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NameField)
                    .addComponent(nameLabel)
                    .addComponent(passLabel)
                    .addComponent(PassField, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailLabel)
                    .addComponent(birthLabel)
                    .addComponent(emailField))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(showsLabel)
                    .addComponent(show_combo, 0, 157, Short.MAX_VALUE)
                    .addComponent(showsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(EditButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AddButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(signLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ClearButton)
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(showsButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nameLabel)
                                .addGap(2, 2, 2)
                                .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(passLabel)
                                .addGap(0, 0, 0)
                                .addComponent(PassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(emailLabel)
                                    .addComponent(showsLabel))
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(show_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(birthLabel)
                                .addGap(0, 0, 0)
                                .addComponent(DatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(AddButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EditButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DeleteButton)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClearButton)
                    .addComponent(signLabel))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JDateChooser getDatePicker() {
        return DatePicker;
    }

    public JTextField getNameField() {
        return NameField;
    }

    public JTextField getPassField() {
        return PassField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JTable getMainUserTable() {
        return MainUserTable;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton ClearButton;
    private com.toedter.calendar.JDateChooser DatePicker;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton EditButton;
    private javax.swing.JTable MainUserTable;
    private javax.swing.JTextField NameField;
    private javax.swing.JTextField PassField;
    private javax.swing.JLabel birthLabel;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel passLabel;
    private javax.swing.JComboBox<String> show_combo;
    private javax.swing.JButton showsButton;
    private javax.swing.JLabel showsLabel;
    private javax.swing.JLabel signLabel;
    // End of variables declaration//GEN-END:variables
}
