package com.example.smartbudget.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartbudget.DataCache;
import com.example.smartbudget.Model.Budget;
import com.example.smartbudget.Presenter.BudgetListPresenter;
import com.example.smartbudget.R;
import com.example.smartbudget.Response.DeleteBudgetResponse;
import com.example.smartbudget.Response.GetBudgetResponse;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class SelectBudgetActivity extends SmartBudgetActivity implements ListItemClickListener, BudgetListPresenter.BudgetListView, PopupMenu.OnMenuItemClickListener {

    private RecyclerView budgetView;
    private RecyclerView.Adapter<BudgetAdapter.ViewHolder> adapter;
    private List<Budget> budgets;

    private BudgetListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_budget);

        presenter = new BudgetListPresenter(this);
        presenter.getBudgets(DataCache.getInstance().getCurrUser());

        DataCache.getInstance().setCurrBudgets(new ArrayList<>());
        budgets = DataCache.getInstance().getCurrBudgets();

        budgetView = findViewById(R.id.budget_view);
        adapter = new BudgetAdapter(budgets, this);

        budgetView.setAdapter(adapter);
        budgetView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton addBudgetButton = findViewById(R.id.add_budget_btn);
        addBudgetButton.setOnClickListener(v->launchCreateBudgetActivity());
    }

    public void showPopup(View v, int rMenu, PopupMenu.OnMenuItemClickListener context){
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(context);
        popup.inflate(rMenu);
        popup.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onListItemClick(int position) {
        DataCache.getInstance().setBudget(position);
        launchBudgetDashboardActivity();
    }

    @Override
    public void onLongItemClick(int position, View view) {
        DataCache.getInstance().setBudget(position);
        showPopup(view, R.menu.edit_menu, this);
    }

    @Override
    public void listFetched(GetBudgetResponse response) {
        if (response.isSuccess()) {
            DataCache.getInstance().updateBudgets(response.getBudgets());
            adapter.notifyItemRangeInserted(0, budgets.size());
        }
    }

    @Override
    public void budgetDeleted(DeleteBudgetResponse response) {
        if (response.isSuccess()){
            int pos = budgets.indexOf(DataCache.getInstance().getBudget());
            budgets.remove(pos);
            runOnUiThread(()->{adapter.notifyItemRemoved(pos);});
        }
        else {
            Toast.makeText(this, "Failed to delete", Toast.LENGTH_SHORT).show();
        }
    }

    private void launchCreateBudgetActivity(){
        Intent intent = new Intent(this, AddBudgetActivity.class);
        startActivity(intent);
    }

    private void launchBudgetDashboardActivity(){
        Intent intent = new Intent(this, MainBudgetDashboardActivity.class);
        startActivity(intent);
    }

    private void launchUpdateBudgetActivity(){
        Intent intent = new Intent(this, UpdateBudgetActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if (item.getItemId() == R.id.delete_option){
            presenter.deleteBudget(DataCache.getInstance().getBudget());
            return true;
        }
        else if (item.getItemId() == R.id.update_option){
            launchUpdateBudgetActivity();
            return true;
        }
        return false;
    }
}

interface ListItemClickListener{
    void onListItemClick(int position);
    void onLongItemClick(int position, View view);
}

class BudgetAdapter extends RecyclerView.Adapter<BudgetAdapter.ViewHolder> {
    private List<Budget> budgets;
    final private ListItemClickListener listener;

    public BudgetAdapter(List<Budget> budgets, ListItemClickListener listener) {
        this.budgets = budgets;
        this.listener = listener;
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
        public TextView budgetTextView;
        public TextView budgetGoalView;
        private ListItemClickListener listener;
        public ViewHolder(View itemView, ListItemClickListener listener){
            super(itemView);
            this.listener = listener;
            budgetTextView = itemView.findViewById(R.id.budget_name_view);
            budgetGoalView = itemView.findViewById(R.id.budget_goal_view);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onListItemClick(getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View v) {
            listener.onLongItemClick(getAdapterPosition(), v);
            return true;
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
        holder.budgetGoalView.setText("$" + budget.calcSpendingGoal());
    }

    @Override
    public int getItemCount() {
        return budgets.size();
    }


}