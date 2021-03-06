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
public class SecretaryRemovePatientAccount extends javax.swing.JFrame {

    /**
     * Creates new form SecretaryRemovePatientAccount
     */
    static String currentUserID;
    public SecretaryRemovePatientAccount(String userID) {
        initComponents();
        this.currentUserID = userID;
        SetCombValues();
    }
    //sets the patient ID combobox values
    public void SetCombValues(){
        ArrayList<String> a = new ArrayList<String>();
            for (int i = 0; i < SystemDatabase.userArray.size(); i++) {
                if (SystemDatabase.userArray.get(i).getUserID().charAt(0) == 'P') {
                    a.add(SystemDatabase.userArray.get(i).getUserID());
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
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtPatientInfo = new javax.swing.JTextArea();
        BtnViewPatient = new javax.swing.JButton();
        BtnCancel = new javax.swing.JButton();
        BtnRemovePatient = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Remove Patient Account");

        jLabel2.setText("Patient ID");

        TxtPatientInfo.setColumns(20);
        TxtPatientInfo.setRows(5);
        jScrollPane1.setViewportView(TxtPatientInfo);

        BtnViewPatient.setText("View Patient");
        BtnViewPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnViewPatientActionPerformed(evt);
            }
        });

        BtnCancel.setText("Cancel");
        BtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelActionPerformed(evt);
            }
        });

        BtnRemovePatient.setText("Remove Patient");
        BtnRemovePatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRemovePatientActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnRemovePatient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CombPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnViewPatient)))
                .addContainerGap(76, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(BtnRemovePatient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnViewPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnViewPatientActionPerformed
        // fills patientInfo textarea with the selected patients info
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

    private void BtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelActionPerformed
        // closes form and returns to Secretary home page
        new SecretaryHome(currentUserID).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnCancelActionPerformed

    private void BtnRemovePatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRemovePatientActionPerformed
        // removes the selected patient, notifies the user it has been deleted and returns to the secretary main form
        String combValue = CombPatientID.getSelectedItem().toString();
        for (int i = 0; i < SystemDatabase.userArray.size(); i++) {
            if (SystemDatabase.userArray.get(i).getUserID().equals(combValue)) {
                SystemDatabase.userArray.remove(i);
                showMessageDialog(null, "Patient account has been deleted");
                SystemDatabase.SaveUserArray();
                new SecretaryHome(currentUserID).setVisible(true);
                this.dispose();               
                break;
            }
        }
        
    }//GEN-LAST:event_BtnRemovePatientActionPerformed

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
            java.util.logging.Logger.getLogger(SecretaryRemovePatientAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SecretaryRemovePatientAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SecretaryRemovePatientAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SecretaryRemovePatientAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SecretaryRemovePatientAccount(currentUserID).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancel;
    private javax.swing.JButton BtnRemovePatient;
    private javax.swing.JButton BtnViewPatient;
    private javax.swing.JComboBox<String> CombPatientID;
    private javax.swing.JTextArea TxtPatientInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
