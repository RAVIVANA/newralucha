package com.nkxgen.spring.jdbc.model;
public class CustomerSub {
  private long customerId;
  private String title;
  private String phoneNo;
  private String address;

  public long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(long customerId) {
    this.customerId = customerId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getPhoneNo() {
    return phoneNo;
  }

  public void setPhoneNo(String phoneNo) {
    this.phoneNo = phoneNo;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
