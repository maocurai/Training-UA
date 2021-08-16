<#import "parts/common2.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring/>
<#include "parts/security.ftlh">

<@c.page>
<h1 class="h3 mb-3 font-weight-normal style="text-align: center; margin-top: 30%;}">
<@spring.message "user.greeting"/>${name}</h1>
</@c.page>