<%-- 
    Document   : main
    Author     : David
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Main Page</title>
        
      <link rel="stylesheet" href="http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.css" />
      <script src="http://code.jquery.com/jquery-1.5.min.js"></script>
      <script src="http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.js"></script>
    </head>
    <body> 
        <div data-role="page" id= "main">
            <div data-role="header" data-position="inline">
                <a href="http://localhost:8084/vault/aboutus.html" data-icon="about">About Us</a>
                <h1>GVault</h1>
                <a href="http://localhost:8084/vault/login.html" data-icon="delete">Logout</a>
            </div><!-- /header -->
            <div data-role="content" >
                <ul data-role="listview" data-dividertheme="a" style="margin-top: 0;">
                    <li data-role="list-divider">Payment</li>
                    <li><a href="#make">Make Payment<span class="ui-li-count">One Remaining</span></a></li>
                    <li><a href="#cancel">Cancel Payment</a></li>
                    <li data-role="list-divider">Account</li>
                    <li><a href="#balance">View Balance</a></li>
                    <li><a href="#payments">View Payments</a></li>
                    <li data-role="list-divider">Personal Details</li>
                    <li><a href="#pin">Change Pin</a></li>
                </ul>
            </div><!-- /content -->
        </div>




        <div data-role="page" id="make">
            <div data-role="header">
                <a href="#main" data-icon="back">Back</a>
                <h1>Make Payments</h1>
                <a href="http://localhost:8084/vault/login.html" data-icon="delete">Logout</a>
            </div><!-- /header -->
            <div data-role="content">   

            </div><!-- /content -->
            <div data-role="footer">
                <h4> </h4>
            </div><!-- /footer -->
        </div><!-- /page -->




        <div data-role="page" id="cancel" data-position="inline">
            <div data-role="header">
                <a href="#main" data-icon="back">Back</a>
                <h1>Cancel Payments</h1>
                <a href="http://localhost:8084/vault/login.html" data-icon="delete">Logout</a>
            </div><!-- /header -->
            <div data-role="content">   
                make payments
            </div><!-- /content -->
            <div data-role="footer">
                <h4> </h4>
            </div><!-- /footer -->
        </div><!-- /page -->

        <div data-role="page" id="balance">
            <div data-role="header">
                <a href="#main" data-icon="back">Back</a>
                <h1>View Balance</h1>
                <a href="http://localhost:8084/vault/login.html" data-icon="delete">Logout</a>
            </div><!-- /header -->
            <div data-role="content">   
                Screen for Navigation Two
            </div><!-- /content -->
            <div data-role="footer">
                <h4> </h4>
            </div><!-- /footer -->
        </div><!-- /page -->

        <div data-role="page" id="payments">
            <div data-role="header">
                <a href="#main" data-icon="back">Back</a>
                <h1>View Payments</h1>
                <a href="http://localhost:8084/vault/login.html" data-icon="delete">Logout</a>
            </div><!-- /header -->
            <div data-role="content">   
                Screen for Navigation Two
            </div><!-- /content -->
            <div data-role="footer">
                <h4> </h4>
            </div><!-- /footer -->
        </div><!-- /page -->

        <div data-role="page" id="pin">
            <div data-role="header">
                <a href="#main" data-icon="back">Back</a>
                <h1>Change Pin</h1>
                <a href="http://localhost:8084/vault/login.html" data-icon="delete">Logout</a>
            </div><!-- /header -->
            <div data-role="content">   
                Screen for Navigation Two
            </div><!-- /content -->
            <div data-role="footer">
                <h4> </h4>
            </div><!-- /footer -->
        </div><!-- /page -->

    </body>
</html>
