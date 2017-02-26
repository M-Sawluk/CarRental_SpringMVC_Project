<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset="utf-8">
	<link rel="stylesheet"
		href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
		
		<title>Select City</title>
	</head>
		<body>
			<div align="center">
					<legend>
						<h2>Select City</h2>
					</legend>
			</div>
			
		 <section class="container" style="font-size: 250% ; padding-top: 100px;" >
			 <div align="center">
			 	<form:form modelAttribute="cities" class="formhorizontal">
				 	<form:errors path="*" cssClass="alert alert-danger" element="div"/>
					 	<form:select path="cityId">
									<form:option value="0" label="--- Select ---" />
									<c:forEach items="${cities.rentingCities}" var="item">
							       		<option value="${item.id}">${item.city} , ${item.street}</option>
							    	</c:forEach>
						</form:select>
						<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}" />
							
						<div class="form-group"  style="padding-top: 50px;">
							
							<input type="submit" id="btnAdd" class="btn btn-success btn-lg" value="Select" name="_eventId_citySelected" />
									
							<button id="btnCancel" class="btn btn-danger btn-lg" name="_eventId_cancel">Cancel</button>
							
						</div>
			 	</form:form>
			 </div>
		 </section>
		</body>
</html>
