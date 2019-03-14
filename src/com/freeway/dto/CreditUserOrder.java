package com.freeway.dto;

public class CreditUserOrder {

	private String bankCard;
	private String idCard;
	private int orderId;
	private String phoneNumber;
	private String realName;
	private int userId;

	public void setBankCard(String bankCard) {

		this.bankCard = bankCard;
	}

	public String getBankCard() {

		return bankCard;
	}

	public void setIdCard(String idCard) {

		this.idCard = idCard;
	}

	public String getIdCard() {

		return idCard;
	}

	public void setOrderId(int orderId) {

		this.orderId = orderId;
	}

	public int getOrderId() {

		return orderId;
	}

	public void setPhoneNumber(String phoneNumber) {

		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber() {

		return phoneNumber;
	}

	public void setRealName(String realName) {

		this.realName = realName;
	}

	public String getRealName() {

		return realName;
	}

	public void setUserId(int userId) {

		this.userId = userId;
	}

	public int getUserId() {

		return userId;
	}
}
