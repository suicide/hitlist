<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="typeinc" uri="http://hastybox.com/taglib/typeinc"
%><%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Add new</title>
</head>
<body>
	<h1>Add new person to kill</h1>
	<p>
	<c:url value="/add" var="actionUrl" />
		<form:form commandName="form" action="${actionUrl}" method="post">
			<form:label path="person.firstname">Firstname</form:label><form:input path="person.firstname" /><br />
			<form:label path="person.lastname">Lastname</form:label><form:input path="person.lastname" /><br />
			<input type="submit" id="formSubmit"/>
		</form:form>
	</p>
	<c:url var="listUrl" value="/list" />
	<a href="${listUrl}" id="cancelLink">cancel</a>
</body>
</html>