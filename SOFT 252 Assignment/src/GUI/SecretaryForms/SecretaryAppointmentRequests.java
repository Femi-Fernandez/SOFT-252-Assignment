/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.SecretaryForms;

import DatabasePackage.SystemDatabase;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author afernandez
 */
public class SecretaryAppointmentRequests extends javax.swing.JFrame {

    /**
     * Creates new form SecretaryAppointmentRequests
     */
    static String currentUserID;
    public SecretaryAppointmentRequests(String userID) {
        initComponents();
        this.currentUserID = userID;
        SetCombValues();
    }
    public void SetCombValues(){
        ArrayList<String> a = new ArrayList<String>();
            for (int i = 0; i < SystemDatabase.appointmentArray.size(); i++) {
                if ("Unverified".equals(SystemDatabase.appointmentArray.get(i).getStatus())) {
                    a.add(SystemDatabase.appointmentArray.get(i).getPatientID());
                }    
        }       
        for (String value : a) {
            CombPatientID.addItem(value); 
        }
    }   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CombPatientID = new javax.swing.JComboBox<>();
        BtnViewAppointmentRequest = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtAppointmentInfo = new javax.swing.JTextArea();
        LblRequestedDate = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtAppointmentDate = new javax.swing.JTextField();
        BtnBack = new javax.swing.JButton();
        BtnRefuseAppointment = new javax.swing.JButton();
        BtnApproveAppointment = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Approve appointment Requests");

        jLabel2.setText("Patient's ID");

        BtnViewAppointmentRequest.setText("View appointment request");
        BtnViewAppointmentRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnViewAppointmentRequestActionPerformed(evt);
            }
        });

        TxtAppointmentInfo.setColumns(20);
        TxtAppointmentInfo.setRows(5);
        jScrollPane1.setViewportView(TxtAppointmentInfo);

        LblRequestedDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblRequestedDate.setText("Requested date: (DATE HERE)");

        jLabel4.setText("New Date");

        BtnBack.setText("Back");
        BtnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBackActionPerformed(evt);
            }
        });

        BtnRefuseAppointment.setText("Refuse Appointment request");
        BtnRefuseAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRefuseAppointmentActionPerformed(evt);
            }
        });

        BtnApproveAppointment.setText("Approve Appointment request");
        BtnApproveAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnApproveAppointmentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CombPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(BtnViewAppointmentRequest)
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(BtnRefuseAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnApproveAppointment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtAppointmentDate))
                            .addComponent(LblRequestedDate))
                        .addGap(153, 153, 153))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(CombPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnViewAppointmentRequest))
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblRequestedDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TxtAppointmentDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnBack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                    .addComponent(BtnRefuseAppointment, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnApproveAppointment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnViewAppointmentRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnViewAppointmentRequestActionPerformed
        // TODO add your handling code here:
        String patientID =  CombPatientID.getSelectedItem().toString();
        TxtAppointmentInfo.setText("");
        LblRequestedDate.setText("");
        
        for (int i = 0; i < SystemDatabase.appointmentArray.size(); i++) 
        {
            if (SystemDatabase.appointmentArray.get(i).getPatientID().equals(patientID)) {

                String DocID = SystemDatabase.appointmentArray.get(i).getDocID();
                var doctor = SystemDatabase.FindUser(DocID);
                var patient = SystemDatabase.FindUser(patientID);
                TxtAppointmentInfo.setText(DocID + "\n" + doctor.getUserFirstname() + "\n" +
                                       doctor.getUserSurname() + "\n" +
                                       SystemDatabase.appointmentArray.get(i).getStatus() + "\n \n" +
                                       patient.getUserFirstname() + "\n" +
                                       patient.getUserSurname() + "\n" +
                                       patient.getUserAge() + "\n" +
                                       patient.getUserGender());
            
                LblRequestedDate.setText("Requested Date: " + SystemDatabase.appointmentArray.get(i).getDate());
                TxtAppointmentDate.setText(SystemDatabase.appointmentArray.get(i).getDate());
                break;
            }
        }
    }//GEN-LAST:event_BtnViewAppointmentRequestActionPerformed

    private void BtnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBackActionPerformed
        // TODO add your handling code here:
        new SecretaryHome(currentUserID).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnBackActionPerformed

    private void BtnRefuseAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRefuseAppointmentActionPerformed
        // TODO add your handling code here:
        String patientID =  CombPatientID.getSelectedItem().toString();
        
        for (int i = 0; i < SystemDatabase.appointmentArray.size(); i++) 
        {
            if (SystemDatabase.appointmentArray.get(i).getPatientID().equals(patientID)) 
            {
                SystemDatabase.appointmentArray.remove(i);
                showMessageDialog(null, "Appointment request denied, request deleted");
                SystemDatabase.saveAppointmentArray();
                new SecretaryHome(currentUserID).setVisible(true);
                this.dispose();               
                break;
            }
        }
    }//GEN-LAST:event_BtnRefuseAppointmentActionPerformed

    private void BtnApproveAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnApproveAppointmentActionPerformed
        // TODO add your handling code here:
        String patientID = CombPatientID.getSelectedItem().toString();
        for (int i = 0; i < SystemDatabase.appointmentArray.size(); i++) 
        {
            if (SystemDatabase.appointmentArray.get(i).getPatientID().equals(patientID)) 
            {
                String Date = TxtAppointmentDate.getText();
                String status = "Verified";
                SystemDatabase.appointmentArray.get(i).setDate(Date);
                SystemDatabase.appointmentArray.get(i).setStatus(status);
                SystemDatabase.saveAppointmentArray();
                showMessageDialog(null, "Appointment approved and created");
                new SecretaryHome(currentUserID).setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_BtnApproveAppointmentActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SecretaryAppointmentRequests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SecretaryAppointmentRequests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SecretaryAppointmentRequests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SecretaryAppointmentRequests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SecretaryAppointmentRequests(currentUserID).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnApproveAppointment;
    private javax.swing.JButton BtnBack;
    private javax.swing.JButton BtnRefuseAppointment;
    private javax.swing.JButton BtnViewAppointmentRequest;
    private javax.swing.JComboBox<String> CombPatientID;
    private javax.swing.JLabel LblRequestedDate;
    private javax.swing.JTextField TxtAppointmentDate;
    private javax.swing.JTextArea TxtAppointmentInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
