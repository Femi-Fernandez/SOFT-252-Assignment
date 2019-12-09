/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabasePackage;
/**
 *
 * @author afernandez
 */
public interface DatabaseControl{
 

    public abstract IUser FindUser(String userID);
    public abstract void RemoveUser(String userID);
    public abstract IUser FindSecretary();
}
