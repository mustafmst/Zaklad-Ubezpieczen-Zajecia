/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Damian Mamla
 */
public class ConnectDB {

    Connection con;
    PreparedStatement stmt;
    ResultSet rs;

    public void DoConnect() {
        try {
            String host = "jdbc:mysql://localhost:3306/projekt";
            String uName = "root";
            String uPass = "root";
            con = DriverManager.getConnection(host, uName, uPass);
            stmt = con.prepareStatement("select * from User where login=? and password=MD5(?)");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }

}

  
