<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="result" class="br.com.codexbookstore.control.Result" scope="request" />
<html>
    <head>
        <title>Codex Bookstore - Book list</title>
        <!-- Google Fonts -->
        <link rel="stylesheet" href="//fonts.googleapis.com/css?family=Roboto:300,300italic,700,700italic">
        <!-- CSS Reset -->
        <link rel="stylesheet" href="//cdn.rawgit.com/necolas/normalize.css/master/normalize.css">
        <!-- Milligram CSS minified -->
        <link rel="stylesheet" href="//cdn.rawgit.com/milligram/milligram/master/dist/milligram.min.css">
        <base href="codex-bookstore/">
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
                        <h2>Book list</h2>
                        <table>
                            <tr>
                                <th>Code</th>
                                <th>Title</th>
                                <th>Status</th>
                                <th>Actions</th>
                            </tr>
                            <c:forEach var="book" items="${books}">
                                <tr>
                                    <td>
                                        <fmt:formatNumber
                                            pattern="0000" type="number" value="${book.id}" />
                                    </td>
                                    <td>${book.title}</td>
                                    <td>${book.status}</td>
                                    <td></td>
                                </tr>
                            </c:forEach>
                        </table>
                        <button id="newBook">New Book</button>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            (function () {
              var btn = document.querySelector("#newBook");
              btn.onclick = function () {
                  window.location = "http://localhost:8080/codex-bookstore/books/new";
              }
            }());
        </script>
    </body>
</html>
