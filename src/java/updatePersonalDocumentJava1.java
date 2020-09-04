import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(urlPatterns = {"/VehicleDocumentJava"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 100)
public class updatePersonalDocumentJava1 extends HttpServlet {

//    this if directory name where the file will be uploaded and saved
    private static final String SAVE_DIR = "pesonalDocument";

//    this is the method which is created by system it self
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

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

                //Part part = request.getPart("propic");
                Part adharpic = request.getPart("adharpic");
                Part voteridpic = request.getPart("voteridpic");
                Part panpic = request.getPart("panpic");
                Part drivinglicencepic = request.getPart("drivinglicencepic");
                
                String email = request.getParameter("email");
                String adharno = request.getParameter("adharno");
                String voteridno = request.getParameter("voteridno");
                String panno = request.getParameter("panno");
                String drivinglicenceno = request.getParameter("drivinglicenceno");
                String drivinglicenceupto = request.getParameter("drivinglicenceupto");
                
                
                //String fileName = extractFileName(part);
                //part.write(savePath + File.separator + fileName);
                //String fileName = extractFileName(adharpic);
                //adharpic.write(savePath + File.separator + fileName);
                
                //String fileName1 = extractFileName(voteridpic);
                //voteridpic.write(savePath + File.separator + fileName1);
                
                //String fileName2 = extractFileName(panpic);
                //panpic.write(savePath + File.separator + fileName2);
                
                String fileName3 = extractFileName(drivinglicencepic);
                drivinglicencepic.write(savePath + File.separator + fileName3);

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/asdl", "root", "root");

//                query to insert name and image name
                String query = "update document set adharcardno=?, voteridno=?, panno=?, drivinglicenceno=?, drivinglicencepic=?, drivinglicenceupto=? where email=?";

                PreparedStatement pst;
                pst = con.prepareStatement(query);
                pst.setString(7, email);
                pst.setString(1,adharno );
                //pst.setString(4,"false");
                pst.setString(2,voteridno);
                //pst.setString(7,"false" );
                pst.setString(3,panno );
                //pst.setString(10,"false" );
                pst.setString(4,drivinglicenceno );
                //pst.setString(13,"false" );
                pst.setString(6,drivinglicenceupto );
                
                
                
                //String filePath = savePath + File.separator + fileName;
                //pst.setString(3, filePath);
                //pst.setString(3, fileName);
                
                //String filePath1 = savePath + File.separator + fileName1;
                //pst.setString(6, filePath1);
                //pst.setString(6, fileName1);
                
                //String filePath2 = savePath + File.separator + fileName2;
                //pst.setString(9, filePath2);
                //pst.setString(9, fileName2);
                
                String filePath3 = savePath + File.separator + fileName3;
                //pst.setString(12, filePath3);
                pst.setString(5, fileName3);
                
                pst.executeUpdate();
                response.sendRedirect("profilePage");

            } catch (Exception ex) {
                out.println("error" + ex);
            }

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