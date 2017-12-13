package br.com.codexbookstore.domain.customer;

import br.com.codexbookstore.domain.DomainEntity;

import javax.persistence.*;

@Entity
@Table(name = "credit_cards")
public class CreditCard extends DomainEntity {
    private String cardNumber;
    private String namePrinted;
    private String securityCode;
    private String expirationDate;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private CreditCardCompany company;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public CreditCard() {
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getNamePrinted() {
        return namePrinted;
    }

    public void setNamePrinted(String namePrinted) {
        this.namePrinted = namePrinted;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public CreditCardCompany getCompany() {
        return company;
    }

    public void setCompany(CreditCardCompany company) {
        this.company = company;
    }
}
