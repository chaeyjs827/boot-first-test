package com.legacy.infra;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.legacy.entity.Account;
import com.legacy.entity.Branch;
import com.legacy.entity.TransactionHistory;
import com.legacy.repository.AccountRepository;
import com.legacy.repository.BranchRepository;
import com.legacy.repository.TransactionHistoryRepository;

@Component
public class InitData {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    BranchRepository branchRepository;
    
    @Autowired
    TransactionHistoryRepository transactionRepository;
    
    @PostConstruct
    private void initAccount() throws IOException {
        if (accountRepository.count() == 0) {
            Resource resource = new ClassPathResource("account_info.csv");
            List<Account> accountList = Files.readAllLines(resource.getFile().toPath(), StandardCharsets.UTF_8)
                    .stream().skip(1).map(line -> {
                        String[] split = line.split(",");
                        return Account.builder().accountNo(split[0]).accountName(split[1]).branchCode(split[2])
                                .build();
                    }).collect(Collectors.toList());
            accountRepository.saveAll(accountList);
        }
    }
    
    @PostConstruct
    private void initBranch() throws IOException {
    	if(branchRepository.count() == 0) {
    		Resource resource = new ClassPathResource("branch_info.csv");
    		List<Branch> branchList = Files.readAllLines(resource.getFile().toPath(), StandardCharsets.UTF_8)
                    .stream().skip(1).map(line -> {
                        String[] split = line.split(",");
                        return Branch.builder().branchCode(split[0]).branchName(split[1]).build();
                    }).collect(Collectors.toList());
    		branchRepository.saveAll(branchList);
    	}
    }
    
    @PostConstruct
    private void initTransactionHistory() throws IOException {
    	if(transactionRepository.count() == 0) {
    		Resource resource = new ClassPathResource("transaction_history.csv");
    		List<TransactionHistory> transactionList = Files.readAllLines(resource.getFile().toPath(), StandardCharsets.UTF_8)
                    .stream().skip(1).map(line -> {
                        String[] split = line.split(",");
                        return TransactionHistory.builder().transactionDate(split[0]).accountNo(split[1]).transactionSeq(split[2])
                        		.transactionAmount(Integer.parseInt(split[3])).transactionFee(Integer.parseInt(split[4])).transactionVoidYN(split[5]).build();
                    }).collect(Collectors.toList());
    		transactionRepository.saveAll(transactionList);
    	}
    }
}
