<#import "parts/common2.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring/>
<#include "parts/security.ftlh">

<@c.page>
User requests

<table>
<#list users as user>
   <tr>
      <td>${user.username}</td>
                <td>
                <#list user.activitiesConfirmationMap?keys as activity>
                <#if  !user.get(activity)>
                ${activity.activityname}
                </#if>
                </#list>
                </td>
                <td><a href="/user/${user.id}" class="btn btn-outline-success" >edit</a></td>
   </tr>
</#list>
</table>
</@c.page>