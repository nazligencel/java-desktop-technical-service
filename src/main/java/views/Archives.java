/*
 * Created by JFormDesigner on Sun Apr 10 17:18:38 TRT 2022
 */

package views;

import models.ArchiveImpl;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class Archives extends Base {
    ArchiveImpl archive = new ArchiveImpl();
    public Archives() {
        initComponents();
        tblArchive.setModel(archive.archiveTable());
    }

    private void thisWindowClosing(WindowEvent e) {
        new Dashboard().setVisible(true);
    }

    private void txtCustomerSearchKeyReleased(KeyEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        lblName = new JLabel();
        label1 = new JLabel();
        txtServiceSearch = new JTextField();
        label3 = new JLabel();
        tblArchive = new JTable();

        //======== this ========
        Container contentPane = getContentPane();

        //---- lblName ----
        lblName.setText(" ");
        lblName.setBackground(new Color(0, 102, 102));
        lblName.setForeground(Color.black);

        //---- label1 ----
        label1.setText("Technical Service");
        label1.setBackground(new Color(0, 102, 102));
        label1.setForeground(Color.black);

        //---- txtServiceSearch ----
        txtServiceSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                txtCustomerSearchKeyReleased(e);
            }
        });

        //---- label3 ----
        label3.setText("Service Search");

        //---- tblArchive ----
        tblArchive.setBackground(new Color(255, 255, 153));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                            .addGap(388, 388, 388)
                            .addComponent(lblName, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label3)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtServiceSearch))
                                .addComponent(tblArchive, GroupLayout.PREFERRED_SIZE, 678, GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1)
                        .addComponent(lblName))
                    .addGap(37, 37, 37)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(txtServiceSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                    .addComponent(tblArchive, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                    .addGap(95, 95, 95))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel lblName;
    private JLabel label1;
    private JTextField txtServiceSearch;
    private JLabel label3;
    private JTable tblArchive;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}