package com.scb.guass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//import com.scb.guass.bean.Accounts;
//import com.scb.guass.service.AccountsService;

@SpringBootApplication
@ComponentScan("com.scb.*")
public class SpringLiquidityProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringLiquidityProjectApplication.class, args);

		}

}
