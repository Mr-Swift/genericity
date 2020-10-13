package com.apple.developer.worker_address;

public class Address {
    private String addressName;
    private String zipCode;

    public Address() {
    }

    public Address(String addressName, String zipCode) {
        this.addressName = addressName;
        this.zipCode = zipCode;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "addressName:" + this.getAddressName() + "\t" + "zipCode:" + this.getZipCode();
    }
}
