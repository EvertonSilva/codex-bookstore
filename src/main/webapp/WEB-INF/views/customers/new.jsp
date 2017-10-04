<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="result" class="br.com.codexbookstore.control.Result" scope="request" />
<html>
<head>
    <title>Codex Bookstore - Home</title>
    <!-- Google Fonts -->
    <link rel="stylesheet" href="//fonts.googleapis.com/css?family=Roboto:300,300italic,700,700italic">
    <!-- CSS Reset -->
    <link rel="stylesheet" href="//cdn.rawgit.com/necolas/normalize.css/master/normalize.css">
    <!-- Milligram CSS minified -->
    <link rel="stylesheet" href="//cdn.rawgit.com/milligram/milligram/master/dist/milligram.min.css">

    <style>
        fieldset {
            border: 1px solid #ccc;
            padding: 1% 2%;
        }
        .phone__area-code {
            width: 10% !important;
        }
        .phone__number {
            width: 89% !important;
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
                <h2>New Customer</h2>
                <form action="/codex-bookstore/customers/create" method="POST">
                    <fieldset>
                        <legend>Personal info</legend>
                        <div>
                            <label for="name">Name:</label>
                            <input id="name" name="name" type="text">
                        </div>
                        <div>
                            <label for="registry">Registry:</label>
                            <input id="registry" name="registry" type="text">
                        </div>
                        <div>
                            <label for="dob">Date of Birthday:</label>
                            <input id="dob" name="dob" type="date">
                        </div>
                        <div>
                            <label for="female">Gender</label>
                            <input id="female" name="gender" type="radio" value="FEMALE">F
                            <input id="male" name="gender" type="radio" value="MALE">M
                        </div>
                    </fieldset>
                    <fieldset>
                        <legend>Contact info</legend>
                        <div class="phone">
                            <label for="phone-number">Phone:</label>
                            <input id="area-code" name="area-code" class="phone__area-code" type="text" placeholder="11">
                            <input id="phone-number" name="phone-number" class="phone__number" type="tel" placeholder="5555-01234">
                        </div>
                        <div>
                            <label for="email">Email:</label>
                            <input id="email" name="email" type="email">
                        </div>
                    </fieldset>
                    <fieldset>
                        <legend>Address info</legend>
                        <div>
                            <h3>Delivery Address</h3>
                            <label for="postal-code">Postal code:</label>
                            <input id="postal-code" name="postal-code" type="text">

                            <label for="home-type">Housing type:</label>
                            <input id="home-type" name="home-type" type="text" placeholder="house, apartment...">
                            
                            <label for="public-place">Address:</label>
                            <select name="address-type" id="address-type">
                                <option value="">select...</option>
                                <option value="street">Street</option>
                                <option value="avenue">Avenue</option>
                            </select>
                            <input id="public-place" name="public-place" type="text" placeholder="5th Ave">

                            <label for="number">Number:</label>
                            <input id="number" name="number" type="number">

                            <label for="district">District:</label>
                            <input id="district" name="district" type="text">

                            <label for="country">Country:</label>
                            <select name="country" id="country">
                                <option value="">select...</option>
                                <option value="1">Brazil</option>
                            </select>
                            <label for="state">State:</label>
                            <select name="state" id="state">
                                <option value="">select...</option>
                                <option value="1">São Paulo</option>
                            </select>
                            <label for="city">City:</label>
                            <select name="city" id="city">
                                <option value="">select...</option>
                                <option value="1">Suzano</option>
                            </select>

                            <label for="note">Note:</label>
                            <textarea name="note" id="note" cols="30" rows="10">Insert here any observation...</textarea>
                        </div>
                    </fieldset>
                    <fieldset>
                        <legend>Payment info</legend>
                        <div>
                            <label for="card-number">Card Number:</label>
                            <input id="card-number" name="card-number" type="text">
                        </div>
                        <div>
                            <label for="card-name">Name printed on card:</label>
                            <input id="card-name" name="card-name" type="text">
                        </div>
                        <div>
                            <label for="security-code">Security Code:</label>
                            <input id="security-code" name="security-code" type="text">
                        </div>
                        <div>
                            <label for="expire-month">Expire date:</label>
                            <span>Month:</span>
                            <select name="expire-month" id="expire-month">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                                <option value="11">11</option>
                                <option value="12">12</option>
                            </select>

                            <span>Year:</span>
                            <select name="expire-year" id="expire-year">
                                <option value="2017">2017</option>
                                <option value="2018">2018</option>
                                <option value="2019">2019</option>
                                <option value="2021">2021</option>
                            </select>
                        </div>
                    </fieldset>
                    <fieldset>
                        <legend>Authentication</legend>
                        <div>
                            <label for="password">Password:</label>
                            <input id="password" name="password" type="password">

                            <label for="pwd-confirm">Confirm password:</label>
                            <input id="pwd-confirm" name="pwd-confirm" type="password">
                        </div>
                    </fieldset>
                    <input id="operation" name="operation" type="hidden" value="create">
                    <button type="submit">Add new customer</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
