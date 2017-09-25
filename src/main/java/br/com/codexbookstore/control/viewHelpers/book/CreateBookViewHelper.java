package br.com.codexbookstore.control.viewHelpers.book;

import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.control.viewHelpers.IViewHelper;
import br.com.codexbookstore.domain.Entity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by everton on 24/09/17.
 */
public class CreateBookViewHelper implements IViewHelper {
    @Override
    public Entity getEntity(HttpServletRequest request) {
        return null;
    }

    @Override
    public void setView(Result result, HttpServletRequest request, HttpServletResponse response) {

    }
}
