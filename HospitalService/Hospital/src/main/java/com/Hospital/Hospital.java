package com.Hospital;

public class Hospital
{


	private int hid;
	private String name;
	private String regID;
	private String address;
	private String telNo;

	
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getRegID() {
		return regID;
	}
	public void setRegID(String regID) {
		this.regID = regID;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	@Override
	public String toString() {
		return "Hospital [hid=" + hid + ", name=" + name + ", regID=" + regID + ", address=" + address + ", telNo="
				+ telNo + "]";
	}
	
	
	

	

}


