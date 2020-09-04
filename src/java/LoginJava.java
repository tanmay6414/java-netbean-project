
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


@WebServlet("/LoginCJava")
public class LoginJava extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String un = request.getParameter("email");
        String pw = request.getParameter("password");
        PrintWriter out = response.getWriter();
// Connect to mysql(mariadb) and verify username password

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/asdl", "root", "root"); // gets a new connection

            PreparedStatement ps = c.prepareStatement("select email,password,type from reg where email=? and password=?");
            ps.setString(1, un);
            ps.setString(2, pw);

            ResultSet rs = ps.executeQuery();
            

            while (rs.next()) {
                String type =rs.getString(3);
                HttpSession session=request.getSession();  
                session.setAttribute("email",un);
                session.setAttribute("type",type);
                //response.sendRedirect("Register.html");
                response.sendRedirect("homePage.jsp"); 
                return;
            }
            //response.sendRedirect("error.html");
            out.println("Not Successfull");
            return;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}