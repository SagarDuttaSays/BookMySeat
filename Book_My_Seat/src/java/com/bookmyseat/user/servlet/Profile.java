/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookmyseat.user.servlet;

import com.bookmyseat.user.dao.UserDAO;
import com.bookmyseat.user.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp-pc
 */
@WebServlet(name = "Profile", urlPatterns = {"/Profile"})
public class Profile extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        
        }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        String email = request.getParameter("email");
        UserDAO userdao = new UserDAO();
        User user = new User();
        try {
            user = userdao.findUserByEmail(email);
        } catch (SQLException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        }
        String name = user.getName();
        String dob = user.getDob();
        String password = user.getPassword();
        String gender = user.getGender();
        String bookings = user.getBookings();
        out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Booking Type</title>");     
            out.println("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css\">");
            out.println("<style type=\"text/css\">");
            out.println("#userlogin\n" +
"        {\n" +
"            position: absolute;\n" +
"            width: 350px;\n" +
"            height: 500px;\n" +
"            padding: 20px;\n" +
"            top: 50%;\n" +
"            left: 50%;\n" +
"            transform: translate(-50%,-50%);\n" +
"        }");
            out.println(".form\n" +
"        {\n" +
"            padding: 20px;\n" +
"        }");
            out.println(".pt-1\n" +
"        {\n" +
"            padding-top: 1rem;\n" +
"        }");
            out.println("</style>");
            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<section id=\"userlogin\">");
            out.println("<div class=\"card z-depth-3\">");
            out.println("<div class=\"card-panel center black darken-3\">");
            out.println("<span class=\"card-title white-text\"><b>"+name+"</b></span>");
            out.println("</div>");
            out.println("<form class=\"form\" action=\"HomePage\" method=\"get\">");
            out.println("<div>");
            out.println("<div class=\"input-field\">");
            out.println("<input type=\"text\" class=\"validate\" name=\"movieId\" value="+email+" readonly>");
            out.println("<label>Email ID</label>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div>");
            out.println("<div class=\"input-field\">");
            out.println("<input type=\"text\" class=\"validate\" name=\"movieId\" value="+password+" readonly>");
            out.println("<label>Password</label>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div>");
            out.println("<div class=\"input-field\">");
            out.println("<input type=\"text\" class=\"validate\" name=\"movieId\" value="+gender+" readonly>");
            out.println("<label>Gender</label>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div>");
            out.println("<div class=\"input-field\">");
            out.println("<input type=\"text\" class=\"validate\" name=\"movieId\" value="+dob+" readonly>");
            out.println("<label>Date Of Birth</label>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div>");
            out.println("<div class=\"input-field\">");
            out.println("<p class=\"validate\" name=\"movieId\"><b>Bookings: </b>"+bookings+"</p>");
//            out.println("<input type=\"text\" class=\"validate\" name=\"movieId\" value="+bookings+" readonly>");
//            out.println("<label>Bookings</label>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div class=\"center\">");
            out.println("<input type=\"submit\" value=\"HOME\" class=\"btn-large black darken-3\">");
            out.println("</div>");
            out.println("<div class=\"center pt-1\">");
            out.println("<a href=\"userloginpage.html\"><b>LOG OUT</b></a>");
            out.println("</div>");
            out.println("</form>");
            out.println("</div>");
            
            out.println("</section>");
            out.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js\"></script>");
            out.println("</body>");
            out.println("</html>");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
