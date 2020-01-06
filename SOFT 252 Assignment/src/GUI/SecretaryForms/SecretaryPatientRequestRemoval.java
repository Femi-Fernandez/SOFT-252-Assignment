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
public class SecretaryPatientRequestRemoval extends javax.swing.JFrame {

    /**
     * Creates new form SecretaryPatientRequestRemoval
     */
    static String currentUserID;
    public SecretaryPatientRequestRemoval(String userID) {
        initComponents();
        this.currentUserID = userID;
        SetCombValues();
    }
    //sets the patientID combobox values
    public void SetCombValues(){
        ArrayList<String> a = new ArrayList<String>();
            for (int i = 0; i < SystemDatabase.patientDeleteRequest.size(); i++) {
                a.add(SystemDatabase.patientDeleteRequest.get(i));                
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
        BtnViewPatient = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtPatientInfo = new javax.swing.JTextArea();
        BtnBack = new javax.swing.JButton();
        BtnRemoveUser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Patient account removal Requests");

        jLabel2.setText("Patient ID");

        BtnViewPatient.setText("View Patient");
        BtnViewPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnViewPatientActionPerformed(evt);
            }
        });

        TxtPatientInfo.setColumns(20);
        TxtPatientInfo.setRows(5);
        jScrollPane1.setViewportView(TxtPatientInfo);

        BtnBack.setText("Back");
        BtnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBackActionPerformed(evt);
            }
        });

        BtnRemoveUser.setText("Remove Patient");
        BtnRemoveUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRemoveUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CombPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(BtnViewPatient, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(BtnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BtnRemoveUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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
                    .addComponent(BtnViewPatient))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnBack, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(BtnRemoveUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnViewPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnViewPatientActionPerformed
        // fills the patientinfo textarea with the patients info  
        String combValue = CombPatientID.getSelectedItem().toString();
        TxtPatientInfo.setText("");
        
        for (int i = 0; i < SystemDatabase.userArray.size(); i++) {
            if (SystemDatabase.userArray.get(i).getUserID().equals(combValue)) {
                TxtPatientInfo.setText(SystemDatabase.userArray.get(i).getUserFirstname() + "\n"+ 
                       SystemDatabase.userArray.get(i).getUserSurname() + "\n"+ 
                       SystemDatabase.userArray.get(i).getUserAddress() + "\n"+  
                       SystemDatabase.userArray.get(i).getUserAge()     + "\n"+  
                       SystemDatabase.userArray.get(i).getUserGender());
                break;
            }
        }
    }//GEN-LAST:event_BtnViewPatientActionPerformed

    private void BtnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBackActionPerformed
        // closes form and returns to Secretary home page
        new SecretaryHome(currentUserID).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnBackActionPerformed

    private void BtnRemoveUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRemoveUserActionPerformed
        // finds the user, removes them from the user array and the request array
        String combValue = CombPatientID.getSelectedItem().toString();
        for (int i = 0; i < SystemDatabase.userArray.size(); i++) {
            if (SystemDatabase.userArray.get(i).getUserID().equals(combValue)) {
                SystemDatabase.userArray.remove(i);
                
                for (int j = 0; j < SystemDatabase.patientDeleteRequest.size(); j++) {
                    if (SystemDatabase.patientDeleteRequest.get(j).equals(combValue)) {
                        SystemDatabase.patientDeleteRequest.remove(j);
                        break;
                    }
                }
                
                //notifies user that the account was deleted, saves the array and returns to the secretary home form
                showMessageDialog(null, "Requested Patient account has been deleted");
                SystemDatabase.SaveUserArray();
                SystemDatabase.saveDeleteRequestArray();
                new SecretaryHome(currentUserID).setVisible(true);
                this.dispose();               
                break;
            }
        }
    }//GEN-LAST:event_BtnRemoveUserActionPerformed

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
            java.util.logging.Logger.getLogger(SecretaryPatientRequestRemoval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SecretaryPatientRequestRemoval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SecretaryPatientRequestRemoval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SecretaryPatientRequestRemoval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SecretaryPatientRequestRemoval(currentUserID).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBack;
    private javax.swing.JButton BtnRemoveUser;
    private javax.swing.JButton BtnViewPatient;
    private javax.swing.JComboBox<String> CombPatientID;
    private javax.swing.JTextArea TxtPatientInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
