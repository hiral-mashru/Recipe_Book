package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.io.*;

public final class view_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("\t<title>View</title>\n");
      out.write("\t<meta charset=\"UTF-8\">\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("<!--===============================================================================================-->\t\n");
      out.write("\t<link rel=\"icon\" type=\"image/png\" href=\"images_v/icons/favicon.ico\"/>\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor_v/bootstrap/css/bootstrap.min.css\">\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"fonts_v/font-awesome-4.7.0/css/font-awesome.min.css\">\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor_v/animate/animate.css\">\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor_v/select2/select2.min.css\">\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor_v/perfect-scrollbar/perfect-scrollbar.css\">\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css_v/util.css\">\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css_v/main.css\">\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    ");

        String st = (String)session.getAttribute("abc")  + "";
    
      out.write("\n");
      out.write("    \n");
      out.write("   \n");
      out.write("\t<div class=\"limiter\">\n");
      out.write("\t\t<div class=\"container-table100\">\n");
      out.write("\t\t\t<div class=\"wrap-table100\">\n");
      out.write("\t\t\t\t<div class=\"table100\">\n");
      out.write("\t\t\t\t\t<table>\n");
      out.write("\t\t\t\t\t\t<thead>\n");
      out.write("\t\t\t\t\t\t\t<tr class=\"table100-head\">\n");
      out.write("\t\t\t\t\t\t\t\t<th class=\"column1\">Recipe ID</th>\n");
      out.write("\t\t\t\t\t\t\t\t<th class=\"column2\">Recipe Name</th>\n");
      out.write("                                                                <th class=\"column3\">Category</th>\n");
      out.write("\t\t\t\t\t\t\t\t<!--<th class=\"column4\"><a href=\"ingredients.html\">Ingredients</a></th>-->\n");
      out.write("\t\t\t\t\t\t\t\t<th class=\"column4\">Neutricians</th>\n");
      out.write("\t\t\t\t\t\t\t\t<th class=\"column5\">Discription</th>\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t</thead>\n");
      out.write("                                               \n");
      out.write("\t\t\t\t\t\t<tbody>\n");
      out.write("                                                     ");

                                                                    Cookie cc[]=request.getCookies();
                                                                    String uid=cc[0].getValue();
                                                                    Class.forName("com.mysql.jdbc.Driver");
                                                                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/129","root","");
                                                                    PreparedStatement pst = con.prepareStatement("select * from recipe where UID=?");
                                                                    pst.setString(1, uid);
                                                                    ResultSet rs = pst.executeQuery();
                                                                    while(rs.next())
                                                                    {
                                                                        
                                                                        
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\n");
      out.write("                                                                        <td class=\"column1\">");
      out.print(rs.getInt("RID"));
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t\t\t<td class=\"column2\">");
      out.print(rs.getString("RName"));
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t\t\t<td class=\"column3\">");
      out.print(rs.getInt("CID"));
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t\t\t<!--<td class=\"column4\"></td>-->\n");
      out.write("\t\t\t\t\t\t\t\t\t<td class=\"column4\">");
      out.print(rs.getString("Neutricians"));
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t\t\t<td class=\"column5\">");
      out.print(rs.getString("discription"));
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\n");
      out.write("                                                                ");
 } 
                                                                    rs.close();
                                                                    pst.close();
                                                                    con.close();
      out.write("\n");
      out.write("\t\t\t\t\t\t</tbody>\n");
      out.write("\t\t\t\t\t</table>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\n");
      out.write("\n");
      out.write("<!--===============================================================================================-->\t\n");
      out.write("\t<script src=\"vendor_v/jquery/jquery-3.2.1.min.js\"></script>\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("\t<script src=\"vendor_v/bootstrap/js/popper.js\"></script>\n");
      out.write("\t<script src=\"vendor_v/bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("\t<script src=\"vendor_v/select2/select2.min.js\"></script>\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("\t<script src=\"js_v/main.js\"></script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
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
