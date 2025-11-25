package com.financetracker.full;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.Holder> {

    List<Transaction> data;

    public TransactionAdapter(List<Transaction> d) { data = d; }

    public static class Holder extends RecyclerView.ViewHolder {
        TextView amount, desc, cat;
        public Holder(View v) {
            super(v);
            amount = v.findViewById(R.id.item_amount);
            desc = v.findViewById(R.id.item_desc);
            cat = v.findViewById(R.id.item_cat);
        }
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_transaction, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(Holder h, int i) {
        Transaction t = data.get(i);
        h.amount.setText(t.amount + "€");
        h.desc.setText(t.description);
        h.cat.setText(t.category);
    }

    @Override
    public int getItemCount() { return data.size(); }
}
