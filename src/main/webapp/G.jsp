<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/ecmascript" src="./framesource/jquery.jqGrid-3.8.2/js/jquery-1.4.2.min.js"></script> 
    <script type="text/ecmascript" src="./framesource/jquery.jqGrid-3.8.2/js/i18n/grid.locale-en.js"></script>
    <script type="text/ecmascript" src="./framesource/jquery.jqGrid-3.8.2/js/jquery.jqGrid.min.js"></script>
    <link rel="stylesheet" type="text/css" media="screen" href="./framesource/jquery-ui-1.12.0/jquery-ui.css" />
    <link rel="stylesheet" type="text/css" media="screen" href="./framesource/jquery.jqGrid-3.8.2/css/ui.jqgrid.css" />
    <meta charset="utf-8" />
    <title>jqGrid Loading Data - Million Rows from a REST service</title>

</head>
<body>
    <table id="jqGrid"></table>
    <div id="jqGridPager"></div>

    <script type="text/javascript"> 
        $(document).ready(function () {
            $("#jqGrid").jqGrid({
                url: 'http://trirand.com/blog/phpjqgrid/examples/jsonp/getjsonp.php?callback=?&qwery=longorders',
                mtype: "GET",
                datatype: "jsonp",
                colModel: [
                    { label: 'OrderID', name: 'OrderID', key: true, width: 75 },
                    { label: 'Customer ID', name: 'CustomerID', width: 150 },
                    { label: 'Order Date', name: 'OrderDate', width: 150,
					formatter : 'date', formatoptions: { srcformat : 'Y-m-d H:i:s', newformat :'ShortDate'}},
                    { label: 'Freight', name: 'Freight', width: 150 },
                    { label:'Ship Name', name: 'ShipName', width: 150 }
                ],
				viewrecords: true,
                width: 780,
                height: 250,
                rowNum: 20,
                pager: "#jqGridPager"
            });
        });
 
   </script>

</body>
</html>