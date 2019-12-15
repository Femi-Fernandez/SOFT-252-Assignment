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
public class Prescription {
    
    private String doctorID;
    private String patientID;
    private String doctorNotes;
    private String medicineName;
    private String quantity;
    private String dosage;
    private boolean completed;

    public Prescription(String doctorID, String patientID, String doctorNotes, String medicine, String quantity, String dosage, boolean completed) {
        this.doctorID = doctorID;
        this.patientID = patientID;
        this.doctorNotes = doctorNotes;
        this.medicineName = medicine;
        this.quantity = quantity;
        this.dosage = dosage;
        this.completed = completed;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getDoctorNotes() {
        return doctorNotes;
    }

    public void setDoctorNotes(String doctorNotes) {
        this.doctorNotes = doctorNotes;
    }

    public String getMedicine() {
        return medicineName;
    }

    public void setMedicine(String medicine) {
        this.medicineName = medicine;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }
    
    
    
    
    
}
