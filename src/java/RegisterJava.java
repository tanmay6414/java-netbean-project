import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisterJava extends HttpServlet {

 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // TODO Auto-generated method stub
  response.setContentType("text/html");
  PrintWriter out = response.getWriter();
  String email = request.getParameter("email");
  String password = request.getParameter("password");
  String password2=request.getParameter("password2");
  String  number= request.getParameter("number");
  String user_type = request.getParameter("user_type");
  
  // validate given input
  if (email.isEmpty() || number.isEmpty() || password.isEmpty() || user_type.isEmpty()) {
   RequestDispatcher rd = request.getRequestDispatcher("Register.html");
   out.println("<font color=red>Please fill all the fields</font>");
   rd.include(request, response);
  } else {
   // inserting data into mysql database 
   // create a test database and student table before running this to create table
   //create table student(name varchar(100), userName varchar(100), pass varchar(100), addr varchar(100), age int, qual varchar(100), percent varchar(100), year varchar(100));
   try {
    Class.forName("com.mysql.jdbc.Driver");
    // loads mysql driver

    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/asdl", "root", "root"); 
    
    PreparedStatement ps1 = con.prepareStatement("select * from reg where email=?");
    ps1.setString(1, email);
    ResultSet rs1 = ps1.executeQuery();
    int count=0;
    while(rs1.next()){
        count++;
        }
        if(count>0){
            RequestDispatcher rd1 = request.getRequestDispatcher("Register.html");
            out.println("<script>alert('This user allready exist')</script></font>");
            rd1.include(request, response);

        }else{
            String query = "insert into reg(email,number,password,type) values(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query); // generates sql query

            ps.setString(1, email);
            ps.setString(2, number);
            ps.setString(3, password);
            ps.setString(4, user_type);

            ps.executeUpdate(); // execute it on test database
            
            ps.close();
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.forward(request, response);
        
        
        
        }        
            
        ps1.close();
            
    
    
    con.close();
   } catch (ClassNotFoundException | SQLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
   
  }
 }
}