/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabasePackage;
import SystemPackage.AccountRequest;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author afernandez
 */
public class SystemDatabase implements DatabaseControl {
    
    public static ArrayList<IUser> userArray  = new ArrayList<IUser>();
    public static ArrayList<AccountRequest> accountRequests = new ArrayList<AccountRequest>();
   
    static JSONObject userDatabaseSave = new JSONObject();
    static JSONObject accountRequestSave = new JSONObject();
    
    
    public static void SaveUserArray(){ 
        userDatabaseSave.put("user Database", SystemDatabase.userArray);
        accountRequestSave.put("Account requests", SystemDatabase.accountRequests);
        
        System.out.println("Working Directory = " +
              System.getProperty("user.dir"));

        try {
            FileWriter file = new FileWriter(new File("src/Storage/userArray.txt").getAbsolutePath());
            file.write(userDatabaseSave.toJSONString());
            file.close();
            System.out.println("Saved user array!");
            
        } catch (IOException ex) {
            Logger.getLogger(SystemDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void ReadUserArray(){
    SystemDatabase.userArray = (ArrayList<IUser>) userDatabaseSave.get("user Database");
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
