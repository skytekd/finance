package com.financetracker.full;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TransactionDao {
    @Insert
    void insert(Transaction t);

    @Query("SELECT * FROM `Transaction` ORDER BY timestamp DESC")
    List<Transaction> getAll();
}
