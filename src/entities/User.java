/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/*
 * @author Damian Mamla
 */

@Entity
@Table(name="user")

public class User implements java.io.Serializable {
   
    
    private int     userId;
    private String  login;
    private String  password;
    private String  stanowisko;
    private int     status;
    
    public User() {
    }

	
    public User(String login) {
        this.login = login;
    }
    public User(int userId, String login, String password, String stanowisko, int status) {
       this.userId = userId;
       this.login = login;
       this.password = password;
       this.stanowisko = stanowisko;
       this.status = status;
    }

    /**
     * @return the userId
     */
    @Id
    
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the stanowisko
     */
    public String getStanowisko() {
        return stanowisko;
    }

    /**
     * @param stanowisko the stanowisko to set
     */
    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }
}
