/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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

/**
 *
 * @author user
 */
public class frgtpswd extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
        response.setContentType("text/html;charset=UTF-8");
        
        try(PrintWriter out = response.getWriter()){
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Forgot Password</title>");            
            out.println("</head>");
            out.println("<body>");
            
            String nm = request.getParameter("name");
            String email = request.getParameter("email");
            String phn = request.getParameter("phone");
            String unm = request.getParameter("uname");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/129", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from user");
            while(rs.next()) {
            if(nm.equals(rs.getString(2)) && email.equals(rs.getString(3)) && phn.equals(rs.getString(4)) && unm.equals(rs.getString(5)))
            {
                request.setAttribute("email",request.getParameter("email"));
                Cookie ck = new Cookie("email",email);
                response.addCookie(ck);
                RequestDispatcher rd=request.getRequestDispatcher("cnfmpswd.html");  
                rd.forward(request, response); 
                request.setAttribute("email",email);
            }
            else{  
               out.print("Sorry...Insert correct values!");  
                RequestDispatcher rd=request.getRequestDispatcher("/frgtpswd.html");  
                rd.include(request, response);  
            } }
            out.println("</body>");
            out.println("</html>");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frgtpswd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(frgtpswd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
