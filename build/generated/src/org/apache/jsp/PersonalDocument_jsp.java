package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class PersonalDocument_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("<title>Home</title>\n");
      out.write("<meta charset=\"utf-8\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Karma\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"srushti.css\">\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body bgcolor=#5296F4>\n");
      out.write("\n");
      out.write("<header>\n");
      out.write("        <img src=\"logo1.png\" width=\"400px\" height=\"50px\">\n");
      out.write("</header>\n");
      out.write("<div style=\"float:right\">\n");
      out.write("     \n");
      out.write("<ul class=\"navi\" >\n");
      out.write("        <li class=\"kavi\"><a  href=\"homePage.jsp\"><b style=\"font-size: 15px;\" >HOME</b></a></li>\n");
      out.write("        <li class=\"kavi\"><a href=\"profilePage\"><b style=\"font-size: 15px;\" >PROFILE</b></a></li>\n");
      out.write("        <li class=\"kavi\"><a href=\"logoutJava\"><b style=\"font-size: 15px;\" >LOGOUT</b></a></li>\n");
      out.write("</ul>\n");
      out.write("   \n");
      out.write(" </div>\n");
      out.write("<div class=\"container-fluid\">\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <div id=\"head\" class=\"row\">\n");
      out.write("    <div class=\"col-xs-6\">\n");
      out.write("    <div style=\"float:left\">\n");
      out.write("\n");
      out.write(" </div>\n");
      out.write(" </div>\n");
      out.write("    <div class=\"col-xs-6\"></div>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    <br>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <div id=\"info\">\n");
      out.write("    \n");
      out.write("  <div id=\"sru\">\n");
      out.write("\n");
      out.write("      \n");
      out.write("      <span style=\"color:black\">\n");
      out.write("        <h1>Fill out your information</h1>\n");
      out.write("        <form enctype=\"multipart/form-data\" action=\"PersonalDocumentJava\" method=\"post\">\n");
      out.write("                <input type=\"hidden\" name=\"email\" placeholder=\"Email\" required><br><br>\n");
      out.write("                <input type=\"text\" name=\"adharno\" placeholder=\"Adhar Card No\" required><br><br>\n");
      out.write("                \n");
      out.write("                Aadhaar Card Pic : <input type=\"file\" class=\"button\" name=\"adharpic\" required><br><br>\n");
      out.write("                \n");
      out.write("                <input type=\"text\" name=\"voteridno\" placeholder=\"Voter Id No\" required><br><br>\n");
      out.write("                \n");
      out.write("                Voter ID Pic : <input type=\"file\" class=\"button\" name=\"voteridpic\" required><br><br>\n");
      out.write("                \n");
      out.write("                <input type=\"text\" name=\"panno\" placeholder=\"PAN Card No\" required><br><br>\n");
      out.write("                \n");
      out.write("                PAN Card Pic : <input type=\"file\" class=\"button\" name=\"panpic\" required><br><br>\n");
      out.write("                \n");
      out.write("                <input type=\"text\" name=\"drivinglicenceno\" placeholder=\"Driving Licence No\" required><br><br>\n");
      out.write("                \n");
      out.write("                Driving License Pic : <input type=\"file\" class=\"button\" name=\"drivinglicencepic\" required><br><br>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                Driving License  Pic : <input type=\"date\"  name=\"drivinglicenceupto\" required><br><br>\n");
      out.write("                \n");
      out.write("                <input type=\"submit\" class=\"button\" name=\"submitinfo\"><br><br>\n");
      out.write("        </form>\n");
      out.write("        <a href=\"profilePage\"><button style=\"background-color:#3A5FC1;border: none;color: white;width:100%;padding: 5px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;margin: 4px 2px;cursor: pointer;border-radius:5px\">Go Back</button></a>\n");
      out.write("      </span>\n");
      out.write("  </div>\n");
      out.write("  <br><br>\n");
      out.write("<footer>\n");
      out.write("  <p>Copyright © 2019 TPS Tech.Pvt.Ltd., All Rights Reserved</p>\n");
      out.write("</footer>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
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
