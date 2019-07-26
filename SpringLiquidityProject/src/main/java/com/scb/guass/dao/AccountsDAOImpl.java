package com.scb.guass.dao;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.scb.guass.bean.Accounts;

@Repository
public  class AccountsDAOImpl implements AccountsDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	@Override
	public int update(Accounts acc) {
		String query = "update  \"accounts\"set  currency = ?,balance=?,customerId=?,groupId=? where accountnumber=?";
		int row = jdbcTemplate.update(query,acc.getCurrency(), acc.getBalance(),acc.getCustomerId(),acc.getGroupId(), acc.getAccountnumber());

		return row;
	}

	@Override
	public Accounts get(int accountnumber) {
		String query = "select *from  \"accounts\" where accountnumber = ?";
		return jdbcTemplate.queryForObject(query, new Object[] { accountnumber }, new StudentMapper());
	}

	public List<Accounts> list() {
		String query = "select * from \"accounts\"";
		return jdbcTemplate.query(query, new StudentMapper());

	}

	class StudentMapper implements RowMapper<Accounts> {

		@Override
		public Accounts mapRow(ResultSet rs, int rowNum) throws SQLException {
			Accounts acc = new Accounts();
			acc.setAccountnumber(rs.getInt("accountnumber"));
			acc.setCurrency(rs.getString("currency"));
			acc.setBalance(rs.getInt("balance"));
			acc.setCustomerId(rs.getInt("customerid"));
			acc.setGroupId(rs.getInt("groupid"));

			return acc;
		}

	}

	@Override
	public int delete(int accountnumber) {
		String query = "delete from \"accounts\" where accountnumber = ?";
		int row = jdbcTemplate.update(query, accountnumber);

		return row;
	}

	@Override
	public int add(Accounts acc) {
		// TODO Auto-generated method stub
		String query = "insert into \"accounts\"(accountnumber,currency,balance,customerid,groupid) VALUES(?,?,?,?,?)";
		return jdbcTemplate.update(query, new Object[]{
				acc.getAccountnumber(), acc.getCurrency(),acc.getBalance(),acc.getCustomerId(),acc.getGroupId()
		});
	}

}

