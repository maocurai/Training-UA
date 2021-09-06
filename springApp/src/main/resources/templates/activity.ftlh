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
                <thead>
                    <tr>
                        <th><@spring.message "activity.name"/></th>
                        <th>Activity start</th>
                        <th>Activity end</th>
                    </tr>
                </thead>
                <tbody>
                    <#list usersActivities as userActivity>
                    <tr>
                        <td>${userActivity.activity.activityname}</td>
                        <form action="/activity/${loggedUserId}/time" method="post">
                        <#if userActivity.isConfirmed()>
                            <td><input type="datetime-local" name="activity-start"></td>
                            <td><input type="datetime-local" name="activity-end"></td>
                            <td><button>Set time</button></td>
                        <#elseif userActivity.isDenied()>
                        <td colspan="2"><@spring.message "admin.denied"/></td>
                        <#else >
                            <td colspan="2"><@spring.message "admin.processing"/></td>
                        </#if>
                            <input type="hidden" name="activityId" value="${userActivity.activity.id}" />
                            <input type="hidden" name="userId" value="${loggedUserId}" />
                            <input type="hidden" name="_csrf" value="${_csrf.token}" />
                        </form>
                   <form action="/userRequests/addActivity" method="post">
                           <td><button name="newActivityStatus" value="DELETE_REQUEST">Delete</button></td>
                    </tr>
                    <input type="hidden" name="activityId" value="${userActivity.activity.id}" />
                    <input type="hidden" name="userId" value="${loggedUserId}" />
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                    </form>
                </#list>
                </tbody>
            </table>
            <a href="/user/${loggedUserId}" class="btn btn-outline-success" ><@spring.message "add"/></a>
        </#if>

<#if isAdmin>
    <h3><@spring.message "all.activities"/></h3>
    <form action="/activity" id="categoryForm" method="post">
    <label><@spring.message "activity.name"/><input type="text" name="activityname"/> </label>
            <select name="categoryname">
                <#list categories as category>
                <option value="${category.categoryname}">${category.categoryname}</option>
                </#list>
            </select>
            <button class="btn btn-outline-success"><@spring.message "add"/></button>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
    </form>

    <form action="/activity/filter" id="filterForm" method="get">
    <label><@spring.message "filter.by"/></label>
                        <select name="filter">
                            <#list categories as category>
                                <option value="${category.categoryname}">${category.categoryname}</option>
                            </#list>
                            <option value="NULL"><@spring.message "without.category"/></option>
                        </select>
                        <button class="btn btn-outline-danger" form="filterForm"><@spring.message "on"/></button>
                        <a href="/activity" class="btn btn-outline-danger" ><@spring.message "off"/></a>
                    </form>
<form action="/activity/sort" id="sortingForm" method="get">
    <table class="table table-striped mt-3">
        <thead>
            <th scope="col"><button form="sortingForm" name="orderField" value="activityName"><@spring.message "activity.name"/></button></th>
            <th scope="col">
                <button form="sortingForm" name="orderField" value="categoryName"><@spring.message "category.name"/></button>
            </th>
            <th scope="col"><button form="sortingForm" name="orderField" value="countUsers"><@spring.message "users.count"/></button></th>
            <input type="hidden" name="currentOrderDirection" value="${currentOrderDirection}"/>
        </thead>
        <tbody>
            <#list activities as activity>
                <tr>
                    <td>${activity.activityName}</td>
                    <td>
                        <#if (activity.categoryName??)>
                            ${activity.categoryName}
                        <#else>
                            <@spring.message "without.category"/>
                        </#if>
                    </td>
                    <td>${activity.countUsers}</td>
                </tr>
            </#list>
        </tbody>
    </table>
    </form>
</#if>
</@c.page>