package br.com.codexbookstore.domain.customer;

import br.com.codexbookstore.domain.DomainEntity;
import br.com.codexbookstore.domain.Phone;
import br.com.codexbookstore.domain.User;
import br.com.codexbookstore.domain.location.Address;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Customer extends DomainEntity {
    private String identificationDoc;
    private String name;
    private Date dob;
    private Phone phone;
    private Gender gender;
    private List<CreditCard> creditCardList = new ArrayList<>();
    private List<Address> deliveryAddressList = new ArrayList<>();
    private Address chargeAddress;
    private User user;

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentificationDoc() {
        return identificationDoc;
    }

    public void setIdentificationDoc(String identificationDoc) {
        this.identificationDoc = identificationDoc;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Address getChargeAddress() {
        return chargeAddress;
    }

    public void setChargeAddress(Address chargeAddress) {
        this.chargeAddress = chargeAddress;
    }

    public void addDeliveryAddress(Address address) {
        this.deliveryAddressList.add(address);
    }

    public void addCreditCard(CreditCard card) {
        this.creditCardList.add(card);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
