package com.financetracker.full;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    AppDatabase db;
    TransactionDao dao;

    EditText amountInput, descInput;
    Spinner categoryInput;
    Button addBtn;
    RecyclerView list;
    TransactionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "finance.db").allowMainThreadQueries().build();
        dao = db.transactionDao();

        amountInput = findViewById(R.id.amount);
        descInput = findViewById(R.id.description);
        categoryInput = findViewById(R.id.category);
        addBtn = findViewById(R.id.addBtn);

        list = findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this));

        loadList();

        addBtn.setOnClickListener(v -> {
            Transaction t = new Transaction();
            t.amount = Double.parseDouble(amountInput.getText().toString());
            t.description = descInput.getText().toString();
            t.category = categoryInput.getSelectedItem().toString();
       	    t.timestamp = System.currentTimeMillis();
            dao.insert(t);
            loadList();
        });
    }

    void loadList() {
        List<Transaction> data = dao.getAll();
        adapter = new TransactionAdapter(data);
        list.setAdapter(adapter);
    }
}
