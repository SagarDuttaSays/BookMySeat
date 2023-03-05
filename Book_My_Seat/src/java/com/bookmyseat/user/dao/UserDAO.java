package com.bookmyseat.user.dao;
import java.sql.*;
import java.util.*;
import com.bookmyseat.connection.ConnectionDB;
import com.bookmyseat.user.model.User;
public class UserDAO {
    public boolean AddUser(User user) throws ClassNotFoundException, SQLException
    {
        int x = 0;
        Connection conn = ConnectionDB.getCon();
        System.out.println("Connection is "+conn);
        String sql = "insert into user (id,name,email,dob,gender,password) values ('"+user.getId()+"', '"+user.getName()+"', '"+user.getEmail()+"', '"+user.getDob()+"', '"+user.getGender()+"', '"+user.getPassword()+"')";
        Statement st = conn.createStatement();
        x = st.executeUpdate(sql);
        conn.close();
        if(x!=0)
            return true;
        else
            return false;
    }
    
    public int lastId() throws SQLException, ClassNotFoundException
    {
        int id = 0;
        Connection conn = ConnectionDB.getCon();
        String sql = "select max(ID) from user";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next())
        {
            id = rs.getInt("id");
        }
        return id;
    }
    
    public boolean validityOfEmail(String email) throws ClassNotFoundException, SQLException
    {
        Connection conn = ConnectionDB.getCon();
        Statement st = conn.createStatement();
        String sql = "select email from user";
        ResultSet rs = st.executeQuery(sql);
        while(rs.next())
        {
            if(rs.getString("email").equals(email))
                return false;
        }
        conn.close();
        return true;
    }
    
    public boolean authentication (String email, String password) throws SQLException, ClassNotFoundException
    {
        Connection conn = ConnectionDB.getCon();
        Statement st = conn.createStatement();
        String sql = "select password from user where email = '"+email+"' ";
        ResultSet rs = st.executeQuery(sql);
        while(rs.next())
        {
            if(rs.getString("password").equals(password))
                return true;
        }
        conn.close();
        return false;
    }
    
    public boolean DeleteUser(int id) throws ClassNotFoundException, SQLException
    {
        int x = 0;
        Connection conn = ConnectionDB.getCon();
        System.out.println("Connection is "+conn);
        String sql = "delete from user where id = '"+id+"' ";
        Statement st = conn.createStatement();
        x = st.executeUpdate(sql);
        conn.close();
        if(x!=0)
            return true;
        else
            return false;
    }
    
    public boolean UpdateUser(User user) throws ClassNotFoundException, SQLException
    {
        int x = 0;
        Connection conn = ConnectionDB.getCon();
        System.out.println("Connection is "+conn);
        String sql = "update user set name = '"+user.getName()+"', email = '"+user.getEmail()+"', dob = '"+user.getDob()+"', gender =  '"+user.getGender()+"', password =  '"+user.getPassword()+"' where id = '"+user.getId()+"' ";
        Statement st = conn.createStatement();
        x = st.executeUpdate(sql);
        conn.close();
        if(x!=0)
            return true;
        else
            return false;
    }
    
    public User findUserById(int id) throws SQLException, ClassNotFoundException
    {
        User user = new User();
        Connection conn = ConnectionDB.getCon();
        String sql = "select * from user where id = '"+id+"' ";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next())
        {
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setDob(rs.getString("dob"));
            user.setGender(rs.getString("gender"));
            user.setPassword(rs.getString("password"));
        }
        conn.close();
        return user;
    }
    
    public User findUserByEmail(String email) throws SQLException, ClassNotFoundException
    {
        User user = new User();
        Connection conn = ConnectionDB.getCon();
        String sql = "select * from user where email = '"+email+"' ";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next())
        {
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setDob(rs.getString("dob"));
            user.setGender(rs.getString("gender"));
            user.setPassword(rs.getString("password"));
            user.setBookings(rs.getString("bookings"));
        }
        conn.close();
        return user;
    }
    
    public ArrayList <User> displayUser() throws SQLException, ClassNotFoundException
    {
        ArrayList <User> list = new ArrayList <User> ();
        Connection conn = ConnectionDB.getCon();
        String sql = "select * from admin";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next())
        {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setDob(rs.getString("dob"));
            user.setGender(rs.getString("gender"));
            user.setPassword(rs.getString("password"));
            list.add(user);
        }
        conn.close();
        return list;
    }
}
