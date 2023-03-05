
package com.bookmyseat.user.servlet;

import com.bookmyseat.user.dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "UserLogin", urlPatterns = {"/UserLogin"})
public class UserLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
       response.setContentType("text/html;charset=UTF-8");
        out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>check 1 2 3</h1>");
        if(request.getParameter("email")!=null && request.getParameter("password")!=null)
            {
                System.out.println("fields are not empty");
                String email = request.getParameter("email");
                String pwd = request.getParameter("password");
                System.out.println("email = "+email);
                System.out.println("password = "+pwd);
                UserDAO ud = new UserDAO();
           try {
               if(ud.authentication(email, pwd))
               {
                   System.out.println("email password verified");
                   out.println("<h1>Welcome to bbokmyseat.</h1>");
                   HttpSession hs= request.getSession();
                    hs.setAttribute("email", email);
                   response.sendRedirect("HomePage");
               }
               else
               {
                   response.getWriter().println("<h1>Login Fail</h1>");
               }
           } catch (SQLException ex) {
               Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
           }
            }
            
            out.println("</body>");
            out.println("</html>"); 
    }

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}


