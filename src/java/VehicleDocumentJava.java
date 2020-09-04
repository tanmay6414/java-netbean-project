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

@WebServlet(urlPatterns = {"/VehicleDocumentJava"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 100)
public class VehicleDocumentJava extends HttpServlet {

//    this if directory name where the file will be uploaded and saved
    private static final String SAVE_DIR = "vehiclePic";

//    this is the method which is created by system it self
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session=request.getSession(false);
            String email=(String)session.getAttribute("email");
            String type=(String)session.getAttribute("type");

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
                Part vehiclepic = request.getPart("vehiclepic");
                Part insupic = request.getPart("insupic");
                Part pucpic = request.getPart("pucpic");
                Part rcbookpic = request.getPart("rcbookpic");
                
                //String email = request.getParameter("email");
                String vname = request.getParameter("vname");
                String vehiclestype = request.getParameter("vehiclestype");
                String cno = request.getParameter("cno");
                String vno = request.getParameter("vno");
                String insuranceno = request.getParameter("insuranceno");
                String insuupto = request.getParameter("insuupto");
                String puc = request.getParameter("puc");
                String pucupto = request.getParameter("pucupto");
                String rcbookno = request.getParameter("rcbookno");
                
                //String fileName = extractFileName(part);
                //part.write(savePath + File.separator + fileName);
                String fileName = extractFileName(vehiclepic);
                vehiclepic.write(savePath + File.separator + fileName);
                
                String fileName1 = extractFileName(insupic);
                insupic.write(savePath + File.separator + fileName1);
                
                String fileName2 = extractFileName(pucpic);
                pucpic.write(savePath + File.separator + fileName2);
                
                String fileName3 = extractFileName(rcbookpic);
                rcbookpic.write(savePath + File.separator + fileName3);

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/asdl", "root", "root");

//                query to insert name and image name
                String query = "INSERT INTO vechile  values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement pst;
                pst = con.prepareStatement(query);
                pst.setString(1, email);
                pst.setString(2,vname );
                pst.setString(4,vehiclestype);
                pst.setString(5,cno);
                pst.setString(6,"false" );
                pst.setString(7,vno );
                pst.setString(8,"false" );
                pst.setString(9,insuranceno );
                pst.setString(10,insuupto );
                pst.setString(11,"false" );
                pst.setString(12,puc );
                pst.setString(13,pucupto );
                pst.setString(14,"false" );
                pst.setString(15,rcbookno );
                pst.setString(16,"false" );
                
                
                String filePath = savePath + File.separator + fileName;
                //pst.setString(3, filePath);
                pst.setString(3, fileName);
                
                String filePath1 = savePath + File.separator + fileName1;
                //pst.setString(18, filePath1);
                pst.setString(18, fileName1);
                
                String filePath2 = savePath + File.separator + fileName2;
                //pst.setString(17, filePath2);
                pst.setString(17, fileName2);
                
                String filePath3 = savePath + File.separator + fileName3;
                //pst.setString(19, filePath3);
                pst.setString(19, fileName3);
                
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