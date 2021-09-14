<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:startwrapper>
    <p>login</p>
    <a href="?lang=en" class="dropdown-item" style="width: 10%;">EN</a>
    <a href="?lang=ru" class="dropdown-item" style="width: 10%;">UA</a>
    <form method="post" class="form-signin">
        <h1 class="h3 mb-3 font-weight-normal mt-5"><@spring.message "authorise"/></h1>
        <div style="display: flex; flex-direction: column; align-items: center;">
            <label  class="sr-only"><@spring.message "login"/></label>
            <input type="text" name="name" class="form-control mt-1" style="width: 30%;">
            <label class="sr-only mt-2"><@spring.message "password"/></label>
            <input type="password" name="pass" class="form-control mt-1" placeholder="Password" style="width: 30%;">
                <%--            <input type="hidden" name="_csrf" value="${_csrf.token}" />--%>
            <button class="btn btn-lg btn-primary btn-block mt-3" type="submit">sign.in</button>
            <a href="${pageContext.request.contextPath}/registration">register now</a>
        </div>
    </form>
</t:startwrapper>