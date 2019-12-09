/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft.pkg252.assignment;

/**
 *
 * @author afernandez
 */
public interface IUser {
    String userID = "";
    String userFirstname = "";
    String userSurname = "";
    String userAddress = "";
    
     void NewUser(String ID, String firstname, String surname, String address);
     
     
}
