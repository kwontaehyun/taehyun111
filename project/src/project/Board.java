package project;

public class Board {
	private int boardNum; // 작성번호
	private String boardpwd; // 비밀번호.
	private String boardWriter; // 작성자
	private String boardTitle; // 글 제목
	private String boardWrite; // 글 내용
	private String boardDate; // 글 쓴 날짜
	private int userNum; // 유저 정보.
	private String comment;
	private int commentNum;
	private int commentHits;

	public Board() {

	}
	
	public Board(int boardNum, int commentHits) {
		super();
		this.boardNum = boardNum;
		this.commentHits = commentHits;
	}

	public Board(int boardNum, int commentNum, String comment) {
		super();
		this.boardNum = boardNum;
		this.commentNum = commentNum;
		this.comment = comment;
	}

	public Board(int boardNum, String boardpwd, String boardWriter, String boardTitle, String boardWrite,
			String boardDate, int userNum) {
		super();
		this.boardNum = boardNum;
		this.boardpwd = boardpwd;
		this.boardWriter = boardWriter;
		this.boardTitle = boardTitle;
		this.boardWrite = boardWrite;
		this.boardDate = boardDate;
		this.userNum = userNum;
	}
	
	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}

	public int getCommentHits() {
		return commentHits;
	}

	public void setCommentHits(int commentHits) {
		this.commentHits = commentHits;
	}

	@Override
	public String toString() {
		return boardNum + "			" + boardTitle + "			" + boardWriter + "	" + boardDate;
	}
	
	public String writeToString() {
		return "-------------------------------------------------------------------------------------	\n"
				+ "				" + boardTitle + "				\n-------------------------------------------------------------------------------------\n" + boardWrite
				+ "\n-------------------------------------------------------------------------------------\n									" + boardWriter + "\n-------------------------------------------------------------------------------------\n									"
				+ boardDate;
	}

	public String boardReference() {
		return "NO : " + boardNum + "	글 제목 : " + boardTitle;
	}

	public String comMent() {
		return comment;
	}
	
	public String userCommentInfo() {
		return "댓글NO	:	"+ commentNum + "	게시판NO	:	" + boardNum + "	글 제목	:	" + boardTitle
				+"		댓글	:	" + comment;
	}
	

}
