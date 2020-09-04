package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class homePage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>MAIN HOME PAGE</title>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Inconsolata\">\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Amatic+SC\">\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Montserrat\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("<style>\n");
      out.write("body, html {\n");
      out.write("  height: 100%;\n");
      out.write("  font-family: \"Inconsolata\", sans-serif;\n");
      out.write("}\n");
      out.write("\n");
      out.write("/*.bgimg {\n");
      out.write("  background-position: center;\n");
      out.write("  background-size: cover;\n");
      out.write("  background-image: url(\"D:/SDL_PROJECT/slide_1.jpg\");\n");
      out.write("  min-height: 75%;\n");
      out.write("}*/\n");
      out.write("\n");
      out.write(".menu {\n");
      out.write("  display: none;\n");
      out.write("}\n");
      out.write("\n");
      out.write("footer {\n");
      out.write("    background-color: #3A5FC1;\n");
      out.write("    padding: 1px;\n");
      out.write("    text-align: center;\n");
      out.write("    color: white;\n");
      out.write("    font-size:10px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("header {\n");
      out.write("    background-color:#F5F5F5;\n");
      out.write("    padding: 1px;\n");
      out.write("    text-align: left;\n");
      out.write("    font-size:13px;\n");
      out.write("    color:#666;\n");
      out.write("}\n");
      out.write("ul.navi {\n");
      out.write("    list-style-type: none;\n");
      out.write("    margin: 0;\n");
      out.write("    padding: 0;\n");
      out.write("    overflow: hidden;\n");
      out.write("    background-color:#3A5FC1;\n");
      out.write("}\n");
      out.write("\n");
      out.write("li.kavi {\n");
      out.write("    float: left;\n");
      out.write("}\n");
      out.write("\n");
      out.write("li a {\n");
      out.write("    display: block;\n");
      out.write("    color: white;\n");
      out.write("    text-align: center;\n");
      out.write("    padding: 10px 16px;\n");
      out.write("    text-decoration: none;\n");
      out.write("}\n");
      out.write("\n");
      out.write("li a:hover:not(.active) {\n");
      out.write("    background-color: #CA175C;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".active {\n");
      out.write("    background-color:red;\n");
      out.write("}\n");
      out.write("\n");
      out.write("</style>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<header>\n");
      out.write("        <img src=\"logo1.png\" width=\"300px\" height=\"80px\">\n");
      out.write("</header>\n");
      out.write("\n");
      out.write(" \n");
      out.write("\n");
      out.write("<ul class=\"navi\" >\n");
      out.write(" <div style=\"float:right\">\n");
      out.write("        <li class=\"kavi\"><a class=\"active\" href=\"#home\"><b style=\"font-size: 20px;\" >HOME</b></a></li>\n");
      out.write("        <li class=\"kavi\"><a href=\"homePage.jsp\" ><b style=\"font-size: 20px;\" >ABOUT US</b></a></li>\n");
      out.write("        \n");
      out.write("        <li class=\"kavi\"><a href=\"#contact\"><b style=\"font-size: 20px;\" >CONTACT US</b></a></li>\n");
      out.write("        <li class=\"kavi\"><a href=\"#logout\"><b style=\"font-size: 20px;\" >LOGOUT</b></a></li>\n");
      out.write(" </div>\n");
      out.write("</ul>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- Links (sit on top) -->\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- Header with image -->\n");
      out.write("<header class=\"bgimg w3-display-container w3-grayscale-min\" id=\"home\">\n");
      out.write(" <!-- <div class=\"w3-display-bottomleft w3-center w3-padding-large w3-hide-small\">\n");
      out.write("    <span class=\"w3-tag\">Open from 6am to 5pm</span>\n");
      out.write("  </div>\n");
      out.write("  <div class=\"w3-display-middle w3-center\">-->\n");
      out.write("   \n");
      out.write("<div class=\"slideshow-container\">\n");
      out.write("\n");
      out.write("<div class=\"mySlides fade\">\n");
      out.write(" \n");
      out.write("  <img src=\"slide_1.jpg\" style=\"width:100%\">\n");
      out.write("  \n");
      out.write("  \n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"mySlides fade\">\n");
      out.write(" \n");
      out.write("  <img src=\"slide_2.jpg\" style=\"width:100%\">\n");
      out.write("  \n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"mySlides fade\">\n");
      out.write("  \n");
      out.write("  <img src=\"bg_img.jpg\" style=\"width:100%\">\n");
      out.write(" \n");
      out.write("</div>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("<br>\n");
      out.write("\n");
      out.write("<div style=\"text-align:center\">\n");
      out.write("  <span class=\"dot\"></span> \n");
      out.write("  <span class=\"dot\"></span> \n");
      out.write("  <span class=\"dot\"></span> \n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"w3-display-middle w3-center\">\n");
      out.write("    <span class=\"w3-text-white\" style=\"font-size:90px\">WELCOME TO OUR <br>WEBSITE</span>\n");
      out.write("</div>\n");
      out.write(" \n");
      out.write("</header>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("var slideIndex = 0;\n");
      out.write("showSlides();\n");
      out.write("\n");
      out.write("function showSlides() {\n");
      out.write("  var i;\n");
      out.write("  var slides = document.getElementsByClassName(\"mySlides\");\n");
      out.write("  var dots = document.getElementsByClassName(\"dot\");\n");
      out.write("  for (i = 0; i < slides.length; i++) {\n");
      out.write("    slides[i].style.display = \"none\";  \n");
      out.write("  }\n");
      out.write("  slideIndex++;\n");
      out.write("  if (slideIndex > slides.length) {slideIndex = 1}    \n");
      out.write("  for (i = 0; i < dots.length; i++) {\n");
      out.write("    dots[i].className = dots[i].className.replace(\" active\", \"\");\n");
      out.write("  }\n");
      out.write("  slides[slideIndex-1].style.display = \"block\";  \n");
      out.write("  dots[slideIndex-1].className += \" active\";\n");
      out.write("  setTimeout(showSlides, 5000); // Change image every 2 seconds\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("<!-- About Container -->\n");
      out.write("<div class=\"w3-container w3-padding-64 w3-white w3-grayscale w3-xlarge\" id=\"about\">\n");
      out.write("  <div class=\"w3-content\">\n");
      out.write("    <h1 class=\"w3-center w3-jumbo\" style=\"margin-bottom:64px\">About Us</h1>\n");
      out.write("    <p align=\"justify\">All over the world, as per the Motor Vehicles Act of the respective countries, it is compulsory to that citizens always carry the original hard copy of documents like (Registration certificates book, vehicle pollution under control, certificate vehicle Insurance policy). Many times citizens do not remember to carry the vehicle-related documents. When traffic police wanted to verify citizens documents at that time citizens need to carry these documents with them otherwise they need to face consequences.Improving Transparency in system and lots of time should be saved.</p>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- Contact -->\n");
      out.write(" \n");
      out.write("\n");
      out.write("<div class=\"w3-padding-32 w3-content \" id=\"contact\" >\n");
      out.write("   \n");
      out.write("    <hr class=\"w3-opacity\">\n");
      out.write("\n");
      out.write("\n");
      out.write("    <font face=\"verdana\" color=\"black\" size=\"3\">\n");
      out.write("    <div style=\"margin-left: 180px;width:600px;background:yellow;padding:40px;border-radius:20px\">\n");
      out.write("    \t<h1  style=\"margin-bottom:64px;margin-left: 200px;font-family:Impact;\">Contact</h1>\n");
      out.write("    \t<p>\n");
      out.write("            <b>Find us at some address at some place or call us at 05050515-122330<br><br>\n");
      out.write("    \t\tPermenent Address<br>\n");
      out.write("    \t\tChurch Road, Camp, Pune - 411001,<br> Near Sadhu Vaswani Chowk,<br> Opposite Nuclius Mall (Map)<br>0120456789\n");
      out.write("                </b>\n");
      out.write("        </p>\n");
      out.write("    </div>\n");
      out.write("    </font>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  \n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- Footer -->\n");
      out.write("<br><br>\n");
      out.write("<footer>\n");
      out.write("  <p>Copyright © 2019 TPS Tech.Pvt.Ltd., All Rights Reserved</p>\n");
      out.write("</footer>\n");
      out.write("</body>\n");
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
