package project;

public class Board {
	int boardNum; //작성번호
	String boardpwd; // 비밀번호.
	String boardWriter; // 작성자
	String boardTitle; // 글 제목
	String boardWrite; // 글 내용
	String boardDate; // 글 쓴 날짜
	
	public Board() {
		
	}
	
	public Board(int boardNum, String boardpwd, String boardWriter, String boardTitle, String boardWrite,
			String boardDate) {
		super();
		this.boardNum = boardNum;
		this.boardpwd = boardpwd;
		this.boardWriter = boardWriter;
		this.boardTitle = boardTitle;
		this.boardWrite = boardWrite;
		this.boardDate = boardDate;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getBoardpwd() {
		return boardpwd;
	}
	public void setBoardpwd(String boardpwd) {
		this.boardpwd = boardpwd;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardWrite() {
		return boardWrite;
	}
	public void setBoardWrite(String boardWrite) {
		this.boardWrite = boardWrite;
	}
	public String getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	
	@Override
	public String toString() {
		return "Board [boardNum=" + boardNum + ", boardpwd=" + boardpwd + ", boardWriter=" + boardWriter
				+ ", boardTitle=" + boardTitle + ", boardWrite=" + boardWrite + ", boardDate=" + boardDate + "]";
	}
	


	
	
}
