package com.bookmyseat.user.servlet;

import com.bookmyseat.admin.dao.HallDAO;
import com.bookmyseat.admin.dao.MovieDAO;
import com.bookmyseat.admin.model.Hall;
import com.bookmyseat.admin.model.Movie;
import com.bookmyseat.connection.ConnectionDB;
import com.bookmyseat.user.dao.UserDAO;
import com.bookmyseat.user.model.User;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;



public class Rough {
    
public boolean bookPremiumSeat(int id, String premiumseats[], String email) throws ClassNotFoundException, SQLException
    {
        int x = 0, y = 0;
        System.out.println("id = "+id);
        System.out.println("email = "+email);
        Connection conn = ConnectionDB.getCon();
        String seats = "Arrays.toString(premiumseats)";
        System.out.println("seats = ");
        MovieDAO moviedao = new MovieDAO();
        String movieName = moviedao.findMovieNameById(id);
        String bookingSql = "update user set bookings = 'Movie - "+movieName+" Seats - "+seats+" ' where email = '"+email+"' ";
        System.out.println("book sql = "+bookingSql);
        String sql = "update premiumseats set ";
        for(int i = 0; i<premiumseats.length; i++)
        {
            if(i<premiumseats.length-1)
                sql = sql + premiumseats[i] + " = 'no', ";
            else
                sql = sql + premiumseats[i] + " = 'no' ";
        }
         sql = sql + "where id = '"+id+"' ";
        Statement st = conn.createStatement();
        x = st.executeUpdate(sql);
        y = st.executeUpdate(bookingSql);
        if(x!=0 && y!=0)
            return true;
        else
            return false;
    }
    
    public boolean bookStandardSeat(int id, String standardseats[], String email) throws ClassNotFoundException, SQLException
    {
        System.out.println("id = "+id);
        System.out.println("email = "+email);
        int x = 0, y = 0;
        Connection conn = ConnectionDB.getCon();
        String seats = Arrays.toString(standardseats);
        MovieDAO moviedao = new MovieDAO();
        String movieName = moviedao.findMovieNameById(id);
        String bookingSql = "update user set bookings = 'Movie - "+movieName+" : Seats - "+seats+" ' where email = '"+email+"' ";
        System.out.println("book sql = "+bookingSql);
        String sql = "update standardseats set ";
        for(int i = 0; i<standardseats.length; i++)
        {
            if(i<standardseats.length-1)
                sql = sql + standardseats[i] + " = 'no', ";
            else
                sql = sql + standardseats[i] + " = 'no' ";
        }
         sql = sql + "where id = '"+id+"' ";
         System.out.println("sql = "+sql);
        Statement st = conn.createStatement();
        x = st.executeUpdate(sql);
        y = st.executeUpdate(bookingSql);
        if(x!=0 && y!=0)
            return true;
        else
            return false;
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Rough r = new Rough();
         HallDAO userdao = new HallDAO();
        String arr [] = {"s12"};
        String email = "sagar.dutta2020@vitbhopal.ac.in";
        int id = 2;
        System.out.println("status = "+userdao.bookStandardSeat(id, arr, email));
        }
    }