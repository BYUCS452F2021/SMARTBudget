package com.example.smartbudget;

import com.example.smartbudget.Request.AddBudgetRequest;
import com.example.smartbudget.Request.AddExpenditureRequest;
import com.example.smartbudget.Request.AddCategoryRequest;
import com.example.smartbudget.Request.DeleteBudgetRequest;
import com.example.smartbudget.Request.DeleteCategoryRequest;
import com.example.smartbudget.Request.DeleteExpenditureRequest;
import com.example.smartbudget.Request.UpdateBudgetRequest;
import com.example.smartbudget.Request.EditCategoriesRequest;
import com.example.smartbudget.Request.EditExpendituresRequest;
import com.example.smartbudget.Request.GetBudgetsRequest;
import com.example.smartbudget.Request.GetExpendituresForDayRequest;
import com.example.smartbudget.Request.GetCategoriesRequest;
import com.example.smartbudget.Request.GetStatsRequest;
import com.example.smartbudget.Request.LoadYearRequest;
import com.example.smartbudget.Request.LoginRequest;
import com.example.smartbudget.Request.ReadBudgetRequest;
import com.example.smartbudget.Request.RegisterRequest;
import com.example.smartbudget.Request.ReportDayRequest;
import com.example.smartbudget.Response.AddBudgetResponse;
import com.example.smartbudget.Response.AddExpenditureResponse;
import com.example.smartbudget.Response.AddCategoryResponse;
import com.example.smartbudget.Response.DeleteBudgetResponse;
import com.example.smartbudget.Response.DeleteCategoryResponse;
import com.example.smartbudget.Response.DeleteExpenditureResponse;
import com.example.smartbudget.Response.UpdateBudgetResponse;
import com.example.smartbudget.Response.EditCategoriesResponse;
import com.example.smartbudget.Response.EditExpendituresResponse;
import com.example.smartbudget.Response.GetBudgetResponse;
import com.example.smartbudget.Response.GetExpenditureForDayResponse;
import com.example.smartbudget.Response.GetCategoriesResponse;
import com.example.smartbudget.Response.GetStatsResponse;
import com.example.smartbudget.Response.LoadYearResponse;
import com.example.smartbudget.Response.LoginResponse;
import com.example.smartbudget.Response.ReadBudgetResponse;
import com.example.smartbudget.Response.RegisterResponse;
import com.example.smartbudget.Response.ReportDayResponse;

public class ServerProxy implements IBackend {
    private static IBackend r;

    public static void setIRequestToResponse(IBackend meep){
        r = meep;
    }

    public static boolean usingServerSide() {
        return r instanceof ServerSide;
    }

    @Override
    public AddBudgetResponse addBudget(AddBudgetRequest request) {
        return r.addBudget(request);
    }

    @Override
    public AddExpenditureResponse addExpenditure(AddExpenditureRequest request) {
        return r.addExpenditure(request);
    }

    @Override
    public ReadBudgetResponse readBudget(ReadBudgetRequest request) {
        return r.readBudget(request);
    }

    @Override
    public DeleteBudgetResponse deleteBudget(DeleteBudgetRequest request) {
        return r.deleteBudget(request);
    }

    @Override
    public UpdateBudgetResponse updateBudget(UpdateBudgetRequest request) {
        return r.updateBudget(request);
    }

    @Override
    public LoadYearResponse loadYear(LoadYearRequest request) {
        return r.loadYear(request);
    }

    @Override
    public ReportDayResponse reportDay(ReportDayRequest request) {
        return r.reportDay(request);
    }

    @Override
    public EditExpendituresResponse editExpenditures(EditExpendituresRequest request) {
        return r.editExpenditures(request);
    }

    @Override
    public GetStatsResponse getStats(GetStatsRequest request) {
        return r.getStats(request);
    }

    @Override
    public EditCategoriesResponse editCategories(EditCategoriesRequest request) {
        return r.editCategories(request);
    }

    @Override
    public AddCategoryResponse addCategory(AddCategoryRequest request) {
        return r.addCategory(request);
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        return r.login(request);
    }

    @Override
    public RegisterResponse register(RegisterRequest request) {
        return r.register(request);
    }

    @Override
    public GetBudgetResponse getBudgets(GetBudgetsRequest request) {
        return r.getBudgets(request);
    }

    @Override
    public GetExpenditureForDayResponse getExpenditures(GetExpendituresForDayRequest request) {
        return r.getExpenditures(request);
    }

    @Override
    public GetCategoriesResponse getCategories(GetCategoriesRequest request) {
        return r.getCategories(request);
    }

    @Override
    public DeleteExpenditureResponse deleteExpenditure(DeleteExpenditureRequest request) {
        return r.deleteExpenditure(request);
    }

    @Override
    public DeleteCategoryResponse deleteCategory(DeleteCategoryRequest request) {
        return r.deleteCategory(request);
    }
}
