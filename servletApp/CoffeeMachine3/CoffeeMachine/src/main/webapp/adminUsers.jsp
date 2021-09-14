<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
<head>
    <title>Title</title>
</head>
List of users
<table class="table table-striped mt-3">
    <thead>
    <tr>
        <th>Name</th>
        <th>Role</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${requestScope.usersList}">
    <tr>
        <td>${user.username}</td>
        <td>${user.role}</td>
        <td><a href="${pageContext.request.contextPath}/user/info/${user.id}" class="btn btn-outline-success" >more</a></td>
        <td><a href="${pageContext.request.contextPath}/user/${user.id}" class="btn btn-outline-success" >edit</a></td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</t:wrapper>
