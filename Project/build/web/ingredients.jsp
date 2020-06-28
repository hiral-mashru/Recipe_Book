<%-- 
    Document   : ingredients
    Created on : 10 Sep, 2019, 6:40:45 PM
    Author     : Harsh -Hiral
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Ingredeints</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor_i/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor_i/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor_i/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor_i/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css_i/util.css">
	<link rel="stylesheet" type="text/css" href="css_i/main.css">
<!--===============================================================================================-->
</head>
<body>
    
	<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100">
					<table>
						<thead>
							<tr class="table100-head">
								<th class="column1">Ingredient ID</th>
								<th class="column2">Ingredient Name</th>
								<th class="column3">Quantity</th>
								
							</tr>
						</thead>
						<tbody>
                                                
                                                <input type="text" name="n" placefolder="How many ingredients u wanna enter?" required>
<!--                                                <font color="white">Ingredients</font>
                                                                    <select name="ingredients" width=300 STYLE="width: 100px" multiple="multiple">
                                                                        <option disabled="disabled" selected="selected">Ingredients</option>
                                                                        <option value='Salt'>Salt</option>
                                                                        <option value='Chilli'>Chilli</option>
                                                                        <option value='Onion'>Onion</option>
                                                                        <option value='Garlic'>Garlic</option>
                                                                        <option value='Potato'>Potato</option>
                                                                    </select>-->
                                                    <%
//                                                        HttpSession session3 = request.getSession();
//                                                        String ing_no =(String)session3.getAttribute("ingno");
                                                       String n = request.getParameter("n");
                                                       int ingno = Integer.parseInt(n);
                                                        for(int i=0;i<ingno;i++){
                                                                        %>
								<tr>
                                                                    <td class="column1"><input type="text" name="iid"/></td>
                                                                    <td class="column2"><input type="text" name="iname"/></td>
                                                                    <td class="column3"><input type="text" name="quantity"/></td>
								</tr>
                                                                
                                                                <%
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
                                                                    %>
						</tbody>
					</table>
                                    <button type="submit"> Done </button>
				</div>
			</div>
		</div>
	</div>

<!--===============================================================================================-->	
	<script src="vendor_i/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor_i/bootstrap/js/popper.js"></script>
	<script src="vendor_i/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor_i/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>
