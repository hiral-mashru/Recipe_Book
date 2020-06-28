<%-- 
    Document   : view
    Created on : 10 Sep, 2019, 7:11:59 PM
    Author     : Harsh -Hiral
--%>
<%@page language="java" import="java.sql.*" %>
<%@page import="java.io.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>View</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images_v/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor_v/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts_v/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor_v/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor_v/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor_v/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css_v/util.css">
	<link rel="stylesheet" type="text/css" href="css_v/main.css">
<!--===============================================================================================-->
</head>

<body>
    <%
        String st = (String)session.getAttribute("abc")  + "";
    %>
    
   
	<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100">
					<table>
						<thead>
							<tr class="table100-head">
								<th class="column1">Recipe ID</th>
								<th class="column2">Recipe Name</th>
                                                                <th class="column3">Category</th>
								<th class="column4">Neutricians</th>
								<th class="column5">Discription</th>
							</tr>
						</thead>
                                               
						<tbody>
                                                     <%
                                                                    String uid=(String)session.getAttribute("u_id"); 
                                                                    Class.forName("com.mysql.jdbc.Driver");
                                                                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/129","root","");
                                                                    PreparedStatement pst = con.prepareStatement("select * from recipe where UID=?");
                                                                    pst.setString(1, uid);
                                                                    ResultSet rs = pst.executeQuery();
                                                                    while(rs.next())
                                                                    {
                                                                        
                                                                        %>
								<tr>
                                                                        <td class="column1"><%=rs.getInt("RID")%></td>
									<td class="column2"><%=rs.getString("RName")%></td>
									<td class="column3"><%=rs.getInt("CID")%></td>
									<td class="column4"><%=rs.getString("Neutricians")%></td>
									<td class="column5"><%=rs.getString("discription")%></td>
								</tr>
                                                                <% } 
                                                                    rs.close();
                                                                    pst.close();
                                                                    con.close();%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>


	

<!--===============================================================================================-->	
	<script src="vendor_v/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor_v/bootstrap/js/popper.js"></script>
	<script src="vendor_v/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor_v/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="js_v/main.js"></script>

</body>

</html>
