/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminPackage;

import DatabasePackage.IUser;

/**
 *
 * @author afernandez
 */
public class Admin implements IUser {
    private String userFirstname;
    private String userID;
    private String userSirname;
    private String userAddress; 
    private String userPassword;

    public Admin(String userID, String userFirstname,  String userSirname, String userAddress, String userPassword) {
        this.userFirstname = userFirstname;
        this.userID = userID;
        this.userSirname = userSirname;
        this.userAddress = userAddress;
        this.userPassword = userPassword;
    }


    
        @Override
    public String getUserFirstname() {
        return userFirstname;
    }
    
    @Override
    public void setUserFirstname(String userFirstname) {
        this.userFirstname = userFirstname;
    }

    @Override
    public String getUserID() {
        return userID;
    }

    @Override
    public void setUserID(String userID) {
        this.userID = userID;
    }
    @Override
    public String getUserSurname() {
        return userSirname;
    }

    @Override
    public void setUserSurname(String userSirname) {
        this.userSirname = userSirname;
    }
    
    @Override
    public String getUserAddress() {
        return userAddress;
    }

    @Override
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
    
        @Override
    public String getUserPassword(){
        return userPassword;
    }

    @Override
    public void setUserPassword(String userPassword){
        this.userPassword = userPassword;
    }
}
