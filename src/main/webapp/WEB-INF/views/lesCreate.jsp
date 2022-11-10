<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
		
		<jsp:include page="layout/cssLib.jsp" />
		<style type="text/css">
			.multiselect.dropdown-toggle {
			    text-align: left;
			}
		</style>
		<style>
	      /* Always set the map height explicitly to define the size of the div
	       * element that contains the map. */
	      #map-canvas {
	        height: 300px;
	        width:500px;
	      }
	      /* Optional: Makes the sample page fill the window. */
	      /* html, body {
	        height: 100%;
	        margin: 0;
	        padding: 0;
	      } */
	      #description {
	        font-family: Roboto;
	        font-size: 15px;
	        font-weight: 300;
	      }
	
	      #infowindow-content .title {
	        font-weight: bold;
	      }
	
	      #infowindow-content {
	        display: none;
	      }
	
	      #map-canvas #infowindow-content {
	        display: inline;
	      }
	
	      .pac-card {
	        margin: 2% 0 0 2%;
	        border-radius: 2px 0 0 2px;
	        box-sizing: border-box;
	        -moz-box-sizing: border-box;
	        outline: none;
	        box-shadow: 0 2px 6px rgba(0, 0, 0, 0.3);
	        background-color: #fff;
	        font-family: Roboto;
	      }
	      
	       .pac-container, .pac-item{
	       	  z-index: 2147483647 !important;
		   }
		   
		   /* #pac-container {
	        padding-bottom: 12px;
	        margin-right: 12px;
	       } */
	
	      #pac-input {
	        background-color: #fff;
	        font-family: Roboto;
	        font-size: 15px;
	        font-weight: 300;
	        
	        margin-top: 6px;
	        margin-left: 6px;
	        margin-right: 6px;
	        margin-bottom: 6px;
	        
	        padding: 0 1px 0 13px;
	        text-overflow: ellipsis;
	        width: 400px;
	      }
	
	      #pac-input:focus {
	        border-color: #4d90fe;
	      }
	
	    </style>
	</head>
	
	<body id="body-class-custom" class="">
		<div class="wrapper">

        <!-- Navigation -->
        <jsp:include page="layout/navigation.jsp" />
        
        <div class="content-wrapper">
        	<section class="content-header">
		    	<h1>Web<small></small></h1>
		      	
		    </section>

            <section class="content">
            	<form:form id="lesCreateForm" method="post" modelAttribute="les" >
	            	<div class="box box-default">
				        <div class="box-header with-border">
				        	
				        </div>
				        <div class="box-body">
				          	<div class="row">
				            	<div class="col-md-6">
				            		
									<div class="form-group">
										<form:label for="name" path="name">Nama Lengkap : </form:label>
										<form:input id ="name" path="name" maxlength="50" class="form-control" required="true" />
									</div>
									
									<div class="form-group">
										<form:label for="address" path="address">Alamat : </form:label>
										<form:input id ="address" path="address" maxlength="50" class="form-control" required="true" />
									</div>
									
									<div class="form-group">
										<form:label for="bornDate" path="bornDate">Tanggal Lahir : </form:label>
										<div class="input-group date" id="bornDatePicker">
						                    <form:input id="bornDatePicker" path="bornDate" class="form-control" required="true" />
						                    <span class="input-group-addon">
						                        <span class="glyphicon glyphicon-calendar"></span>
						                    </span>
						                </div>
									</div>
									
									<div class="form-group">
										<form:label for="kelas" path="kelasId">Kelas: </form:label>
										<form:select id="kelas" path="kelasId" class="form-control" required="true" >
											<form:option value="0"  >-- Pilih --</form:option>
											<form:options items="${listKelas}" itemLabel="value" itemValue="id" />
										</form:select>
									</div>
									
									<div class="form-group">
										<form:label for="jurusan" path="jurusanId">Jurusan: </form:label>
										<form:select id="jurusan" path="jurusanId" class="form-control" required="true" >
											<form:option value="0"  >-- Pilih --</form:option>
											<form:options items="${listJurusan}" itemLabel="value" itemValue="id" />
										</form:select>
									</div>
									
									<div class="form-group">
										<form:label for="jenisPertemuan" path="jenisPertemuanId">Online/Offline: </form:label>
										<form:select id="jenisPertemuan" path="jenisPertemuanId" class="form-control" required="true" >
											<form:option value="0"  >-- Pilih --</form:option>
											<form:options items="${listJenisPertemuan}" itemLabel="value" itemValue="id" />
										</form:select>
									</div>
									
									<div class="form-group">
										<form:label for="jadwal" path="jadwalId">Jadwal: </form:label>
										<form:select id="jadwal" path="jadwalId" class="form-control" required="true" >
											<form:option value="0"  >-- Pilih --</form:option>
											<form:options items="${listJadwal}" itemLabel="value" itemValue="id" />
										</form:select>
									</div>
								</div>
								
								<div class= 'col-md-6'></div>
				        	</div>
				    	</div>
						<div class="box-footer with-border">
							<div class="row">
								<div class="col-md-12 text-left">
						       		<!-- <button type="submit" class="btn btn-primary">Submit</button> -->
						       		<input type="submit" id="submitSave" name="submitSave" value="Save" class="btn btn-primary">
									<input type="button" id="submitCancel" name="submitCancel" onclick="window.location.href='/mywebapp/attendance/list'" value="Cancel" class="btn btn-default" formnovalidate>
						        </div>
							</div>
						</div>
					</div>
				</form:form>
	    	</section>
        </div>
    </div>

	<jsp:include page="layout/jsLib.jsp" />
	<script type="text/javascript">
		$(function () {
	        $('#bornDatePicker').datetimepicker({
	            format: 'DD-MM-YYYY'
	        });
	        
	        $('#bornDatePicker').data("DateTimePicker").date(new Date());
	        
	        
	        
	    });
		
		$('#lesCreateForm').submit(function (){
			//alert('test');
			//return false;
	    	/* $("#lesCreateForm").ajaxSubmit({})
	    	 */
	    });
		
	
	</script>

</body>
</html>