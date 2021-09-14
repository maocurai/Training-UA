<#import "parts/common2.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring/>

<@c.page>
<p class="h3 mt-5"><@spring.message "user.list"/></p>
<table class="table table-striped mt-3">
    <thead>
        <tr>
        <th><@spring.message "user.name"/></th>
        <th><@spring.message "user.role"/></th>
        <th colspan="2"><@spring.message "user.action"/></th>
        </tr>
    </thead>
    <tbody>
        <#list users as user>
            <tr>
                <td>${user.username}</td>
                <td>${user.role}</td>
                <td><a href="/user/info/${user.id}" class="btn btn-outline-success" ><@spring.message "more"/></td>
                <td><a href="/user/${user.id}" class="btn btn-outline-success" ><@spring.message "edit"/></a></td>
            </tr>
        </#list>
    </tbody>
</table>
</@c.page>