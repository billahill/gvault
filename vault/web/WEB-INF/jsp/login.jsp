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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="j_spring_security_check">
	<label for="j_username">Username</label>
	<input type="text" name="j_username" id="j_username" <c:if test="${not empty param.login_error}">value='<%= session.getAttribute(AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY) %>'</c:if>/>
	<br/>
	<label for="j_password">Password</label>
	<input type="password" name="j_password" id="j_password"/>
	<br/>
	<input type='checkbox' name='_spring_security_remember_me'/> Remember me on this computer.
	<br/>
	<input type="submit" value="Login"/>
</form>
    </body>
</html>
