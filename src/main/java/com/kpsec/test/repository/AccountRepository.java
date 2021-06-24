package com.kpsec.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kpsec.test.model.TopCustomer;
import com.kpsec.test.model.entity.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

//	@Query(value = "SELECT account_no as accountNo, account_name as accountName FROM account WHERE branch_code = :branchCode", nativeQuery = true)
	@Query(value = "SELECT sub.transaction_year AS YEAR, MAX(sub.account_name) AS name , MAX(sub.account_no) AS accNo,  MAX(sub.sumAmt) AS sumAmt\n" + 
			"FROM (\n" + 
			"SELECT YEAR(t.transaction_date) AS transaction_year, t.account_no, acc.account_name, SUM(t.transaction_amount-t.transaction_fee) AS sumAmt\n" + 
			"FROM account acc\n" + 
			"JOIN transaction_history t ON acc.account_no = t.account_no\n" + 
			"WHERE t.transaction_voidYN = 'N'\n" + 
			"GROUP BY t.account_no, YEAR(t.transaction_date)\n" + 
			") AS sub\n" + 
			"GROUP BY sub.transaction_year;", nativeQuery = true)
//    @Query(value = "SELECT * FROM account", nativeQuery = true)
    List<TopCustomer> getAccountByBranchCode(@Param("branchCode") String branchCode);

}
