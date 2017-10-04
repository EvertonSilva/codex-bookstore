package br.com.codexbookstore.domain.customer;

import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.domain.Phone;
import br.com.codexbookstore.domain.User;
import br.com.codexbookstore.domain.location.Address;

import java.util.Date;
import java.util.List;

public class Customer extends Entity {
    private String registry;
    private String name;
    private Date dob;
    private Phone phone;
    private Gender gender;
    private CreditCard creditCard;
    private List<Address> deliveryAddressList;
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

    public String getRegistry() {
        return registry;
    }

    public void setRegistry(String registry) {
        this.registry = registry;
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

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
