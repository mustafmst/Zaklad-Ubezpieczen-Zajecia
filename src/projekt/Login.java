/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Damian Mamla
 */
public class Login extends javax.swing.JFrame {

    Container c;
    ConnectDB connection;
    
    public Login() {
        super("Login form");
        initComponents();
        connection = new ConnectDB();
        connection.DoConnect();

        Handler handle = new Handler();

        l_name.setText("Username");
        l_pass.setText("Password");
        button.setText("Login");

        button.addActionListener(handle);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setSize(200, 130);

    }

    //an inner class .You can also write as a separate class
    class Handler implements ActionListener {

        //must implement method
        //This is triggered whenever the user clicks the login button
        public void actionPerformed(ActionEvent ae) {
            //checks if the button clicked
            if (ae.getSource() == button) {
                char[] temp_pwd = t_pass.getPassword();
                String pwd = null;
                pwd = String.copyValueOf(temp_pwd);
                System.out.println("Username,Pwd:" + t_name.getText() + "," + pwd);

                if (checkLogin(t_name.getText(), pwd)) {
                    JOptionPane.showMessageDialog(null, "You have logged in successfully", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Login failed!", "Failed!!",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public Boolean checkLogin(String uname, String pwd) {
        try {

            connection.stmt.setString(1, uname);
            connection.stmt.setString(2, pwd);

            connection.rs = connection.stmt.executeQuery();

            if (connection.rs.next()) {
                System.out.println("tu");
                String login = connection.rs.getString("login");
                String pass = connection.rs.getString("password");
                int status = connection.rs.getInt("status");
               // Integer.valueOf(status);
                System.out.println(login + " " + pass + " !!!");
                
                if(UserStatus.ADVISOR == status) {
                    AdvisorFrame advisorFrame = new AdvisorFrame();
                    advisorFrame.setVisible(true);
                }else if(UserStatus.ACCOUNTANT == status) {
                    AccountantFrame accountantFrame = new AccountantFrame();
                    accountantFrame.setVisible(true);
                }
                else if(UserStatus.DIRECTOR == status) {
                    DirectorFrame directorFrame = new DirectorFrame();
                    directorFrame.setVisible(true);
                }
                else if(UserStatus.SECRETARY == status) {
                    SecretaryFrame secretaryFrame = new SecretaryFrame();
                    secretaryFrame.setVisible(true);
                }
                dispose();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {

            System.out.println("error while validating" + e);
            return false;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        l_name = new javax.swing.JLabel();
        l_pass = new javax.swing.JLabel();
        t_name = new javax.swing.JTextField();
        t_pass = new javax.swing.JPasswordField();
        button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        l_name.setText("Name");

        l_pass.setText("pass");

        button.setText("Login");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_pass)
                            .addComponent(l_name))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t_name, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_name)
                    .addComponent(t_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_pass)
                    .addComponent(t_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel l_name;
    private javax.swing.JLabel l_pass;
    private javax.swing.JTextField t_name;
    private javax.swing.JPasswordField t_pass;
    // End of variables declaration//GEN-END:variables
}
