import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class login extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("heyy");
            String email = request.getParameter("email");
            String pw = request.getParameter("pswd");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/129", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from user");
            //out.print("hello");
            boolean result = true;
            while(rs.next()){
                
                if(email.equals(rs.getString(3)) && pw.equals(rs.getString(6)))
                {
                    result = false;
                    int uid=rs.getInt(1);
                    String u_id = Integer.toString(uid);
                    out.print(u_id);
                    HttpSession session1 = request.getSession();
                    session1.setAttribute("u_id",u_id);
//                    Cookie cc = new Cookie("u_id",u_id);
//                    response.addCookie(cc);
                    
                    RequestDispatcher rd=request.getRequestDispatcher("addorview.html");  
                    HttpSession session = request.getSession();
                    session.setAttribute("abc",email);
                    rd.forward(request, response);
                    
                    break;
                }
            }
                if(result)
                {
                    out.print("Sorry UserName or Password Error!");  
                    RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
                    rd.include(request, response);
                }
            
            out.println("</body>");
            out.println("</html>");
        }catch(Exception e){
              
            System.out.println(e);
        }
        
    }
    }