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


@WebServlet("/updateUserDocument")
public class updateUserDocument extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session=request.getSession(false);
        
        String email=(String)session.getAttribute("email");
        PrintWriter out = response.getWriter();
        LocalDate today = LocalDate.now();
// Connect to mysql(mariadb) and verify username password

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/asdl", "root", "root"); // gets a new connection

            PreparedStatement ps = c.prepareStatement("select * from document where email=?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Update Personal Document</title>");
            out.println("<title>Personal Document</title>"); 
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
                                    "        <li class=\"kavi\"><a class=\"active\" href=\"homePage.jsp\"><b style=\"font-size: 15px;\" >HOME</b></a></li>\n" +
                                    
                                    "        <li class=\"kavi\"><a href=\"profilePage\"><b style=\"font-size: 15px;\" >PROFILE</b></a></li>\n" +
                                 "        <li class=\"kavi\"><a href=\"logoutJava\"><b style=\"font-size: 15px;\" >LOGOUT</b></a></li>\n" +
                                    "    </div>\n" +
                                    "</ul>");
            
            while (rs.next()) {
            out.println("<div id=\"sru\" style=\"margin-left: 400px;padding:100px;margin-top: 7px;height:800px;width:600px\" ><form enctype=\"multipart/form-data\" action=\"updatePersonalDocumentJava1\" method=\"post\">\n" +
"            <span style='color:black;margin-left:85px'>"+   
"                <h1 '>Fill out your information</h1>\n" +
"                <hr>" +
"                <b></b> <input type=\"hidden\" name=\"email\" placeholder=\"Email\" value='"+rs.getString(1)+"' style=\"height:30px;width:400px;\"><br>\n" +
"                <b>Adhar Number</b><br><input type=\"text\" name=\"adharno\" placeholder=\"Adhar Card No\" value='"+rs.getString(2)+"' style=\"height:30px;width:400px;\"><br>\n" +

"                \n" +
"                <b>Voter Card No</b><br><input type=\"text\" name=\"voteridno\" placeholder=\"Voter Id No\" value='"+rs.getString(5)+"' style=\"height:30px;width:400px;\"><br>\n" +

"                \n" +
"                <b>Pan Card No</b><br><input type=\"text\" name=\"panno\" placeholder=\"PAN Card No\"value='"+rs.getString(8)+"' style=\"height:30px;width:400px;\"><br>\n" +

"                \n" +

"                <b>Driving Licence  Pic</b> <br><input type=\"file\" name=\"drivinglicencepic\" value='"+rs.getString(12)+"' style=\"height:30px;width:400px;\"><br><br>\n" +
                "<b>Driving Licence Number</b> <br><input type=\"text\" name=\"drivinglicenceno\" placeholder=\"Driving Licence No\" value='"+rs.getString(11)+"' style=\"height:30px;width:400px;\"><br>\n" +
"                <b>Licence Valid Upto</b> <br><input type=\"date\" name=\"drivinglicenceupto\" value='"+rs.getString(14)+"' style=\"height:30px;width:400px;\"><br>\n" +
"                \n" +
"                <input type=\"submit\" name=\"submitinfo\" value=\"Update Document\" style=\"width:400px;background-color: #ff0000\"><br><br>\n" +
"	</form></span><a href='profilePage'><button>Go back</button></a></div><br>");
            }
            
            out.println("</body>");
            out.println("</html>");
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}