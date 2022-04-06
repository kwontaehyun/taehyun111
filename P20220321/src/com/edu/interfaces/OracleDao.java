package com.edu.interfaces;

public class OracleDao implements Dao{

	@Override
	public void select() {
		System.out.println("OracleDB에서 조회합니다.");
	}

	@Override
	public void insert() {
		System.out.println("OracleDB에서 입력합니다.");
	}

	@Override
	public void update() {
		System.out.println("OracleDB에서 수정합니다.");
	}

	@Override
	public void delete() {
		System.out.println("OracleDB에서 삭제합니다.");
	}

	@Override
	public void PowerOn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void PowerOff() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}

}
