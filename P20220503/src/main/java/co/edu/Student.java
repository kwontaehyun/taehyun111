package co.edu;

public class Student {
	private int StuNo;
	private String StuName;
	private int EngScore;
	private int KorScore;
	
	public Student() {
		
	}
	
	
	public Student(int stuNo, String stuName, int engScore, int korScore) {
		super();
		StuNo = stuNo;
		StuName = stuName;
		EngScore = engScore;
		KorScore = korScore;
	}
	
	public int getStuNo() {
		return StuNo;
	}
	public void setStuNo(int stuNo) {
		StuNo = stuNo;
	}
	public String getStuName() {
		return StuName;
	}
	public void setStuName(String stuName) {
		StuName = stuName;
	}
	public int getEngScore() {
		return EngScore;
	}
	public void setEngScore(int engScore) {
		EngScore = engScore;
	}
	public int getKorScore() {
		return KorScore;
	}
	public void setKorScore(int korScore) {
		KorScore = korScore;
	}
	
	@Override
	public String toString() {
		return "Student [StuNo=" + StuNo + ", StuName=" + StuName + ", EngScore=" + EngScore + ", KorScore=" + KorScore
				+ "]";
	}
	
	
}
