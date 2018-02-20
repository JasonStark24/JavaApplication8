package javaapplication8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class HospitalSystem {

    Connection conn;

    HospitalSystem() {


        try {
            String filename = "PatientRecord.mdb";
            String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=";
            database += filename.trim() + ";DriverID=22;READONLY=false}";
            conn = DriverManager.getConnection(database, "", "");
            System.out.println("Connection Passed");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void WriteToDatabase(String ID, String Name, String Age, String Gender,String lab, String consulation, String bed, String drug, String total, String date) {

        try {
            String filename = "PatientRecord.mdb";
            String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=";
            database += filename.trim() + ";DriverID=22;READONLY=false}";
            conn = DriverManager.getConnection(database, "", "");

            Statement sta = conn.createStatement();

            int s = sta.executeUpdate("INSERT INTO PatientRecords VALUES ('" + ID + "','" + Name + "','" + Age + "','" + Gender + "','" + lab + "','" + consulation + "','" + bed + "','" + drug + "','" + total + "','" + date + "')");
            System.out.println("Inserted into DB");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

