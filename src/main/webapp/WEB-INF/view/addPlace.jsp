<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>	
	<section class="container">
		<form:form modelAttribute="place" class="form-horizontal">
		<form:errors path="*" cssClass="alert alert-danger" element="div"/>
			<fieldset>
				<!-- Form Name -->
				<div align="center">
					<legend>
						<h2><spring:message code="addplace.shop.label" /></h2>
					</legend>
				</div>	
				<!-- Text input -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="city"><spring:message code="addplace.city.label" /></label>
					<div class="col-md-4">
						<form:input id="city" path="city" type="text" placeholder="Wprowadz Miasto" class="form-control input-md" />
						<form:errors path="city" cssClass="text-danger"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label" for="street"><spring:message code="addplace.street.label" /></label>
					<div class="col-md-4">
						<form:input id="street" path="street" type="text" placeholder="Wprowadz Ulice" class="form-control input-md" />
						<form:errors path="street" cssClass="text-danger"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label" for="placeNumber"><spring:message code="addplace.number.label" /></label>
					<div class="col-md-4">
						<form:input id="placeNumber" path="placeNumber" type="text" placeholder="Wprowadz Numer Budynku" class="form-control input-md" />
						<form:errors path="placeNumber" cssClass="text-danger"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label"></label>
					<div class="col-md-4">
						<input type="submit" id="btnAdd" class="btn btn-lg btn-success btn-block"
							value="<spring:message code="addplace.shop.label" />" /> 
							<a href="<spring:url value="/adminPage" />" class="btn btn-lg btn-danger btn-block"><spring:message code="success.back.label" /></a>
					</div>
				</div>
			</fieldset>
		</form:form>
	</section>
</body>
</html>