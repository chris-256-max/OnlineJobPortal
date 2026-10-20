/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package onlinejobportalv2;
import java.sql.Connection;
import javax.swing.JOptionPane;
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        getContentPane().setBackground(
        new java.awt.Color(225, 242, 255)
    );

    setSize(500, 400);
    setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblSubtitle = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnRegister = new javax.swing.JButton();
        lblMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 0));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setForeground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(500, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 51, 153));
        lblTitle.setText("ONLINE  JOB  PORTAL");
        lblTitle.setInheritsPopupMenu(false);
        lblTitle.setMaximumSize(new java.awt.Dimension(92, 16));
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 267, 35));

        lblSubtitle.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lblSubtitle.setForeground(new java.awt.Color(0, 51, 153));
        lblSubtitle.setText("Login to your account");
        getContentPane().add(lblSubtitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, -1));

        lblEmail.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(0, 51, 153));
        lblEmail.setText("Email:");
        getContentPane().add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        lblPassword.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(0, 51, 153));
        lblPassword.setText("Password:");
        getContentPane().add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 320, -1));
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 320, -1));

        btnLogin.setBackground(new java.awt.Color(0, 51, 153));
        btnLogin.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("LOGIN");
        btnLogin.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnLogin.setBorderPainted(false);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 80, 30));

        btnClear.setBackground(new java.awt.Color(0, 51, 153));
        btnClear.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnClear.setForeground(new java.awt.Color(242, 242, 242));
        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 82, 30));

        btnRegister.setBackground(new java.awt.Color(0, 51, 153));
        btnRegister.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister.setText("CREATE ACCOUNT");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, -1, -1));
        getContentPane().add(lblMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 327, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String email = txtEmail.getText();
String password = new String(txtPassword.getPassword());

String sql = "SELECT * FROM users WHERE email = ? AND password = ?";

try {
    Connection conn = DatabaseConnection.getConnection();

    java.sql.PreparedStatement pst = conn.prepareStatement(sql);

    pst.setString(1, email);
    pst.setString(2, password);

    java.sql.ResultSet rs = pst.executeQuery();

    if (rs.next()) {
        JOptionPane.showMessageDialog(this, "Login successful!");

        String role = rs.getString("role");

        if (role.equals("Job Seeker")) {
            int userId = rs.getInt("user_id");
            
            java.sql.PreparedStatement pst2 = conn.prepareStatement(
              "SELECT seeker_id FROM job_seekers WHERE user_id = ?"
            );
            pst2.setInt(1, userId);
            java.sql.ResultSet rs2 = pst2.executeQuery();
            
            if (rs2.next()) {
                int seekerId = rs2.getInt("seeker_id");
                new JobSeekerDashboard(seekerId).setVisible(true);
                this.dispose();
            }

                    
        
} else if (role.equals("Employer")) {

    int userId = rs.getInt("user_id");

    java.sql.PreparedStatement pst3 = conn.prepareStatement(
        "SELECT employer_id FROM employers WHERE user_id = ?"
    );

    pst3.setInt(1, userId);
    java.sql.ResultSet rs3 = pst3.executeQuery();

    if (rs3.next()) {
        int employerId = rs3.getInt("employer_id");

        new EmployerDashboard(employerId).setVisible(true);
        this.dispose();
    } else {
        JOptionPane.showMessageDialog(
            this, "No employer profile found!"
        );
    }
}

    } else {
        JOptionPane.showMessageDialog(this, "Invalid email or password!");
    }

} catch (Exception e) {
    JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
}
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        new CreateAccount().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegisterActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblSubtitle;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables


}
