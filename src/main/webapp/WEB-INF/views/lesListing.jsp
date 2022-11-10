<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@
	taglib
	prefix="form" uri="http://www.springframework.org/tags/form"%><%@
	taglib
	prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<jsp:include page="layout/cssLib.jsp" />
<script type="text/javascript">
	var frameRes = null;
	var resSendNotif = "${sendNotif}";
</script>

</head>
<body id="body-class-custom" class="">
	<div class="wrapper">

		<!-- Navigation -->
		<jsp:include page="layout/navigation.jsp" />

		<div id="page-wrapper">

			<div class="content-wrapper">

				<section class="content-header">
					<h1>
						Les<small></small>
					</h1>
					<ol class="breadcrumb">
						<li><a href="/mywebapp"><i class="fa fa-home"></i> Home</a></li>
						<li class="active">Les</li>
					</ol>
				</section>

				<section class="content">
					<div class="row">
						<div class="col-xs-12">
							<c:url var="formListingAttn" value="/les/list" />
							<form:form action="${formListingAttn}" method="get" modelAttribute="attendance">
								<div class="box">
									<div class="box-header">
										<div class="row">
											<div class='form-group col-md-12'>
												<button type="button" id="createLes" name="createLes" onclick="location.href='/mywebapp/les/create';" class="btn btn-sm btn-primary"> <i class="fa fa-plus"></i> Daftar Baru </button>
											</div>
										</div>
									</div>
									<div class="box-body">
										<c:url var="formListingAttn" value="/attendance/list" />
										<form:form action="${formListingAttn}" method="get" modelAttribute="user">
											<div class="table-responsive">
												<table class="table table-bordered table-hover table-striped">
													<thead>
														<tr>
															<th style="text-align: left; vertical-align: middle" ></th>
															<th style="text-align: left; vertical-align: middle" >Nama</th>
															<th style="text-align: left; vertical-align: middle" >Alamat</th>
															<th style="text-align: left; vertical-align: middle" >Tanggal Lahir</th>
															<th style="text-align: left; vertical-align: middle" >Kelas</th>
															<th style="text-align: left; vertical-align: middle" >Jurusan</th>
															<th style="text-align: left; vertical-align: middle" >Online/Offline</th>
															<th style="text-align: left; vertical-align: middle" >Jadwal</th>
															<th style="text-align: left; vertical-align: middle" >Status</th>
														</tr>
													</thead>
													<tbody>
														<c:if test="${!empty listDataLes}">
															<c:set var="count" value="${fn:length(listDataLes)}" scope="page" />
															<c:forEach items="${listDataLes}" var="data" varStatus="status">
																<tr>
																	<td align="left" >
																		<button type="button" id="edit" name="edit" onclick="location.href='/mywebapp/les/edit?id=${data.id}';" class="btn btn-sm btn-info"> Edit </button>
																		<button type="button" id="paid" name="paid" onclick="location.href='/mywebapp/les/paid?id=${data.id}';" class="btn btn-sm btn-success"> Bayar </button>
																	</td>
																	<td align="left">${data.name}</td>
																	<td align="left">${data.address}</td>
																	<td align="left"><fmt:formatDate pattern='dd-MMM-yyyy' value="${data.bornDate}" /></td>
																	<td align="left">${data.kelas}</td>
																	<td align="left">${data.jurusan}</td>
																	<td align="left">${data.jenisPertemuan}</td>
																	<td align="left">${data.jadwal}</td>
																	<td align="center">${data.status}</td>
																</tr>
																<c:set var="count" value="${count - 1}" scope="page" />
															</c:forEach>
														</c:if>
														<c:if test="${empty listDataLes}">
															<tr><td colspan="17" align="center">No Data</td></tr>
														</c:if>
													</tbody>
												</table>
											</div>
										</form:form>
									</div>
									<div class="box-footer">
										<div class="row">
											<div class="form-group col-md-11 pagination-centered">
												<input id="pageSize" name="pageSize" value="${selectedPageSize}" hidden="true" />
												<c:if test="${totalPage > 0}">
														Showing ${showingDataFrom} to ${showingDataTo} of ${totalData} entries
														<ul class="pagination  pull-right">
														<li><button value="1" class="btn btn-default someclass" id="firstPage" name="submitSearch" type="submit" formnovalidate>&laquo;</button></li>
														<li><button value="${page-1}" class="btn btn-default someclass" id="previousPage" name="submitSearch" type="submit" formnovalidate>&larr;</button></li>
														<c:forEach var="pageIndex" items="${pageArray}">
															<li><button value="${pageIndex}" class="btn btn-default someclass" id="indexPage" name="submitSearch" type="submit" formnovalidate>${pageIndex}</button></li>
														</c:forEach>
														<li><button value="${page+1}" class="btn btn-default someclass" id="nextPage" name="submitSearch" type="submit" formnovalidate>&rarr;</button></li>
														<li><button value="${totalPage}" class="btn btn-default someclass" id="lastPage" name="submitSearch" type="submit" formnovalidate>&raquo;</button></li>
													</ul>
												</c:if>
											</div>
										</div>
									</div>
								</div>
							</form:form>
						</div>
					</div>
				</section>
			</div>
		</div>
	</div>
	<jsp:include page="layout/jsLib.jsp" />

	<script type="text/javascript">
		var msg = "${msg}";
		if (msg != '') {
			showFilter()
			$.alert({
				title : 'Alert',
				content : msg,
			});
		}
		
		var srcAttnId = document.getElementById('attnId');
		srcAttnId.addEventListener('keypress', function(event) {
			if (event.keyCode == 13) {
				event.preventDefault();
				document.getElementById('submitSearch').click();
			}
		});

		var srcUserNik = document.getElementById('userNik');
		srcUserNik.addEventListener('keypress', function(event) {
			if (event.keyCode == 13) {
				event.preventDefault();
				document.getElementById('submitSearch').click();
			}
		});
		
		var srcUserNikExt = document.getElementById('userNikExt');
		srcUserNikExt.addEventListener('keypress', function(event) {
			if (event.keyCode == 13) {
				event.preventDefault();
				document.getElementById('submitSearch').click();
			}
		});
		
		var srcUserOfficeName = document.getElementById('userOfficeName');
		srcUserOfficeName.addEventListener('keypress', function(event) {
			if (event.keyCode == 13) {
				event.preventDefault();
				document.getElementById('submitSearch').click();
			}
		});
		
		var srcUserCompanyId = document.getElementById('userCompanyId');
		srcUserCompanyId.addEventListener('keypress', function(event) {
			if (event.keyCode == 13) {
				event.preventDefault();
				document.getElementById('submitSearch').click();
			}
		});
		
		var srcUserJobPositionId = document.getElementById('userJobPositionId');
		srcUserJobPositionId.addEventListener('keypress', function(event) {
			if (event.keyCode == 13) {
				event.preventDefault();
				document.getElementById('submitSearch').click();
			}
		});

		var srcUserDepartmentName = document.getElementById('userDepartmentName');
		srcUserDepartmentName.addEventListener('keypress', function(event) {
			if (event.keyCode == 13) {
				event.preventDefault();
				document.getElementById('submitSearch').click();
			}
		});
		
		var srcUserName = document.getElementById('userName');
		srcUserName.addEventListener('keypress', function(event) {
			if (event.keyCode == 13) {
				event.preventDefault();
				document.getElementById('submitSearch').click();
			}
		});

		var srcStartArriveTimeStr = document.getElementById('startArriveTimeStr');
		srcStartArriveTimeStr.addEventListener('keypress', function(event) {
			if (event.keyCode == 13) {
				event.preventDefault();
				document.getElementById('submitSearch').click();
			}
		});

		var srcEndArriveTimeStr = document.getElementById('endArriveTimeStr');
		srcEndArriveTimeStr.addEventListener('keypress', function(event) {
			if (event.keyCode == 13) {
				event.preventDefault();
				document.getElementById('submitSearch').click();
			}
		});

		var srcArriveOfficeName = document.getElementById('arriveOfficeName');
		srcArriveOfficeName.addEventListener('keypress', function(event) {
			if (event.keyCode == 13) {
				event.preventDefault();
				document.getElementById('submitSearch').click();
			}
		});

		var srcArriveApproval = document.getElementById('arriveApproval');
		srcArriveApproval.addEventListener('keypress', function(event) {
			if (event.keyCode == 13) {
				event.preventDefault();
				document.getElementById('submitSearch').click();
			}
		});
		
		var srcArriveApprovedBy = document.getElementById('arriveApprovedBy');
		srcArriveApprovedBy.addEventListener('keypress', function(event) {
			if (event.keyCode == 13) {
				event.preventDefault();
				document.getElementById('submitSearch').click();
			}
		});

		var srcStartDepartTimeStr = document.getElementById('startDepartTimeStr');
		srcStartDepartTimeStr.addEventListener('keypress', function(event) {
			if (event.keyCode == 13) {
				event.preventDefault();
				document.getElementById('submitSearch').click();
			}
		});

		var srcEndDepartTimeStr = document.getElementById('endDepartTimeStr');
		srcEndDepartTimeStr.addEventListener('keypress', function(event) {
			if (event.keyCode == 13) {
				event.preventDefault();
				document.getElementById('submitSearch').click();
			}
		});

		var srcDepartOfficeName = document.getElementById('departOfficeName');
		srcDepartOfficeName.addEventListener('keypress', function(event) {
			if (event.keyCode == 13) {
				event.preventDefault();
				document.getElementById('submitSearch').click();
			}
		});

		var srcDepartApproval = document.getElementById('departApproval');
		srcDepartApproval.addEventListener('keypress', function(event) {
			if (event.keyCode == 13) {
				event.preventDefault();
				document.getElementById('submitSearch').click();
			}
		});
		
		var srcDepartApprovedBy = document.getElementById('departApprovedBy');
		srcDepartApprovedBy.addEventListener('keypress', function(event) {
			if (event.keyCode == 13) {
				event.preventDefault();
				document.getElementById('submitSearch').click();
			}
		});

		var totalPage = "${totalPage}";
		var page = "${page}";
		var totalData = "${totalData}";

		if (totalData != 0 && page == 1) {
			document.getElementById("firstPage").disabled = true;
			document.getElementById("previousPage").disabled = true;
		}
		if (page == totalPage) {
			document.getElementById("nextPage").disabled = true;
			document.getElementById("lastPage").disabled = true;
		}

		function showFilter() {
			var x = document.getElementById("filter");
			if (x.style.display === "none") {
				x.style.display = "block";
			} else {
				x.style.display = "none";
			}
		}

		$(function() {

			//setting arrive time
			$('#startArriveTimePicker').datetimepicker({
				format : 'DD-MMM-YYYY HH:mm',
				sideBySide : true,
				useCurrent : false
			});
			$('#endArriveTimePicker').datetimepicker({
				format : 'DD-MMM-YYYY HH:mm',
				sideBySide : true,
				useCurrent : false
			//Important! See issue #1075
			});

			//setting depart time
			$('#startDepartTimePicker').datetimepicker({
				format : 'DD-MMM-YYYY HH:mm',
				sideBySide : true,
				useCurrent : false
			});
			$('#endDepartTimePicker').datetimepicker({
				format : 'DD-MMM-YYYY HH:mm',
				sideBySide : true,
				useCurrent : false
			//Important! See issue #1075
			});

		});
	</script>
</body>
</html>
