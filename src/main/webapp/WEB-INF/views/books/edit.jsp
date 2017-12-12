<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<t:page>
    <jsp:attribute name="title">Edit book</jsp:attribute>

    <jsp:body>
        <h1>Codex bookstore</h1>
        <div class="row">
            <div class="column">

            </div>
            <div class="column column-80">
                <h2>New Book</h2>
                <form action="${rootPath}/books/update" method="POST">
                    <input type="hidden" name="operation" value="update">
                    <input type="hidden" name="book_id" value="${book.id}">
                    <fieldset>
                        <legend>Basic</legend>
                        <div>
                            <label for="book-title">Book title</label>
                            <input name="book-title" id="book-title" type="text" value="${book.title}">
                        </div>
                        <div>
                            <label for="book-author">Author</label>
                            <select name="book-author" id="book-author">
                                <c:forEach var="author" items="${authors}">
                                    <c:if test="${author.name == book.author.name}">
                                        <c:set scope="page" var="selectBookAuthor" value="selected"/>
                                    </c:if>
                                    <option value="${author.id}" ${selectBookAuthor}>${author.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div>
                            <label for="book-category">Category</label>
                            <select name="book-category" id="book-category" multiple>
                                <c:forEach var="category" items="${categories}">
                                    <c:choose>
                                        <c:when test="${book.categories.contains(category)}">
                                            <option value="${category.id}" selected>${category.name}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${category.id}">${category.name}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>
                        <div>
                            <label for="book-publisher">Publisher</label>
                            <select name="book-publisher" id="book-publisher">
                                <option value="1" selected>Editora 34</option>
                                <option value="2">Novatec</option>
                                <option value="3">Casa do código</option>
                            </select>
                        </div>
                        <div>
                            <label for="book-edition">Edition</label>
                            <input name="book-edition" id="book-edition" type="text" value="${book.edition}">
                        </div>
                        <div>
                            <label for="book-year">Publish Year</label>
                            <input name="book-year" id="book-year" type="number" min="1889" max="2017" value="${book.publishYear}">
                        </div>
                        <div>
                            <label for="book-pages-number">Pages number</label>
                            <input name="book-pages-number" id="book-pages-number" type="number" value="${book.numberOfPages}">
                        </div>
                        <div>
                            <label for="book-synopsis">Synopsis</label>
                            <textarea name="book-synopsis" id="book-synopsis" cols="30" rows="10">${book.synopsis}</textarea>
                        </div>
                    </fieldset>
                    <fieldset>
                        <legend>Dimensions</legend>
                        <div>
                            <label for="book-height">Height</label>
                            <input name="book-height" id="book-height" type="number" value="${book.dimensions.height}">
                        </div>
                        <div>
                            <label for="book-width">Width</label>
                            <input name="book-width" id="book-width" type="number" value="${book.dimensions.width}">
                        </div>
                        <div>
                            <label for="book-weight">Weight</label>
                            <input name="book-weight" id="book-weight" type="number" value="${book.dimensions.weight}">
                        </div>
                        <div>
                            <label for="book-depth">Depth</label>
                            <input name="book-depth" id="book-depth" type="number" value="${book.dimensions.depth}">
                        </div>
                    </fieldset>
                    <fieldset>
                        <legend>ID</legend>
                        <div>
                            <label for="book-isbn">ISBN</label>
                            <input name="book-isbn" id="book-isbn" type="text" value="${book.isbn}">
                        </div>
                        <div>
                            <label for="book-barcode">Barcode</label>
                            <input name="book-barcode" id="book-barcode" type="text" value="${book.barcode}">
                        </div>
                    </fieldset>
                    <fieldset>
                        <legend>Price Group</legend>
                        <div>
                            <label for="book-price-group">Group</label>
                            <select name="book-price-group" id="book-price-group">
                                <option value="1" selected>5%</option>
                                <option value="2">7.5%</option>
                                <option value="3">10%</option>
                            </select>
                        </div>
                    </fieldset>
                    <fieldset>
                        <legend>Sales Parameter</legend>
                        <div>
                            <label for="book-sales-min-number">Sales minimum number</label>
                            <input name="book-sales-min-number" id="book-sales-min-number" type="number" min="1" value="${book.salesParameters.minSaleLimit}">
                        </div>
                        <div>
                            <label for="book-sales-period">Period</label>
                            <input name="book-sales-value" id="book-sales-period" type="number" min="1" value="${book.salesParameters.periodicity}">
                            <select name="book-sales-period-unit" id="book-sales-period-unit" value="${book.salesParameters.periodicityUnit}">
                                <option value="min">Minutes</option>
                                <option value="hour">Hours</option>
                                <option value="day" selected>Days</option>
                                <option value="month">Months</option>
                                <option value="year">Years</option>
                            </select>
                        </div>
                        <input type="hidden" name="salesParameters_id" value="${book.salesParameters.id}" />
                    </fieldset>
                    <button type="submit">Update book!</button>
                </form>
            </div>
        </div>
    </jsp:body>
</t:page>
