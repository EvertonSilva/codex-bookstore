<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                                <th>Código</th>
                                <th>Titulo</th>
                                <th>Adicionado em</th>
                            </tr>
                            <tr></tr>
                            <tr>
                                <th>Código</th>
                                <th>Titulo</th>
                                <th>Adicionado em</th>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
