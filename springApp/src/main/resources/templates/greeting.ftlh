<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring/>

<@c.page>
<div>Hello, user</div>
<a href="/main"><@spring.message "main.page"/></a>
</@c.page>