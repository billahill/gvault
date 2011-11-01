<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <header data-role="header"><h1>Vault</h1>
                    <nav data-role="navbar">
                        <ul>
                            <li><a href="#" class="ui-btn-active">Make Payment</a></li>
                            <li><a href="#">Profile</a></li>
                            <li><a href="#">Account</a></li> 
                        </ul>
                       
                    </nav>
                </header>
                <div data-role="content" class="content">
                    <p>First page!</p>

                    <h3>Buttons</h3>
                    <a href="#" data-role="button">Link-based button</a>
                    <input type="submit" value="submit" data-inline="true">
                    <input type="reset" value="reset" data-inline="true">
                    <h3>Checkboxes and Radio Buttons</h3>
                    <form id="myform" action="formprocessor.php" method="post">
                        <div data-role="fieldcontain">
                            <label for="slider-music">Ambient Music</label>
                            <select name="slider-music" id="slider-music" data-role="slider">
                                <option value="on">On</option>
                                <option value="off">Off</option>
                            </select>
                            <div data-role="fieldcontain">
                                <label for="search-restaurants">Search Restaurants:</label>
                                <input type="search" name="search-restaurants" id="search-restaurants" />
                            </div>

                        </div>
                    </form>


                    <p><a href="#page2" data-rel="dialog">HashPay Diaolog</a></p>
                </div>
                <footer data-role="footer"><h1>hash Pay </h1></footer>
            </section>
            <!-- end first page -->
            <!-- Begin second page -->
            <section id="page2" data-role="page" data-theme="b">
                <header data-role="header" data-theme="b"><h1>HashPay Mobile</h1></header>
                <div data-role="content" class="content" data-theme="b">
                    <p>Second page!</p>
                </div>
                <footer data-role="footer" data-theme="b"><h1>Hash Pay Footer</h1></footer>
            </section>
            <!-- end second page -->
        </div>
    </body>
</html>