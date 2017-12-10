package br.com.codexbookstore.domain.location;

import br.com.codexbookstore.domain.DomainEntity;
import br.com.codexbookstore.domain.customer.Customer;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "addresses")
public class Address extends DomainEntity {
    @Column
    private String alias;

    @Column
    private String district;

    @Column
    private String number;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "public_place_name")
    private String publicPlaceName;

    @Column(name = "public_place_type")
    private String publicPlaceType;

    @Column
    @ManyToMany(mappedBy = "addresses", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private List<Customer> customers;

    @Column
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name = "addresses_to_address_types",
            joinColumns = {@JoinColumn(name = "address_id")},
            inverseJoinColumns = {@JoinColumn(name = "address_type_id")})
    private List<AddressType> addressTypes;

    public Address() {
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPublicPlaceName() {
        return publicPlaceName;
    }

    public void setPublicPlaceName(String publicPlaceName) {
        this.publicPlaceName = publicPlaceName;
    }

    public String getPublicPlaceType() {
        return publicPlaceType;
    }

    public void setPublicPlaceType(String publicPlaceType) {
        this.publicPlaceType = publicPlaceType;
    }
}
