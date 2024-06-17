/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javaproj.farmindia;

/**
 *
 * @author rajat
 */
import java.awt.Component;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author nihar
 */
public class dBpart extends javax.swing.JFrame {

    private javax.swing.JButton JButton3;
    private javax.swing.JTable jTable1;

    public dBpart() {
        initComponents(null);
        Connect();
        initComponents();
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void Connect() {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded successfully.");
        String url = "jdbc:mysql://localhost:759/javaconn";
        String uname = "root";
        String pass = "rootuser";
        try {
            con = DriverManager.getConnection(url, uname, pass);
        } catch (SQLException ex) {
            Logger.getLogger(dBpart.class.getName()).log(Level.SEVERE, null, ex);  // Fix the class name here
        }
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(dBpart.class.getName()).log(Level.SEVERE, null, ex);  // Fix the class name here
    System.out.println("Driver not found.");
    }
}

    
    
    
    private void initComponents(String a) {

        JButton jButton1 = new javax.swing.JButton();
        JButton jButton2 = new javax.swing.JButton();
        JButton3 = new javax.swing.JButton();
        JButton jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane(); // Initialize jScrollPane1
        jTable1 = new javax.swing.JTable();
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("FRUIT");

        jButton2.setText("VEGETABLE");

        JButton3.setText("GRAINS");

        jButton4.setText("jButton4");
        
        
    
    
  javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(JButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 494, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(216, 216, 216))
        );
        
        
        
    
         layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent((Component) JButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(216, Short.MAX_VALUE))
        );
         
         jButton1.addActionListener((java.awt.event.ActionEvent evt) -> {
             JButton1ActionPerformed(evt);
        });
        
         jButton2.addActionListener((java.awt.event.ActionEvent evt) -> {
             JButton2ActionPerformed(evt);
        });
         
         JButton3.addActionListener((java.awt.event.ActionEvent evt) -> {
             JButton3ActionPerformed(evt);
        });
         
         pack();
    }// </editor-fold>                        
    
   private void JButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    try {
        pst = con.prepareStatement("select crop_name,price from farmer_sell where crop_type='fruit';");
        rs = pst.executeQuery();
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Crop Name");
        model.addColumn("Price");

        // Populate the table model with data from the ResultSet
        while (rs.next()) {
            model.addRow(new Object[]{rs.getString("crop_name"), rs.getDouble("price")});
        }

        // Set the table model to the JTable
        jTable1.setModel(model);


        // Process the ResultSet here (e.g., display in a table or update GUI components)
    } catch (SQLException ex) {
        Logger.getLogger(dBpart.class.getName()).log(Level.SEVERE, null, ex);
    }
}

// Repeat the same changes for JButton2ActionPerformed and JButton3ActionPerformed

   private void JButton2ActionPerformed(java.awt.event.ActionEvent evt) {
    try {
        pst = con.prepareStatement("select crop_name,price from farmer_sell where crop_type='vegetable';");
        rs = pst.executeQuery();
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Crop Name");
        model.addColumn("Price");

        // Populate the table model with data from the ResultSet
        while (rs.next()) {
            model.addRow(new Object[]{rs.getString("crop_name"), rs.getDouble("price")});
        }

        // Set the table model to the JTable
        jTable1.setModel(model);


        // Process the ResultSet here (e.g., display in a table or update GUI components)
    } catch (SQLException ex) {
        Logger.getLogger(dBpart.class.getName()).log(Level.SEVERE, null, ex);
    }
}

private void JButton3ActionPerformed(java.awt.event.ActionEvent evt) {
    try {
        pst = con.prepareStatement("select crop_name,price from farmer_sell where crop_type='grains';");
        rs = pst.executeQuery();
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Crop Name");
        model.addColumn("Price");

        // Populate the table model with data from the ResultSet
        while (rs.next()) {
            model.addRow(new Object[]{rs.getString("crop_name"), rs.getDouble("price")});
        }

        // Set the table model to the JTable
        jTable1.setModel(model);


        // Process the ResultSet here (e.g., display in a table or update GUI components)
    } catch (SQLException ex) {
        Logger.getLogger(dBpart.class.getName()).log(Level.SEVERE, null, ex);
    }
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTable1 = new javax.swing.JTable();
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(238, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String args[])throws Exception {
       
          //</editor-fold>
            java.awt.EventQueue.invokeLater(() -> {
                new dBpart().setVisible(true);
        });

    
    }
      
    // Variables declaration - do not modify                     
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration                   
}

