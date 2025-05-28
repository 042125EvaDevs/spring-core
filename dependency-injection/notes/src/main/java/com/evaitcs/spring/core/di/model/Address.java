package com.evaitcs.spring.core.di.model;


import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Optional;

@Getter
@Setter
public class Address {

  private Integer buildingNumber;

  private String streetName;

  private String city;

  private String state;

  private Integer zipCode;

  private String unitNumber;

  public Address() {};

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    private Integer buildingNumber;
    private String streetName;
    private String city;
    private String state;
    private Integer zipCode;
    private String unitNumber;

    public Builder buildingNumber(Integer buildingNumber) {
      this.buildingNumber = Objects.requireNonNull(buildingNumber, "buildingNumber must not be null");
      return this;
    }

    public Builder streetName(String streetName) {
      this.streetName = Objects.requireNonNull(streetName, "streetName must not be null");
      return this;
    }

    public Builder city(String city) {
      this.city = Objects.requireNonNull(city, "city must not be null");
      return this;
    }

    public Builder state(String state) {
      this.state = Objects.requireNonNull(state, "state must not be null");
      return this;
    }

    public Builder zipCode(Integer zipCode) {
      this.zipCode = Objects.requireNonNull(zipCode, "zipCode must not be null");
      return this;
    }

    public Builder unitNumber(String unitNumber) {
      this.unitNumber = Objects.requireNonNull(unitNumber, "unitNumber must not be null");
      return this;
    }

    public Address build() {
      final Address address = new Address();
      address.setStreetName(this.streetName);
      address.setBuildingNumber(this.buildingNumber);
      address.setStreetName(this.streetName);
      address.setCity(this.city);
      address.setState(this.state);
      address.setZipCode(this.zipCode);
      address.setUnitNumber(this.unitNumber);
      return address;
    }
  }

  public static void main(String[] args) {
    Address address = Address.builder()
      .buildingNumber(6301)
      .streetName("Centreville Dr.")
      .state("VA")
      .city("Herndon")
      .zipCode(22011)
      .build();
  }

}
