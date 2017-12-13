package br.com.codexbookstore.domain.customer;

import br.com.codexbookstore.domain.DomainEntity;
import br.com.codexbookstore.domain.User;
import br.com.codexbookstore.domain.location.Address;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer extends DomainEntity {
    @Column(name = "identification_doc")
    private String identificationDoc;

    @Column
    private String name;

    @Temporal(TemporalType.DATE)
    @Column
    private Date dob;

    @Column
    private String phone;

    @Column
    private Gender gender;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(name = "customers_addresses",
            joinColumns = {@JoinColumn(name = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "address_id")})
    private List<Address> addresses;

    @OneToMany(mappedBy = "customer", targetEntity = CreditCard.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CreditCard> cards;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Customer() {
    }

    public String getIdentificationDoc() {
        return identificationDoc;
    }

    public void setIdentificationDoc(String identificationDoc) {
        this.identificationDoc = identificationDoc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CreditCard> getCards() {
        return cards;
    }
}
