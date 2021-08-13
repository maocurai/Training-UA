<#import "parts/common2.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring/>
<#include "parts/security.ftlh">

<@c.page>
<h1 class="mt-5"><@spring.message "activity.control"/></h1>
        <#if !isAdmin>
        <a href="/user/${loggedUserId}">Add activity</a>
                <label><@spring.message "all.activities"/></label>
                <table class="mt-3">
                    <#list usersActivities as userActivity>
                    <form action="/ur" method="post">
                       <tr>
                           <td>${userActivity.activity.activityname}</td>
                           <td><button name="newActivityStatus" value="DELETE_REQUEST">Delete</button></td>
                       </tr>
                       <input type="hidden" name="activityId" value="${userActivity.activity.id}" />
                       <input type="hidden" name="userId" value="${loggedUserId}" />
                       <input type="hidden" name="_csrf" value="${_csrf.token}" />
                    </form>
                    </#list>
                <table class="mt-3">
        </#if>

<#if isAdmin>
<form action="/adminActivity" method="post">
<label><@spring.message "activity.name"/><input type="text" name="activityname"/> </label>
    <div class="col-md-4 col-lg-4 order-md-last dropdown">
        <#list categories as category>
            <div>
                <label><input type="checkbox" name="${category.categoryname}"/>${category.categoryname}</label>
            </div>
        </#list>
    </div>
    <div class="col-md-4 col-lg-4 order-md-last">
        <input type="submit" class="btn btn-outline-success" value="Add"/>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
</form>
    <h3><@spring.message "all.activities"/></h3>
    <table class="mt-3">
        <thead>
            <th><@spring.message "activity.name"/></th>
            <th><@spring.message "category.name"/></th>
            </tr>
        </thead>
        <tbody>
            <#list activities as activity>
                <tr>
                    <td>${activity.activityname}</td>
                    <td>
                        <#list activity.categoriesOfactivities as category>
                            ${category.categoryname}
                        </#list>
                    </td>
                </tr>
            </#list>
        </tbody>
    </table>
</#if>
</@c.page>