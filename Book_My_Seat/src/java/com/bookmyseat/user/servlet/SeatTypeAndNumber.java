
package com.bookmyseat.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SeatTypeAndNumber", urlPatterns = {"/SeatTypeAndNumber"})
public class SeatTypeAndNumber extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession s = request.getSession();
        String email = (String)s.getAttribute("email");
        s.setAttribute("email", email);
        try (PrintWriter out = response.getWriter()) {
            int movieId = Integer.parseInt(request.getParameter("movieId"));
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
            out.println("</style>");
            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<section id=\"userlogin\">");
            out.println("<div class=\"card z-depth-3\">");
            out.println("<div class=\"card-panel center black darken-3\">");
            out.println("<span class=\"card-title white-text\">Please enter your choice</span>");
            out.println("</div>");
            out.println("<form class=\"form\" action=\"MovieHallSeats\" method=\"get\">");
            out.println("<div>");
            out.println("<div class=\"input-field\">");
            out.println("<input type=\"text\" class=\"validate\" name=\"movieId\" value="+request.getParameter("movieId")+" readonly>");
            out.println("<label>Movie Id</label>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div>");
            out.println("<div class=\"input-field\">");
            out.println("<input type=\"text\" class=\"validate\" name=\"seattype\" placeholder=\"S for Standard and P for Premium\" required>");
            out.println("<label>Seat Type</label>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div class=\"input-field\">");
            out.println("<input type=\"number\" class=\"validate\" min=\"1\" max=\"10\" name=\"numberofseats\" placeholder=\"Choose between 1 to 10\" required>");
            out.println("<label>Number of seats</label>");
            out.println("</div>");
            out.println("<div class=\"center\">");
            out.println("<input type=\"submit\" value=\"submit\" class=\"btn-large black darken-3\">");
            out.println("</div>");
            out.println("</form>");
            out.println("</div>");
            out.println("</section>");
            out.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js\"></script>");
            out.println("</body>");
            out.println("</html>");
        }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
