<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Select Date</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/jquery.datetimepicker.css" />
    
   
   	
    
  </head>
  
  <body>
	
	<div align="center">
		<legend>
			<h2>Select Date</h2>
		</legend>
	</div>	

	<div class="container" >
		<form:form modelAttribute="order" class="form-horizontal">
		<form:errors path="*" cssClass="alert alert-danger" element="div"/>
		
		    <div class='col-md-6' >
		        <div class="form-group">
		            <div class='input-group' >
		            	<form:input id="datetimepicker" path="rentStart" type="text" placeholder="Start Date" class="form-control input-md"  />
		            	<form:errors path="rentStart" cssClass="text-danger"/>
		            
		                <span class="input-group-addon">
		                    <span class="glyphicon glyphicon-calendar"></span>
		                </span>
		            </div>
		        </div>
		    </div>
		    <div class='col-md-6'>
		        <div class="form-group">
		            <div class='input-group date' >
		                <form:input id="datetimepicker1" path="rentEnd" type="text" placeholder="End Date" class="form-control input-md"  />
		                <form:errors path="rentEnd" cssClass="text-danger"/>
		                
		                <span class="input-group-addon">
		                    <span class="glyphicon glyphicon-calendar"></span>
		                </span>
		            </div>
		        </div>
		    </div>
		   		 <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}" />
							
					<div class="form-group"  style="padding-top: 150px;" align="center">
						<input type="submit" id="btnAdd" class="btn btn-success btn-lg" value="Select" name="_eventId_dateSelected" />
						<button id="btnCancel" class="btn btn-danger btn-lg" name="_eventId_cancel">Cancel</button>
					</div>
														
						
							
	    </form:form>
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
  </body>
</html>
       
       
       
