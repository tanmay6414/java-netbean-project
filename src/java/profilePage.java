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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/profilePage")
public class profilePage extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String un = request.getParameter("email");
        //String pw = request.getParameter("password");
        //String email="sdpokarkar@mitaoe.ac.in";
        HttpSession session=request.getSession(false);
        String email=(String)session.getAttribute("email");
        PrintWriter out = response.getWriter();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/asdl", "root", "root"); // gets a new connection

            PreparedStatement ps = c.prepareStatement("select * from info where email=?");
            ps.setString(1, email);
            //ps.setString(2, pw);
            
            

            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            //out.println("<img src='/pesonalDocument/document_11_living 12th.jpg'>");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Vehicles Document</title>"); 
               out.println("<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">");
            out.println("<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Karma\">");
            out.println("<style>\n" +
                            "body,h1,h2,h3,h4,h5,h6 {font-family: \"Karma\", sans-serif}\n" +
                            ".w3-bar-block .w3-bar-item {padding:20px}\n" +
                        "</style>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"srushti.css\">"); 
            out.println("</head>");
            
            out.println("<body bgcolor='#5296F4'> ");
                        out.println("<header>\n" +
                                    "        <img src=\"logo1.png\"width=\"400px\" height=\"50px\">\n" +
                                    "</header>\n" +
                                    "\n" +
                                    "<ul class=\"navi\" >\n" +
                                    "  <div style=\"float:right\">\n" +
                                    "        <li class=\"kavi\"><a  href=\"homePage.jsp\"><b style=\"font-size: 15px;\" >HOME</b></a></li>\n" +
                                                                        "        <li class=\"kavi\"><a href=\"logoutJava\"><b style=\"font-size: 15px;\" >LOGOUT</b></a></li>\n" +
                                    "    </div>\n" +
                                    "</ul>");
           
            
            
            
 
            int j=0;
          
            while (rs.next()) {
                j+=1;
                if(j==0){
                    response.sendRedirect("PersonalInfo.html"); 
                }else{
                out.println(" <b>");
                out.println("<div style='padding:10px;background:yellow'><table style ='margin-left:50px' ><tr><td>");
                out.println("<img src='propic\\"+rs.getString(7)+"' style='width:250px;height:250px;border-radius:20px'>");
                out.println("</td>");
                
                out.println("<td>");
                out.println("<span style='font-family:Impact; font-size:50px'>Name - "+rs.getString(8)+"</span>");
                out.println("<br><span style=' font-size:20px'>Email - "+rs.getString(1)+"</span>");
                out.println("<br><span style=' font-size:20px'>Address - "+rs.getString(2)+"</span>");
                out.println("<br><span style=' font-size:20px'>"+rs.getString(3)+", "+rs.getString(4)+"</span>");
                out.println("<br><span style=' font-size:20px'>Pincode - "+rs.getString(6)+"</span>");
                out.println("<br><br><br><br></td></tr></table></div>");
                
                out.println("<div style='margin-top:90px;background:yellow;padding:10px'>");
                out.println("<a href='VehicleDocument.html'><button style='background-color:#3A5FC1;border: none;color: white;width:90%;padding: 5px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;margin: 4px 2px;cursor: pointer;border-radius:5px;margin-left:50px' >Add Vehicle Document</button></a>");
                out.println("<a href='ShowPersonalDocument?email="+rs.getString(1)+"&aim=self'><button style='background-color:#3A5FC1;border: none;color: white;width:45%;padding: 5px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;margin: 4px 2px;cursor: pointer;border-radius:5px;margin-left:50px'>View Personal Document</button></a>");
                out.println("<a href='ShowVehicleJava?email="+rs.getString(1)+"&aim=self'><button style='background-color:#3A5FC1;border: none;color: white;width:45%;padding: 5px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;margin: 4px 2px;cursor: pointer;border-radius:5px'>View vehicle Document</button></a>");
                out.println("</div>");
                }
            }
            if(j==0){
                    response.sendRedirect("PersonalInfo.html"); 
                }
            
                
            out.println("<br><footer>\n" +
"  <p>Copyright © 2019 TPS Tech.Pvt.Ltd., All Rights Reserved</p>\n" +
"</footer>");
            out.println("</body>");
            out.println("</html>");
            return;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        
    }

}