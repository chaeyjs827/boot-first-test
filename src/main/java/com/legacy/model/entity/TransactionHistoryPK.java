package com.legacy.model.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class TransactionHistoryPK implements Serializable {
	private String transactionSeq;
	private String transactionDate;
}
