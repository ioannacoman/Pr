[#ftl]
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>-=SmartMeniu=-</title>

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
  		<nav class="navbar navbar-default navbar-fixed-top" style="background-color: #F5F6CE;>
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
  		[#list produs as produs]
<div>

<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <p><img class="img-responsive" src="/images/produse/${produs.idProdus}.jpg" ></p>
    </div>
    <div class="col-sm-8 text-left">

      <h1>${produs.numeProdus}</h1>
      <p>Contine: ${produs.descriere}</p>
      <hr>
      <h3>Pret</h3>
      <p>${produs.pret} RON</p>

    </div>

    <div class="col-sm-2 sidenav">
      <div class="btn btn-default"><a href = "/add?idProdus=${produs.idProdus}&addStatus=1">
       Adauga in Comanda</a>
      </div>

    </div>
  </div>
</div>
 [/#list]
<footer class="container-fluid text-center">
  <p>SmartMeniu</p>
</footer>

</body>
</html>
