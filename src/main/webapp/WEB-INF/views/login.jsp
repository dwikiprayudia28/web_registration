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
		            <h1 class="text-center login-title">Log In</h1>
		            <div class="account-wall">
		            	
		                <form action="<c:url value='j_spring_security_check' />" method="POST" class="form-signin">
		                	<div class="alert alert-danger alert-dismissable" id="alert" >
	                            <i class="fa fa-info-circle"></i><strong>${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}!</strong> Please try again.
	                        </div>
	                        <label>User Name:</label>
			                <input type="txt" name="j_username" class="form-control" placeholder="User Name" required autofocus> <br>
			                <label>Password:</label>
			                <input type="password" name="j_password" class="form-control" placeholder="Password" required>
			                
			                <!-- <button class="btn btn-lg btn-primary btn-block" type="submit" value="Login"> Sign in</button> -->
			                <button class="btn btn-lg btn-primary btn-block" type="submit" value="Login" > Log in</button>
			                
		                </form>
		            </div>
		            <a href="registrasi" class="text-center new-account"><b>Registrasi</b> </a>
		            <a href="forget" class="text-center new-account"><b>Lupa Password</b> </a>
		        </div>
		    </div>
		</div>
		
		<script type="text/javascript">
			var error = "${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}";
			if(error==null || error==''){
				document.getElementById("alert").hidden = true;
			}
			
			
		</script>
		
	</body>
</html>
