package com.example.smartbudget.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartbudget.DataCache;
import com.example.smartbudget.Model.Category;
import com.example.smartbudget.Presenter.CategoryListPresenter;
import com.example.smartbudget.R;
import com.example.smartbudget.Response.GetCategoriesResponse;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class SelectCategoryActivity extends SmartBudgetActivity implements ListItemClickListener, CategoryListPresenter.CategoryListView {

    private RecyclerView categoryView;
    private RecyclerView.Adapter<CategoryAdapter.ViewHolder> adapter;
    private List<Category> categories;

    private CategoryListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_category);

        presenter = new CategoryListPresenter(this);
        presenter.getCategories(DataCache.getInstance().getBudget());

        DataCache.getInstance().setCurrCategories(new ArrayList<>());
        categories = DataCache.getInstance().getCurrCategories();

        categoryView = findViewById(R.id.category_view);
        adapter = new CategoryAdapter(categories, this);

        categoryView.setAdapter(adapter);
        categoryView.setLayoutManager(new LinearLayoutManager(this));


        FloatingActionButton addCategoryButton = findViewById(R.id.add_category_btn);
        addCategoryButton.setOnClickListener(v->launchCreateCategoryActivity());
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onListItemClick(int position) {

    }

    @Override
    public void onLongItemClick(int position, View view) {

    }

    @Override
    public void listFetched(GetCategoriesResponse response) {
        if (response.isSuccess()) {
            DataCache.getInstance().updateCategories(response.getCategories());
            adapter.notifyItemRangeInserted(0, categories.size());
        }
    }

    private void launchCreateCategoryActivity(){
        Intent intent = new Intent(this, AddCategoryActivity.class);
        startActivity(intent);
    }
}

//interface ListItemClickListener{
//    void onListItemClick(int position);
//}

class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private List<Category> categories;
    final private ListItemClickListener listener;

    public CategoryAdapter(List<Category> categories, ListItemClickListener listener) {
        this.categories = categories;
        this.listener = listener;
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
        public TextView categoryTextView;
        public TextView categoryGoalView; // FIXME maybe change to allotment
        private ListItemClickListener listener;
        public ViewHolder(View itemView, ListItemClickListener listener){
            super(itemView);
            this.listener = listener;
            categoryTextView = itemView.findViewById(R.id.budget_name_view);
            categoryGoalView = itemView.findViewById(R.id.budget_goal_view);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onListItemClick(getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View v) {

            return true;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflator = LayoutInflater.from(context);

        View budgetView = inflator.inflate(R.layout.budget_item_detail, parent, false); // FIXME maybe to a new xml file

        ViewHolder v = new ViewHolder(budgetView, listener);
        return v;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Category category = categories.get(position);

        holder.categoryTextView.setText(category.getName());
        holder.categoryGoalView.setText("$" + category.getAllotment());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }


}
