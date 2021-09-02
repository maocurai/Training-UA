<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
<h1 class="h3 mb-3 font-weight-normal" style="text-align: center; margin-top: 30%;">
<@spring.message "user.greeting"/>${sessionScope.loggedUsername}</h1>
</t:wrapper>