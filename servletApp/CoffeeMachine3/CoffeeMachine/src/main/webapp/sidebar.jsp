<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="d-flex flex-column flex-shrink-0 p-3 bg-light" style="width: 280px; height: 100vh;">
    <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none">
      <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"></use></svg>
      <p class="fs-4">${sessionScope.loggedUsername}<br>${sessionScope.loggedUserRole}</p>
    </a>
    <hr>
    <ul class="nav nav-pills flex-column mb-auto">
        <c:if test="${sessionScope.isAdmin}">
        <li class="nav-item">
        <a href="/user" class="nav-link link-dark" aria-current="page">
          <svg class="bi me-2" width="16" height="16"><use xlink:href="#home"></use></svg>
<%--          <@spring.message "admin.users"/>--%>users
        </a>
      </li>
      <li class="nav-item">
        <a href="/userRequests" class="nav-link link-dark" aria-current="page">
          <svg class="bi me-2" width="16" height="16"><use xlink:href="#home"></use></svg>
<%--          <@spring.message "admin.user.requests"/>--%>requests
        </a>
      </li>
      <li>
         <a href="/category" class="nav-link link-dark">
             <svg class="bi me-2" width="16" height="16"><use xlink:href="#speedometer2"></use></svg>
<%--             <@spring.message "admin.activity.category"/>--%>category
         </a>
      </li>

      <li>
          <a href="/activity" class="nav-link link-dark">
          <svg class="bi me-2" width="16" height="16"><use xlink:href="#table"></use></svg>
<%--          <@spring.message "all.activities"/>--%>activities
           </a>
      </li>
        </c:if>

            <c:if test="${! sessionScope.isAdmin}">
      <li>
        <a href="/activity/${sessionScope.loggedUserId}" class="nav-link link-dark">
          <svg class="bi me-2" width="16" height="16"><use xlink:href="#table"></use></svg>
<%--          <@spring.message "all.activities"/>--%>activities
        </a>
      </li>
         </c:if>
    </ul>
  </div>