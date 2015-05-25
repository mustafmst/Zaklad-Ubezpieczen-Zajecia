/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entities.Customer;
import entities.Service;
import entities.User;
import java.awt.HeadlessException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.CustomerModel;
import model.ServiceModel;
import model.UserIdentify;

/**
 *
 * @author Damian Mamla
 */
public class ServiceJFrame extends javax.swing.JFrame {

    private final ServiceModel serviceModel = new ServiceModel();
    private int day;
    private int month;
    private int year;    
    private final CustomerModel customerModel = new CustomerModel();
    /**
     * Creates new form ServiceJFrame
     *
     *
     */
    public ServiceJFrame() {
        super();
        setComboBox();
    }
    
    
    public ServiceJFrame(int dd, int mm, int yy) {
        super("Add Service");   
        initComponents();      
        this.day = dd;
        this.month = mm + 1; //add 1 month because we have indexes from 0
        this.year = yy;
        setVisible(true);
        setComboBox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldInsuranceCost = new javax.swing.JTextField();
        jTextFieldServiceCost = new javax.swing.JTextField();
        jButtonAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescription = new javax.swing.JTextArea();
        jButtonBack = new javax.swing.JButton();
        jComboBoxPesel = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/icon/icon.png")).getImage());

        jLabel1.setText("Customer Pesel");

        jLabel2.setText("Service Cost $");

        jLabel3.setText("Insurance Cost $");

        jLabel4.setText("Service Description");

        jTextFieldInsuranceCost.setToolTipText("e.g. 120.99");
        jTextFieldInsuranceCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldInsuranceCostActionPerformed(evt);
            }
        });

        jTextFieldServiceCost.setToolTipText("e.g. 120.99");
        jTextFieldServiceCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldServiceCostActionPerformed(evt);
            }
        });

        jButtonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/list-add1.png"))); // NOI18N
        jButtonAdd.setText("Add");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jTextAreaDescription.setColumns(5);
        jTextAreaDescription.setLineWrap(true);
        jTextAreaDescription.setRows(5);
        jTextAreaDescription.setToolTipText("10-255 characters");
        jScrollPane1.setViewportView(jTextAreaDescription);

        jButtonBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/go-previous1.png"))); // NOI18N
        jButtonBack.setText("Back");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        jComboBoxPesel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));
        jComboBoxPesel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPeselActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel3)
                    .addComponent(jButtonBack))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldInsuranceCost, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jComboBoxPesel, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldServiceCost, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                    .addComponent(jButtonAdd)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPesel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldServiceCost, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldInsuranceCost, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldInsuranceCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldInsuranceCostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldInsuranceCostActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed

        Service service = new Service();
        String pesel = jComboBoxPesel.getSelectedItem().toString();
        String sCost =this.jTextFieldServiceCost.getText();
        String iCost =this.jTextFieldInsuranceCost.getText();
        String description = this.jTextAreaDescription.getText();
        if((ServiceCostValidation(sCost))==false)
            {
                JOptionPane.showMessageDialog(null, "Invalid Service Cost. Please enter correct. E.g. 120.99"); 
                return;
            }else 
        if((InsuranceCostValidation(iCost))==false)
            {
                JOptionPane.showMessageDialog(null, "Invalid Insurance Cost. Please enter correct. E.g. 120.99"); 
                return;
            }
         if((ServiceDescriptionValidation(description))==false)
            {
                JOptionPane.showMessageDialog(null, "Invalid description. Please enter correct description(10-255 characters)"); 
                return;
            }
        Float serviceCost = Float.parseFloat(sCost);
        Float insuranceCost = Float.parseFloat(iCost);
        
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy");  
        if (pesel.isEmpty() || serviceCost == null || insuranceCost == null || description.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fill field: ");
        } else {
            try {
                User user = new User();
                user.setUserId(UserIdentify.userId);
                Customer customer = new Customer();
                customer.setPesel(pesel);
                service.setDateOfAddService(cal.getTime());
                String y = Integer.toString(year);
                String m = Integer.toString(month);
                String d = Integer.toString(day);
                String stringDate = d + "-" + m + "-" + y;
                service.setDateOfService(dateFormat.parse(stringDate));
                service.setDescription(description);
                service.setInsuranceCost(insuranceCost);
                service.setPeselFk(customer);
                service.setServiceCost(serviceCost);
                service.setUserFk(user);
                this.serviceModel.create(service);
                JOptionPane.showMessageDialog(null, "Add new service successful");
                dispose();
            } catch (NumberFormatException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (ParseException ex) {
                Logger.getLogger(ServiceJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jTextFieldServiceCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldServiceCostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldServiceCostActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jComboBoxPeselActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPeselActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPeselActionPerformed

    /**
     * @param args the command line arguments
     */   
    private void setComboBox() {
       DefaultComboBoxModel model = (DefaultComboBoxModel) this.jComboBoxPesel.getModel();       
       List<Customer> listOfCustomer = customerModel.findAll();
       for(Customer customer : listOfCustomer) {
           model.addElement(customer.getPesel());
       }   
    }
       public boolean ServiceCostValidation(String serviceCost)
    {
       String regex = "[0-9]+\\.?[0-9]+";
       Pattern pattern = Pattern.compile(regex);
       Matcher matcher = pattern.matcher(serviceCost);      
       return matcher.matches();
    }
       
    public boolean InsuranceCostValidation(String insuranceCost)
    {
       String regex = "[0-9]+\\.?[0-9]+"; 
       Pattern pattern = Pattern.compile(regex);
       Matcher matcher = pattern.matcher(insuranceCost);      
       return matcher.matches();
    } 
    
    public boolean ServiceDescriptionValidation(String serviceDescription)
    {
       String regex = ".{10,255}"; 
       Pattern pattern = Pattern.compile(regex);
       Matcher matcher = pattern.matcher(serviceDescription);      
       return matcher.matches();
    } 
    
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServiceJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServiceJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServiceJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServiceJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ServiceJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JComboBox jComboBoxPesel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaDescription;
    private javax.swing.JTextField jTextFieldInsuranceCost;
    private javax.swing.JTextField jTextFieldServiceCost;
    // End of variables declaration//GEN-END:variables
}
