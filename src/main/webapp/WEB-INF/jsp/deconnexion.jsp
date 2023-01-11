<%
session.invalidate();
%>
<jsp:forward page="ServletConnexionPage.jsp">
<jsp:param name="msg" value="msg" />
</jsp:forward>