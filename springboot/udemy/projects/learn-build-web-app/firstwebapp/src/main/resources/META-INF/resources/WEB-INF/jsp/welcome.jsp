    <%@include file="common/header.jspf"%>
    <%@include file="common/navigation.jspf"%>
    <div class="container">
        <div>
            welcome ${username}
        </div>
        <div>
            username: ${username}
        </div>
        <div>
            password: ${password}
        </div>
        <a href="list-todos">Manage your todos</a>
    </div>
    <%@include file="common/footer.jspf"%>