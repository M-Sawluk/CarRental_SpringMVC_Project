<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>



<link rel="stylesheet" href="<c:url value="/resource/css/rent.css" />" />
<script src="<c:url value="/resource/js/rent.js"/>"></script>

<div class="container">
	<div class="row" align="center">
	  <div class="col-md-9"><input type="text" class="  search-query form-control" placeholder="Name or Manufacturer " id="search" /></div>
	  <div class="col-md-1"><input type="text" class="  search-query form-control" placeholder="Min Price " id="min" /></div>
	  <div class="col-md-1"><input type="text" class="  search-query form-control" placeholder="Max Price " id="max" /></div>
	       <span class="input-group-btn">
	            <a class="btn btn-danger  btn-block " id="searchbutton">
	                <span class=" glyphicon glyphicon-search"></span>
	            </a>
	      </span>
	</div>
</div>
<div class="container">
    <strong>View</strong> 
    <div class="btn-group"> 
  			<a href="#" id="list" class="btn btn-default btn-sm "><span class="glyphicon glyphicon-th-list"></span>List</a>
   			<a href="#" id="grid" class="btn btn-default btn-sm "><span class="glyphicon glyphicon-th"></span>Grid</a>
    </div>  
    
    <div id="products" class="row list-group">
	    <c:forEach items="${cars}" var="cars">
	        <div class="item  col-xs-4 col-lg-4">
	            <div class="thumbnail">
	                 <img src="<c:url value="/resource/cars/${cars.carId}.png"></c:url>" alt="${cars.carId}" />
	                <div class="caption">
	                    <h4 class="group inner list-group-item-heading">${cars.name}</h4>
	                    <h3>Producer: ${cars.manufacturer}</h3>
	          			<p>Price: ${cars.price}zł/day</p>
	            		<p>Description: ${cars.type} , ${cars.description} </p>
	                    <div class="row">
	                        <div class="col-xs-12 col-md-6">
	                            <sec:authorize access="hasRole('ROLE_ADMIN')">
	                            <a class="btn btn-danger" href="<spring:url value="/adminPage/carrent/delete?car=${cars.carId}" />"><spring:message code="rent.delete.label" /></a>
	                            <a class="btn btn-primary" href="<spring:url value="/adminPage/carrent/edit?car=${cars.carId}" />"><spring:message code="rent.edit.label" /></a>
	                            <a class="btn btn-warning" href="<spring:url value="/adminPage/carrent/setUnits?car=${cars.carId}" />"><spring:message code="rent.add.label" /></a>
	                            </sec:authorize>
	                            <a class="btn btn-success btn-right " href="<spring:url value="/renting?carId=${cars.carId}" />"><spring:message code="rent.rent.label" /></a>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </c:forEach>
    </div>
</div>





 





