package com.example.smartbudget.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartbudget.DataCache;
import com.example.smartbudget.Model.Expenditure;
import com.example.smartbudget.Presenter.ExpenditureListForDayPresenter;
import com.example.smartbudget.R;
import com.example.smartbudget.Response.DeleteExpenditureResponse;
import com.example.smartbudget.Response.GetExpenditureForDayResponse;
import com.example.smartbudget.ServerProxy;
import com.example.smartbudget.Utils;

import java.util.ArrayList;
import java.util.List;

public class ViewDaysExpendituresActivity extends SmartBudgetActivity implements ListItemClickListener, ExpenditureListForDayPresenter.ExpenditureListForDayView, PopupMenu.OnMenuItemClickListener {
    private RecyclerView expenditureView;
    private ExpenditureAdapter adapter;
    private List<Expenditure> expenditures;

    private ExpenditureListForDayPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_days_expenditures);

        presenter = new ExpenditureListForDayPresenter(this);
        presenter.getExpendituresForDay(DataCache.getInstance().getBudget());

        DataCache.getInstance().setCurrExpenditures(new ArrayList<>());
        expenditures = DataCache.getInstance().getCurrExpenditures();

        Button addExpenditureBtn = findViewById(R.id.add_expenditure);
        addExpenditureBtn.setOnClickListener(v->launchActivity(AddExpenditureActivity.class));

        expenditureView = findViewById(R.id.expenditure_day_view);
        adapter = new ExpenditureAdapter(DataCache.getInstance().getCurrExpenditures(), this);
        expenditureView.setAdapter(adapter);
        expenditureView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.expenditure_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.expenditure_done_btn) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void launchActivity(Class<?> activityClass){
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }

    @Override
    public void onListItemClick(int position) {
        // TODO edit budget activity
    }

    @Override
    public void onLongItemClick(int position, View view) {
        Utils.showPopup(this, view, R.menu.delete_menu, this);
    }

    @Override
    public void listFetched(GetExpenditureForDayResponse response) {
        if (response.isSuccess()) {
            DataCache.getInstance().updateExpenditures(response.getExpenditures());
            if (ServerProxy.usingServerSide()){
                runOnUiThread(()->{adapter.notifyItemRangeInserted(0, expenditures.size());});
            }
            else {
                adapter.notifyItemRangeInserted(0, expenditures.size());
            }
        }
    }

    @Override
    public void expenditureDeleted(DeleteExpenditureResponse response) {
        if (response.isSuccess()) {
            int pos = expenditures.indexOf(DataCache.getInstance().getCurrExpenditure());
            expenditures.remove(pos);
            runOnUiThread(()->{adapter.notifyItemRemoved(pos);});
        }
        else {
            Toast.makeText(this, "Failed to delete expenditure", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if (item.getItemId() == R.id.delete_menu_option){
            presenter.deleteExpenditure(DataCache.getInstance().getCurrExpenditure());
        }
        return false;
    }
}

class ExpenditureAdapter extends RecyclerView.Adapter<ExpenditureAdapter.ExpenditureViewHolder> {
    private List<Expenditure> expenditures;
    private ListItemClickListener listener;

    protected static class ExpenditureViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        public TextView categoryDisplay;
        public TextView descriptionDisplay;
        public TextView amountDisplay;
        public ListItemClickListener listener;
        public ExpenditureViewHolder(View itemView, ListItemClickListener listener) {
            super(itemView);
            categoryDisplay = itemView.findViewById(R.id.expenditure_category_view);
            descriptionDisplay = itemView.findViewById(R.id.expenditure_description_view);
            amountDisplay = itemView.findViewById(R.id.expenditure_amount_view);
            this.listener = listener;
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onListItemClick(getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View v) {
            DataCache.getInstance().setCurrExpenditure(getAdapterPosition());
            listener.onLongItemClick(getAdapterPosition(), v);
            return false;
        }
    }

    public ExpenditureAdapter(List<Expenditure> expenditures, ListItemClickListener listener) {
        this.expenditures = expenditures;
        this.listener = listener;
    }

    @Override
    public ExpenditureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflator = LayoutInflater.from(context);

        View expenditureView = inflator.inflate(R.layout.expenditure_item_detail, parent, false);

        ExpenditureViewHolder v  = new ExpenditureViewHolder(expenditureView, listener);
        return v;
    }

    @Override
    public void onBindViewHolder(ExpenditureViewHolder holder, int position) {
        Expenditure expenditure = expenditures.get(position);
        holder.descriptionDisplay.setText(expenditure.getDescription());
        holder.amountDisplay.setText(String.format("$%.2f", expenditure.getAmount()));
        holder.categoryDisplay.setText(expenditure.getCategory().getName());
    }

    @Override
    public int getItemCount() {
        return expenditures.size();
    }
}