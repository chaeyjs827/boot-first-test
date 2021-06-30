package com.kpsec.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kpsec.test.model.AccountResult;
import com.kpsec.test.model.BranchMigrationResult;
import com.kpsec.test.model.BranchTotalAmountResult;
import com.kpsec.test.model.NonServiceCustomerResult;
import com.kpsec.test.model.TopCustomerResult;
import com.kpsec.test.repository.AccountRepository;

@Service
@Transactional
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<TopCustomerResult> getTopCustomerOfYear(String branchCode){
        List<TopCustomerResult> list = accountRepository.getTopCustomerOfYear(branchCode);
        return list;
    }

    public List<NonServiceCustomerResult> getNonServiceCustomer(){
    	List<NonServiceCustomerResult> list = accountRepository.getNonServiceCustomer();
    	return list;
    }

    public List<BranchTotalAmountResult> getBranchTotalAmountByYear(){
    	List<BranchTotalAmountResult> list = accountRepository.getBranchTotalAmountByYear();
    	return list;
    }
    
    public List<BranchMigrationResult> getBranchMigration(String branchName){
    	List<BranchMigrationResult> list = new ArrayList<>();
		list = accountRepository.getBranchMigration(branchName);
    	return list;
    }
    
    public List<AccountResult> findByAccountName(String accountName){
    	List<AccountResult> list = accountRepository.findByAccountName(accountName);
    	return list;
    }
    
    public List<AccountResult> findByAccountNameAndBranchCodeAndAccountNo(String accountName, String accountNo, String branchCode){
    	List<AccountResult> list = accountRepository.findByAccountNameAndBranchCodeAndAccountNo(accountName, branchCode, accountNo);
    	return list;
    }
}
