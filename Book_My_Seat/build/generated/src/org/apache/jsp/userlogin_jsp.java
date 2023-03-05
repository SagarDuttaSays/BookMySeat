package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class userlogin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>USER LOGIN</title>\n");
      out.write("        <!-- Compiled and minified CSS -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css\">\n");
      out.write("    <style type=\"text/css\">\n");
      out.write("        #userlogin\n");
      out.write("        {\n");
      out.write("            position: absolute;\n");
      out.write("            width: 350px;\n");
      out.write("            height: 500px;\n");
      out.write("            padding: 20px;\n");
      out.write("            top: 50%;\n");
      out.write("            left: 50%;\n");
      out.write("            transform: translate(-50%,-50%);\n");
      out.write("        }\n");
      out.write("        .form\n");
      out.write("        {\n");
      out.write("            padding: 20px;\n");
      out.write("        }\n");
      out.write("        .pt-1\n");
      out.write("        {\n");
      out.write("            padding-top: 1rem;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <section id=\"userlogin\">\n");
      out.write("            <div class=\"card z-depth-3\">\n");
      out.write("                <div class=\"card-panel center light-blue darken-3\">\n");
      out.write("                    <span class=\"card-title white-text\">User Login</span>\n");
      out.write("                </div>\n");
      out.write("                <form class=\"form\">\n");
      out.write("                    <div class=\"input-field\">\n");
      out.write("                        <input type=\"email\" class=\"validate\">\n");
      out.write("                        <label>Email</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"input-field \">\n");
      out.write("                        <input type=\"password\" class=\"validate\">\n");
      out.write("                        <label>Password</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"center\">\n");
      out.write("                        <button type=\"submit\" class=\"btn-large light-blue darken-3\">Sign-in</button>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"center pt-1\">\n");
      out.write("                        <a href=\"#\">Forget Password</a>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("        \n");
      out.write("        <!-- Compiled and minified JavaScript -->\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js\"></script>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
