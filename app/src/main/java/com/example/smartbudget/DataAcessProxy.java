package com.example.smartbudget;

import com.example.smartbudget.Model.Budget;
import com.example.smartbudget.Model.Category;
import com.example.smartbudget.Model.Expenditure;
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

import java.util.Set;

public interface DataAcessProxy {
    CreateBudgetResponse createBudget(CreateBudgetRequest request);
    ReadBudgetResponse readBudget(ReadBudgetRequest request);
    DeleteBudgetResponse deleteBudget(DeleteBudgetRequest request);
    EditBudgetResponse editBudget(EditBudgetRequest request);
    LoadYearResponse loadYear(LoadYearRequest request);
    ReportDayResponse reportDay(ReportDayRequest request);
    EditExpendituresResponse editExpenditures(EditExpendituresRequest request);
    GetStatsResponse getStats(GetStatsRequest request);
    EditCategoriesResponse editCategories(EditCategoriesRequest request);
    LoginResponse login(LoginRequest request);
    RegisterResponse register(RegisterRequest request);
}
