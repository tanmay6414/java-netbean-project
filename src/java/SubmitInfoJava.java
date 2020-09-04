import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet(urlPatterns = {"/SubmitInfoJava"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 100)
public class SubmitInfoJava extends HttpServlet {

//    this if directory name where the file will be uploaded and saved
    private static final String SAVE_DIR = "propic";

//    this is the method which is created by system it self
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session=request.getSession(false);
        
            String email=(String)session.getAttribute("email");

//            this tyr is created by me for the connection of database
            try {

//                this is the path provide by me to save the image 
                String savePath = "C:\\Users\\TANNY\\Documents\\NetBeansProjects\\Police\\web" + File.separator + SAVE_DIR; 
/*in place of C: you can place a path wher you need to save the image*/

//                this comment will picup the image file and have convert it into file type
                File fileSaveDir = new File(savePath);
                if (!fileSaveDir.exists()) {
                    fileSaveDir.mkdir();
                }

                Part part = request.getPart("propic");
                String name = request.getParameter("name");
                String number = request.getParameter("number");
                //String email = request.getParameter("email");
                String add = request.getParameter("flat");
                String add1 = request.getParameter("address1");
                String state = request.getParameter("state");
                String city = request.getParameter("city");
                String district = request.getParameter("district");
                String pincode = request.getParameter("pincode");
                String address=add + " "+ add1;
                String fileName = extractFileName(part);
                
                part.write(savePath + File.separator + fileName);

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/asdl", "root", "root");

//                query to insert name and image name
                String query = "INSERT INTO info (email,address,city,state,distric,pincode,propic,name) values (?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement pst;
                pst = con.prepareStatement(query);
                pst.setString(1, email);
                pst.setString(2,address );
                pst.setString(3,city);
                pst.setString(4,state);
                pst.setString(5,district );
                pst.setString(6,pincode );
                pst.setString(8,name );
                
                String filePath = savePath + File.separator + fileName;
                pst.setString(7, fileName);
                pst.executeUpdate();
                response.sendRedirect("homePage.jsp");

            } catch (Exception ex) {
                out.println("error" + ex);
            }
            //response.sendRedirect("C:\\Users\\TANNY\\Documents\\NetBeansProjects\\Police\\src\\java\\profilePage.java");

        }
    }

//    the extractFileName() is method used to extract the file name
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}