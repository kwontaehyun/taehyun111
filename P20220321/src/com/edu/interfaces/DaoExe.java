package com.edu.interfaces;

public class DaoExe {
	public static void main(String[] args) {
		Dao dao = new OracleDao();
		
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
		
		Dao da = new MysqlDao();
		
		da.select();
		da.insert();
		da.update();
		da.delete();
		
		
	}
}
