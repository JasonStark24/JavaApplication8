/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

import java.awt.Component;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author calope
 */
public class AddPatient extends javax.swing.JFrame {
    
    Double num0,num00,num1, num2,num3, num4,compute,MONTH,monthz,uuage,u1,u2,u3,u4;
  String para;
    Connection conn;
    String Password = "";
    private Component rootPane;
    
    PreparedStatement pstmt = null;
    Statement stmt = null;
    int count;
    ResultSet rs; 
    private PreparedStatement pst;
    
    /**
     * Creates new form AddPatient
     */
      public String[] getdata = new String[2];
      
    public AddPatient() {
        initComponents();
       upDate.setVisible(false);
       
 charges.setVisible(false);
      reg.setVisible(false); 
      jLabel13.setVisible(false);
         jLabel15.setVisible(false);
      
    deletepanel.setVisible(false);
    addpatient.setVisible(false);
  
     
    
 
      
    }
 
    
    
    
    
    
      
   
    public void deletedrecord()
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
    String bl = did.getText();
   
    
        sql = "DELETE FROM PatientRecordS "
                + "WHERE Patient_ID ='"+bl+"'";
                
        rs = stmt.executeQuery(sql);
        
        if(rs.next())
        {
            JOptionPane.showMessageDialog(rootPane, "Record DELETE!");
            
                     
           
            did.setText("");
            
            dname.setText("");
            dage.setText("");
            dgender.setText("");
            
            
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Record NOT DELETE");
            
        }
          
    }
     catch(SQLException | HeadlessException E)
     {
         System.out.printf(E.toString());
     }
    
}

    
    
    
    
    
    
    
     public void searchcharges()
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
    String jm = updatepi.getText();
    
        sql = "SELECT Balance,Name,Laboratory_charge,Consulation_charge,Bed_charge,Drug_charge FROM PatientRecords WHERE Patient_ID ='"+jm+"'";
        
        rs = stmt.executeQuery(sql);
        
        if(rs.next())
        {
            JOptionPane.showMessageDialog(rootPane, "Record Found!");
            
            String tot =    rs.getString("Balance");         
            updatebalance.setText(tot);
            
            String tname = rs.getString("Name");         
            updatenam.setText(tname);
            
            String ulab = rs.getString("Laboratory_charge");         
            updatelab.setText(ulab);
            
            String ucon = rs.getString("Consulation_charge");         
            updatecon.setText(ucon);
            
            String ubed = rs.getString("Bed_charge");         
            updatebed.setText(ubed);
            
            String udrug = rs.getString("Drug_charge");         
            updatedrug.setText(udrug);
            
            
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

  
    
    
    
    
     
     
     
    
    
    
     public void deletesearch()
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
    String del = did.getText();
    
        sql = "SELECT Name,Age,Gender FROM PatientRecords WHERE Patient_ID ='"+del+"'";
        
        rs = stmt.executeQuery(sql);
        
        if(rs.next())
        {
            JOptionPane.showMessageDialog(rootPane, "Record Found!");
            
            String tot =    rs.getString("Name");         
            dname.setText(tot);
            
         
            
            String ulab = rs.getString("Age");         
            dage.setText(ulab);
            
            String ucon = rs.getString("Gender");         
            dgender.setText(ucon);
            
            
            
            
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "No Record Found!"+"\nPlease verify ID");
            
            
            did.setText("");
            
            dname.setText("");
            dage.setText("");
            dgender.setText("");
        }
          
    }
     catch(SQLException | HeadlessException E)
     {
         System.out.printf(E.toString());
     }
    
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
    String jk = Uid.getText();
    
        sql = "SELECT Name,Age,Gender FROM PatientRecords WHERE Patient_ID ='"+jk+"'";
        
        rs = stmt.executeQuery(sql);
        
        if(rs.next())
        {
            JOptionPane.showMessageDialog(rootPane, "Record Found!");
            
            String tot =    rs.getString("Name");         
            Uname.setText(tot);
            
         
            
            String ulab = rs.getString("Age");         
            Uage.setText(ulab);
            
            String ucon = rs.getString("Gender");         
            gender101.setText(ucon);
            
            
            
            
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

     
     
     
     
     
     
     
     
    public void UPDATEcharge()
{
    try
    {
            String filename = "PatientRecord.mdb";
            String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=";
            database += filename.trim() + ";DriverID=22;READONLY=false}";
            conn = DriverManager.getConnection(database, "", "");
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            
            String sql = "Update PatientRecords Set Laboratory_charge = '"+updatelab.getText()+"', Consulation_charge = '"+updatecon.getText()+"', Drug_charge = '"+updatedrug.getText()+"', Balance = '"+updatebalance.getText()+"', Bed_charge = '"+updatebed.getText()+"' WHERE Patient_ID = '"+updatepi.getText()+"'";
            try
            {
                if(updatenam.getText().equals("")&&updatepi.getText().equals("")&&updatelab.getText().equals("")&&updatecon.getText().equals("")&&updatebed.getText().equals("")&&updatedrug.getText().equals("")&&updatebalance.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(rootPane, "ERROR: Unable to Update!");
                }
                else{
                pstmt = conn.prepareStatement(sql);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, "Notice: Charges Has Been Applied!");
             
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
     
     
     
     
     
     
     
     
     
     
     
     
  
  
    public void UPDATEINFO()
{
    try
    {
            String filename = "PatientRecord.mdb";
            String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=";
            database += filename.trim() + ";DriverID=22;READONLY=false}";
            conn = DriverManager.getConnection(database, "", "");
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            
            String sql = "Update PatientRecords Set Name = '"+Uname.getText()+"', Age = '"+Uage.getText()+"', Gender = '"+gender101.getText()+"' WHERE Patient_ID = '"+Uid.getText()+"'";
            try
            {
                if(Uname.getText().equals(""))
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

        status = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        home = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        deletepanel = new javax.swing.JPanel();
        dsearch = new javax.swing.JLabel();
        did = new javax.swing.JTextField();
        dname = new javax.swing.JTextField();
        dage = new javax.swing.JTextField();
        dgender = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        deldeldel = new javax.swing.JLabel();
        addpatient = new javax.swing.JPanel();
        ID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        Age = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        date = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        gender = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        upDate = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        Uid = new javax.swing.JTextField();
        Uname = new javax.swing.JTextField();
        Uage = new javax.swing.JTextField();
        cgender = new javax.swing.JComboBox();
        gender101 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        charges = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        updatepi = new javax.swing.JTextField();
        updatenam = new javax.swing.JTextField();
        updatelab = new javax.swing.JTextField();
        updatecon = new javax.swing.JTextField();
        updatebed = new javax.swing.JTextField();
        updatedrug = new javax.swing.JTextField();
        updatebalance = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        reg = new javax.swing.JLabel();
        updatecalcu = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 479));
        setResizable(false);
        getContentPane().setLayout(null);

        status.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(status);
        status.setBounds(130, 60, 110, 20);

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/base2.png"))); // NOI18N
        jLabel33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel33MousePressed(evt);
            }
        });
        getContentPane().add(jLabel33);
        jLabel33.setBounds(0, 390, 200, 50);

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/charge.png"))); // NOI18N
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel19MousePressed(evt);
            }
        });
        getContentPane().add(jLabel19);
        jLabel19.setBounds(0, 240, 221, 80);

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel20MousePressed(evt);
            }
        });
        getContentPane().add(jLabel20);
        jLabel20.setBounds(0, 310, 221, 80);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/addp.png"))); // NOI18N
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel16MousePressed(evt);
            }
        });
        getContentPane().add(jLabel16);
        jLabel16.setBounds(0, 100, 221, 80);

        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/homelogo.png"))); // NOI18N
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                homeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                homeMouseReleased(evt);
            }
        });
        getContentPane().add(home);
        home.setBounds(10, 0, 110, 110);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/header.png"))); // NOI18N
        getContentPane().add(jLabel18);
        jLabel18.setBounds(0, 0, 300, 108);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/updatep.png"))); // NOI18N
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel17MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel17MouseReleased(evt);
            }
        });
        getContentPane().add(jLabel17);
        jLabel17.setBounds(0, 170, 221, 80);

        deletepanel.setOpaque(false);
        deletepanel.setLayout(null);

        dsearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search_button.png"))); // NOI18N
        dsearch.setToolTipText("SEARCH");
        dsearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dsearchMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dsearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dsearchMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dsearchMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                dsearchMouseReleased(evt);
            }
        });
        deletepanel.add(dsearch);
        dsearch.setBounds(300, 15, 57, 57);

        did.setBackground(new java.awt.Color(0, 0, 0));
        did.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        did.setForeground(new java.awt.Color(0, 255, 255));
        did.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                didActionPerformed(evt);
            }
        });
        deletepanel.add(did);
        did.setBounds(180, 20, 190, 40);

        dname.setEditable(false);
        dname.setBackground(new java.awt.Color(0, 0, 0));
        dname.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        dname.setForeground(new java.awt.Color(0, 255, 255));
        deletepanel.add(dname);
        dname.setBounds(180, 90, 190, 40);

        dage.setEditable(false);
        dage.setBackground(new java.awt.Color(0, 0, 0));
        dage.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        dage.setForeground(new java.awt.Color(0, 255, 255));
        deletepanel.add(dage);
        dage.setBounds(180, 150, 190, 40);

        dgender.setEditable(false);
        dgender.setBackground(new java.awt.Color(0, 0, 0));
        dgender.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        dgender.setForeground(new java.awt.Color(0, 255, 255));
        dgender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dgenderActionPerformed(evt);
            }
        });
        deletepanel.add(dgender);
        dgender.setBounds(180, 210, 190, 40);

        jLabel21.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Patient ID");
        deletepanel.add(jLabel21);
        jLabel21.setBounds(70, 30, 100, 30);

        jLabel22.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Name");
        deletepanel.add(jLabel22);
        jLabel22.setBounds(70, 100, 100, 30);

        jLabel23.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Age");
        deletepanel.add(jLabel23);
        jLabel23.setBounds(70, 160, 100, 30);

        jLabel24.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Gender");
        deletepanel.add(jLabel24);
        jLabel24.setBounds(70, 220, 100, 30);

        deldeldel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/deldel.png"))); // NOI18N
        deldeldel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deldeldelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deldeldelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deldeldelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deldeldelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                deldeldelMouseReleased(evt);
            }
        });
        deletepanel.add(deldeldel);
        deldeldel.setBounds(210, 410, 140, 30);

        getContentPane().add(deletepanel);
        deletepanel.setBounds(340, 10, 360, 440);

        addpatient.setOpaque(false);
        addpatient.setLayout(null);

        ID.setBackground(new java.awt.Color(0, 0, 0));
        ID.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        ID.setForeground(new java.awt.Color(0, 255, 255));
        ID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDActionPerformed(evt);
            }
        });
        addpatient.add(ID);
        ID.setBounds(170, 10, 190, 40);

        jLabel1.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Patient ID");
        addpatient.add(jLabel1);
        jLabel1.setBounds(40, 20, 120, 30);

        jLabel2.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Patient Name");
        addpatient.add(jLabel2);
        jLabel2.setBounds(30, 90, 130, 30);

        Name.setBackground(new java.awt.Color(0, 0, 0));
        Name.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        Name.setForeground(new java.awt.Color(0, 255, 255));
        Name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameActionPerformed(evt);
            }
        });
        addpatient.add(Name);
        Name.setBounds(170, 80, 190, 40);

        Age.setBackground(new java.awt.Color(0, 0, 0));
        Age.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        Age.setForeground(new java.awt.Color(0, 255, 255));
        Age.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Age.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgeActionPerformed(evt);
            }
        });
        addpatient.add(Age);
        Age.setBounds(170, 140, 190, 40);

        jLabel3.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Age");
        addpatient.add(jLabel3);
        jLabel3.setBounds(60, 150, 100, 30);

        jLabel4.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Gender");
        addpatient.add(jLabel4);
        jLabel4.setBounds(10, 190, 150, 23);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        addpatient.add(jComboBox1);
        jComboBox1.setBounds(170, 220, 60, 20);
        jComboBox1.getAccessibleContext().setAccessibleName("");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", " " }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        addpatient.add(jComboBox2);
        jComboBox2.setBounds(230, 220, 60, 20);
        jComboBox2.getAccessibleContext().setAccessibleName("");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        addpatient.add(jComboBox3);
        jComboBox3.setBounds(290, 220, 70, 20);
        jComboBox3.getAccessibleContext().setAccessibleName("");

        date.setEditable(false);
        date.setBackground(new java.awt.Color(0, 0, 0));
        date.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        date.setForeground(new java.awt.Color(0, 255, 255));
        date.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateActionPerformed(evt);
            }
        });
        addpatient.add(date);
        date.setBounds(170, 250, 190, 40);

        jLabel10.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Date");
        addpatient.add(jLabel10);
        jLabel10.setBounds(50, 250, 110, 30);

        total.setEditable(false);
        total.setBackground(new java.awt.Color(0, 0, 0));
        total.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        total.setForeground(new java.awt.Color(0, 255, 255));
        total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        total.setText("20");
        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });
        addpatient.add(total);
        total.setBounds(170, 320, 190, 40);

        jLabel9.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Registration Fee");
        addpatient.add(jLabel9);
        jLabel9.setBounds(10, 320, 150, 40);

        gender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        addpatient.add(gender);
        gender.setBounds(170, 190, 65, 27);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/registered.png"))); // NOI18N
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel15MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel15MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel15MouseReleased(evt);
            }
        });
        addpatient.add(jLabel15);
        jLabel15.setBounds(210, 410, 140, 30);

        jButton4.setText("finalized");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        addpatient.add(jButton4);
        jButton4.setBounds(230, 380, 100, 25);

        getContentPane().add(addpatient);
        addpatient.setBounds(340, 10, 360, 440);

        upDate.setOpaque(false);
        upDate.setLayout(null);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search_button.png"))); // NOI18N
        jLabel14.setToolTipText("SEARCH");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel14MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel14MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel14MouseReleased(evt);
            }
        });
        upDate.add(jLabel14);
        jLabel14.setBounds(300, 25, 57, 57);

        Uid.setBackground(new java.awt.Color(0, 0, 0));
        Uid.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        Uid.setForeground(new java.awt.Color(0, 255, 255));
        upDate.add(Uid);
        Uid.setBounds(170, 30, 190, 40);

        Uname.setBackground(new java.awt.Color(0, 0, 0));
        Uname.setForeground(new java.awt.Color(0, 255, 255));
        Uname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UnameActionPerformed(evt);
            }
        });
        upDate.add(Uname);
        Uname.setBounds(170, 100, 190, 40);

        Uage.setBackground(new java.awt.Color(0, 0, 0));
        Uage.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        Uage.setForeground(new java.awt.Color(0, 255, 255));
        Uage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UageMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                UageMousePressed(evt);
            }
        });
        Uage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UageActionPerformed(evt);
            }
        });
        upDate.add(Uage);
        Uage.setBounds(170, 160, 190, 40);

        cgender.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        cgender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        cgender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cgenderActionPerformed(evt);
            }
        });
        upDate.add(cgender);
        cgender.setBounds(250, 210, 100, 27);

        gender101.setEditable(false);
        gender101.setBackground(new java.awt.Color(0, 0, 0));
        gender101.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        gender101.setForeground(new java.awt.Color(0, 255, 255));
        gender101.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gender101ActionPerformed(evt);
            }
        });
        upDate.add(gender101);
        gender101.setBounds(170, 240, 190, 40);

        jLabel5.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Patient ID");
        upDate.add(jLabel5);
        jLabel5.setBounds(40, 40, 120, 25);

        jLabel6.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Name");
        upDate.add(jLabel6);
        jLabel6.setBounds(40, 110, 120, 25);

        jLabel7.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Age");
        upDate.add(jLabel7);
        jLabel7.setBounds(40, 170, 120, 25);

        jLabel8.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Gender");
        upDate.add(jLabel8);
        jLabel8.setBounds(40, 250, 120, 25);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel13MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel13MouseReleased(evt);
            }
        });
        upDate.add(jLabel13);
        jLabel13.setBounds(210, 410, 150, 30);

        jButton1.setText("Finalized");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        upDate.add(jButton1);
        jButton1.setBounds(230, 320, 100, 25);

        getContentPane().add(upDate);
        upDate.setBounds(340, 10, 360, 440);

        charges.setOpaque(false);
        charges.setLayout(null);

        jLabel32.setForeground(new java.awt.Color(153, 255, 255));
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search_button.png"))); // NOI18N
        jLabel32.setToolTipText("SEARCH");
        jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel32MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel32MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel32MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel32MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel32MouseReleased(evt);
            }
        });
        charges.add(jLabel32);
        jLabel32.setBounds(300, 15, 50, 50);

        updatepi.setBackground(new java.awt.Color(0, 0, 0));
        updatepi.setForeground(new java.awt.Color(0, 255, 255));
        charges.add(updatepi);
        updatepi.setBounds(170, 20, 190, 40);

        updatenam.setEditable(false);
        updatenam.setBackground(new java.awt.Color(0, 0, 0));
        updatenam.setForeground(new java.awt.Color(0, 255, 255));
        charges.add(updatenam);
        updatenam.setBounds(170, 70, 190, 40);

        updatelab.setBackground(new java.awt.Color(0, 0, 0));
        updatelab.setForeground(new java.awt.Color(0, 255, 255));
        charges.add(updatelab);
        updatelab.setBounds(170, 120, 190, 40);

        updatecon.setBackground(new java.awt.Color(0, 0, 0));
        updatecon.setForeground(new java.awt.Color(0, 255, 255));
        charges.add(updatecon);
        updatecon.setBounds(170, 170, 190, 40);

        updatebed.setBackground(new java.awt.Color(0, 0, 0));
        updatebed.setForeground(new java.awt.Color(0, 255, 255));
        charges.add(updatebed);
        updatebed.setBounds(170, 220, 190, 40);

        updatedrug.setBackground(new java.awt.Color(0, 0, 0));
        updatedrug.setForeground(new java.awt.Color(0, 255, 255));
        charges.add(updatedrug);
        updatedrug.setBounds(170, 270, 190, 40);

        updatebalance.setEditable(false);
        updatebalance.setBackground(new java.awt.Color(0, 0, 0));
        updatebalance.setForeground(new java.awt.Color(0, 255, 255));
        updatebalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebalanceActionPerformed(evt);
            }
        });
        charges.add(updatebalance);
        updatebalance.setBounds(170, 340, 190, 40);

        jLabel25.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("Patient ID");
        charges.add(jLabel25);
        jLabel25.setBounds(10, 20, 150, 30);

        jLabel26.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("Name");
        charges.add(jLabel26);
        jLabel26.setBounds(10, 70, 150, 30);

        jLabel27.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Laboratory ");
        charges.add(jLabel27);
        jLabel27.setBounds(10, 120, 150, 30);

        jLabel28.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Consultation ");
        charges.add(jLabel28);
        jLabel28.setBounds(10, 170, 150, 30);

        jLabel29.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("Bed");
        charges.add(jLabel29);
        jLabel29.setBounds(10, 220, 150, 30);

        jLabel30.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("Drug Charge");
        charges.add(jLabel30);
        jLabel30.setBounds(10, 270, 150, 30);

        jLabel31.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel31.setText("Balance");
        charges.add(jLabel31);
        jLabel31.setBounds(10, 350, 150, 30);

        reg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update.png"))); // NOI18N
        reg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                regMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                regMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                regMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                regMouseReleased(evt);
            }
        });
        charges.add(reg);
        reg.setBounds(210, 410, 140, 30);

        updatecalcu.setText("Calculate");
        updatecalcu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatecalcuActionPerformed(evt);
            }
        });
        charges.add(updatecalcu);
        updatecalcu.setBounds(240, 310, 100, 23);

        getContentPane().add(charges);
        charges.setBounds(340, 10, 360, 440);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication8/adminmode.png"))); // NOI18N
        getContentPane().add(jLabel12);
        jLabel12.setBounds(120, 0, 710, 450);
        getContentPane().add(jLabel11);
        jLabel11.setBounds(2, -4, 770, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

 
    
    
    
    private void cgenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cgenderActionPerformed
   
gender101.setText(cgender.getSelectedItem().toString());

    }//GEN-LAST:event_cgenderActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed

        date.setText(jComboBox1.getSelectedItem().toString()+"/ "+jComboBox2.getSelectedItem().toString()+"/ "+jComboBox3.getSelectedItem().toString());

        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed

       date.setText(jComboBox1.getSelectedItem().toString()+"/ "+jComboBox2.getSelectedItem().toString()+"/ "+jComboBox3.getSelectedItem().toString());

        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

        date.setText(jComboBox1.getSelectedItem().toString()+"/ "+jComboBox2.getSelectedItem().toString()+"/ "+jComboBox3.getSelectedItem().toString());

        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void UageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UageMouseExited


    }//GEN-LAST:event_UageMouseExited

    private void IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDActionPerformed

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateActionPerformed

    private void jLabel13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MousePressed
ImageIcon II = new ImageIcon(getClass().getResource("/img/update.png"));
     jLabel3.setIcon(II);
     
        
        
        
        
 


if(Uname.getText().equals("")||Uid.getText().equals("")||Uage.getText().equals("")||gender101.getText().equals("")){
    
JOptionPane.showMessageDialog(this,"textfield should not be empty!");
jLabel13.setVisible(false);
}
else{
    UPDATEINFO();
}
 




    }//GEN-LAST:event_jLabel13MousePressed

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
 ImageIcon II = new ImageIcon(getClass().getResource("/img/update2.png"));
     jLabel13.setIcon(II);
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel13MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseReleased
ImageIcon II = new ImageIcon(getClass().getResource("/img/update.png"));
     jLabel13.setIcon(II);
    }//GEN-LAST:event_jLabel13MouseReleased

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
ImageIcon II = new ImageIcon(getClass().getResource("/img/update2.png"));
     jLabel13.setIcon(II);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
      ImageIcon II = new ImageIcon(getClass().getResource("/img/update.png"));
     jLabel13.setIcon(II);
    }//GEN-LAST:event_jLabel13MouseExited

    private void UnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UnameActionPerformed

    private void gender101ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gender101ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gender101ActionPerformed

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked

    ImageIcon II = new ImageIcon(getClass().getResource("/img/search_button2.png"));
     jLabel14.setIcon(II);      
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MousePressed

        


if(ID.getText().equals("")||Name.getText().equals("")||Age.getText().equals("")||date.getText().equals("")){
    
JOptionPane.showMessageDialog(this,"textfield should not be empty!");
jLabel15.setVisible(false);
}
else{
 
        HospitalSystem DB = new HospitalSystem();
        DB.WriteToDatabase(ID.getText(), Name.getText(), Age.getText(), gender.getSelectedItem() + "", null,null,null,null, total.getText(), date.getText());
        
}
              
  

        
        






    }//GEN-LAST:event_jLabel15MousePressed

    private void jLabel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseExited
    ImageIcon II = new ImageIcon(getClass().getResource("/img/registered.png"));
     jLabel15.setIcon(II);
    }//GEN-LAST:event_jLabel15MouseExited

    private void jLabel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseEntered
 ImageIcon II = new ImageIcon(getClass().getResource("/img/registered2.png"));
     jLabel15.setIcon(II);
    }//GEN-LAST:event_jLabel15MouseEntered

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
 ImageIcon II = new ImageIcon(getClass().getResource("/img/registered2.png"));
     jLabel15.setIcon(II);
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel15MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseReleased
ImageIcon II = new ImageIcon(getClass().getResource("/img/registered.png"));
     jLabel15.setIcon(II);
    }//GEN-LAST:event_jLabel15MouseReleased

    private void NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameActionPerformed

    private void AgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AgeActionPerformed

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalActionPerformed

    private void UageMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UageMousePressed


    }//GEN-LAST:event_UageMousePressed

    private void UageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UageActionPerformed

    private void updatebalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebalanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updatebalanceActionPerformed

    private void jLabel32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseClicked

        
        
        ImageIcon II = new ImageIcon(getClass().getResource("/img/search_button2.png"));
     jLabel32.setIcon(II);    
        
        
        
        
    }//GEN-LAST:event_jLabel32MouseClicked

    private void updatecalcuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatecalcuActionPerformed

        
        
           if (updatelab.getText().length() != 0) {
            
            try {
                num1 = Double.parseDouble(updatelab.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, " Laboratory Charge should be a valid number");
                
                if (updatebalance == null) {
                    reg.setVisible(true);
                    
                }
                
                
                updatelab.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(this, " Laboratory Charge should not be empty!");
        }
        
        
        
       
        
        if (updatecon.getText().length() != 0) {
            
            try {
                num2 = Double.parseDouble(updatecon.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, " Consultaion Charge should be a valid number");
                
                if (updatebalance == null) {
                    reg.setVisible(true);
                    
                }
                
                
                updatecon.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Consultaion Charge should not be empty!");
        }
        
         
        
        if (updatebed.getText().length() != 0) {
            
            try {
                num3 = Double.parseDouble(updatebed.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, " Bed Charge should be a valid number");
                
                if (updatebalance == null) {
                    reg.setVisible(true);
                    
                }
                
                
                updatebed.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(this, " Bed Charge should not be empty!");
        }
        
         
        
        if (updatedrug.getText().length() != 0) {
            
            try {
                num4 = Double.parseDouble(updatedrug.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, " Drug Charge  should be a valid number");
                
                if (updatebalance == null) {
                    reg.setVisible(true);
                    
                }
                
                
                updatedrug.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Drug Charge should not be empty!");
        }
        
          
        
        compute=(num1+num2+num3+num4);
        updatebalance.setText(Double.toString(compute));
        
      
        
        
        
        if (updatebalance == null) {
            reg.setVisible(true);
            
        } else {
            reg.setVisible(true);
        }

        
        
    }//GEN-LAST:event_updatecalcuActionPerformed

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
 
        ImageIcon I = new ImageIcon(getClass().getResource("/img/addp2.png"));
     jLabel16.setIcon(I); 
     
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked

     
 ImageIcon III = new ImageIcon(getClass().getResource("/img/updatep2.png"));
        jLabel17.setIcon(III); 
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel17MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseReleased

    }//GEN-LAST:event_jLabel17MouseReleased

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked

        
        ImageIcon II = new ImageIcon(getClass().getResource("/img/homelogo2.png"));
     home.setIcon(II);
        
    }//GEN-LAST:event_homeMouseClicked

    private void homeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseEntered
     
        ImageIcon II = new ImageIcon(getClass().getResource("/img/homelogo2.png"));
     home.setIcon(II);
    }//GEN-LAST:event_homeMouseEntered

    private void homeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMousePressed

    status.setText("");
    charges.setVisible(false);     
    upDate.setVisible(false);
    addpatient.setVisible(false);
    deletepanel.setVisible(false);
  
     
     
        ImageIcon I = new ImageIcon(getClass().getResource("/img/addp.png"));
     jLabel16.setIcon(I); 
    
      
        
 ImageIcon IIo = new ImageIcon(getClass().getResource("/img/delete.png"));
        jLabel20.setIcon(IIo); 
     
 ImageIcon III = new ImageIcon(getClass().getResource("/img/updatep.png"));
        jLabel17.setIcon(III);   
        
        
        
      
      
 ImageIcon IIII = new ImageIcon(getClass().getResource("/img/charge.png"));
        jLabel19.setIcon(IIII); 
      
        
        
            int p = JOptionPane.showConfirmDialog(rootPane, "Do you want to Close the ADMIN MODE?", "CONFIRM CLOSE",JOptionPane.YES_NO_OPTION); 
        if(p==0){
            
                     
    this.dispose(); 
    
    
    
          HOSPITAL_Billing_System s = new HOSPITAL_Billing_System();
     s.setVisible(true);
                }
            
        ImageIcon II = new ImageIcon(getClass().getResource("/img/homelogo2.png"));
     home.setIcon(II);
     
     
    }//GEN-LAST:event_homeMousePressed

    private void homeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseExited
      
        ImageIcon II = new ImageIcon(getClass().getResource("/img/homelogo.png"));
     home.setIcon(II);
    }//GEN-LAST:event_homeMouseExited

    private void homeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseReleased
      
        ImageIcon II = new ImageIcon(getClass().getResource("/img/homelogo.png"));
     home.setIcon(II);
    }//GEN-LAST:event_homeMouseReleased

    private void jLabel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseExited

        ImageIcon II = new ImageIcon(getClass().getResource("/img/search_button.png"));
     jLabel14.setIcon(II);
    }//GEN-LAST:event_jLabel14MouseExited

    private void jLabel14MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseReleased
  ImageIcon II = new ImageIcon(getClass().getResource("/img/search_button.png"));
     jLabel14.setIcon(II);
    }//GEN-LAST:event_jLabel14MouseReleased

    private void jLabel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseEntered
 ImageIcon II = new ImageIcon(getClass().getResource("/img/search_button2.png"));
     jLabel14.setIcon(II);   
    }//GEN-LAST:event_jLabel14MouseEntered

    private void jLabel14MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MousePressed
search();
        
        ImageIcon II = new ImageIcon(getClass().getResource("/img/search_button2.png"));
     jLabel14.setIcon(II);   
    }//GEN-LAST:event_jLabel14MousePressed

    private void jLabel32MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseEntered
 
        
        ImageIcon II = new ImageIcon(getClass().getResource("/img/search_button2.png"));
     jLabel32.setIcon(II);   
    }//GEN-LAST:event_jLabel32MouseEntered

    private void jLabel32MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MousePressed

        searchcharges(); 
         
        
        ImageIcon II = new ImageIcon(getClass().getResource("/img/search_button2.png"));
     jLabel32.setIcon(II);   
    }//GEN-LAST:event_jLabel32MousePressed

    private void jLabel32MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseExited
 
        
        ImageIcon II = new ImageIcon(getClass().getResource("/img/search_button.png"));
     jLabel32.setIcon(II);   
    }//GEN-LAST:event_jLabel32MouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 
        
      
          
                
        
        
        
if(Uage.getText().length()!=0){
    
try{u2=Double.parseDouble(Uage.getText());
  jLabel13.setVisible(true);
}

catch(NumberFormatException e)
{
    jLabel13.setVisible(false);
    Uage.setText("");
    JOptionPane.showMessageDialog(this,"Age should be a valid number");
}
}
else
{
jLabel13.setVisible(false);
 Uage.setText("");
    JOptionPane.showMessageDialog(this,"Age Charge should not be empty!");
}

        
        
     



if(Uname.getText().equals("")||Uid.getText().equals("")){
    
JOptionPane.showMessageDialog(this,"Name Charge should not be empty!");
jLabel13.setVisible(false);
}
else{
    jLabel13.setVisible(true);
}
              
  




    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
 
        
      
          
                
        
        
        
if(Age.getText().length()!=0){
    
try{num2=Double.parseDouble(Age.getText());
  jLabel15.setVisible(true);
}

catch(NumberFormatException e)
{
    jLabel15.setVisible(false);
    Age.setText("");
    JOptionPane.showMessageDialog(this,"Age should be a valid number");
}
}
else
{
jLabel15.setVisible(false);
 Age.setText("");
    JOptionPane.showMessageDialog(this,"Age Charge should not be empty!");
}

        
        
     



if(ID.getText().equals("")||Name.getText().equals("")){
    
JOptionPane.showMessageDialog(this,"Name , Id  should not be empty!");
jLabel15.setVisible(false);
}
else{
    jLabel15.setVisible(true);
}
              
  

        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void regMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regMouseReleased
ImageIcon II = new ImageIcon(getClass().getResource("/img/update.png"));
     reg.setIcon(II);  
    }//GEN-LAST:event_regMouseReleased

    private void regMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regMouseExited
ImageIcon II = new ImageIcon(getClass().getResource("/img/update.png"));
     reg.setIcon(II); 
    }//GEN-LAST:event_regMouseExited

    private void regMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regMouseClicked
 ImageIcon II = new ImageIcon(getClass().getResource("/img/update2.png"));
     reg.setIcon(II); 
    }//GEN-LAST:event_regMouseClicked

    private void regMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regMouseEntered
 ImageIcon II = new ImageIcon(getClass().getResource("/img/update2.png"));
     reg.setIcon(II);
    }//GEN-LAST:event_regMouseEntered

    private void regMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regMousePressed

        
        ImageIcon II = new ImageIcon(getClass().getResource("/img/update2.png"));
     reg.setIcon(II);
    


if(updatepi.getText().equals("")||updatenam.getText().equals("")||updatelab.getText().equals("")||updatecon.getText().equals("")||updatebed.getText().equals("")||updatedrug.getText().equals("")){
    
JOptionPane.showMessageDialog(this,"textfield should not be empty!");
reg.setVisible(false);
}
else{
  
     UPDATEcharge();
    
        
}
              
  
 
     
    }//GEN-LAST:event_regMousePressed

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked

      
      
 ImageIcon IIII = new ImageIcon(getClass().getResource("/img/charge2.png"));
        jLabel19.setIcon(IIII); 
      
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked

        
 ImageIcon II = new ImageIcon(getClass().getResource("/img/delete2.png"));
        jLabel20.setIcon(II); 
    }//GEN-LAST:event_jLabel20MouseClicked

    private void didActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_didActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_didActionPerformed

    private void dgenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dgenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dgenderActionPerformed

    private void dsearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dsearchMouseClicked

        ImageIcon II = new ImageIcon(getClass().getResource("/img/search_button2.png"));
     dsearch.setIcon(II);  
    }//GEN-LAST:event_dsearchMouseClicked

    private void dsearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dsearchMouseEntered
ImageIcon II = new ImageIcon(getClass().getResource("/img/search_button2.png"));
     dsearch.setIcon(II); 
    }//GEN-LAST:event_dsearchMouseEntered

    private void dsearchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dsearchMousePressed
deletesearch();
        ImageIcon II = new ImageIcon(getClass().getResource("/img/search_button2.png"));
     dsearch.setIcon(II); 
    }//GEN-LAST:event_dsearchMousePressed

    private void dsearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dsearchMouseExited
ImageIcon II = new ImageIcon(getClass().getResource("/img/search_button.png"));
     dsearch.setIcon(II); 
    }//GEN-LAST:event_dsearchMouseExited

    private void dsearchMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dsearchMouseReleased
ImageIcon II = new ImageIcon(getClass().getResource("/img/search_button.png"));
     dsearch.setIcon(II); 
    }//GEN-LAST:event_dsearchMouseReleased

    private void deldeldelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deldeldelMouseClicked
 ImageIcon II = new ImageIcon(getClass().getResource("/img/deldel2.png"));
     deldeldel.setIcon(II);
    }//GEN-LAST:event_deldeldelMouseClicked

    private void deldeldelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deldeldelMouseEntered
  ImageIcon II = new ImageIcon(getClass().getResource("/img/deldel2.png"));
     deldeldel.setIcon(II);
    }//GEN-LAST:event_deldeldelMouseEntered

    private void deldeldelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deldeldelMousePressed
String jk = did.getText();
        

if (did.getText().equals("")){
     JOptionPane.showMessageDialog(rootPane, "Patient ID should not be empty!");
}
else{

            int p = JOptionPane.showConfirmDialog(rootPane, "Do you want to DELETE the '"+jk+"'?", "CONFIRM DELETE",JOptionPane.YES_NO_OPTION); 
        if(p==0){
            
              
        
     deletedrecord();  
                }
       
}
        
        
        
        ImageIcon II = new ImageIcon(getClass().getResource("/img/deldel2.png"));
     deldeldel.setIcon(II);
    }//GEN-LAST:event_deldeldelMousePressed

    private void deldeldelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deldeldelMouseExited
 ImageIcon II = new ImageIcon(getClass().getResource("/img/deldel.png"));
     deldeldel.setIcon(II);
    }//GEN-LAST:event_deldeldelMouseExited

    private void deldeldelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deldeldelMouseReleased
 ImageIcon II = new ImageIcon(getClass().getResource("/img/deldel.png"));
     deldeldel.setIcon(II);
    }//GEN-LAST:event_deldeldelMouseReleased

    private void jLabel16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MousePressed
 status.setText("Add Patient");
 ID.setText("");
 Name.setText("");
 Age.setText("");
 date.setText("");
 
 
    deletepanel.setVisible(false);
 charges.setVisible(false);     
 upDate.setVisible(false);
    addpatient.setVisible(true);
  
     
     
     
      if (status.getText().equals("Add Patient")){
           ImageIcon I = new ImageIcon(getClass().getResource("/img/addp2.png"));
     jLabel16.setIcon(I); 
     
        
         
 ImageIcon III = new ImageIcon(getClass().getResource("/img/updatep.png"));
        jLabel17.setIcon(III);
         
        
 
 ImageIcon IIII = new ImageIcon(getClass().getResource("/img/charge.png"));
        jLabel19.setIcon(IIII); 
        
        
        
 ImageIcon II = new ImageIcon(getClass().getResource("/img/delete.png"));
        jLabel20.setIcon(II); 
      }
      
    }//GEN-LAST:event_jLabel16MousePressed

    private void jLabel17MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MousePressed
 status.setText("Update Patient Info");
        
    deletepanel.setVisible(false);
        addpatient.setVisible(false);
        
 upDate.setVisible(true);
 
 charges.setVisible(false);
 Uid.setText("");
 Uname.setText("");
 Uage.setText("");
 gender101.setText("");
 
      if (status.getText().equals("Update Patient Info")){
           ImageIcon I = new ImageIcon(getClass().getResource("/img/addp.png"));
     jLabel16.setIcon(I); 
     
               
 ImageIcon II = new ImageIcon(getClass().getResource("/img/delete.png"));
        jLabel20.setIcon(II); 
        
 
 ImageIcon III = new ImageIcon(getClass().getResource("/img/updatep2.png"));
        jLabel17.setIcon(III); 
        
        
 ImageIcon IIII = new ImageIcon(getClass().getResource("/img/charge.png"));
        jLabel19.setIcon(IIII); 
        } 
 
     
    }//GEN-LAST:event_jLabel17MousePressed

    private void jLabel19MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MousePressed
   
       charges.setVisible(true); 
        addpatient.setVisible(false);
    upDate.setVisible(false);
    
    deletepanel.setVisible(false);
    
        status.setText("Add Charges ");
      updatepi.setText("");
      updatenam.setText("");
      updatelab.setText("");
      updatecon.setText("");
      updatebed.setText("");
      updatedrug.setText("");
      updatebalance.setText("");
      
      if (status.getText().equals("Add Charges ")){
           ImageIcon I = new ImageIcon(getClass().getResource("/img/addp.png"));
     jLabel16.setIcon(I); 
     
          
 ImageIcon II = new ImageIcon(getClass().getResource("/img/delete.png"));
        jLabel20.setIcon(II); 
         
 ImageIcon III = new ImageIcon(getClass().getResource("/img/updatep.png"));
        jLabel17.setIcon(III);
        
        
 ImageIcon IIII = new ImageIcon(getClass().getResource("/img/charge2.png"));
        jLabel19.setIcon(IIII); 
      }
      
    }//GEN-LAST:event_jLabel19MousePressed

    private void jLabel20MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MousePressed
  status.setText("Delete Patient Recod ");

 
 
    
    deletepanel.setVisible(true);
    charges.setVisible(false);     
    upDate.setVisible(false);
    addpatient.setVisible(false);
  
     
    did.setText("");
    dname.setText("");
    dage.setText("");
    dgender.setText("");
 
 
        if (status.getText().equals("Delete Patient Recod ")){
           ImageIcon I = new ImageIcon(getClass().getResource("/img/addp.png"));
     jLabel16.setIcon(I); 
     
          
 ImageIcon II = new ImageIcon(getClass().getResource("/img/delete2.png"));
        jLabel20.setIcon(II); 
         
 ImageIcon III = new ImageIcon(getClass().getResource("/img/updatep.png"));
        jLabel17.setIcon(III);
        
        
 ImageIcon IIII = new ImageIcon(getClass().getResource("/img/charge.png"));
        jLabel19.setIcon(IIII); 
      }
    }//GEN-LAST:event_jLabel20MousePressed

    private void jLabel32MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseReleased
 
        
        ImageIcon II = new ImageIcon(getClass().getResource("/img/search_button.png"));
     jLabel32.setIcon(II); 
    }//GEN-LAST:event_jLabel32MouseReleased

    private void jLabel33MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel33MousePressed
 
          view s = new view();
     s.setVisible(true);
    }//GEN-LAST:event_jLabel33MousePressed

    
       
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
            java.util.logging.Logger.getLogger(AddPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddPatient().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Age;
    private javax.swing.JTextField ID;
    private javax.swing.JTextField Name;
    private javax.swing.JTextField Uage;
    private javax.swing.JTextField Uid;
    private javax.swing.JTextField Uname;
    private javax.swing.JPanel addpatient;
    private javax.swing.JComboBox cgender;
    private javax.swing.JPanel charges;
    private javax.swing.JTextField dage;
    private javax.swing.JTextField date;
    private javax.swing.JLabel deldeldel;
    private javax.swing.JPanel deletepanel;
    private javax.swing.JTextField dgender;
    private javax.swing.JTextField did;
    private javax.swing.JTextField dname;
    private javax.swing.JLabel dsearch;
    private javax.swing.JComboBox gender;
    private javax.swing.JTextField gender101;
    private javax.swing.JLabel home;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel reg;
    private javax.swing.JLabel status;
    private javax.swing.JTextField total;
    private javax.swing.JPanel upDate;
    private javax.swing.JTextField updatebalance;
    private javax.swing.JTextField updatebed;
    private javax.swing.JButton updatecalcu;
    private javax.swing.JTextField updatecon;
    private javax.swing.JTextField updatedrug;
    private javax.swing.JTextField updatelab;
    private javax.swing.JTextField updatenam;
    private javax.swing.JTextField updatepi;
    // End of variables declaration//GEN-END:variables
}
