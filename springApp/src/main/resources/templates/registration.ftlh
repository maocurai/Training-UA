<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring/>

<@c.page>
    <a href="?lang=en" class="dropdown-item" style="width: 10%;">EN</a>
    <a href="?lang=ru" class="dropdown-item" style="width: 10%;">UA</a>
    <body class="text-center">
    <h1 class="h3 mb-3 font-weight-normal mt-5"><@spring.message "register.please"/></h1>
    <@l.login "/registration" />
    <button class="btn btn-lg btn-primary btn-block mt-3" type="submit">
        <@spring.message "ok"/></button>
    </form>
    </body>
</@c.page>