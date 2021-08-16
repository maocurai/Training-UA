<#import "parts/common2.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring/>

<@c.page>
<h2>User ${user.username} info</h2>
<h3>Role ${user.role}</h3>
<table class="table table-striped mt-3">
    <thead>
        <tr>
            <th><@spring.message "all.activities"/></th>
            <th>Activity start</th>
            <th>Activity end</th>
            <th>Activity status</th>
        </tr>
    </thead>
<tbody>
    <#list usersActivities as userActivity>
            <tr>
                <td>
                   ${userActivity.activity.activityname}
                </td>
                <td>
                    <#list usersActivitiesTime as usersActivityTime>
                       <#if userActivity.activity.id == usersActivityTime.userAndActivityId.activityId>
                           ${usersActivityTime.startTime}
                       </#if>
                     </#list>
                </td>
                <td>
                   <#list usersActivitiesTime as usersActivityTime>
                        <#if userActivity.activity.id == usersActivityTime.userAndActivityId.activityId>
                            ${usersActivityTime.endTime}
                        </#if>
                   </#list>
                </td>
                <td>${userActivity.status}</td>
            </tr>
    </#list>
    <tfoot>Total activities: ${usersActivities?size}</tfoot>
    </tbody>
</table>
</@c.page>