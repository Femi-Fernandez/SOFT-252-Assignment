/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemPackage;

/**
 *
 * @author afernandez
 */
public class Medicine {
 
    private String medicineName;
    private String stock;
    private boolean newMedicine;

    public Medicine(String medicineName, String stock, boolean newMedicine) {
        this.medicineName = medicineName;
        this.stock = stock;
        this.newMedicine = newMedicine;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public boolean getNewMedicine() {
        return newMedicine;
    }

    public void setNewMedicine(boolean newMedicine) {
        this.newMedicine = newMedicine;
    }
    
    
}
