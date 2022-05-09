package co.edu.full;

public class FullVO {
	private String title;
	private String StartDate;
	private String endDate;
	
	public FullVO() {
	}
	public FullVO(String title, String startDate, String endDate) {
		super();
		this.title = title;
		StartDate = startDate;
		this.endDate = endDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStartDate() {
		return StartDate;
	}
	public void setStartDate(String startDate) {
		StartDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "FullVO [title=" + title + ", StartDate=" + StartDate + ", endDate=" + endDate + "]";
	}
	
	
	
}
