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
<c:url var="jqueryUrl" value="/static/js/jquery-1.7.1.js" />
<c:url var="json2Url" value="/static/js/json2.js" />
<c:url var="underscoreUrl" value="/static/js/underscore.js" />
<c:url var="backboneUrl" value="/static/js/backbone.js" />
<script type="text/javascript" src="${jqueryUrl}" ></script>
<script type="text/javascript" src="${json2Url}" ></script>
<script type="text/javascript" src="${underscoreUrl}" ></script>
<script type="text/javascript" src="${backboneUrl}" ></script>
<title>Show</title>
</head>
<body>
	<h1>Person to kill</h1>
	<p>
		Firstname: <span id="firstname"><c:out value="${person.firstname}" /></span><br />
		Lastname: <span id="lastname"><c:out value="${person.lastname}" /></span>
	</p>
	<c:url var="listUrl" value="/list" />
	<a href="${listUrl}" id="listLink">list all</a>
</body>
</html>