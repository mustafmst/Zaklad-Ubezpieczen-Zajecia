/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entities.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.CustomerModel;
import model.HibernateUtil;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author Damian Mamla
 */
public class DirectorJFrame extends javax.swing.JFrame {

    private final CustomerModel customerModel = new CustomerModel();
    
    /**
     * Creates new form DirectorJFrame
     */
    public DirectorJFrame() {
        super("Welcome Director");
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAddEmployee = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButtonSearch = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jTextFieldSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCustomers = new javax.swing.JTable();
        jButtonLogout = new javax.swing.JButton();
        jButtonChanges = new javax.swing.JButton();
        Calender = new javax.swing.JButton();
        jButtonTransactions = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/icon/icon.png")).getImage());

        jButtonAddEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/list-add1.png"))); // NOI18N
        jButtonAddEmployee.setText("Add new employee");
        jButtonAddEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddEmployeeActionPerformed(evt);
            }
        });

        jLabel4.setText("Search for customers:");

        jButtonSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/system-search1.png"))); // NOI18N
        jButtonSearch.setText("Search");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/list-add1.png"))); // NOI18N
        jButton1.setText("Add customer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyPressed(evt);
            }
        });

        jTableCustomers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First Name", "Last Name", "PESEL", "Adress", "E-mail", "Phone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableCustomers);

        jButtonLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/system-log-out1.png"))); // NOI18N
        jButtonLogout.setText("Logout");
        jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutActionPerformed(evt);
            }
        });

        jButtonChanges.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit-find1.png"))); // NOI18N
        jButtonChanges.setText("Search Changes");
        jButtonChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChangesActionPerformed(evt);
            }
        });

        Calender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/x-office-calendar1.png"))); // NOI18N
        Calender.setText("Calender");
        Calender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalenderActionPerformed(evt);
            }
        });

        jButtonTransactions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/image-loading2.png"))); // NOI18N
        jButtonTransactions.setText("Transactions");
        jButtonTransactions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTransactionsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButtonSearch)
                            .addGap(62, 62, 62)
                            .addComponent(jButton1)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAddEmployee)
                        .addGap(45, 45, 45)
                        .addComponent(jButtonTransactions)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonChanges, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Calender, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonLogout)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonChanges, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Calender, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonTransactions, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLogout))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddEmployeeActionPerformed
        EmployeeJFrame addEmployeeJFrame = new EmployeeJFrame();
        addEmployeeJFrame.setVisible(true);
    }//GEN-LAST:event_jButtonAddEmployeeActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        clientSearch();
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CustomerJFrame addCustomerJFrame = new CustomerJFrame();
        addCustomerJFrame.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyPressed
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER)
        {
            this.clientSearch();
        }
    }//GEN-LAST:event_jTextFieldSearchKeyPressed

    private void jButtonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoutActionPerformed
   
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = "{call ProcedureTempLogin()}";
        SQLQuery query = session.createSQLQuery(sql);
        query.executeUpdate();
        session.getTransaction().commit();
       
        LoginJFrame loginFrame = new LoginJFrame();
        loginFrame.setVisible(true);
   
        dispose();
    }//GEN-LAST:event_jButtonLogoutActionPerformed

    private void jButtonChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChangesActionPerformed
        HistoryJFrame historyJFrame = new HistoryJFrame();
        historyJFrame.setVisible(true);    
    }//GEN-LAST:event_jButtonChangesActionPerformed

    private void CalenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalenderActionPerformed
       CalendarJFrame calendarFrame = new CalendarJFrame();
       calendarFrame.setVisible(true);
    }//GEN-LAST:event_CalenderActionPerformed

    private void jButtonTransactionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTransactionsActionPerformed
        AccountantJFrame accountantFrame = new AccountantJFrame();
        accountantFrame.setVisible(true);
    }//GEN-LAST:event_jButtonTransactionsActionPerformed
    
    private void clientSearch(){
        String[] search = this.jTextFieldSearch.getText().split(" ");
        int searchInt;
        int tmp;
        List<Customer> wynik = new ArrayList<Customer>();
        DefaultTableModel model = (DefaultTableModel) this.jTableCustomers.getModel();
        model.setRowCount(0);
        
        try{            
            for(Customer c : this.customerModel.findAll()){
                tmp=0;
                for(String s: search){
                    try{
                        searchInt = Integer.parseInt(s);
                    }catch(NumberFormatException e){
                        searchInt = 0;
                    }
                    if( (s.equals(c.getFirstName())) || (s.equals(c.getLastName())) || (s.equals(c.getEmail())) || (s.equals(c.getAdress())) || (s.equals(c.getPesel())) || (searchInt == c.getPhone()) ){
                    //wynik.add(c);
                        tmp++;
                    }
                }
                if(tmp == search.length) wynik.add(c);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        for(Customer c : wynik ){
            model.addRow(new Object[]{c.getFirstName(),c.getLastName(),c.getPesel(),c.getAdress(),c.getEmail(),c.getPhone()});
        }
        
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DirectorJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DirectorJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Calender;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAddEmployee;
    private javax.swing.JButton jButtonChanges;
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonTransactions;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCustomers;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables
}
