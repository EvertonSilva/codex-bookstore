<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<html>
    <head>
        <title>Checkout</title>
        <!-- Google Fonts -->
        <link rel="stylesheet" href="//fonts.googleapis.com/css?family=Roboto:300,300italic,700,700italic">
        <!-- CSS Reset -->
        <link rel="stylesheet" href="//cdn.rawgit.com/necolas/normalize.css/master/normalize.css">
        <!-- Milligram CSS minified -->
        <link rel="stylesheet" href="//cdn.rawgit.com/milligram/milligram/master/dist/milligram.min.css">
        <%-- font awesome --%>
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
                                <a href="${rootPath}/cart/items?operation=retrieve">
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
            </div>
        </div>
    </body>
</html>
