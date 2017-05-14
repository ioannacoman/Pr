[#ftl]
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
		<title>-=SmartMeniu-${gama.gama}=-</title>
		<!-- Bootstrap -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
		<style>
                			body{
                				background-color: lightyellow
                				}
                		</style>
	</head>
	<body id="index" data-spy="scroll" data-target=".navbar" data-offset="50">
		<nav class="navbar navbar-default navbar-fixed-top" style="background-color: #ffe699;>
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="/meniu"><span class="glyphicon glyphicon-backward"></span> SmartMeniu </a>
				    <a class="navbar-brand"> <span class="glyphicon glyphicon-object-align-right"></span> ${gama.gama} <span class="glyphicon glyphicon-object-align-left"></span> </a>
    			</div>
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="/comanda" class="btn btn-default btn-sm""><span class="glyphicon glyphicon-bookmark"></span> Ordin de masa <span class="glyphicon glyphicon-bookmark"></span></a></li>
						<li><a href>${suma.suma} RON</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<p>.</p>
		<p>.</p>
		<div>
			<table class="table">
				<tr>
					<th>Nr.Crt</th>
					<th>Poza Produs</th>
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
				[#list produs as produs]
				<tr>
					<td>${produs.nrCrt}</td>
					<td><img src="/images/produse/${produs.idProdus}.jpg" width="120" height="90"></td>
					<td><a href="/produse?idProdus=${produs.idProdus}">${produs.numeProdus}</a></td>
					<td><h6>${produs.descriere}</h6></td>
					<td>${produs.cant} ${produs.unitateMasura}</td>
					<td></td>
					<td>${produs.pret} RON</td>
					<td><a href = "/add?idProdus=${produs.idProdus}&addStatus=1"><span class="glyphicon glyphicon-plus"></a></td>
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