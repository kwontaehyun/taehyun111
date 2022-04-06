package com.edu.interfaces;

public interface Dao extends RemoteControl, Run{
	
	public void select();
	public void insert();
	public void update();
	public void delete();
}
