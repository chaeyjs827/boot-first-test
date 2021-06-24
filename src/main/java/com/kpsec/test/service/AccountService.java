package com.kpsec.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kpsec.test.model.TopCustomer;
import com.kpsec.test.repository.AccountRepository;

@Service
@Transactional
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<TopCustomer> getAccountByBranchCode(String branchCode){
        List<TopCustomer> list = accountRepository.getAccountByBranchCode(branchCode);
        return list;
    }
}
