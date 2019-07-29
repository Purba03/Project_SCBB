package com.scb.gauss.controller;

import java.util.ArrayList;
import java.util.List;

import com.scb.gauss.common.Utility;
import com.scb.gauss.dao.AccountsDAO;
import com.scb.gauss.dao.AccountsDAOImpl;
import com.scb.gauss.model.Accounts;

public class Starter {

	public static void main(String[] args) {

		AccountsDAO accountDAO = new AccountsDAOImpl();

		accountDAO.Connection();
		// Insert Operation
		Accounts a = new Accounts();
		
		a.setAccountnumber(10020);
		a.setCurrency("Rupee");
		a.setBalance(999999009);
		a.setCustomerId(4006);
		a.setGroupId(601);
		int insertStatus = 0;
		insertStatus = accountDAO.insert(a);
		if (insertStatus > 0) {
			System.out.println("Successfully Inserted");
		}

		// Display All Operation
		List<Accounts> accountList = new ArrayList<Accounts>();
		accountList = accountDAO.displayAll();
		System.out.println("Displaying ALL Records");
		System.out.println("___________________________________________");
		for (Accounts acct : accountList) {
			System.out.println(acct);
		}

		// Update Operation
		a.setAccountnumber(10003);
		a.setCurrency("Dhiram");
		a.setBalance(92309);
		a.setCustomerId(4006);
		a.setGroupId(602);
		
		
		int updateStatus = 0;
		updateStatus = accountDAO.update(10020, a);
		if (updateStatus > 0) {
			System.out.println("Successfully Updated");
		}
		// Display One
		Accounts a1 = accountDAO.display(10020);
		System.out.println("Displaing a single Record");
		System.out.println(a1);

		// Delete Operation
		int deleteStatus = 0;
		deleteStatus = accountDAO.delete(10010);
		if (deleteStatus > 0) {
			System.out.println("Successfully deleted");
		}

		Utility.closeResources();
	}

}