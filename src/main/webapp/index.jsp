<%@ page import="java.util.List" %>
<%@ page import="com.servletdemo.dao.Entity" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<%-- Entity dao = new EntityDAOImpl();	for (Entity folk : allFolks) {
 --%>
 <%! int i = 0; %>
 <%--! Entity folk; --%>
<html>
<body>qwe<br/>
<%
List<Entity> allFolks = (List<Entity>) request.getAttribute("folks");
String themessage = (String) request.getAttribute("message");
for (int i = 0; i < allFolks.size(); ++i) {
	out.println(allFolks.get(i).getName() + "<br/>");
}
out.println(themessage);
%>
<%--= request.getAttribute("message") --%>
<c:out value = "${themessage}"/>
<c:forEach var="i" begin="1" end="5">
   Item <c:out value="${i}"/><br/>
</c:forEach>
<c:forEach items="${allFolks}" var="folk">
    <c:out value = "${folk.name}"/>
</c:forEach>
<form method = "post">
Name: <input type="text" name="input_name">
<button type="submit" value="AddValue" formmethod="post">Add</button><br/>
</form>
</body>
</html>
