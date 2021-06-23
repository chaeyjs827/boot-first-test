package com.kpsec.test.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(TransactionHistoryPK.class)
public class TransactionHistory{

	@Id
    private String transactionDate;
    
    private String accountNumber;
    
    @Id
    private String transactionSeq;
    
    private String transactionAmount;
    
    private String transactionFee;
    
    private String transactionVoidYN;
    
}
