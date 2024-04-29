package com.ecom.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class AddressEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addrId;
    
    private Boolean isAddrPrimary;
    private String addrLine1;
    private String addrLine2;
    private String landmark;
    private String city;
    private String state;
    private String country;
    private String pincode;
    private String phoneNumber;
    
    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity userAccount;

	public Long getAddrId() {
		return addrId;
	}

	public void setAddrId(Long addrId) {
		this.addrId = addrId;
	}

	public Boolean getIsAddrPrimary() {
		return isAddrPrimary;
	}

	public void setIsAddrPrimary(Boolean isAddrPrimary) {
		this.isAddrPrimary = isAddrPrimary;
	}

	public String getAddrLine1() {
		return addrLine1;
	}

	public void setAddrLine1(String addrLine1) {
		this.addrLine1 = addrLine1;
	}

	public String getAddrLine2() {
		return addrLine2;
	}

	public void setAddrLine2(String addrLine2) {
		this.addrLine2 = addrLine2;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public UserEntity getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserEntity userAccount) {
		this.userAccount = userAccount;
	}
    
}
