package com.bookmyseat.admin.dao;
import java.sql.*;
import java.util.*;
import com.bookmyseat.connection.ConnectionDB;
import com.bookmyseat.admin.model.Movie;

public class MovieDAO {
    public boolean AddMovie(Movie movie) throws ClassNotFoundException, SQLException
    {
        int x = 0;
        String sql = "insert into movie values('"+movie.getId()+"','"+movie.getName()+"', '"+movie.getDirector()+"', '"+movie.getReleasing_Date()+"', '"+movie.getCasts()+"', '"+movie.getDescription()+"', '"+movie.getPoster()+"', '"+movie.getDuration()+"', '"+movie.getTrailer()+"', '"+movie.getCategory()+"')";
        Connection conn = ConnectionDB.getCon();
        System.out.println("Connection is "+conn);
        Statement st = conn.createStatement();
        x = st.executeUpdate(sql);
        conn.close();
        if(x!=0)
            return true;
        else
            return false;
    }
    
    public boolean DeleteMovie(int id) throws ClassNotFoundException, SQLException
    {
        int x = 0;
        String sql = "delete from movie where id = '"+id+"' ";
        Connection conn = ConnectionDB.getCon();
        System.out.println("Connection is "+conn);
        Statement st = conn.createStatement();
        x = st.executeUpdate(sql);
        conn.close();
        if(x!=0)
            return true;
        else
            return false;
    }
    
    public boolean UpdateMovie(Movie movie) throws ClassNotFoundException, SQLException
    {
        int x = 0;
        String sql = "update movie set name = '"+movie.getName()+"', director = '"+movie.getDirector()+"',Releasing_Date = '"+movie.getReleasing_Date()+"', Casts = '"+movie.getCasts()+"', Description = '"+movie.getDescription()+"', poster = '"+movie.getPoster()+"', duration = '"+movie.getDuration()+"', trailer = '"+movie.getTrailer()+"', category = '"+movie.getCategory()+"' where id = '"+movie.getId()+"' ";
        Connection conn = ConnectionDB.getCon();
        System.out.println("Connection is "+conn);
        Statement st = conn.createStatement();
        x = st.executeUpdate(sql);
        conn.close();
        if(x!=0)
            return true;
        else
            return false;
    }
    
    public String findMovieNameById(int id) throws SQLException, ClassNotFoundException
    {
        Connection conn = ConnectionDB.getCon();
        String sql = "select name from movie where id = '"+id+"' ";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        String name = "error";
        while(rs.next())
        {
            name = rs.getString("name");
        }
        return name;
    }
    
    public Movie findMovieById(int id) throws SQLException, ClassNotFoundException
    {
        Movie movie = new Movie();
        Connection conn = ConnectionDB.getCon();
        String sql = "select * from admin where id = '"+id+"' ";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next())
        {
            movie.setId(rs.getInt("id"));
            movie.setName(rs.getString("name"));
            movie.setDirector(rs.getString("director"));
            movie.setReleasing_Date(rs.getString("Releasing_Date"));
            movie.setCasts(rs.getString("casts"));
            movie.setDescription(rs.getString("description"));
            movie.setPoster(rs.getString("poster"));
            movie.setDuration(rs.getString("duration"));
            movie.setTrailer(rs.getString("trailer"));
            movie.setCategory(rs.getString("category"));
        }
        conn.close();
        return movie;
    }
    
    public ArrayList <Movie> displayMovie() throws SQLException, ClassNotFoundException
    {
        ArrayList <Movie> list = new ArrayList <Movie> ();
        Connection conn = ConnectionDB.getCon();
        String sql = "select * from movie";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next())
        {
            Movie movie = new Movie();
            movie.setId(rs.getInt("id"));
            movie.setName(rs.getString("name"));
            movie.setDirector(rs.getString("director"));
            movie.setReleasing_Date(rs.getString("Releasing_Date"));
            movie.setCasts(rs.getString("casts"));
            movie.setDescription(rs.getString("description"));
            movie.setPoster(rs.getString("poster"));
            movie.setDuration(rs.getString("duration"));
            movie.setTrailer(rs.getString("trailer"));
            movie.setCategory(rs.getString("category"));
            list.add(movie);
        }
        conn.close();
        return list;
    }
}
