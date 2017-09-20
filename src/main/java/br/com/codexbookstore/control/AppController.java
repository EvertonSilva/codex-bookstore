package br.com.codexbookstore.control;


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
@WebServlet("/**")
public class AppController extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void destroy() {

    }

    public AppController() {

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}