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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class registration extends HttpServlet {
     protected void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException{
         response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            String nm = request.getParameter("name");
            String eml = request.getParameter("email");
            String phn = request.getParameter("phone");
            String unm = request.getParameter("uname");
            String paaswd = request.getParameter("pswd");
            boolean mob_str=false;
            double mob;
            try{
                mob = Double.parseDouble(phn);
                
            }catch(NumberFormatException e){
                  mob_str=true;
            }
       
        if(mob_str)
        {
            out.println("<font color='red'<br><center>Mobile Number must be in digits!!</center></font>");
            RequestDispatcher rd=request.getRequestDispatcher("/registration.html");  
            rd.include(request,response);
        }
        else if(!(phn.length()<10 || phn.length()>10))
            {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/129", "root", "");
            Statement stmt3 = con.createStatement();
            //stmt3.setString(1, unm);
            ResultSet rs3 = stmt3.executeQuery("select * from user");
            boolean result = true;
            while(rs3.next()){
                if(unm.equals(rs3.getString(5))){
                    result = false;
                    out.print("username has already registered...");
                    RequestDispatcher rd=request.getRequestDispatcher("/registration.html");
                    rd.include(request, response);
                }
            }
                if(result)
                {
                PreparedStatement stmt = con.prepareStatement("insert into user(Name,Email_ID,Mobile_No,Username,Password) values(?,?,?,?,?)");
                stmt.setString(1,nm);
                stmt.setString(2,eml);
                stmt.setString(3,phn);
                stmt.setString(4,unm);
                stmt.setString(5,paaswd);
//            out.print("hellooo");
                int i=stmt.executeUpdate();
//            rs3.close();
if(i>0)
{
    out.print("You are successfully registered...");
    PreparedStatement stmt2 = con.prepareStatement("select * from user where Email_ID=?");
    stmt2.setString(1,eml);
    ResultSet rs2 = stmt2.executeQuery();
    
    while(rs2.next()){
        //out.println(rs2.getInt(1));
        int id=rs2.getInt(1);
        String u_id = Integer.toString(rs2.getInt(1));
        //out.print(u_id);
        Cookie ckk = new Cookie("u_id",u_id);
        response.addCookie(ckk);
                out.print(u_id);
                
    }
    
    RequestDispatcher rd=request.getRequestDispatcher("index.html");
    rd.forward(request, response);
    rs2.close();
    
}

else
{
    out.print("Sorry UserName or Password Error!");
    RequestDispatcher rd=request.getRequestDispatcher("/registration.html");
    rd.include(request, response);
    
}
//                }
            }}
            else{
                   
//                out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
//                out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
//                out.println("<script>");
//                out.println("$(document).ready(function(){ ");
//                out.println("swal('Oops' , 'somethings wee inserted wrong...','error')");
//                out.println(" });");
//                out.println("</script>");
//                out.println("<a href="+"registration.html"+"> Go back!! </a>");
                out.println("<font color='red'<br><center>Mobile no must be of 10 digits..!!!</center></font>");
                RequestDispatcher rd=request.getRequestDispatcher("/registration.html");  
                rd.include(request,response); 
            }
            
        
     }   catch (ClassNotFoundException ex) { 
             Logger.getLogger(registration.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(registration.class.getName()).log(Level.SEVERE, null, ex);
         } 
     }
}