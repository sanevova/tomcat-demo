<%@ page import="java.util.List" %>
<%@ page import="com.servletdemo.dao.Entity" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

 <%! int i = 0; %>
<html>
<body>qwe<br/>
<c:out value = "${message}"/><br/>
<c:forEach items="${folks}" var="folk">
    <c:out value = "${folk.id} - ${folk.name}"/><br/>
</c:forEach>
<form method = "post">
Name: <input type="text" name="input_name">
<button type="submit" value="AddValue" formmethod="post">Add</button><br/>
</form>
</body>
</html>
