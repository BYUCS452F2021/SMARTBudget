package com.example.smartbudget.DAO.relational;

import com.example.smartbudget.DataAcessProxy;
import com.example.smartbudget.Request.CreateBudgetRequest;
import com.example.smartbudget.Request.DeleteBudgetRequest;
import com.example.smartbudget.Request.EditBudgetRequest;
import com.example.smartbudget.Request.EditCategoriesRequest;
import com.example.smartbudget.Request.EditExpendituresRequest;
import com.example.smartbudget.Request.GetStatsRequest;
import com.example.smartbudget.Request.LoadYearRequest;
import com.example.smartbudget.Request.LoginRequest;
import com.example.smartbudget.Request.ReadBudgetRequest;
import com.example.smartbudget.Request.RegisterRequest;
import com.example.smartbudget.Request.ReportDayRequest;
import com.example.smartbudget.Response.CreateBudgetResponse;
import com.example.smartbudget.Response.DeleteBudgetResponse;
import com.example.smartbudget.Response.EditBudgetResponse;
import com.example.smartbudget.Response.EditCategoriesResponse;
import com.example.smartbudget.Response.EditExpendituresResponse;
import com.example.smartbudget.Response.GetStatsResponse;
import com.example.smartbudget.Response.LoadYearResponse;
import com.example.smartbudget.Response.LoginResponse;
import com.example.smartbudget.Response.ReadBudgetResponse;
import com.example.smartbudget.Response.RegisterResponse;
import com.example.smartbudget.Response.ReportDayResponse;

public class DataInSqlDatabase implements DataAcessProxy {
    @Override
    public CreateBudgetResponse createBudget(CreateBudgetRequest request) {
        return null;
    }

    @Override
    public ReadBudgetResponse readBudget(ReadBudgetRequest request) {
        return null;
    }

    @Override
    public DeleteBudgetResponse deleteBudget(DeleteBudgetRequest request) {
        return null;
    }

    @Override
    public EditBudgetResponse editBudget(EditBudgetRequest request) {
        return null;
    }

    @Override
    public LoadYearResponse loadYear(LoadYearRequest request) {
        return null;
    }

    @Override
    public ReportDayResponse reportDay(ReportDayRequest request) {
        return null;
    }

    @Override
    public EditExpendituresResponse editExpenditures(EditExpendituresRequest request) {
        return null;
    }

    @Override
    public GetStatsResponse getStats(GetStatsRequest request) {
        return null;
    }

    @Override
    public EditCategoriesResponse editCategories(EditCategoriesRequest request) {
        return null;
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        return null;
    }

    @Override
    public RegisterResponse register(RegisterRequest request) {
        return null;
    }
}
