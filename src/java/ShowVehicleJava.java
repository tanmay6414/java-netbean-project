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


@WebServlet("/ShowVehicleJava")
public class ShowVehicleJava extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String un = request.getParameter("email");
        //String pw = request.getParameter("password");
        HttpSession session=request.getSession(false);
        
        String type=(String)session.getAttribute("type");
        
        PrintWriter out = response.getWriter();
        String email1 = request.getParameter("email");
        String aim = request.getParameter("aim");
        
        


        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/asdl", "root", "root"); // gets a new connection

            PreparedStatement ps = c.prepareStatement("select * from vechile where email=?");
            if (type.equals("user")){
                email1=(String)session.getAttribute("email");
                ps.setString(1, email1);
            }else{
                //String email = request.getParameter("email");
                ps.setString(1, email1);
            }
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
                                    "        <li class=\"kavi\"><a class=\"active\" href=\"#home\"><b style=\"font-size: 15px;\" >HOME</b></a></li>\n" +
                                    "        <li class=\"kavi\"><a href=\"profilePage\"><b style=\"font-size: 15px;\" >PROFILE</b></a></li>\n" +                                 
                                    "        <li class=\"kavi\"><a href=\"logoutJava\"><b style=\"font-size: 15px;\" >LOGOUT</b></a></li>\n" +
                                    "    </div>\n" +
                                    "</ul>");
           
            
            
            out.println("<h1 style=\"text-align:center\"><b> Vehicle Information <b></h1>");
 
            
            int i=0;
            while (rs.next()) {
               i+=1;
                LocalDate currentDate = LocalDate.now();

                String insuDateString=rs.getString(10);
                LocalDate insuDate = LocalDate.parse(insuDateString);
                long insuExpire = ChronoUnit.DAYS.between(currentDate, insuDate);

                String pucDateString=rs.getString(13);
                LocalDate pucDate = LocalDate.parse(insuDateString);
                long pucExpire = ChronoUnit.DAYS.between(currentDate, pucDate);
                String url="showFullImage?name1="+rs.getString(18)+"&column="+rsmd.getColumnName(18)+"&email="+email1+"&aim="+aim;
                String url1="showFullImage?name1="+rs.getString(17)+"&column="+rsmd.getColumnName(17)+"&email="+email1+"&aim="+aim;
                String url2="showFullImage?name1="+rs.getString(19)+"&column="+rsmd.getColumnName(19)+"&email="+email1+"&aim="+aim;
                String url3="showFullImage?name1="+rs.getString(3)+"&column="+rsmd.getColumnName(3)+"&email="+email1+"&aim="+aim;



                out.println("<div class=\"w3-main w3-content w3-padding\" style=\"max-width:1200px;margin-top:2px\">");
                out.println("<div class=\"w3-row-padding w3-padding-16 w3-center\" id=\"food\">");
                out.println("<div style='background:white;padding:10px;margin:10px'><h2 style=\"text-align:center\"><b>Vehicle Number "+i+"</b></h2></div>");


                out.println("<div style='background:white;padding:10px;margin:10px'>Passing Number : "+rs.getString(5)+"&nbsp&nbsp&nbspPlate Number : "+rs.getString(7)+"</div>");

                out.println("<div class=\"w3-quarter\">");
                out.println("<div style='background:white;padding:10px;height:465px'><a href='"+url3+"'><img src='vehiclePic\\"+rs.getString(3)+"' style='width:250px;height:300px'></a><br>Vehicle Name<br>"+rs.getString(2)+"<br>Vehicle Type<br>"+rs.getString(4)+"</div>");
                //out.println("Passing Number<br>"+rs.getString(5)+"Plate Number<br>"+rs.getString(7));
                out.println("</div>");

                out.println("<div class=\"w3-quarter\">");                
                out.println("<div style='background:white;padding:10px;height:465px'><a href='"+url+"'><img src='vehiclePic\\"+ rs.getString(18)+ "' style='width:250px;height:300px'></a><br>Insurance No<br>"+rs.getString(9)+"<br>Insurance Expiry Date<br>"+rs.getString(10));

                if(insuExpire<=30){
                    out.println("<br><span style='color:red;'>Expire In "+insuExpire+" days<br>Please reniew your insurance</span></div>");
                }else{
                    out.println("</div>");
                }
                out.println("</div>");

                out.println("<div class=\"w3-quarter\">");
                //out.println("<div style='background:white;padding:10px;height:408px'><a href='"+url1+"'><img src='vehiclePic\\"+ rs.getString(17)+ "' style='width:250px;height:300px'></a><br>PUC No<br>"+rs.getString(12)+"<br>PUC Expiry Date<br>"+rs.getString(13+"</div>"));
                out.println("<div style='background:white;padding:10px;height:465px'><a href='"+url1+"'><img src='vehiclePic\\"+ rs.getString(17)+ "' style='width:250px;height:300px'></a><br>PUC No<br>"+rs.getString(12)+"<br>PUC Expiry Date<br>"+rs.getString(13));
                if(pucExpire<=30){
                    out.println("<br><span style='color:red;'>Expire In "+pucExpire+" days<br>Please reniew your insurance</span></div>");
                }else{
                    out.println("</div>");
                }
                out.println("</div>");

                out.println("<div class=\"w3-quarter\">");
                out.println("<div style='background:white;padding:10px;height:465px'><a href='"+url2+"'><img src='vehiclePic\\"+ rs.getString(19)+ "' style='width:250px;height:300px'></a><br>RcBook No<br>"+rs.getString(15)+"</div>");
                out.println("</div>");

                out.println("</div>");
                out.println("</div>");

                
                
            }
            
            out.println("</div>");
            out.println("</div>");
            if (i==0){
                response.sendRedirect("VehicleDocument.html");
            }
            
            if(type.equals("user")){
                out.println("<a href=\"profilePage\"><button style=\"background-color:#3A5FC1;border: none;color: white;width:100%;padding: 5px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;margin: 4px 2px;cursor: pointer;border-radius:5px\">Go Back</button></a>");
            }else{
                if(aim.equals("verify")){
                    out.println("<a href='policeSearchUserJava?searchUser="+email1+"'><button style=\"background-color:#3A5FC1;border: none;color: white;width:100%;padding: 5px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;margin: 4px 2px;cursor: pointer;border-radius:5px\">Go Back</button></a>");
                }else{
                    out.println("<a href=\"profilePage\"><button style=\"background-color:#3A5FC1;border: none;color: white;width:100%;padding: 5px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;margin: 4px 2px;cursor: pointer;border-radius:5px\">Go Back</button></a>");
                }
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