package com.bankapp.service;

import java.util.List;

import com.bankapp.entity.Account;

public interface AccountService {

	public Account createAccount(Account account);
	public Account getAccountByAccountNo(Integer acc_no);
	public List <Account> getAllAccountDetails();
	public Account depositAmount(Integer acc_no, Double amount);
	public Account withdrawAmount(Integer acc_no, Double amount);
	public void closeAccount(Integer acc_no);
}
