package com.example.smartbudget.Presenter;

import com.example.smartbudget.Model.Budget;
import com.example.smartbudget.Model.Expenditure;
import com.example.smartbudget.Model.User;
import com.example.smartbudget.Request.AddBudgetRequest;
import com.example.smartbudget.Request.AddExpenditureRequest;
import com.example.smartbudget.Request.GetCategoriesRequest;
import com.example.smartbudget.Response.AddBudgetResponse;
import com.example.smartbudget.Response.AddExpenditureResponse;
import com.example.smartbudget.Response.DeleteCategoryResponse;
import com.example.smartbudget.Response.GetCategoriesResponse;
import com.example.smartbudget.Runnable.AddBudgetRunnable;
import com.example.smartbudget.Runnable.AddExpenditureRunnable;
import com.example.smartbudget.Runnable.GetCategoriesRunnable;

public class AddExpenditurePresenter implements GetCategoriesPresenter {
    public interface AddExpenditureView{
        void expenditureAdded(AddExpenditureResponse response);
        void categoriesLoaded(GetCategoriesResponse response);
    }

    private AddExpenditureView view;

    public AddExpenditurePresenter(AddExpenditureView view) {
        this.view = view;
    }

    public void addExpenditure(Expenditure expenditure, User user){
        AddExpenditureRequest request = new AddExpenditureRequest(expenditure, user);
        AddExpenditureRunnable runnable = new AddExpenditureRunnable(this, request);
        new Thread(runnable).start();
    }

    public void expenditureAdded(AddExpenditureResponse response){
        view.expenditureAdded(response);
    }

    public void getCategories(Budget budget){
        GetCategoriesRequest request = new GetCategoriesRequest(budget);
        GetCategoriesRunnable runnable = new GetCategoriesRunnable(this, request);
        new Thread(runnable).start();
    }

    @Override
    public void categoriesLoaded(GetCategoriesResponse response){
        view.categoriesLoaded(response);
    }

    @Override
    public void categoryDeleted(DeleteCategoryResponse response) {

    }
}
