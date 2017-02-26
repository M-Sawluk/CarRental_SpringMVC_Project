<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<title>SignUp</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>
	<section class="container">
		<form:form modelAttribute="newUser" class="form-horizontal">
			<form:errors path="*" cssClass="alert alert-danger" element="div" />
			<fieldset>

				<!-- Form Name -->
				<div align="center">
					<legend>
						<h2>
							<spring:message code="registration.title.label" />
						</h2>
					</legend>
				</div>

				<!-- Text input -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="name"><spring:message
							code="registration.username.label" /></label>
					<div class="col-md-4">
						<form:input id="username" path="username" type="text"
							placeholder="Enter Your UserName" class="form-control input-md" />
						<form:errors path="username" cssClass="text-danger" />
					</div>
				</div>

				<!-- Text input -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="name"><spring:message
							code="registration.name.label" /></label>
					<div class="col-md-4">
						<form:input id="name" path="name" type="text"
							placeholder="Enter Your Name" class="form-control input-md" />
						<form:errors path="name" cssClass="text-danger" />
					</div>
				</div>

				<!-- Password input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="password"><spring:message
							code="registration.password.label" /></label>
					<div class="col-md-4">
						<form:input id="password" path="password" type="password"
							placeholder="Enter Yuor Password" class="form-control input-md"
							required="" />
						<form:errors path="password" cssClass="text-danger" />
					</div>
				</div>

				<!-- Password1 input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="password1"><spring:message
							code="registration.password1.label" /></label>
					<div class="col-md-4">
						<form:input id="password1" path="password1" type="password"
							placeholder="Repeat Your Password" class="form-control input-md"
							required="" />
						<form:errors path="password" cssClass="text-danger" />
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="telephone"><spring:message
							code="registration.telephone.label" /> </label>
					<div class="col-md-4">
						<form:input id="telephone" path="telephone" type="text"
							placeholder="Enter your Telephone Number"
							class="form-control input-md" value="" />
						<form:errors path="telephone" cssClass="text-danger" />
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="email"><spring:message
							code="registration.email.label" /></label>
					<div class="col-md-4">
						<form:input id="email" path="email" type="text"
							placeholder="E-Mail" class="form-control input-md" required="" />
						<form:errors path="email" cssClass="text-danger" />
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="birth"><spring:message
							code="registration.birth.label" /></label>
					<div class="col-md-4">
						<form:input id="birth" path="birth" type="Date"
							placeholder="Enter Your Birth Date" class="form-control input-md"
							required="" />
						<form:errors path="birth" cssClass="text-danger" />
					</div>
				</div>

				<!-- Textarea -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="address"><spring:message
							code="registration.address.label" /></label>
					<div class="col-md-4">
						<form:textarea class="form-control" id="address" path="address"
							placeholder="Address"></form:textarea>
						<form:errors path="address" cssClass="text-danger" />
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
												document.getElementById('recaptchaResponse').value = response;},
											'theme' : 'light'
										});
					}
				</script>

				<script
					src="https://www.google.com/recaptcha/api.js?onload=onloadCallback&render=explicit"
					async defer>
					
				</script>

				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label"></label>
					<div class="col-md-4">
						<input type="submit" id="btnAdd"
							class="btn btn-lg btn-success btn-block"
							value="<spring:message code="registration.register.label" />" />
						<a href="<spring:url value="/" />"
							class="btn btn-lg btn-danger btn-block"><spring:message
								code="success.back.label" /></a>
					</div>

				</div>
			</fieldset>
		</form:form>
	</section>
</body>
</html>