<#import "parts/common2.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring>
<#include "parts/security.ftlh">
<#import "parts/pager.ftlh" as p>

<@c.page>
<h1 class="mt-5"><@spring.message "activity.control"/></h1>
        <#if !isAdmin>
            <h3><@spring.message "all.activities"/></h3>
            <table class="table table-striped mt-3">
                <#list usersActivities as userActivity>
                    <tr>
                        <td>${userActivity.activity.activityname}</td>
                        <form action="/adminActivity/${loggedUserId}/time" method="post">
                            <td><input type="datetime-local" name="activity-start"></td>
                            <td><input type="datetime-local" name="activity-end"></td>
                            <td><button>Set time</button></td>
                            <input type="hidden" name="activityId" value="${userActivity.activity.id}" />
                            <input type="hidden" name="userId" value="${loggedUserId}" />
                            <input type="hidden" name="_csrf" value="${_csrf.token}" />
                        </form>
                   <form action="/ur" method="post">
                           <td><button name="newActivityStatus" value="DELETE_REQUEST">Delete</button></td>
                    </tr>
                    <input type="hidden" name="activityId" value="${userActivity.activity.id}" />
                    <input type="hidden" name="userId" value="${loggedUserId}" />
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                    </form>
                </#list>
            </table>
            <a href="/user/${loggedUserId}" class="btn btn-outline-success" ><@spring.message "add"/></a>
        </#if>

<#if isAdmin>
    <h3><@spring.message "all.activities"/></h3>
    <form action="/adminActivity" id="categoryForm" method="get">
    <label><@spring.message "activity.name"/><input type="text" name="activityname"/> </label>

            <select name="categoryname">
                <#list categories as category>
                <option value="${category.categoryname}">${category.categoryname}</option>
                </#list>
            </select>
            <button class="btn btn-outline-success"><@spring.message "add"/></button>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
    </form>

<form action="/adminActivity/filter" id="filterForm" method="get">
    <select name="filter">
        <#list categories as category>
            <option value="${category.id}">${category.categoryname}</option>
        </#list>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
    </select>
    <button form="filterForm">Show</button>
</form>

<form action="/adminActivity/sort" id="sortingForm" method="get">
    <table class="table table-striped mt-3">
        <thead>
            <th scope="col"><button form="sortingForm" name="orderField" value="activityname"><@spring.message "activity.name"/></button></th>
            <th scope="col">
                <button form="sortingForm" name="orderField" value="category.categoryname"><@spring.message "category.name"/></button>
            </th>
            <th scope="col"><button form="sortingForm" name="orderField" value="usersCounter">Users count</button></th>
            <input type="hidden" name="currentOrderDirection" value="${currentOrderDirection}"/>
        </thead>
        <tbody>
            <#list activities as activity>
                <tr>
                    <td>${activity.activityname}</td>
                    <td>${activity.category.categoryname}</td>
                    <td>${activity.usersCounter}</td>
                </tr>
            </#list>
        </tbody>
    </table>
    </form>
</#if>
</@c.page>