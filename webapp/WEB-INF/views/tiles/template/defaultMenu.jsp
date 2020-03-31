<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
	<c:url value="/city/add" var="cityAdd"></c:url>
	<a href="<c:out value="${cityAdd}"/>">Add city</a>
</div>

<div>
	<c:url value="/company" var="companyHome"></c:url>
	<a href="<c:out value="${companyHome}"/>">Company home</a>
</div>

<div>
	<c:url value="/company/add" var="companyAdd"></c:url>
	<a href="<c:out value="${companyAdd}"/>">Company add</a>
</div>

<div>
	<c:url value="/businessPartner/add" var="businessPartnerAdd"></c:url>
	<a href="<c:out value="${businessPartnerAdd}"/>">Business partner
		add</a>
</div>