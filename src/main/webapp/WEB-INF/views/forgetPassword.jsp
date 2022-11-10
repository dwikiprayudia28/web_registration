<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@
	taglib prefix="form" uri="http://www.springframework.org/tags/form" %><%@
	taglib prefix="spring" uri="http://www.springframework.org/tags"
%><!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Web</title>
		
		<%-- <link rel="icon" href="<c:url value='/images/favicon.ico'/>" type="image/ico"> --%>
		
		<link href="<c:url value='/styles/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet">
		<link href="<c:url value='/styles/login/css/signin.css'/>" rel="stylesheet">
		
		
		<script src="<c:url value='/scripts/config/sock.js'/>"></script>
		<script src="<c:url value='/scripts/config/stomp.min.js'/>"></script>
		
	</head>
	<body onload="disconnect()">
		<div class="container">
		    <div class="row">
		        <div class="col-sm-6 col-md-4 col-md-offset-4">
		            <h1 class="text-center login-title">Lupa Password</h1>
		            <div class="account-wall">
		            	
		                <form:form id="forgetPasswordForm" method="post" modelAttribute="user" >
		                	
	                        <label>Email:</label>
			                <form:input id ="email" path="email" maxlength="50" class="form-control" type="email" /> <br>
			                
			                <!-- <button class="btn btn-lg btn-primary btn-block" type="submit" value="Login"> Sign in</button> -->
			                <input type="submit" id="submitSave" name="submitSave" value="Save" class="btn btn-primary">
			                <input type="button" id="submitCancel" name="submitCancel" onclick="window.location.href='login'" value="Cancel" class="btn btn-default" formnovalidate>
		                </form:form>
		            </div>
		        </div>
		    </div>
		</div>
		
		
		
	</body>
</html>
