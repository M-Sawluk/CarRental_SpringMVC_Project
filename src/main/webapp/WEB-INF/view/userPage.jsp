<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<style>
#head {
	background: url("<c:url value="/resource/pictures/trip.jpg" />");
}
</style>
<link rel="stylesheet" href="<c:url value="/resource/css/userPage.css" />" />
<script src="<c:url value="/resource/js/userPage.js"/>"></script>
<div id="head">

		<div class="container">
			<div class="row" align="center">
				<div
					class="col-lg-5 col-md-12 col-sm-8 col-xs-9 bhoechie-tab-container">
					<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 bhoechie-tab-menu">
						<ul class="list-group">
							<a href="#" class="list-group-item active" > 
								<br />
								<br />
								<i class="glyphicon glyphicon-home" /></i>	<spring:message code="user.home.label" /> 
								<br />
								<br />
							</a>
							
							<a href="#" class="list-group-item " /> 
								<br />
								<br />
									<i class="glyphicon glyphicon-tasks"></i>	<spring:message code="user.active.label" />
								<br />
								<br />
							</a>
							
							<a href="#" class="list-group-item "> 
							<br />
							<br />
							<i class="glyphicon glyphicon-transfer"></i>	<spring:message code="user.history.label" />
							<br />
							<br />
							</a>
							
							<a href="#" class="list-group-item"> 
								<br />
								<br />
								<i class="glyphicon glyphicon-wrench"></i>	<spring:message code="user.reserve.label" />
								<br />
								<br />
							</a>
							<a href="#" class="list-group-item"> 
								<br />
								<br />
								<i class="glyphicon glyphicon-wrench"></i>	<spring:message code="user.edit.label" />
								<br />
								<br />
							</a>
							
						</ul>
					</div>
					<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9 bhoechie-tab">
						<!-- flight section -->
						<div class="bhoechie-tab-content active">
							<h1 class="glyphicon glyphicon-user"
								style="font-size: 14em; color: #00001a"></h1>


							<h2 style="margin-top: 0; color: #00001a">
								<spring:message code="user.welcome.label" />
							</h2>
							<h3 style="margin-top: 0; color: #00001a">
								<sec:authentication property="name" />
							</h3>
						</div>


						<div class="bhoechie-tab-content">
							<div class="table-responsive" style="max-height: 500px">
							<table class="table table-striped table-hover">
				                <thead>
				                    <tr>
				                        <th><spring:message code="user.start.label" /></th><th><spring:message code="user.end.label" /></th><th><spring:message code="user.name.label" /></th>
				                        <th><spring:message code="user.manufacturer.label" /></th><th><spring:message code="user.price.label" /></th><th><spring:message code="user.city.label" /></th>
				                    </tr>
				                </thead>
				              <c:forEach items="${presentOrders}" var="presentOrders">  
				                <tbody>
				                    <tr>
				                        <td class="col-md-1"><p>${presentOrders.rentStart}</p></td>
				                        <td class="col-md-1"><p>${presentOrders.rentEnd}<br/></td>
				                        <td class="col-md-1"><p>${presentOrders.car.name}</p></td>
				                        <td class="col-md-1"><p>${presentOrders.car.manufacturer}</p></td>
				                        <td class="col-md-1"><p>${presentOrders.price}</p></td>
				                        <td class="col-md-1"><p>${presentOrders.rentingPlace.city}</p></td>

				                    </tr>
				                    
				                    
				                </tbody>
				               </c:forEach>
				            </table>
				            </div>
						</div>

						<div class="bhoechie-tab-content">
						<div class="table-responsive" style="max-height: 500px">
							<table class="table table-striped table-hover">
				                <thead>
				                    <tr>
				                        <th><spring:message code="user.start.label" /></th><th><spring:message code="user.end.label" /></th><th><spring:message code="user.name.label" /></th>
				                        <th><spring:message code="user.manufacturer.label" /></th><th><spring:message code="user.price.label" /></th><th><spring:message code="user.city.label" /></th>
				                    </tr>
				                </thead>
				              <c:forEach items="${pastOrders}" var="presentOrders">  
				                <tbody>
				                    <tr>
				                        <td class="col-md-1"><p>${presentOrders.rentStart}</p></td>
				                        <td class="col-md-1"><p>${presentOrders.rentEnd}<br/></td>
				                        <td class="col-md-1"><p>${presentOrders.car.name}</p></td>
				                        <td class="col-md-1"><p>${presentOrders.car.manufacturer}</p></td>
				                        <td class="col-md-1"><p>${presentOrders.price}</p></td>
				                        <td class="col-md-1"><p>${presentOrders.rentingPlace.city}</p></td>

				                    </tr>
				                    
				                    
				                </tbody>
				               </c:forEach>
				            </table>
				            </div>
						</div>

						<div class="bhoechie-tab-content">
							 <div class="col-md-12 well">
					            	 <a class="btn btn-danger btn-lg btn-block" href="<spring:url value="/carrent" />"><spring:message code="user.rent.label" /></a>	
					        </div>
						
						</div>

						<!-- 					EDIT USER DATA 													-->


						<div class="bhoechie-tab-content">
							<form:form modelAttribute="newUserF" class="form-horizontal">

								<fieldset>

									<div align="center">
										<legend>
											<h5>
												<spring:message code="user.edit.label" />
											</h5>
										</legend>
									</div>

									<div class="form-group">
										<label class="col-md-4 control-label" for="name"><spring:message code="registration.username.label" /></label>
										<div class="col-md-4">
											<input type="text" readonly="readonly" class="form-control input-md" value="<sec:authentication property="name"/> " />

										</div>
									</div>

									<div class="form-group">
										<label class="col-md-4 control-label" for="name"><spring:message
												code="registration.name.label" /></label>
										<div class="col-md-4">
											<form:input id="name" path="name" type="text" placeholder="Enter Your Name" class="form-control input-md" />
										</div>
										<form:errors path="name" cssClass="text-danger" />
									</div>

									<!-- Password input-->
									<div class="form-group">
										<label class="col-md-4 control-label" for="password"><spring:message code="registration.password.label" /></label>
										<div class="col-md-4">
											<form:input id="password" path="password" type="password" placeholder="Enter Yuor Password" class="form-control input-md" required="" />
										</div>
										<form:errors path="password" cssClass="text-danger" />
									</div>

									<!-- Text input-->
									<div class="form-group">
										<label class="col-md-4 control-label" for="telephone"><spring:message code="registration.telephone.label" /> </label>
										<div class="col-md-4">
											<form:input id="telephone" path="telephone" type="text" placeholder="Enter your Telephone Number" class="form-control input-md" />
										</div>
										<form:errors path="telephone" cssClass="text-danger" />
									</div>

									<!-- Text input-->
									<div class="form-group">
										<label class="col-md-4 control-label" for="birth"><spring:message code="registration.birth.label" /></label>
										<div class="col-md-4">
											<form:input id="birth" path="birth" type="Date" placeholder="Enter Your Birth Date" class="form-control input-md" required="" />

										</div>
										<form:errors path="birth" cssClass="text-danger" />
									</div>

									<!-- Textarea -->
									<div class="form-group">
										<label class="col-md-4 control-label" for="address"><spring:message code="registration.address.label" /></label>
										<div class="col-md-4">
											<form:input class="form-control" id="address" path="address" placeholder="Address"></form:input>
										</div>
										<form:errors path="address" cssClass="text-danger" />
									</div>

									<!-- Button -->

									<div class="form-group">
										<label class="col-md-4 control-label"></label>
										<div class="col-md-4">
											<input type="submit" id="btnAdd"
												class="btn  btn-success btn-block"
												value="<spring:message code="user.update.label" />" />

										</div>

									</div>


								</fieldset>
							</form:form>
							<form:form modelAttribute="newEmail" class="form-horizontal">
								<fieldset>
									<div align="center">
										<legend>
											<h5><spring:message code="user.updateemail.label" /></h5>
										</legend>
									</div>

									<div class="form-group">
										<label class="col-md-4 control-label" for="email"><spring:message code="registration.email.label" /> </label>
										<div class="col-md-4">
											<form:input id="email" path="email" type="text" placeholder="Enter Email" class="form-control input-md" />
										</div>
										<form:errors path="email" cssClass="text-danger" />
									</div>

									<div class="form-group">
										<label class="col-md-4 control-label"></label>
										<div class="col-md-4">
											<input type="submit" id="btnAdd" class="btn  btn-success btn-block" value="<spring:message code="user.updateemail.label" />" />
										</div>

									</div>
								</fieldset>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	

</div>