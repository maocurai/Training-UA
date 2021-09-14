<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring>

<@c.page>
    <a href="?lang=en" class="dropdown-item" style="width: 10%;">EN</a>
    <a href="?lang=ru" class="dropdown-item" style="width: 10%;">UA</a>
    <body class="text-center">
    <h1 class="h3 mb-3 font-weight-normal mt-5"><@spring.message "authorise"/></h1>
    <@l.login "/login" />
    <button class="btn btn-lg btn-primary btn-block mt-3" type="submit">
        <@spring.message "sign.in"/></button>
    </form>
    <a href="/registration"><@spring.message "user.registration"/></a>
    </body>
</@c.page>