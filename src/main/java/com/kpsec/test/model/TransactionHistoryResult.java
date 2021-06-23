package com.kpsec.test.model;

public interface TransactionHistoryResult {
	String getTransactionDate();
	String getAccountNumber();
	String getTransactionSeq();
	String getTransactionAmount();
	String getTransactionFee();
	String getTransactionVoidYN();
}
