<#import "parts/common2.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring/>
<#include "parts/security.ftlh">

<@c.page>
<#if isAdmin>
User editor
    <form action="/user" method="post">
        <input type="text" name="username" value="${userToEdit.username}">
        <#list roles as role>
            <div>
                <p><input type="radio" name="${role}">${role}</p>
            </div>
        </#list>
        <h4>User's activities</h4>
        <table>
            <tbody>
                <#list usersActivities as userActivity>
                    <#if userActivity.user.id == userToEdit.id>
                      ${userActivity.activity.activityname}
                    </#if>
               </#list>
            </tbody>
        </table>

            <h4>Add activity</h4>
            <div class="col-md-4 col-lg-4 order-md-last dropdown">
                <#list activities as activity>
                    <div>
                        <label><input type="checkbox" name="${activity.activityname}"/>${activity.activityname}</label>
                    </div>
                </#list>
            </div>
            <input type="hidden" name="username" value="${userToEdit.username}">
            <input type="hidden" value="${userToEdit.id}" name="userId">
            <input type="hidden" value="${_csrf.token}" name="_csrf">
            <button type="submit">Save</button>
    </form>

<#else>
<form action="/user" method="post">
    <h4>Add activity</h4>
    <div class="col-md-4 col-lg-4 order-md-last dropdown">
        <#list activities as activity>
            <div>
            <label><input type="checkbox" name="${activity.activityname}"/>${activity.activityname}</label>
            </div>
        </#list>
    </div>
    <input type="hidden" value="${userToEdit.id}" name="userId">
    <input type="hidden" name="username" value="${userToEdit.username}">
    <input type="hidden" value="${_csrf.token}" name="_csrf">
    <button type="submit" name="newActivityStatus" value="ADD_REQUEST">Save</button>
</form>
</#if>
</@c.page>