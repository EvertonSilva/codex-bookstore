<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<t:page>
    <jsp:attribute name="title">Order checkout</jsp:attribute>
    <jsp:body>
        <div class="row">
            <h1>Checkout Page</h1>
        </div>
        <div class="row">
            <div class="column column-33">
                <section>
                    <h3>Ship Address</h3>
                    <form action="#">
                        <select name="ship-address" id="ship-address">
                            <option value="1">Home</option>
                            <option value="2" selected="selected">Work</option>
                            <option value="3">Parents house</option>
                        </select>
                    </form>
                    <div class="address">
                        <h4>Current: work</h4>
                        <p>2400 Bayshore Pkwy,</p>
                        <p>Mountain View</p>
                        <p>CA 94043, EUA</p>
                    </div>
                    <button class="button-outline">New Address</button>
                </section>
            </div>
            <div class="column">
                <section>
                    <h3>Payment options</h3>
                    <form action="#">
                        <fieldset>
                            <legend>Credit Cards</legend>
                            <label for="credit-card">Your cards</label>
                            <select name="credit-card" id="credit-card">
                                <option value="1">Card 1</option>
                                <option value="2">Card 2</option>
                                <option value="3">Card 3</option>
                            </select>
                        </fieldset>

                        <fieldset>
                            <legend>Vouchers</legend>
                            <label for="promo-code">Promo code</label>
                            <input type="text" name="promo-code" id="promo-code">

                            <label for="exchange-voucher">Exchange</label>
                            <select name="exchange-voucher" id="exchange-voucher">
                                <option value="1">Coupon 1 - $10,00</option>
                                <option value="2">Coupon 2 - $20,00</option>
                                <option value="3">Coupon 3 - $15,00</option>
                            </select>
                        </fieldset>

                        <div class="float-right">
                            <button type="submit">Purchase!</button>
                        </div>
                    </form>
                </section>
            </div>
        </div>
    </jsp:body>
</t:page>
