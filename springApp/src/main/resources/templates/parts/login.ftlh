<#macro logout>
 <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="submit" value="Sign Out"/>
    </form>
</#macro>

<#macro login path>
  <body class="text-center">
      <form action="${path}" method="post" class="form-signin">
        <h1 class="h3 mb-3 font-weight-normal mt-5"><@spring.message "authorise"/></h1>
        <div style="display: flex; flex-direction: column; align-items: center;">
        <label for="inputEmail" class="sr-only"><@spring.message "login"/></label>
            <input type="text" name="username" class="form-control mt-1" placeholder="Email address" style="width: 30%;">
            <label for="inputPassword" class="sr-only mt-2"><@spring.message "password"/></label>
            <input type="password" name="password" class="form-control mt-1" placeholder="Password" style="width: 30%;">
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="btn btn-lg btn-primary btn-block mt-3" type="submit">
        <@spring.message "sign.in"/></button>
        <a href="?lang=en" class="dropdown-item">EN</a>
        <a href="?lang=ru" class="dropdown-item">UA</a>
      </form>
  </body>
</#macro>