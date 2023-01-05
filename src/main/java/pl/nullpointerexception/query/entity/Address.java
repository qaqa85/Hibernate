package pl.nullpointerexception.query.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class Address {
    @Enumerated(EnumType.STRING)
    @Column(name = "address_type")
    private AddressType addressType;
    private String street;
    @Column(name = "postal_code")
    private String postalCode;
    private String city;

    public Address(AddressType addressType, String street, String postalCode, String city) {
        this.addressType = addressType;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
    }

    public Address() {
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressType=" + addressType +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
