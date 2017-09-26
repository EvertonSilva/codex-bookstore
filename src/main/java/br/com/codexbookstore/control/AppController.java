package br.com.codexbookstore.control;

import br.com.codexbookstore.control.abstractFactory.AbstractOperationFactory;
import br.com.codexbookstore.control.abstractFactory.FormInsertOperationFactory;
import br.com.codexbookstore.control.operations.AbstractOperation;
import br.com.codexbookstore.control.operations.IOperation;
import br.com.codexbookstore.control.viewHelpers.IViewHelper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Application entry point, implementation of
 * Front Controller Java EE pattern
 *
 * see http://www.oracle.com/technetwork/java/frontcontroller-135648.html
 */
@WebServlet("/")
public class AppController extends HttpServlet {
    private String basePath;
    private String viewsFolderPath;
    private AbstractOperationFactory operationFactory;
    private IOperation op;
    private IViewHelper vh;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void destroy() {

    }

    public AppController() {
        operationFactory = null;
        basePath = "/codex-bookstore";
        viewsFolderPath = "/WEB-INF/views/";
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();

        if(uri.equals(basePath) || uri.equals(basePath.concat("/"))) {
            request.getRequestDispatcher(viewsFolderPath.concat("index.jsp")).forward(request, response);
        } else if(uri.contains("new")) {
            operationFactory = new FormInsertOperationFactory();
            op = operationFactory.defineOperation();
            vh = operationFactory.defineViewHelper();
        }

        Result result = op.execute(vh.getEntity(request));
        vh.setView(result, request, response);
    }

}