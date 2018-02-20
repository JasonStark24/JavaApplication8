




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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;




/**
 *
 * @author calope
 */
public class HOSPITAL_Billing_System extends javax.swing.JFrame {

    Double num1, num2, calculating,num3, num4;
    int money;
    
    Connection conn;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    int count;
    ResultSet rs;
    
    
    
    
    public HOSPITAL_Billing_System() {
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
    String jk = aUsername.getText();
    
        sql = "SELECT Balance FROM PatientRecords WHERE Patient_ID ='"+jk+"'";
        
        rs = stmt.executeQuery(sql);
        
        if(rs.next())
        {
            JOptionPane.showMessageDialog(rootPane, "Record Found!");
            
            String tot = rs.getString("Balance");         
            aAge.setText(tot);
            
            
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
    String bl = balance.getText();
    String bm = aAge.getText();
    String bn = aUsername.getText();
    
        sql = "UPDATE PatientRecordS SET Balance ='"+bl+"'"
                + "WHERE Balance ='"+bm+"' AND Patient_ID ='"+bn+"'";
                
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
   
  
    private void lookUp()
    {
        
        connectDB();
        
        String ID;
        String sql = "SELECT Patient_ID, Name, Date_register, Balance FROM PatientRecords";
        
        
        
        
        
        try{
         pstmt = conn.prepareStatement(sql);
         rs = pstmt.executeQuery();
         jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            }
        catch(SQLException E)
        {
            JOptionPane.showMessageDialog(null, E);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        aAge = new javax.swing.JTextField();
        jButton4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JLabel();
        OK = new javax.swing.JLabel();
        jButton2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JLabel();
        aUsername = new javax.swing.JTextField();
        AmountR = new javax.swing.JTextField();
        change = new javax.swing.JTextField();
        balance = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextField1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1009, 640));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Patient_ID", "Name", "Age",  "Gender", "Total"
            }
        )
        {public boolean isCellEditable(int row, int column){return false;}}
    );
    jScrollPane1.setViewportView(jTable1);

    getContentPane().add(jScrollPane1);
    jScrollPane1.setBounds(20, 280, 540, 210);

    aAge.setEditable(false);
    aAge.setBackground(new java.awt.Color(51, 51, 51));
    aAge.setFont(new java.awt.Font("Myriad Pro", 1, 18)); // NOI18N
    aAge.setForeground(new java.awt.Color(255, 255, 255));
    aAge.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    aAge.setBorder(null);
    aAge.setCaretColor(new java.awt.Color(255, 255, 255));
    aAge.setDisabledTextColor(new java.awt.Color(255, 255, 255));
    aAge.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            aAgeActionPerformed(evt);
        }
    });
    getContentPane().add(aAge);
    aAge.setBounds(250, 65, 127, 22);

    jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add-user2-512.png"))); // NOI18N
    jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jButton4MouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jButton4MouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jButton4MouseExited(evt);
        }
        public void mousePressed(java.awt.event.MouseEvent evt) {
            jButton4MousePressed(evt);
        }
        public void mouseReleased(java.awt.event.MouseEvent evt) {
            jButton4MouseReleased(evt);
        }
    });
    getContentPane().add(jButton4);
    jButton4.setBounds(940, 90, 30, 30);

    jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/power-symbol.png"))); // NOI18N
    jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jButton3MouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jButton3MouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jButton3MouseExited(evt);
        }
        public void mousePressed(java.awt.event.MouseEvent evt) {
            jButton3MousePressed(evt);
        }
        public void mouseReleased(java.awt.event.MouseEvent evt) {
            jButton3MouseReleased(evt);
        }
    });
    getContentPane().add(jButton3);
    jButton3.setBounds(930, 30, 50, 50);

    jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh.png"))); // NOI18N
    jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jButton5MouseClicked(evt);
        }
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            jButton5MouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            jButton5MouseExited(evt);
        }
        public void mousePressed(java.awt.event.MouseEvent evt) {
            jButton5MousePressed(evt);
        }
        public void mouseReleased(java.awt.event.MouseEvent evt) {
            jButton5MouseReleased(evt);
        }
    });
    getContentPane().add(jButton5);
    jButton5.setBounds(940, 140, 30, 30);

    OK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication8/checkbut.png"))); // NOI18N
    OK.setToolTipText("CHECKOUT");
    OK.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent evt) {
            OKMousePressed(evt);
        }
    });
    getContentPane().add(OK);
    OK.setBounds(407, 197, 130, 46);

    jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication8/buttoncalc.png"))); // NOI18N
    jButton2.setToolTipText("CALCULATE");
    jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent evt) {
            jButton2MousePressed(evt);
        }
    });
    getContentPane().add(jButton2);
    jButton2.setBounds(410, 90, 100, 30);

    jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication8/button.png"))); // NOI18N
    jButton1.setToolTipText("SEARCH");
    jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent evt) {
            jButton1MousePressed(evt);
        }
    });
    getContentPane().add(jButton1);
    jButton1.setBounds(410, 30, 100, 30);

    aUsername.setBackground(new java.awt.Color(51, 51, 51));
    aUsername.setFont(new java.awt.Font("Myriad Pro", 1, 18)); // NOI18N
    aUsername.setForeground(new java.awt.Color(255, 255, 255));
    aUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    aUsername.setAlignmentX(0.3F);
    aUsername.setAlignmentY(0.3F);
    aUsername.setBorder(null);
    aUsername.setCaretColor(new java.awt.Color(255, 255, 255));
    aUsername.setDisabledTextColor(new java.awt.Color(255, 255, 255));
    aUsername.setMargin(new java.awt.Insets(0, 0, 0, 0));
    getContentPane().add(aUsername);
    aUsername.setBounds(250, 35, 125, 20);

    AmountR.setBackground(new java.awt.Color(51, 51, 51));
    AmountR.setFont(new java.awt.Font("Myriad Pro", 1, 18)); // NOI18N
    AmountR.setForeground(new java.awt.Color(255, 255, 255));
    AmountR.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    AmountR.setBorder(null);
    AmountR.setCaretColor(new java.awt.Color(255, 255, 255));
    AmountR.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            AmountRActionPerformed(evt);
        }
    });
    getContentPane().add(AmountR);
    AmountR.setBounds(250, 95, 127, 22);

    change.setEditable(false);
    change.setBackground(new java.awt.Color(51, 51, 51));
    change.setFont(new java.awt.Font("Myriad Pro", 1, 18)); // NOI18N
    change.setForeground(new java.awt.Color(255, 255, 255));
    change.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    change.setBorder(null);
    change.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            changeActionPerformed(evt);
        }
    });
    getContentPane().add(change);
    change.setBounds(250, 125, 127, 22);

    balance.setEditable(false);
    balance.setBackground(new java.awt.Color(51, 51, 51));
    balance.setFont(new java.awt.Font("Myriad Pro", 1, 36)); // NOI18N
    balance.setForeground(new java.awt.Color(255, 255, 255));
    balance.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    balance.setBorder(null);
    getContentPane().add(balance);
    balance.setBounds(250, 200, 130, 50);

    jTextField1.setEditable(false);
    jTextField1.setBackground(new java.awt.Color(51, 51, 51));
    jTextField1.setColumns(20);
    jTextField1.setForeground(new java.awt.Color(255, 255, 255));
    jTextField1.setRows(5);
    jTextField1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(51, 51, 51), new java.awt.Color(51, 51, 51), new java.awt.Color(51, 51, 51), new java.awt.Color(51, 51, 51)));
    jScrollPane2.setViewportView(jTextField1);

    getContentPane().add(jScrollPane2);
    jScrollPane2.setBounds(590, 30, 330, 560);

    jLabel1.setBackground(new java.awt.Color(102, 102, 255));
    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication8/newBG.jpg"))); // NOI18N
    jLabel1.setAlignmentY(0.0F);
    getContentPane().add(jLabel1);
    jLabel1.setBounds(0, -90, 1000, 800);

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       lookUp(); // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void AmountRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AmountRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AmountRActionPerformed

    private void changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_changeActionPerformed

    private void aAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aAgeActionPerformed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
search(); 
          
          AmountR.setText("");
          change.setText("");
          balance.setText("");
    }//GEN-LAST:event_jButton1MousePressed

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
 
        
        
        
        
        
        if (AmountR.getText().length() != 0) {
            
            try {
                num1 = Double.parseDouble(AmountR.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, " Amount Receive should be a valid number");
                
                if (change == null) {
                    OK.setVisible(true);
                    
                }
                
                aUsername.setText("");
              aAge.setText("");
              change.setText("");
              balance.setText("");
                AmountR.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Amount Receive should not be empty!");
        }
        
        
        
        
        
        
        
        
        if (aAge.getText().length() != 0) {
            
            try {
                num2 = Double.parseDouble(aAge.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, " Total Charge should be a valid number");
                
                if (change == null) {
                    OK.setVisible(true);
                    
                }
                
                
            }
        } else {
            JOptionPane.showMessageDialog(this, "Total Charge should not be empty!");
        }
        

        


        
        
        
        
        calculating=(num1-num2);
        
         if (calculating>0){
            
             change.setText(Double.toString(calculating));
        } else {
            change.setText("00");
        }


        num3=(num2-num1);
        
        if (num3>0){
            
             balance.setText(Double.toString(num3));
        } else {
            balance.setText("00");
        }
        
        
    }//GEN-LAST:event_jButton2MousePressed

    private void OKMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OKMousePressed

          if (balance.getText().equals("")){
              String entervalue = jTextField1.getText() +"\n ------------------------------------------------------------------------\n "+" ERROR"+"\n ------------------------------------------------------------------------\n";
jTextField1.setText(entervalue+"\n");
          }else{
   
              
              
             
              send();
 
              
              String entervalue = jTextField1.getText() +"\n ------------------------------------------------------------------------\n Patient Id:\t\t\t"+ aUsername.getText()+"\n Patient Balance:\t\t"+balance.getText()+"\n Amount Received:\t\t"+AmountR.getText()+"\n Change:\t\t\t"+change.getText()+"\n ------------------------------------------------------------------------\n";
jTextField1.setText(entervalue+"\n");
          }
    }//GEN-LAST:event_OKMousePressed

    private void jButton4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MousePressed
ImageIcon II = new ImageIcon(getClass().getResource("/img/add-user3.png"));
     jButton4.setIcon(II); 
        this.dispose(); 
        
          Login s = new Login();
     s.setVisible(true);
           

    }//GEN-LAST:event_jButton4MousePressed

    private void jButton5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MousePressed
        
        
          HOSPITAL_Billing_System s = new HOSPITAL_Billing_System();
     s.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_jButton5MousePressed

    private void jButton3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MousePressed
 ImageIcon II = new ImageIcon(getClass().getResource("/img/power-symbol2.png"));
     jButton3.setIcon(II); 
        
        
            int p = JOptionPane.showConfirmDialog(rootPane, "Do you want to close the Program?", "CONFIRM EXIT",JOptionPane.YES_NO_OPTION); 
        if(p==0){
            
                    System.exit(0);
                }
       
        
    }//GEN-LAST:event_jButton3MousePressed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
 ImageIcon II = new ImageIcon(getClass().getResource("/img/power-symbol2.png"));
     jButton3.setIcon(II);
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
       ImageIcon II = new ImageIcon(getClass().getResource("/img/power-symbol2.png"));
     jButton3.setIcon(II);
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
 ImageIcon II = new ImageIcon(getClass().getResource("/img/power-symbol.png"));
     jButton3.setIcon(II);
    }//GEN-LAST:event_jButton3MouseExited

    private void jButton3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseReleased
 ImageIcon II = new ImageIcon(getClass().getResource("/img/power-symbol.png"));
     jButton3.setIcon(II);
    }//GEN-LAST:event_jButton3MouseReleased

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
 ImageIcon II = new ImageIcon(getClass().getResource("/img/refresh2.png"));
     jButton5.setIcon(II);
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
ImageIcon II = new ImageIcon(getClass().getResource("/img/refresh2.png"));
     jButton5.setIcon(II);
    }//GEN-LAST:event_jButton5MouseEntered

    private void jButton5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseExited
 ImageIcon II = new ImageIcon(getClass().getResource("/img/refresh.png"));
     jButton5.setIcon(II);
    }//GEN-LAST:event_jButton5MouseExited

    private void jButton5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseReleased
ImageIcon II = new ImageIcon(getClass().getResource("/img/refresh.png"));
     jButton5.setIcon(II);
    }//GEN-LAST:event_jButton5MouseReleased

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
ImageIcon II = new ImageIcon(getClass().getResource("/img/add-user3.png"));
     jButton4.setIcon(II);
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
ImageIcon II = new ImageIcon(getClass().getResource("/img/add-user3.png"));
     jButton4.setIcon(II);
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
ImageIcon II = new ImageIcon(getClass().getResource("/img/add-user2-512.png"));
     jButton4.setIcon(II);
    }//GEN-LAST:event_jButton4MouseExited

    private void jButton4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseReleased
 ImageIcon II = new ImageIcon(getClass().getResource("/img/add-user2-512.png"));
     jButton4.setIcon(II);
    }//GEN-LAST:event_jButton4MouseReleased
                                 
  
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
            java.util.logging.Logger.getLogger(HOSPITAL_Billing_System.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HOSPITAL_Billing_System.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HOSPITAL_Billing_System.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HOSPITAL_Billing_System.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HOSPITAL_Billing_System().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AmountR;
    private javax.swing.JLabel OK;
    private javax.swing.JTextField aAge;
    private javax.swing.JTextField aUsername;
    private javax.swing.JTextField balance;
    private javax.swing.JTextField change;
    private javax.swing.JLabel jButton1;
    private javax.swing.JLabel jButton2;
    private javax.swing.JLabel jButton3;
    private javax.swing.JLabel jButton4;
    private javax.swing.JLabel jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextField1;
    // End of variables declaration//GEN-END:variables
}