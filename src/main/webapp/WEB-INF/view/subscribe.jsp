<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"/>
<title>Subscribe</title>
</head>
<body>
	
	<section class="container" >
		<form:form modelAttribute="subscriber" class="form-horizontal" action="/carRental/subscribe">
		<form:errors path="*" cssClass="alert alert-danger" element="div"/>
			<fieldset>

				<!-- Form Name -->
				<div align="center">
					<legend>
						<h2><spring:message code="subscribe.subs.label" /></h2>
					</legend>
				</div>
	
				<c:if test="${not empty expired}">
					<div class="warning alert" style="background-color: #ffb3b3">
						<spring:message code="subscribe.expired.label" />
					</div>
				</c:if>
				<c:if test="${not empty failed}">
					<div class="warning alert" style="background-color: #ffb3b3">
						<spring:message code="subscribe.failed.label" />
					</div>
				</c:if>

				<!-- Text input -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="firstName"><spring:message code="subscribe.name.label" /></label>
					<div class="col-md-4">
						<form:input id="firstName" path="firstName" type="text" placeholder="Enter Name" class="form-control input-md" />
						<form:errors path="firstName" cssClass="text-danger"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label" for="lastName"><spring:message code="subscribe.lastname.label" /></label>
					<div class="col-md-4">
						<form:input id="lastName" path="lastName" type="text" placeholder="Enter LastName" class="form-control input-md" />
						<form:errors path="lastName" cssClass="text-danger"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label" for="email"><spring:message code="registration.email.label" /></label>
					<div class="col-md-4">
						<form:input id="email" path="email" type="text" placeholder="Enter Email" class="form-control input-md" />
						<form:errors path="email" cssClass="text-danger"/>
					</div>
				</div>
				
				<div id="g-recaptcha" align="center"></div>
				<form:hidden path="recaptchaResponse" />
				<script type="text/javascript">
					var onloadCallback = function() {
						grecaptcha
								.render(
										'g-recaptcha',
										{
											'sitekey' : '<c:out value="${recaptchaSiteKey}" />',
											'callback' : function(response) {
												document.getElementById('recaptchaResponse').value = response;
											},
											'theme' : 'light'
										});
					}
				</script>
				<script
					src="https://www.google.com/recaptcha/api.js?onload=onloadCallback&render=explicit"
					async defer></script>
				
				

				<div class="form-group">
					<label class="col-md-4 control-label"></label>
					<div class="col-md-4">
						<input type="submit" id="btnAdd" class="btn btn-lg btn-success btn-block" value="<spring:message code="footer.subscribe.label" />" /> 
						<a href="<spring:url value="/" />" class="btn btn-lg btn-danger btn-block"><spring:message code="success.back.label" /></a>
					</div>

				</div>

			</fieldset>
		</form:form>
	</section>
</body>
</html>