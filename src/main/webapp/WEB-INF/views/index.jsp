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
                        <h3>Actions</h3>
                        <div>
                            <h4>Books</h4>
                            <ul>
                                <li><a href="books/list?operation=retrieve">Find a book</a></li>
                                <li><a href="books/new">Insert a new book</a></li>
                            </ul>
                        </div>
                        <div>
                            <h4>Customers</h4>
                            <ul>
                                <li><a href="customers/new?operation=new">New</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="column column-80">
                        <h2>Dashboard</h2>
                        <p>coming soon...</p>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
