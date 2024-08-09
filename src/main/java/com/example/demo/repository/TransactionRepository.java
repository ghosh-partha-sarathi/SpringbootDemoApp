package com.example.demo.repository;

import java.util.List;
import com.example.demo.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    public List<Transaction> findTop10ByAccountIdOrderByTxnTimestampDesc(String accountId);
}
