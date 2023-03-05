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
import com.bookmyseat.admin.dao.HallDAO;
import com.bookmyseat.admin.model.Hall;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
/**
 *
 * @author hp-pc
 */
@WebServlet(name = "Submission", urlPatterns = {"/Submission"})
public class Submission extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        
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
        response.setContentType("text/html;charset=UTF-8");
        HttpSession s = request.getSession();
        String email = (String)s.getAttribute("email");
        PrintWriter out = response.getWriter();
        int movieId = Integer.parseInt(request.getParameter("movieId"));
        int numberofseats = Integer.parseInt(request.getParameter("numberofseats"));
        String seatChoice = request.getParameter("seatChoice");
        String seatType = request.getParameter("seatType");
        String arr [] = seatChoice.split(",");
        
        HallDAO halldao = new HallDAO();

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Submission</title>");            
            out.println("</head>");
            out.println("movieId = "+movieId);
            out.println("numberofseats = "+numberofseats);
            out.println("seatChoice = "+seatChoice);
            out.println("seatType = "+seatType);
            out.println("<body>");
            out.println("<h1>Servlet Submission at " + request.getContextPath() + "</h1>");
                    if(seatType.equalsIgnoreCase("S"))
        {
            try {
                if(halldao.bookStandardSeat(movieId, arr, email))
                    response.sendRedirect("HomePage");
                else
                    response.getWriter().println("<h1>Booking Failed</h1>");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Submission.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Submission.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            try {
                if(halldao.bookPremiumSeat(movieId, arr, email))
                    response.sendRedirect("HomePage");
                else
                    response.getWriter().println("<h1>Booking Failed</h1>");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Submission.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Submission.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Submission.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Submission.class.getName()).log(Level.SEVERE, null, ex);
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
