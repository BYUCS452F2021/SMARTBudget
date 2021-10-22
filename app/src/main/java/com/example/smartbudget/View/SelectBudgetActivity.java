package com.example.smartbudget.View;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartbudget.DataCache;
import com.example.smartbudget.Model.Budget;
import com.example.smartbudget.R;

import java.util.ArrayList;
import java.util.List;

public class SelectBudgetActivity extends SmartBudgetActivity implements ListItemClickListener{

    RecyclerView budgetView;
    RecyclerView.Adapter<BudgetAdapter.ViewHolder> adapter;
    List<Budget> budgets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_budget);

        // TODO load from actual database
        budgets = new ArrayList<>();
        budgets.add(new Budget("Jimmy's Budget", 1000.0));
        budgets.add(new Budget("Test", 2500.0));
        budgets.add(new Budget("Eureka", 0.0));

        budgetView = findViewById(R.id.budget_view);
        adapter = new BudgetAdapter(budgets, this);

        budgetView.setAdapter(adapter);
        budgetView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onListItemClick(int position) {
        DataCache.getInstance().setBudget(budgets.get(position));
        Toast.makeText(this, "Success: " + position, Toast.LENGTH_LONG).show();
        // TODO launch budget activity
    }
}

interface ListItemClickListener{
    void onListItemClick(int position);
}

class BudgetAdapter extends RecyclerView.Adapter<BudgetAdapter.ViewHolder> {
    private List<Budget> budgets;
    final private ListItemClickListener listener;

    public BudgetAdapter(List<Budget> budgets, ListItemClickListener listener) {
        this.budgets = budgets;
        this.listener = listener;
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView budgetTextView;
        public TextView budgetGoalView;
        private ListItemClickListener listener;
        public ViewHolder(View itemView, ListItemClickListener listener){
            super(itemView);
            this.listener = listener;
            budgetTextView = itemView.findViewById(R.id.budget_name_view);
            budgetGoalView = itemView.findViewById(R.id.budget_goal_view);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onListItemClick(getAdapterPosition());
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflator = LayoutInflater.from(context);

        View budgetView = inflator.inflate(R.layout.budget_item_detail, parent, false);

        ViewHolder v = new ViewHolder(budgetView, listener);
        return v;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Budget budget = budgets.get(position);

        holder.budgetTextView.setText(budget.getName());
        holder.budgetGoalView.setText("$" + budget.getSpendingGoal());
    }

    @Override
    public int getItemCount() {
        return budgets.size();
    }
}