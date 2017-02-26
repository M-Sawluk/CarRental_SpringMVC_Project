<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/navigation.css" />


<tilesx:useAttribute name="current"/>


<div class="navbar navbar-inverse navbar-fixed-top">
	<div id="topnavbar">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<spring:url value="/" />"><img height="45" src="<c:url value="/resource/navigation/car-logo.png"></c:url>" style="margin-top: -10px ;margin-left: -33px" /></a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="${current== 'home' ? 'active' : '' }"><a href="<spring:url value="/" />"><spring:message
								code="navigation.home.label" /></a></li>
					<!--  			
					<li  class="${current== 'products' ? 'active' : '' }" class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"><spring:message
								code="navigation.products.label" /><span class="caret"></span></a>
						<ul class="dropdown-menu">

							<li><a href="#">Page 1-1</a></li>
							<li><a href="#">Page 1-2</a></li>
							<li><a href="#">Page 1-3</a></li>
						</ul></li>
					-->
					<li class="${current=='contacts' ? 'active' : '' }"><a href="<spring:url value="/contacts" />"><spring:message
								code="navigation.contact.label" /></a></li>
					<!--  
					<li class="${current== 'cart' ? 'active' : '' }"><a href="#"><spring:message
								code="navigation.cart.label" /></a></li>
					-->
					<li class="${current=='rent' ? 'active' : '' }"><a href="<spring:url value="/carrent" />"><spring:message
								code="navigation.carRental.label" /></a></li>
				</ul>
				
				
				<ul class="nav navbar-nav navbar-right">
					
					<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">
					<spring:message code="language.label" /> 
					<c:if test="${pageContext.response.locale=='eng' }">
					<img src="<c:url value="/resource/navigation/british.jpg"></c:url>"  />
					</c:if>
					<c:if test="${pageContext.response.locale=='pl' }">
					<img src="<c:url value="/resource/navigation/poland.jpg"></c:url>"/>
					</c:if>
					<span class="caret"></span></a>
					
					<ul class="dropdown-menu">

						<li><a href="?language=pl"><spring:message code="language.polish.label" /></a> </li>
						<li><a href="?language=eng"><spring:message code="language.english.label" /></a> </li>
					
						</ul>
						
					</li>
					
				
					<li>
					<sec:authorize  access="isAnonymous()">
				 	 	<a href="<spring:url value="/signup" /> "><span class="glyphicon glyphicon-user"></span>
						  	<spring:message code="navigation.signup.label" /></a>
					</sec:authorize>
					<sec:authorize  access="hasRole('ROLE_USER')">
						<a href="<spring:url value="/userPage" /> "><sec:authentication property="name"  /></a>
					</sec:authorize>
					<sec:authorize  access="hasRole('ROLE_ADMIN')">
						<a href="<spring:url value="/adminPage" /> "><sec:authentication property="name"  /></a>
					</sec:authorize>
					</li>
				
					<li>
						<sec:authorize  access="isAnonymous()">
								<a href="<spring:url value="/login" /> "><span class="glyphicon glyphicon-log-in"></span>
									<spring:message code="navigation.login.label" />
								</a>
						</sec:authorize>
						
						<sec:authorize  access="isAuthenticated()">
							<a href="<spring:url value="/j_spring_security_logout" /> "><spring:message code="form.logout.label" /></a>
						</sec:authorize>
					
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>
