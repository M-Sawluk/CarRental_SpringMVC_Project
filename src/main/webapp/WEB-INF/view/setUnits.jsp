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
		<div align="center">
			<legend>
				<h2>Dodaj egzemplarze ${car.name} ${car.manufacturer}</h2>
			</legend>
		</div>
	
	
		<section class="container">
			<form:form modelAttribute="CarStorageForm" class="form-horizontal">
				<fieldset>
					
			<c:forEach items="${CarStorageForm.storages}" var="storages" varStatus="status">
					<div class="form-group">
						<label class="col-md-4 control-label" for="placeName"><spring:message code="units.city.label" /></label>
						<div class="col-md-4">
							<form:input id="placeName" path="storages[${status.index}].placeName" type="text" placeholder="Miasto" class="form-control input-md" />	
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label" for="units"><spring:message code="units.add.label" /></label>
						<div class="col-md-4">
							<form:input id="units" path="storages[${status.index}].units" type="text" placeholder="Dodana ilosc" class="form-control input-md" />	
						</div>
					</div>
					
					
			</c:forEach>	
					<div class="form-group">
						<label class="col-md-4 control-label"></label>
						<div class="col-md-4">
							<input type="submit" id="btnAdd" class="btn btn-lg btn-success btn-block"
								value="<spring:message code="units.addcars.label" />" /> 
								<a href="<spring:url value="/carrent" />" class="btn btn-lg btn-danger btn-block"><spring:message code="success.back.label" /></a>
						</div>
					</div>
				</fieldset>
			</form:form>
		</section>
</body>
</html>