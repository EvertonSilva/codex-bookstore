package br.com.codexbookstore.control;

import br.com.codexbookstore.domain.DomainEntity;

import java.util.*;

public class Result {

    private Map<String, List<DomainEntity>> entities;
    private StringBuilder errors;
    private List<DomainEntity> tmpList;

    public Result() {
        entities = new HashMap<>();
        errors = new StringBuilder("");
        tmpList = new ArrayList<>();
    }

    public void addErrorMsg(String message) {
        errors.append(message);
    }

    public String getErrorsMsg() {
        return errors.toString();
    }

    public boolean hasErrors() {
        // true - has error
        // false - 200 OK!
        return errors.length() > 0;
    }

    public void putEntities(List<DomainEntity> entities) {
        String key = entityName(entities.get(0));
        this.entities.put(key, entities);
    }

    public List<DomainEntity> getEntities(String key) {
        return this.entities.get(key);
    }

    public void setEntity(DomainEntity domainEntity) {
        String key = entityName(domainEntity);
        tmpList.add(domainEntity); // TODO: change this
        this.entities.put(key, tmpList);
    }

    private String entityName(DomainEntity domainEntity) {
        return domainEntity.getClass().getSimpleName();
    }
}
