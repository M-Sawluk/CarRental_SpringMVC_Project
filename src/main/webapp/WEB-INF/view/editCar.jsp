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
		<form:form modelAttribute="newCar" class="form-horizontal">
		<form:errors path="*" cssClass="alert alert-danger" element="div"/>
			<fieldset>

				<!-- Form Name -->
				<div align="center">
					<legend>
						<h2><spring:message code="editcar.edit.label" /></h2>
					</legend>
				</div>
		
				<!-- Text input -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="name"><spring:message code="editcar.name.label" /></label>
					<div class="col-md-4">
						<form:input id="name" path="name" type="text" placeholder="Nazwa" class="form-control input-md" />
						<form:errors path="name" cssClass="text-danger"/>
					</div>
				</div>

				<!-- Text input -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="manufacturer"><spring:message code="editcar.manufacturer.label" /></label>
					<div class="col-md-4">
						<form:input id="manufacturer" path="manufacturer" type="text" placeholder="Producent" class="form-control input-md" />
						<form:errors path="manufacturer" cssClass="text-danger"/>
					</div>
				</div>

				<!-- Password input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="price"><spring:message code="editcar.price.label" /></label>
					<div class="col-md-4">
						<form:input id="price" path="price" type="text" placeholder="Cena" class="form-control input-md" required="" />
						<form:errors path="price" cssClass="text-danger"/>
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="type"><spring:message code="editcar.type.label" /></label>
					<div class="col-md-4">
						<form:input id="type" path="type" type="text" placeholder="Typ" class="form-control input-md" value="" />
						<form:errors path="type" cssClass="text-danger"/>
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="description"><spring:message code="editcar.description.label" /></label>
					<div class="col-md-4">
						<form:input id="description" path="description" type="text" placeholder="Opis" class="form-control input-md" required="" />
						<form:errors path="description" cssClass="text-danger"/>
					</div>
				</div>

				<!-- Button -->

				<div class="form-group">
					<label class="col-md-4 control-label"></label>
					<div class="col-md-4">
						<input type="submit" id="btnAdd" class="btn btn-lg btn-success btn-block"
							value="<spring:message code="editcar.edit.label" />" /> 
							<a href="<spring:url value="/carrent" />" class="btn btn-lg btn-danger btn-block"><spring:message code="success.back.label" /></a>
					</div>
				</div>
			</fieldset>
		</form:form>
	</section>
</body>
</html>