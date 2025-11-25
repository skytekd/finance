package com.financetracker.full;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Transaction {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String category;
    public double amount;
    public String description;
    public long timestamp;
}
