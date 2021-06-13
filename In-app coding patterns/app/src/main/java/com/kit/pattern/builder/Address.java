package com.kit.pattern.builder;

public final class Address {
    private final int id, pinCode;
    private final float latitude, longitude;
    private final String street, city, country;

    public Address(Builder builder) {
        this.id = builder.id;
        this.pinCode = builder.pinCode;
        this.latitude = builder.latitude;
        this.longitude = builder.longitude;
        this.street = builder.street;
        this.city = builder.city;
        this.country = builder.country;
    }

    public int getId() {
        return id;
    }

    public int getPinCode() {
        return pinCode;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public static class Builder {
        private int id, pinCode;
        private float latitude, longitude;
        private String street, city, country;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setPinCode(int pinCode) {
            this.pinCode = pinCode;
            return this;
        }

        public Builder setLatitude(float latitude) {
            this.latitude = latitude;
            return this;
        }

        public Builder setLongitude(float longitude) {
            this.longitude = longitude;
            return this;
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }
}
