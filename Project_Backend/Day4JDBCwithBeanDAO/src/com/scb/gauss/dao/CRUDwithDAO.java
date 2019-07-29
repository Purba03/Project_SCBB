package com.scb.gauss.dao;

import java.util.List;

import com.scb.gauss.model.Accounts;

public interface CRUDwithDAO {
	public List<Accounts> displayAll();
	public Accounts display(int accountnumber);
	public int insert(Accounts a);
	public int update(int accountnumber, Accounts a);
	public int delete(int accountnumber);
}