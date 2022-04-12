/*
 * Created by JFormDesigner on Thu Apr 07 18:53:20 TRT 2022
 */

package views;
import java.awt.event.*;
import models.ServiceImpl;
import models.UserImpl;
import props.Service;
import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class Services extends Base {
    ServiceImpl service = new ServiceImpl();
    public Services() {
        initComponents();
        lblName.setText("Merhaba, " + UserImpl.name);
        tblServiceCustomer.setModel(service.serviceCustomerTable(null));
        tblServiceService.setModel(service.serviceServiceTable());
    }
    int row = -1;
    int cid = 0;
    int sid = 0;
    int column = 0;
    int scolumn = 0;

    private Service fncDataValid(){
        row = tblServiceCustomer.getSelectedRow();
        String title=txtTitle.getText().trim();
        String info=txtDetails.getText().trim();
        int days= Integer.parseInt(txtDays.getText().trim());
        String date = txtDate.getText().trim();
        int status = Integer.parseInt(txtStatus.getText().trim());
        cid = Integer.valueOf(tblServiceCustomer.getModel().getValueAt(row,column).toString());

        if (title.equals("")){
            lblError.setText("Title is Empty!!!");
            txtTitle.requestFocus();
        }else if (info.equals("")){
            lblError.setText("Surname is Empty!!!");
            txtDetails.requestFocus();
        }else if (days == 0){
            lblError.setText("Days is Empty!!!");
            txtDays.requestFocus();
        }
        else if (date.equals("")){
            lblError.setText("Date is Empty!!!");
            txtDate.requestFocus();
        }
        else if (status > 3){
            lblError.setText("Enter a valid status value");
            txtStatus.requestFocus();
        }
        else {
            lblError.setText("");
            Service s = new Service(0,cid,title,info,days,date,status);
            return s;
        }
        return null;

    }

    private void thisWindowClosing(WindowEvent e) {
        new Dashboard().setVisible(true);
    }


    private void txtCustomerSearchKeyReleased(KeyEvent e) {
        String txtSearch = txtCustomerSearch.getText().trim();
        tblServiceCustomer.setModel(service.serviceCustomerTable(txtSearch));
    }


    private void btnAddServiceClick(ActionEvent e) {
        Service s = fncDataValid();
        if(s!=null){
            int status = service.serviceInsert(s);
            if (status>0){
                System.out.println("Insert Success");
                txtTitle.setText("");
                txtDetails.setText("");
                txtDate.setText("");
                txtDays.setText("");
                txtStatus.setText("");
                tblServiceService.setModel(service.serviceServiceTable());
            }
            else {
                if (status == -1){
                    lblError.setText("E-mail or Phone have already used");
                }
                else {
                    lblError.setText("Insert Error");
                }
            }
        }
    }

    private void tblServiceServiceKeyReleased(KeyEvent e) {
        rowVal();
    }

    private void tblServiceServiceMouseClicked(MouseEvent e) {
        rowVal();
    }
    void rowVal(){
        row = tblServiceService.getSelectedRow();
        String title = (String) tblServiceService.getValueAt(row, 2);
        String info = (String) tblServiceService.getValueAt(row, 3);
        int days = (int) tblServiceService.getValueAt(row, 4);
        String date = (String) tblServiceService.getValueAt(row, 5);
        int status = (int) tblServiceService.getValueAt(row, 6);

        txtTitle.setText(title);
        txtDetails.setText(info);
        txtDays.setText(String.valueOf(days));
        txtDate.setText(date);
        txtStatus.setText(String.valueOf(status));

    }

    private void btnServiceUpdateClick(ActionEvent e) {
        Service s = fncDataValid();
        if(row != -1 ) {
            row = tblServiceService.getSelectedRow();
            sid = Integer.valueOf(tblServiceService.getModel().getValueAt(row,scolumn).toString());
            int answer = JOptionPane.showConfirmDialog(this, "Are you sure you want to update?", "Update process", JOptionPane.YES_NO_OPTION);
            if (answer == 0) {
                service.serviceUpdate(s,sid);
                tblServiceService.setModel(service.serviceServiceTable());
                row = -1;
            }
        }else{
            JOptionPane.showMessageDialog(this, "Please choose");
        }
    }

    private void btnDeleteServiceClick(ActionEvent e) {
        if(row != -1 ) {
            row = tblServiceService.getSelectedRow();
            sid = Integer.valueOf(tblServiceService.getModel().getValueAt(row,scolumn).toString());
            int answer = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete?", "Deletion action", JOptionPane.YES_NO_OPTION);
            if(answer==0){
                service.serviceDelete(sid);
                tblServiceService.setModel(service.serviceServiceTable());
                row = -1;
            }
        } else{
            JOptionPane.showMessageDialog(this, "Please choose");
        }
    }

    private void tblServiceMouseReleased(MouseEvent e) {
        // TODO add your code here
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        lblName = new JLabel();
        label3 = new JLabel();
        txtCustomerSearch = new JTextField();
        scrollPane1 = new JScrollPane();
        tblServiceCustomer = new JTable();
        panel1 = new JPanel();
        label4 = new JLabel();
        txtTitle = new JTextField();
        label5 = new JLabel();
        txtDays = new JTextField();
        label6 = new JLabel();
        scrollPane2 = new JScrollPane();
        txtDetails = new JTextArea();
        lblError = new JLabel();
        txtStatus = new JTextField();
        label7 = new JLabel();
        txtDate = new JTextField();
        label8 = new JLabel();
        scrollPane3 = new JScrollPane();
        tblServiceService = new JTable();
        btnAdd = new JButton();
        btnUpdate = new JButton();
        btnDelete = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing(e);
            }
        });
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Technical Service");
        label1.setBackground(new Color(0, 102, 102));
        label1.setForeground(Color.black);

        //---- lblName ----
        lblName.setText(" ");
        lblName.setBackground(new Color(0, 102, 102));
        lblName.setForeground(Color.black);

        //---- label3 ----
        label3.setText("Customer Search");

        //---- txtCustomerSearch ----
        txtCustomerSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                txtCustomerSearchKeyReleased(e);
            }
        });

        //======== scrollPane1 ========
        {

            //---- tblServiceCustomer ----
            tblServiceCustomer.setBackground(new Color(255, 255, 153));
            scrollPane1.setViewportView(tblServiceCustomer);
        }

        //======== panel1 ========
        {
            panel1.setBackground(new Color(255, 255, 153));

            //---- label4 ----
            label4.setText("Title");

            //---- label5 ----
            label5.setText("Days");

            //---- label6 ----
            label6.setText("Details");

            //======== scrollPane2 ========
            {
                scrollPane2.setViewportView(txtDetails);
            }

            //---- lblError ----
            lblError.setText(" ");

            //---- label7 ----
            label7.setText("Status");

            //---- label8 ----
            label8.setText("Date");

            //======== scrollPane3 ========
            {

                //---- tblServiceService ----
                tblServiceService.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        tblServiceServiceMouseClicked(e);
                    }
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        tblServiceMouseReleased(e);
                    }
                });
                tblServiceService.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        tblServiceServiceKeyReleased(e);
                    }
                });
                scrollPane3.setViewportView(tblServiceService);
            }

            //---- btnAdd ----
            btnAdd.setIcon(new ImageIcon(getClass().getResource("/add_icon.png")));
            btnAdd.setBackground(new Color(153, 255, 255));
            btnAdd.addActionListener(e -> btnAddServiceClick(e));

            //---- btnUpdate ----
            btnUpdate.setIcon(new ImageIcon(getClass().getResource("/update_icon.png")));
            btnUpdate.setBackground(new Color(153, 255, 255));
            btnUpdate.addActionListener(e -> btnServiceUpdateClick(e));

            //---- btnDelete ----
            btnDelete.setIcon(new ImageIcon(getClass().getResource("/delete_icon.png")));
            btnDelete.setBackground(new Color(153, 255, 255));
            btnDelete.addActionListener(e -> btnDeleteServiceClick(e));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(label4)
                                    .addComponent(label8)
                                    .addComponent(label7)
                                    .addComponent(label5))
                                .addGap(27, 27, 27))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(label6)
                                .addGap(18, 18, 18)))
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(lblError, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(67, Short.MAX_VALUE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtDate)
                                        .addComponent(txtStatus, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                                    .addComponent(txtTitle, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDays, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                        .addGap(0, 159, Short.MAX_VALUE)
                                        .addComponent(btnAdd)
                                        .addGap(55, 55, 55)
                                        .addComponent(btnUpdate)
                                        .addGap(58, 58, 58)
                                        .addComponent(btnDelete)
                                        .addGap(36, 36, 36))))))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label4)
                                    .addComponent(txtTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDays, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label5))
                                .addGap(18, 18, 18)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label7))
                                .addGap(20, 20, 20)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label8))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(label6)
                                        .addGap(17, 17, 17))))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblError)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnAdd)
                                    .addComponent(btnDelete)
                                    .addComponent(btnUpdate))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                            .addGap(388, 388, 388)
                            .addComponent(lblName, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(label3)
                                    .addGap(1070, 1070, 1070))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE)))))
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(txtCustomerSearch, GroupLayout.PREFERRED_SIZE, 572, GroupLayout.PREFERRED_SIZE)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 688, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(4, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1)
                        .addComponent(lblName))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(txtCustomerSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(13, 13, 13)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel lblName;
    private JLabel label3;
    private JTextField txtCustomerSearch;
    private JScrollPane scrollPane1;
    private JTable tblServiceCustomer;
    private JPanel panel1;
    private JLabel label4;
    private JTextField txtTitle;
    private JLabel label5;
    private JTextField txtDays;
    private JLabel label6;
    private JScrollPane scrollPane2;
    private JTextArea txtDetails;
    private JLabel lblError;
    private JTextField txtStatus;
    private JLabel label7;
    private JTextField txtDate;
    private JLabel label8;
    private JScrollPane scrollPane3;
    private JTable tblServiceService;
    private JButton btnAdd;
    private JButton btnUpdate;
    private JButton btnDelete;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}