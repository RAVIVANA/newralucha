package com.nkxgen.spring.jdbc.model;

public class Customer {

	private Long id;

	private String title;

	private String type;

	private String currentAddress;

	private String currentPINCode;

	private String dateOfBirth;

	private String mobile1;

	private String mobile2;

	private String residencePhone;

	private String residenceAddress;

	// Setters and Getters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setcustTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setcust_type(String type) {
		this.type = type;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setcust_caddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getCurrentPINCode() {
		return currentPINCode;
	}

	public void setcust_capincode(String currentPINCode) {
		this.currentPINCode = currentPINCode;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setcust_dob(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMobile1() {
		return mobile1;
	}

	public void setcust_mobile1(String mobile1) {
		this.mobile1 = mobile1;
	}

	public String getMobile2() {
		return mobile2;
	}

	public void setcust_mobile2(String mobile2) {
		this.mobile2 = mobile2;
	}

	public String getResidencePhone() {
		return residencePhone;
	}

	public void setcust_rphone(String residencePhone) {
		this.residencePhone = residencePhone;
	}

	public String getResidenceAddress() {
		return residenceAddress;
	}

	public void setcust_raddress(String residenceAddress) {
		this.residenceAddress = residenceAddress;
	}

	public static Customer dotheservice1(Customertrail customertrail) {
		Customer customer = new Customer();
		customer.setId(customertrail.getId());
		customer.setcustTitle(customertrail.getTitle());
		customer.setcust_type(customertrail.getType());
		customer.setcust_caddress(customertrail.getCurrentAddress());
		customer.setcust_capincode(customertrail.getCurrentPINCode());
		customer.setcust_dob(customertrail.getDateOfBirth());
		customer.setcust_mobile1(customertrail.getMobile1());
		customer.setcust_mobile2(customertrail.getMobile2());
		customer.setcust_rphone(customertrail.getResidencePhone());
		customer.setcust_raddress(customertrail.getResidenceAddress());

		return customer;
	}

}
