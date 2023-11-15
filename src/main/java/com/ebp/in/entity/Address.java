package com.ebp.in.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long addressId;

	private int flatOrHouseNumber;
	@NotEmpty(message="buildingname is required")
	private String buildingName;
	@NotEmpty(message="landmark is required")
	private String landmark;
	@NotEmpty(message="Village is required")
	private String village;
	@NotEmpty(message="Taluka is required")
	private String taluka;

<<<<<<< HEAD
	@NotNull(message="Please enter your district")
	private String district;
	
	@NotNull(message="Please enter your state")
	private String state;
	
	@NotNull(message="Please enter your pincode")
=======
	@NotEmpty(message="District is required")
	private String district;
	
	@NotEmpty(message="State is required")
	private String state;
	
	@NotEmpty(message="pincode is required")
>>>>>>> b423192b85408e1fe090b5a59aa16a47da93172b
	private String pincode;

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public int getFlatOrHouseNumber() {
		return flatOrHouseNumber;
	}

	public void setFlatOrHouseNumber(int flatOrHouseNumber) {
		this.flatOrHouseNumber = flatOrHouseNumber;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getTaluka() {
		return taluka;
	}

	public void setTaluka(String taluka) {
		this.taluka = taluka;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", flatOrHouseNumber=" + flatOrHouseNumber + ", buildingName="
				+ buildingName + ", landmark=" + landmark + ", village=" + village + ", taluka=" + taluka
				+ ", district=" + district + ", state=" + state + ", pincode=" + pincode + "]";
	}

<<<<<<< HEAD
	public Address(Long addressId, int flatOrHouseNumber, String buildingName, String landmark, String village,
			String taluka, String district, String state, String pincode) {
=======
	public Address(Long addressId, int flatOrHouseNumber,
			@NotEmpty(message = "buildingname is required") String buildingName,
			@NotEmpty(message = "landmark is required") String landmark,
			@NotEmpty(message = "Village is required") String village,
			@NotEmpty(message = "Taluka is required") String taluka,
			@NotEmpty(message = "District is required") String district,
			@NotEmpty(message = "State is required") String state,
			@NotEmpty(message = "pincode is required") String pincode) {
>>>>>>> b423192b85408e1fe090b5a59aa16a47da93172b
		super();
		this.addressId = addressId;
		this.flatOrHouseNumber = flatOrHouseNumber;
		this.buildingName = buildingName;
		this.landmark = landmark;
		this.village = village;
		this.taluka = taluka;
		this.district = district;
		this.state = state;
		this.pincode = pincode;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	

}
