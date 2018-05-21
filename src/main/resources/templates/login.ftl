<#--
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Login</title>
<meta name="description" content="" />
<meta name="viewport" content="width=device-width" />
<base href="/" />
<link rel="stylesheet" type="text/css" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="/webjars/jquery/jquery.min.js"></script>
<script type="text/javascript" src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/webjars/font-awesome/css/font-awesome.min.css"/>
</head>

<body>
	<div class="container">
		<h1>Login Using</h1>

		<form action="/connect/google" method="POST" style="display: inline">
			<input type="hidden" name="scope" value="profile email" />
			<button type="submit" class="btn btn-danger">
				Google <span class="fa fa-google-plus"></span>
			</button>
		</form>

		<form action="/connect/facebook" method="POST" style="display: inline">
			<input type="hidden" name="scope" value="public_profile,email" />
			<button type="submit" class="btn btn-primary">
				Facebook <span class="fa fa-facebook"></span>
			</button>
		</form>

		<form action="/connect/linkedin" method="POST" style="display: inline">
			<input type="hidden" name="scope"
				value="r_basicprofile,r_emailaddress" />
			<button type="submit" class="btn btn-primary">
				LinkedIn <span class="fa fa-linkedin"></span>
			</button>
		</form>
	</div>
</body>
</html>-->
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Education &mdash; Free Website Template, Free HTML5 Template by freehtml5.co</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Free HTML5 Website Template by freehtml5.co"/>
    <meta name="keywords"
          content="free website templates, free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive"/>
    <meta name="author" content="freehtml5.co"/>

    <!--
	//////////////////////////////////////////////////////

	FREE HTML5 TEMPLATE
	DESIGNED & DEVELOPED by FreeHTML5.co

	Website: 		http://freehtml5.co/
	Email: 			info@freehtml5.co
	Twitter: 		http://twitter.com/fh5co
	Facebook: 		https://www.facebook.com/fh5co

	//////////////////////////////////////////////////////
	 -->

    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">


    <link rel="stylesheet" href="css/styles/style.css">

    <!-- So we can work with the import of the modal-->
    <link rel="stylesheet" type="text/css" href="/education/modal_register/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="/education/modal_register/font-awesome/css/font-awesome.min.css"/>

    <script type="text/javascript" src="/education/modal_register/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="/education/modal_register/bootstrap/js/bootstrap.min.js"></script>


    <!-- Facebook and Twitter integration -->
    <meta property="og:title" content=""/>
    <meta property="og:image" content=""/>
    <meta property="og:url" content=""/>
    <meta property="og:site_name" content=""/>
    <meta property="og:description" content=""/>
    <meta name="twitter:title" content=""/>
    <meta name="twitter:image" content=""/>
    <meta name="twitter:url" content=""/>
    <meta name="twitter:card" content=""/>

    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:300,400" rel="stylesheet">

    <!-- Animate.css -->
    <link rel="stylesheet" href="css/animate.css">
    <!-- Icomoon Icon Fonts-->
    <link rel="stylesheet" href="css/icomoon.css">
    <!-- Bootstrap  -->
    <link rel="stylesheet" href="css/bootstrap.css">

    <!-- Magnific Popup -->
    <link rel="stylesheet" href="css/magnific-popup.css">

    <!-- Owl Carousel  -->
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">

    <!-- Flexslider  -->
    <link rel="stylesheet" href="css/flexslider.css">

    <!-- Pricing -->
    <link rel="stylesheet" href="css/pricing.css">

    <!-- Theme style  -->
    <link rel="stylesheet" href="css/style.css">

    <!-- Modernizr JS -->
    <script src="js/modernizr-2.6.2.min.js"></script>
    <!-- FOR IE9 below -->
    <!--[if lt IE 9]>
    <script src="js/respond.min.js"></script>
    <![endif]-->
    <link rel="import" href="/education/nav.html">


</head>

<body>

<div class="fh5co-loader"></div>


<div id="page">

    <nav class="fh5co-nav" role="navigation">
        <div class="top">
            <div class="container">
                <div class="row">
                    <div class="col-xs-12 text-right">
                        <p class="site">www.yourdomainname.com</p>
                        <p class="num">Call: +01 123 456 7890</p>
                        <ul class="fh5co-social">
                            <li><a href="#"><i class="icon-facebook2"></i></a></li>
                            <li><a href="#"><i class="icon-twitter2"></i></a></li>
                            <li><a href="#"><i class="icon-dribbble2"></i></a></li>
                            <li><a href="#"><i class="icon-github"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="top-menu">
            <div class="container">
                <div class="row">
                    <div class="col-xs-2">
                        <div id="fh5co-logo"><a href="index.html"><i
                                class="icon-study"></i>CabAcademie<span>.</span></a></div>
                    </div>
                    <div class="col-xs-10 text-right menu-1">
                        <ul>
                            <li class="active"><a href="index.html">Accueil</a></li>
                            <li class="has-dropdown"><a href="courses.html">Cours</a>
                                <ul class="dropdown">
                                    <li><a href="#">Web Design</a></li>
                                    <li><a href="#">Mathematiques</a></li>
                                    <li><a href="#">Anglais</a></li>
                                    <li><a href="#">Prefac</a></li>
                                </ul>
                            </li>
                            <li><a href="teacher.html">Enseignants</a></li>
                            <li><a href="about.html">A propos</a></li>
                            <li><a href="pricing.html">Prix</a></li>

                            <!--
<li class="has-dropdown">
<a href="blog.html">Blog</a>
<ul class="dropdown">
    <li><a href="#">Web Design</a></li>
    <li><a href="#">eCommerce</a></li>
    <li><a href="#">Branding</a></li>
    <li><a href="#">API</a></li>
</ul>
</li>
-->

                            <li><a href="contact.html">Contactez-nous</a></li>
                            <li class="btn-cta"><a href="/education/login.html"><span>Conexion</span></a></li>
                            <li class="btn-cta"><a href="#"><span>Creer un cours</span></a></li>
                        </ul>
                    </div>
                </div>

            </div>
        </div>
    </nav>

    <div>
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <div class="row">
                        <div class="col-sm-4 col-sm-offset-4 col-xs-10 col-xs-offset-1">

                            <div class="loginWith">
                                <h6><b style="color: brown">Se connecter avec:</b></h6>
                                <#--<a><i class="fa fa-facebook"></i></a>-->
                                <#--<a><i class="fa fa-twitter"></i></a>-->
                                <#--<a><i class="fa fa-google noBorder"></i></a>-->

                                <form action="/connect/google" method="POST" style="display: inline">
                                    <input type="hidden" name="scope" value="profile email" />
                                    <button type="submit" class="btn-link fa fa-google noBorder">oogle
                                    </button>
                                </form>

                                <form action="/connect/facebook" method="POST" style="display: inline">
                                    <input type="hidden" name="scope" value="public_profile,email" />
                                    <button type="submit" class="btn-link fa fa-facebook noBorder">acebook
                                    </button>
                                </form>

                                <form action="/connect/linkedin" method="POST" style="display: inline">
                                    <input type="hidden" name="scope" value="public_profile,email" />
                                    <button type="submit" class="btn-link fa fa-linkedin noBorder"> linkedin
                                    </button>
                                </form>
                            </div>

                            <div class="signUpForm">
                                <div class="head">
                                    <img src="/images/course_1.jpg" alt="Subscribe"/>
                                </div>
                                <form role="form" class="flp">
                                    <div class="input-group has-feedback">
                                        <label class="sr-only" for="exEmail">Email ou Nom d'utilisateur</label>
                                        <input style="height: 50px" type="email" class="form-control" id="exEmail"
                                               placeholder="Email ou Nom d'utilisateur">
                                        <div class="input-group-addon"><i class="fa fa-envelope"></i></div>
                                    </div>
                                    <div class="input-group">
                                        <label class="sr-only" for="exPassword">Mot de passe</label>
                                        <input style="height: 50px" type="password" class="form-control" id="exPassword"
                                               placeholder="Mot de passe">
                                        <div class="input-group-addon"><i class="fa fa-lock"></i></div>
                                    </div>
                                    <button type="submit" class="btn btn-primary btn-block" id="loading-example-btn"
                                            data-loading-text="Logining in...">Conexion
                                    </button>
                                    <button type="button" class="btn btn-success btn-block pb-modalreglog-submit"
                                            data-toggle="modal" data-target="#myModal2">S'inscrire
                                    </button>
                                    <a href="/">Forgot Password?</a>
                                </form>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-md" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">Registration form</h4>
            </div>
            <div class="modal-body">
                <form class="pb-modalreglog-form-reg">
                    <div class="form-group">
                        <div id="pb-modalreglog-progressbar"></div>
                    </div>
                    <div class="form-group">
                        <label for="email">Email address</label>
                        <div class="input-group pb-modalreglog-input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                            <input type="email" class="form-control" id="inputEmail" placeholder="Email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <div class="input-group pb-modalreglog-input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                            <input type="password" class="form-control" id="inputPws" placeholder="Password">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="confirmpassword">Confirm password</label>
                        <div class="input-group pb-modalreglog-input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                            <input type="password" class="form-control" id="inputConfirmPws"
                                   placeholder="Confirm Password">
                        </div>
                    </div>

                    <div class="form-group">
                        <input type="checkbox" id="ch" name="chs"> I agree with <a href="#">terms and conditions.</a>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">S'inscrire</button>
            </div>
        </div>
    </div>
</div>


<div class="gototop js-top">
    <a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
</div>

<!-- jQuery -->
<script src="js/jquery.min.js"></script>
<!-- jQuery Easing -->
<script src="js/jquery.easing.1.3.js"></script>
<!-- Bootstrap -->
<script src="js/bootstrap.min.js"></script>
<!-- Waypoints -->
<script src="js/jquery.waypoints.min.js"></script>
<!-- Stellar Parallax -->
<script src="js/jquery.stellar.min.js"></script>
<!-- Carousel -->
<script src="js/owl.carousel.min.js"></script>
<!-- Flexslider -->
<script src="js/jquery.flexslider-min.js"></script>
<!-- countTo -->
<script src="js/jquery.countTo.js"></script>
<!-- Magnific Popup -->
<script src="js/jquery.magnific-popup.min.js"></script>
<script src="js/magnific-popup-options.js"></script>
<!-- Count Down -->
<script src="js/simplyCountdown.js"></script>
<!-- Main -->
<script src="js/main.js"></script>
<script>
    var d = new Date(new Date().getTime() + 1000 * 120 * 120 * 2000);

    // default example
    simplyCountdown('.simply-countdown-one', {
        year: d.getFullYear(),
        month: d.getMonth() + 1,
        day: d.getDate()
    });

    //jQuery example
    $('#simply-countdown-losange').simplyCountdown({
        year: d.getFullYear(),
        month: d.getMonth() + 1,
        day: d.getDate(),
        enableUtc: false
    });
</script>

<!--
<script>
    $(function() {
        $("#includedContent").load("/education/nav.html");
    });
</script>
-->
</body>
</html>


