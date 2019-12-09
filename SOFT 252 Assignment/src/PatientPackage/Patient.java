/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientPackage;

import DatabasePackage.IUser;

/**
 *
 * @author afernandez
 */
public class Patient implements IUser{
    private String userFirstname;
    private String userID;
    private String userSurname;
    private String userAddress;
    String userPassword;
    private int userAge;
    private String userGender;

    public Patient(String userID, String userFirstname,  String userSirname, String userAddress, String userPassword, int userAge, String userGender) {
        this.userFirstname = userFirstname;
        this.userID = userID;
        this.userSurname = userSirname;
        this.userAddress = userAddress;
        this.userPassword = userPassword;
        this.userAge = userAge;
        this.userGender = userGender;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
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
        return userSurname;
    }

    @Override
    public void setUserSurname(String userSirname) {
        this.userSurname = userSirname;
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
