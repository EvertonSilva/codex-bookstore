<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Codex Bookstore - Home</title>
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
            <a href="#" class="navigation-link">Menu item 1</a>
            <a href="#" class="navigation-link">Menu item 2</a>
            <a href="#" class="navigation-link">Menu item 3</a>
        </nav>
    </div>
    <div class="main-content container">
        <h1>Codex bookstore</h1>
        <div class="row">
            <div class="column">

            </div>
            <div class="column column-80">
                <h2>New Book</h2>
                <form action="#" method="POST">
                    <fieldset>
                        <legend>Basic</legend>
                        <div>
                            <label for="book-title">Book title</label>
                            <input name="book-title" id="book-title" type="text">
                        </div>
                        <div>
                            <label for="book-author">Author</label>
                            <select name="book-author" id="book-author">
                                <option value="">select...</option>
                                <option value="1">DOSTOIEVSKI, Fiodor</option>
                                <option value="2">GOGÓL, Nikolai</option>
                                <option value="3">TOLSTÓI, Liev</option>
                            </select>
                        </div>
                        <div>
                            <label for="book-category">Category</label>
                            <select name="book-category" id="book-category" multiple>
                                <option value="1">Romance</option>
                                <option value="2">Mistery & Suspense</option>
                                <option value="3">Terror</option>
                                <option value="4">Sci-FI & Fantasy</option>
                            </select>
                        </div>
                        <div>
                            <label for="book-publisher">Publisher</label>
                            <select name="book-publisher" id="book-publisher">
                                <option value="">select...</option>
                                <option value="1">Editora 34</option>
                                <option value="2">Novatec</option>
                                <option value="3">Cada do código</option>
                            </select>
                        </div>
                        <div>
                            <label for="book-edition">Edition</label>
                            <input name="book-edtion" id="book-edition" type="text">
                        </div>
                        <div>
                            <label for="book-year">Publication Year</label>
                            <input name="book-year" id="book-year" type="number" min="1889" max="2017">
                        </div>
                        <div>
                            <label for="book-pages-number">Pages number</label>
                            <input name="book-pages-number" id="book-pages-number" type="number">
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
                            <input name="book-width" id="book-width" type="text">
                        </div>
                        <div>
                            <label for="book-weight">Weigth</label>
                            <input name="book-weight" id="book-weight" type="number">
                        </div>
                        <div>
                            <label for="book-depth">Depth</label>
                            <input name="book-depth" id="book-depth" type="text">
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
                                <option value="">select...</option>
                                <option value="1">P1</option>
                                <option value="2">P2</option>
                                <option value="3">P3</option>
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
                            <label for="book-sales-value">Period</label>
                            <input name="book-sales-value" id="book-sales-value" type="number" min="1">
                            <select name="book-sales-period-unit" id="book-sales-period-unit">
                                <option value="">Minutes</option>
                                <option value="">Hours</option>
                                <option value="">Days</option>
                                <option value="">Months</option>
                                <option value="">Years</option>
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
