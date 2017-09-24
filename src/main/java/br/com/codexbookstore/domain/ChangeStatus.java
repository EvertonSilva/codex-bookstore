package br.com.codexbookstore.domain;

/**
 * Created by everton on 24/09/17.
 */
public class ChangeStatus extends AbstractCategory {
    private String justification;

    public ChangeStatus(String justification) {
        this.justification = justification;
    }
}
