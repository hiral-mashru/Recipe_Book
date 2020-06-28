import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

public class cnfmpswd extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Confirm Password</title>");            
            out.println("</head>");
            out.println("<body>");
//            Cookie ck[]=request.getCookies();
//            String eml = ck[1].getValue();
            HttpSession session=request.getSession(false);  
            String eml=(String)session.getAttribute("abc"); 
            out.println(eml);
            String password = request.getParameter("pswd");
            String confirm = request.getParameter("cnfmpswd");
            //String email = (String)request.getAttribute("email");
            if(request.getParameter("pswd").equals(request.getParameter("cnfmpswd")))
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/129", "root", "");
                PreparedStatement stmt = con.prepareStatement("update user set Password=? where Email_ID=?");
                stmt.setString(1,request.getParameter("cnfmpswd"));
                stmt.setString(2,(String)session.getAttribute("abc"));
                int i=stmt.executeUpdate(); 
                RequestDispatcher rd=request.getRequestDispatcher("addorview.html");  
                rd.forward(request, response); 
            }
            else{  
                out.print("Sorry Password Error!");  
                RequestDispatcher rd=request.getRequestDispatcher("/cnfmpswd.html");  
                rd.include(request, response);  
            }
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e)
        {
            out.println(e);
        }
            
        }
    }