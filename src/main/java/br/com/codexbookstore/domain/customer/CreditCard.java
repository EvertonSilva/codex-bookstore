package br.com.codexbookstore.domain.customer;

public class CreditCard {
    private String cardNumber;
    private String namePrinted;
    private String securityCode;
    private String company;
    private String expirationDate;

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
}
