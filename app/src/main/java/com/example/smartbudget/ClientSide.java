package com.example.smartbudget;

import com.example.smartbudget.Handler.AddBudgetHandler;
import com.example.smartbudget.Handler.AddCategoryHandler;
import com.example.smartbudget.Handler.AddExpenditureHandler;
import com.example.smartbudget.Handler.DeleteBudgetHandler;
import com.example.smartbudget.Handler.DeleteCategoryHandler;
import com.example.smartbudget.Handler.DeleteExpenditureHandler;
import com.example.smartbudget.Handler.GetBudgetsHandler;
import com.example.smartbudget.Handler.GetCategoriesHandler;
import com.example.smartbudget.Handler.GetExpendituresForDayHandler;
import com.example.smartbudget.Handler.LoginHandler;
import com.example.smartbudget.Handler.RegisterHandler;
import com.example.smartbudget.Handler.UpdateBudgetHandler;
import com.example.smartbudget.Request.AddBudgetRequest;
import com.example.smartbudget.Request.AddCategoryRequest;
import com.example.smartbudget.Request.AddExpenditureRequest;
import com.example.smartbudget.Request.DeleteBudgetRequest;
import com.example.smartbudget.Request.DeleteCategoryRequest;
import com.example.smartbudget.Request.DeleteExpenditureRequest;
import com.example.smartbudget.Request.EditCategoriesRequest;
import com.example.smartbudget.Request.EditExpendituresRequest;
import com.example.smartbudget.Request.GetBudgetsRequest;
import com.example.smartbudget.Request.GetCategoriesRequest;
import com.example.smartbudget.Request.GetExpendituresForDayRequest;
import com.example.smartbudget.Request.GetStatsRequest;
import com.example.smartbudget.Request.LoadYearRequest;
import com.example.smartbudget.Request.LoginRequest;
import com.example.smartbudget.Request.ReadBudgetRequest;
import com.example.smartbudget.Request.RegisterRequest;
import com.example.smartbudget.Request.ReportDayRequest;
import com.example.smartbudget.Request.UpdateBudgetRequest;
import com.example.smartbudget.Response.AddBudgetResponse;
import com.example.smartbudget.Response.AddCategoryResponse;
import com.example.smartbudget.Response.AddExpenditureResponse;
import com.example.smartbudget.Response.DeleteBudgetResponse;
import com.example.smartbudget.Response.DeleteCategoryResponse;
import com.example.smartbudget.Response.DeleteExpenditureResponse;
import com.example.smartbudget.Response.EditCategoriesResponse;
import com.example.smartbudget.Response.EditExpendituresResponse;
import com.example.smartbudget.Response.GetBudgetResponse;
import com.example.smartbudget.Response.GetCategoriesResponse;
import com.example.smartbudget.Response.GetExpenditureForDayResponse;
import com.example.smartbudget.Response.GetStatsResponse;
import com.example.smartbudget.Response.LoadYearResponse;
import com.example.smartbudget.Response.LoginResponse;
import com.example.smartbudget.Response.ReadBudgetResponse;
import com.example.smartbudget.Response.RegisterResponse;
import com.example.smartbudget.Response.ReportDayResponse;
import com.example.smartbudget.Response.UpdateBudgetResponse;

public class ClientSide implements IBackend {
    @Override
    public AddBudgetResponse addBudget(AddBudgetRequest request) {
        return new AddBudgetHandler().handleRequest(request);
    }
    @Override
    public AddExpenditureResponse addExpenditure(AddExpenditureRequest request) {
        return new AddExpenditureHandler().handleRequest(request);
    }

    @Override
    public ReadBudgetResponse readBudget(ReadBudgetRequest request) {
        return null;
    }
    @Override
    public DeleteBudgetResponse deleteBudget(DeleteBudgetRequest request) {
        return new DeleteBudgetHandler().handleRequest(request);
    }
    @Override
    public UpdateBudgetResponse updateBudget(UpdateBudgetRequest request) {
        return new UpdateBudgetHandler().handleRequest(request);
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
    public AddCategoryResponse addCategory(AddCategoryRequest request) {
        return new AddCategoryHandler().handleRequest(request);
    }
    @Override
    public LoginResponse login(LoginRequest request) {
        //use handler
        return new LoginHandler().handleRequest(request);
    }
    @Override
    public RegisterResponse register(RegisterRequest request) {
        //use handler
        return new RegisterHandler().handleRequest(request);
    }
    @Override
    public GetBudgetResponse getBudgets(GetBudgetsRequest request){
        return new GetBudgetsHandler().handleRequest(request);
    }
    @Override
    public GetExpenditureForDayResponse getExpenditures(GetExpendituresForDayRequest request) {
        return new GetExpendituresForDayHandler().handleRequest(request);
    }
    @Override
    public GetCategoriesResponse getCategories(GetCategoriesRequest request) {
        return new GetCategoriesHandler().handleRequest(request);
    }
    @Override
    public DeleteExpenditureResponse deleteExpenditure(DeleteExpenditureRequest request){
        return new DeleteExpenditureHandler().handleRequest(request);
    }
    @Override
    public DeleteCategoryResponse deleteCategory(DeleteCategoryRequest request){
        return new DeleteCategoryHandler().handleRequest(request);
    }
}
