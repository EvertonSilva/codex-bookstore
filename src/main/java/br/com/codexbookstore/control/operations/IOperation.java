package br.com.codexbookstore.control.operations;

import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.domain.Entity;

/**
 * Created by everton on 24/09/17.
 */
public interface IOperation {

    Result execute(Entity entity);
}
