<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<t:page>
    <jsp:attribute name="title">Order checkout</jsp:attribute>
    <jsp:body>
        <div class="row">
            <h1>Checkout Page</h1>
        </div>
        <div class="row">
            <div class="column"></div>
            <div class="column column-80">
                <h2>Purchase details</h2>
                <section>
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad eligendi enim expedita labore
                        laboriosam minus neque odio vitae voluptatem voluptatibus.1
                    </p>
                </section>
            </div>
        </div>
    </jsp:body>
</t:page>
