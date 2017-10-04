package br.com.codexbookstore.domain.customer;

import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.domain.Phone;

import java.util.Date;
import java.util.List;

public class Customer extends Entity {
    private String registry;
    private String name;
    private Date dob;
    private Phone phone;
    private Gender gender;
    private CreditCard creditCard;
    private List<DeliveryAddress> deliveryAddressList;
    private List<ChargeAddress> chargeAddressesList;

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
}
