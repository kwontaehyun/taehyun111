package com.dev;

public class Account {
	//field
	private String accNo;
	private String accName;
	private int accMoney;
	
	
	public static String bankName;
	static {
		bankName = "한일은행";
	}
	
	public static void showBankName()
	{
		System.out.println("한일은행");
	}
	
	//생성자의 목적 
	//오버로딩!
	public Account(int money)
	{
		
	}
	
	public Account(String accNo, String accName) {
		super();
		this.accNo = accNo;
		this.accName = accName;
	}

	public Account(String accNo, int accMoney) {
		super();
		this.accNo = accNo;
		this.accMoney = accMoney;
	}

	public Account(String accNo, String accName, int accMoney) {
		super();
		this.accNo = accNo;
		this.accName = accName;
		this.accMoney = accMoney;
	}
	
	Account() {
	}
	
	
	//method
	public String getAccNo() 
	{
		return accNo;
	}

	public void setAccNo(String accNo) 
	{
		this.accNo = accNo;
	}
	public String getAccName() 
	{
		return accName;
	}
	public void setAccName(String accName) 
	{
		this.accName = accName;
	}
	public int getAccMoney()
	{
		return accMoney;
	}
	public void setAccMoney(int accMoney) 
	{
		this.accMoney = accMoney;
	}

	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", accName=" + accName + ", accMoney=" + accMoney + "]";
	}
	
}
