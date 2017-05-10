[#ftl]
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Smart Meniu</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
<div>
<table class="table">
    <tr>
        <th>Nr.Crt</th>
        <th>Nume Produs</th>
        <th>Continut</th>
        <th>Cantitate</th>
        <th></th>
        <th>Pret</th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    <tr></tr>
    [#list produseComandate as produseComandate]
    <tr>
        <td>${produseComandate.nrCrt}</td>
        <td>${produseComandate.numeProdus}</td>
        <td>${produseComandate.descriere}</td>
        <td>${produseComandate.cant}</td>
        <td>${produseComandate.buc}</td>
        <td>${produseComandate.pret}</td>
        <td><span class="glyphicon glyphicon-plus" aria-hidden="true"></td>
        <th></th>
        <th></th>
    </tr>
    [/#list]
</table>
</div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>