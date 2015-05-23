/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entities.Customer;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import model.CustomerModel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author Damian Mamla
 */
public class CustomerJFrame extends javax.swing.JFrame {

    /**
     * Creates new form CustomerJFrame
     */
    private final CustomerModel customerModel = new CustomerModel();

    public CustomerJFrame() {
        initComponents();
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldPesel = new javax.swing.JTextField();
        jTextFieldFirstName = new javax.swing.JTextField();
        jTextFieldLastName = new javax.swing.JTextField();
        jTextFieldPhone = new javax.swing.JTextField();
        jTextFieldAdress = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jButtonAddNewCustomer = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Customer");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/icon/icon.png")).getImage());

        jLabel1.setText("PESEL");

        jLabel2.setText("First Name");

        jLabel3.setText("Last Name");

        jLabel4.setText("Phone");

        jLabel5.setText("Adress");

        jLabel6.setText("E-mail");

        jButtonAddNewCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/list-add1.png"))); // NOI18N
        jButtonAddNewCustomer.setText("Add New");
        jButtonAddNewCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddNewCustomerActionPerformed(evt);
            }
        });

        jButtonBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/go-previous1.png"))); // NOI18N
        jButtonBack.setText("Back");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldPesel, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                        .addComponent(jTextFieldLastName)
                        .addComponent(jTextFieldPhone)
                        .addComponent(jTextFieldAdress)
                        .addComponent(jTextFieldEmail))
                    .addComponent(jButtonAddNewCustomer, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPesel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddNewCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("SuspiciousIndentAfterControlStatement")
    private void jButtonAddNewCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddNewCustomerActionPerformed
        boolean customerExists = false;
        
        try {
            Customer foundCustomer = null;
            Customer customer = new Customer();
            String email = this.jTextFieldEmail.getText();
            String firstName = this.jTextFieldFirstName.getText();
            String lastName = this.jTextFieldLastName.getText();
            String adress = this.jTextFieldAdress.getText();
            String pesel = this.jTextFieldPesel.getText();
            String phone = this.jTextFieldPhone.getText();
            String showInputDialog = null;
            boolean isFill = true;
            if((EmailValidation(email))==false)
            {
                JOptionPane.showMessageDialog(null, "Invalid email. Please enter correct email.");
                return;
            }else
                
            if((PeselValidation(pesel))==false)
            {
                JOptionPane.showMessageDialog(null, "Invalid pesel. Please enter correct pesel."); 
                return;
            }else
                
            if((FirstNameValidation(firstName))==false)
            {
                JOptionPane.showMessageDialog(null, "Invalid First Name. Please enter correct First Name."); 
                return;
            }else 
                
            if((LastNameValidation(lastName))==false)
            {
                JOptionPane.showMessageDialog(null, "Invalid Last Name. Please enter correct Last Name."); 
                return;
            }else
                
            if((PhoneValidation(phone))==false)
            {
                JOptionPane.showMessageDialog(null, "Invalid phone number. Please enter correct phone number."); 
                return;
            }else
            
            if((AdressValidation(adress))==false)
            {
                JOptionPane.showMessageDialog(null, "Invalid Adress. Please enter correct adress."); 
                return;
            }else
                
            if (email.isEmpty()) {
                showInputDialog = "email";
                isFill = false;
            } else if (firstName.isEmpty()) {
                showInputDialog = "firstName";
                isFill = false;
            } else if (lastName.isEmpty()) {
                showInputDialog = "lastName";
                isFill = false;
            } else if (adress.isEmpty()) {
                showInputDialog = "adress";
                isFill = false;
            } else if (pesel.isEmpty()) {
                showInputDialog = "pesel";
                isFill = false;
            } else if (phone.isEmpty()) {
                showInputDialog = "phone";
                isFill = false;
            }
            if (isFill != false) {
                customer.setEmail(this.jTextFieldEmail.getText());
                customer.setFirstName(this.jTextFieldFirstName.getText());
                customer.setLastName((this.jTextFieldLastName.getText()));
                customer.setAdress(this.jTextFieldAdress.getText());
                customer.setPhone(Integer.parseInt(this.jTextFieldPhone.getText()));
                customer.setPesel(this.jTextFieldPesel.getText());
                foundCustomer = this.customerModel.findCustomer(customer);
            }
           
                 
            if (isFill == false) {
                JOptionPane.showMessageDialog(null, "Fill field: " + showInputDialog);
            } else if (foundCustomer == null) {
                try {
                customer.setEmail(this.jTextFieldEmail.getText());
                customer.setFirstName(this.jTextFieldFirstName.getText());
                customer.setLastName((this.jTextFieldLastName.getText()));
                customer.setAdress(this.jTextFieldAdress.getText());
                customer.setPhone(Integer.parseInt(this.jTextFieldPhone.getText()));
                customer.setPesel(this.jTextFieldPesel.getText());
                this.customerModel.create(customer);
                JOptionPane.showMessageDialog(null, "Add new customer successful");
                dispose();
                } catch (NumberFormatException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "There is such customer in Database!!!", "Warning!", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButtonAddNewCustomerActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed


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
            java.util.logging.Logger.getLogger(CustomerJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CustomerJFrame().setVisible(true);
            }
        });
    }
    
    public boolean EmailValidation(String customerEmail)
    {
       String regex = ".+@.+\\.[a-z]+";
       Pattern pattern = Pattern.compile(regex);
       Matcher matcher = pattern.matcher(customerEmail);      
       return matcher.matches();
    }
    @SuppressWarnings("SuspiciousIndentAfterControlStatement")
    public static boolean PeselValidation(String customerPesel) {
           int[] wagi = {1, 3, 7, 9, 1, 3, 7 ,9 ,1 ,3};
           if (customerPesel.length() != 11) return false;          
           int suma = 0;          
           for (int i = 0; i < 10; i++)
               suma += Integer.parseInt(customerPesel.substring(i, i+1)) * wagi[i];
           int cyfraKontrolna = Integer.parseInt(customerPesel.substring(10, 11));          
           suma %= 10;
           if(suma==0)
           {
               return (suma==cyfraKontrolna);
           }else
           suma = 10 - suma;       
           return (suma == cyfraKontrolna);
    }
       
    public boolean FirstNameValidation(String customerFirstName)
    {
       String regex = "[a-zA-Z]{3,12}";
       Pattern pattern = Pattern.compile(regex);
       Matcher matcher = pattern.matcher(customerFirstName);      
       return matcher.matches();
    }
       
    public boolean LastNameValidation(String customerLastName)
    {
       String regex = "[a-zA-Z]{3,12}-?[a-zA-Z]*"; 
       Pattern pattern = Pattern.compile(regex);
       Matcher matcher = pattern.matcher(customerLastName);      
       return matcher.matches();
    }
       
    public boolean PhoneValidation(String customerPhone)
    {
       String regex = "\\+?[0-9]{6,12}";
       Pattern pattern = Pattern.compile(regex);
       Matcher matcher = pattern.matcher(customerPhone);      
       return matcher.matches();
    }
       
    public boolean AdressValidation(String customerAdress)
    {
       String regex = "[a-zA-Z]{2,15}.+ [0-9]{2}-([0-9]){3}( [a-zA-Z]{2,15})";
       Pattern pattern = Pattern.compile(regex);
       Matcher matcher = pattern.matcher(customerAdress);       
       return matcher.matches();
    }
       
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddNewCustomer;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextFieldAdress;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldFirstName;
    private javax.swing.JTextField jTextFieldLastName;
    private javax.swing.JTextField jTextFieldPesel;
    private javax.swing.JTextField jTextFieldPhone;
    // End of variables declaration//GEN-END:variables
}
