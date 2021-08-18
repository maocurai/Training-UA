<#import "parts/common2.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring/>
<#include "parts/security.ftlh">

<@c.page>
<#if isAdmin>
User editor
    <form action="/user" method="post">
        <input type="text" name="username" placeholder="${userToEdit.username}" value="${userToEdit.username}">
        <#list roles as role>
            <div>
                <p><input type="radio" name="${role}">${role}</p>
            </div>
        </#list>
        <h4>User's activities</h4>
        <table>
            <tr>
               <#list usersActivities as userActivity>
                  <p>${userActivity.activity.activityname}</p>
              </#list>
            </tr>
        </table>

            <h4>Add activity</h4>
            <div class="col-md-4 col-lg-4 order-md-last dropdown">
                <#list NotUsersActivities as notUserActivity>
                    <div>
                        <label><input type="checkbox" name="${notUserActivity.activityname}"/>${notUserActivity.activityname}</label>
                    </div>
                </#list>
            </div>
            <input type="hidden" value="${userToEdit.id}" name="userId">
            <input type="hidden" value="${loggedUserId}" name="loggedUserId">
            <input type="hidden" value="${_csrf.token}" name="_csrf">
            <button type="submit" name="newActivityStatus" value="CONFIRMED">Save</button>
    </form>

<#else>
<form action="/user" method="post">
    <h4>Add activity</h4>
    <div class="col-md-4 col-lg-4 order-md-last dropdown">
        <#list NotUsersActivities as notUsersActivity>
            <div>
            <label><input type="checkbox" name="${notUsersActivity.activityname}"/>${notUsersActivity.activityname}</label>
            </div>
        </#list>
    </div>
    <input type="hidden" value="${userToEdit.id}" name="userId">
    <input type="hidden" value="${loggedUserId}" name="loggedUserId">
    <input type="hidden" name="username" value="${userToEdit.username}">
    <input type="hidden" value="${_csrf.token}" name="_csrf">
    <button type="submit" name="newActivityStatus" value="ADD_REQUEST">Save</button>
</form>
</#if>
</@c.page>