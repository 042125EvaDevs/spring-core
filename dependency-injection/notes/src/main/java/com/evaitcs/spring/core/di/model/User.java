package com.evaitcs.spring.core.di.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {

  private long id;

  private String name;

  private String email;

  private Address address;

  private int phoneNum;

  public User (long id, String name, String email, Address address, int phoneNum){
    this.id = id;
    this.name = name;
    this.email = email;
    this.address = address;
    this.phoneNum = phoneNum;
  }

  public User() {}

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    Pattern emailPattern = Pattern.compile("^(\\w+)@(\\w{2,})\\.(\\w{2,7})$");
    Matcher matcher = emailPattern.matcher(email.trim());


    if (!matcher.matches()) {
      throw new RuntimeException("Invalid email");
    }

    this.email = matcher.group();
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public int getPhoneNum() {
    return phoneNum;
  }

  public void setPhoneNum(int phoneNum) {
    this.phoneNum = phoneNum;
  }
}
