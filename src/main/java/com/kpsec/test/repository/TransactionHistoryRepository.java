package com.kpsec.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kpsec.test.model.TransactionHistoryResult;
import com.kpsec.test.model.entity.TransactionHistory;

public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, String> {

    @Query(value = "SELECT account_no as accountNo, account_name as accountName FROM account WHERE branch_code = :branchCode", nativeQuery = true)
    List<TransactionHistoryResult> getTransactionHistoryByAccountNumber(@Param("branchCode") String branchCode);


}
