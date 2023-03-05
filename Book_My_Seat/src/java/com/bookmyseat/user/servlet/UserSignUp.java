/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookmyseat.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bookmyseat.user.dao.UserDAO;
import com.bookmyseat.user.model.User;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author hp-pc
 */
@WebServlet(name = "UserSignUp", urlPatterns = {"/UserSignUp"})
public class UserSignUp extends HttpServlet {

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
                if(request.getParameter("name")!=null && request.getParameter("name")!=null && request.getParameter("email")!=null && request.getParameter("password")!=null && request.getParameter("gender")!=null && request.getParameter("dob")!=null )
       {
           response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String password = request.getParameter("password");
        String dob = request.getParameter("dob");
        UserDAO userdao = new UserDAO();
        int id=0;
                    try {
                        id = 1 + userdao.lastId();
                    } catch (SQLException ex) {
                        Logger.getLogger(UserSignUp.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(UserSignUp.class.getName()).log(Level.SEVERE, null, ex);
                    }
        User user = new User (id, name, email, dob, gender, password);
        out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>User Sign up</title>");     
            out.print("<script>");
                    try {
                        if(userdao.validityOfEmail(email))
                        {
                            if(userdao.AddUser(user))
                            {
                                out.print("function success()");
                                out.print("{");
                                out.print("alert(\"Registration successful\")");
                                out.print("}");
                                out.print("success()");
                                response.sendRedirect("userloginpage.html");
                            }
                            else
                            {
                                out.print("function success()");
                                out.print("{");
                                out.print("alert(\"Registration failed\")");
                                out.print("}");
                                out.print("success()");
                            }
                        }
                        else
                        {
                            out.print("function success()");
                            out.print("{");
                            out.print("alert(\"Email ID already in use!\")");
                            out.print("}");
                            out.print("success()");
                        }       } catch (ClassNotFoundException ex) {
                        Logger.getLogger(UserSignUp.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(UserSignUp.class.getName()).log(Level.SEVERE, null, ex);
                    }
            out.print("</script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<button class=\"center\"><a href=\"usersignup.html\">Reload</a></button>");
            out.println("</body>");
            out.println("</html>");
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
