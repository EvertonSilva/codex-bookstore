package br.com.codexbookstore.domain.location;

import br.com.codexbookstore.domain.Entity;

public class Address extends Entity {
    private String postalCode;
    private String district;
    private String number;
    private Country country;
    private State state;
    private City city;
    private String alias;
    private AddressType addressType;
    private PublicPlace publicPlace;

    // TODO: add another class HomeType
    // private HomeType homeType

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public PublicPlace getPublicPlace() {
        return publicPlace;
    }

    public void setPublicPlace(PublicPlace publicPlace) {
        this.publicPlace = publicPlace;
    }
}
