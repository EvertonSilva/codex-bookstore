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
}
