import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class add extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
               
       
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>add</title>");            
            out.println("</head>");
            out.println("<body>");
            String rname = request.getParameter("r_name");
            String ctgry = request.getParameter("category");
            int cid=0;
            switch(ctgry)
            {
                case "Gujarati" : 
                    cid=456;
                    break;
                case "Punjabi" : 
                    cid=455;
                    break;
                case "Chinese" :
                    cid= 457;
                    break;
            }
            //out.print("hellooo");
            String c_id = Integer.toString(cid);
            //out.print(c_id);
            out.print("heyy");
//            try{
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/129", "root", "");
//            PreparedStatement stm2 = con.prepareStatement("select RID from recipe where Rname=?");
//            stm2.setString(1, request.getParameter("r_name"));
//            ResultSet rss = stm2.executeQuery();
//            while(rss.next()){
//            out.print(rss.getInt("RID"));}
//            
//            HttpSession session4 = request.getSession();
//            session4.setAttribute("RID",rss.getString("RID"));
//            out.print(rss.getString("RID"));
//            rss.close();
//            }
//        catch (Exception ex) {
//        out.println(ex);
//}

//            HttpSession sessionn = request.getSession(false);
//            String r_id=(String) sessionn.getAttribute("RID");
//            out.print(r_id);
//            Cookie ckk[] = request.getCookies();
//            String u_id = ckk[0].getValue();
             
            HttpSession session1=request.getSession(false);  
            String u_id=(String)session1.getAttribute("u_id"); 
            out.print(u_id);
            
            
            
            HttpSession session2=request.getSession();  
            session2.setAttribute("rname",rname);
            String neutrician = request.getParameter("neutrician");
            String discription = request.getParameter("discription");
            try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/129", "root", "");
            PreparedStatement stm = con2.prepareStatement("insert into recipe(Rname,CID,Neutricians,discription,UID) values(?,?,?,?,?)");
            stm.setString(1,request.getParameter("r_name"));
            stm.setString(2,c_id);
            stm.setString(3,request.getParameter("neutrician"));
            stm.setString(4,request.getParameter("discription"));
            stm.setString(5,u_id);
            int j=stm.executeUpdate();
            out.print("   "+"eeeee");
                        
                       

            
//          
//            HttpSession sessionn = request.getSession(false);
//            String r_id=(String) sessionn.getAttribute("RID");
//            out.print(r_id);
//            boolean result = true;
//            String ingredients[] = request.getParameterValues("ingredients");
////            HttpSession sessionn = request.getSession(false);
////            String r_id=(String) sessionn.getAttribute("RID");
//            int rid = Integer.parseInt(r_id);
//            for(int i=0;i<ingredients.length;i++){
//                out.println(ingredients[i]+"");
//                PreparedStatement stmt = con.prepareStatement("select IID from ingredients where Iname=?");
//                stmt.setString(1, ingredients[i]);
//                ResultSet rs = stmt.executeQuery();
//                out.print(rs.getInt("IID"));
//                
//                PreparedStatement stmt2 = con.prepareStatement("insert into ingrecrelation(IID,RID) values(?,?)");
//                stmt2.setInt(1,rs.getInt("IID"));
//                stmt2.setInt(2, rid);
////                rs.close();
////                    PreparedStatement stm2 = null;
////                        stm2 = con.prepareStatement("select RID from recipe where Rname=?");
////                        stm2.setString(1, rname);
////                        ResultSet rss = null;
////                        rss = stm2.executeQuery();
////                        out.print(rss.getInt("RID"));
////                        stmt2.setInt(2,rss.getInt("RID"));
////                    rss.close();
//                    int k = stmt2.executeUpdate();
//                    if(k>0){
//                        out.print("hoooo");
//                    }
//            }
////                rs.close();
            if(j>0)
                {
                    out.print("heyyoo");
//                    
                    RequestDispatcher rd=request.getRequestDispatcher("view.jsp");  
                    rd.forward(request, response);
                   
                } else
                {
                    out.print("Sorry ur recipe has not been updated...!");  
                    RequestDispatcher rd=request.getRequestDispatcher("/add.html");  
                    rd.include(request, response); 
                   
                }
            
            out.println("</body>");
            out.println("</html>");
         
    
    }
        catch (Exception ex) {
        out.println(ex);
}}}
