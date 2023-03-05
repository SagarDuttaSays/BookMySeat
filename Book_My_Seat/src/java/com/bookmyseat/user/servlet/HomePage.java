package com.bookmyseat.user.servlet;

import com.bookmyseat.admin.dao.MovieDAO;
import com.bookmyseat.admin.model.Movie;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "HomePage", urlPatterns = {"/HomePage"})
public class HomePage extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            MovieDAO moviedao = new MovieDAO(); 
            ArrayList <Movie> list = moviedao.displayMovie();
            HttpSession s = request.getSession();
            String email = (String)s.getAttribute("email");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
            out.println("<title>Home Page</title>");
            out.println("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css\">");
            out.println("<style type=\"text/css\">");
            out.println("#moviegrid {");
            out.println("position: absolute;");
            out.println("width: 1000px;");
            out.println("height: 1000px;");
            out.println("padding: 20px;");
            out.println("top: 80%;");
            out.println("left: 50%;");
            out.println("transform: translate(-50%,-50%); }");
            out.println("</style>");
            out.println("<link href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css\" rel=\"stylesheet\">");
            out.println("</head>");
            
            out.println("<body>");
            out.println("<marquee style=\"background-color: black; color: white;\" >Welcome to BookMySeat.com</marquee>");
            out.println("<button style=\"margin: 5px; \"><a style=\"text-decoration: none; color: black;\" href=\"http://localhost:8181/Book_My_Seat/Profile?email="+email+"\"><i class=\"fas fa-user\"></i></a></button>");
            
            out.println("<section id=\"moviegrid\">");
            out.println("<div class=\"card z-depth-3\">");
            out.println("<div class=\"card-panel center black darken-3\">");
            out.println("<span class=\"card-title white-text\"><i class=\"fas fa-video\"></i>&nbsp;&nbsp;SELECT A MOVIE</span>");
            out.println("</div>");
            out.println("<form class=\"form\" action=\"SeatTypeAndNumber\" method=\"post\">");
            out.println("<table>");
            out.println("<tr>");
            int c = 1;
            System.out.println(list);
            for(Movie movie: list)
            {
                System.out.println(movie.getName());
                if(c<=3)
//                    out.println("<th class=\"center\"><a href='SeatTypeAndNumber?movieId="+movie.getId()+"'>"+movie.getName()+"</a></th>");
                    out.println("<th class=\"center\"><div class=\"row center\">\n" +
"    <div class=\"col s12 m7\">\n" +
"      <div class=\"card small center\" style=\"width:250px; height: 500px;\">\n" +
"        <div class=\"card-image\">\n" +
"          <img src=\""+movie.getPoster()+"\" style=\"width: 250px; height: 350px;\">\n" +
"          <span class=\"card-title\"><b>"+movie.getName()+"</b></span>\n" +
"        </div>\n" +
"        <div class=\"card-content\">\n" +
"          <p><b>"+movie.getDescription()+"</b></p>\n" +
"        </div>\n" +
"        <div class=\"card-action\">\n" +
"          <a target=\"_blank\" href=\""+movie.getTrailer()+"\"><b>TRAILER</b></a>\n" +
"          &nbsp;&nbsp;\n" +
"          <a href='SeatTypeAndNumber?movieId="+movie.getId()+"'><b>BOOK</b></a>\n" +
"        </div>\n" +
"      </div>\n" +
"    </div>\n" +
"  </div></th>");
                if(c==3)
                {
                    out.println("</tr>");
                    out.println("<tr>");
                }
                else if (c>3)
                    out.println("<th class=\"center\"><div class=\"row center\">\n" +
"    <div class=\"col s12 m7\">\n" +
"      <div class=\"card small center\" style=\"width:250px; height: 500px;\">\n" +
"        <div class=\"card-image\">\n" +
"          <img src=\""+movie.getPoster()+"\" style=\"width: 250px; height: 350px;\">\n" +
"          <span class=\"card-title\"><b>"+movie.getName()+"</b></span>\n" +
"        </div>\n" +
"        <div class=\"card-content\">\n" +
"          <p><b>"+movie.getDescription()+"</b></p>\n" +
"        </div>\n" +
"        <div class=\"card-action\">\n" +
"          <a target=\"_blank\" href=\""+movie.getTrailer()+"\"><b>TRAILER</b></a>\n" +
"          &nbsp;&nbsp;\n" +
"          <a href='SeatTypeAndNumber?movieId="+movie.getId()+"'><b>BOOK</b></a>\n" +
"        </div>\n" +
"      </div>\n" +
"    </div>\n" +
"  </div></th>");
                c++;
            }
            out.println("</tr>");
            out.println("</table>");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
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
