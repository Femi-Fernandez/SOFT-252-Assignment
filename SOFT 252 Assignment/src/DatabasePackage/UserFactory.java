/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabasePackage;

import AdminPackage.Admin;
import PatientPackage.Patient;
import DoctorPackage.Doctor;
import SecretaryPackage.Secretary;
/**
 *
 * @author afernandez
 */
public class UserFactory {
    
    public static void getUserType(String userID, String firstname, String surname, 
            String address, String password, String age, String gender){
        
    char firstChar = userID.charAt(0);
    
        if (firstChar == 'A') {
            Admin newAdmin = new Admin(userID, firstname,  surname, address, password);
            SystemDatabase.userArray.add(newAdmin);
        }
        if (firstChar == 'D') {
            Doctor newDoctor = new Doctor(userID, firstname,  surname, address, password);
            SystemDatabase.userArray.add(newDoctor);
        }
        if (firstChar == 'P') {
            Patient newPatient = new Patient(userID, firstname,  surname, address, password, age, gender);
            SystemDatabase.userArray.add(newPatient);
        }
        if (firstChar == 'S') {
            Secretary newSecretary = new Secretary(userID, firstname,  surname, address, password);
            SystemDatabase.userArray.add(newSecretary);
            //System.out.println("added to array!");
        }
        else{
        
        }
        
    }
    
}
