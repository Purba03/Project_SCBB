package com.scb.guass.controller;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scb.guass.bean.Accounts;
import com.scb.guass.service.AccountsService;;

@RestController
@RequestMapping("account")
public class AccountsController {

	@Autowired
	private AccountsService accService;
	
	static
	{
		System.out.println("controller");
	}

	/* Adding a resource */
	@PostMapping("/add")
	private int add(@RequestBody Accounts acc) {
		
		{
			System.out.println("add");
		}
		return accService.add(acc);
	}

	/* Updating a resource */
	@PutMapping("/update")
	private int update(@RequestBody Accounts acc) {
		return accService.update(acc);
	}

	/* Getting a resource */
	@GetMapping("/{accountnumber}")
	private Accounts get(@PathVariable int accountnumber) {
		return accService.get(accountnumber);
	}

	/* Getting a list of resources */
	@GetMapping("/")
	private Collection<Accounts> list() {
		return accService.list();
	}

	/* Deleting a resource */
	@DeleteMapping("/{accountnumber}")
	private int delete(@PathVariable int accountnumber) {
		return accService.delete(accountnumber);
	}

}

