<#macro sidebar>
<#include "security.ftlh">
<div class="d-flex flex-column flex-shrink-0 p-3 bg-light" style="width: 280px; height: 100vh;">
    <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none">
      <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"></use></svg>
      <p class="fs-4">${name}<br>${role}</p>
    </a>
    <hr>
    <ul class="nav nav-pills flex-column mb-auto">

    <#if isAdmin>
      <li class="nav-item">
        <a href="/user" class="nav-link link-dark" aria-current="page">
          <svg class="bi me-2" width="16" height="16"><use xlink:href="#home"></use></svg>
          <@spring.message "admin.users"/>
        </a>
      </li>
      <li class="nav-item">
        <a href="/userRequests" class="nav-link link-dark" aria-current="page">
          <svg class="bi me-2" width="16" height="16"><use xlink:href="#home"></use></svg>
          <@spring.message "admin.user.requests"/>
        </a>
      </li>
      <li>
         <a href="/adminCategory" class="nav-link link-dark">
             <svg class="bi me-2" width="16" height="16"><use xlink:href="#speedometer2"></use></svg>
             <@spring.message "admin.activity.category"/>
         </a>
      </li>

      <li>
          <a href="/adminActivity" class="nav-link link-dark">
          <svg class="bi me-2" width="16" height="16"><use xlink:href="#table"></use></svg>
          <@spring.message "all.activities"/>
           </a>
      </li>
    </#if>

    <#if !isAdmin>
      <li>
        <a href="/adminActivity/${loggedUserId}" class="nav-link link-dark">
          <svg class="bi me-2" width="16" height="16"><use xlink:href="#table"></use></svg>
          <@spring.message "all.activities"/>
        </a>
      </li>
      </#if>
    </ul>
  </div>
</#macro>