package br.com.codexbookstore.control;

import br.com.codexbookstore.domain.book.Entity;

import java.util.*;

/**
 * Created by everton on 24/09/17.
 */
public class Result {

    private Map<String, List<Entity>> entities;
    private StringBuilder errors;
    private List<Entity> tmpList;

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

    public void putEntities(List<Entity> entities) {
        String key = entityName(entities.get(0));
        this.entities.put(key, entities);
    }

    public List<Entity> getEntities(String key) {
        return this.entities.get(key);
    }

    public void setEntity(Entity entity) {
        String key = entityName(entity);
        tmpList.add(entity); // TODO: change this
        this.entities.put(key, tmpList);
    }

    private String entityName(Entity entity) {
        return entity.getClass().getSimpleName();
    }
}
