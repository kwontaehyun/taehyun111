package project;

import java.util.List;

public interface BoardService {

	public List<Board> BoardList();
	public void insertBoard(Board board);
	public void modifyBoard(Board board);
	public boolean BoardDelete(String pwd, int boardNum);
	public boolean CheckNum();
	public Board boardView(int boardNum);
	public boolean CheckPwd(int writeNum);
	public int writeNum();
	public int CommentNum();
	public boolean PwdCheck(String pwd);
	public List<Board> refercence();
	public void boardCommentInsert(Board board);
	public List<Board> boardComment(int boardNum);
	public int ToComment(int boardNum);
	public int getCommentHits(int boardNum);
	public void CommentHits(Board board);
}