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
			href="<%=request.getContextPath()%>/resource/css/orderConfirmation.css" />
		
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
		<div  class="columns w-row " style ="min-width: 97.5%; align-items: center;">
			<div class="w-col w-col-1"></div>
			<div class="w-col w-col-5">
				<img class="pic w-preserve-3d" src="<c:url value="/resource/cars/${order.car.carId}.png"></c:url>" alt="${order.car.carId}"  />
			</div>
			<div class="w-col w-col-6">
			<form:form modelAttribute="order">
				<div class="w-richtext">
					
					<h2>${order.car.name} ${order.car.manufacturer}</h2>
					<p>${order.car.description }, ${order.car.type}</p>
					<h2>City</h2>
					<p>${order.rentingPlace.city }, ${order.rentingPlace.street } ${order.rentingPlace.placeNumber}</p>
					<h2>Renting Period</h2>
					<p>Start: ${order.rentStart }</p>
					<p>End: ${order.rentEnd}</p>
					<h2>Price</h2>
					<p>${order.price}$</p>
				</div>
			
				<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}" />
									
				<div class="w-row" >
					<div class="w-col w-col-5">
						<input type="submit" id="btnAdd" class="but1 w-button" value="Confirm" name="_eventId_accepted" />
					</div>
					
					<div class="w-col w-col-7">
						<button id="btnCancel" class="but1 but2 w-button" name="_eventId_cancel">Cancel</button>
					</div>			
				</div>
			</form:form>
			</div>
		</div>
	</body>
</html>