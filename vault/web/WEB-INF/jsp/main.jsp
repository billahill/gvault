

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

    <!--    <style>

            table
            {
                width: auto;
                padding: 0;
                margin: 0 auto 1.5em auto;

                border-collapse:collapse;
            }

            caption
            {
                padding: 0 0 5px 0;
                margin:0 auto;
                width:auto;
                font: italic 11px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
                text-align: right;
            }
            th
            {
                font: bold 10px/22px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
                color: #4f6b72;
                border: 1px solid #C1DAD7;
                letter-spacing: 1px;
                text-transform: uppercase;
                text-align: left;
                padding: 8px 12px 4px 12px;
                background: #CAE8EA url(../media/bg_header.jpg) no-repeat;
                vertical-align:middle;
            }
            td.total
            {
                border-top: 0;
                border-left: 0;
                border-right: 1px solid #C1DAD7;
                background: none;
                text-align:right;
                font-weight:bold;
                text-transform:uppercase;
                letter-spacing:1px;
            }

            th.forwardSort
            {
                background:#CAE8EA url(../media/bg_header_down.jpg) no-repeat 0 0;
            }
            th.reverseSort
            {
                background:#CAE8EA url(../media/bg_header_up.jpg) no-repeat 0 0;
            }
            table thead th.forwardSort a,
            table thead th.reverseSort a
            {
                color:#000;
                text-decoration:none;
            }

            th a
            {
                text-decoration:none;
                color: #4f6b72;
                background:transparent;
            }
            td a
            {
                text-decoration:none;
                color:#239;
                background:transparent;
            }
            td img
            {
                margin:0 auto;
                border:3px solid #ddd;
            }

            td
            {
                font: normal 11px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
                border-right: 1px solid #C1DAD7;
                border-bottom: 1px solid #C1DAD7;
                padding: 6px 12px 6px 12px;
                color: #4f6b72;
            }
            td.lft
            {
                text-align:left;
            }
            tr.alt
            {
                background: #F5FAFA;
                color: #797268;
            }

        </style>-->
        <title>Main</title>
       <!-- <link rel="stylesheet" href="Jquery/jm.css" />
        <script type="text/javascript" src="Jquery/jq.min.js"></script>
        <script type="text/javascript" src="Jquery/jm.js"></script>
        <script type="text/javascript" src="Jquery/tablesort.min.js"></script>
        <script type = "text/javascript">  -->
    
	     <link rel="stylesheet" href="http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.css" />
      <script src="http://code.jquery.com/jquery-1.5.min.js"></script>
      <script src="http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.js"></script>
	
    </head>


    <body> 
        <div data-role="page" id= "main" data-theme="b">
            <div data-role="header" data-position="inline">
                <a href="http://localhost:8084/vault/aboutus.html" data-icon="about">About Us</a>
                <h1>Vault</h1>
                <a href="http://localhost:8084/vault/login.html" data-icon="delete">Logout</a>
            </div><!-- /header -->
            <div data-role="content" data-theme="b">
                <ul data-role="listview" data-dividertheme="b" style="margin-top: 0;">
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




        <div data-role="page" id="make" data-theme="b">
            <div data-role="header">
                <a href="#main" data-icon="back">Back</a>
                <h1>Make Payments</h1>
                <a href="http://localhost:8084/vault/login.html" data-icon="delete">Logout</a>
            </div><!-- /header -->
            <div data-role="content" data-theme="b"> 
                <h1 align="center">Payments to Make</h1>
                <table id="makeTable" class="tablesorter">
                    <table border="2" bordercolor="#48A299">
                        <thead>

                            <tr>
                                <th class = "sortable-date">Date</th>
                                <th class = "sortable-text">Vender</th>
                                <th class = "sortable-currency">Ammount</th>
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
            </div><!-- /content -->
            <div data-role="footer">
                <h4> </h4>
            </div><!-- /footer -->
        </div><!-- /page -->




        <div data-role="page" id="cancel" data-position="inline" data-theme="b">
            <div data-role="header">
                <a href="#main" data-icon="back">Back</a>
                <h1>Cancel Payments</h1>
                <a href="http://localhost:8084/vault/login.html" data-icon="delete">Logout</a>
            </div><!-- /header -->
            <div data-role="content" data-theme="b">   
                <h1 align="center">Balances</h1>
                <table id="cancelTable" class="tablesorter">
                    <table border="2" bordercolor="#48A299">
                        <thead>

                            <tr>
                                <th class = "sortable-date">Date</th>
                                <th class = "sortable-text">Vender</th>
                                <th class = "sortable-currency">Ammount</th>
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
            </div><!-- /content -->
            <div data-role="footer">
                <h4> </h4>
            </div><!-- /footer -->
        </div><!-- /page -->

        <div data-role="page" id="balance" data-theme="b">
            <div data-role="header">
                <a href="#main" data-icon="back">Back</a>
                <h1>Cancel Payments</h1>
                <a href="http://localhost:8084/vault/login.html" data-icon="delete">Logout</a>
            </div><!-- /header -->

            <div data-role="content" data-theme="b">
                <h1 align="center">View Balances</h1>
                <table id="balanceTable" class="tablesorter">
                    <table border="2" bordercolor="#48A299">
                        <thead>

                            <tr>
                                <th class = "sortable-date">Date</th>
                                <th class = "sortable-currency">Ammount Withdrawn</th>
                                <th class = "sortable-currency">Ammount Added</th>
                                <th class = "sortable-currency">Availble</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>10 March 2011</td>
                                <td></td>
                                <td>R45.00</td>
                                <td>R45.00</td>

                            </tr>
                            <tr>
                                <td>15 March 2011</td>
                                <td>R35.00</td>
                                <td></td>
                                <td>R10.00</td>

                            </tr>
                        </tbody>
                    </table>


            </div><!-- /content -->
            <div data-role="footer">
                <h4> </h4>
            </div><!-- /footer -->
        </div><!-- /page -->

        <div data-role="page" id="payments" data-theme="b">
            <div data-role="header">
                <a href="#main" data-icon="back">Back</a>
                <h1>View Payments</h1>
                <a href="http://localhost:8084/vault/login.html" data-icon="delete">Logout</a>
            </div><!-- /header -->
            <div data-role="content" data-theme="b"> 
                <h1 align="center"> Payments Made</h1>
                <table id="paymentTable" class="tablesorter">
                    <table border="2" bordercolor="#48A299">
                        <thead>

                            <tr>
                                <th class = "sortable-date">Date</th>
                                <th class = "sortable-text">Vender</th>
                                <th class = "sortable-currency">Ammount</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Smith</td>
                                <td>John</td>

                                <td>$50.00</td>

                            </tr>
                            <tr>
                                <td>Bach</td>
                                <td>Frank</td>

                                <td>$50.00</td>

                            </tr>
                            <tr>
                                <td>Doe</td>
                                <td>Jason</td>

                                <td>$100.00</td>

                            </tr>
                            <tr>
                                <td>Conway</td>
                                <td>Tim</td>

                                <td>$50.00</td>

                            </tr>
                        </tbody>
                    </table>




            </div><!-- /content -->
            <div data-role="footer">
                <h4> </h4>
            </div><!-- /footer -->
        </div><!-- /page -->

        <div data-role="page" id="pin" data-theme="b">
            <div data-role="header">
                <a href="#main" data-icon="back">Back</a>
                <h1>Change Pin</h1>
                <a href="http://localhost:8084/vault/login.html" data-icon="delete">Logout</a>
            </div><!-- /header -->
            <div data-role="content" data-theme="b">   
                <p> Old Password<input id ="old" type = "text" /> 
                    New Password<input id ="new" type = "text" /></p>
                <center><a data-role="button" data-theme="c" data-inline="true">Sign in</a>
                    <span id = "saveStatus"></span>
                   
            </div><!-- /content -->
            <div data-role="footer">
                <h4> </h4>
            </div><!-- /footer -->
        </div><!-- /page -->

    </body>
</html>
