/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package onlinejobportalv2;

/**
 *
 * @author AHSAN
 */
public class JobSeekerDashboard extends javax.swing.JFrame {

    private int seekerId;
    public JobSeekerDashboard(int seekerId) {
        initComponents();
        
        getContentPane().setBackground(
        new java.awt.Color(225, 242, 255)
    );
        
        this.seekerId = seekerId;
        loadDashboardSummary();
    }
    
    
    private void loadDashboardSummary() {
    String sql = "SELECT COUNT(*) AS total, " +
                 "SUM(CASE WHEN status_id = 1 THEN 1 ELSE 0 END) AS pending, " +
                 "SUM(CASE WHEN status_id = 2 THEN 1 ELSE 0 END) AS accepted, " +
                 "SUM(CASE WHEN status_id = 3 THEN 1 ELSE 0 END) AS rejected " +
                 "FROM applications WHERE seeker_id = ?";

    try {
        java.sql.Connection conn = DatabaseConnection.getConnection();
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, seekerId);

        java.sql.ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            lblTotalApplications.setText("Total Applications: " + rs.getInt("total"));
            lblPending.setText("Pending: " + rs.getInt("pending"));
            lblAccepted.setText("Accepted: " + rs.getInt("accepted"));
            lblRejected.setText("Rejected: " + rs.getInt("rejected"));
        }

        conn.close();

    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, e.getMessage());
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblWelcome = new javax.swing.JLabel();
        lblSubtitle = new javax.swing.JLabel();
        btnViewJobs = new javax.swing.JButton();
        btnMyApplications = new javax.swing.JButton();
        btnMyProfile = new javax.swing.JButton();
        btnMyResume = new javax.swing.JButton();
        btnMySkills = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        lblContentTitle = new javax.swing.JLabel();
        lblTotalApplications = new javax.swing.JLabel();
        lblPending = new javax.swing.JLabel();
        lblAccepted = new javax.swing.JLabel();
        lblRejected = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDashboardInfo = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(750, 500));

        lblWelcome.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(0, 51, 153));
        lblWelcome.setText("Welcome, Job Seeker");

        lblSubtitle.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lblSubtitle.setForeground(new java.awt.Color(0, 51, 153));
        lblSubtitle.setText("Find jobs and manage your applications");

        btnViewJobs.setBackground(new java.awt.Color(0, 51, 153));
        btnViewJobs.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnViewJobs.setForeground(new java.awt.Color(255, 255, 255));
        btnViewJobs.setText("VIEW AVAILABLE JOBS");
        btnViewJobs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewJobsActionPerformed(evt);
            }
        });

        btnMyApplications.setBackground(new java.awt.Color(0, 51, 153));
        btnMyApplications.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnMyApplications.setForeground(new java.awt.Color(255, 255, 255));
        btnMyApplications.setText("MY APPLICATIONS");
        btnMyApplications.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyApplicationsActionPerformed(evt);
            }
        });

        btnMyProfile.setBackground(new java.awt.Color(0, 51, 153));
        btnMyProfile.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnMyProfile.setForeground(new java.awt.Color(255, 255, 255));
        btnMyProfile.setText("MY PROFILE");
        btnMyProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyProfileActionPerformed(evt);
            }
        });

        btnMyResume.setBackground(new java.awt.Color(0, 51, 153));
        btnMyResume.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnMyResume.setForeground(new java.awt.Color(242, 242, 242));
        btnMyResume.setText("MY RESUME");
        btnMyResume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyResumeActionPerformed(evt);
            }
        });

        btnMySkills.setBackground(new java.awt.Color(0, 51, 153));
        btnMySkills.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnMySkills.setForeground(new java.awt.Color(242, 242, 242));
        btnMySkills.setText("MY SKILLS");
        btnMySkills.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMySkillsActionPerformed(evt);
            }
        });

        btnLogout.setBackground(new java.awt.Color(0, 51, 153));
        btnLogout.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setText("LOGOUT");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        lblContentTitle.setBackground(new java.awt.Color(0, 0, 0));
        lblContentTitle.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        lblContentTitle.setForeground(new java.awt.Color(0, 51, 153));
        lblContentTitle.setText("Dashboard Overview");

        lblTotalApplications.setBackground(new java.awt.Color(255, 255, 255));
        lblTotalApplications.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lblTotalApplications.setForeground(new java.awt.Color(0, 51, 153));
        lblTotalApplications.setText("Total Applications: 0");

        lblPending.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lblPending.setForeground(new java.awt.Color(0, 51, 153));
        lblPending.setText("Pending: 0");

        lblAccepted.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lblAccepted.setForeground(new java.awt.Color(0, 51, 153));
        lblAccepted.setText("Accepted: 0 ");

        lblRejected.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lblRejected.setForeground(new java.awt.Color(0, 51, 153));
        lblRejected.setText("Rejected: 0");

        txtDashboardInfo.setColumns(20);
        txtDashboardInfo.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        txtDashboardInfo.setForeground(new java.awt.Color(0, 51, 153));
        txtDashboardInfo.setRows(5);
        txtDashboardInfo.setText("Welcome to your Dashboard!");
        jScrollPane2.setViewportView(txtDashboardInfo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblSubtitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addGap(62, 62, 62))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMyApplications)
                            .addComponent(btnMyProfile)
                            .addComponent(btnMyResume)
                            .addComponent(btnViewJobs)
                            .addComponent(btnMySkills))
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotalApplications, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblContentTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblRejected, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblAccepted, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                .addComponent(lblPending, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblWelcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLogout)
                            .addComponent(lblSubtitle))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(btnViewJobs))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblContentTitle)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMyApplications)
                            .addComponent(lblTotalApplications))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMyProfile)
                            .addComponent(lblPending, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMyResume, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAccepted, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblRejected))
                    .addComponent(btnMySkills))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMySkillsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMySkillsActionPerformed
        new MySkills(seekerId).setVisible(true);
    }//GEN-LAST:event_btnMySkillsActionPerformed

    private void btnMyApplicationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyApplicationsActionPerformed
        new MyApplications(seekerId).setVisible(true);
    }//GEN-LAST:event_btnMyApplicationsActionPerformed

    private void btnMyProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyProfileActionPerformed
        new MyProfile(seekerId).setVisible(true);
    }//GEN-LAST:event_btnMyProfileActionPerformed

    private void btnViewJobsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewJobsActionPerformed
        new AvailableJobs(seekerId).setVisible(true);
    }//GEN-LAST:event_btnViewJobsActionPerformed

    private void btnMyResumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyResumeActionPerformed
        new MyResume(seekerId).setVisible(true);
    }//GEN-LAST:event_btnMyResumeActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        
int choice = javax.swing.JOptionPane.showConfirmDialog(
    this,
    "Are you sure you want to logout?",
    "Logout",
    javax.swing.JOptionPane.YES_NO_OPTION
);

if (choice == javax.swing.JOptionPane.YES_OPTION) {
    new Login().setVisible(true);
    this.dispose();
}

    }//GEN-LAST:event_btnLogoutActionPerformed

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
            java.util.logging.Logger.getLogger(JobSeekerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JobSeekerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JobSeekerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JobSeekerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JobSeekerDashboard(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMyApplications;
    private javax.swing.JButton btnMyProfile;
    private javax.swing.JButton btnMyResume;
    private javax.swing.JButton btnMySkills;
    private javax.swing.JButton btnViewJobs;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAccepted;
    private javax.swing.JLabel lblContentTitle;
    private javax.swing.JLabel lblPending;
    private javax.swing.JLabel lblRejected;
    private javax.swing.JLabel lblSubtitle;
    private javax.swing.JLabel lblTotalApplications;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JTextArea txtDashboardInfo;
    // End of variables declaration//GEN-END:variables
}
