package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Connection;

public final class ingredients_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("\t<title>Ingredeints</title>\n");
      out.write("\t<meta charset=\"UTF-8\">\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("<!--===============================================================================================-->\t\n");
      out.write("\t<link rel=\"icon\" type=\"image/png\" href=\"images/icons/favicon.ico\"/>\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor_i/bootstrap/css/bootstrap.min.css\">\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"fonts/font-awesome-4.7.0/css/font-awesome.min.css\">\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor_i/animate/animate.css\">\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor_i/select2/select2.min.css\">\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor_i/perfect-scrollbar/perfect-scrollbar.css\">\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css_i/util.css\">\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css_i/main.css\">\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    \n");
      out.write("\t<div class=\"limiter\">\n");
      out.write("\t\t<div class=\"container-table100\">\n");
      out.write("\t\t\t<div class=\"wrap-table100\">\n");
      out.write("\t\t\t\t<div class=\"table100\">\n");
      out.write("\t\t\t\t\t<table>\n");
      out.write("\t\t\t\t\t\t<thead>\n");
      out.write("\t\t\t\t\t\t\t<tr class=\"table100-head\">\n");
      out.write("\t\t\t\t\t\t\t\t<th class=\"column1\">Ingredient ID</th>\n");
      out.write("\t\t\t\t\t\t\t\t<th class=\"column2\">Ingredient Name</th>\n");
      out.write("\t\t\t\t\t\t\t\t<th class=\"column3\">Quantity</th>\n");
      out.write("\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t</thead>\n");
      out.write("\t\t\t\t\t\t<tbody>\n");
      out.write("                                                \n");
      out.write("                                                <input type=\"text\" name=\"n\" placefolder=\"How many ingredients u wanna enter?\" required>\n");
      out.write("<!--                                                <font color=\"white\">Ingredients</font>\n");
      out.write("                                                                    <select name=\"ingredients\" width=300 STYLE=\"width: 100px\" multiple=\"multiple\">\n");
      out.write("                                                                        <option disabled=\"disabled\" selected=\"selected\">Ingredients</option>\n");
      out.write("                                                                        <option value='Salt'>Salt</option>\n");
      out.write("                                                                        <option value='Chilli'>Chilli</option>\n");
      out.write("                                                                        <option value='Onion'>Onion</option>\n");
      out.write("                                                                        <option value='Garlic'>Garlic</option>\n");
      out.write("                                                                        <option value='Potato'>Potato</option>\n");
      out.write("                                                                    </select>-->\n");
      out.write("                                                    ");

                                                        HttpSession session3 = request.getSession();
                                                        String ing_no =(String)session3.getAttribute("ingno");
      out.write("\n");
      out.write("                                                        \n");
      out.write("                                                       ");
 int ingno = Integer.parseInt(ing_no);
                                                        for(int i=0;i<ingno;i++){
                                                                        
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\n");
      out.write("                                                                    <td class=\"column1\"><input type=\"text\" name=\"iid\"/></td>\n");
      out.write("                                                                    <td class=\"column2\"><input type=\"text\" name=\"iname\"/></td>\n");
      out.write("                                                                    <td class=\"column3\"><input type=\"text\" name=\"quantity\"/></td>\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\n");
      out.write("                                                                \n");
      out.write("                                                                ");

                                                                    }
                                                                    try{
                                                                        String iname = request.getParameter("iname");
                                                                        String quantity = request.getParameter("quantity");
                                                                        Class.forName("com.mysql.jdbc.Driver");
                                                                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/129", "root", "");
                                                                        
                                                                        PreparedStatement stmt = con.prepareStatement("insert into ingredients(IName,Quantity) values(?,?)");
            
                                                                        stmt.setString(1, iname);
                                                                        stmt.setString(2, quantity);
                                                                        int j = stmt.executeUpdate();
                                                                        if(j>0)
                                                                        {
                                                                            out.println("inserted");
                                                                            HttpSession sessionn = request.getSession(false);
                                                                            String r_id=(String) sessionn.getAttribute("RID");
                                                                            out.print(r_id);
//                                                                            RequestDispatcher rd=request.getRequestDispatcher(".html");  
//                                                                            rd.forward(request, response);
                                                                        }
                                                                        else
                                                                        {
                
                                                                        }
                                                                        }
                                                                    catch(Exception e){
                                                                        out.print(e);
                                                                    }
                                                                    
      out.write("\n");
      out.write("\t\t\t\t\t\t</tbody>\n");
      out.write("\t\t\t\t\t</table>\n");
      out.write("                                    <button type=\"submit\"> Done </button>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("<!--===============================================================================================-->\t\n");
      out.write("\t<script src=\"vendor_i/jquery/jquery-3.2.1.min.js\"></script>\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("\t<script src=\"vendor_i/bootstrap/js/popper.js\"></script>\n");
      out.write("\t<script src=\"vendor_i/bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("\t<script src=\"vendor_i/select2/select2.min.js\"></script>\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("\t<script src=\"js/main.js\"></script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
