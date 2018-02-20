/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AdminLoginCode {
    Connection conn;
    String Password="";
    AdminLoginCode()
    {
        try
        {
            String filename = "password.mdb";
            String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=";
            database+=filename.trim()+";DriverID=22;READONLY=false}";
            conn = DriverManager.getConnection(database, "", "");
        }
        catch(SQLException E)
        {
            System.out.println(E.toString());
        }
        
    }


public boolean CheckLogin(String Username, String Password)
{
boolean check = false;
try
{
String filename = "password.mdb";
String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=";
database+=filename.trim()+";DriverID=22;READONLY=false}";
conn = DriverManager.getConnection(database, "", "");

Statement sta = conn.createStatement();
String sql = "SELECT * FROM key WHERE Username = '"+Username+"' AND Password =  '"+Password+"'";
ResultSet rs = sta.executeQuery(sql);

while(rs.next())
{
check=true;
}
if(check==false)
{
System.out.println("Login is not correct");
}
}
catch(SQLException E)
{
System.out.println(E.toString());
}
return check;
}
}