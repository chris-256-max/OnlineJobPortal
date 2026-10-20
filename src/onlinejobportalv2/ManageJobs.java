/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package onlinejobportalv2;

/**
 *
 * @author AHSAN
 */
public class ManageJobs extends javax.swing.JFrame {
    
 /*   
    private int getOrCreateCategory(Connection conn, String name)
        throws SQLException {
    String sql = "SELECT category_id, category_name FROM job_categories";

    try (PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            if (rs.getString("category_name")
                    .equalsIgnoreCase(name)) {
                return rs.getInt("category_id");
            }
        }
    }

    sql = "INSERT INTO job_categories (category_name, description) "
        + "VALUES (?, ?)";

    try (PreparedStatement ps = conn.prepareStatement(
            sql, Statement.RETURN_GENERATED_KEYS)) {
        ps.setString(1, name);
        ps.setString(2, "Jobs related to " + name);
        ps.executeUpdate();

        try (ResultSet rs = ps.getGeneratedKeys()) {
            if (rs.next()) return rs.getInt(1);
        }
    }
    throw new SQLException("Could not save job category.");
}

private int getOrCreateJobType(Connection conn, String name)
        throws SQLException {
    String sql = "SELECT type_id, type_name FROM job_types";

    try (PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            if (rs.getString("type_name")
                    .equalsIgnoreCase(name)) {
                return rs.getInt("type_id");
            }
        }
    }

    sql = "INSERT INTO job_types (type_name, description) "
        + "VALUES (?, ?)";

    try (PreparedStatement ps = conn.prepareStatement(
            sql, Statement.RETURN_GENERATED_KEYS)) {
        ps.setString(1, name);
        ps.setString(2, name + " employment");
        ps.executeUpdate();

        try (ResultSet rs = ps.getGeneratedKeys()) {
            if (rs.next()) return rs.getInt(1);
        }
    }
    throw new SQLException("Could not save job type.");
}

private int getOrCreateLocation(Connection conn,
        String locationName, String district) throws SQLException {
    String sql = "SELECT location_id, location_name, district "
               + "FROM locations";

    try (PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            String existingName = rs.getString("location_name");
            String existingDistrict = rs.getString("district");

            if (existingName.equalsIgnoreCase(locationName)
                    && existingDistrict != null
                    && existingDistrict.equalsIgnoreCase(district)) {
                return rs.getInt("location_id");
            }
        }
    }

    sql = "INSERT INTO locations (location_name, district) "
        + "VALUES (?, ?)";

    try (PreparedStatement ps = conn.prepareStatement(
            sql, Statement.RETURN_GENERATED_KEYS)) {
        ps.setString(1, locationName);
        ps.setString(2, district);
        ps.executeUpdate();

        try (ResultSet rs = ps.getGeneratedKeys()) {
            if (rs.next()) return rs.getInt(1);
        }
    }
    throw new SQLException("Could not save job location.");
}
*/

/*
private void saveJob(String title, String description,
        String salaryText, String deadlineText) {

    String category = txtCategory.getText().trim();
    String jobType = txtJobType.getText().trim();
    String location = txtLocation.getText().trim();
    String district = txtDistrict.getText().trim();

    if (title.isEmpty() || description.isEmpty()
            || salaryText.isEmpty() || deadlineText.isEmpty()
            || category.isEmpty() || jobType.isEmpty()
            || location.isEmpty() || district.isEmpty()) {
        JOptionPane.showMessageDialog(this,
                "Please fill in all job details.");
        return;
    }

    double salary;
    java.sql.Date deadline;

    try {
        salary = Double.parseDouble(salaryText);
        deadline = java.sql.Date.valueOf(deadlineText);
    } catch (IllegalArgumentException e) {
        JOptionPane.showMessageDialog(this,
                "Enter a valid salary and deadline (YYYY-MM-DD).");
        return;
    }

    String companySql =
            "SELECT company_id FROM companies WHERE employer_id = ?";

    String insertSql =
            "INSERT INTO jobs (company_id, category_id, type_id, "
          + "location_id, job_title, description, salary, deadline) "
          + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection conn = DatabaseConnection.getConnection()) {
        if (conn == null) return;

        conn.setAutoCommit(false);

        try {
            int companyId;

            try (PreparedStatement ps =
                    conn.prepareStatement(companySql)) {
                ps.setInt(1, employerId);

                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next()) {
                        throw new SQLException(
                                "No company is linked to this employer.");
                    }
                    companyId = rs.getInt("company_id");
                }
            }

            int categoryId = getOrCreateCategory(conn, category);
            int typeId = getOrCreateJobType(conn, jobType);
            int locationId =
                    getOrCreateLocation(conn, location, district);

            try (PreparedStatement ps =
                    conn.prepareStatement(insertSql)) {
                ps.setInt(1, companyId);
                ps.setInt(2, categoryId);
                ps.setInt(3, typeId);
                ps.setInt(4, locationId);
                ps.setString(5, title);
                ps.setString(6, description);
                ps.setDouble(7, salary);
                ps.setDate(8, deadline);
                ps.executeUpdate();
            }

            conn.commit();

            JOptionPane.showMessageDialog(this,
                    "Job posted successfully!");

            txtJobTitle.setText("");
            txtDescription.setText("");
            txtSalary.setText("");
            txtDeadline.setText("");
            txtCategory.setText("");
            txtJobType.setText("");
            txtLocation.setText("");
            txtDistrict.setText("");

            loadJobs();

        } catch (Exception e) {
            conn.rollback();
            throw e;
        } finally {
            conn.setAutoCommit(true);
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
                "Could not post job: " + e.getMessage());
    }
}
*/

    private int employerId;
    
    public ManageJobs(int employerId) {
        initComponents();
        
        getContentPane().setBackground(
        new java.awt.Color(225, 242, 255)
    );
        
        this.employerId = employerId;
        loadJobs();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblJobs = new javax.swing.JTable();
        lblJobTitle = new javax.swing.JLabel();
        txtJobTitle = new javax.swing.JTextField();
        lblDescription = new javax.swing.JLabel();
        lblSalary = new javax.swing.JLabel();
        txtSalary = new javax.swing.JTextField();
        lblDeadline = new javax.swing.JLabel();
        txtDeadline = new javax.swing.JTextField();
        btnPost = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 650));

        lblTitle.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 51, 153));
        lblTitle.setText("MANAGE JOBS");

        tblJobs.setBackground(new java.awt.Color(204, 255, 255));
        tblJobs.setForeground(new java.awt.Color(0, 51, 153));
        tblJobs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Job ID", "Job Title", "Company", "Salary", "Deadline"
            }
        ));
        jScrollPane1.setViewportView(tblJobs);

        lblJobTitle.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lblJobTitle.setForeground(new java.awt.Color(0, 51, 153));
        lblJobTitle.setText("Job Title");

        txtJobTitle.setBackground(new java.awt.Color(0, 51, 153));
        txtJobTitle.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        txtJobTitle.setForeground(new java.awt.Color(255, 255, 255));

        lblDescription.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lblDescription.setForeground(new java.awt.Color(0, 51, 153));
        lblDescription.setText("Description");

        lblSalary.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lblSalary.setForeground(new java.awt.Color(0, 51, 153));
        lblSalary.setText("Salary");

        txtSalary.setBackground(new java.awt.Color(0, 51, 153));
        txtSalary.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        txtSalary.setForeground(new java.awt.Color(255, 255, 255));

        lblDeadline.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lblDeadline.setForeground(new java.awt.Color(0, 51, 153));
        lblDeadline.setText("Deadline (YYYY-MM-DD)");

        txtDeadline.setBackground(new java.awt.Color(0, 51, 153));
        txtDeadline.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        txtDeadline.setForeground(new java.awt.Color(255, 255, 255));

        btnPost.setBackground(new java.awt.Color(0, 51, 153));
        btnPost.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnPost.setForeground(new java.awt.Color(255, 255, 255));
        btnPost.setText("POST JOB");
        btnPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostActionPerformed(evt);
            }
        });

        btnRefresh.setBackground(new java.awt.Color(0, 51, 153));
        btnRefresh.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh.setText("REFRESH");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(0, 51, 153));
        btnBack.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        txtDescription.setBackground(new java.awt.Color(0, 51, 153));
        txtDescription.setColumns(20);
        txtDescription.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        txtDescription.setForeground(new java.awt.Color(255, 255, 255));
        txtDescription.setRows(5);
        jScrollPane3.setViewportView(txtDescription);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblDescription)
                                    .addComponent(lblJobTitle)
                                    .addComponent(lblSalary)
                                    .addComponent(lblDeadline))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnRefresh)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBack))
                                    .addComponent(btnPost, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtJobTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtDeadline, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
                                        .addComponent(txtSalary, javax.swing.GroupLayout.Alignment.LEADING))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(215, 215, 215)
                                .addComponent(lblTitle)))
                        .addGap(0, 104, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJobTitle)
                    .addComponent(txtJobTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescription)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSalary))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDeadline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDeadline))
                .addGap(52, 52, 52)
                .addComponent(btnPost)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefresh)
                    .addComponent(btnBack))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostActionPerformed
        
String title = txtJobTitle.getText().trim();
String description = txtDescription.getText().trim();
String salaryText = txtSalary.getText().trim();
String deadlineText = txtDeadline.getText().trim();

if (title.isEmpty() || salaryText.isEmpty() || deadlineText.isEmpty()) {
    javax.swing.JOptionPane.showMessageDialog(
        this, "Enter the job title, salary, and deadline!"
    );
    return;
}

try {
    java.math.BigDecimal salary =
        new java.math.BigDecimal(salaryText);
    java.sql.Date deadline =
        java.sql.Date.valueOf(deadlineText);

    java.sql.Connection conn = DatabaseConnection.getConnection();

    java.sql.PreparedStatement companyQuery = conn.prepareStatement(
        "SELECT company_id FROM companies WHERE employer_id = ? LIMIT 1"
    );
    companyQuery.setInt(1, employerId);
    java.sql.ResultSet companyRs = companyQuery.executeQuery();

    if (!companyRs.next()) {
        javax.swing.JOptionPane.showMessageDialog(
            this, "Create a company profile before posting jobs!"
        );
        conn.close();
        return;
    }

    int companyId = companyRs.getInt("company_id");

    java.sql.PreparedStatement pst = conn.prepareStatement(
        "INSERT INTO jobs (company_id, category_id, type_id, location_id, " +
        "job_title, description, salary, deadline) " +
        "VALUES (?, 1, 1, 1, ?, ?, ?, ?)"
    );

    pst.setInt(1, companyId);
    pst.setString(2, title);
    pst.setString(3, description);
    pst.setBigDecimal(4, salary);
    pst.setDate(5, deadline);
    pst.executeUpdate();

    conn.close();

    javax.swing.JOptionPane.showMessageDialog(
        this, "Job posted successfully!"
    );

    txtJobTitle.setText("");
    txtDescription.setText("");
    txtSalary.setText("");
    txtDeadline.setText("");
    loadJobs();

} catch (IllegalArgumentException e) {
    javax.swing.JOptionPane.showMessageDialog(
        this, "Enter salary as a number and deadline as YYYY-MM-DD."
    );
} catch (Exception e) {
    javax.swing.JOptionPane.showMessageDialog(this, e.getMessage());
}

    }//GEN-LAST:event_btnPostActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        loadJobs();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(ManageJobs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageJobs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageJobs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageJobs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageJobs(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnPost;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDeadline;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblJobTitle;
    private javax.swing.JLabel lblSalary;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblJobs;
    private javax.swing.JTextField txtDeadline;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtJobTitle;
    private javax.swing.JTextField txtSalary;
    // End of variables declaration//GEN-END:variables


private void loadJobs() {
    String sql = "SELECT j.job_id, j.job_title, c.company_name, " +
                 "j.salary, j.deadline FROM jobs j " +
                 "JOIN companies c ON j.company_id = c.company_id " +
                 "WHERE c.employer_id = ?";

    try {
        java.sql.Connection conn = DatabaseConnection.getConnection();
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, employerId);

        java.sql.ResultSet rs = pst.executeQuery();
        javax.swing.table.DefaultTableModel model =
            (javax.swing.table.DefaultTableModel) tblJobs.getModel();

        model.setRowCount(0);

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("job_id"),
                rs.getString("job_title"),
                rs.getString("company_name"),
                rs.getBigDecimal("salary"),
                rs.getDate("deadline")
            });
        }

        conn.close();
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, e.getMessage());
    }
}
    
}
