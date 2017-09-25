package br.com.codexbookstore.control;

import br.com.codexbookstore.control.operations.AbstractOperation;
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
    private AbstractOperation cmd;
    private IViewHelper vh;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void destroy() {

    }

    public AppController() {
        basePath = "/codex-bookstore";
        viewsFolderPath = "/WEB-INF/views/";
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();

        if(uri.equals(basePath)) {
            request.getRequestDispatcher(viewsFolderPath.concat("index.jsp")).forward(request, response);
        } else if(uri.contains("new")) {
            /*String[] reqPath = uri.split("/");
            StringBuilder view = new StringBuilder(viewsFolderPath);
            view.append(reqPath[2]);
            view.append("/new.jsp");

            request.getRequestDispatcher(view.toString()).forward(request, response);*/
        }
    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//
//    }
}