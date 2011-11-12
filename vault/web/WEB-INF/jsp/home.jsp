<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
       
      <link rel="stylesheet" href="http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.css" />
      <script src="http://code.jquery.com/jquery-1.5.min.js"></script>
      <script src="http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.js"></script>
    </head>
    <body>


        <!-- begin first page -->
        <section id="page1" data-role="page"  data-theme="b">
            <div data-role="header"><h1>GVault</h1></div>
            <div data-role="content" class="content">
                <center><img src="images\logo.png" /></center>
                <center><a href="http://localhost:8084/vault/login.html" data-role="button" data-theme="c" data-inline="true">Sign in</a> | <a href="http://localhost:8084/vault/aboutus.html" data-role="button" data-theme="c" data-inline="true">About us</a> |<a href="http://localhost:8084/vault/contactus.html" data-role="button" data-theme="c" data-inline="true">Contact Us</a></center>
            </div>
            <footer data-role="footer"><h1> </h1></footer>
        </section>
        <!-- end first page -->
</body>
</html>