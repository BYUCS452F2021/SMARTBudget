package com.example.smartbudget;

import com.example.smartbudget.Model.JsonHandler;
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

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ServerSide implements IBackend {
    private String host;
    private String port;

    public ServerSide(String host, String port) {
        this.host = host;
        this.port = port;
    }

    private String sendRequest(String request, String endPoint){
        try {
            URL url = new URL("http://" + host + ":" + port + endPoint);
            HttpURLConnection http = createConnection(url);
            writeJsonToOutputStream(request, http.getOutputStream());
            InputStream responseBody = getResponseInputStream(http);
            return readString(responseBody);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public AddBudgetResponse addBudget(AddBudgetRequest r){
        return (AddBudgetResponse) JsonHandler.Decode(sendRequest(JsonHandler.Encode(r),
                "/add-budget"), new AddBudgetResponse());
    }

    private static void writeJsonToOutputStream(String reqData, OutputStream reqBody) throws IOException {
        writeString(reqData, reqBody);
        reqBody.close();
    }

    private static HttpURLConnection createConnection(URL url) throws IOException {
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setRequestMethod("GET");
        http.setDoOutput(true);
        // http.setRequestProperty("Content-Type", "application/json");
        http.addRequestProperty("Accept", "application/json");
        http.connect();
        return http;
    }
    public static String readString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputStreamReader sr = new InputStreamReader(is);
        char[] buf = new char[1024];
        int len;
        while ((len = sr.read(buf)) > 0) {
            sb.append(buf, 0, len);
        }
        return sb.toString();
    }
    public static void writeString(String str, OutputStream os) throws IOException {
        OutputStreamWriter sw = new OutputStreamWriter(os);
        sw.write(str);
        sw.flush();
    }

    private static InputStream getResponseInputStream(HttpURLConnection http) throws IOException{
        if (http.getResponseCode() == HttpURLConnection.HTTP_OK) {
            return http.getInputStream();
        }
        else {
            return http.getErrorStream();
        }
    }

    @Override
    public AddExpenditureResponse addExpenditure(AddExpenditureRequest request) {
        return (AddExpenditureResponse) JsonHandler.Decode(sendRequest(JsonHandler.Encode(request),
                "/add-expenditure"), new AddExpenditureResponse());
    }

    @Override
    public ReadBudgetResponse readBudget(ReadBudgetRequest request) {
        return (ReadBudgetResponse) JsonHandler.Decode(sendRequest(JsonHandler.Encode(request),
                "/?"), new ReadBudgetResponse());
    }

    @Override
    public DeleteBudgetResponse deleteBudget(DeleteBudgetRequest request) {
        return (DeleteBudgetResponse) JsonHandler.Decode(sendRequest(JsonHandler.Encode(request),
                "/delete-budget"), new DeleteBudgetResponse());
    }

    @Override
    public UpdateBudgetResponse updateBudget(UpdateBudgetRequest request) {
        return (UpdateBudgetResponse) JsonHandler.Decode(sendRequest(JsonHandler.Encode(request),
                "/update-budget"), new UpdateBudgetResponse());
    }

    @Override
    public LoadYearResponse loadYear(LoadYearRequest request) {
        return (LoadYearResponse) JsonHandler.Decode(sendRequest(JsonHandler.Encode(request),
                "/?"), new LoadYearResponse());
    }

    @Override
    public ReportDayResponse reportDay(ReportDayRequest request) {
        return (ReportDayResponse) JsonHandler.Decode(sendRequest(JsonHandler.Encode(request),
                "/?"), new ReportDayResponse());
    }

    @Override
    public EditExpendituresResponse editExpenditures(EditExpendituresRequest request) {
        return (EditExpendituresResponse) JsonHandler.Decode(sendRequest(JsonHandler.Encode(request),
                "/?"), new EditExpendituresResponse());
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
        return (AddCategoryResponse) JsonHandler.Decode(sendRequest(JsonHandler.Encode(request),
                "/add-category"), new AddCategoryResponse());
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        return (LoginResponse) JsonHandler.Decode(sendRequest(JsonHandler.Encode(request),
                "/login"), new LoginResponse());
    }

    @Override
    public RegisterResponse register(RegisterRequest request) {
        return (RegisterResponse) JsonHandler.Decode(sendRequest(JsonHandler.Encode(request),
                "/register"), new RegisterResponse());
    }

    @Override
    public GetBudgetResponse getBudgets(GetBudgetsRequest request) {
        return (GetBudgetResponse) JsonHandler.Decode(sendRequest(JsonHandler.Encode(request),
                "/get-budgets"), new GetBudgetResponse());
    }

    @Override
    public GetExpenditureForDayResponse getExpenditures(GetExpendituresForDayRequest request) {
        return (GetExpenditureForDayResponse) JsonHandler.Decode(sendRequest(JsonHandler.Encode(request),
                "/get-expenditures"), new GetExpenditureForDayResponse());
    }

    @Override
    public GetCategoriesResponse getCategories(GetCategoriesRequest request) {
        return (GetCategoriesResponse) JsonHandler.Decode(sendRequest(JsonHandler.Encode(request),
                "/get-categories"), new GetCategoriesResponse());
    }

    @Override
    public DeleteExpenditureResponse deleteExpenditure(DeleteExpenditureRequest request) {
        return (DeleteExpenditureResponse) JsonHandler.Decode(sendRequest(JsonHandler.Encode(request),
                "/delete-expenditure"), new DeleteExpenditureResponse());
    }

    @Override
    public DeleteCategoryResponse deleteCategory(DeleteCategoryRequest request) {
        return (DeleteCategoryResponse) JsonHandler.Decode(sendRequest(JsonHandler.Encode(request),
                "/delete-category"), new DeleteCategoryResponse());
    }
}
