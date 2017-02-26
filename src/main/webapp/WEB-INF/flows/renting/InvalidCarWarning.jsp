<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Order Confirmation</title>
		<meta content="width=device-width, initial-scale=1" name="viewport">
		<link rel="stylesheet"
			href="<%=request.getContextPath()%>/resource/css/orderForm.css" />
		<link rel="stylesheet"
			href="<%=request.getContextPath()%>/resource/css/jquery.datetimepicker.css" />
		<script
			src="https://ajax.googleapis.com/ajax/libs/webfont/1.4.7/webfont.js"></script>
		<script type="text/javascript">
			WebFont.load({google : {families : [ "Droid Sans:400,700" ]}});
		</script>
		<style>
		.bod
		{background: url("<%=request.getContextPath()%>/resource/pictures/orderConfirm.png");}
		</style>
	</head>
	

<body class="bod">
  <div class="con w-container " align="center" style="padding-top:0px;padding-bottom: 30px;">
    <div class="sec">
      <h2>We are sorry this but car is not available in selected period!!</h2>
      	<div class="form-group" align="center">
							<div class="w-col w-col-6">
								<a href="<spring:url value="/renting?carId=" />" class="but1 w-button">Start again</a>
							</div>
							<div class="w-col w-col-6">
								<a href="<spring:url value="/" />" class="but1 but2 w-button">Cancel</a>
							</div>
		</div>
		<div></div>
    </div>
  </div>
</body>
</html>