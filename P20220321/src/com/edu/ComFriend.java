package com.edu;

public class ComFriend extends Friend{
	
	private String company;
	private String job;
	
	public ComFriend() {} // super();
	
	public ComFriend(String name, int age, double height, double weight, String phone, String company, String job) {
		super(name, age, height, weight, phone);
		this.company = company;
		this.job = job;
		// TODO Auto-generated constructor stub
	}



	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		String str = "친구의 이름은 " + super.getName() + "이고 친구의 나이는 " + super.getAge() + "이고 \n친구의 키는 " + super.getHeight() +"이고 친구의 몸무게는 " + super.getWeight() + "이고 폰번호는 " + this.getPhone() + "입니다.\n===========< 추가정보 >============\n" +"회사이름은 "+ this.getCompany() +"이고 하는 일은 "+ this.getJob() + "입니다\n";
		return str;
	}
	
	
	
	

}
