<#import "parts/common2.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring/>

<@c.page>
List of users
<table class="table table-striped mt-3">
    <thead>
        <tr>
        <th>Name</th>
        <th>Role</th>
        <th><@spring.message "all.activities"/></th>
        <th>Activity start</th>
        <th>Activity end</th>
        <th>Total</th>
        </tr>
    </thead>
    <tbody>
        <#list users as user>
            <tr>
                <td>${user.username}</td>
                <td>${user.role}</td>
                <td>
                    <#list usersActivities as userActivity>
                    <table>
                      <#if userActivity.user.id == user.id>
                            <tr>${userActivity.activity.activityname}</tr>
                      </#if>
                      </table>
                    </#list>
                </td>
                <td></td>
                <td></td>
                <td><a href="/user/${user.id}" class="btn btn-outline-success" ><@spring.message "edit"/></a></td>
            </tr>
        </#list>
    </tbody>
</table>
</@c.page>