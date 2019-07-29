package com.scb.gauss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.scb.gauss.common.Utility;
import com.scb.gauss.model.Accounts;

public class AccountsDAOImpl implements AccountsDAO {
	private Statement stmt = null;
	private ResultSet rs = null;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public void Connection() {
		this.conn = Utility.connect();
	}

	@Override
	public List<Accounts> displayAll() {
		String query = "select * from \"Accounts\"";
		List<Accounts> accountList = new ArrayList<Accounts>();
		try {
			this.stmt = this.conn.createStatement();
			this.rs = this.stmt.executeQuery(query);
			while (rs.next()) {
				Accounts a = new Accounts();
				a.setAccountnumber(rs.getInt("Account_Number"));
				a.setCurrency(rs.getString(2));
				a.setBalance(rs.getInt(3));
				a.setCustomerId(rs.getInt(4));
				a.setGroupId(rs.getInt("Group_Id"));
				accountList.add(a);
			}

		} catch (Exception e) {
			System.out.println("Exception in displayAll:" + e.getMessage());
		}
		return accountList;

	}

	@Override
	public Accounts display(int accountnumber) {
		String query ="select * from \"Accounts\" where Account_Number="+accountnumber;
		Accounts a = new Accounts();
		try {
			this.stmt = this.conn.createStatement();
			this.rs = this.stmt.executeQuery(query);
			if (rs.next()) {
				a.setAccountnumber(rs.getInt("Account_Number"));
				a.setCurrency(rs.getString(2));
				a.setBalance(rs.getInt(3));
				a.setCustomerId(rs.getInt(4));
				a.setGroupId(rs.getInt("Group_Id"));
			}

		} catch (Exception e) {
			System.out.println("Exception in displayAll:" + e.getMessage());
		}
		return a;
	}

	@Override
	public int insert(Accounts a) {
		String insertQuery = "insert into \"Accounts\" values (?,?,?,?,?)";
		int insertStatus = 0;
		try {
			pstmt = conn.prepareStatement(insertQuery);
			
			pstmt.setInt(1, a.getAccountnumber());
			pstmt.setString(2, a.getCurrency());
			pstmt.setInt(3, a.getBalance());
			pstmt.setInt(4, a.getCustomerId());
			pstmt.setInt(5, a.getGroupId());

			insertStatus = pstmt.executeUpdate();
		} 
		catch (Exception e) {
			System.out.println("Exception in Insert:" + e.getMessage());
		}

		return insertStatus;
	}

	@Override   
	public int update(int accountnumber, Accounts a) {
		String updateQuery = "update \"Accounts\"set Currency=?, Balance=?, Customer_Id=?,Group_Id=? where Account_Number=?";
		int updateStatus = 0;
		try {
			pstmt = conn.prepareStatement(updateQuery);
			pstmt.setString(1, a.getCurrency());
			pstmt.setInt(2, a.getBalance());
			pstmt.setInt(3, a.getCustomerId());
			pstmt.setInt(4, a.getGroupId());
			pstmt.setInt(5, a.getAccountnumber());
            updateStatus = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Exception in Update:" + e.getMessage());
		}
		return updateStatus;
	}

	@Override
	public int delete(int accountnumber) {
		String deleteQuery = "delete from  \"Accounts\" where Account_Number=?";
		int deleteStatus = 0;
		try {
			pstmt = conn.prepareStatement(deleteQuery);
			pstmt.setInt(1, accountnumber);
			deleteStatus = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Exception in delete:" + e.getMessage());
		}
		return deleteStatus;
	}

}