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
        <link rel="stylesheet" href="https://opensource.keycdn.com/fontawesome/4.7.0/font-awesome.min.css"
              integrity="sha384-dNpIIXE8U05kAbPhy3G1cz+yZmTzA6CY8Vg/u2L9xRnHjJiAK76m2BIEaSEV+/aU"
              crossorigin="anonymous">
        <style type="text/css">
            .book {
                border: 1px solid;
                padding: 3em 1em 1em 1em;
                position: relative;
            }
            .book__title {
                background-color: rebeccapurple;
                color: #fff;
                left: 0;
                padding: 1% 2%;
                position: absolute;
                text-transform: capitalize;
                top: 0;
                width: 100%;
            }
            .book__author,
            .book__price {
                display: block;
                margin: 0.7em 0;
            }
            .top-bar {
                background-color: #ddd;
                padding: 1.5% 0;
                margin-bottom: 2em;
            }
        </style>
    </head>
    <body>
        <div class="main-wrapper">
            <div class="top-bar">
                <div class="container">
                    <div class="row">
                        <div class="column column-80">
                            <nav class="navigation">
                                <a href="/codex-bookstore" class="navigation-link">
                                    <i class="fa fa-home" aria-hidden="true"></i>
                                    Home
                                </a>
                            </nav>
                        </div>
                        <div class="column">
                            <div class="cart">
                                <a href="#">
                                    <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                    <span>Your Cart</span>
                                </a>
                            </div>
                        </div>
                        <div class="column">
                            <div class="user-info">
                                <i class="fa fa-user-circle" aria-hidden="true"></i>
                                <span>Guest</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="main-content container">
                <div class="row">
                    <h1>Codex bookstore</h1>
                </div>
                <div class="row">
                    <c:forEach var="book" items="${books}">
                        <div class="book">
                            <h3 class="book__title">${book.title}</h3>
                            <span class="book__author"><strong>Author:</strong> ${book.author.name}</span>
                            <span class="book__price"><strong>Price:</strong> $000,00</span>
                            <button>Add to cart!</button>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </body>
</html>
