<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<style>

#wrap
{
	background : url('<c:url value="/resource/pictures/admin.png"/>') ;
	margin-top: -20px;
	min-height: 920px;
}

</style>
<script src="<c:url value="/resource/js/admin.js"/>"></script>

<div id="wrap">
<div class="container">
    <div class="row">
        <div class="col-md-3">
            <ul class="nav nav-pills nav-stacked admin-menu">
                <li class="active"><a href="#" data-target-id="home"><i class="fa fa-home fa-fw"></i><spring:message code="admin.home.label" /></a></li>
                <li><a data-target-id="dodajauta"><i class="fa fa-list-alt fa-fw"></i><spring:message code="admin.addcar.label" /></a></li>
                <li><a data-target-id="dodajprodukt"><i class="fa fa-file-o fa-fw"></i><spring:message code="admin.addproduct.label" /></a></li>
                <li><a data-target-id="zarzadzajuz"><i class="fa fa-bar-chart-o fa-fw"></i><spring:message code="admin.users.label" /></a></li>
                <li><a data-target-id="zardzord"><i class="fa fa-table fa-fw"></i><spring:message code="admin.orders.label" /></a></li>
                <li><a data-target-id="zarzadzajau"><i class="fa fa-table fa-fw"></i><spring:message code="admin.cars.label" /></a></li>
                <li><a data-target-id="dodjsskelp"><i class="fa fa-table fa-fw"></i><spring:message code="admin.addshop.label" /></a></li>
                
            </ul>
        </div>
        <div class="col-md-9 well admin-content" id="home" >
 			 <p> <spring:message code="admin.welcome.label" /> </p>
        </div>
        <div class="col-md-9 well admin-content" id="dodajauta" >
           
           <form:form modelAttribute="newCar" class="form-horizontal" enctype="multipart/form-data"> 
			
			<fieldset>

				<div align="center">
					<legend>
						<h5><spring:message code="admin.addcar.label" /></h5>
					</legend>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label" for="carId"><spring:message code="admin.carid.label" /></label>
					<div class="col-md-4">
						<form:input id="carId" path="carId" type="text" placeholder="Id Samochodu" class="form-control input-md" />
						
					</div>
					<form:errors path="carId" cssClass="text-danger"/>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label" for="name"><spring:message code="admin.name.label" /></label>
					<div class="col-md-4">
						<form:input id="name" path="name" type="text" placeholder="Nazwa Samochodu" class="form-control input-md" />
						
					</div>
					<form:errors path="name" cssClass="text-danger"/>
				</div>
					<div class="form-group">
					<label class="col-md-4 control-label" for="manufacturer"><spring:message code="admin.manufacturer.label" /></label>
					<div class="col-md-4">
						<form:input id="manufacturer" path="manufacturer" type="text" placeholder="Marka Samochodu" class="form-control input-md" />
						
					</div>
					<form:errors path="manufacturer" cssClass="text-danger"/>
				</div>
				
				<div class="form-group">
					<label class="col-md-4 control-label" for="price"><spring:message code="admin.price.label" /></label>
					<div class="col-md-4">
						<form:input id="price" path="price" type="text" placeholder="Cena Samochodu" class="form-control input-md" />
						
					</div>
					<form:errors path="price" cssClass="text-danger"/>
				</div>
				
				<div class="form-group">
					<label class="col-md-4 control-label" for="type"><spring:message code="admin.type.label" /></label>
					<div class="col-md-4">
						<form:input id="type" path="type" type="text" placeholder="Rodzaj Samochodu" class="form-control input-md" />
						
					</div>
					<form:errors path="type" cssClass="text-danger"/>
				</div>
				
				<div class="form-group">
					<label class="col-md-4 control-label" for="description"><spring:message code="admin.description.label" /></label>
					<div class="col-md-4">
						<form:input id="description" path="description" type="text" placeholder="Opis Samochodu" class="form-control input-md" />
						
					</div>
					<form:errors path="description" cssClass="text-danger"/>
				</div>
				
				
				<div class="form-group">
					<label class="col-md-4 control-label" for="productImage"><spring:message code="admin.picture.label" /></label>
						<div class="col-md-4">
						<form:input id="productImage" path="productImage" type="file" class="form:input-large" />
					</div>
				</div>
				
				<!-- Button -->

				<div class="form-group">
					<label class="col-md-4 control-label"></label>
					<div class="col-md-4">
						<input type="submit" id="btnAdd" class="btn  btn-success btn-block"
							value="<spring:message code="admin.addcar.label" />" /> 					
					</div>
				</div>
			</fieldset>
		</form:form>
        </div>
        <div class="col-md-9 well admin-content" id="dodajprodukt" >
            Pages
        </div>
        <div class="col-md-9 well admin-content" id="zarzadzajuz" >
            <div class="container">
					<div class="row">
						<div align="center">
						<div class="container">
							<div class="row" align="center">
							  <div class="col-md-9"><input type="text" class="  search-query form-control" placeholder="UserName" id="search" /></div>
							
							       <span class="input-group-btn">
							            <a class="btn btn-danger  btn-block " id="searchbutton">
							                <span class=" glyphicon glyphicon-search"></span>
							            </a>
							      </span>
							</div>	
							</div>
							<legend>
								<h1><spring:message code="admin.users.label" /></h1>
							</legend>
						</div>			
				     <c:forEach items="${users}" var="users">   
				        <div class="table-responsive col-md-12">
				            <table class="table table-striped table-hover">
				                <thead>
				                    <tr>
				                        <th><spring:message code="admin.firstname.label" /></th><th><spring:message code="admin.username.label" /></th><th><spring:message code="admin.telephone.label" /></th>
				                        <th><spring:message code="admin.role.label" /></th><th><spring:message code="admin.email.label" /></th><th><spring:message code="admin.address.label" /></th><th><spring:message code="admin.status.label" /></th>
				                    </tr>
				                </thead>
				                <tbody>
				                    <tr>
				                        <td class="col-md-1"><p>${users.name}</p></td>
				                        <td class="col-md-1"><p>${users.username}<br/></td>
				                        <td class="col-md-1"><p>${users.telephone}</p></td>
				                        <td class="col-md-1"><p>${users.roles.get(0).roleName}</p></td>
				                        <td class="col-md-1"><p>${users.email}</p></td>
				                        <td class="col-md-1"><p>${users.address}</p></td>
				                        <td class="col-md-1"><p>${users.status}</p></td>
				                        <td class="col-md-3"><p>
				                            <a class="btn btn-danger" href="<spring:url value="/adminPage/delete?name=${users.username}" />"><spring:message code="admin.delete.label" /></a>
				                            <a class="btn btn-danger" href="<spring:url value="/adminPage/change?name=${users.username}" />"><spring:message code="admin.changerole.label" /></a>
				                            <a class="btn btn-danger" href="<spring:url value="/adminPage/block?name=${users.username}" />"><spring:message code="admin.block.label" /></a>
				                        </p></td>
				                    </tr>				                 	                    
				                </tbody>
				            </table>
				        </div>
				        </c:forEach>
				        <div align="center">
				            <ul class="pagination">
				                <li><a href="#">«</a></li>
				                <li><a href="#">1</a></li>
								<li><a href="#">»</a></li>
				            </ul>
				        </div>
					</div>
				</div>
        </div>        
        <div class="col-md-9 well admin-content" id="zardzord" >
           		<div class="container">
					<div class="row">
						<div align="center">
						<div class="container">
							<div class="row" align="center">
							  <div class="col-md-9"><input type="text" class="  search-query form-control" placeholder="UserName" id="search" /></div>
							
							       <span class="input-group-btn">
							            <a class="btn btn-danger  btn-block " id="searchbutton">
							                <span class=" glyphicon glyphicon-search"></span>
							            </a>
							      </span>
							</div>	
							</div>
							<legend>
								<h1><spring:message code="admin.orders.label" /></h1>
							</legend>
						</div>				
				     <c:forEach items="${orders}" var="orders">   
				        <div class="table-responsive col-md-12">
				            <table class="table table-striped table-hover">
				                <thead>
				                    <tr>
				                        <th><spring:message code="admin.rentStart.label" /></th><th><spring:message code="admin.rentEnd.label" /></th><th><spring:message code="admin.city.label" /></th>
				                        <th><spring:message code="admin.username.label" /></th><th><spring:message code="admin.price.label" /></th><th><spring:message code="admin.carname.label" /></th><th><spring:message code="admin.status.label" /></th>
				                    </tr>
				                </thead>
				                <tbody>
				                    <tr>
				                        <td class="col-md-1"><p>${orders.rentStart}</p></td>
				                        <td class="col-md-1"><p>${orders.rentEnd}<br/></td>
				                        <td class="col-md-1"><p>${orders.rentingPlace.city}</p></td>
				                        <td class="col-md-1"><p>${orders.user.username}</p></td>
				                        <td class="col-md-1"><p>${orders.price}</p></td>
				                        <td class="col-md-1"><p>${orders.car.name}</p></td>
				                        <td class="col-md-1"><p>${orders.status}</p></td>
					                    <td class="col-md-3"><p>
					                            <a class="btn btn-danger" href="<spring:url value="/adminPage/deleteOrder?order=${orders.id}" />"><spring:message code="admin.delete.label" /></a>
					                            <a class="btn btn-danger" href="<spring:url value="/adminPage/changeOrder?order=${orders.id}" />"><spring:message code="admin.changestatus.label" /></a>					                            
					                     </p></td>
				                    </tr>

				                </tbody>
				            </table>
				        </div>
				        </c:forEach>
				        <div align="center">
				            <ul class="pagination">
				                <li><a href="#">«</a></li>
				                <li><a href="#">1</a></li>
								<li><a href="#">»</a></li>
				            </ul>
				        </div>
					</div>
				</div>
        </div>
        
         <div class="col-md-9 well admin-content" id="zarzadzajau" >
            	 <a class="btn btn-danger btn-lg btn-block" href="<spring:url value="/carrent" />"><spring:message code="admin.cars.label" /></a>	
        </div>
        
         <div class="col-md-9 well admin-content" id="dodjsskelp" >
            	<a class="btn btn-danger btn-lg btn-block" href="<spring:url value="/adminPage/addPlace" />"><spring:message code="admin.addshop.label" /></a>
        </div>
         
    </div>
</div>
</div>

