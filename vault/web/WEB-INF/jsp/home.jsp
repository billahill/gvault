<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>jQuery Mobile Application</title>
         <link rel="stylesheet" href="http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.css" />
        <script src="http://code.jquery.com/jquery-1.5.2.min.js"></script>
        <script src="http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.js"></script> 
    </head>
    <body>
     
        <div data-role="header">
            <!-- begin first page -->
            <section id="page1" data-role="page"  data-theme="b">

                <div data-role="content" class="content">
                    <center><img src="images\logo.png" /></center>
                    <center><a href="http://localhost:8084/vault/login.html" data-role="button" data-theme="c" data-inline="true">Sign in</a> | <a href="http://localhost:8084/vault/aboutus.html" data-role="button" data-theme="c" data-inline="true">About us</a> | Contact us</center>
                </div>
                <footer data-role="footer"><h1>Vault</h1></footer>
            </section>
            <!-- end first page -->
        </div>
    </body>
</html>