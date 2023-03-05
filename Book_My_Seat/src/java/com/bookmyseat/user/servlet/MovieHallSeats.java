
package com.bookmyseat.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bookmyseat.admin.dao.HallDAO;
import com.bookmyseat.admin.dao.MovieDAO;
import com.bookmyseat.admin.model.Hall;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MovieHallSeats", urlPatterns = {"/MovieHallSeats"})
public class MovieHallSeats extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        HttpSession s = request.getSession();
        String email = (String)s.getAttribute("email");
        s.setAttribute("email", email);
            if(request.getParameter("seattype")!=null && request.getParameter("numberofseats")!=null)
            {
                String seattype = request.getParameter("seattype");
                Integer numberofseats = Integer.parseInt(request.getParameter("numberofseats"));
                Integer movieId = Integer.parseInt(request.getParameter("movieId"));
                String sSeats = "", pSeats = "";
                out.println("id = "+movieId);
                out.println("seat type = "+seattype);
                out.println("numberofseats = "+numberofseats);
                String movieName = "Movie Booking";
                MovieDAO moviedao = new MovieDAO();
                HallDAO halldao = new HallDAO();
            try {
                movieName = moviedao.findMovieNameById(movieId);
            } catch (SQLException ex) {
                Logger.getLogger(MovieHallSeats.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MovieHallSeats.class.getName()).log(Level.SEVERE, null, ex);
            }
                if(seattype.equalsIgnoreCase("S") || seattype.equalsIgnoreCase("P"))
                {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Seat Selection</title>");      
            out.println("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css\">");
            out.println("<link href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css\" rel=\"stylesheet\">");
            out.println("<style type=\"text/css\">");
            out.println("#userlogin\n" +
"        {\n" +
"            position: absolute;\n" +
"            width: 1000px;\n" +
"            height: 1000px;\n" +
"            padding: 20px;\n" +
"            top: 80%;\n" +
"            left: 50%;\n" +
"            transform: translate(-50%,-50%);\n" +
"        }");
            out.println(".form\n" +
"        {\n" +
"            padding: 20px;\n" +
"        }");
            out.println("th\n" +
"        {\n" +
"            border: 1px solid black;\n" +
"        }");
            out.println(".button-54 {\n" +
"  font-family: \"Open Sans\", sans-serif;\n" +
"  font-size: 16px;\n" +
"  letter-spacing: 2px;\n" +
"  text-decoration: none;\n" +
"  text-transform: uppercase;\n" +
"  color: #000;\n" +
"  cursor: pointer;\n" +
"  border: 3px solid;\n" +
"  padding: 0.25em 0.5em;\n" +
"  box-shadow: 1px 1px 0px 0px, 2px 2px 0px 0px, 3px 3px 0px 0px, 4px 4px 0px 0px, 5px 5px 0px 0px;\n" +
"  position: relative;\n" +
"  user-select: none;\n" +
"  -webkit-user-select: none;\n" +
"  touch-action: manipulation;\n" +
"}");
            out.println(".button-54:active {\n" +
"  box-shadow: 0px 0px 0px 0px;\n" +
"  top: 5px;\n" +
"  left: 5px;\n" +
"}");
            out.println("@media (min-width: 768px) {\n" +
"  .button-54 {\n" +
"    padding: 0.25em 0.75em;\n" +
"  }\n" +
        "}");
            out.println("a\n" +
        "{\n" +
        "    color: black;\n" +
        "}");
            out.println(".pt-1\n" +
        "        {\n" +
        "            padding-top: 1rem;\n" +
            "        }");
            out.println("</style>");
            
            out.println("<script type=\"text/javascript\">");
            out.println("var arr = new Array();");
            out.println("function func1(id)");
            out.println("{");
            out.println("if(arr.length<"+numberofseats+")");
            out.println("{");
                 out.println("document.getElementById(id).disabled = true;");
                 out.println("arr.push(id);");
                 out.println("console.log(id);");
            out.println("}");
            out.println("else");
            out.println("{");
                out.println("alert(\"maximum seat count reached\");");
            out.println("}");
            out.println("}");
            out.println("function showSuccessfulBooking()");
            out.println("{");
            out.println("if(arr.length=="+numberofseats+")");
            out.println("{");
            out.println("var str = arr.toString(); ");
            out.println("alert('Congratulations! Your booking has been confirmed.');");
            out.println("window.location.replace(\"http://localhost:8181/Book_My_Seat/Submission?seatChoice=\"+str+\" &movieId="+movieId+"&numberofseats="+numberofseats+"&seatType="+seattype+"\");");
            out.println("}");
            out.println("}");
            out.println("</script>");
            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<section id=\"userlogin\">");
            out.println("<div class=\"card z-depth-3\">");
            out.println("<div class=\"card-panel center black darken-3\">");
            out.println("<span class=\"card-title white-text\">Please enter your choice</span>");
            out.println("</div>");
            if(seattype.equalsIgnoreCase("S"))
            {
                pSeats = "disabled";
                out.println("<table id=\"standardtable\">");
            out.println("<tr>");
            out.println("<th colspan=\"10\"><p class=\"center\"><b>"+movieName+"</b></p></th>");
            out.println("</tr>");
            out.println("<tr>");
            ArrayList <String>  list = new ArrayList<String>();
                try {
                    list = halldao.standardSeatAvailability(movieId);
                } catch (SQLException ex) {
                    Logger.getLogger(MovieHallSeats.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MovieHallSeats.class.getName()).log(Level.SEVERE, null, ex);
                }
                int counter = 1;
            for(int i = 0; i<list.size(); i++)
            {
                String status = list.get(i);
                if(status.equalsIgnoreCase("yes"))
                {
                    sSeats = "";
                    out.println("<th><button id=\"s"+(i+1)+"\" onclick=\"func1(id)\" "+sSeats+" ><i class=\"fas fa-chair\">&nbsp;s"+(i+1)+"</i></button></th>");
                }
                else
                {
                    sSeats = "disabled";
                    out.println("<th><button id=\"s"+(i+1)+"\" onclick=\"func1(id)\" "+sSeats+" ><i class=\"fas fa-chair\">&nbsp;s"+(i+1)+"</i></button></th>");
                }
                
                if(counter%10==0 && i<79)
                {
                    out.println("</tr>");
                    out.println("<tr>");
                }
                counter++;
            }
            out.println("</tr>");
            out.println("</table>");
            out.println("<table id=\"premiumtable\">");
            out.println("<tr>");
            out.println("<th rowspan=\"2\" colspan=\"5\" class=\"center\">");
            out.println("<button id=\"p1\" onclick=\"func1(id)\" "+pSeats+"><i class=\"fas fa-chair\">&nbsp;p1</i></button>&nbsp;");
            out.println("<button id=\"p2\" onclick=\"func1(id)\" "+pSeats+"><i class=\"fas fa-chair\">&nbsp;p2</i></a></button>&nbsp;");
            out.println("<button id=\"p3\" onclick=\"func1(id)\" "+pSeats+"><i class=\"fas fa-chair\">&nbsp;p3</i></a></button>&nbsp;");
            out.println("<button id=\"p4\" onclick=\"func1(id)\" "+pSeats+"><i class=\"fas fa-chair\">&nbsp;p4</i></a></button>&nbsp;");
            out.println("<button id=\"p5\" onclick=\"func1(id)\" "+pSeats+"><i class=\"fas fa-chair\">&nbsp;p5</i></a></button>");
            out.println("</th>");
            out.println("<th rowspan=\"2\" colspan=\"5\" class=\"center\">");
            out.println("<button id=\"p6\" onclick=\"func1(id)\" "+pSeats+"><i class=\"fas fa-chair\">&nbsp;p6</i></a></button>&nbsp;");
            out.println("<button id=\"p7\" onclick=\"func1(id)\" "+pSeats+"><i class=\"fas fa-chair\">&nbsp;p7</i></a></button>&nbsp;");
            out.println("<button id=\"p8\" onclick=\"func1(id)\" "+pSeats+"><i class=\"fas fa-chair\">&nbsp;p8</i></a></button>&nbsp;");
            out.println("<button id=\"p9\" onclick=\"func1(id)\" "+pSeats+"><i class=\"fas fa-chair\">&nbsp;p9</i></a></button>&nbsp;");
            out.println("<button id=\"p10\" onclick=\"func1(id)\" "+pSeats+"><i class=\"fas fa-chair\">&nbsp;p10</i></a></button>");
            out.println("</th>");
            out.println("</tr>");
            out.println("<tr></tr>");
            out.println("<tr>");
            out.println("<th rowspan=\"2\" colspan=\"5\" class=\"center\">");
            out.println("<button id=\"p11\" onclick=\"func1(id)\" "+pSeats+"><i class=\"fas fa-chair\">&nbsp;p11</i></a></button>&nbsp;");
            out.println("<button id=\"p12\" onclick=\"func1(id)\" "+pSeats+"><i class=\"fas fa-chair\">&nbsp;p12</i></a></button>&nbsp;");
            out.println("<button id=\"p13\" onclick=\"func1(id)\" "+pSeats+"><i class=\"fas fa-chair\">&nbsp;p13</i></a></button>&nbsp;");
            out.println("<button id=\"p14\" onclick=\"func1(id)\" "+pSeats+"><i class=\"fas fa-chair\">&nbsp;p14</i></a></button>&nbsp;");
            out.println("<button id=\"p15\" onclick=\"func1(id)\" "+pSeats+"><i class=\"fas fa-chair\">&nbsp;p15</i></a></button>");
            out.println("</th>");
            out.println("<th rowspan=\"2\" colspan=\"5\" class=\"center\">");
            out.println("<button id=\"p16\" onclick=\"func1(id)\" "+pSeats+"><i class=\"fas fa-chair\">&nbsp;p16</i></a></button>&nbsp;");
            out.println("<button id=\"p17\" onclick=\"func1(id)\" "+pSeats+"><i class=\"fas fa-chair\">&nbsp;p17</i></a></button>&nbsp;");
            out.println("<button id=\"p18\" onclick=\"func1(id)\" "+pSeats+"><i class=\"fas fa-chair\">&nbsp;p18</i></a></button>&nbsp;");
            out.println("<button id=\"p19\" onclick=\"func1(id)\" "+pSeats+"><i class=\"fas fa-chair\">&nbsp;p19</i></a></button>&nbsp;");
            out.println("<button id=\"p20\" onclick=\"func1(id)\" "+pSeats+"><i class=\"fas fa-chair\">&nbsp;p20</i></a></button>");
            out.println("</th>");
            out.println("</tr>");
            out.println("<tr></tr>");
            out.println("<tr>");
            out.println("<th colspan=\"10\"><p class=\"center\"><b>Seat type: STANDARD - Number of seats: "+numberofseats+"</b></p></th>");
            out.println("</tr>");
            out.println("</table>");
            }
            else
            {
                sSeats = "disabled";
                
                out.println("<table id=\"standardtable\">");
            out.println("<tr>");
            out.println("<th colspan=\"10\"><p class=\"center\"><b>"+movieName+"</b></p></th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th><button id=\"s1\" onclick=\"func1(id)\" "+sSeats+" ><i class=\"fas fa-chair\">&nbsp;s1</i></a></button></th>");
           out.println("<th><button id=\"s2\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s2</i></a></button></th>");
            out.println("<th><button id=\"s3\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s3</i></a></button></th>");
            out.println("<th><button id=\"s4\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s4</i></a></button></th>");
            out.println("<th><button id=\"s5\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s5</i></a></button></th>");
            out.println("<th><button id=\"s6\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s6</i></a></button></th>");
            out.println("<th><button id=\"s7\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s7</i></a></button></th>");
            out.println("<th><button id=\"s8\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s8</i></a></button></th>");
            out.println("<th><button id=\"s9\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s9</i></a></button></th>");
            out.println("<th><button id=\"s10\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s10</i></a></button></th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th><button id=\"s11\" onclick=\"func1(id)\" "+sSeats+" ><i class=\"fas fa-chair\">&nbsp;s11</i></a></button></th>");
           out.println("<th><button id=\"s12\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s12</i></a></button></th>");
            out.println("<th><button id=\"s13\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s13</i></a></button></th>");
            out.println("<th><button id=\"s14\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s14</i></a></button></th>");
            out.println("<th><button id=\"s15\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s15</i></a></button></th>");
            out.println("<th><button id=\"s16\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s16</i></a></button></th>");
            out.println("<th><button id=\"s17\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s17</i></a></button></th>");
            out.println("<th><button id=\"s18\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s18</i></a></button></th>");
            out.println("<th><button id=\"s19\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s19</i></a></button></th>");
            out.println("<th><button id=\"s20\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s20</i></a></button></th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th><button id=\"s21\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s21</i></a></button></th>");
           out.println("<th><button id=\"s22\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s22</i></a></button></th>");
            out.println("<th><button id=\"s23\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s23</i></a></button></th>");
            out.println("<th><button id=\"s24\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s24</i></a></button></th>");
            out.println("<th><button id=\"s25\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s25</i></a></button></th>");
            out.println("<th><button id=\"s26\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s26</i></a></button></th>");
            out.println("<th><button id=\"s27\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s27</i></a></button></th>");
            out.println("<th><button id=\"s28\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s28</i></a></button></th>");
            out.println("<th><button id=\"s29\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s29</i></a></button></th>");
            out.println("<th><button id=\"s30\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s30</i></a></button></th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th><button id=\"s31\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s31</i></a></button></th>");
           out.println("<th><button id=\"s32\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s32</i></a></button></th>");
            out.println("<th><button id=\"s33\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s33</i></a></button></th>");
            out.println("<th><button id=\"s34\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s34</i></a></button></th>");
            out.println("<th><button id=\"s35\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s35</i></a></button></th>");
            out.println("<th><button id=\"s36\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s36</i></a></button></th>");
            out.println("<th><button id=\"s37\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s37</i></a></button></th>");
            out.println("<th><button id=\"s38\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s38</i></a></button></th>");
            out.println("<th><button id=\"s39\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s39</i></a></button></th>");
            out.println("<th><button id=\"s40\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s40</i></a></button></th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th><button id=\"s41\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s41</i></a></button></th>");
           out.println("<th><button id=\"s42\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s42</i></a></button></th>");
            out.println("<th><button id=\"s43\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s43</i></a></button></th>");
            out.println("<th><button id=\"s44\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s44</i></a></button></th>");
            out.println("<th><button id=\"s45\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s45</i></a></button></th>");
            out.println("<th><button id=\"s46\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s46</i></a></button></th>");
            out.println("<th><button id=\"s47\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s47</i></a></button></th>");
            out.println("<th><button id=\"s48\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s48</i></a></button></th>");
            out.println("<th><button id=\"s49\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s49</i></a></button></th>");
            out.println("<th><button id=\"s50\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s50</i></a></button></th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th><button id=\"s51\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s51</i></a></button></th>");
           out.println("<th><button id=\"s52\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s52</i></a></button></th>");
            out.println("<th><button id=\"s53\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s53</i></a></button></th>");
            out.println("<th><button id=\"s54\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s54</i></a></button></th>");
            out.println("<th><button id=\"s55\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s55</i></a></button></th>");
            out.println("<th><button id=\"s56\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s56</i></a></button></th>");
            out.println("<th><button id=\"s57\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s57</i></a></button></th>");
            out.println("<th><button id=\"s58\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s58</i></a></button></th>");
            out.println("<th><button id=\"s59\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s59</i></a></button></th>");
            out.println("<th><button id=\"s60\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s60</i></a></button></th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th><button id=\"s71\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s61</i></a></button></th>");
           out.println("<th><button id=\"s72\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s62</i></a></button></th>");
            out.println("<th><button id=\"s73\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s63</i></a></button></th>");
            out.println("<th><button id=\"s74\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s64</i></a></button></th>");
            out.println("<th><button id=\"s75\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s65</i></a></button></th>");
            out.println("<th><button id=\"s76\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s66</i></a></button></th>");
            out.println("<th><button id=\"s77\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s67</i></a></button></th>");
            out.println("<th><button id=\"s78\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s68</i></a></button></th>");
            out.println("<th><button id=\"s79\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s69</i></a></button></th>");
            out.println("<th><button id=\"s70\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s70</i></a></button></th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th><button id=\"s71\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s71</i></a></button></th>");
           out.println("<th><button id=\"s72\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s72</i></a></button></th>");
            out.println("<th><button id=\"s73\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s73</i></a></button></th>");
            out.println("<th><button id=\"s74\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s74</i></a></button></th>");
            out.println("<th><button id=\"s75\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s75</i></a></button></th>");
            out.println("<th><button id=\"s76\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s76</i></a></button></th>");
            out.println("<th><button id=\"s77\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s77</i></a></button></th>");
            out.println("<th><button id=\"s78\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s78</i></a></button></th>");
            out.println("<th><button id=\"s79\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s79</i></a></button></th>");
            out.println("<th><button id=\"s80\" onclick=\"func1(id)\" "+sSeats+"><i class=\"fas fa-chair\">&nbsp;s80</i></a></button></th>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<table id=\"premiumtable\">");
            out.println("<tr>");
            out.println("<th rowspan=\"2\" colspan=\"5\" class=\"center\">");
            ArrayList <String>  list = new ArrayList<String>();
                try {
                    list = halldao.premiumSeatAvailability(movieId);
                } catch (SQLException ex) {
                    Logger.getLogger(MovieHallSeats.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MovieHallSeats.class.getName()).log(Level.SEVERE, null, ex);
                }
                int counter = 1;
            for(int i = 0; i<list.size(); i++)
            {
                String status = list.get(i);
                if(status.equalsIgnoreCase("yes"))
                {
                    pSeats = "";
                    out.println("<button id=\"p"+(i+1)+"\" onclick=\"func1(id)\" "+pSeats+"><i class=\"fas fa-chair\">&nbsp;p"+(i+1)+"</i></button>&nbsp;");
                }
                else
                {
                    pSeats = "disabled";
                    out.println("<button id=\"p"+(i+1)+"\" onclick=\"func1(id)\" "+pSeats+"><i class=\"fas fa-chair\">&nbsp;p"+(i+1)+"</i></button>&nbsp;");
                }
                
                
                if(counter==5 || counter ==15)
                {
                    out.println("</th>");
                    out.println("<th rowspan=\"2\" colspan=\"5\" class=\"center\">");
                }
                if(counter==10)
                {
                    out.println("</th>");
                    out.println("</tr>");
                    out.println("<tr></tr>");
                    out.println("<tr>");
                    out.println("<th rowspan=\"2\" colspan=\"5\" class=\"center\">");
                }    
                counter++;
            }
            out.println("</th>");
            out.println("</tr>");
            out.println("<tr></tr>");
            out.println("<tr>");
            
//            out.println("<th colspan=\"10\"><p class=\"center\">Namaste</p></th>");
            out.println("</tr>");
            out.println("</table>");
            }
            out.println("<div class=\"center pt-1\">");
            out.println("<button  class=\"button-54\" onclick=\"showSuccessfulBooking()\"  >BOOK</button>");
            // role=\"button\"
            out.println("</div>");
            out.println("</div>");
            out.println("</section>");
            out.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js\"></script>");
            out.println("</body>");
            out.println("</html>");  
                }
                else
                {
                    response.getWriter().println("<h1>Invalid seat choice</h1>");
                }
           }
            else
            {
                response.getWriter().println("<h1>Please fill all the fields</h1>");
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
            throws ServletException, IOException 
    {
            
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
