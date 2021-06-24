package com.kpsec.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kpsec.test.model.NonServiceCustomerResult;
import com.kpsec.test.model.TopCustomerResult;
import com.kpsec.test.model.entity.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

	@Query(value = "select transaction_year as year,account_name as name, account_no as accNo, a.sumAmt as sumAmt\n" + 
			"from \n" + 
			"   (SELECT YEAR(t.transaction_date) AS transaction_year, t.account_no, acc.account_name, SUM(t.transaction_amount-t.transaction_fee) AS sumAmt\n" + 
			"   FROM account acc\n" + 
			"   JOIN transaction_history t ON acc.account_no = t.account_no\n" + 
			"   WHERE t.transaction_voidYN = 'N'\n" + 
			"   GROUP BY t.account_no, YEAR(t.transaction_date)\n" + 
			"   ) as a ,\n" + 
			"   (SELECT max(sumAmt) as sumAmt\n" + 
			"   FROM (\n" + 
			"      SELECT YEAR(t.transaction_date) AS transaction_year, t.account_no, acc.account_name, SUM(t.transaction_amount-t.transaction_fee) AS sumAmt\n" + 
			"      FROM account acc\n" + 
			"      JOIN transaction_history t ON acc.account_no = t.account_no\n" + 
			"      WHERE t.transaction_voidYN = 'N'\n" + 
			"      GROUP BY t.account_no, YEAR(t.transaction_date)\n" + 
			"      ) as sub\n" + 
			"   group by transaction_year) as b \n" + 
			"where b.sumAmt = a.sumAmt\n" + 
			"order by transaction_year;", nativeQuery = true)
    List<TopCustomerResult> getTopCustomerOfYear(@Param("branchCode") String branchCode);
	
	@Query(value = "select COALESCE(ty, 2018) as year, account.account_no as accNo , account.account_name as name \n" + 
			"from account left join \n" + 
			"   ( select distinct account_no , YEAR(transaction_date) as ty\n" + 
			"   from transaction_history\n" + 
			"   where transaction_voidYN = 'N' AND YEAR(transaction_date) in(2018) ) as b   \n" + 
			"    on account.account_no=b.account_no\n" + 
			"where b.account_no is null\n" + 
			"union   \n" + 
			"select COALESCE(ty, 2019) as year, account.account_no , account.account_name\n" + 
			"from account left join \n" + 
			"   ( select distinct account_no , YEAR(transaction_date) as ty\n" + 
			"   from transaction_history\n" + 
			"   where transaction_voidYN = 'N' AND YEAR(transaction_date) in(2019) ) as b   \n" + 
			"    on account.account_no=b.account_no\n" + 
			"where b.account_no is null    ", nativeQuery = true)
	List<NonServiceCustomerResult> getNonServiceCustomer();

}
