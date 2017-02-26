<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>


<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/footer.css" />

<div class="section">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<hr>
			</div>
		</div>
	</div>
</div>
<div class="section">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1 class="text-center">
					<spring:message code="footer.subscribe.label" />
				</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-offset-3 col-md-6">
				<form role="form">
					<div class="form-group">
						<div class="input-group">
							<input type="text" class="search-query form-control" id="mail" placeholder="<spring:message code="footer.enter.label" />">
							<span class="input-group-btn"> <a class="btn btn-success" id="submail" type="submit">Ok</a>
							</span>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<div class="section">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<hr>
			</div>
		</div>
	</div>
</div>
<!--footer-->

<footer class="footer1">
	<div class="container">

		<div class="row">
			<!-- row -->

			<div class="col-lg-3 col-md-3 col-md-offset-3">
				<!-- widgets column left -->

				<ul class="list-unstyled clear-margins">
					<!-- widgets -->

					<li class="widget-container widget_nav_menu">
						<!-- widgets list -->

						<h1 class="title-widget">
							<spring:message code="footer.useful.label" />
						</h1>

						<ul>


							<li><a href="mailto:Loonger@gmail.com"><i
									class="fa fa-angle-double-right"></i> <spring:message
										code="footer.ask.label" /></a></li>
							<li><a
								href="https://www.google.pl/maps/@49.3806827,25.5071849,4.83z"><i
									class="fa fa-angle-double-right"></i> <spring:message
										code="footer.maps.label" /></a></li>
							<li><a
								href="https://www.viamichelin.com/web/Weather/"><i
									class="fa fa-angle-double-right"></i> <spring:message
										code="footer.weather.label" /></a></li>


						</ul>

					</li>

				</ul>


			</div>
			<!-- widgets column left end -->


			<div class="col-lg-3 col-md-3 col-md-offset-1">
				<!-- widgets column center -->



				<ul class="list-unstyled clear-margins">
					<!-- widgets -->

					<li class="widget-container widget_recent_news">
						<!-- widgets list -->

						<h1 class="title-widget">
							<spring:message code="footer.contact.label" />
						</h1>

						<div class="footerp">

							<h2 class="title-median">Loonger ®</h2>
							<p>
								<b>Email: </b> <a href="mailto:info@Longer.com">info@Longer.com</a>
							</p>
							<p>
								<b><spring:message code="footer.helpline.label" /></b> <b
									style="color: #ffc106;">(8AM to 10PM):</b> +91-8130890090,
								+91-8130190010
							</p>

							<p>
								<b><spring:message code="footer.address.label" /> : </b>
								<spring:message code="footer.adr.label" />
							</p>
							<p>
								<b>Phone Number : </b>(+48) 555-532-111
							</p>

						</div>

						<div class="social-icons">

							<ul class="nomargin">

								<a href="https://www.facebook.com"><i
									class="fa fa-facebook-square fa-3x social-fb" id="social"></i></a>
								<a href="https://twitter.com"><i
									class="fa fa-twitter-square fa-3x social-tw" id="social"></i></a>
								<a href="https://plus.google.com/"><i
									class="fa fa-google-plus-square fa-3x social-gp" id="social"></i></a>
								<a href="mailto:Loonger@gmail.com"><i
									class="fa fa-envelope-square fa-3x social-em" id="social"></i></a>

							</ul>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
</footer>
<!--header-->

<div class="footer-bottom">

	<div class="container">

		<div class="row">

			<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">

				<div class="copyright">© 2017 | LongerCompany | All rights
					reserved</div>

			</div>

			<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6"></div>

		</div>

	</div>

</div>
<script>

$(document).ready(function() {
	  $('#submail').click(function() {

		  var url='/carRental/';
		  
			window.location.href=url +'subscribe?mail='+$('#mail').val();

	  });
	});
</script>
