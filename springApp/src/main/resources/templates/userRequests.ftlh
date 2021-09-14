<#import "parts/common2.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring/>
<#include "parts/security.ftlh">

<@c.page>
<p class="h3 mt-5"><@spring.message "admin.user.requests"/></p>
<table class="table table-striped mt-3">
    <thead>
    <tr>
        <th><@spring.message "user.name"/></th>
        <th><@spring.message "activity.name"/></th>
        <th><@spring.message "request.type"/></th>
        <th colspan="2"><@spring.message "user.action"/></th>
    </tr>
    </thead>
    <tbody>
    <#list usersActivities as userActivity>
    <form action="/userRequests/ad" method="post">
          <tr>
             <td>${userActivity.user.username}</td>
             <td>${userActivity.activity.activityname}</td>
             <td>${userActivity.status}</td>
             <td><button name="newActivityStatus" class="btn btn-outline-success" value="CONFIRMED">Confirm</button></td>
             <td><button name="newActivityStatus" class="btn btn-outline-danger" value="DENIED">Deny</button></td>
             <input type="hidden" name="activityId" value="${userActivity.activity.id}"/>
             <input type="hidden" name="userId" value="${userActivity.user.id}"/>
             <input type="hidden" value="${_csrf.token}" name="_csrf">
          </tr>
    </form>
    </#list>
    </tbody>
</table>
</@c.page>