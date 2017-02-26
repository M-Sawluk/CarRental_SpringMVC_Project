<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="pl">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initialscale=1.0">
<title><tiles:insertAttribute name="title" /></title>
</head>
<body>
	<div class="container">
		<div class="header">
			<tiles:insertAttribute name="navigation" />
		</div>
		
		<div class="row">
			<tiles:insertAttribute name="content" />
		</div>
		<div class="footer" >
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</body>
</html>