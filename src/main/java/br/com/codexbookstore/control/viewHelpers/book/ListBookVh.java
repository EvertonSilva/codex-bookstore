package br.com.codexbookstore.control.viewHelpers.book;

import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.control.viewHelpers.IViewHelper;
import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.domain.book.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListBookVh implements IViewHelper {
    @Override
    public Entity getEntity(HttpServletRequest request) {
        return new Book();
    }

    @Override
    public void setView(Result result, HttpServletRequest request, HttpServletResponse response) {
        String uri = request.getRequestURI();
        String rootPath = request.getContextPath();
        try {
            request.setAttribute("result", result);
            request.setAttribute("books", result.getEntities("Book"));
            if(uri.equals(rootPath) || uri.equals(rootPath.concat("/"))) {
                request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/WEB-INF/views/books/index.jsp").forward(request, response);
            }
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
