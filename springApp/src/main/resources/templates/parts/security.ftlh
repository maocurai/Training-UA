<#assign
    known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = user.getUsername()
        id = user.getId()
        isAdmin = user.isAdmin()
        role = user.getRole()
    >
<#else>
    <#assign
        name = "unknown"
        isAdmin = false
    >
</#if>