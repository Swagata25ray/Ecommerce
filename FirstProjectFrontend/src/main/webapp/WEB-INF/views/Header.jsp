<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1">
 <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 

<style type="text/css">
#mycontainer
{
background-color:violet;
}
</style>
</head>

<body>
<div id="mycontainer" class="container">
</div>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Online Store</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="home">Home</a></li>
      <li><a href="login">Login</a></li>
      <li><a href="register">Register</a></li>
      <li><a href="contactus">Contact Us</a></li>
      <li><a href="aboutus">About Us</a></li>
      <li><a href="category">Manage Category</a></li>
      <li><a href="product">Manage Product</a></li>     
    </ul>
  </div>
  <div class="nav navbar-nav navber-right">
  	<font color="white" face="calibri" size="3">Welcome : </font>
  	<a href="/logout"><font color="white" face="calibri" size="2">LOGOUT</font></a>
  	</div>
</nav>

