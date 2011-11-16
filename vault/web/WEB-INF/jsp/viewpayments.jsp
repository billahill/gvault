<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <style>

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

    </style>
    <title>Main</title>
    <link rel="stylesheet" href="http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.css" />
    <script src="http://code.jquery.com/jquery-1.5.min.js"></script>
    <script src="http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.js"></script>
    <script type="text/javascript" src="Jquery/tablesort.min.js"></script>


    <body>
        <div data-role="header">
            <a href="http://localhost:8084/vault/main.html" data-icon="back">Back</a>
            <h1>View Payments</h1>
            <a href="http://localhost:8084/vault/login.html" data-icon="delete">Logout</a>
        </div><!-- /header -->
        <h3 align="center">Payments</h3>
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





            <div data-role="footer">
                <h4> </h4>
            </div><!-- /footer -->
    </body>
</html>