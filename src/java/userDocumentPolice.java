
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


@WebServlet("/userDocumentPolice")
public class userDocumentPolice extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String email = request.getParameter("email");
       String button1 = request.getParameter("document");
        //String pw = request.getParameter("password");
        
        PrintWriter out = response.getWriter();
        if(button1.equals("Personal Document")){
             response.sendRedirect("http://localhost:8084/Police/ShowPersonalDocument?email="+email+"&aim=verify");
        }else{
            response.sendRedirect("http://localhost:8084/Police/ShowVehicleJava?email="+email+"&aim=verify");
        }
            
    }

}