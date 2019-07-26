package com.scb.guass.dao;
import com.scb.guass.bean.Accounts;
import java.util.List;



public interface AccountsDAO {

	//public void Connection();
     public int delete(int accountnumber);
     int update(Accounts acc);
      Accounts get(int accountnumber);
        List<Accounts> list();
         int add(Accounts acc);
}