package br.com.codexbookstore.control;

import br.com.codexbookstore.control.abstractFactory.AbstractOperationFactory;
import br.com.codexbookstore.control.abstractFactory.FormInsertOperationFactory;
import br.com.codexbookstore.control.operations.*;
import br.com.codexbookstore.control.viewHelpers.IViewHelper;
import br.com.codexbookstore.control.viewHelpers.login.LoginVh;
import br.com.codexbookstore.control.viewHelpers.sales.*;
import br.com.codexbookstore.control.viewHelpers.book.CreateBookVh;
import br.com.codexbookstore.control.viewHelpers.book.BookEditFormVh;
import br.com.codexbookstore.control.viewHelpers.book.ListBookVh;
import br.com.codexbookstore.control.viewHelpers.book.UpdateBookVh;
import br.com.codexbookstore.control.viewHelpers.customer.CreateCustomerVh;
import br.com.codexbookstore.control.viewHelpers.customer.InsertCustomerFormVh;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Application entry point, implementation of
 * Front Controller Java EE pattern
 *
 * see http://www.oracle.com/technetwork/java/frontcontroller-135648.html
 */
@WebServlet("/")
public class AppController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AbstractOperationFactory operationFactory;
    private HashMap<String, IViewHelper> viewHelpers;
    private HashMap<String, IOperation> commands;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void destroy() {

    }

    public AppController() {
        operationFactory = null;
        String basePath = "/codex-bookstore";
        viewHelpers = new HashMap<>();
        commands = new HashMap<>();

        // homepage
        viewHelpers.put(basePath.concat("/"), new ListBookVh());

        // book ViewHelpers
        viewHelpers.put(basePath.concat("/books/list"), new ListBookVh());
        viewHelpers.put(basePath.concat("/books/create"), new CreateBookVh());
        viewHelpers.put(basePath.concat("/books/edit"), new BookEditFormVh());
        viewHelpers.put(basePath.concat("/books/update"), new UpdateBookVh());

        // customer ViewHelpers
        viewHelpers.put(basePath.concat("/customers/new"), new InsertCustomerFormVh());
        viewHelpers.put(basePath.concat("/customers/create"), new CreateCustomerVh());

        // shopcart ViewHelpers
        viewHelpers.put(basePath.concat("/cart/addItem"), new ShopCartVh());
        viewHelpers.put(basePath.concat("/cart/removeItem"), new ShopCartRemoveItemVh());
        viewHelpers.put(basePath.concat("/cart/items"), new ListShopCartVh());

        // order viewHelper
        // viewHelpers.put(basePath.concat("/order/checkout"), new OrderCheckoutVh());
        viewHelpers.put(basePath.concat("/order/checkout"), new OrderCheckoutPageVh());

        // login
        viewHelpers.put(basePath.concat("/login"), new LoginVh());

        commands.put("NEW", new FormInsertOperation());
        commands.put("EDIT", new FormEditOperation());
        commands.put("CREATE", new CreateOperation());
        commands.put("RETRIEVE", new RetrieveOperation());
        commands.put("UPDATE", new UpdateOperation());
        commands.put("DELETE", new DeleteOperation());

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        String operation = request.getParameter("operation");

        IOperation op;
        IViewHelper vh;
        if(uri.contains("books/new")) {
            operationFactory = new FormInsertOperationFactory();
            op = operationFactory.defineOperation();
            vh = operationFactory.defineViewHelper();
        } else {
            vh = viewHelpers.get(uri);
            op = operation == null ? commands.get("RETRIEVE") : commands.get(operation.toUpperCase());
        }

        Result result = op.execute(vh.getEntity(request));
        vh.setView(result, request, response);
    }

}