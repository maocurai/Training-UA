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
                <td><#list user.roles as role>${role}<#sep>, </#list></td>
                <td>
                    <#list user.userActivitiesSet as activity>
                        ${activity.activityname}
                    </#list>
                </td>
                <td><a href="/user/${user.id}" class="btn btn-outline-success" >edit</a></td>
            </tr>
        </#list>
    </tbody>
</table>
</@c.page>