package com.bookmyseat.admin.dao;
import java.sql.*;
import java.util.*;
import com.bookmyseat.connection.ConnectionDB;
import com.bookmyseat.admin.model.Hall;
/**
 *
 * @author hp-pc
 */
public class HallDAO {
    
    public ArrayList premiumSeatAvailability(int id) throws SQLException, ClassNotFoundException
    {
        ArrayList list = new ArrayList();
        Connection conn = ConnectionDB.getCon();
        String sql = "select * from premiumseats where id = '"+id+"' ";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next())
        {
            list.add(rs.getString("p1"));
list.add(rs.getString("p2"));
list.add(rs.getString("p3"));
list.add(rs.getString("p4"));
list.add(rs.getString("p5"));
list.add(rs.getString("p6"));
list.add(rs.getString("p7"));
list.add(rs.getString("p8"));
list.add(rs.getString("p9"));
list.add(rs.getString("p10"));
list.add(rs.getString("p11"));
list.add(rs.getString("p12"));
list.add(rs.getString("p13"));
list.add(rs.getString("p14"));
list.add(rs.getString("p15"));
list.add(rs.getString("p16"));
list.add(rs.getString("p17"));
list.add(rs.getString("p18"));
list.add(rs.getString("p19"));
list.add(rs.getString("p20"));
        }
        return list;
    }
    
    public ArrayList standardSeatAvailability(int id) throws SQLException, ClassNotFoundException
    {
        ArrayList list = new ArrayList();
        Connection conn = ConnectionDB.getCon();
        String sql = "select * from standardseats where id = '"+id+"' ";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next())
        {
            list.add(rs.getString("s1"));
list.add(rs.getString("s2"));
list.add(rs.getString("s3"));
list.add(rs.getString("s4"));
list.add(rs.getString("s5"));
list.add(rs.getString("s6"));
list.add(rs.getString("s7"));
list.add(rs.getString("s8"));
list.add(rs.getString("s9"));
list.add(rs.getString("s10"));
list.add(rs.getString("s11"));
list.add(rs.getString("s12"));
list.add(rs.getString("s13"));
list.add(rs.getString("s14"));
list.add(rs.getString("s15"));
list.add(rs.getString("s16"));
list.add(rs.getString("s17"));
list.add(rs.getString("s18"));
list.add(rs.getString("s19"));
list.add(rs.getString("s20"));
list.add(rs.getString("s21"));
list.add(rs.getString("s22"));
list.add(rs.getString("s23"));
list.add(rs.getString("s24"));
list.add(rs.getString("s25"));
list.add(rs.getString("s26"));
list.add(rs.getString("s27"));
list.add(rs.getString("s28"));
list.add(rs.getString("s29"));
list.add(rs.getString("s30"));
list.add(rs.getString("s31"));
list.add(rs.getString("s32"));
list.add(rs.getString("s33"));
list.add(rs.getString("s34"));
list.add(rs.getString("s35"));
list.add(rs.getString("s36"));
list.add(rs.getString("s37"));
list.add(rs.getString("s38"));
list.add(rs.getString("s39"));
list.add(rs.getString("s40"));
list.add(rs.getString("s41"));
list.add(rs.getString("s42"));
list.add(rs.getString("s43"));
list.add(rs.getString("s44"));
list.add(rs.getString("s45"));
list.add(rs.getString("s46"));
list.add(rs.getString("s47"));
list.add(rs.getString("s48"));
list.add(rs.getString("s49"));
list.add(rs.getString("s50"));
list.add(rs.getString("s51"));
list.add(rs.getString("s52"));
list.add(rs.getString("s53"));
list.add(rs.getString("s54"));
list.add(rs.getString("s55"));
list.add(rs.getString("s56"));
list.add(rs.getString("s57"));
list.add(rs.getString("s58"));
list.add(rs.getString("s59"));
list.add(rs.getString("s60"));
list.add(rs.getString("s61"));
list.add(rs.getString("s62"));
list.add(rs.getString("s63"));
list.add(rs.getString("s64"));
list.add(rs.getString("s65"));
list.add(rs.getString("s66"));
list.add(rs.getString("s67"));
list.add(rs.getString("s68"));
list.add(rs.getString("s69"));
list.add(rs.getString("s70"));
list.add(rs.getString("s71"));
list.add(rs.getString("s72"));
list.add(rs.getString("s73"));
list.add(rs.getString("s74"));
list.add(rs.getString("s75"));
list.add(rs.getString("s76"));
list.add(rs.getString("s77"));
list.add(rs.getString("s78"));
list.add(rs.getString("s79"));
list.add(rs.getString("s80"));
        }
        return list;
    }
    
    public ArrayList<Hall> premiumseatStatus(int id) throws SQLException, ClassNotFoundException
    {
        ArrayList <Hall> list = new ArrayList<Hall>();
        Connection conn = ConnectionDB.getCon();
        String sql1 = "Select * from premiumseats where id = '"+id+"' ";
        Statement st = conn.createStatement();
        ResultSet rs1 = st.executeQuery(sql1);
        while(rs1.next())
        {
            Hall hall = new Hall();
            hall.setId(rs1.getInt("id"));
            hall.setP1(rs1.getString("p1"));
hall.setP2(rs1.getString("p2"));
hall.setP3(rs1.getString("p3"));
hall.setP4(rs1.getString("p4"));
hall.setP5(rs1.getString("p5"));
hall.setP6(rs1.getString("p6"));
hall.setP7(rs1.getString("p7"));
hall.setP8(rs1.getString("p8"));
hall.setP9(rs1.getString("p9"));
hall.setP10(rs1.getString("p10"));
hall.setP11(rs1.getString("p11"));
hall.setP12(rs1.getString("p12"));
hall.setP13(rs1.getString("p13"));
hall.setP14(rs1.getString("p14"));
hall.setP15(rs1.getString("p15"));
hall.setP16(rs1.getString("p16"));
hall.setP17(rs1.getString("p17"));
hall.setP18(rs1.getString("p18"));
hall.setP19(rs1.getString("p19"));
hall.setP20(rs1.getString("p20"));
list.add(hall);
        }
        
        return list;
    }
    
    public ArrayList<Hall> standardseatStatus(int id) throws SQLException, ClassNotFoundException
    {
        ArrayList <Hall> list = new ArrayList<Hall>();
        Connection conn = ConnectionDB.getCon();
        String sql2 = "Select * from standardseats where id = '"+id+"' ";
        Statement st = conn.createStatement();
        ResultSet rs2 = st.executeQuery(sql2);
        while(rs2.next())
        {
            Hall hall = new Hall();
            hall.setS1(rs2.getString("s1"));
hall.setS2(rs2.getString("s2"));
hall.setS3(rs2.getString("s3"));
hall.setS4(rs2.getString("s4"));
hall.setS5(rs2.getString("s5"));
hall.setS6(rs2.getString("s6"));
hall.setS7(rs2.getString("s7"));
hall.setS8(rs2.getString("s8"));
hall.setS9(rs2.getString("s9"));
hall.setS10(rs2.getString("s10"));
hall.setS11(rs2.getString("s11"));
hall.setS12(rs2.getString("s12"));
hall.setS13(rs2.getString("s13"));
hall.setS14(rs2.getString("s14"));
hall.setS15(rs2.getString("s15"));
hall.setS16(rs2.getString("s16"));
hall.setS17(rs2.getString("s17"));
hall.setS18(rs2.getString("s18"));
hall.setS19(rs2.getString("s19"));
hall.setS20(rs2.getString("s20"));
hall.setS21(rs2.getString("s21"));
hall.setS22(rs2.getString("s22"));
hall.setS23(rs2.getString("s23"));
hall.setS24(rs2.getString("s24"));
hall.setS25(rs2.getString("s25"));
hall.setS26(rs2.getString("s26"));
hall.setS27(rs2.getString("s27"));
hall.setS28(rs2.getString("s28"));
hall.setS29(rs2.getString("s29"));
hall.setS30(rs2.getString("s30"));
hall.setS31(rs2.getString("s31"));
hall.setS32(rs2.getString("s32"));
hall.setS33(rs2.getString("s33"));
hall.setS34(rs2.getString("s34"));
hall.setS35(rs2.getString("s35"));
hall.setS36(rs2.getString("s36"));
hall.setS37(rs2.getString("s37"));
hall.setS38(rs2.getString("s38"));
hall.setS39(rs2.getString("s39"));
hall.setS40(rs2.getString("s40"));
hall.setS41(rs2.getString("s41"));
hall.setS42(rs2.getString("s42"));
hall.setS43(rs2.getString("s43"));
hall.setS44(rs2.getString("s44"));
hall.setS45(rs2.getString("s45"));
hall.setS46(rs2.getString("s46"));
hall.setS47(rs2.getString("s47"));
hall.setS48(rs2.getString("s48"));
hall.setS49(rs2.getString("s49"));
hall.setS50(rs2.getString("s50"));
hall.setS51(rs2.getString("s51"));
hall.setS52(rs2.getString("s52"));
hall.setS53(rs2.getString("s53"));
hall.setS54(rs2.getString("s54"));
hall.setS55(rs2.getString("s55"));
hall.setS56(rs2.getString("s56"));
hall.setS57(rs2.getString("s57"));
hall.setS58(rs2.getString("s58"));
hall.setS59(rs2.getString("s59"));
hall.setS60(rs2.getString("s60"));
hall.setS61(rs2.getString("s61"));
hall.setS62(rs2.getString("s62"));
hall.setS63(rs2.getString("s63"));
hall.setS64(rs2.getString("s64"));
hall.setS65(rs2.getString("s65"));
hall.setS66(rs2.getString("s66"));
hall.setS67(rs2.getString("s67"));
hall.setS68(rs2.getString("s68"));
hall.setS69(rs2.getString("s69"));
hall.setS70(rs2.getString("s70"));
hall.setS71(rs2.getString("s71"));
hall.setS72(rs2.getString("s72"));
hall.setS73(rs2.getString("s73"));
hall.setS74(rs2.getString("s74"));
hall.setS75(rs2.getString("s75"));
hall.setS76(rs2.getString("s76"));
hall.setS77(rs2.getString("s77"));
hall.setS78(rs2.getString("s78"));
hall.setS79(rs2.getString("s79"));
hall.setS80(rs2.getString("s80"));
list.add(hall);
        }
        return list;
    }
    
    public boolean bookPremiumSeat(int id, String premiumseats[], String email) throws ClassNotFoundException, SQLException
    {
        int x = 0, y = 0;
        System.out.println("id = "+id);
        System.out.println("email = "+email);
        Connection conn = ConnectionDB.getCon();
        String seats = Arrays.toString(premiumseats);
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
    
}
