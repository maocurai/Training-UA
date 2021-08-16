<#import "parts/common2.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring/>
<#include "parts/security.ftlh">

<@c.page>
User requests

<table class="table table-striped mt-3">
    <#list usersActivities as userActivity>
    <form action="/ad" method="post">
          <tr>
             <td>${userActivity.user.username}</td>
             <td>${userActivity.activity.activityname}</td>
             <td>${userActivity.status}</td>
             <td><button name="newActivityStatus" value="CONFIRMED">Confirm</button></td>
             <td><button name="newActivityStatus" value="DENIED">Deny</button></td>
             <input type="hidden" name="activityId" value="${userActivity.activity.id}"/>
             <input type="hidden" name="userId" value="${userActivity.user.id}"/>
             <input type="hidden" value="${_csrf.token}" name="_csrf">
          </tr>
    </form>
    </#list>
</table>
</@c.page>