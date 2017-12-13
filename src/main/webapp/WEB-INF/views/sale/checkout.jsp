<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<c:set var="order" value="${sessionScope.get('shopCart')}" />

<t:page>
    <jsp:attribute name="title">Order checkout</jsp:attribute>
    <jsp:body>
        <div class="row">
            <h1>Checkout Page</h1>
        </div>
        <div class="row">
            <div class="column column-33">
                <section>
                    <h3>Order summary</h3>
                    <div class="order-summary">
                        <p>
                            <c:forEach var="item" items="${order.orderItems}">
                                <span class="order-summary__itemqty">${item.quantity}</span>
                                <span>${item.book.title}:</span>
                                <strong><fmt:formatNumber type="currency" value="${item.subTotal}"/></strong><br>
                            </c:forEach>
                        </p>
                        <p>Shipping Cost: R$0.00</p>
                        <h4>Total: <fmt:formatNumber type="currency" value="${order.total}" /> </h4>
                        <div>
                            <label for="promo-code">Promo code</label>
                            <input type="text" name="promo-code" id="promo-code">
                            <button class="button-outline">Apply</button>
                        </div>
                    </div>
                </section>
            </div>
            <div class="column">
                <section>
                    <h3>Shipping Info</h3>
                    <div class="row">
                        <div class="column">
                            <select name="ship-address" id="ship-address">
                                <c:forEach var="address" items="${customerAddresses}">
                                    <option value="${address.id}">
                                        <c:choose>
                                            <c:when test="${address.alias != null}">${address.alias}</c:when>
                                            <c:otherwise>${address.publicPlaceName}</c:otherwise>
                                        </c:choose>
                                    </option>
                                </c:forEach>
                            </select>
                            <%--<div class="current-address">--%>
                                <%--<h4>Current delivery address:</h4>--%>
                                <%--<p>2400 Bayshore Pkwy, Mountain View <br> CA 94043, EUA</p>--%>
                            <%--</div>--%>
                        </div>
                        <button class="button-outline float-right">New Address</button>
                    </div>
                </section>
                <section class="clear">
                    <h3>Payment options</h3>
                    <form action="#">
                        <fieldset>
                            <legend>Credit Cards</legend>
                            <h5>Your cards</h5>
                            <p>Select one or more credit cards to purchase</p>
                            <c:forEach var="card" items="${customerCards}">
                                <label for="card-${card.id}">
                                    <input type="checkbox" name="credit-card"
                                           id="card-${card.id}" value="${card.id}">
                                        ${card.company.name}
                                </label>
                            </c:forEach>
                        </fieldset>

                        <fieldset>
                            <legend>Vouchers</legend>

                            <label for="exchange-voucher">Exchange vouchers</label>
                            <select name="exchange-voucher" id="exchange-voucher">
                                <option value="">none</option>
                                <%--<option value="1">Coupon 1 - $10,00</option>--%>
                                <%--<option value="2">Coupon 2 - $20,00</option>--%>
                                <%--<option value="3">Coupon 3 - $15,00</option>--%>
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
