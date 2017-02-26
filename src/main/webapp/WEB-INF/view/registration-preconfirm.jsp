<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<html>
	<head>
		<title>Confirm registration</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"/>
	</head>
	<body>
		<section >
			<div align="center">
				<legend>
					<h1><spring:message code="registration.confirm.label" /></h1>
				</legend>
			</div>
			<div align="center" style="padding-top: 70px">
				<h3><spring:message code="registration.confirmtext.label" /></h3>
			</div>
		</section>
	</body>
</html>
