<#import "parts/common2.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring/>

<@c.page>
    <p class="h5 mt-5"><@spring.message "user.name"/>: ${user.username}</p>
    <p class="h5 mt-1"><@spring.message "user.role"/>: ${user.role}</p>
    <p class="h5 mt-1"><@spring.message "activity.total"/>: ${usersActivities?size}</p>
<table class="table table-striped mt-3">
    <thead>
        <tr>
            <th><@spring.message "all.activities"/></th>
            <th><@spring.message "activity.start"/></th>
            <th><@spring.message "activity.end"/></th>
            <th><@spring.message "activity.status"/></th>
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
    </tbody>
</table>
</@c.page>