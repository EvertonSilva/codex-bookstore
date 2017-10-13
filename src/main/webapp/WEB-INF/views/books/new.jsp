<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="result" class="br.com.codexbookstore.control.Result" scope="request" />
<html>
<head>
    <title>Codex Bookstore - New Book</title>
    <!-- Google Fonts -->
    <link rel="stylesheet" href="//fonts.googleapis.com/css?family=Roboto:300,300italic,700,700italic">
    <!-- CSS Reset -->
    <link rel="stylesheet" href="//cdn.rawgit.com/necolas/normalize.css/master/normalize.css">
    <!-- Milligram CSS minified -->
    <link rel="stylesheet" href="//cdn.rawgit.com/milligram/milligram/master/dist/milligram.min.css">
    <base href="codex-bookstore/">
    <style>
        #book-category {
            min-height: 100px;
        }
        fieldset {
            border: 1px solid #ccc;
            padding: 1% 2%;
        }
    </style>
</head>
<body>
<div class="main-wrapper">
    <div class="container">
        <nav class="navigation">
            <a href="/codex-bookstore" class="navigation-link">Home</a>
        </nav>
    </div>
    <div class="main-content container">
        <h1>Codex bookstore</h1>
        <div class="row">
            <div class="column">

            </div>
            <div class="column column-80">
                <h2>New Book</h2>
                <form action="/codex-bookstore/books/create" method="POST">
                    <input type="hidden" name="operation" value="create">
                    <fieldset>
                        <legend>Basic</legend>
                        <div>
                            <label for="book-title">Book title</label>
                            <input name="book-title" id="book-title" type="text">
                        </div>
                        <div>
                            <label for="book-author">Author</label>
                            <select name="book-author" id="book-author">
                                <c:forEach var="author" items="${authors}">
                                    <option value="${author.id}">${author.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div>
                            <label for="book-category">Category</label>
                            <select name="book-category" id="book-category" multiple>
                               <c:forEach var="category" items="${categories}">
                                   <option value="${category.id}">${category.name}</option>
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
                            <input name="book-edition" id="book-edition" type="text">
                        </div>
                        <div>
                            <label for="book-year">Publish Year</label>
                            <input name="book-year" id="book-year" type="number" min="1889" max="2017">
                        </div>
                        <div>
                            <label for="book-pages-number">Pages number</label>
                            <input name="book-pages-number" id="book-pages-number" type="number">
                        </div>
                        <div>
                            <label for="book-synopsis">Synopsis</label>
                            <textarea name="book-synopsis" id="book-synopsis" cols="30" rows="10"></textarea>
                        </div>
                    </fieldset>
                    <fieldset>
                        <legend>Dimensions</legend>
                        <div>
                            <label for="book-height">Height</label>
                            <input name="book-height" id="book-height" type="number">
                        </div>
                        <div>
                            <label for="book-width">Width</label>
                            <input name="book-width" id="book-width" type="number">
                        </div>
                        <div>
                            <label for="book-weight">Weigth</label>
                            <input name="book-weight" id="book-weight" type="number">
                        </div>
                        <div>
                            <label for="book-depth">Depth</label>
                            <input name="book-depth" id="book-depth" type="number">
                        </div>
                    </fieldset>
                    <fieldset>
                        <legend>ID</legend>
                        <div>
                            <label for="book-isbn">ISBN</label>
                            <input name="book-isbn" id="book-isbn" type="text">
                        </div>
                        <div>
                            <label for="book-barcode">Barcode</label>
                            <input name="book-barcode" id="book-barcode" type="text">
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
                            <input name="book-sales-min-number" id="book-sales-min-number" type="number" min="1">
                        </div>
                        <div>
                            <label for="book-sales-period">Period</label>
                            <input name="book-sales-value" id="book-sales-period" type="number" min="1">
                            <select name="book-sales-period-unit" id="book-sales-period-unit">
                                <option value="min">Minutes</option>
                                <option value="hour">Hours</option>
                                <option value="day" selected>Days</option>
                                <option value="month">Months</option>
                                <option value="year">Years</option>
                            </select>
                        </div>
                    </fieldset>
                    <button type="submit">Create book!</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
