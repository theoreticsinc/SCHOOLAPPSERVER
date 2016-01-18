<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html data-ng-app="inventoryapp">
<head>
<meta charset="utf-8" />
<title>WOM Content Management System</title>
<head>
	<link data-require="bootstrap-css@3.1.1" data-semver="3.1.1" rel="stylesheet" href='<c:url value="/resources/css/bootstrap.min.css" />' />
	<link rel="stylesheet" href='<c:url value="/resources/css/xeditable.css" />' />
	<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/main.css" />'/>
	
	<script data-require="angular.js@1.3.0" data-semver="1.3.0" src="https://code.angularjs.org/1.3.0/angular.js"></script>
	<script src='<c:url value="/resources/js/xeditable/xeditable.js" />' ></script>
	<script src="http://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.10.0.min.js"></script>
	<script data-require="jquery@*" data-semver="2.0.3" src="http://code.jquery.com/jquery-2.0.3.min.js"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> 
	<script src= '<c:url value="/resources/js/angular/dirPagination.js" />'></script>
	<script data-require="bootstrap@3.1.1" data-semver="3.1.1" src='<c:url value="/resources/js/bootstrap/bootstrap.min.js" />'></script>
	<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular-animate.js"></script>
</head>
  
  
<style>
	#inventory table{
		width: 1500px;
	}
	#inventory table, th , td {
	  border: 1px solid grey;
	  border-collapse: collapse;
	  padding: 5px;
	}
	#inventory table tr:nth-child(odd) {
	  background-color: #f1f1f1;
	}
	#inventory table tr:nth-child(even) {
	  background-color: #ffffff;
	}
	
	.processing {  
	    position:absolute;
	    top:200px;
	    left:520px;
	    width:100px;
	    height:100px;
	    z-index:1000;
	    
	    opacity: .6;
	}
	
</style> 
<script>
	
    var inventoryapp = angular.module('inventoryapp', ['angularUtils.directives.dirPagination', 'ui.bootstrap', 'xeditable' ]);
    
    inventoryapp.controller('SummaryController', function ($scope, $http){
    	
    	$scope.currentPage = 1;
    	$scope.pageSize = 10;
    	
    	$scope.getProductList = function() {  
    		$scope.loading = true;
    		
    		if($scope.productcode === ''){ $scope.productcode = '-'}
    		if($scope.brand === ''){ $scope.brand = '-'}
    		if($scope.categorycode === ''){ $scope.categorycode = '-'}
    		
        	$http.get('searchInventoryCode/' + encodeURIComponent($scope.productcode) + '/' + encodeURIComponent($scope.brand) + '/' + encodeURIComponent($scope.categorycode))
            .success(function(data, status, headers, config) {
            	console.log("search >> " + data);
            	$scope.inventorylist = data;
            	$scope.loading = false;
            })
            .error(function(data, status, headers, config) {
            	alert('Error in Parameters')
            	$scope.loading = false;
            });
        };
        
        $scope.cancel = function () {
            window.location.reload(); 
        };
        
        $scope.pageChangeHandler = function(num) {
            console.log('changed to ' + num);
        };
    });
    function PageController($scope) {
   	  $scope.pageChangeHandler = function(num) {
   	    console.log('going to page ' + num);
   	  };
  }
    inventoryapp.controller('PageController', PageController);
</script>
</head>

<body id="mainpage" class="mainpage">
<header id="banner" class="body">
	<h1>Content Management System</h1>
	<c:url var="home" value="/amti/cms/home"/>
	<c:url var="password" value="/amti/cms/password"/>
	<c:url var="uploading" value="/amti/cms/uploadimages"/>
	<c:url var="purchaseorders" value="/amti/cms/purchaseorders"/>
	<c:url var="salesorder" value="/amti/cms/salesorder"/>
	<c:url var="otherdetails" value="/amti/cms/otherdetails"/>
	<c:url var="addnewproduct" value="/amti/cms/addnewproductpage"/>
	<c:url var="logout" value="/amti/cms/login"/>
	<nav>
		<ul>
			<li><a href="${home}">Home</a></li>
			<li><a href="${logout}">Log Out</a></li>
		</ul>
	</nav>
 
</header><!-- /#banner -->

<section id="uicontent" class="body">
<div class="container">
    <div class="row">
    <div class="col-lg-8">
	<div data-ng-controller="SummaryController" class="my-controller"> 
		<table>
		 	<tr>
		        <td style="text-align:right" width="390px">Product Code : </td>
				<td><input id="productcode" name="productcode" type="text" data-ng-model="productcode"  data-ng-init="productcode='-'" size="70px"/></td>
			</tr>
	        <tr>
		        <td style="text-align:right" width="390px">Brand Name : </td>
				<td><input id="brand" name="brand" type="text" data-ng-model="brand" data-ng-init="brand='-'" size="70px"/></td>
			</tr>
			<tr>
				<td style="text-align:right" width="390px">Category Code : </td>
				<td><input id="categorycode" name="categorycode" type="text" data-ng-model="categorycode" data-ng-init="categorycode='-'" size="70px"/></td>
	        </tr>
			<tr>
		        <td colspan="2" style="text-align:center">
		        	<button data-ng-click="getProductList()">Search</button>
		        	<button data-ng-click="cancel()">Cancel</button>
		        </td>
	        </tr>
		</table>
		
		<div class="processing" data-ng-show="loading">
            <div class="input-group  pull-right">
                <img class="spinner"  src='<c:url value="/resources/images/loading51.gif" />' />
            </div>
        </div>
        
		<div class="row">
           <div class="col-xs-4">
             <h3>Page: {{ currentPage }}</h3>
           </div>
           
           <div class="col-xs-4">
             <label for="search">Filter Result:</label>
             <input data-ng-model="q" id="search" class="form-control" placeholder="Filter text">
           </div>
           
           <div class="col-xs-4">
             <label for="search">items per page:</label>
             <input type="number" min="1" max="100" class="form-control" data-ng-model="pageSize">
           </div>
        </div>
        <div class="panel panel-default">
        	<div class="panel-body">
			<table id="product">
				<thead>
					<tr>
						<th>No</th>
						<th>Product Code</th>
						<th>Brand</th>
						<th>Product Name</th>
						<th>Pack Weight</th>
						<th>Pack Mass</th>
						<th>Store Code</th>
						<th>Stock Location</th>
						<th>Supplier Price</th>
						<th>RRPrice</th>
						<th>PO</th>
						<th>SO</th>
						<th>RFC</th>
						<th>RTV</th>
						<th>Balance Unit</th>
						<th>Edit</th>
					</tr>
				</thead>
				<tbody>
					<tr data-dir-paginate="inventory in inventorylist | filter:q | itemsPerPage: pageSize" data-current-page="currentPage">
					   	<td>{{ $index + 1 }}</td>
					    <td><span data-editable-text="inventory.productCode" data-e-name="pcode" data-e-form="rowform" data-e-style="width: 77px" data-e-disabled="disabled">
					    {{ inventory.productCode }}</span></td>
					    
					    <td><span data-editable-textarea="inventory.brand" data-e-name="brandname" data-e-form="rowform" data-e-style="width: 60px;  height: 60px">
					    {{ inventory.brand }} </span></td>
					    
					    <td style="white-space: nowrap">
					    <!-- form -->
					        <form data-editable-form name="rowform" data-onbeforesave="saveEditedProduct($data)" data-ng-show="rowform.$visible" class="form-buttons form-inline">
					          <button type="submit" data-ng-disabled="rowform.$waiting" class="btn btn-primary">
					            save
					          </button>
					          <button type="button" data-ng-disabled="rowform.$waiting" data-ng-click="rowform.$cancel()" class="btn btn-default">
					            cancel
					          </button>
					        </form>
	        				<div class="buttons" data-ng-show="!rowform.$visible">
					          <button class="btn btn-primary" data-ng-click="rowform.$show()">edit</button>
					        </div>  
				        </td>
					 </tr>
				</tbody>
			</table>
			</div>
		</div>
    </div>	
	<div data-ng-controller="PageController" class="other-controller">
		 <small></small>
         <div class="text-center">
         	<dir-pagination-controls boundary-links="true" on-page-change="pageChangeHandler(newPageNumber)" template-url='<c:url value="/resources/js/angular/dirPagination.tpl.html" />'></dir-pagination-controls>
       	</div>
	</div>
	</div>
	</div>
</div>
</section><!-- /#content -->
<%@ include file="productfooter.jsp" %>

</body>
