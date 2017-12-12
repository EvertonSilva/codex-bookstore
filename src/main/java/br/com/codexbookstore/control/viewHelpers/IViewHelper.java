package br.com.codexbookstore.control.viewHelpers;

import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.domain.DomainEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by everton on 24/09/17.
 */
public interface IViewHelper {

    DomainEntity getEntity(HttpServletRequest request);

    void setView(Result result, HttpServletRequest request, HttpServletResponse response);
}
