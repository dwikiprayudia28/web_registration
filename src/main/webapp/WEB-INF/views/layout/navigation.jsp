<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
  <script>
    document.getElementById("body-class-custom").className = "hold-transition skin-blue-light sidebar-mini";
  </script>
  <header class="main-header">
    <a href="/mywebapp" class="logo">
      <span class="logo-mini"><b>PO</b></span>
      <span class="logo-lg"><b>Product</b>Order</span>
    </a>
    <nav class="navbar navbar-inverse navbar-static-top">
    <!-- <nav class="navbar navbar-static-top"> -->
      <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>

      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-user"></i>
              <span class="hidden-xs">${pageContext.request.userPrincipal.name}</span>
              <b class="caret"></b>
            </a>
            <ul class="dropdown-menu">
           	 <li class="user-header">
                <img src="/mywebapp/images/profile-pict.png" class="img-circle" alt="User Image">
                <p>
                  ${pageContext.request.userPrincipal.name}
                </p>
                <small id="role-name" style="color:white;"></small>
              	</li>
              <li class="user-footer">
                <!-- <div class="pull-left">
                  <a href="#" class="btn btn-default btn-flat"></a>
                </div> -->
                <div class="pull-right">
                  <a href="/mywebapp/logout"><i class="fa fa-fw fa-power-off"></i> Sign out</a>
                </div>
              </li>
            </ul>
          </li>
        </ul>
      </div>
    </nav>
  </header>
  <script src="<c:url value='/styles/jquery/js/jquery.min.js'/>"></script>
  <script type="text/javascript"></script>
  
  <aside class="main-sidebar">
    <section class="sidebar">
      <ul class="mylist sidebar-menu" data-widget="tree">
        <li class="header">MAIN NAVIGATION</li>
        <li class="">
          <a href="/mywebapp/les/list">
            <i class="fa fa-hand-o-right"></i> <span>Pendaftaran Les</span>
          </a>
          
        </li>
        
        
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>