<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="typeinc" uri="http://hastybox.com/taglib/typeinc"
%><%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/show/${self.id}" var="showUrl"/>
<li>
	<a href="${showUrl}" id="showLink_${self.id}" class="person">
		<c:out value="${self.firstname}" />
		<c:out value="${self.lastname}" />
	</a>
</li>
