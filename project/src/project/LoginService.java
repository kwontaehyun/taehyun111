package project;

import java.util.List;

public interface LoginService {
	public List<Board> boardInfo(int userNum);
	public List<Board> comMentInfo(int userNum);
	public void userDelete(String pwd);
	public void userModify(String pwd);
	public void emailModify(String email, String pwd);
	public int userPwdCheck(String pwd);
	public void commentDelete(int delete);
	public void commentModefy(String modefyComment, int modefy);
	public boolean selectComment(int modefy);
}
