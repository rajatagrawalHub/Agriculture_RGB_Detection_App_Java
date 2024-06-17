package com.javaproj.farmindia;

import java.awt.Color;
import javax.swing.*;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.table.DefaultTableModel;

public class mainF extends javax.swing.JFrame implements ActionListener {
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    String Soil;

    public mainF(int type) {
        initComponents();
        jButton6.setBackground(new Color(255,255,255));
        jButton7.setBackground(new Color(255,255,255));
        jButton8.setBackground(new Color(255,255,255));
        jButton9.setBackground(new Color(255,255,255));
        jButton10.setBackground(new Color(255,255,255));
        jButton2.setBackground(new Color(255,255,255));
        jComboBox1.setBackground(new Color(255,255,255));
        jButton10.addActionListener(this);
        jButton9.addActionListener(this);
        jButton8.addActionListener(this);
        jLayeredPane9.setVisible(false);
        jLayeredPane6.setVisible(false);
        errorLAbel1.setVisible(false);
        errorLAbel.setVisible(false);
        if(type == 1){
            jLayeredPane3.setVisible(true);
            jLayeredPane12.setVisible(false);
        }else{
             jLayeredPane3.setVisible(false);
             jLayeredPane2.setVisible(false);
            jLayeredPane12.setVisible(true);
        }
        setVisible(true);
        Connect();
        get_crop_name();
    }
    
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
     
    private void get_crop_name(){
        try {
        pst = con.prepareStatement("select crop_name from crop;");
        rs = pst.executeQuery();
        while (rs.next()) {
            jComboBox1.addItem(rs.getString("crop_name"));
        }
    } catch (SQLException ex) {
        Logger.getLogger(dBpart.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    private void add_crop(String CropName, Double Price, Double Quantity){
        try {
        pst = con.prepareStatement("Insert into crop values('"+CropName+"',"+Price+","+Quantity+");");
        pst.execute();
  
    } catch (SQLException ex) {
        Logger.getLogger(dBpart.class.getName()).log(Level.SEVERE, null, ex);
        errorLAbel.setText("Duplicate Names Not allowed");
        errorLAbel.setVisible(true);
    }
    }
    
     private void get_crop_price(String CropName){
        try {
        pst = con.prepareStatement("select crop_price from crop where crop_name ='"+ CropName + "';");
        rs = pst.executeQuery();
       
        while (rs.next()) {
           jTextField8.setText(String.valueOf(rs.getDouble("crop_price")));
        }
    } catch (SQLException ex) {
        Logger.getLogger(dBpart.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
     
    private Double get_qunatity_available(String CropName){
        try {
        pst = con.prepareStatement("select qty_available from Crop where crop_name ='"+ CropName + "';");
        rs = pst.executeQuery();
        rs.next();
        return rs.getDouble("qty_available");
        
    } catch (SQLException ex) {
        Logger.getLogger(dBpart.class.getName()).log(Level.SEVERE, null, ex);
        return 0.00;
    }
    }
    
    private void update_quantity(String CropName, Double Quantity){
        try {
        pst = con.prepareStatement("update Crop set qty_available = "+Quantity+"where crop_name = '"+CropName+"';");
        pst.executeUpdate();
        
    } catch (SQLException ex) {
        Logger.getLogger(dBpart.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLayeredPane12 = new javax.swing.JLayeredPane();
        jLayeredPane13 = new javax.swing.JLayeredPane();
        jLayeredPane14 = new javax.swing.JLayeredPane();
        jLabel15 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jTextField8 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jTextField9 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        errorLAbel1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jLayeredPane9 = new javax.swing.JLayeredPane();
        jLayeredPane10 = new javax.swing.JLayeredPane();
        jLayeredPane11 = new javax.swing.JLayeredPane();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTextField5 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jTextField6 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        errorLAbel = new javax.swing.JLabel();
        jLayeredPane6 = new javax.swing.JLayeredPane();
        jLayeredPane7 = new javax.swing.JLayeredPane();
        jLayeredPane8 = new javax.swing.JLayeredPane();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        labelSoilType = new javax.swing.JLabel();
        imageLabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLayeredPane1.setBackground(new java.awt.Color(245, 245, 245));
        jLayeredPane1.setOpaque(true);
        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane2.setBackground(new java.awt.Color(87, 81, 150));
        jLayeredPane2.setOpaque(true);
        jLayeredPane2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setText("Extended Support");
        jLabel1.setFocusable(false);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLayeredPane2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 100, 20));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("FARM INDIA");
        jLabel7.setFocusable(false);
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLayeredPane2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 120, 30));

        jButton2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(103, 96, 184));
        jButton2.setText("Sell Harvest");
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 102, 255), 1, true));
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jLayeredPane2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 240, 40));

        jButton6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(103, 96, 184));
        jButton6.setText("Know Your Soil");
        jButton6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 102, 255), 1, true));
        jButton6.setFocusable(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jLayeredPane2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 240, 40));

        jButton7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(103, 96, 184));
        jButton7.setText("More Info");
        jButton7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 102, 255), 1, true));
        jButton7.setFocusable(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jLayeredPane2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 240, 40));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Meet Developers");
        jLabel2.setFocusable(false);
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jLayeredPane2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 440, 100, 20));

        jButton8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(103, 96, 184));
        jButton8.setText("Government Schemes");
        jButton8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 102, 255), 1, true));
        jButton8.setFocusable(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jLayeredPane2.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 240, 40));

        jButton9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(103, 96, 184));
        jButton9.setText("Farmer's Portal");
        jButton9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 102, 255), 1, true));
        jButton9.setFocusable(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jLayeredPane2.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 240, 40));

        jButton10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton10.setForeground(new java.awt.Color(103, 96, 184));
        jButton10.setText("Call Hellpline");
        jButton10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 102, 255), 1, true));
        jButton10.setFocusable(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jLayeredPane2.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 240, 40));

        jLayeredPane1.add(jLayeredPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 480));

        jLayeredPane12.setOpaque(true);
        jLayeredPane12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane13.setBackground(new java.awt.Color(255, 153, 171));
        jLayeredPane13.setForeground(new java.awt.Color(255, 239, 153));
        jLayeredPane13.setOpaque(true);

        javax.swing.GroupLayout jLayeredPane13Layout = new javax.swing.GroupLayout(jLayeredPane13);
        jLayeredPane13.setLayout(jLayeredPane13Layout);
        jLayeredPane13Layout.setHorizontalGroup(
            jLayeredPane13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );
        jLayeredPane13Layout.setVerticalGroup(
            jLayeredPane13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jLayeredPane12.add(jLayeredPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 40));

        jLayeredPane14.setBackground(new java.awt.Color(255, 153, 171));
        jLayeredPane14.setForeground(new java.awt.Color(255, 239, 153));
        jLayeredPane14.setOpaque(true);

        javax.swing.GroupLayout jLayeredPane14Layout = new javax.swing.GroupLayout(jLayeredPane14);
        jLayeredPane14.setLayout(jLayeredPane14Layout);
        jLayeredPane14Layout.setHorizontalGroup(
            jLayeredPane14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );
        jLayeredPane14Layout.setVerticalGroup(
            jLayeredPane14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jLayeredPane12.add(jLayeredPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 770, 40));

        jLabel15.setBackground(new java.awt.Color(147, 140, 180));
        jLabel15.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("0.00");
        jLabel15.setFocusable(false);
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel15.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jLabel15InputMethodTextChanged(evt);
            }
        });
        jLayeredPane12.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 140, 30));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(147, 140, 228)));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 19, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        jLayeredPane12.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 250, 40));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Name Of The Crop");
        jLabel6.setFocusable(false);
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLayeredPane12.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 110, 20));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Quantity ");
        jLabel8.setFocusable(false);
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLayeredPane12.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 110, 20));

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(147, 140, 228)));

        jTextField8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(116, 116, 116));
        jTextField8.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jTextField8.setEnabled(false);
        jTextField8.setFocusable(false);
        jTextField8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField8FocusGained(evt);
            }
        });
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLayeredPane12.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, -1, 40));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Buying Price ");
        jLabel12.setFocusable(false);
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLayeredPane12.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 110, 20));

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(147, 140, 228)));

        jTextField9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(116, 116, 116));
        jTextField9.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jTextField9.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField9FocusGained(evt);
            }
        });
        jTextField9.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextField9InputMethodTextChanged(evt);
            }
        });
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLayeredPane12.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, -1, 40));

        jButton4.setBackground(new java.awt.Color(147, 140, 228));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Buy Crop");
        jButton4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 102, 255), 1, true));
        jButton4.setFocusable(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jLayeredPane12.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 80, 30));

        errorLAbel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        errorLAbel1.setForeground(new java.awt.Color(255, 19, 32));
        errorLAbel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorLAbel1.setText("Error Message");
        errorLAbel1.setFocusable(false);
        errorLAbel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLayeredPane12.add(errorLAbel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 250, 20));

        jLabel16.setBackground(new java.awt.Color(147, 140, 180));
        jLabel16.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(103, 96, 184));
        jLabel16.setText("Buy Crop");
        jLabel16.setFocusable(false);
        jLabel16.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLayeredPane12.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 140, 30));

        jLabel17.setBackground(new java.awt.Color(147, 140, 180));
        jLabel17.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(103, 96, 184));
        jLabel17.setText("Total Amount");
        jLabel17.setFocusable(false);
        jLabel17.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLayeredPane12.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 140, 30));

        jButton11.setBackground(new java.awt.Color(255, 102, 102));
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Calculate");
        jButton11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 102, 255), 1, true));
        jButton11.setFocusable(false);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jLayeredPane12.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 80, 30));

        jLayeredPane1.add(jLayeredPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 450, 480));

        jLayeredPane9.setOpaque(true);
        jLayeredPane9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane10.setBackground(new java.awt.Color(255, 239, 153));
        jLayeredPane10.setForeground(new java.awt.Color(255, 239, 153));
        jLayeredPane10.setOpaque(true);

        javax.swing.GroupLayout jLayeredPane10Layout = new javax.swing.GroupLayout(jLayeredPane10);
        jLayeredPane10.setLayout(jLayeredPane10Layout);
        jLayeredPane10Layout.setHorizontalGroup(
            jLayeredPane10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        jLayeredPane10Layout.setVerticalGroup(
            jLayeredPane10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jLayeredPane9.add(jLayeredPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 40));

        jLayeredPane11.setBackground(new java.awt.Color(255, 239, 153));
        jLayeredPane11.setForeground(new java.awt.Color(255, 239, 153));
        jLayeredPane11.setOpaque(true);

        javax.swing.GroupLayout jLayeredPane11Layout = new javax.swing.GroupLayout(jLayeredPane11);
        jLayeredPane11.setLayout(jLayeredPane11Layout);
        jLayeredPane11Layout.setHorizontalGroup(
            jLayeredPane11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        jLayeredPane11Layout.setVerticalGroup(
            jLayeredPane11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jLayeredPane9.add(jLayeredPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 450, 40));

        jLabel14.setBackground(new java.awt.Color(147, 140, 180));
        jLabel14.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(103, 96, 184));
        jLabel14.setText("Add Crops");
        jLabel14.setFocusable(false);
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLayeredPane9.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 140, 30));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(147, 140, 228)));

        jTextField4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(116, 116, 116));
        jTextField4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jTextField4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField4FocusGained(evt);
            }
        });
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLayeredPane9.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, -1, 40));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Name Of The Crop");
        jLabel3.setFocusable(false);
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLayeredPane9.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 110, 20));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Quantity ");
        jLabel4.setFocusable(false);
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLayeredPane9.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 110, 20));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(147, 140, 228)));

        jTextField5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(116, 116, 116));
        jTextField5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jTextField5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField5FocusGained(evt);
            }
        });
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLayeredPane9.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, -1, 40));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Selling Price ");
        jLabel5.setFocusable(false);
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLayeredPane9.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 110, 20));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(147, 140, 228)));

        jTextField6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(116, 116, 116));
        jTextField6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jTextField6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField6FocusGained(evt);
            }
        });
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLayeredPane9.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, -1, 40));

        jButton3.setBackground(new java.awt.Color(147, 140, 228));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Add Crop");
        jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 102, 255), 1, true));
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jLayeredPane9.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 80, 30));

        errorLAbel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        errorLAbel.setForeground(new java.awt.Color(255, 19, 32));
        errorLAbel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorLAbel.setText("Error Message");
        errorLAbel.setFocusable(false);
        errorLAbel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLayeredPane9.add(errorLAbel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 250, 20));

        jLayeredPane1.add(jLayeredPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 450, 480));

        jLayeredPane6.setOpaque(true);
        jLayeredPane6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane7.setBackground(new java.awt.Color(255, 239, 153));
        jLayeredPane7.setForeground(new java.awt.Color(255, 239, 153));
        jLayeredPane7.setOpaque(true);

        javax.swing.GroupLayout jLayeredPane7Layout = new javax.swing.GroupLayout(jLayeredPane7);
        jLayeredPane7.setLayout(jLayeredPane7Layout);
        jLayeredPane7Layout.setHorizontalGroup(
            jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        jLayeredPane7Layout.setVerticalGroup(
            jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jLayeredPane6.add(jLayeredPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 40));

        jLayeredPane8.setBackground(new java.awt.Color(255, 239, 153));
        jLayeredPane8.setForeground(new java.awt.Color(255, 239, 153));
        jLayeredPane8.setOpaque(true);

        javax.swing.GroupLayout jLayeredPane8Layout = new javax.swing.GroupLayout(jLayeredPane8);
        jLayeredPane8.setLayout(jLayeredPane8Layout);
        jLayeredPane8Layout.setHorizontalGroup(
            jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        jLayeredPane8Layout.setVerticalGroup(
            jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jLayeredPane6.add(jLayeredPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 450, 40));

        jLabel10.setBackground(new java.awt.Color(147, 140, 180));
        jLabel10.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(103, 96, 184));
        jLabel10.setText("Crops that Can be Cultivated On this soil");
        jLabel10.setFocusable(false);
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLayeredPane6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 300, 30));

        jTextArea2.setEditable(false);
        jTextArea2.setBackground(new java.awt.Color(245, 245, 245));
        jTextArea2.setColumns(20);
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setText("Crop A\nCrop B\nCrop A\nCrop B\nCrop A\nCrop B\nCrop A\nCrop B\nCrop A\nCrop B");
        jTextArea2.setBorder(null);
        jTextArea2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea2.setEnabled(false);
        jTextArea2.setFocusable(false);
        jTextArea2.setOpaque(false);
        jScrollPane2.setViewportView(jTextArea2);

        jLayeredPane6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 290, 180));

        jLabel13.setBackground(new java.awt.Color(147, 140, 180));
        jLabel13.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(103, 96, 184));
        jLabel13.setText("Other Important Details:");
        jLabel13.setFocusable(false);
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLayeredPane6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 300, 30));

        jTextArea3.setEditable(false);
        jTextArea3.setBackground(new java.awt.Color(245, 245, 245));
        jTextArea3.setColumns(20);
        jTextArea3.setLineWrap(true);
        jTextArea3.setRows(5);
        jTextArea3.setText("Irrigation Details: :\n\nFertiliser Details: \n");
        jTextArea3.setBorder(null);
        jTextArea3.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea3.setEnabled(false);
        jTextArea3.setFocusable(false);
        jTextArea3.setOpaque(false);
        jScrollPane3.setViewportView(jTextArea3);

        jLayeredPane6.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 290, 90));

        jLayeredPane1.add(jLayeredPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 450, 480));

        jLayeredPane3.setOpaque(true);
        jLayeredPane3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane4.setBackground(new java.awt.Color(255, 239, 153));
        jLayeredPane4.setForeground(new java.awt.Color(255, 239, 153));
        jLayeredPane4.setOpaque(true);

        javax.swing.GroupLayout jLayeredPane4Layout = new javax.swing.GroupLayout(jLayeredPane4);
        jLayeredPane4.setLayout(jLayeredPane4Layout);
        jLayeredPane4Layout.setHorizontalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        jLayeredPane4Layout.setVerticalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jLayeredPane3.add(jLayeredPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 40));
        jLayeredPane4.getAccessibleContext().setAccessibleName("");

        jLayeredPane5.setBackground(new java.awt.Color(255, 239, 153));
        jLayeredPane5.setForeground(new java.awt.Color(255, 239, 153));
        jLayeredPane5.setOpaque(true);

        javax.swing.GroupLayout jLayeredPane5Layout = new javax.swing.GroupLayout(jLayeredPane5);
        jLayeredPane5.setLayout(jLayeredPane5Layout);
        jLayeredPane5Layout.setHorizontalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        jLayeredPane5Layout.setVerticalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jLayeredPane3.add(jLayeredPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 450, 40));

        labelSoilType.setBackground(new java.awt.Color(147, 140, 180));
        labelSoilType.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        labelSoilType.setForeground(new java.awt.Color(237, 58, 101));
        labelSoilType.setText("X Soil");
        labelSoilType.setFocusable(false);
        labelSoilType.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLayeredPane3.add(labelSoilType, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 305, 250, -1));

        imageLabel.setBackground(new java.awt.Color(217, 217, 217));
        imageLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        imageLabel.setOpaque(true);
        jLayeredPane3.add(imageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 370, 180));

        jLabel9.setBackground(new java.awt.Color(147, 140, 180));
        jLabel9.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(103, 96, 184));
        jLabel9.setText("Upload Your Soil Image Here:");
        jLabel9.setFocusable(false);
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLayeredPane3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 240, 30));

        jLabel11.setBackground(new java.awt.Color(147, 140, 180));
        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(5, 0, 65));
        jLabel11.setText("Your Soil Type Is:");
        jLabel11.setFocusable(false);
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLayeredPane3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 302, 130, 20));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(245, 245, 245));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("trud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitationUt enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea coo ");
        jTextArea1.setBorder(null);
        jTextArea1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea1.setOpaque(false);
        jScrollPane1.setViewportView(jTextArea1);

        jLayeredPane3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 380, 90));

        jButton5.setBackground(new java.awt.Color(147, 140, 228));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Upload");
        jButton5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 102, 255), 1, true));
        jButton5.setFocusable(false);
        jButton5.setNextFocusableComponent(jButton2);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jLayeredPane3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 80, 30));

        jLayeredPane1.add(jLayeredPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 450, 480));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );

        getAccessibleContext().setAccessibleParent(this);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jLayeredPane9.setVisible(true);
        jLayeredPane6.setVisible(false);
        jLayeredPane3.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
         jLayeredPane9.setVisible(false);
         jLayeredPane6.setVisible(false);
         jLayeredPane3.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
            // TODO add your handling code here:
            jLayeredPane9.setVisible(false);
            jLayeredPane6.setVisible(true);
            jLayeredPane3.setVisible(false);
            
            if("Sandy Soil".equals(Soil)){
                jTextArea2.setText("""
                                       Crops Suitable for Sandy Soil:
                                       Potatoes 
                                       Carrots 
                                       Radishes""");

                jTextArea3.setText("""
                                       Crop Irrigation:   - Sandy soils drain quickly, so frequent irrigation may be necessary. Use drip irrigation or soaker hoses to ensure deep watering.

                                       Fertilizer :    - Use fertilizers with balanced nutrients, including nitrogen, phosphorus, and potassium.
                                          - Consider using organic matter like compost to improve soil fertility.""");
            } else if("Clayey Soil".equals(Soil)){
                jTextArea2.setText("""
                                       Crops Suitable for Clayey Soil:
                                       Wheat 
                                       Barley 
                                       Beans""");

                jTextArea3.setText("""
                                       Crop Irrigation:   - Clayey soils retain water well, so moderate irrigation is usually sufficient. Be cautious of overwatering.

                                       Fertilizer :    - Use fertilizers with higher phosphorus content to promote root development.
                                          - Incorporate organic matter like well-rotted manure to improve soil structure.""");
            } else if("Laterite Soil".equals(Soil)){
                jTextArea2.setText("""
                                       Crops Suitable for Laterite Soil:
                                       Cashew 
                                       Tea 
                                       Coffee""");

                jTextArea3.setText("""
                                       Crop Irrigation:   - Laterite soils have low water retention, so regular and controlled irrigation is essential.

                                       Fertilizer :    - Use fertilizers rich in potassium and phosphorus.
                                          - Apply organic mulch to retain soil moisture and improve fertility.""");
            } else if("Limestone Soil".equals(Soil)){
                jTextArea2.setText("""
                                       Crops Suitable for Limestone Soil:
                                       Lettuce 
                                       Cabbage 
                                       Broccoli""");

                jTextArea3.setText("""
                                       Crop Irrigation:   - Limestone soils may have good drainage; however, consistent watering is important to prevent drought stress.

                                       Fertilizer :    - Limestone soils may benefit from added calcium. Consider using lime to adjust pH if necessary.""");
            } else if("Red Soil".equals(Soil)){
                jTextArea2.setText("""
                                       Crops Suitable for Red Soil:
                                       Tomatoes 
                                       Peppers 
                                       Groundnuts""");

                jTextArea3.setText("""
                                       Crop Irrigation:   - Red soils drain well, so irrigation should be regular but not excessive.

                                       Fertilizer :    - Red soils are often rich in iron and aluminum. Supplement with fertilizers containing phosphorus and nitrogen.""");
            } else if("Black Soil".equals(Soil)){
                jTextArea2.setText("""
                                       Crops Suitable for Black Soil:
                                       Cotton 
                                       Soybeans 
                                       Chickpeas""");

                jTextArea3.setText("""
                                       Crop Irrigation:   - Black soils have good water retention, so irrigation should be moderate.

                                       Fertilizer :    - Use fertilizers with a balanced mix of nutrients. Organic matter like well-rotted manure can improve soil structure.""");
            } else if("Alluvial Soil".equals(Soil)){
                jTextArea2.setText("""
                                       Crops Suitable for Alluvial Soil:
                                       Rice 
                                       Wheat 
                                       Sugarcane""");

                jTextArea3.setText("""
                                       Crop Irrigation:   - Alluvial soils are generally well-draining. Regular irrigation is important, especially for water-intensive crops.

                                       Fertilizer :    - Use a balanced fertilizer with nitrogen, phosphorus, and potassium. Supplement with organic matter for improved fertility.""");
            } else {
                // Handle the case when the soil type is not recognized
                jTextArea2.setText("No information available for the specified soil type.");
                jTextArea3.setText("");
            }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    public void setLabelImage(){
         JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif");
            fileChooser.setFileFilter(filter);
            int returnVal = fileChooser.showOpenDialog(jLayeredPane3);
                
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try {
                        BufferedImage image = ImageIO.read(file);

                        int pixelX = image.getWidth() / 2;
                        int pixelY = image.getHeight() / 2;
                        Color pixelColor = new Color(image.getRGB(pixelX, pixelY));
                        int red = pixelColor.getRed();
                        int green = pixelColor.getGreen();
                        int blue = pixelColor.getBlue();

                        // 
                        Soil = detectSoilType(red, green, blue);

                        File sFile = new File("Soiltype.txt");
                        
                        labelSoilType.setText(Soil+":"+red+":"+green+":"+blue);
                        imageLabel.setIcon(new ImageIcon(image));
                        revalidate();
                        repaint();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    ImageIcon imageIcon = new ImageIcon(file.getPath());
                    Image image = imageIcon.getImage();

            Image scaledImage = image.getScaledInstance(imageLabel.getWidth(),imageLabel.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            // Set the scaled image as the label's icon
            imageLabel.setIcon(scaledIcon);
            }
    }
    
    public String detectSoilType(int red, int green, int blue) {
        
       String[] soilTypes = {
           "Alluvial Soil",
                "Sandy Soil",
                "Clayey Soil",
                "Laterite Soil",
                "Limestone Soil",
                "Red Soil",
                "Black Soil"
                
        };
          int[][] rgbLimits = {
              {150,160,100,120,70,100},
                {170, 190, 100, 150, 50, 90},
                {100, 200, 110, 130, 90, 100},            
                {139, 200, 100, 150, 50, 100},
                {200, 255, 180, 205, 140, 200},
                {150,255,0,100,0,100},
                {0,100,0,100,0,100}
                
        };

        for (int i = 0; i < soilTypes.length; i++) {
            if (red >= rgbLimits[i][0] && red <= rgbLimits[i][1] &&
                    green >= rgbLimits[i][2] && green <= rgbLimits[i][3] &&
                    blue >= rgbLimits[i][4] && blue <= rgbLimits[i][5]) {
                Soil=soilTypes[i];
                return Soil;
            }
        }
        return "Unknown";
    }
    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
           setLabelImage();
           switch (Soil){
               case "Sandy Soil":
           jTextArea1.setText("Composition: Sandy soil is predominantly composed of loose, coarse sand particles.\n" +
"Formation: Formed by the weathering and breakdown of rocks, with sand being the predominant result.\n" +
"Characteristics: Well-draining due to large particle size, but may have low nutrient retention");
           break;
           
               case "Alluvial Soil":
                    jTextArea1.setText("Composition: Alluvial soil consists of loose clay, silt, sand, or gravel deposited by running water.\n" +
"Formation: Deposited in stream beds, floodplains, alluvial fans, beaches, or similar settings.\n" +
"Characteristics: Fertile due to the deposition of nutrients, good water retention, suitable for a wide range of crops.");
                    break;
                    
               case "Red Soil":
                jTextArea1.setText("Composition: Red soil gets its color from iron oxides and is typically sandy or loamy.\n" +
"Formation: Forms in warm, tropical regions with a high concentration of iron-rich minerals.\n" +
"Characteristics: Moderately well-draining, fertile, but may require phosphorus supplementation");
                break;
                
                 case "Black Soil":
                jTextArea1.setText("Composition: Black soil is rich in clay and has a high swelling and shrinking capacity.\n" +
"Formation: Forms through the weathering of basaltic rocks, leading to the development of clay-rich soil.\n" +
"Characteristics: Moderate to poor drainage, high fertility, cracking during dry periods");
                break;
                
                 case "Limestone Soil":
                jTextArea1.setText("Composition: Limestone soil is derived from limestone rock and may contain calcium carbonate.\n" +
"Formation: Develops in areas with limestone bedrock, with soil forming from weathered rock.\n" +
"Characteristics: Well-draining, may require calcium-based fertilizers.");
                break;
                
                 case "Laterite Soil":
                jTextArea1.setText("Composition: Laterite soil is rich in iron and aluminum oxides.\n" +
"Formation: Develops in tropical regions through the leaching of silica and other minerals.\n" +
"Characteristics: Varied drainage characteristics, nutrient deficiencies are common");
                break;
                
                 case "Clayey Soil":
                jTextArea1.setText("Composition: Clayey soil consists of fine, compacted clay particles.\n" +
"Formation: Formed by the weathering of rocks and the subsequent compaction of fine particles.\n" +
"Characteristics: Poor drainage due to small particle size, high nutrient retention");
                break;
                
                 default:
                     jTextArea1.setText("unknow soil detected");
                   
           }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField4FocusGained
        

    }//GEN-LAST:event_jTextField4FocusGained

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField5FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5FocusGained

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField6FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6FocusGained

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
            try{
                String CropName = jTextField4.getText();
                Double Qty = Double.valueOf(jTextField5.getText());
                Double SP = Double.valueOf(jTextField6.getText());
                add_crop(CropName,SP,Qty);
                jTextField4.setText(null);
                jTextField5.setText(null);
                jTextField6.setText(null);
                errorLAbel.setText("Transaction Successfull");
                errorLAbel.setVisible(true);
            }catch(Exception e){
                errorLAbel.setText("Invalid Selling Price or Qunatity");
                errorLAbel.setVisible(true);
            }
            
            
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField8FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8FocusGained

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField9FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField9FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9FocusGained

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
        try{
        Double Quantity = Double.valueOf(jTextField8.getText());
        Double Price = Double.valueOf(jTextField9.getText());
        Double Amount = Quantity * Price;
        jLabel15.setText(Amount.toString());}catch(Exception e){
            errorLAbel1.setText("Invalid Quantity");
            errorLAbel1.setVisible(true);
        }
    }//GEN-LAST:event_jTextField9ActionPerformed
    
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Double Qty = get_qunatity_available(jComboBox1.getSelectedItem().toString());
        Double Qty_entered = Double.valueOf(jTextField9.getText());
        if(Qty_entered <Qty){
            update_quantity(jComboBox1.getSelectedItem().toString(),Qty-Qty_entered);
            jTextField9.setText(null);
            jComboBox1.setSelectedIndex(1);
            errorLAbel1.setText("Transaction Successfull");
            errorLAbel1.setVisible(true);
        }else{
            errorLAbel1.setText("Insufficient Quantity");
            errorLAbel1.setVisible(true);
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        get_crop_price(jComboBox1.getSelectedItem().toString());
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jLabel15InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jLabel15InputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel15InputMethodTextChanged

    private void jTextField9InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextField9InputMethodTextChanged
        // TODO add your handling code here:
         try{
        Double Quantity = Double.valueOf(jTextField8.getText());
        Double Price = Double.valueOf(jTextField9.getText());
        Double Amount = Quantity * Price;
        jLabel15.setText(Amount.toString());}catch(Exception e){
            errorLAbel1.setText("Invalid Quantity");
            errorLAbel1.setVisible(true);
        }
    }//GEN-LAST:event_jTextField9InputMethodTextChanged

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
         try{
        Double Quantity = Double.valueOf(jTextField8.getText());
        Double Price = Double.valueOf(jTextField9.getText());
        Double Amount = Quantity * Price;
        jLabel15.setText(Amount.toString());}catch(Exception e){
            errorLAbel1.setText("Invalid Quantity");
            errorLAbel1.setVisible(true);
        }
    }//GEN-LAST:event_jButton11ActionPerformed
    
   @Override
   public void actionPerformed(ActionEvent e) {
            String phoneNumber = "tel:18001801551";
            String farmerPortal = "https://www.farmer.gov.in/";
            String progandSchemes = "https://agricoop.gov.in/en/FarmWelfare";
            String To_Be_Executed = "";

            if(e.getSource()== jButton10){
                To_Be_Executed = phoneNumber;
            }else if(e.getSource() == jButton9){
                To_Be_Executed = farmerPortal;
            }else if(e.getSource() == jButton8){
                To_Be_Executed = progandSchemes;
            }else if(e.getSource() == jLabel2){
                 To_Be_Executed = "https://instagram.com/nshetty07";
            }   

            try {
                Desktop.getDesktop().browse(new URI(To_Be_Executed));
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(jLayeredPane3, "Unable to initiate request to third party browser because: "+ ex.getMessage());
            }
   }
   
    public static void main(String args[]) {
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errorLAbel;
    private javax.swing.JLabel errorLAbel1;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane10;
    private javax.swing.JLayeredPane jLayeredPane11;
    private javax.swing.JLayeredPane jLayeredPane12;
    private javax.swing.JLayeredPane jLayeredPane13;
    private javax.swing.JLayeredPane jLayeredPane14;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JLayeredPane jLayeredPane6;
    private javax.swing.JLayeredPane jLayeredPane7;
    private javax.swing.JLayeredPane jLayeredPane8;
    private javax.swing.JLayeredPane jLayeredPane9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel labelSoilType;
    // End of variables declaration//GEN-END:variables
}
