/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author calope
 */
public class Charges extends javax.swing.JFrame {

       Double num0,num00,num1, num2,num3, num4,compute;
  String para; 
    
     Connection conn;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    int count;
    ResultSet rs;
    
    
    /**
     * Creates new form Charges
     */
    public Charges() {
        initComponents();
    }

    
     public void search()
{
    try{
    
    String filename = "PatientRecord.mdb";
    String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=";
    database += filename.trim() + ";DriverID=22;READONLY=false}";    
    conn = DriverManager.getConnection(database, "", "");
    System.out.println("DATABASE connection ESTABLSHED!");            
    stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            
    stmt = conn.createStatement();
    String sql;
    String jk = searchID.getText();
    
        sql = "SELECT Balance,Name,Laboratory_charge,Consulation_charge,Bed_charge,Drug_charge FROM PatientRecords WHERE Patient_ID ='"+jk+"'";
        
        rs = stmt.executeQuery(sql);
        
        if(rs.next())
        {
            JOptionPane.showMessageDialog(rootPane, "Record Found!");
            
            String tot =    rs.getString("Balance");         
            balance.setText(tot);
            
            String tname = rs.getString("Name");         
            name.setText(tname);
            
            String ulab = rs.getString("Laboratory_charge");         
            lab.setText(ulab);
            
            String ucon = rs.getString("Consulation_charge");         
            consulation.setText(ucon);
            
            String ubed = rs.getString("Bed_charge");         
            bed.setText(ubed);
            
            String udrug = rs.getString("Drug_charge");         
            drug.setText(udrug);
            
            
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "No Record Found!"+"\nPlease verify ID");
            
        }
          
    }
     catch(SQLException | HeadlessException E)
     {
         System.out.printf(E.toString());
     }
    
}

    
    
    
    public void connectDB() //Connect Java to Database
{
    try{
        String filename = "PatientRecord.mdb";
            String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=";
            database += filename.trim() + ";DriverID=22;READONLY=false}";
            conn = DriverManager.getConnection(database, "", "");
            System.out.println("DATABASE connection ESTABLSHED!");            
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        }
    catch(SQLException E)
    {
        System.out.println(E.toString());
    }
}
  
    
 
    public void send()
{
    try{
    
    String filename = "PatientRecord.mdb";
    String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=";
    database += filename.trim() + ";DriverID=22;READONLY=false}";    
    conn = DriverManager.getConnection(database, "", "");
    System.out.println("DATABASE connection ESTABLSHED!");            
    stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            
    stmt = conn.createStatement();
    String sql;
    String bl = update_lab.getText();
    String bm = lab.getText();
    String bn = name.getText();
    
        sql = "UPDATE PatientRecordS SET Laboratory_charge ='"+bl+"'"
                + "WHERE Laboratory_charge ='"+bm+"' AND Name ='"+bn+"'";
                
        rs = stmt.executeQuery(sql);
        
        if(rs.next())
        {
            JOptionPane.showMessageDialog(rootPane, "Record UPDATE!");
            
                     
           
            
            
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Record NOT UPDATE");
            
        }
          
    }
     catch(SQLException | HeadlessException E)
     {
         System.out.printf(E.toString());
     }
    
}

   
   
    
 
    public void send2()
{
    try{
    
    String filename = "PatientRecord.mdb";
    String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=";
    database += filename.trim() + ";DriverID=22;READONLY=false}";    
    conn = DriverManager.getConnection(database, "", "");
    System.out.println("DATABASE connection ESTABLSHED!");            
    stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            
    stmt = conn.createStatement();
    String sql;
    String bl = update_consulation.getText();
    String bm = consulation.getText();
    String bn = name.getText();
    
        sql = "UPDATE PatientRecordS SET Consulation_charge ='"+bl+"'"
                + "WHERE Consulation_charge ='"+bm+"' AND Name ='"+bn+"'";
                
        rs = stmt.executeQuery(sql);
        
        if(rs.next())
        {
            JOptionPane.showMessageDialog(rootPane, "Record UPDATE!");
            
                     
           
            
            
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Record NOT UPDATE");
            
        }
          
    }
     catch(SQLException | HeadlessException E)
     {
         System.out.printf(E.toString());
     }
    
}

     
    
 
    public void send3()
{
    try
    {
            String filename = "PatientRecord.mdb";
            String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=";
            database += filename.trim() + ";DriverID=22;READONLY=false}";
            conn = DriverManager.getConnection(database, "", "");
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            
            String sql = "Update PatientRecords Set Laboratory_charge = '"+update_lab.getText()+"', Consulation_charge = '"+update_consulation.getText()+"', Bed_charge = '"+update_bed.getText()+"', Drug_charge = '"+update_drug.getText()+"', Balance = '"+balance.getText()+"'WHERE Name = '"+name.getText()+"'";
            try
            {
                if(name.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(rootPane, "ERROR: Unable to Update!");
                }
                else{
                pstmt = conn.prepareStatement(sql);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, "Notice: Update Has Been Applied!");
             
                }
            }
            catch(Exception e)
            {
                System.out.println(e.toString());
            }
    }
    catch(Exception E)
    {
        System.out.printf(E.toString());
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

        searchID = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lab = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        consulation = new javax.swing.JTextField();
        bed = new javax.swing.JTextField();
        drug = new javax.swing.JTextField();
        balance = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        calculate = new javax.swing.JButton();
        Register = new javax.swing.JButton();
        update_drug = new javax.swing.JTextField();
        update_balance = new javax.swing.JTextField();
        update_lab = new javax.swing.JTextField();
        update_consulation = new javax.swing.JTextField();
        update_bed = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 500));
        getContentPane().setLayout(null);

        searchID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchIDActionPerformed(evt);
            }
        });
        getContentPane().add(searchID);
        searchID.setBounds(114, 11, 89, 25);

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(221, 12, 65, 23);
        getContentPane().add(lab);
        lab.setBounds(114, 78, 89, 25);
        getContentPane().add(name);
        name.setBounds(114, 42, 89, 25);
        getContentPane().add(consulation);
        consulation.setBounds(114, 121, 89, 25);
        getContentPane().add(bed);
        bed.setBounds(114, 164, 89, 25);
        getContentPane().add(drug);
        drug.setBounds(114, 200, 89, 25);
        getContentPane().add(balance);
        balance.setBounds(114, 274, 89, 25);

        jLabel1.setText("Patient ID");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 11, 100, 30);

        jLabel2.setText("Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 42, 100, 25);

        jLabel3.setText("Laboratory Charge");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 78, 100, 25);

        jLabel4.setText("Drug Charge");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 200, 100, 25);

        jLabel5.setText("Bed Charge");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 152, 100, 25);

        jLabel6.setText("Consultation Charge");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 121, 100, 25);

        jLabel8.setText("Balance");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(10, 274, 100, 25);

        calculate.setText("Calculate");
        calculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateActionPerformed(evt);
            }
        });
        getContentPane().add(calculate);
        calculate.setBounds(260, 240, 77, 23);

        Register.setText("Save");
        Register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterActionPerformed(evt);
            }
        });
        getContentPane().add(Register);
        Register.setBounds(280, 310, 57, 23);
        getContentPane().add(update_drug);
        update_drug.setBounds(230, 200, 89, 25);

        update_balance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_balanceActionPerformed(evt);
            }
        });
        getContentPane().add(update_balance);
        update_balance.setBounds(230, 280, 89, 25);
        getContentPane().add(update_lab);
        update_lab.setBounds(230, 80, 89, 25);
        getContentPane().add(update_consulation);
        update_consulation.setBounds(230, 120, 89, 25);
        getContentPane().add(update_bed);
        update_bed.setBounds(230, 170, 89, 25);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        search(); 
        
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void calculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateActionPerformed

        
        
           if (lab.getText().length() != 0) {
            
            try {
                num1 = Double.parseDouble(lab.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, " Laboratory Charge should be a valid number");
                
                if (balance == null) {
                    Register.setVisible(true);
                    
                }
                
                
                lab.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(this, " Laboratory Charge should not be empty!");
        }
        
        
        
       
        
        if (consulation.getText().length() != 0) {
            
            try {
                num2 = Double.parseDouble(consulation.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, " Amount Receive should be a valid number");
                
                if (balance == null) {
                    Register.setVisible(true);
                    
                }
                
                
                consulation.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Amount Receive should not be empty!");
        }
        
         
        
        if (bed.getText().length() != 0) {
            
            try {
                num3 = Double.parseDouble(bed.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, " Amount Receive should be a valid number");
                
                if (balance == null) {
                    Register.setVisible(true);
                    
                }
                
                
                bed.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Amount Receive should not be empty!");
        }
        
         
        
        if (drug.getText().length() != 0) {
            
            try {
                num4 = Double.parseDouble(drug.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, " Amount Receive should be a valid number");
                
                if (balance == null) {
                    Register.setVisible(true);
                    
                }
                
                
                drug.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Amount Receive should not be empty!");
        }
        
          
        
        compute=(num1+num2+num3+num4);
        balance.setText(Double.toString(compute));
        
        
        if (balance == null) {
            Register.setVisible(true);
            
        } else {
            Register.setVisible(true);
        }

        
        
        
    }//GEN-LAST:event_calculateActionPerformed

    private void RegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterActionPerformed
send3();


    }//GEN-LAST:event_RegisterActionPerformed

    private void update_balanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_balanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_update_balanceActionPerformed

    private void searchIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchIDActionPerformed

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
            java.util.logging.Logger.getLogger(Charges.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Charges.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Charges.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Charges.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Charges().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Register;
    private javax.swing.JTextField balance;
    private javax.swing.JTextField bed;
    private javax.swing.JButton calculate;
    private javax.swing.JTextField consulation;
    private javax.swing.JTextField drug;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField lab;
    private javax.swing.JTextField name;
    private javax.swing.JTextField searchID;
    private javax.swing.JTextField update_balance;
    private javax.swing.JTextField update_bed;
    private javax.swing.JTextField update_consulation;
    private javax.swing.JTextField update_drug;
    private javax.swing.JTextField update_lab;
    // End of variables declaration//GEN-END:variables
}
