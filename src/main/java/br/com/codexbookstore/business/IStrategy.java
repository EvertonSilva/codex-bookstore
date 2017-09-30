package br.com.codexbookstore.business;

import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.domain.book.Entity;

/**
 * Created by everton on 27/09/17.
 */
public interface IStrategy {

    Result process(Entity entity, Result result);
}
