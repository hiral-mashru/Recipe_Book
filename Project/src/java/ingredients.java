import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class ingredients extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Ingredients</title>");            
            out.println("</head>");
            out.println("<body>");
            out.print("hello");
//            Cookie ck1[]=request.getCookies();
//            String eml = ck1[0].getValue();
//            out.println(eml);
            HttpSession sessionn = request.getSession(false);
            String r_id=(String) sessionn.getAttribute("RID");
            out.print(r_id);
            String ingredients[] = request.getParameterValues("ingredients");
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/129","root","");
            
            
            
            
            
            for(int i=0;i<ingredients.length;i++){
            PreparedStatement stmt = con.prepareStatement("select IID from ingredients where Iname=?");
            stmt.setString(1, ingredients[i]);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                out.println(rs.getInt("IID"));
                PreparedStatement stmt2 = con.prepareStatement("insert into ingrecrelation(IID) values(?)");
                stmt2.setInt(1, rs.getInt("IID"));
                int k = stmt2.executeUpdate();
                if(k>0){
                    out.print("hoooooooooooo");
                }
//                RequestDispatcher rd=request.getRequestDispatcher("view.jsp");  
//                rd.forward(request, response);
            }
            }
                out.println("</body>");
            } 
            catch (Exception e) {
                    out.print(e);
            } 
            out.println("</html>");
        }
       
    }


