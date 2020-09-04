import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/showFullImage")
public class showFullImage extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String un = request.getParameter("email");
        //String pw = request.getParameter("password");
        HttpSession session=request.getSession(false);
        String type=(String)session.getAttribute("type");
        String name1= request.getParameter("name1");
        String column= request.getParameter("column");
        String email= request.getParameter("email");
        String aim= request.getParameter("aim");
        PrintWriter out = response.getWriter();
        
        


        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Image</title>");
             out.println("<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">");
            out.println("<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Karma\">");
            out.println("<style>\n" +
"body,h1,h2,h3,h4,h5,h6 {font-family: \"Karma\", sans-serif}\n" +
".w3-bar-block .w3-bar-item {padding:20px}\n" +
"</style>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"srushti.css\">"); 
        out.println("<link href=\"formstyle.css\" rel=\"stylesheet\">");
        out.println("</head>");
         out.println("<body bgcolor='#5296F4'> ");
                        out.println("<header>\n" +
                                    "        <img src=\"logo1.png\"width=\"400px\" height=\"50px\">\n" +
                                    "</header>\n" +
                                    "\n" +
                                    "<ul class=\"navi\" >\n" +
                                    "  <div style=\"float:right\">\n" +
                                    "        <li class=\"kavi\"><a class=\"active\" href=\"#home\"><b style=\"font-size: 15px;\" >HOME</b></a></li>\n" +
                                    "        <li class=\"kavi\"><a href=\"#news\"><b style=\"font-size: 15px;\" >ABOUT US</b></a></li>\n" +
                              
                                    "        <li class=\"kavi\"><a href=\"#news\"><b style=\"font-size: 15px;\" >GALLARY</b></a></li>\n" +
                                 
                                    "        <li class=\"kavi\"><a href=\"#contact\"><b style=\"font-size: 15px;\" >CONTACT US</b></a></li>\n" +
                                 "        <li class=\"kavi\"><a href=\"logoutJava\"><b style=\"font-size: 15px;\" >LOGOUT</b></a></li>\n" +
                                    "    </div>\n" +
                                    "</ul>");

       
        if(column.equals("document")){
            out.println("<img src='pesonalDocument\\"+name1+"' style='width:800px;margin-left:280px;margin-top:50px;'><br><br>");
            out.println("<a href='ShowPersonalDocument?email="+email+"&aim="+aim+"'><input type='submit' value='GO BACK'  style='background:#e62e00;width:50% ;margin-left:25% ;margin-top:10px;padding:2px' ></a>");            

        }else{
            out.println("<img src='vehiclePic\\"+name1+"' style ='width:800px;margin-left:280px;margin-top:30px;'><br><br>");
            out.println("<a href='ShowVehicleJava?email="+email+"&aim="+aim+"'><input type='submit' value='GO BACK'  style='background:#e62e00;width:50% ;margin-left:25% ;margin-top:10px;padding:2px' ></a>");            
        }
        
        
      
        out.println("<footer>\n" +
"  <p>Copyright © 2019 TPS Tech.Pvt.Ltd., All Rights Reserved</p>\n" +
"</footer>");
        out.println("</body>");
        out.println("</html>");
        return;
    }

}