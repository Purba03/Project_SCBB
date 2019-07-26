

	package com.scb.guass.service;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.scb.guass.dao.AccountsDAO;
	import com.scb.guass.bean.Accounts;

	@Service
	public class AccountsServiceImpl implements AccountsService {

		@Autowired
		private AccountsDAO accountDao;

		@Override
		public int add(Accounts acc) {
			return accountDao.add(acc);
		}

		@Override
		public int update(Accounts acc) {
			return accountDao.update(acc);
		}

		@Override
		public Accounts get(int accountnumber) {
			return accountDao.get(accountnumber);
		}

		@Override
		public List<Accounts> list() {
			return accountDao.list();
		}

		@Override
		public int delete(int accountnumber) {
			return accountDao.delete(accountnumber);
		}

	}
