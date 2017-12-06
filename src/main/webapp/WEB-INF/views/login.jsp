<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<t:page>
    <jsp:attribute name="title">Login</jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="column column-66">
                <form action="login?operation=create">
                    <label for="email">Email</label>
                    <input type="text" name="email" id="email">

                    <label for="password">Password</label>
                    <input type="password" name="password" id="password">

                    <input type="submit" value="login">
                </form>
            </div>
        </div>
    </jsp:body>
</t:page>

