package com.kpsec.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kpsec.test.model.BranchMigrationResult;
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

    public List<BranchMigrationResult> getBranchMigration(String branchName){
    	List<BranchMigrationResult> list = accountRepository.getBranchMigration(branchName);
    	return list;
    }
}
