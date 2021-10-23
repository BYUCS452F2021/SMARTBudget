package com.example.smartbudget;

import com.example.smartbudget.Handler.AddBudgetHandler;
import com.example.smartbudget.Handler.GetBudgetsHandler;
import com.example.smartbudget.Handler.LoginHandler;
import com.example.smartbudget.Handler.RegisterHandler;
import com.example.smartbudget.Request.AddBudgetRequest;
import com.example.smartbudget.Request.DeleteBudgetRequest;
import com.example.smartbudget.Request.EditBudgetRequest;
import com.example.smartbudget.Request.EditCategoriesRequest;
import com.example.smartbudget.Request.EditExpendituresRequest;
import com.example.smartbudget.Request.GetBudgetsRequest;
import com.example.smartbudget.Request.GetStatsRequest;
import com.example.smartbudget.Request.LoadYearRequest;
import com.example.smartbudget.Request.LoginRequest;
import com.example.smartbudget.Request.ReadBudgetRequest;
import com.example.smartbudget.Request.RegisterRequest;
import com.example.smartbudget.Request.ReportDayRequest;
import com.example.smartbudget.Response.AddBudgetResponse;
import com.example.smartbudget.Response.DeleteBudgetResponse;
import com.example.smartbudget.Response.EditBudgetResponse;
import com.example.smartbudget.Response.EditCategoriesResponse;
import com.example.smartbudget.Response.EditExpendituresResponse;
import com.example.smartbudget.Response.GetBudgetResponse;
import com.example.smartbudget.Response.GetStatsResponse;
import com.example.smartbudget.Response.LoadYearResponse;
import com.example.smartbudget.Response.LoginResponse;
import com.example.smartbudget.Response.ReadBudgetResponse;
import com.example.smartbudget.Response.RegisterResponse;
import com.example.smartbudget.Response.ReportDayResponse;

public class ServerProxy {

    public AddBudgetResponse addBudget(AddBudgetRequest request) {
        return new AddBudgetHandler().addBudget(request);
    }

    public ReadBudgetResponse readBudget(ReadBudgetRequest request) {
        return null;
    }

    public DeleteBudgetResponse deleteBudget(DeleteBudgetRequest request) {
        return null;
    }

    public EditBudgetResponse editBudget(EditBudgetRequest request) {
        return null;
    }

    public LoadYearResponse loadYear(LoadYearRequest request) {
        return null;
    }

    public ReportDayResponse reportDay(ReportDayRequest request) {
        return null;
    }

    public EditExpendituresResponse editExpenditures(EditExpendituresRequest request) {
        return null;
    }

    public GetStatsResponse getStats(GetStatsRequest request) {
        return null;
    }

    public EditCategoriesResponse editCategories(EditCategoriesRequest request) {
        return null;
    }

    public LoginResponse login(LoginRequest request) {
        //use handler
        return new LoginHandler().login(request);
    }

    public RegisterResponse register(RegisterRequest request) {
        //use handler
        return new RegisterHandler().register(request);
    }

    public GetBudgetResponse getBudgets(GetBudgetsRequest request){
        return new GetBudgetsHandler().getBudgets(request);
    }
}
