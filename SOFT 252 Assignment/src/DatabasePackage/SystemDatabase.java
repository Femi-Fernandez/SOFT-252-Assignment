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
public class SystemDatabase implements DatabaseControl {
    
    public static ArrayList<IUser> userArray  = new ArrayList<IUser>();
    public static ArrayList<AccountRequest> accountRequests = new ArrayList<AccountRequest>();

    
    static JSONObject accountRequestSave = new JSONObject();
    
    static File userArraytext = new File("src/Storage/userArray.txt");

    
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
                    
                    System.out.print("here1");
                    if (id.charAt(0) == 'P')
                    {
                      age =  String.valueOf((String) temp.get("age"));  
                      gender =  String.valueOf((String) temp.get("gender"));  
                        
                        System.out.print("here2");
                    }
                    
                    UserFactory.getUserType(id, firstname, surname, address, password, age, gender);
                    System.out.print("here3");
                }
            }
            
        } catch (Exception ex) {
            Logger.getLogger(SystemDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void SaveAccountRequests()
    {
        accountRequestSave.put("Account requests", SystemDatabase.accountRequests);
        
        try {
            FileWriter file = new FileWriter(new File("src/Storage/accountRequestArray.txt").getAbsolutePath());
            file.write(accountRequestSave.toJSONString());
            file.close();
            System.out.println("Saved Account request array!");
            
        } catch (IOException ex) {
            Logger.getLogger(SystemDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void ReadAccountRequestArray()
    {
    SystemDatabase.accountRequests = (ArrayList<AccountRequest>) accountRequestSave.get("Account requests");
    }
    
    @Override
    public IUser FindUser(String userID)
    {
        for (int i = 0; i <= SystemDatabase.userArray.size(); i++) {
            if (userArray.get(i).getUserID().equals(userID)) {
                return SystemDatabase.userArray.get(i);               
            }
        }
        return null;
    }
    @Override
    public void RemoveUser(String userID){
        userArray.remove(FindUser(userID));     
    }
    
    @Override
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
