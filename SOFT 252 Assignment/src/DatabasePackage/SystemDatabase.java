/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabasePackage;
import PatientPackage.Patient;
import SystemPackage.AccountRequest;
import SystemPackage.Appointment;
import SystemPackage.DoctorFeedback;
import SystemPackage.Medicine;
import SystemPackage.Prescription;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/**
 *
 * @author afernandez
 */
public class SystemDatabase {
    
    public static ArrayList<IUser> userArray  = new ArrayList<IUser>();
    public static ArrayList<AccountRequest> accountRequests = new ArrayList<AccountRequest>();
    public static ArrayList<DoctorFeedback> doctorFeedbackArray = new ArrayList<DoctorFeedback>();
    public static ArrayList<Appointment> appointmentArray = new ArrayList<Appointment>();
    public static ArrayList<Prescription> prescriptionArray = new ArrayList<Prescription>();
    public static ArrayList<Medicine> medicineArray = new ArrayList<Medicine>();
    public static ArrayList<String> patientDeleteRequest = new ArrayList<String>();
    
    static File userArraytext = new File("src/Storage/userArray.txt");
    static File accountRequestText = new File("src/Storage/accountRequestArray.txt");
    static File doctorFeedbackText = new File("src/Storage/doctorFeedbackArray.txt");
    static File appointmentText = new File("src/Storage/appointmentArray.txt");
    static File prescriptionText = new File("src/Storage/prescriptionArray.txt");
    static File medicineText = new File("src/Storage/medicineArray.txt");
    static File patientDeletionText = new File("src/Storage/patientDeleteArray.txt");
    
    public static void SaveUserArray(){ 
        JSONArray jsonUser = new JSONArray();
        for (int i = 0; i < userArray.size(); i++) {
            
            JSONObject obj = new JSONObject();
            obj.put("ID", userArray.get(i).getUserID());
            obj.put("firstname", userArray.get(i).getUserFirstname());
            obj.put("surname", userArray.get(i).getUserSurname());
            obj.put("address",  userArray.get(i).getUserAddress());
            obj.put("password",  userArray.get(i).getUserPassword());
            if (userArray.get(i).getUserID().charAt(0) == 'P')
            {
                obj.put("age",  userArray.get(i).getUserAge());
                obj.put("gender", userArray.get(i).getUserGender());
            }

             jsonUser.add(i, obj);
        }
        
        try (FileWriter file = new FileWriter(userArraytext.getAbsolutePath())) {
			file.write(jsonUser.toJSONString());
			
			//System.out.println( jsonUser);
		} catch (IOException ex) {
            Logger.getLogger(SystemDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void ReadUserArray()
    {
        JSONParser parser = new JSONParser();
        try {
            
            JSONArray obj = (JSONArray) parser.parse(new FileReader(userArraytext.getAbsolutePath()));
            //System.out.print(obj);
            if (obj != null) {
                for (int i = 0; i < obj.size(); i++) {
                    JSONObject temp = (JSONObject) obj.get(i);
                    
                    String id =  String.valueOf((String) temp.get("ID"));
                    String firstname =  String.valueOf((String) temp.get("firstname"));
                    String surname =  String.valueOf((String) temp.get("surname"));
                    String address =  String.valueOf((String) temp.get("address"));
                    String password =  String.valueOf((String) temp.get("password"));
                    String age = "";
                    String gender = "";
                    
                    //System.out.print("here1");
                    if (id.charAt(0) == 'P')
                    {
                      age =  String.valueOf((String) temp.get("age"));  
                      gender =  String.valueOf((String) temp.get("gender"));  
                        
                        //System.out.print("here2");
                    }
                    
                    UserFactory.getUserType(id, firstname, surname, address, password, age, gender);
                    //System.out.print("here3");
                }
            }
            
        } catch (Exception ex) {
            Logger.getLogger(SystemDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void SaveAccountRequests()
    {
        JSONArray jsonAccReq = new JSONArray();
        for (int i = 0; i < accountRequests.size(); i++) {
            
            JSONObject obj = new JSONObject();
            //obj.put("ID", userArray.get(i).getUserID());
            obj.put("firstname", accountRequests.get(i).getFirstname());
            obj.put("surname", accountRequests.get(i).getSurname());
            obj.put("address",  accountRequests.get(i).getAddress());
            obj.put("password",  accountRequests.get(i).getPassword());
            obj.put("age",  accountRequests.get(i).getAge());
            obj.put("gender", accountRequests.get(i).getGender());

             jsonAccReq.add(i, obj);
        }
        
        try (FileWriter file = new FileWriter(accountRequestText.getAbsolutePath())) {
			file.write(jsonAccReq.toJSONString());
			
			//System.out.println( jsonUser);
		} catch (IOException ex) {
            Logger.getLogger(SystemDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void ReadAccountRequestArray()
    {
        JSONParser parser = new JSONParser();     
        try
        {
            JSONArray obj = (JSONArray) parser.parse(new FileReader("src/Storage/accountRequestArray.txt"));          
            if (obj != null) {
                
                for (int i = 0; i < obj.size(); i++) {
                    JSONObject temp = (JSONObject) obj.get(i);
                    
                    String firstname =  (String) temp.get("firstname");
                    String surname =  (String) temp.get("surname");
                    String address =  (String) temp.get("address");
                    String password = (String) temp.get("password");
                    String age =  (String) temp.get("age");  
                    String gender =  (String) temp.get("gender");
                    AccountRequest newAccountRequest = new AccountRequest(firstname, surname, address, password, age, gender);
                    accountRequests.add(newAccountRequest);
                }
            }
        }
        catch(Exception ex)
        {
            Logger.getLogger(SystemDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
    
    public static void saveDoctorFeedback()  
    {
        JSONArray jsonDocFeedback = new JSONArray();
        for (int i = 0; i < doctorFeedbackArray.size(); i++) {
            
            JSONObject obj = new JSONObject();
            obj.put("docID", doctorFeedbackArray.get(i).getDoctorID());
            obj.put("rating", doctorFeedbackArray.get(i).getRating());
            obj.put("notes", doctorFeedbackArray.get(i).getNotes());
            obj.put("adminApproved", doctorFeedbackArray.get(i).isAdminApproved());
            
            jsonDocFeedback.add(i, obj);
        }
        
        try (FileWriter file = new FileWriter(doctorFeedbackText.getAbsolutePath())) {
			file.write(jsonDocFeedback.toJSONString());
			
			//System.out.println( jsonUser);
		} catch (IOException ex) {
            Logger.getLogger(SystemDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void readDoctorFeedback()
    {
        JSONParser parser = new JSONParser();
        
        try
        {
            JSONArray obj = (JSONArray) parser.parse(new FileReader("src/Storage/doctorFeedbackArray.txt"));
            if (obj != null) {
                
                for (int i = 0; i < obj.size(); i++) {
                    JSONObject temp = (JSONObject) obj.get(i);
                    
                    String docID = (String) temp.get("docID");
                    String rating = (String) temp.get("rating");
                    String notes = (String) temp.get("notes");
                    boolean adminApproved = (boolean) temp.get("adminApproved");
                    
                    DoctorFeedback newDocfeedback = new DoctorFeedback(docID, rating, notes, adminApproved);
                    doctorFeedbackArray.add(newDocfeedback);
                }
                
            }
        
        } catch (Exception ex) {
            Logger.getLogger(SystemDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void saveAppointmentArray()
    {
        JSONArray jsonAppointments = new JSONArray();
        if (appointmentArray != null) {
            for (int i = 0; i < appointmentArray.size(); i++) {
                
                JSONObject obj = new JSONObject();
                obj.put("docID", appointmentArray.get(i).getDocID());
                obj.put("patientID", appointmentArray.get(i).getPatientID());
                obj.put("dates", appointmentArray.get(i).getDate());
                obj.put("status", appointmentArray.get(i).getStatus());
                
                jsonAppointments.add(i, obj);
            }
            
            try (FileWriter file = new FileWriter(appointmentText.getAbsolutePath())) {
			file.write(jsonAppointments.toJSONString());
			
			//System.out.println( jsonUser);
		} catch (IOException ex) {
            Logger.getLogger(SystemDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void readAppointmentArray()
    {
        JSONParser parser = new JSONParser(); 
        
        try{
            
            JSONArray obj = (JSONArray) parser.parse(new FileReader("src/Storage/appointmentArray.txt"));
            if (obj != null) {
                
                for (int i = 0; i < obj.size(); i++) {
                    JSONObject temp = (JSONObject) obj.get(i);
                    
                    String docID = (String) temp.get("docID");
                    String patientID = (String) temp.get("patientID");
                    String dates = (String) temp.get("dates");
                    String status = (String) temp.get("status");
                    
                    Appointment newAppointment = new Appointment(docID, patientID, dates, status);
                    appointmentArray.add(newAppointment);
                }
                
            }
                    
        }
        catch(Exception ex)
        {
            Logger.getLogger(SystemDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public static void savePrescriptionArray()
    {
        JSONArray jsonPrescriptions = new JSONArray();
        if (prescriptionArray != null) {
            for (int i = 0; i < prescriptionArray.size(); i++) {
                JSONObject obj = new JSONObject();

                obj.put("docID", prescriptionArray.get(i).getDoctorID());
                obj.put("patientID", prescriptionArray.get(i).getPatientID());
                obj.put("doctorNotes", prescriptionArray.get(i).getDoctorNotes());
                obj.put("medicineName", prescriptionArray.get(i).getMedicine());
                obj.put("quantity", prescriptionArray.get(i).getQuantity());
                obj.put("dosage", prescriptionArray.get(i).getDosage());
                obj.put("completed", prescriptionArray.get(i).getCompleted());
                
                jsonPrescriptions.add(i, obj);
                
            }
            try (FileWriter file = new FileWriter(prescriptionText.getAbsolutePath())) {
			file.write(jsonPrescriptions.toJSONString());
			
			//System.out.println( jsonUser);
		} catch (IOException ex) {
            Logger.getLogger(SystemDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void readPrescriptionArray()
    {
        JSONParser parser = new JSONParser(); 
        
        try {
            
            JSONArray obj = (JSONArray) parser.parse(new FileReader("src/Storage/prescriptionArray.txt"));
            if (obj != null) {
                
                for (int i = 0; i < obj.size(); i++) {
                    JSONObject temp = (JSONObject) obj.get(i);
                    
                    String docID = (String) temp.get("docID");
                    String patientID = (String) temp.get("patientID");
                    String doctorNotes = (String) temp.get("doctorNotes");
                    String medicineName = (String) temp.get("medicineName");
                    String quantity = (String) temp.get("quantity");
                    String dosage = (String) temp.get("dosage");
                    boolean completed = (boolean) temp.get("completed");
                    
                    Prescription newPrescription = new Prescription(docID, patientID, doctorNotes, medicineName, quantity, dosage, completed);
                    prescriptionArray.add(newPrescription);
                }
                
            }
            
        }
        catch(Exception ex)
        {
            Logger.getLogger(SystemDatabase.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public static void saveMedicineArray()
    {
        JSONArray jsonMedicine = new JSONArray();
        if (medicineArray != null) {
            for (int i = 0; i < medicineArray.size(); i++) {
                JSONObject obj = new JSONObject();
                
                obj.put("medicineName",medicineArray.get(i).getMedicineName());
                obj.put("stock", medicineArray.get(i).getStock());
                
                jsonMedicine.add(i, obj);
            }
             try (FileWriter file = new FileWriter(medicineText.getAbsolutePath())) {
			file.write(jsonMedicine.toJSONString());
			
			//System.out.println( jsonUser);
		} catch (IOException ex) {
            Logger.getLogger(SystemDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    public static void readMedicineArray()
    {
        JSONParser parser = new JSONParser(); 
        
        try
        {
            JSONArray obj = (JSONArray) parser.parse(new FileReader("src/Storage/medicineArray.txt"));
            if (obj != null) {
                for (int i = 0; i < obj.size(); i++) {
                    JSONObject temp = (JSONObject) obj.get(i);
                    
                    String medicineName = (String) temp.get("medicineName");
                    String stock = (String) temp.get("stock");
                    
                    Medicine newMedicine = new Medicine(medicineName, stock);
                    medicineArray.add(newMedicine);
                }
            }
        
        }
        catch(Exception ex)
        {
            Logger.getLogger(SystemDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }  

    }
    
    public static void saveDeleteRequestArray()
    {JSONArray jsonDeleteRequest = new JSONArray();
        for (int i = 0; i < patientDeleteRequest.size(); i++) {
            
            JSONObject obj = new JSONObject();
            obj.put("ID", patientDeleteRequest.get(i));
            

             jsonDeleteRequest.add(i, obj);
        }
        
        try (FileWriter file = new FileWriter(patientDeletionText.getAbsolutePath())) {
			file.write(jsonDeleteRequest.toJSONString());
			
			//System.out.println( jsonUser);
		} catch (IOException ex) {
            Logger.getLogger(SystemDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static void readDeleteRequestArray()
    {
    JSONParser parser = new JSONParser();
        try {
            
            JSONArray obj = (JSONArray) parser.parse(new FileReader(patientDeletionText.getAbsolutePath()));
            //System.out.print(obj);
            if (obj != null) {
                for (int i = 0; i < obj.size(); i++) {
                    JSONObject temp = (JSONObject) obj.get(i);
                    
                    String id =  String.valueOf((String) temp.get("ID"));
          
                    patientDeleteRequest.add(id);

                }
            }
            
        } catch (Exception ex) {
            Logger.getLogger(SystemDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static IUser FindUser(String userID)
    {
        for (int i = 0; i <= SystemDatabase.userArray.size(); i++) {
            if (userArray.get(i).getUserID().equals(userID)) {
                return SystemDatabase.userArray.get(i);               
            }
        }
        return null;
    }
    
    public static void RemoveUser(String userID){
        userArray.remove(FindUser(userID));     
    }
    
    
    public IUser FindSecretary()
    {
    for (int i = 0; i <= SystemDatabase.userArray.size(); i++) {
            if (userArray.get(i).getUserID().charAt(0) == 'S')
            {
                return userArray.get(i);               
            }
        }
    return null;
    }
    
    public static Appointment FindAppointment(String userID)
    {
        for (int i = 0; i < appointmentArray.size(); i++) {
            if (appointmentArray.get(i).getPatientID().equals(userID)) {
                return appointmentArray.get(i);
            }
        }
        return null;
    }
    
}
