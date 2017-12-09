<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<t:page>
    <jsp:attribute name="title">Shopping cart</jsp:attribute>
    <jsp:body>
        <div class="row">
            <h1>Shopping Cart</h1>
        </div>
        <div class="row">
            <div class="column">
                <h3></h3>
            </div>
            <div class="column column-80">
                <table class="shopcart">
                    <tr>
                        <th>Book title</th>
                        <th>Quantity</th>
                        <th>Subtotal</th>
                        <th>actions</th>
                    </tr>
                    <c:forEach var="cartItem" items="${cartItems}" varStatus="it">
                        <tr class="shopcart__item">
                            <td>${cartItem.book.title}</td>
                            <td>${cartItem.quantity}</td>
                            <td><fmt:formatNumber type="currency" value="${cartItem.subTotal}"/></td>
                            <td>
                                <a href="${rootPath}/cart/removeItem?operation=delete&item=${it.index}" title="remove">
                                    <i class="fa fa-close" aria-hidden="true"></i>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <div class="shopCart-total">
                    <span>Total: </span>
                    <span>
                        <strong><fmt:formatNumber type="currency" value="${sessionScope.shopCart.total}" /></strong>
                    </span>
                    <span>&nbsp;</span>
                    <a href="${rootPath}/order/checkout?operation=new" class="button button-outline">Checkout</a>
                </div>
            </div>
        </div>
    </jsp:body>
</t:page>