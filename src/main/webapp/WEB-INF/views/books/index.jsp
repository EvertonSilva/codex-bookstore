<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<t:page>
    <jsp:attribute name="title">Books</jsp:attribute>
    <jsp:body>
        <h1>Codex bookstore</h1>
        <div class="row">
            <div class="column">

            </div>
            <div class="column column-80">
                <h2>Book list</h2>
                <table>
                    <tr>
                        <th>Code</th>
                        <th>Title</th>
                        <th>Author</th>
                        <th>Categories</th>
                        <th>Status</th>
                        <th>Actions</th>
                    </tr>
                    <c:forEach var="book" items="${books}">
                        <tr>
                            <td>
                                <a href="${rootPath}/books/edit?id=${book.id}&operation=edit">
                                    <fmt:formatNumber pattern="0000"
                                                      type="number" value="${book.id}" />
                                </a>
                            </td>
                            <td>${book.title}</td>
                            <td>${book.author.name}</td>
                            <td>
                                <c:forEach var="category" items="${book.categories}">
                                    ${category.name},&nbsp;
                                </c:forEach>
                            </td>
                            <td>${book.status}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${book.enabled}">
                                        <a href="#" title="disable book">
                                            <i class="fa fa-ban" aria-hidden="true"></i>
                                        </a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="#" title="enable book">
                                            <i class="fa fa-check-circle" aria-hidden="true"></i>
                                        </a>
                                    </c:otherwise>
                                </c:choose>
                                    <%--<i class="fa fa-edit" aria-hidden="true"></i>--%>
                                    <%--<i class="fa fa-remove" aria-hidden="true"></i>--%>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <button id="newBook">New Book</button>
            </div>
        </div>
    </jsp:body>
</t:page>
