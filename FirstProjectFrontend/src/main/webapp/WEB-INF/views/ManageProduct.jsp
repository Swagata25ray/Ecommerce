<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@include file="Header.jsp" %>


<form:form action="ProductInsert" Attribute="product" method="post">

<table align="center" cellspacing="3">

<tr bgcolor="pink">
	<td colspan="2"><center>Product Manage</center>center></td>
</tr>

<tr>
	<td> Product Name </td>
	<td> <form:input path="productName" /></td>
</tr>

<tr>
	<td> Product Description </td>
	<td> <form:input path="productDesc" /></td>
</tr>

<tr>
	<td> Price </td>
	<td> <form:input path="price" /></td>
</tr>

<tr>
	<td> Stock </td>
	<td> <form:input path="stock"/></td>
</tr>

<tr>
	<td> Category </td>
	<td> 
	<form:select path="categoryID">
		<form:option value="0" lable="---Select List---"/>
		<form:options items="${categoryList}"/>
	</form:select>
	</td>
</tr>

<tr>
	<td> Supplier </td>
	<td> <form:input path="supplierId"/></td>
</tr>

<tr>
	<td colspan="2">
		<center><input type="submit" value="Save"/></center>
	</td>
</tr>
</table>
</form:form>

<table align="center">
	<tr bgcolor="pink">
		<td>Product ID</td>
		<td>Product Name</td>
		<td>Product Desc</td>
		<td>Price</td>
		<td>Stock</td>
		<td>Category</td>
		<td>Supplier</td>
		<td>Operation</td>
	</tr>
	<c:forEach items="${productList}" var="product">
	<tr>
		<td>${product.productID}</td>
		<td>${product.productName}</td>
		<td>${product.productDesc}</td>
		<td>${product.price}</td>
		<td>${product.stock}</td>
		<td>${product.categoryID}</td>
		<td>${product.supplierID}</td>
		<td>
			<a href="<c:url value='/deleteProduct/${product.productID}'/>">Delete</a>
			<a href="<c:url value='/editProduct/${product.productID}'/>">Edit</a>
		</td>
	</tr>
	</c:forEach>
</table>
		

</body>
</html>