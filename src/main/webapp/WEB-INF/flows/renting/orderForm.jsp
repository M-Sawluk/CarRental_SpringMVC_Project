<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<!-- This site was created in Webflow. http://www.webflow.com-->
<!-- Last Published: Thu Feb 09 2017 14:30:21 GMT+0000 (UTC) -->
<html>
<head>
<meta charset="utf-8">
<title>Fill the Order</title>
<meta content="width=device-width, initial-scale=1" name="viewport">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/orderForm.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/jquery.datetimepicker.css" />
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
<body class="bod" >
	<div class="con w-container" >
	<c:if test="${not empty order.car}" >
		<div>
		
			<div class="w-row">
				<div class="w-col w-col-6">
					<img class="im"
						src="<c:url value="/resource/cars/${order.car.carId}.png"></c:url>" alt="${order.car.carId}"
						width="368">
						
				</div>
				<div class="w-col w-col-6">
					<div class="rich w-richtext" align="left">		
						<h2>${order.car.name} ${order.car.manufacturer}</h2>
						<h4>${order.car.description }, ${order.car.type}</h4>
						<h2>Price</h2>
						<h4>${order.car.price}$</h4>
					</div>
				</div>
			</div>
		</div>
	</c:if>
		<div class="sec">
			<div class="w-form">
				<form:form class="fo" modelAttribute="order"  id="email-form" name="email-form" method="post">
				<form:errors path="*" cssClass="alert alert-danger" element="div" style="color: red; font-weight: bold; " align="center"/>
					<c:if test="${!not empty order.car}" >
					<h1 class="text1">Pick a Car</h1>
					<form:select class="w-select" id="field" name="field" path="selectedCar">
						<option value="">Select one...</option>
						<c:forEach items="${order.cars}" var="item">
							       		<option value="${item.carId}">${item.name} , ${item.manufacturer}, ${item.price}$</option>
						</c:forEach>
					</form:select>
					
					</c:if>
				
					<h1 class="text1">Select City</h1>
					<form:select class="w-select" id="field-2" name="field-2" path="selectedPlace">
						<option value="">Select one...</option>
						<c:forEach items="${order.places}" var="item">
							       		<option value="${item.id}">${item.city} , ${item.street}</option>
						</c:forEach>
					</form:select>
					
					<div>
						<h1 class="text1">Select Date</h1>
					</div>
					<div>
						<h4 class="rich w-richtext" align="center">Start</h4>
					  <form:input path="rentStart" class="w-input" id="datetimepicker" maxlength="256" name="field-3" placeholder="Rent Start" type="text" />
					
					</div>
					<div>
						<h4 class="rich w-richtext" align="center">End</h4>
						<form:input path="rentEnd" class="w-input" id="datetimepicker1" maxlength="256" name="field-3" placeholder="Rent End"  type="text"/>
						
					</div>
					<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}" />
							
						<div class="form-group" align="right">
							<div class="w-col w-col-10">
							<input type="submit" id="btnAdd" class="but1 w-button" value="Next" name="_eventId_orderDone" />
							</div>
							<div style="margin-right: 10px">
							<button id="btnCancel" class="but1 but2 w-button" name="_eventId_cancel">Cancel</button>
							</div>
						</div>
					
				</form:form>
			</div>
		</div>
	</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/resource/js/jquery.datetimepicker.full.js"></script>
	<script type="text/javascript"> 	
   		$("#datetimepicker").datetimepicker();
   	</script>
	<script type="text/javascript"> 	
   		$("#datetimepicker1").datetimepicker();
   	</script>
   	<script type="text/javascript">
   	$('#datetimepicker').datetimepicker({
   	 format:'d-m-Y H:i'
   	});
	$('#datetimepicker1').datetimepicker({
	   	 format:'d-m-Y H:i'
	   	});
   	</script>
</body>
</html>