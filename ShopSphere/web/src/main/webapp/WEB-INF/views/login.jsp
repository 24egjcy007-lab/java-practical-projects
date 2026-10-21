<%@ page contentType="text/html;charset=UTF-8" %>

<%
    request.setAttribute("pageTitle", "Login");
%>

<%@ include file="fragments/header.jsp" %>

<div class="auth-wrap">
    <div class="auth-card">

        <span class="eyebrow">WELCOME BACK</span>

        <h1 class="fw-bold mt-2">Sign in</h1>

        <p class="text-secondary">
            Your next great find is waiting.
        </p>

        <%-- Display login error --%>
        <c:if test="${not empty error}">
            <div class="alert alert-danger" role="alert">
                <c:out value="${error}" />
            </div>
        </c:if>

        <%-- Display registration success message --%>
        <c:if test="${param.registered eq '1'}">
            <div class="alert alert-success" role="alert">
                Account created. You can sign in now.
            </div>
        </c:if>

        <form method="post"
              action="${pageContext.request.contextPath}/login">

            <label for="email" class="form-label mt-3">
                Email
            </label>

            <input
                id="email"
                class="form-control form-control-lg"
                type="email"
                name="email"
                required
                autocomplete="email"
            >

            <label for="password" class="form-label mt-3">
                Password
            </label>

            <input
                id="password"
                class="form-control form-control-lg"
                type="password"
                name="password"
                required
                autocomplete="current-password"
            >

            <button
                type="submit"
                class="btn btn-dark btn-lg w-100 mt-4">
                Sign in
            </button>

        </form>

        <p class="text-center mt-4 mb-0">
            New to ShopSphere?
            <a href="${pageContext.request.contextPath}/register">
                Create an account
            </a>
        </p>

    </div>
</div>

<%@ include file="fragments/footer.jsp" %>
