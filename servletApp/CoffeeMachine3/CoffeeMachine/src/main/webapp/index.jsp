<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:wrapper>
    <h2>
            Hello World!
        </h2>

    <br/>
        <a href="${pageContext.request.contextPath}/login">Login</a>
    <br/>
        <a href="${pageContext.request.contextPath}/registration">Registration form</a>
    <br>
        <a href="${pageContext.request.contextPath}/exception">Exception</a>
</t:wrapper>