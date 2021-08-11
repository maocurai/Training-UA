<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring>

<@c.page>
<p>Welcome to time accounting system</p>
<p><@spring.message code='login.page'/></p>
<@l.login "/login" />
<a href="/registration">Add new user</a>
</@c.page>