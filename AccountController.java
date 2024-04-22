package com.bankapp.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.entity.Account;
import com.bankapp.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountService service;
	
	@PostMapping("/create")
	public ResponseEntity <Account> createAccount(@RequestBody Account account)
	{
		Account createAccount= service.createAccount(account);
		return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
	}
	
	@GetMapping("/{acc_no}")
	public Account getAccountByAccountNo(@PathVariable Integer acc_no)
	{
		Account getaccount=service.getAccountByAccountNo(acc_no);
		return getaccount;
	}
	
	@GetMapping("/read")
	public List <Account> getAllAccountDetails() {
		
		 List <Account> acc_list = service.getAllAccountDetails();
		return acc_list;
	}
	
	@PutMapping("/deposit/{acc_no}/{amount}")
	public Account depositAmount(@PathVariable Integer acc_no,@PathVariable Double amount) {
		// TODO Auto-generated method stub
		Account acc = service.depositAmount(acc_no, amount);
		return acc;
	}
	
	@PutMapping("/withdraw/{acc_no}/{amount}")
	public Account withdrawAmount(@PathVariable Integer acc_no,@PathVariable Double amount) {
		// TODO Auto-generated method stub
		Account acc=service.withdrawAmount(acc_no, amount);
		return acc;
	}
	
	@DeleteMapping("/delete/{acc_no}")
	public ResponseEntity<String> closeAccount(@PathVariable Integer acc_no) {
		// TODO Auto-generated method stub
		service.closeAccount(acc_no);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Account closed");

	}

}
