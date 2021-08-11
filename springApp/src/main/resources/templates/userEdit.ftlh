<#import "parts/common2.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring/>
<#include "parts/security.ftlh">

<@c.page>
User editor

<#if isAdmin>
    <form action="/user" method="post">
        <input type="text" name="username" value="${user.username}">
        <#list roles as role>
        <div>
            <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
        </div>
        </#list>
        <h4>User's activities</h4>
        <table>
            <tbody>
               <#list user.userActivitiesSet as activity>
                  ${activity.activityname}
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
            <input type="hidden" value="${user.id}" name="userId">
            <input type="hidden" value="${_csrf.token}" name="_csrf">
            <button type="submit">Save</button>
    </form>
</#if>

<form action="/user" method="post">
    <h4>Add activity</h4>
    <div class="col-md-4 col-lg-4 order-md-last dropdown">
        <#list activities as activity>
            <div>
                <label><input type="checkbox" name="${activity.activityname}"/>${activity.activityname}</label>
            </div>
        </#list>
    </div>
    <input type="hidden" value="${user.id}" name="userId">
    <input type="hidden" name="username" value="${user.username}">
    <input type="hidden" value="${_csrf.token}" name="_csrf">
    <button type="submit">Save</button>
</form>
</@c.page>