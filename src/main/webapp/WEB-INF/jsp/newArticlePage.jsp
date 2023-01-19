<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/styleNewArticlePage.css"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script type="text/javascript" src="winAuctionPage.js"></script>

<title>Vente</title>
</head>
<body>
	
	<header>
		<%@include file="headerFragment.jsp"%>
	</header>
		<c:if test="${articleOngoing != null }">
		<%@include file="updateArticleFormFragment.jsp"%>
	</c:if>
	
	<c:if test="${articleOngoing == null }">
		<%@include file="newArticleFormFragment.jsp"%>
	</c:if>
	
</body>
</html>