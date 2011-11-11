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
        <title>JSP Page</title>
        <link rel="stylesheet" href="http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.css" />
        <script src="http://code.jquery.com/jquery-1.5.2.min.js"></script>
        <script src="http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.js"></script> 
    </head>
    <body>
        <div data-role="header">
            <!-- begin first page -->
            <section id="page1" data-role="page"  data-theme="b">
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
                <footer data-role="footer"><h1>Vault</h1></footer>
            </section>
            <!-- end first page -->
        </div>
    </body>
</html>
