[#ftl]
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>-=SmartMeniu-ODM=-</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <style>
          			body{
          				background-color: lightgray
          				}
          		</style>
  <body id="index" data-spy="scroll" data-target=".navbar" data-offset="50">
  		<nav class="navbar navbar-default navbar-fixed-top" style="background-color: #ffe699;>
  			<div class="container-fluid">
  				<div class="navbar-header">
  					<a class="navbar-brand" href="/meniu"><span class="glyphicon glyphicon-backward"></span> SmartMeniu </a>
  				    <a class="navbar-brand"> <span class="glyphicon glyphicon-bookmark"></span> Ordin de Masa <span class="glyphicon glyphicon-bookmark"></span> </a>
  				</div>
  			</div>
  		</nav>
  		<p>.</p>
  		<p>.</p>
<div>
<table class="table">
    <tr class="success">
        <th>Nr.Crt</th>
        <th></th>
        <th>Nume Produs</th>
        <th>Cantitate</th>
        <th>Pret</th>
        <th>Pret Total</th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    <tr></tr>
    [#list produseComandate as produseComandate]
    <tr class="info">
        <td>${produseComandate.nrCrt}</td>
        <td><img src="/images/produse/${produseComandate.idProdus}.jpg" width="120" height="90"></td>
        <td><a href="/produse?idProdus=${produseComandate.idProdus}">${produseComandate.gama} - ${produseComandate.numeProdus}</a></td>
        <td>${produseComandate.cant} ${produseComandate.unitateMasura}</td>
        <td>${produseComandate.buc} x ${produseComandate.pret}</td>
        <td>${produseComandate.pretTotal} RON</td>
        <td><a href = "/add?idProdus=${produseComandate.idProdus}&addStatus=2"><span class="glyphicon glyphicon-plus"></a></td>
        <th><a href = "/remove?idProdus=${produseComandate.idProdus}&aOrb=1"><span class="glyphicon glyphicon-minus" aria-hidden="true"></th>
        <th><a href = "/remove?idProdus=${produseComandate.idProdus}&aOrb=2"><span class="glyphicon glyphicon-remove"></th>
    </tr>
    [/#list]
</table>
<p>.</p>
 <p>.</p>
<nav class="navbar navbar-default navbar-fixed-bottom" style="background-color: lightgreen;>
  			<div class="container-fluid">
  				<div class="navbar-header">
  					<a href="/abandon" class="btn btn-danger btn-sm""><span class="glyphicon glyphicon-remove-circle"></span> Anulare Comanda! </a>
  				    <a href="/finish" class="btn btn-success btn-sm""><span class="glyphicon glyphicon-ok-circle"></span> Trimite Comanda! </a>
  					<span>Total Comanda: ${suma.suma} RON</span>

  				</div>
  			</div>
  		</nav>
</div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>