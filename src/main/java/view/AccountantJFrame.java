/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.itextpdf.text.DocumentException;
import entities.Service;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import model.HibernateUtil;
import model.ServiceModel;
import model.UserIdentify;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import pdf.GeneratePDF;

/**
 *
 * @author Piotr Filipowicz, Damian Mamla
 */
public class AccountantJFrame extends javax.swing.JFrame {

    private final ServiceModel serviceModel = new ServiceModel();

    /**
     * Creates new form AccountantJFrame
     */
    public AccountantJFrame() {
        super("Welcome Accountant " + UserIdentify.imie + " " + UserIdentify.nazwisko);
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        transactionView();
    }
    
    public AccountantJFrame(String imie, String nazwisko) {
        super("Transactions");
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        transactionView();
    }
    
    	
    /** TODO
        if(UserIdentify.status != UserStatus.ACCOUNTANT){
            jButtonLogout.setVisible(false);
        } 
        else
        {
            jButtonBack.setVisible(false);
        }
    **/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAccountant = new javax.swing.JTable();
        GeneratePDFjButton = new javax.swing.JButton();
        jButtonLogout = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();
        jDateChooserOd = new com.toedter.calendar.JDateChooser();
        jDateChooserDo = new com.toedter.calendar.JDateChooser();
        jLabelFrom = new javax.swing.JLabel();
        jLabelTo = new javax.swing.JLabel();
        jButtonFind = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/icon/icon.png")).getImage());

        jTableAccountant.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Advisor", "Customer", "Description", "Insurance Price", "Service Price", "Cost", "Date"
            }
        ));
        jTableAccountant.setRowHeight(32);
        jScrollPane1.setViewportView(jTableAccountant);

        GeneratePDFjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/x-office-document1.png"))); // NOI18N
        GeneratePDFjButton.setText("Generate PDF");
        GeneratePDFjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GeneratePDFjButtonActionPerformed(evt);
            }
        });

        jButtonLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/system-log-out1.png"))); // NOI18N
        jButtonLogout.setText("Logout");
        jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutActionPerformed(evt);
            }
        });

        jButtonBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/go-previous1.png"))); // NOI18N
        jButtonBack.setText("Back");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        jLabelFrom.setText("Date From");

        jLabelTo.setText("Date To");

        jButtonFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit-find-replace1.png"))); // NOI18N
        jButtonFind.setText("Find");
        jButtonFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFindActionPerformed(evt);
            }
        });

        jButtonClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit-clear1.png"))); // NOI18N
        jButtonClear.setText("Clear");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(GeneratePDFjButton)
                        .addGap(117, 117, 117)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelFrom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelTo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jDateChooserDo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonClear))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jDateChooserOd, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonFind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(101, 101, 101)
                        .addComponent(jButtonBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonLogout))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonFind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooserOd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelFrom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonLogout))
                    .addComponent(jDateChooserDo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelTo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(GeneratePDFjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void transactionView() {
        List<Service> wynik = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) this.jTableAccountant.getModel();
        model.setRowCount(0);
        try {
            for (Service c : this.serviceModel.findAll()) {
                wynik.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Service c : wynik) {
            model.addRow(new Object[]{c.getUserFk().getImie() + " " + c.getUserFk().getNazwisko(), c.getPeselFk().getFirstName() + " " + c.getPeselFk().getLastName(), c.getDescription(), c.getInsuranceCost(), c.getServiceCost(), c.getInsuranceCost() + c.getServiceCost(), c.getDateOfService()});
        }
    }

    @SuppressWarnings("null")
    private void transactionViewWithDate(Date from, Date to) {
        List<Service> wynik = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) this.jTableAccountant.getModel();
        model.setRowCount(0);
        try {
            for (Service c : this.serviceModel.findAll()) {
                wynik.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Service c : wynik) {
            if (from == null && c.getDateOfService().getDate() < to.getDate()) {
                model.addRow(new Object[]{c.getUserFk().getImie() + " " + c.getUserFk().getNazwisko(), c.getPeselFk().getFirstName() + " " + c.getPeselFk().getLastName(), c.getDescription(), c.getInsuranceCost(), c.getServiceCost(), c.getInsuranceCost() + c.getServiceCost(), c.getDateOfService()});
            } else if (to == null && c.getDateOfService().getDate() > from.getDate()) {
                model.addRow(new Object[]{c.getUserFk().getImie() + " " + c.getUserFk().getNazwisko(), c.getPeselFk().getFirstName() + " " + c.getPeselFk().getLastName(), c.getDescription(), c.getInsuranceCost(), c.getServiceCost(), c.getInsuranceCost() + c.getServiceCost(), c.getDateOfService()});
            } else if (from != null && to != null && c.getDateOfService().getDate() <= to.getDate() && c.getDateOfService().getDate() >= from.getDate()) {
                model.addRow(new Object[]{c.getUserFk().getImie() + " " + c.getUserFk().getNazwisko(), c.getPeselFk().getFirstName() + " " + c.getPeselFk().getLastName(), c.getDescription(), c.getInsuranceCost(), c.getServiceCost(), c.getInsuranceCost() + c.getServiceCost(), c.getDateOfService()});
            }
        }
    }
    private void GeneratePDFjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GeneratePDFjButtonActionPerformed
        String filepath = "accountant.pdf";

        FileFilter pdf = new FileNameExtensionFilter("PDF File", "pdf");
        File workingDirectory = new File(System.getProperty("user.dir"));

        JFileChooser fs = new JFileChooser();
        fs.setDialogTitle("Save file as...");
        fs.addChoosableFileFilter(pdf);
        fs.setFileFilter(pdf);
        fs.setCurrentDirectory(workingDirectory);

        int result = fs.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File fi = fs.getSelectedFile();
            try {
                filepath = fi.getPath() + ".pdf";
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, e2.getMessage());
            }
        }

        try {
            new GeneratePDF().createPdf(filepath);
        } catch (DocumentException ex) {
            Logger.getLogger(AccountantJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AccountantJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        JOptionPane.showMessageDialog(null, "Document " + filepath + " has been generated!", "Success",
                JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_GeneratePDFjButtonActionPerformed


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

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jButtonFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFindActionPerformed
        
        Date dateTo = jDateChooserDo.getDate(); 
        Date dateFrom = jDateChooserOd.getDate();
        if (dateTo != null && dateFrom != null) {
            if (dateTo.getDate() >= dateFrom.getDate()) {
                transactionViewWithDate(dateFrom, dateTo);
            } else {
                JOptionPane.showMessageDialog(null, "Date From can not be bigger than Date To", "Fail",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (dateTo != null) {
            transactionViewWithDate(null, dateTo);
        } else if (dateFrom != null) {
            transactionViewWithDate(dateFrom, null);
        } else {
                JOptionPane.showMessageDialog(null, "Bad date!!!", "Error",
                    JOptionPane.ERROR_MESSAGE);           
        }
    }//GEN-LAST:event_jButtonFindActionPerformed

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        jDateChooserOd.setDate(null);
        jDateChooserDo.setDate(null);
    }//GEN-LAST:event_jButtonClearActionPerformed

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
            java.util.logging.Logger.getLogger(AccountantJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountantJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountantJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountantJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AccountantJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GeneratePDFjButton;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonFind;
    private javax.swing.JButton jButtonLogout;
    private com.toedter.calendar.JDateChooser jDateChooserDo;
    private com.toedter.calendar.JDateChooser jDateChooserOd;
    private javax.swing.JLabel jLabelFrom;
    private javax.swing.JLabel jLabelTo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAccountant;
    // End of variables declaration//GEN-END:variables

}
