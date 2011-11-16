<%-- 
    Document   : MakePayment
    Created on : Nov 15, 2011, 7:52:01 PM
    Author     : David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" href="http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.css" />
    <script src="http://code.jquery.com/jquery-1.5.min.js"></script>
    <script src="http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.js"></script>
    <script type="text/javascript" src="Jquery/tablesort.min.js"></script>



    <body>
        <div data-role="header">
            <a href="http://localhost:8084/vault/main.html" data-icon="back">Back</a>
            <h1>Make Payments</h1>
            <a href="http://localhost:8084/vault/login.html" data-icon="delete">Logout</a>
            <h1 align="center">Payments to Make</h1>
        </div><!-- /header -->
        <table id="makeTable" class="tablesorter" align="center" border="2" cellpadding="2">
            <thead>

                <tr>
                    <th class = "sortable-date">Date</th>
                    <th class = "sortable-text">Vender</th>
                    <th class = "sortable-currency">Amount</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Smith</td>
                    <td>John</td>

                    <td>$50.00</td>

                </tr>
            </tbody>
        </table> 

    <center><a data-role="button" data-theme="c" data-inline="true">Make Payment</a></center>


    <div data-role="footer">
        <h4> </h4>
    </div><!-- /footer -->
</body>
</html>
