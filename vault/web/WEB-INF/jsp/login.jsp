<%-- 
    Document   : login
    Created on : 01 Nov 2011, 10:34:56 AM
    Author     : Carlos
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter" %>
<%@ page import="org.springframework.security.web.authentication.AuthenticationFailureHandler" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Login Page</title>
        
      <link rel="stylesheet" href="http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.css" />
      <script src="http://code.jquery.com/jquery-1.5.min.js"></script>
      <script src="http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.js"></script>
    </head>
    <body>
        
            <!-- begin first page -->
            <section id="page1" data-role="page"  data-theme="b">
            <div data-role="header"><h1>Wecome To GVault</h1></div>
                <form action="j_spring_security_check">
                    <div data-role="fieldcontain">
                    <label for="j_username">Username:</label>
                    <input type="text" name="j_username" id="j_username" <c:if test="${not empty param.login_error}">value='<%= session.getAttribute(AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY)%>'</c:if>/>
                    <br/>
                    <label for="j_password">Password:</label>
                    <input type="password" name="j_password" id="j_password"/>
                    <br/>
                    <input type="submit" value="Login" data-role="button" data-theme="c" data-inline="true"/>
                    </div>
                </form>
                <footer data-role="footer"><h1> </h1></footer>
            </section>
            <!-- end first page -->
        
    </body>
</html>
