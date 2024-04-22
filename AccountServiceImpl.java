package com.bankapp.service;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.entity.Account;
import com.bankapp.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountRepository repo;
	
	@Override
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		Account account_saved=repo.save(account);
		return account_saved;
	}

	@Override
	public  Account getAccountByAccountNo(Integer acc_no) {
		// TODO Auto-generated method stub
		Optional <Account> account_get=repo.findById(acc_no);
		if(account_get.isEmpty())
			throw new RuntimeException("Account not present");
		Account acc_found = account_get.get();
		return acc_found;
	}

	@Override
	public List <Account> getAllAccountDetails() {
		// TODO Auto-generated method stub
		 List <Account> acc_list =repo.findAll();
		return acc_list;
	}

	@Override
	public Account depositAmount(Integer acc_no, Double amount) {
		// TODO Auto-generated method stub
		Optional <Account> acc = repo.findById(acc_no);
		if(acc.isEmpty())
			throw new RuntimeException("Account not present");
		Account acc_found = acc.get();
		acc_found.setBalance(acc_found.getBalance()+amount);
		repo.save(acc_found);
		return acc_found;
	}

	@Override
	public Account withdrawAmount(Integer acc_no, Double amount) {
		// TODO Auto-generated method stub
		Optional<Account> acc = repo.findById(acc_no);
		if(acc.isEmpty())
			throw new RuntimeException("Account not present");
		Account acc_found = acc.get();
		Double bal = acc_found.getBalance()-amount;
		acc_found.setBalance(bal);
		repo.save(acc_found);
		return acc_found;
	}

	@Override
	public void closeAccount(Integer acc_no) {
		// TODO Auto-generated method stub
		repo.deleteById(acc_no);

	}

}
