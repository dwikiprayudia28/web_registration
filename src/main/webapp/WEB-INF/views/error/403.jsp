<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%@
	taglib prefix="form" uri="http://www.springframework.org/tags/form" %><%@
	taglib prefix="spring" uri="http://www.springframework.org/tags"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta name="description" content="">
	    <meta name="author" content="">
	    
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		
	</head>
	
	<body id="body-class-custom" class="">
		<jsp:include page="../layout/cssLib.jsp" />
		<div id="wrapper">

	        <!-- Navigation -->
	        <jsp:include page="../layout/navigation.jsp" />
	
	        <div class="content-wrapper">

				<div class="row">
					<div class="col-lg-6 col-lg-offset-3">
						<h1 class="text-center" style="font-size: 150px; font-weight: 800; color:gray;">403</h1>
						<p class="text-center lead">You do not have permission to access this page.</p>
						<hr>
					</div>
				</div>
		
				<div class="row">
					<div class="col-lg-6 col-lg-offset-3 text-center ">
						<button type="submit" class="btn btn-default"><a href="/mywebapp/" class="menu-clickable">Home</a></button>
					</div>
				</div>
		
			</div>
	        <!-- /#page-wrapper -->
	
	    </div>
	    <!-- /#wrapper -->
	    
	    <jsp:include page="../layout/jsLib.jsp" />
	    
	</body>
</html>