package com.project;

import java.util.List;

public interface BoardService {

	public List<Board> BoardList();
	public void insertBoard(Board board);
	public void modifyBoard(Board board);
	public void BoardDelete(String pwd);
}
