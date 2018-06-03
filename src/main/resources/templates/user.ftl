<!doctype html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Login</title>
<meta name="description" content="" />
<meta name="viewport" content="width=device-width" />
<#--<meta name="ctx" th:content="${#httpServletRequest.getContextPath()}" />-->
<base href="/" />
<link rel="stylesheet" type="text/css" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="/webjars/jquery/jquery.min.js"></script>
<script type="text/javascript" src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/webjars/font-awesome/css/font-awesome.min.css"/>
</head>

<body>
	<div class="container">
		<div>
			El usuario es: <h1>${loggedInUser.email}</h1>
			El usuario es: <h1>${loggedInUser}</h1>
		</div>
	</div>
</body>
</html>