package br.com.codexbookstore.control.viewHelpers.book;

import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.control.viewHelpers.IViewHelper;
import br.com.codexbookstore.domain.book.Book;
import br.com.codexbookstore.domain.Entity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InsertFormVh implements IViewHelper {
    @Override
    public Entity getEntity(HttpServletRequest request) {
        return new Book();
    }

    @Override
    public void setView(Result result, HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("result", result);
            request.setAttribute("categories", result.getEntities("Category"));
            request.setAttribute("authors", result.getEntities("Author"));
            request.getRequestDispatcher("/WEB-INF/views/books/new.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
