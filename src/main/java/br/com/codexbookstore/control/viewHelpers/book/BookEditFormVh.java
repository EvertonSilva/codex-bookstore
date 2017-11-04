package br.com.codexbookstore.control.viewHelpers.book;

import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.control.viewHelpers.IViewHelper;
import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.domain.book.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookEditFormVh implements IViewHelper {
    @Override
    public Entity getEntity(HttpServletRequest request) {
        Book book = new Book();
        book.setId(Long.valueOf(request.getParameter("id")));
        return book;
    }

    @Override
    public void setView(Result result, HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("result", result);
            request.setAttribute("book", result.getEntities("Book").get(0));
            request.setAttribute("categories", result.getEntities("Category"));
            request.setAttribute("authors", result.getEntities("Author"));
            request.getRequestDispatcher("/WEB-INF/views/books/edit.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
