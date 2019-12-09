/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoctorPackage;

import soft.pkg252.assignment.IUser;

/**
 *
 * @author afernandez
 */
public class Doctor implements IUser {
    private String userFirstname;
    private String userID;
    private String userSirname;
    private String userAddress;    

        @Override
    public void NewUser(String ID, String firstname, String surname, String address)
    {
        
    }
    
    public String getUserFirstname() {
        return userFirstname;
    }

    public void setUserFirstname(String userFirstname) {
        this.userFirstname = userFirstname;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserSirname() {
        return userSirname;
    }

    public void setUserSirname(String userSirname) {
        this.userSirname = userSirname;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    
}
