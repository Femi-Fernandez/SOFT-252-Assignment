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
    
    //these are the arrays that all the data is stored in while the program is running
    public static ArrayList<IUser> userArray  = new ArrayList<IUser>();
    public static ArrayList<AccountRequest> accountRequests = new ArrayList<AccountRequest>();
    public static ArrayList<DoctorFeedback> doctorFeedbackArray = new ArrayList<DoctorFeedback>();
    public static ArrayList<Appointment> appointmentArray = new ArrayList<Appointment>();
    public static ArrayList<Prescription> prescriptionArray = new ArrayList<Prescription>();
    public static ArrayList<Medicine> medicineArray = new ArrayList<Medicine>();
    public static ArrayList<String> patientDeleteRequest = new ArrayList<String>();
    
    //these are the text files that store the info while the app is closed
    static File userArraytext = new File("src/Storage/userArray.txt");
    static File accountRequestText = new File("src/Storage/accountRequestArray.txt");
    static File doctorFeedbackText = new File("src/Storage/doctorFeedbackArray.txt");
    static File appointmentText = new File("src/Storage/appointmentArray.txt");
    static File prescriptionText = new File("src/Storage/prescriptionArray.txt");
    static File medicineText = new File("src/Storage/medicineArray.txt");
    static File patientDeletionText = new File("src/Storage/patientDeleteArray.txt");
    
    public static void SaveUserArray(){ 
        //creates a new json array 
        JSONArray jsonUser = new JSONArray();
        for (int i = 0; i < userArray.size(); i++) {
            
            //creatres a new json object and puts the user data into it
            JSONObject obj = new JSONObject();
            obj.put("ID", userArray.get(i).getUserID());
            obj.put("firstname", userArray.get(i).getUserFirstname());
            obj.put("surname", userArray.get(i).getUserSurname());
            obj.put("address",  userArray.get(i).getUserAddress());
            obj.put("password",  userArray.get(i).getUserPassword());
            
            //if the user being added is a patient, puts their age and gender into the object
            if (userArray.get(i).getUserID().charAt(0) == 'P')
            {
                obj.put("age",  userArray.get(i).getUserAge());
                obj.put("gender", userArray.get(i).getUserGender());
            }
            //adds the json object to the jsonarray
             jsonUser.add(i, obj);
        }
        
        //writes the jsonarray to the appropriate text file
        try (FileWriter file = new FileWriter(userArraytext.getAbsolutePath())) {
			file.write(jsonUser.toJSONString());
			
			//System.out.println( jsonUser);
		} catch (IOException ex) {
            Logger.getLogger(SystemDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void ReadUserArray()
    {
        //creates a json parser
        JSONParser parser = new JSONParser();
        try {
            //parses the json array from the text file
            JSONArray obj = (JSONArray) parser.parse(new FileReader(userArraytext.getAbsolutePath()));
            //System.out.print(obj);
            if (obj != null) {
                for (int i = 0; i < obj.size(); i++) {
                    //sets values in json array into single json object and saves them as strings
                    JSONObject temp = (JSONObject) obj.get(i);
                    
                    String id =  String.valueOf((String) temp.get("ID"));
                    String firstname =  String.valueOf((String) temp.get("firstname"));
                    String surname =  String.valueOf((String) temp.get("surname"));
                    String address =  String.valueOf((String) temp.get("address"));
                    String password =  String.valueOf((String) temp.get("password"));
                    String age = "";
                    String gender = "";
                    
                    //if the user is a patient gets the age and gender
                    if (id.charAt(0) == 'P')
                    {
                      age =  String.valueOf((String) temp.get("age"));  
                      gender =  String.valueOf((String) temp.get("gender"));  
                        
                        //System.out.print("here2");
                    }
                    //creates the user
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
        //creates a json array
        JSONArray jsonAccReq = new JSONArray();
        for (int i = 0; i < accountRequests.size(); i++) {
            //creates a json object and adds the account request info to it
            JSONObject obj = new JSONObject();
            //obj.put("ID", userArray.get(i).getUserID());
            obj.put("firstname", accountRequests.get(i).getFirstname());
            obj.put("surname", accountRequests.get(i).getSurname());
            obj.put("address",  accountRequests.get(i).getAddress());
            obj.put("password",  accountRequests.get(i).getPassword());
            obj.put("age",  accountRequests.get(i).getAge());
            obj.put("gender", accountRequests.get(i).getGender());

            //adds the json object to the json array 
             jsonAccReq.add(i, obj);
        }
        
        //writes jsonarray to the appropriate text file
        try (FileWriter file = new FileWriter(accountRequestText.getAbsolutePath())) {
			file.write(jsonAccReq.toJSONString());
			
			//System.out.println( jsonUser);
		} catch (IOException ex) {
            Logger.getLogger(SystemDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void ReadAccountRequestArray()
    {
        //creates json parser
        JSONParser parser = new JSONParser();     
        try
        {
            //parses the json array from the text file
            JSONArray obj = (JSONArray) parser.parse(new FileReader("src/Storage/accountRequestArray.txt"));          
            if (obj != null) {
                
                for (int i = 0; i < obj.size(); i++) {
                    //stores one of the jsonobjects from the array into its own jsonobject and saves the info as strings
                    JSONObject temp = (JSONObject) obj.get(i);
                    
                    String firstname =  (String) temp.get("firstname");
                    String surname =  (String) temp.get("surname");
                    String address =  (String) temp.get("address");
                    String password = (String) temp.get("password");
                    String age =  (String) temp.get("age");  
                    String gender =  (String) temp.get("gender");
                    //creates new account request and adds it to the accountrequest array
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
        //creates json array 
        JSONArray jsonDocFeedback = new JSONArray();
        for (int i = 0; i < doctorFeedbackArray.size(); i++) {
            //creates json object
            JSONObject obj = new JSONObject();
            obj.put("docID", doctorFeedbackArray.get(i).getDoctorID());
            obj.put("rating", doctorFeedbackArray.get(i).getRating());
            obj.put("notes", doctorFeedbackArray.get(i).getNotes());
            obj.put("adminApproved", doctorFeedbackArray.get(i).isAdminApproved());
            
            //adds json object to the json array
            jsonDocFeedback.add(i, obj);
        }
        //saves jsonarray to text file
        try (FileWriter file = new FileWriter(doctorFeedbackText.getAbsolutePath())) {
			file.write(jsonDocFeedback.toJSONString());
		} catch (IOException ex) {
            Logger.getLogger(SystemDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void readDoctorFeedback()
    {
        //creates json parser
        JSONParser parser = new JSONParser();
        
        try
        {
            //parses jsonarray from text file
            JSONArray obj = (JSONArray) parser.parse(new FileReader("src/Storage/doctorFeedbackArray.txt"));
            if (obj != null) {
                
                for (int i = 0; i < obj.size(); i++) {
                    //adds entry in array to json object and saves data as strings
                    JSONObject temp = (JSONObject) obj.get(i);
                    
                    String docID = (String) temp.get("docID");
                    String rating = (String) temp.get("rating");
                    String notes = (String) temp.get("notes");
                    String adminApproved = (String) temp.get("adminApproved");
                    
                    //creates new doctorfeedback and adds it to the doctorfeedback array
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
        //creates json array 
        JSONArray jsonAppointments = new JSONArray();
        if (appointmentArray != null) {
            for (int i = 0; i < appointmentArray.size(); i++) {
                //creates json object
                JSONObject obj = new JSONObject();
                obj.put("docID", appointmentArray.get(i).getDocID());
                obj.put("patientID", appointmentArray.get(i).getPatientID());
                obj.put("dates", appointmentArray.get(i).getDate());
                obj.put("status", appointmentArray.get(i).getStatus());
                //adds json object to the json array
                jsonAppointments.add(i, obj);
            }
            //saves jsonarray to text file
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
        //creates json parser
        JSONParser parser = new JSONParser(); 
        
        try{
            
            JSONArray obj = (JSONArray) parser.parse(new FileReader("src/Storage/appointmentArray.txt"));
            if (obj != null) {
                
                for (int i = 0; i < obj.size(); i++) {
                    //adds entry in array to json object and saves data as strings
                    JSONObject temp = (JSONObject) obj.get(i);
                    
                    String docID = (String) temp.get("docID");
                    String patientID = (String) temp.get("patientID");
                    String dates = (String) temp.get("dates");
                    String status = (String) temp.get("status");
                    
                    //create new appointment object and saves it to array
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
        //creates json array 
        JSONArray jsonPrescriptions = new JSONArray();
        if (prescriptionArray != null) {
            for (int i = 0; i < prescriptionArray.size(); i++) {
                //creates json object
                JSONObject obj = new JSONObject();

                obj.put("docID", prescriptionArray.get(i).getDoctorID());
                obj.put("patientID", prescriptionArray.get(i).getPatientID());
                obj.put("doctorNotes", prescriptionArray.get(i).getDoctorNotes());
                obj.put("medicineName", prescriptionArray.get(i).getMedicine());
                obj.put("quantity", prescriptionArray.get(i).getQuantity());
                obj.put("dosage", prescriptionArray.get(i).getDosage());
                obj.put("completed", prescriptionArray.get(i).getCompleted());
                //adds json object to the json array
                jsonPrescriptions.add(i, obj);
                
            }
            //saves jsonarray to text file
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
        //creates json parser
        JSONParser parser = new JSONParser(); 
        
        try {
            
            JSONArray obj = (JSONArray) parser.parse(new FileReader("src/Storage/prescriptionArray.txt"));
            if (obj != null) {
                
                for (int i = 0; i < obj.size(); i++) {
                    //adds entry in array to json object and saves data as strings
                    JSONObject temp = (JSONObject) obj.get(i);
                    
                    String docID = (String) temp.get("docID");
                    String patientID = (String) temp.get("patientID");
                    String doctorNotes = (String) temp.get("doctorNotes");
                    String medicineName = (String) temp.get("medicineName");
                    String quantity = (String) temp.get("quantity");
                    String dosage = (String) temp.get("dosage");
                    boolean completed = (boolean) temp.get("completed");
                    
                    //creates new prescription object and saves it to the prescription array
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
        //creates json array 
        JSONArray jsonMedicine = new JSONArray();
        if (medicineArray != null) {
            for (int i = 0; i < medicineArray.size(); i++) {
                //creates json object
                JSONObject obj = new JSONObject();
                
                obj.put("medicineName",medicineArray.get(i).getMedicineName());
                obj.put("stock", medicineArray.get(i).getStock());
                obj.put("newMedicine", medicineArray.get(i).getNewMedicine());
                //adds json object to the json array
                jsonMedicine.add(i, obj);
            }
            //saves jsonarray to text file
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
        //creates json parser
        JSONParser parser = new JSONParser(); 
        
        try
        {
            JSONArray obj = (JSONArray) parser.parse(new FileReader("src/Storage/medicineArray.txt"));
            if (obj != null) {
                for (int i = 0; i < obj.size(); i++) {
                    //adds entry in array to json object and saves data as strings
                    JSONObject temp = (JSONObject) obj.get(i);
                    
                    String medicineName = (String) temp.get("medicineName");
                    String stock = (String) temp.get("stock");
                    boolean newMed = (boolean) temp.get("newMedicine");
                    
                    //creates new medicine object and saves it to the medicine array
                    Medicine newMedicine = new Medicine(medicineName, stock, newMed);
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
    {
        //creates json array 
        JSONArray jsonDeleteRequest = new JSONArray();
        for (int i = 0; i < patientDeleteRequest.size(); i++) {
            //creates json object
            JSONObject obj = new JSONObject();
            obj.put("ID", patientDeleteRequest.get(i));
            
            //adds json object to the json array
             jsonDeleteRequest.add(i, obj);
        }
        //saves jsonarray to text file
        try (FileWriter file = new FileWriter(patientDeletionText.getAbsolutePath())) {
			file.write(jsonDeleteRequest.toJSONString());
			
			//System.out.println( jsonUser);
		} catch (IOException ex) {
            Logger.getLogger(SystemDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static void readDeleteRequestArray()
    {
        //creates json parser
    JSONParser parser = new JSONParser();
        try {
            
            JSONArray obj = (JSONArray) parser.parse(new FileReader(patientDeletionText.getAbsolutePath()));
            //System.out.print(obj);
            if (obj != null) {
                for (int i = 0; i < obj.size(); i++) {
                    //adds entry in array to json object and saves data as strings
                    JSONObject temp = (JSONObject) obj.get(i);
                    
                    String id =  String.valueOf((String) temp.get("ID"));
          
                    //adds the id to the patient delete request array
                    patientDeleteRequest.add(id);

                }
            }
            
        } catch (Exception ex) {
            Logger.getLogger(SystemDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static IUser FindUser(String userID)
    {
        //finds and returns an IUser based on input ID
        for (int i = 0; i <= SystemDatabase.userArray.size(); i++) {
            if (userArray.get(i).getUserID().equals(userID)) {
                return SystemDatabase.userArray.get(i);               
            }
        }
        return null;
    }
    
    public static void RemoveUser(String userID){
        //removes an IUser based on input string
        userArray.remove(FindUser(userID));     
    }
    
    
    public IUser FindSecretary()
    {
        //finds and returns a secretary
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
        //finds an appointment based on the input user ID (can be either the patients or the doctors)
        for (int i = 0; i < appointmentArray.size(); i++) {
            if ((appointmentArray.get(i).getPatientID().equals(userID)) || (appointmentArray.get(i).getDocID().equals(userID))) {
                return appointmentArray.get(i);
            }
        }
        return null;
    }
    
}
