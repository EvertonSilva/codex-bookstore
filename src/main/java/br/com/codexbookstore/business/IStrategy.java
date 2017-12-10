package br.com.codexbookstore.business;

import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.domain.DomainEntity;

/**
 * Created by everton on 27/09/17.
 */
public interface IStrategy {

    Result process(DomainEntity domainEntity, Result result);
}
