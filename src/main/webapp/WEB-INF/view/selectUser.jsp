<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
  
<html>
  <head>
	<title>Selected User</title>
 	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" />
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="<c:url value="/resource/js/admin.js"/>" /></script>
  
  </head>
  <body>
  <div style="padding-top: 50px">
            <div class="container">
					<div class="row">
						<div align="center">
							<div class="container">
								<div class="row" align="center">
								  <div class="col-md-9"><input type="text" class="  search-query form-control" placeholder="UserName" id="search" /></div>
										<span class="input-group-btn">
								            <a class="btn btn-danger  btn-block " id="searchbutton"><span class=" glyphicon glyphicon-search"></span></a>
								      	</span>
								</div>	
							</div>
							
							<legend>
								<h1><spring:message code="admin.users.label" /></h1>
							</legend>
						</div>
						
				     <c:forEach items="${selectedUser}" var="users">   
				        <div class="table-responsive col-md-12">
				            <table class="table table-bordered table-hover">
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
				  		<a href="<spring:url value="/adminPage" />" class="btn btn-lg btn-danger"><spring:message code="success.back.label" /></a>
				  		
				  		</div>
					</div>
				</div>
        </div>

    </body>
</html>  




