package br.com.codexbookstore.control.crudService;

import br.com.codexbookstore.control.Result;
import br.com.codexbookstore.domain.DomainEntity;

public interface ICrudService {
    Result create(DomainEntity domainEntity);
    Result retrieve(DomainEntity domainEntity);
    Result update(DomainEntity domainEntity);
    Result delete(DomainEntity domainEntity);
    Result insertForm(DomainEntity domainEntity);
    Result editForm(DomainEntity domainEntity);
}
