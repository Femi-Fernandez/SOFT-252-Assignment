/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabasePackage;

/**
 *
 * @author afernandez
 */

//interface for all the users. userGender and userAge is only used by the patient
public interface IUser {
    String userID = "";
    String userFirstname = "";
    String userSurname = "";
    String userAddress = "";
    String userPassword = "";
    String userGender = "";
    String userAge = "";
    boolean isPatient = false;
    
    public String getUserID();
    public String getUserFirstname();
    public String getUserSurname();
    public String getUserAddress();
    public String getUserPassword();
    public String getUserGender();
    public String getUserAge();
    
    public void setUserID(String ID);
    public void setUserFirstname(String firstname);
    public void setUserSurname(String surname);
    public void setUserAddress(String address);
    public void setUserPassword(String password);
    public void setUserGender(String gender);
    public void setUserAge(String age);
     
}
