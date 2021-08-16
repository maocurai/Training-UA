<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring>

<@c.page>
<@l.login "/login" />
<a href="/registration"><@spring.message "user.registration"/></a>
</@c.page>