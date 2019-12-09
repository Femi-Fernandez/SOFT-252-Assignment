/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft.pkg252.assignment;

import AdminPackage.Admin;
import PatientPackage.Patient;
import DoctorPackage.Doctor;
import SecretaryPackage.Secretary;
/**
 *
 * @author afernandez
 */
public class UserFactory {
    
    public IUser getUserType(String userType){
        
    char firstChar = userType.charAt(0);
    
        if (firstChar == 'A') {
            return new Admin();
        }
        if (firstChar == 'D') {
            return new Doctor();
        }
        if (firstChar == 'P') {
            return new Patient();
        }
        if (firstChar == 'S') {
            return new Secretary();
        }
        else{
        return null;
        }
        
    }
    
}
