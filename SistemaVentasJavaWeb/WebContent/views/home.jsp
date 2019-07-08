<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ventas | ${title}</title>
<script>
  window.menu = '${title}';	
  window.contextRoot = '${contextRoot}';	  
</script>

<%@include file="../WEB-INF/jspf/css/cssLinks.jspf" %>	
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
	
  <%@include file="../WEB-INF/jspf/header.jspf" %>
  	
  <!-- Left side column. contains the logo and sidebar -->
  <%@include file="../WEB-INF/jspf/sidebar.jspf" %>
  
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    		
    <section class="content-header">
		<h1>
			home page
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-home"></i> Home</a></li>
			<li class="active">About</li>
		</ol>
	</section>		
	        
			
  </div>
  <!-- /.content-wrapper -->
  
  <%@include file="../WEB-INF/jspf/footer.jspf" %>

  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->


<%@include file="../WEB-INF/jspf/js/jsSrc.jspf" %>
</body>
</html>