import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/ShowPersonalDocument")
public class try1 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String un = request.getParameter("email");
        //String pw = request.getParameter("password");
        String email="sdpokarkar@mitaoe.ac.in";
        PrintWriter out = response.getWriter();
        LocalDate today = LocalDate.now();
// Connect to mysql(mariadb) and verify username password

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/asdl", "root", "root"); // gets a new connection

            PreparedStatement ps = c.prepareStatement("select * from document where email=?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Personal Document</title>");
              out.println("<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">");
            out.println("<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Karma\">");
            out.println("<style>\n" +
"body,h1,h2,h3,h4,h5,h6 {font-family: \"Karma\", sans-serif}\n" +
".w3-bar-block .w3-bar-item {padding:20px}\n" +
"</style>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"srushti.css\">");
            out.println("</head>");
            
            out.println("<body>");
            out.println("<header>\n" +
"        <img src=\"tps.jpg\"width=\"400px\" height=\"50px\">\n" +
"</header>\n" +
"\n" +
"<ul class=\"navi\" >\n" +
"  <div style=\"float:right\">\n" +
"        <li class=\"kavi\"><a class=\"active\" href=\"#home\"><i style=\"font-size: 15px;\" >HOME</i></a></li>\n" +
"        <li class=\"kavi\"><a href=\"#news\"><i style=\"font-size: 15px;\" >ABOUT US</i></a></li>\n" +
"        <li class=\"kavi\"><a href=\"#news\"><i style=\"font-size: 15px;\" >SERVICES</i></a></li>\n" +
"        <li class=\"kavi\"><a href=\"#news\"><i style=\"font-size: 15px;\" >GALLARY</i></a></li>\n" +
"        <li class=\"kavi\"><a href=\"#contact\"><i style=\"font-size: 15px;\" >TEAM</i></a></li>\n" +
"        <li class=\"kavi\"><a href=\"#contact\"><i style=\"font-size: 15px;\" >CONTACT US</i></a></li>\n" +
"    </div>\n" +
"</ul>");
            
            out.println("<h1 style=\"text-align:center\"> <b>Personal Document</b></h1>");
           // out.println("<table cellspacing=\"50\">");
            while (rs.next()) {
                out.println("<div class=\"w3-main w3-content w3-padding\" style=\"max-width:1200px;margin-top:40px\">");
                out.println("<div class=\"w3-row-padding w3-padding-16 w3-center\" id=\"food\">");
                out.println("<div class=\"w3-quarter\">");
                out.println("<img src='pesonalDocument\\"+rs.getString(3)+"' style='width:250px;height:300px'><br>Adhar Card No<br>"+rs.getString(2)+"");
                out.println("</div>");
                out.println("<div class=\"w3-quarter\">");
                out.println("<img src='pesonalDocument\\"+ rs.getString(6)+ "' style='width:250px;height:300px'><br>Voter ID No<br>"+rs.getString(5)+"");
                out.println("</div>");
                out.println("<div class=\"w3-quarter\">");
                out.println("<img src='pesonalDocument\\"+ rs.getString(9)+ "' style='width:250px;height:300px'><br>PAN Card No<br>"+rs.getString(8)+"");
                out.println("</div>"); 
                out.println("<div class=\"w3-quarter\">");
                out.println("<img src='pesonalDocument\\"+ rs.getString(12)+ "' style='width:250px;height:300px'><br>Driving Licence No<br>"+rs.getString(11)+"");
                out.println("</div>");
                return;
            }
           // out.println("</table>");
             out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            return;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}