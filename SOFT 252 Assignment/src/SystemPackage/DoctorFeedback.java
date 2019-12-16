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
public class DoctorFeedback {
    
    private String doctorID;
    private String rating;
    private String notes;
    private String adminApproved;

    public DoctorFeedback(String doctorID, String rating, String notes, String adminApproved) {
        this.doctorID = doctorID;
        this.rating = rating;
        this.notes = notes;
        this.adminApproved = adminApproved;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String isAdminApproved() {
        return adminApproved;
    }

    public void setAdminApproved(String adminApproved) {
        this.adminApproved = adminApproved;
    }

    
    
}
