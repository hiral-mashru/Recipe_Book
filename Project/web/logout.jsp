<%-- 
    Document   : logout
    Created on : 24 Sep, 2019, 11:09:52 PM
    Author     : Harsh -Hiral
--%>

<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="khaki">
       

        <%
            
            session.setAttribute("abc",null);

        %>

        <h1><font color="Red">You are Sucessfully logged out...</font></h1>
        <%
            session.invalidate();
            %>
        <a href="index.html">Go-Back To Home Page</a>

   </body>
</html>
