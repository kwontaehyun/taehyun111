package com.work;

public class Bank {
	
	private int bankNo;
	private String bankName;
	private int bankMoney;
	
	public Bank() {
		
	}
	
	public Bank(int bankNo, String bankName, int bankMoney) {
		this.bankNo = bankNo;
		this.bankName = bankName;
		this.bankMoney = bankMoney;
	}
	
	public int getBankNo() {
		return bankNo;
	}
	public void setBankNo(int bankNo) {
		this.bankNo = bankNo;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public int getBankMoney() {
		return bankMoney;
	}
	public void setBankMoney(int bankMoney) {
		this.bankMoney = bankMoney;
	}

	@Override
	public String toString() {
		return "Bank [bankNo=" + bankNo + ", bankName=" + bankName + ", bankMoney=" + bankMoney + "]";
	}
	
	
	
}
