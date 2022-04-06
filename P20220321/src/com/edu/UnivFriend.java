package com.edu;

public class UnivFriend extends Friend {
//학교: 학교이름, 전공
	private String university;
	private String major;
	
	
	public UnivFriend() {
		super();
	}
	public UnivFriend(String name, int age, double height, double weight, String phone) {
		super(name, age, height, weight, phone);
		//Friend(name, age, height, weight, phone)
	}
	public UnivFriend(String name, int age, double height, double weight, String phone, String university, String major) 
	{
		super(name, age, height, weight, phone);
		this.university = university;
		this.major = major;
	}
	
	
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	@Override
	public String toString() {
		String str = "친구의 이름은 " + super.getName() + "이고 친구의 나이는 " + super.getAge() + "이고 \n친구의 키는 " + super.getHeight() +"이고 친구의 몸무게는 " + super.getWeight() + "이고 폰번호는 " + this.getPhone()  + "입니다.\n===========< 추가정보 >============\n" + "학교이름은 " + this.getUniversity() + "이고 전공은 " + this.getMajor() + "입니다\n";
		return str;
	}
	
	

}
