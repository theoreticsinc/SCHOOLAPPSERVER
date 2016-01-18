<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>WOM Content Management System</title>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/main.css" />'/>
</head>
<body id="mainpage" class="mainpage">
<header id="banner" class="body">
	<h1>Content Management System</h1>
	<c:url var="password" value="/amti/cms/password"/>
	<c:url var="productpromotional1" value="/amti/cms/productpromotional1"/>
	<c:url var="amendproducts" value="/amti/cms/amendproducts"/>
	<c:url var="purchaseorders" value="/amti/cms/purchaseorders"/>
	<c:url var="salesorder" value="/amti/cms/salesorder"/>
	<c:url var="maindetails" value="/amti/cms/maindetails"/>
	<c:url var="otherdetails" value="/amti/cms/otherdetails"/>
	<c:url var="addnewproduct" value="/amti/cms/addnewproductpage"/>
	<c:url var="addnewsupplier" value="/amti/cms/addnewsupplierpage"/>
	<c:url var="inventorysummary" value="/amti/cms/inventorysummary"/>
	<c:url var="salessummary" value="/amti/cms/salessummary"/>
	<c:url var="logout" value="/amti/cms/login"/>
	<nav>
		<ul>
			<li>
				<a href="#">Staff</a>
				<ul>
					<li><a href="${password}">Change Password</a></li>
					<li><a href="#">New Staff</a></li>
				</ul>
			</li>
	 		<li class="active"><a href="#">Documents</a>
	 			<ul>
					<li><a href="${purchaseorders}">Purchase Order</a></li>
					<li><a href="${salesorder}">Sales Order</a></li>
				</ul>
	 		</li>
			<li><a href="#">Product</a>
				<ul>
					<li><a href="${productpromotional1}">Product Promotional 1</a></li>
					<li><a href="#">Product Details</a>
						<ul>
							<li><a href="${addnewproduct}">Add New Product</a></li>
							<li><a href="${maindetails}">Edit Main Details</a></li>
							<li><a href="${otherdetails}">Edit Other Details</a></li>
						</ul>
					</li>
					
				</ul>
			</li>
			<li><a href="#">Supplier</a>
				<ul>
					<li><a href="${addnewsupplier}">Add New Supplier</a></li>
					<li><a href="#">Edit Supplier's Product</a></li>
				</ul>
			</li>
			<li><a href="#">Summary</a>
				<ul>
					<li><a href="${inventorysummary}">Inventory Summary</a></li>
					<li><a href="${salessummary}">Sales Summary</a></li>
				</ul>
			</li>
			<li><a href="${logout}">Log Out</a></li>
		</ul>
	</nav>
 
</header><!-- /#banner -->

<section id="content" class="body">
	<img src='<c:url value="/resources/img/logo2.jpg" />' class="photo" />
</section><!-- /#content -->

<%@ include file="footer.jsp" %>

</body>
</html>