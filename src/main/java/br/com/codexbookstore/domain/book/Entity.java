package br.com.codexbookstore.domain.book;

/**
 * Created by everton on 24/09/17.
 */
public class Entity {
    private Long id;
    private boolean enabled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
