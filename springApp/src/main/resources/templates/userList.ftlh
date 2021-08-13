<#import "parts/common2.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring/>

<@c.page>
List of users
<table>
    <thead>
        <tr>
        <th>Name</th>
        <th>Role</th>
        <th><@spring.message "all.activities"/></th>
        </tr>
    </thead>
    <tbody>
        <#list users as user>
            <tr>
                <td>${user.username}</td>
                <td>${user.role}</td>
                <td>
                    <#list usersActivities as userActivity>
                      <#if userActivity.user.id == user.id>
                            ${userActivity.activity.activityname}
                      </#if>
                    </#list>
                </td>
                <td><a href="/user/${user.id}" class="btn btn-outline-success" >edit</a></td>
            </tr>
        </#list>
    </tbody>
</table>
</@c.page>