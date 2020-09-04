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

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/ShowPersonalDocument")
public class ShowPersonalDocument extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String un = request.getParameter("email");
        //String pw = request.getParameter("password");
        HttpSession session=request.getSession(false);
        
        String type=(String)session.getAttribute("type");
        PrintWriter out = response.getWriter();
        LocalDate today = LocalDate.now();
        String email = request.getParameter("email");
        String aim = request.getParameter("aim");
// Connect to mysql(mariadb) and verify username password

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/asdl", "root", "root"); // gets a new connection

            PreparedStatement ps = c.prepareStatement("select * from document where email=?");
            if (type.equals("user")){
                email=(String)session.getAttribute("email");
                ps.setString(1, email);
            }else{
                email = request.getParameter("email");
                ps.setString(1, email);
            }
            
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            String tableName="document";
            
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
           
            
            
           
            int i=0;
            while (rs.next()) {
                
                LocalDate currentDate = LocalDate.now();
                String liceDateString=rs.getString(14);
                LocalDate insuDate = LocalDate.parse(liceDateString);
                long liceExpire = ChronoUnit.DAYS.between(currentDate, insuDate);
                
                
                String url="showFullImage?name1="+rs.getString(3)+"&column="+tableName+"&email="+email+"&aim="+aim;
                String url1="showFullImage?name1="+rs.getString(6)+"&column="+tableName+"&email="+email+"&aim="+aim;
                String url2="showFullImage?name1="+rs.getString(9)+"&column="+tableName+"&email="+email+"&aim="+aim;
                String url3="showFullImage?name1="+rs.getString(12)+"&column="+tableName+"&email="+email+"&aim="+aim;
                 out.println("<div class=\"w3-main w3-content w3-padding\" style=\"max-width:1200px;margin-top:2px\">");
                out.println("<div class=\"w3-row-padding w3-padding-16 w3-center\" id=\"food\">");  
                 out.println("<div class=\"w3-quarter\">");
                out.println("<div style='background:white;padding:10px;height:408px;'><a href='"+url+"'><img src='pesonalDocument\\"+rs.getString(3)+"' style='width:250px;height:300px'></a><br><b>Adhar Card</b><br> Number - "+rs.getString(2)+"</div>");
                out.println("</div>"); 
                out.println("<div class=\"w3-quarter\">");
                out.println("<div style='background:white;padding:10px;height:408px'><a href='"+url1+"'><img src='pesonalDocument\\"+ rs.getString(6)+ "' style='width:250px;height:300px'></a><br><b> Voter ID </b><br> Number - "+rs.getString(5)+"</div>");
                out.println("</div>"); 
                out.println("<div class=\"w3-quarter\">");
                out.println("<div style='background:white;padding:10px;height:408px'><a href='"+url2+"'><img src='pesonalDocument\\"+ rs.getString(9)+ "' style='width:250px;height:300px'></a><br><b>PAN Card</b><br> Number - "+rs.getString(8)+"</div>");
                out.println("</div>");
                out.println("<div class=\"w3-quarter\">");
                out.println("<div style='background:white;padding:10px;height:408px'><a href='"+url3+"'><img src='pesonalDocument\\"+ rs.getString(12)+ "' style='width:250px;height:300px'></a><br><b>Driving Licence</b> <br>Number - "+rs.getString(11));
                
                if(liceExpire<=30){
                    out.println("<br><span style='color:red;'>Expire In "+liceExpire+" days<br>Please reniew your driving licence</span></div>");
                }else{
                    out.println("<br>.</div>");
                }
                out.println("</div>");
                out.println("</table>");
            
                if(type.equals("user")){
                    out.println("<a href='profilePage'><div class='button'>Go back</div></a>");
                    out.println("<form action='updateUserDocument' method='post'><input type='submit' value='Edit Document'></form>");
                }else{
                    if(aim.equals("verify")){
                        out.println("<a href='policeSearchUserJava?searchUser="+rs.getString(1)+"'><div class='button'>Go back</div></a>");
                    }else if(aim.equals("self")){
                        out.println("<a href='profilePage'><div class='button'>Go back</div></a>");
                        out.println("<form action='updateUserDocument' method='post'><input type='submit' value='Edit Document'></form>");
                        
                    }else{
                        out.println("<a href='profilePage'><div class='button'>Go back</div></a>");
                    }
                    }
                i+=1;
            }
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            if(i==0){
                response.sendRedirect("PersonalDocument.jsp");
            }
            
            

            
            
            out.println("<footer>\n" +
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