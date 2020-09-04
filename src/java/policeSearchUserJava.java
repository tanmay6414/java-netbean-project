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


@WebServlet("/policeSearchUserJava")
public class policeSearchUserJava extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String un = request.getParameter("email");
        //String pw = request.getParameter("password");
        String email = request.getParameter("searchUser");
        PrintWriter out = response.getWriter();
// Connect to mysql(mariadb) and verify username password

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/asdl", "root", "root"); // gets a new connection
            PreparedStatement ps = c.prepareStatement("select * from reg where email=?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            
            
            PreparedStatement ps1 = c.prepareStatement("select * from info where email=?");
            ps1.setString(1, email);
            ResultSet rs1 = ps1.executeQuery();
            
            
            
         
            while (rs.next()) {
                
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>User Document</title>");  
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
                            "        <li class=\"kavi\"><a class=\"active\" href=\"#home\"><b style=\"font-size: 15px;\" >HOME</b></a></li>\n" +
                            "        <li class=\"kavi\"><a href=\"profilePage\"><b style=\"font-size: 15px;\" >PROFILE</b></a></li>\n" +
                            "        <li class=\"kavi\"><a href=\"logoutJava\"><b style=\"font-size: 15px;\" >LOGOUT</b></a></li>\n" +
                            "    </div>\n" +
                            "</ul>");

                out.println("</head>");
                out.println("<body>");
                //out.println("<h1>Select from what you want to search</h1>");
                
                out.println("<div align='center' style='margin-top:50px'>"
                        + "<form action='userDocumentPolice' method='get'>");
                out.println("<p style='font-size:15px'> <b><span style='font-size:30px'>SEARCHING DOCUMENT FOR</b></span> <br>");
                String name;
                String image;
                while (rs1.next()) {
                    image=rs1.getString(7);
                    name=rs1.getString(8);
                    out.println("<img src='propic\\"+image+"' style='width:150px;height:150px;border-radius:10px'><br>");
                    out.println("<b><span  style='font-size:25px'>"+name+"</span></b><br>");
                }
                
                out.println(rs.getString(1)+"<br>"+rs.getString(2)+"</p>");
                out.println("<input type='hidden' name='email' value='"+email+"'>");
                out.println("<input type='submit' name='document' value='Personal Document' style='width:200px;heigth:30px;font-size:20px;border-radius:5px'>");
                out.println("<input type='submit' name='document' value='Vechile Document'style='width:200px;heigth:30px;font-size:20px;border-radius:5px'>");
                out.println("</form> </div>");
                
                out.println("<footer style='margin-top:85px'>\n" +
                                "  <p>Copyright © 2019 TPS Tech.Pvt.Ltd., All Rights Reserved</p>\n" +
                                "</footer>");
                out.println("</body>");
                out.println("</html>");
                
            }
            return;
        
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            out.println("Sorry we can not find any user with this email");
            out.println("Please try with another email");
        }
    }

}
