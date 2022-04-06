package com.edu;

public class Student {
	private int stuNober;
	private String stuName;
	private int korScore = -1;
	private int mathScore = -1;
	private int EngScore = -1;
	
	//생성자 : 필드의 값을 초기화..
	Student(){
		this.stuNober = 1;
		this.stuName = "Nobody";
		this.korScore = 90;
		this.mathScore = 92;
		this.EngScore = 88;
	}
	
	public Student(int stuNober)
	{
		this.stuNober = stuNober;
	}
	
	public Student(int stuNober, String stuName, int korScore, int mathScore, int EngScore) {
		
		this.stuNober = stuNober;
		this.stuName = stuName;
		this.korScore = korScore;
		this.mathScore = mathScore;
		this.EngScore  = EngScore;
	}

	public Student(int stuNober, String stuName)
	{
		this.stuNober = stuNober;
		this.stuName = stuName;
	}

	
	int getSumScore()
	{
		if(this.korScore != -1 && this.EngScore != -1 && mathScore != -1)
			return this.korScore + this.EngScore + this.mathScore;
		else
			return 0;
	}
	
	public double getAvgScore()
	{
		return getSumScore() / 3.0;
	}
	
	//기능(method) => 규칙 반환값 메소드명 매개변수
	public void setStuNo(int stuNober)
	{
		this.stuNober = stuNober;
	}
	public int getStudNo()
	{
		return this.stuNober;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getKorScore() {
		return korScore;
	}
	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}
	public int getMathScore() {
		return mathScore;
	}
	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	public int getEngScore() {
		return EngScore;
	}
	public void setEngScore(int engScore) {
		EngScore = engScore;
	}
	
	public String getStudInfo()
	{
		String str = "====================================";
		str += "\n 학생이름은 " + this.stuName + "이고";
		str += "\n 학번은 " + this.getStudNo() + "이고";
		str += "\n 평균은 " + String.format("%.2f",this.getAvgScore()) + "입니다.\n";
		return str;
	}
	
	public static void callStatic()
	{
		System.out.println("정적메소드 실행 ....");
		
	}
}

