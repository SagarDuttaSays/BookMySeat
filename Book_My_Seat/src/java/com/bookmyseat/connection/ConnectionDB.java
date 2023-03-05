/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookmyseat.connection;
import java.sql.*;
/**
 *
 * @author hp-pc
 */
public class ConnectionDB {
    public static Connection getCon() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyseat", "root", "duttasagar086");
    }
    
}
