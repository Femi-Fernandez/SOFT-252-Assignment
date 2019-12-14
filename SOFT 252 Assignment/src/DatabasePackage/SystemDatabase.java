/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabasePackage;
import SystemPackage.AccountRequest;
import DatabasePackage.UserFactory;
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

    
    static JSONObject accountRequestSave = new JSONObject();
    
    static File userArraytext = new File("src/Storage/userArray.txt");
    static File accountRequestText = new File("src/Storage/accountRequestArray.txt");

    
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
            
            JSONArray obj = (JSONArray) parser.parse(new FileReader("src/Storage/userArray.txt"));
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
                    SystemDatabase.accountRequests.add(newAccountRequest);
                }
            }
        }
        catch(Exception ex)
        {
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
                return SystemDatabase.userArray.get(i);               
            }
        }
    return null;
    }
    
}
