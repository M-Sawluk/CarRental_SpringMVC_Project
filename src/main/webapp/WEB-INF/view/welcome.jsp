<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>


<script src="<c:url value="/resource/js/scroll.js"/>"></script>

<link rel="stylesheet"
	href="<c:url value="/resource/css/welcome.css" />" />
<style>
#headerwrap {
	background: url("<c:url value="/ resource/ navigation/ welcome.png " />");
}
</style>


<div id="headerwrap">

	<div style="padding-top: 200px">
		<a class="bt w-button" href="<spring:url value="/renting?carId=" />"><spring:message
				code="welcome.start.label" /></a>
	</div>
	<div style="padding-top: 400px">
		<a href="#carouselrwrap" class="scroll"><img height="140"
			src="<c:url value="/resource/navigation/arrow2.png"></c:url>" /></a>
	</div>

</div>

<div id="carouselrwrap">
	<div align="center">
		<h1>
			<spring:message code="welcome.offers.label" />
		</h1>
	</div>

	<div class="container">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">



			<div class="carousel-inner">

				<div class="item active" align="left">
					<img
						src="<c:url value="/resource/cars/${list.get(0).carId}.png"></c:url>"
						alt="${list.get(0).carId}" />
					<div class="carousel-caption">
						<h1>${list.get(0).name}</h1>
						<h3>${list.get(0).manufacturer}</h3>
						<p>${list.get(0).price}zł/day</p>
						<p>${list.get(0).description}</p>
						<p>
							<a
								href=" <spring:url value="/renting?carId=${list.get(0).carId}" />"
								class="btn btn-primary"> <span
								class="glyphicon-info-sign glyphicon" /></span> <spring:message
									code="welcome.get.label" />
							</a>
						</p>
					</div>
				</div>

				<div class="item" align="left">
					<img
						src="<c:url value="/resource/cars/${list.get(1).carId}.png"></c:url>"
						alt="${list.get(0).carId}" />
					<div class="carousel-caption">
						<h1>${list.get(1).name}</h1>
						<h3>${list.get(1).manufacturer}</h3>
						<p>${list.get(1).price}zł/day</p>
						<p>${list.get(1).description}</p>
						<p>
							<a
								href=" <spring:url value="/renting?carId=${list.get(1).carId}" />"
								class="btn btn-primary"> <span
								class="glyphicon-info-sign glyphicon" /></span> <spring:message
									code="welcome.get.label" />
							</a>
						</p>
					</div>
				</div>

				<div class="item" align="left">
					<img
						src="<c:url value="/resource/cars/${list.get(2).carId}.png"></c:url>"
						alt="${list.get(0).carId}" />
					<div class="carousel-caption">
						<h1>${list.get(2).name}</h1>
						<h3>${list.get(2).manufacturer}</h3>
						<p>${list.get(2).price}zł/day</p>
						<p>${list.get(2).description}</p>
						<p>
							<a
								href=" <spring:url value="/renting?carId=${list.get(2).carId}" />"
								class="btn btn-primary"> <span
								class="glyphicon-info-sign glyphicon" /></span> <spring:message
									code="welcome.get.label" />
							</a>
						</p>
					</div>
				</div>

				<div class="item" align="left">
					<img
						src="<c:url value="/resource/cars/${list.get(3).carId}.png"></c:url>"
						alt="${list.get(0).carId}" />
					<div class="carousel-caption">
						<h1>${list.get(3).name}</h1>
						<h3>${list.get(3).manufacturer}</h3>
						<p>${list.get(3).price}zł/day</p>
						<p>${list.get(3).description}</p>
						<p>
							<a
								href=" <spring:url value="/renting?carId=${list.get(3).carId}" />"
								class="btn btn-primary"> <span
								class="glyphicon-info-sign glyphicon" /></span> <spring:message
									code="welcome.get.label" />
							</a>
						</p>
					</div>
				</div>


			</div>


			<ul class="nav nav-pills nav-justified">
				<li data-target="#myCarousel" data-slide-to="0"><a href="#">${list.get(0).name}</a></li>
				<li data-target="#myCarousel" data-slide-to="1"><a href="#">${list.get(1).name}</a></li>
				<li data-target="#myCarousel" data-slide-to="2"><a href="#">${list.get(2).name}</a></li>
				<li data-target="#myCarousel" data-slide-to="3"><a href="#">${list.get(3).name}</a></li>
			</ul>
		</div>

	</div>
</div>

































