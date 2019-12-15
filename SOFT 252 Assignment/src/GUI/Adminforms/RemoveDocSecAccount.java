/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Adminforms;

import DatabasePackage.IUser;
import DatabasePackage.SystemDatabase;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author afernandez
 */
public class RemoveDocSecAccount extends javax.swing.JFrame {

    /**
     * Creates new form RemoveDocSecAccount
     */
    static String currentUserID;
    public RemoveDocSecAccount(String userID) {
        initComponents();
        this.currentUserID = userID;
        
            SetCombValues();
    }
    public void SetCombValues(){
        ArrayList<String> a = new ArrayList<String>();
            for (int i = 0; i < SystemDatabase.userArray.size(); i++) {
                if ((SystemDatabase.userArray.get(i).getUserID().charAt(0) == 'S') || (SystemDatabase.userArray.get(i).getUserID().charAt(0) == 'D') ) {
                a.add(SystemDatabase.userArray.get(i).getUserID());
            }
        }
        
        for (String value : a) {
                CombDocSecSelect.addItem(value); 
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
        CombDocSecSelect = new javax.swing.JComboBox<>();
        BtnFindDocSec = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtAreaShowUserInfo = new javax.swing.JTextArea();
        BtnRemove = new javax.swing.JButton();
        BtnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Remove doctor or Secretary ");

        jLabel2.setText("Find user to delete:");

        CombDocSecSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CombDocSecSelectActionPerformed(evt);
            }
        });

        BtnFindDocSec.setText("Find Doctor/Secretary");
        BtnFindDocSec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnFindDocSecActionPerformed(evt);
            }
        });

        TxtAreaShowUserInfo.setColumns(20);
        TxtAreaShowUserInfo.setRows(5);
        jScrollPane1.setViewportView(TxtAreaShowUserInfo);

        BtnRemove.setText("remove user");
        BtnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRemoveActionPerformed(evt);
            }
        });

        BtnCancel.setText("Cancel");
        BtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnRemove, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CombDocSecSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BtnCancel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(BtnFindDocSec)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(CombDocSecSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnFindDocSec))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnFindDocSecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnFindDocSecActionPerformed
        // TODO add your handling code here:
           String value= CombDocSecSelect.getSelectedItem().toString();
           
           IUser temp = SystemDatabase.FindUser(value);
           String firstname = temp.getUserFirstname();
           String surname = temp.getUserSurname();
           String address = temp.getUserAddress();
           
           TxtAreaShowUserInfo.setText(value + "\n" + firstname + "\n" + surname+ "\n" + address);
    }//GEN-LAST:event_BtnFindDocSecActionPerformed

    private void CombDocSecSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CombDocSecSelectActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_CombDocSecSelectActionPerformed

    private void BtnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRemoveActionPerformed
        // TODO add your handling code here:
        String value= CombDocSecSelect.getSelectedItem().toString();
        SystemDatabase.RemoveUser(value);
        SystemDatabase.SaveUserArray();
        showMessageDialog(null, "Account Deleted");
        new AdminHome(currentUserID).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnRemoveActionPerformed

    private void BtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelActionPerformed
        // TODO add your handling code here:
        new AdminHome(currentUserID).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnCancelActionPerformed

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
            java.util.logging.Logger.getLogger(RemoveDocSecAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RemoveDocSecAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RemoveDocSecAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RemoveDocSecAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RemoveDocSecAccount(currentUserID).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancel;
    private javax.swing.JButton BtnFindDocSec;
    private javax.swing.JButton BtnRemove;
    private javax.swing.JComboBox<String> CombDocSecSelect;
    private javax.swing.JTextArea TxtAreaShowUserInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
