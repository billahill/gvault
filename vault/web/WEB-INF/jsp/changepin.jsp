<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <title>Pin</title>
    <link rel="stylesheet" href="http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.css" />
    <script src="http://code.jquery.com/jquery-1.5.min.js"></script>
    <script src="http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.js"></script>
    <script type="text/javascript" src="Jquery/tablesort.min.js"></script>


    <body> 
        <div data-role="header">
            <a href="http://localhost:8084/vault/main.html" data-icon="back">Back</a>
            <h1>Change Pin</h1>
            <a href="http://localhost:8084/vault/login.html" data-icon="delete">Logout</a>
        </div><!-- /header -->
        <div data-role="fieldcontain">
            <p align="center">   <label for="j_oldPassword">Old Password:</label>
                <input type="text" name="j_username" id="j_username"/>
                <br/>
                <label for="j_newPassword">New Password:</label>
                <input type="password" name="j_password" id="j_password"/>
            </p>
            <center><a data-role="button" data-theme="c" data-inline="true">Save Pin</a></center>
            <span id = "saveStatus"></span>
        </div>  
        <div data-role="footer">
            <h4> </h4>
        </div><!-- /footer -->     
    </body>
</html>