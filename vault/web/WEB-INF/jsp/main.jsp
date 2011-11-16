

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

        <title>Main</title>
        <link rel="stylesheet" href="http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.css" />
        <script src="http://code.jquery.com/jquery-1.5.min.js"></script>
        <script src="http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.js"></script>
        <script type="text/javascript" src="Jquery/tablesort.min.js"></script>
        <script type = "text/javascript">  
    
	
	
        </script>
    </head>


    <body> 
        <div data-role="header" data-position="inline">
            <a href="http://localhost:8084/vault/aboutus.html" data-icon="about">About Us</a>
            <h1>GVault</h1>
            <a href="http://localhost:8084/vault/login.html" data-icon="delete">Logout</a>
        </div><!-- /header -->
        <div data-role="content" >
            <ul data-role="listview" data-dividertheme="a" style="margin-top: 0;">
                <li data-role="list-divider">Payment</li>
                <li><a href="http://localhost:8084/vault/makepayment.html">Make Payment<span class="ui-li-count">One Remaining</span></a></li>
                <li><a href="http://localhost:8084/vault/viewpayments.html">View Payments</a></li>
                <li data-role="list-divider">Account</li>

                <li><a href="http://localhost:8084/vault/balance.html">View Balance</a></li>

                <li data-role="list-divider">Personal Details</li>
                <li><a href= "http://localhost:8084/vault/personaldetails.html">View Personal Details</a></li>
                <li><a href="http://localhost:8084/vault/pin.html">Change Pin</a></li>
            </ul>
        </div><!-- /content -->


        <footer data-role="footer"><h1> </h1></footer>
    </body>
    <!-- /footer -->
</html>
