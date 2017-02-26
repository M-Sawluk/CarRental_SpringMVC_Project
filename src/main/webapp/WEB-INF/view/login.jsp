<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Login</title>
</head>
<body>
	<div class="container" style="margin-top: 150px">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title"><spring:message code="login.title.label" /></h3>
					</div>
					<div class="panel-body">
						<div class="panel-body">
							<c:if test="${not empty error}">
								<div class="alert alert-danger">
									<spring:message
										code="AbstractUserDetailsAuthenticationProvider.badCredentials" />
									<br />
								</div>
							</c:if>	
							<form action="<c:url value="/j_spring_security_check"></c:url>"
								method="post">
								<fieldset>
									<div class="form-group">
										<input class="form-control" placeholder="Nazwa użytkownika" name='j_username' type="text">
									</div>
									<div class="form-group">
										<input class="form-control" placeholder="Hasło"
											name='j_password' type="password" value="">
									</div>
									<input class="btn btn-lg btn-success btn-block" type="submit"
										value="Zaloguj się">
									<a href="<spring:url value="/" />" class="btn btn-lg btn-danger btn-block"><spring:message code="success.back.label" /></a>
								</fieldset>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>