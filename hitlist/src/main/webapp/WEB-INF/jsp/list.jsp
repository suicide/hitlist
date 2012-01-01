<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>List</title>
</head>
<body>
	<h1>Hitlist</h1>
	<p>People to kill</p>
	<ul>
		<c:forEach items="${personList}" var="person">
			<c:url value="/show/${person.id}" var="showUrl"/>
			<li>
				<a href="${showUrl}" id="showLink_${person.id}" class="person">
					<c:out value="${person.firstname}" />
					<c:out value="${person.lastname}" />
				</a>
			</li>
		</c:forEach>
	</ul>
	<c:url var="addUrl" value="/add" />
	<a href="${addUrl}" id="addLink">add</a>
</body>
</html>