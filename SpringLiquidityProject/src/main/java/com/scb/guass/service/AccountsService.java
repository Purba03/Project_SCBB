package com.scb.guass.service;

import java.util.List;

import com.scb.guass.bean.Accounts;

public interface AccountsService {
   public int add(Accounts acc);
	public int update( Accounts acc);
	public Accounts get(int accountnumber);
	public List<Accounts> list();
	public int delete(int accountnumber);
}








