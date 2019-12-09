/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabasePackage;
import SystemPackage.AccountRequest;
import java.util.ArrayList;
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
    
    public static void SaveUserArray(){ 
        userDatabaseSave.put("user Database", SystemDatabase.userArray);
    }
    
    public static void ReadUserArray(){
    SystemDatabase.userArray = (ArrayList<IUser>) userDatabaseSave.get("user Database");
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
