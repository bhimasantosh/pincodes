package com.santosh.wsutils.pincodes;

public class Pincode {
	public Pincode(String state, String district, String subDistrict, String village, String locality, String locality2,
			String locality3, String office, String pincode) {
		super();
		this.state = state;
		this.district = district;
		this.subDistrict = subDistrict;
		this.village = village;
		this.locality = locality;
		this.locality2 = locality2;
		this.locality3 = locality3;
		this.office = office;
		this.pincode = pincode;
	}

	private String state;
	private String district;
	private String subDistrict;
	private String village;
	private String locality;
	private String locality2;
	private String locality3;
	private String office;
	private String pincode;

	public String getState() {
		return state;
	}

	@Override
	public String toString() {
		return "Pincode [state=" + state + ", district=" + district + ", subDistrict=" + subDistrict + ", village="
				+ village + ", locality=" + locality + ", locality2=" + locality2 + ", locality3=" + locality3
				+ ", office=" + office + ", pincode=" + pincode + "]";
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getSubDistrict() {
		return subDistrict;
	}

	public void setSubDistrict(String subDistrict) {
		this.subDistrict = subDistrict;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getLocality2() {
		return locality2;
	}

	public void setLocality2(String locality2) {
		this.locality2 = locality2;
	}

	public String getLocality3() {
		return locality3;
	}

	public void setLocality3(String locality3) {
		this.locality3 = locality3;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

}
