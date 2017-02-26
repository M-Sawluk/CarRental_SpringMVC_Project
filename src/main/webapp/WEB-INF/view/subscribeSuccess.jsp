<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" />
<title>Success</title>

</head>
</body>
<div class="container">
	<div class="row text-center" style="padding-top: 80px">
        <div class="col-sm-6 col-sm-offset-3">
        <h2 style="color:#0fad00"><spring:message code="success.label" /></h2>
        <img src="http://osmhotels.com//assets/check-true.jpg">
        <h3>${name.firstName} ${name.lastName}</h3> <h3><spring:message code="subscribe.creation.label" /></h3>
        <p style="font-size:20px;color:#5C5C5C; padding-top: 80px"></p>
        <a href="<spring:url value="/" />" class="btn btn-danger"><spring:message code="subscribe.home.label" /></a>
   
        </div>
        
	</div>
</div>
</body>
</html>