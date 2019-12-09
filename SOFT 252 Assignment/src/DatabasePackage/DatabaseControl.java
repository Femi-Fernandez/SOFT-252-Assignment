/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabasePackage;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author afernandez
 */
public class DatabaseControl {
    
    
    public void SaveUserArray(){
        JSONObject userDatabaseSave = new JSONObject();
        
        userDatabaseSave.put("user Database", SystemDatabase.userArray);
    }
}
