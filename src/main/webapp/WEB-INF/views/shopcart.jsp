<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<html>
    <head>
        <title>Codex Bookstore - Shopping Cart</title>
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
                                <a href="${rootPath}" class="navigation-link">
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
                    <h1>Shopping Cart</h1>
                </div>
                <div class="row">
                    <div class="column">
                        <h3>Filters</h3>
                    </div>
                    <div class="column column-80">
                        <table class="shopcart">
                            <tr>
                                <th>Book title</th>
                                <th>Quantity</th>
                                <th>Subtotal</th>
                            </tr>
                            <c:forEach var="cartItem" items="${cartItems}">
                                <tr class="shopcart__item">
                                    <td>${cartItem.book.title}</td>
                                    <td>${cartItem.quantity}</td>
                                    <td>R$ 000,00</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
