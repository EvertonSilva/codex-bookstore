<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<c:choose>
    <c:when test="${sessionScope.containsKey(\"shopCart\")}">
        <c:set var="operation" value="update"/>
    </c:when>
    <c:otherwise>
        <c:set var="operation" value="create"/>
    </c:otherwise>
</c:choose>

<t:page>
    <jsp:attribute name="title">Home</jsp:attribute>
    <jsp:body>
        <div class="row">
            <h1>Codex bookstore</h1>
        </div>
        <div class="row">
            <c:forEach var="book" items="${books}">
                <div class="book" id="book-${book.id}">
                    <h3 class="book__title">${book.title}</h3>
                    <span class="book__author"><strong>Author:</strong> ${book.author.name}</span>
                    <span class="book__price">
                                <strong>Price:</strong>
                                <span>
                                    <fmt:formatNumber type="currency" value="${book.stock.salePrice}"/>
                                </span>
                            </span>
                    <form id="orderItem" action="${rootPath}/cart/addItem" method="post">
                        <label for="book_id">Quantity:</label>
                        <input type="number" id="book_quantity" name="book_quantity" value="1" min="1">
                        <input type="hidden" id="book_id" name="book_id" value="${book.id}">
                        <input type="hidden" value="${operation}" name="operation">
                        <button id="addToCart">Add to cart!</button>
                    </form>
                </div>
            </c:forEach>
        </div>
    </jsp:body>
</t:page>
