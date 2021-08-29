<html>
<head>
    <title>Registration form</title>

</head>
<body>
        <h2>
            This is fucking registration form! <br/>
        </h2>

        <p>${requestScope.message}</p>

        <form method="post">
            <button type="submit">Send</button>
        </form>

        <a href="${pageContext.request.contextPath}/index.jsp">Index</a>
</body>
</html>