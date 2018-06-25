<!DOCTYPE HTML>
<html ng-app="cabAcademie">
	<head>
		<meta charset="utf-8"/>
		<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
		<title>CabAcademie</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="Free HTML5 Website Template by freehtml5.co" />
		<meta name="keywords" content="free website templates, free html5, free templates, free bootstrap, free website templates, html5, css3, mobile first, responsive" />
		<meta name="author" content="freehtml5.co" />
		<style type="text/css">
			[ng\:cloak], [ng-cloak], .ng-cloak {
				display: none !important;
			}
		</style>

		<!-- Facebook and Twitter integration -->
		<meta property="og:title" content=""/>
		<meta property="og:image" content=""/>
		<meta property="og:url" content=""/>
		<meta property="og:site_name" content=""/>
		<meta property="og:description" content=""/>
		<meta name="twitter:title" content="" />
		<meta name="twitter:image" content="" />
		<meta name="twitter:url" content="" />
		<meta name="twitter:card" content="" />
		<link rel="icon" type="image/png" href="images/favicon.co"/>
		<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet"/>
		<link href="https://fonts.googleapis.com/css?family=Roboto+Slab:300,400" rel="stylesheet"/>

        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/angular_material/1.1.0/angular-material.min.css">

        <!-- Animate.css -->
		<link rel="stylesheet" href="css/animate.css"/>
		<!-- Icomoon Icon Fonts-->
		<link rel="stylesheet" href="css/icomoon.css"/>
		<!-- Bootstrap  -->
		<link rel="stylesheet" href="css/bootstrap.css"/>

		<!-- Magnific Popup -->
		<link rel="stylesheet" href="css/magnific-popup.css"/>

		<!-- Owl Carousel  -->
		<link rel="stylesheet" href="css/owl.carousel.min.css"/>
		<link rel="stylesheet" href="css/owl.theme.default.min.css"/>

		<!-- Flexslider  -->
		<link rel="stylesheet" href="css/flexslider.css"/>

		<!-- Pricing -->
		<link rel="stylesheet" href="css/pricing.css"/>

        <!-- Theme style  -->
        <link rel="stylesheet" href="css/style.css"/>

        <script src="js/modernizr-2.6.2.min.js"></script>

        <!-- Modernizr JS -->
        <!-- FOR IE9 below -->
        <!--[if lt IE 9]>
        <script src="js/respond.min.js"></script>
        <![endif]-->

        <script src="js/angular.js"></script>
        <script src="js/angular-route.js"></script>
        <script src="js/angular-ui-router.js"></script>
        <script src="js/angular/app.js"></script>
        <!-- Angular Material Library -->
        <script src="http://ajax.googleapis.com/ajax/libs/angular_material/1.1.0/angular-material.min.js"></script>
        <script src="js/angular-aria.js"></script>
        <script src="js/angular-messages.js"></script>
    </head>
    <!-- header goes here -->
    <!--<div ng-include="'particourse.ftlhtml'"></div>-->
    <body ng-cloak class="ng-cloak">
    <div id="page">
            <div ng-include src="'partials/nav.ftl'"></div>
            <!-- aside goes here  -->
        <#--<div ng-include src="'partials/aside.ftl'"></div>-->
            <div ui-view    ></div>
            <!-- footer goes here -->
            <div ng-include src="'partials/footer.ftl'"></div>
        </div>
        <!-- scripts goes here -->
        <div class="gototop js-top">
        <a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
    </div>

    <script src="js/angular/services/CourseService.js"></script>
    <script src="js/angular/controllers/LoginController.js"></script>
    <script src="js/angular/controllers/HomeController.js"></script>
    <script src="js/angular/controllers/CourseController.js"></script>
    <script src="js/angular-animate.js"></script>
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
	</body>
</html>

