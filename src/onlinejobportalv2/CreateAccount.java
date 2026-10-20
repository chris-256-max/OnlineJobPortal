/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package onlinejobportalv2;

/**
 *
 * @author AHSAN
 */
public class CreateAccount extends javax.swing.JFrame {
    
    
private void registerAccount() {
    String name = txtFullName.getText().trim();
    String email = txtEmail.getText().trim();
    String password = new String(txtPassword.getPassword());
    String phone = txtPhone.getText().trim();
    String role = cmbRole.getSelectedItem().toString();
    String companyName = txtCompanyName.getText().trim();

    if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(
            this, "Please fill in name, email and password.");
        return;
    }

    if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$")) {
        javax.swing.JOptionPane.showMessageDialog(
            this, "Please enter a valid email address.");
        return;
    }

    if (password.length() < 5) {
        javax.swing.JOptionPane.showMessageDialog(
            this, "Password must contain at least 5 characters.");
        return;
    }

    if (role.equals("Employer") && companyName.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(
            this, "Please enter your company name.");
        return;
    }

    String checkSql = "SELECT user_id FROM users WHERE email = ?";
    String userSql = "INSERT INTO users "
        + "(full_name, email, password, role) VALUES (?, ?, ?, ?)";
    String seekerSql = "INSERT INTO job_seekers (user_id, phone) VALUES (?, ?)";
    String employerSql = "INSERT INTO employers "
        + "(user_id, phone, position) VALUES (?, ?, ?)";
    String companySql = "INSERT INTO companies "
        + "(employer_id, company_name) VALUES (?, ?)";

    try (java.sql.Connection conn =
             DatabaseConnection.getConnection()) {

        if (conn == null) {
            javax.swing.JOptionPane.showMessageDialog(
                this, "Could not connect to the database.");
            return;
        }

        conn.setAutoCommit(false);

        try {
            // Check whether the email already exists
            try (java.sql.PreparedStatement check =
                     conn.prepareStatement(checkSql)) {
                check.setString(1, email);

                try (java.sql.ResultSet rs = check.executeQuery()) {
                    if (rs.next()) {
                        conn.rollback();
                        javax.swing.JOptionPane.showMessageDialog(
                            this, "This email is already registered.");
                        return;
                    }
                }
            }

            // Create the main user account
            int userId;

            try (java.sql.PreparedStatement ps =
                     conn.prepareStatement(
                         userSql, java.sql.Statement.RETURN_GENERATED_KEYS)) {

                ps.setString(1, name);
                ps.setString(2, email);
                ps.setString(3, password);
                ps.setString(4, role);
                ps.executeUpdate();

                try (java.sql.ResultSet keys = ps.getGeneratedKeys()) {
                    if (!keys.next()) {
                        throw new java.sql.SQLException(
                            "Could not obtain the new user ID.");
                    }
                    userId = keys.getInt(1);
                }
            }

            if (role.equals("Job Seeker")) {
                try (java.sql.PreparedStatement ps =
                         conn.prepareStatement(seekerSql)) {
                    ps.setInt(1, userId);

                    if (phone.isEmpty()) {
                        ps.setNull(2, java.sql.Types.VARCHAR);
                    } else {
                        ps.setString(2, phone);
                    }

                    ps.executeUpdate();
                }

            } else {
                int employerId;

                try (java.sql.PreparedStatement ps =
                         conn.prepareStatement(
                             employerSql,
                             java.sql.Statement.RETURN_GENERATED_KEYS)) {

                    ps.setInt(1, userId);

                    if (phone.isEmpty()) {
                        ps.setNull(2, java.sql.Types.VARCHAR);
                    } else {
                        ps.setString(2, phone);
                    }

                    ps.setString(3, "Employer");
                    ps.executeUpdate();

                    try (java.sql.ResultSet keys = ps.getGeneratedKeys()) {
                        if (!keys.next()) {
                            throw new java.sql.SQLException(
                                "Could not obtain the employer ID.");
                        }
                        employerId = keys.getInt(1);
                    }
                }

                // Create the employer's company record
                try (java.sql.PreparedStatement ps =
                         conn.prepareStatement(companySql)) {
                    ps.setInt(1, employerId);
                    ps.setString(2, companyName);
                    ps.executeUpdate();
                }
            }

            conn.commit();

            javax.swing.JOptionPane.showMessageDialog(
                this, "Account created successfully! You can now log in.");

            new Login().setVisible(true);
            this.dispose();

        } catch (java.sql.SQLException e) {
            conn.rollback();
            throw e;
        } finally {
            conn.setAutoCommit(true);
        }

    } catch (java.sql.SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(
            this, "Registration failed: " + e.getMessage());
    }
}

private void clearFields() {
    txtFullName.setText("");
    txtEmail.setText("");
    txtPassword.setText("");
    txtPhone.setText("");
    txtCompanyName.setText("");
    cmbRole.setSelectedIndex(0);
}

private void updateRoleFields() {
    boolean employer = cmbRole.getSelectedItem() != null
        && cmbRole.getSelectedItem().toString().equals("Employer");

    lblCompany.setVisible(employer);
    txtCompanyName.setVisible(employer);
}


    
    public CreateAccount() {
        initComponents();
        
        getContentPane().setBackground(
        new java.awt.Color(225, 242, 255)
        );
        
        setSize(550, 600);
        setLocationRelativeTo(null);
        
        updateRoleFields();
/*       
private void registerAccount() {
    String name = txtFullName.getText().trim();
    String email = txtEmail.getText().trim();
    String password = new String(txtPassword.getPassword());
    String phone = txtPhone.getText().trim();
    String role = cmbRole.getSelectedItem().toString();
    String companyName = txtCompanyName.getText().trim();

    if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(
            this, "Please fill in name, email and password.");
        return;
    }

    if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$")) {
        javax.swing.JOptionPane.showMessageDialog(
            this, "Please enter a valid email address.");
        return;
    }

    if (password.length() < 5) {
        javax.swing.JOptionPane.showMessageDialog(
            this, "Password must contain at least 5 characters.");
        return;
    }

    if (role.equals("Employer") && companyName.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(
            this, "Please enter your company name.");
        return;
    }

    String checkSql = "SELECT user_id FROM users WHERE email = ?";
    String userSql = "INSERT INTO users "
        + "(full_name, email, password, role) VALUES (?, ?, ?, ?)";
    String seekerSql = "INSERT INTO job_seekers (user_id, phone) VALUES (?, ?)";
    String employerSql = "INSERT INTO employers "
        + "(user_id, phone, position) VALUES (?, ?, ?)";
    String companySql = "INSERT INTO companies "
        + "(employer_id, company_name) VALUES (?, ?)";

    try (java.sql.Connection conn =
             DatabaseConnection.getConnection()) {

        if (conn == null) {
            javax.swing.JOptionPane.showMessageDialog(
                this, "Could not connect to the database.");
            return;
        }

        conn.setAutoCommit(false);

        try {
            // Check whether the email already exists
            try (java.sql.PreparedStatement check =
                     conn.prepareStatement(checkSql)) {
                check.setString(1, email);

                try (java.sql.ResultSet rs = check.executeQuery()) {
                    if (rs.next()) {
                        conn.rollback();
                        javax.swing.JOptionPane.showMessageDialog(
                            this, "This email is already registered.");
                        return;
                    }
                }
            }

            // Create the main user account
            int userId;

            try (java.sql.PreparedStatement ps =
                     conn.prepareStatement(
                         userSql, java.sql.Statement.RETURN_GENERATED_KEYS)) {

                ps.setString(1, name);
                ps.setString(2, email);
                ps.setString(3, password);
                ps.setString(4, role);
                ps.executeUpdate();

                try (java.sql.ResultSet keys = ps.getGeneratedKeys()) {
                    if (!keys.next()) {
                        throw new java.sql.SQLException(
                            "Could not obtain the new user ID.");
                    }
                    userId = keys.getInt(1);
                }
            }

            if (role.equals("Job Seeker")) {
                try (java.sql.PreparedStatement ps =
                         conn.prepareStatement(seekerSql)) {
                    ps.setInt(1, userId);

                    if (phone.isEmpty()) {
                        ps.setNull(2, java.sql.Types.VARCHAR);
                    } else {
                        ps.setString(2, phone);
                    }

                    ps.executeUpdate();
                }

            } else {
                int employerId;

                try (java.sql.PreparedStatement ps =
                         conn.prepareStatement(
                             employerSql,
                             java.sql.Statement.RETURN_GENERATED_KEYS)) {

                    ps.setInt(1, userId);

                    if (phone.isEmpty()) {
                        ps.setNull(2, java.sql.Types.VARCHAR);
                    } else {
                        ps.setString(2, phone);
                    }

                    ps.setString(3, "Employer");
                    ps.executeUpdate();

                    try (java.sql.ResultSet keys = ps.getGeneratedKeys()) {
                        if (!keys.next()) {
                            throw new java.sql.SQLException(
                                "Could not obtain the employer ID.");
                        }
                        employerId = keys.getInt(1);
                    }
                }

                // Create the employer's company record
                try (java.sql.PreparedStatement ps =
                         conn.prepareStatement(companySql)) {
                    ps.setInt(1, employerId);
                    ps.setString(2, companyName);
                    ps.executeUpdate();
                }
            }

            conn.commit();

            javax.swing.JOptionPane.showMessageDialog(
                this, "Account created successfully! You can now log in.");

            new Login().setVisible(true);
            this.dispose();

        } catch (java.sql.SQLException e) {
            conn.rollback();
            throw e;
        } finally {
            conn.setAutoCommit(true);
        }

    } catch (java.sql.SQLException e) {
        javax.swing.JOptionPane.d: " + e.getMessage());
    }
}

private void clearFields() {
    txtFullName.setText("");
    txtEmail.setText("");
    txtPassword.setText("");
    txtPhone.setText("");
    txtCompanyName.setText("");
    cmbRole.setSelectedIndex(0);
}

private void updateRoleFields() {
    boolean employer = cmbRole.getSelectedItem() != null
        && cmbRole.getSelectedItem().toString().equals("Employer");

    lblCompany.setVisible(employer);
    txtCompanyName.setVisible(employer);
}
*/
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lblRole = new javax.swing.JLabel();
        cmbRole = new javax.swing.JComboBox<>();
        lblPhone = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        lblCompany = new javax.swing.JLabel();
        txtCompanyName = new javax.swing.JTextField();
        btnRegister = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 51, 153));
        lblTitle.setText("CREATE ACCOUNT");

        lblName.setText("Full Name");

        lblEmail.setText("Email");

        lblPassword.setText("Password");

        lblRole.setText("Account Type");

        cmbRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Job Seeker", "Employer" }));
        cmbRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRoleActionPerformed(evt);
            }
        });

        lblPhone.setText("Phone");

        lblCompany.setText("Company Name");

        btnRegister.setText("REGISTER");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnBack.setText("Back to Login");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(137, 137, 137))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEmail)
                            .addComponent(lblName)
                            .addComponent(lblPassword)
                            .addComponent(lblRole)
                            .addComponent(lblPhone)
                            .addComponent(lblCompany))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRegister)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBack))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtFullName)
                                .addComponent(txtEmail)
                                .addComponent(txtPassword)
                                .addComponent(cmbRole, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPhone)
                                .addComponent(txtCompanyName, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(lblMessage)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblName)
                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRole)
                    .addComponent(cmbRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhone)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCompany)
                    .addComponent(txtCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegister)
                    .addComponent(btnClear)
                    .addComponent(btnBack))
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMessage)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        registerAccount();
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearFields();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void cmbRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRoleActionPerformed
        updateRoleFields();
    }//GEN-LAST:event_cmbRoleActionPerformed

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
            java.util.logging.Logger.getLogger(CreateAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnRegister;
    private javax.swing.JComboBox<String> cmbRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCompany;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtCompanyName;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
