<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
     <%@ page isELIgnored= "false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
<script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>
<script src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>
<link href="https://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css" rel="stylesheet">
<style>
    /* Remove the navbar's default rounded borders and increase the bottom margin */ 
    .navbar {
      margin-bottom: 50px;
      border-radius: 0;
    }
    
    /* Remove the jumbotron's default bottom margin */ 
     .jumbotron {
      margin-bottom: 0;
    }
   
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
  </style>
</head>
<body>
<nav class="navbar navbar-default">
<div class="container-fluid">
<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#collapse-example" aria-expanded="false">
<span class="sr-only">Toggle navigation</span>
<span class="icon-bar"></span>
<span class="icon-bar"></span>
<span class="icon-bar"></span>
</button>
<div class="navbar-header">
<c:url value="/resources/images/Capture.JPG" var="url5"></c:url>
<a class="navbar-brand" href="#"><img src="${url5 }" alt="NIIT" height="30px" width="30px"></a>
</div>
<div class="collapse navbar-collapse" id="collapse-example">
<ul class="nav navbar-nav">
<c:url value="/home" var="url1"></c:url>
<li class="active"><a href="${url1 }">Home<span class="sr-only">You are in home page link</span></a></li>
<c:url value="/aboutus" var="url2"></c:url>
<li><a href="${url2 }">About Us</a></li>
 <c:url value="/admin/getproductform" var="url3"></c:url>
<li>
<c:if test="${pageContext.request.userPrincipal.name!=null }">
			<security:authorize access="hasRole('ROLE_ADMIN')">
			  			   <a href="${url3 }">Add Product</a>
			  </security:authorize>
			  <li><security:authorize access="hasRole('ROLE_USER')">
			  <li><a href="<c:url value="/cart/getcart">
			  </c:url>">Cart</a></li></security:authorize>
			</c:if>
			</li>
<c:url value="/all/product/getallproducts" var="url4"></c:url>
<li><a href="${url4 }">Browse All Products</a></li>
<li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">category<span class="caret"></span></a>
          <ul class="dropdown-menu">
           <c:url value="/all/product/searchbycategory?searchCondition=${c.categoryName }" var="curl"></c:url>
               <c:url value="/all/product/searchbycategory?searchCondition=All" var="curl1"></c:url>
          <c:forEach items="${categories}" var="c">
                    <li> <a href=" ${curl } ">${c.categoryName }</a></li>     
           </c:forEach>
                 
           <li><a href="${curl1}">all</a>
          </ul>
        </li>
<li>
			<c:if test="${pageContext.request.userPrincipal.name!=null }">
			<a href="">Welcome ${pageContext.request.userPrincipal.name }</a>
			</c:if>
			</li>
			
			<c:if test="${pageContext.request.userPrincipal.name==null }">
<c:url value="/all/registrationform" var="url5"></c:url>
<li><a href="${url5 }">Sign Up</a></li>
	<c:url value="/login" var="url6"></c:url>
		    <li><a href="${url6 }">Sign In</a></li>
</c:if>
 <c:url value="/j_spring_security_logout" var="logoutUrl"></c:url>
		    <c:if test="${pageContext.request.userPrincipal.name!=null }">
		    <li><a href="${logoutUrl }">logout</a></li>
		    </c:if>
</ul>
</div>
<!--  <li><a href="aboutus">About Us</a></li>-->
			<!--  http://localhost:8080/project1_frontend/getproductform -->
<!--  			<li><a href="getproductform">Add Product</a></li> -->
<!--  			<li><a href="all/product/getallproducts">Browse All Products</a></li> -->
</div>
</nav>
</body>
</html>