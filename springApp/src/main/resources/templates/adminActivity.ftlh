<#import "parts/common2.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring/>

<@c.page>
<h1 class="mt-5"><@spring.message "activity.control"/></h1>
<div class="row g-5 mt-3">
<form action="/adminActivity" method="post">
    <div class="col-md-4 col-lg-4 order-md-last">
        <label><@spring.message "activity.name"/><input type="text" name="activityname"/> </label>
    </div>
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
</div>
<table class="mt-3">
    <thead>
        <tr>
        <th><h3><@spring.message "all.activities"/></h3></th>
        </tr>
    </thead>
    <tbody>
        <#list activities as activity>
            <tr>
                <td>${activity.activityname}</td>
            </tr>
        </#list>
    </tbody>
</table>

</@c.page>