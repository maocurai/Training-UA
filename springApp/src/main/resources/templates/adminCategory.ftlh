<#import "parts/common2.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring/>

<@c.page>
<h1 class="mt-5"><@spring.message "category.control"/></h1>
<form action="/adminCategory" method="post">
<div class="row g-5 mt-3">
    <div class="col-md-6 col-lg-6 order-md-last">
        <label><@spring.message "category.name"/><input type="text" name="categoryname"/> </label>
    </div>
    <div class="col-md-6 col-lg-6 order-md-last">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="submit" class="btn btn-outline-success" value="Add"/>
    </div>
</form>
</div>
<table class="mt-3">
    <thead>
        <tr>
        <th><h3><@spring.message "category.list"/></h3></th>
        </tr>
    </thead>
    <tbody>
        <#list categories as category>
            <tr>
                <td>${category.categoryname}</td>
            </tr>
        </#list>
    </tbody>
</table>

</@c.page>