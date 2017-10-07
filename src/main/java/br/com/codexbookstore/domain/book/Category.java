package br.com.codexbookstore.domain.book;

/**
 * Created by everton on 24/09/17.
 */
public class Category extends AbstractCategory {
    private String name;
    private String description;

    public Category() {
    }

    public Category(Long id, String name, String description) {
        super.setId(id);
        this.name = name;
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }
}
