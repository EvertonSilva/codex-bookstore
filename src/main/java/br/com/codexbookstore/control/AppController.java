package br.com.codexbookstore.control;

import br.com.codexbookstore.control.operationfactory.AbstractOperationFactory;
import br.com.codexbookstore.control.operationfactory.OperationBuilder;
import br.com.codexbookstore.control.operationfactory.OperationRetrieveFactory;

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
    private OperationBuilder builder;
    private AbstractOperationFactory operationFactory;
    private String basePath;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void destroy() {

    }

    public AppController() {
        this.builder = new OperationBuilder();
        this.basePath = "/codex-bookstore";
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
        if(request.getRequestURI().equals(basePath)) {
            request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
        }
    }
}