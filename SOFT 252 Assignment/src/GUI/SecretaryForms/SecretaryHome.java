/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.SecretaryForms;

import DatabasePackage.SystemDatabase;

/**
 *
 * @author afernandez
 */
public class SecretaryHome extends javax.swing.JFrame {

    /**
     * Creates new form SecretaryHome
     */
    private static SecretaryHome obj = null;
    
    static String currentUserID;
    public SecretaryHome(String userID) {
        initComponents();
        this.currentUserID = userID;
        LblTitle.setText("Welcome, " + SystemDatabase.FindUser(currentUserID).getUserFirstname());
    }

    //makes sure only one form opens when it is loaded
     public static SecretaryHome getObj()
    {
        if (obj == null) {
            obj = new SecretaryHome(currentUserID);
        } return obj;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LblTitle = new javax.swing.JLabel();
        BtnApprovePatientAccount = new javax.swing.JButton();
        BtnRemovePatientAccount = new javax.swing.JButton();
        BtnPatientRemoverequest = new javax.swing.JButton();
        BtnCreateAppointment = new javax.swing.JButton();
        BtnAppointmentRequests = new javax.swing.JButton();
        BtnGetRequestedMedicine = new javax.swing.JButton();
        BtnMedicineRestock = new javax.swing.JButton();
        BtnGivePrescription = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LblTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        LblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblTitle.setText("Welcome, Secretary");

        BtnApprovePatientAccount.setText("Approve Patient Account");
        BtnApprovePatientAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnApprovePatientAccountActionPerformed(evt);
            }
        });

        BtnRemovePatientAccount.setText("Remove patient account");
        BtnRemovePatientAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRemovePatientAccountActionPerformed(evt);
            }
        });

        BtnPatientRemoverequest.setText("Patient removal requests");
        BtnPatientRemoverequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPatientRemoverequestActionPerformed(evt);
            }
        });

        BtnCreateAppointment.setText("Create new appointment");
        BtnCreateAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCreateAppointmentActionPerformed(evt);
            }
        });

        BtnAppointmentRequests.setText("Approve Appointment Requests");
        BtnAppointmentRequests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAppointmentRequestsActionPerformed(evt);
            }
        });

        BtnGetRequestedMedicine.setText("Order requested medicine");
        BtnGetRequestedMedicine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGetRequestedMedicineActionPerformed(evt);
            }
        });

        BtnMedicineRestock.setText("Restock medicine");
        BtnMedicineRestock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMedicineRestockActionPerformed(evt);
            }
        });

        BtnGivePrescription.setText("Give patient medicine");
        BtnGivePrescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGivePrescriptionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(BtnApprovePatientAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BtnCreateAppointment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BtnGetRequestedMedicine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(BtnMedicineRestock, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnRemovePatientAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnPatientRemoverequest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnAppointmentRequests, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnGivePrescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnApprovePatientAccount, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(BtnRemovePatientAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnPatientRemoverequest, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(BtnGetRequestedMedicine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnCreateAppointment, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(BtnAppointmentRequests, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnMedicineRestock, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(BtnGivePrescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnApprovePatientAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnApprovePatientAccountActionPerformed
        // TODO add your handling code here:
        new SecretaryApprovePatientAccount(currentUserID).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnApprovePatientAccountActionPerformed

    private void BtnRemovePatientAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRemovePatientAccountActionPerformed
        // TODO add your handling code here:
        new SecretaryRemovePatientAccount(currentUserID).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnRemovePatientAccountActionPerformed

    private void BtnPatientRemoverequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPatientRemoverequestActionPerformed
        // TODO add your handling code here:
        new SecretaryPatientRequestRemoval(currentUserID).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnPatientRemoverequestActionPerformed

    private void BtnCreateAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCreateAppointmentActionPerformed
        // TODO add your handling code here:
        new SecretaryCreateAppointment(currentUserID).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnCreateAppointmentActionPerformed

    private void BtnAppointmentRequestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAppointmentRequestsActionPerformed
        // TODO add your handling code here:
        new SecretaryAppointmentRequests(currentUserID).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnAppointmentRequestsActionPerformed

    private void BtnGetRequestedMedicineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGetRequestedMedicineActionPerformed
        // TODO add your handling code here:
        new SecretaryGetRequestedMedicine(currentUserID).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnGetRequestedMedicineActionPerformed

    private void BtnMedicineRestockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMedicineRestockActionPerformed
        // TODO add your handling code here:
        new SecretaryRestockMed(currentUserID).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnMedicineRestockActionPerformed

    private void BtnGivePrescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGivePrescriptionActionPerformed
        // TODO add your handling code here:
        new SecretaryGivePrescription(currentUserID).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnGivePrescriptionActionPerformed

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
            java.util.logging.Logger.getLogger(SecretaryHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SecretaryHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SecretaryHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SecretaryHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SecretaryHome(currentUserID).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAppointmentRequests;
    private javax.swing.JButton BtnApprovePatientAccount;
    private javax.swing.JButton BtnCreateAppointment;
    private javax.swing.JButton BtnGetRequestedMedicine;
    private javax.swing.JButton BtnGivePrescription;
    private javax.swing.JButton BtnMedicineRestock;
    private javax.swing.JButton BtnPatientRemoverequest;
    private javax.swing.JButton BtnRemovePatientAccount;
    private javax.swing.JLabel LblTitle;
    // End of variables declaration//GEN-END:variables
}
