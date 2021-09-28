package com.example.smartbudget;

import com.example.smartbudget.Model.JsonHandler;
import com.example.smartbudget.Request.CreateBudgetRequest;
import com.example.smartbudget.Response.CreateBudgetResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Server {
    public static CreateBudgetResponse createBudget(CreateBudgetRequest r){
        try {
            URL url = new URL("http://" + "localhost" + ":" + "8080" + "/create");
            HttpURLConnection http = createConnection(url, false);
            writeJsonToOutputStream(JsonHandler.Encode(r), http.getOutputStream());
            InputStream respBody = getResponseInputStream(http);
            return (CreateBudgetResponse) JsonHandler.Decode(
                    readString(respBody), new CreateBudgetResponse());
        }
        catch (IOException e) {
            return new CreateBudgetResponse(e.getMessage());
        }
    }

    private static void writeJsonToOutputStream(String reqData, OutputStream reqBody) throws IOException {
        writeString(reqData, reqBody);
        reqBody.close();
    }

    private static HttpURLConnection createConnection(URL url, boolean isGet) throws IOException {
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        if (isGet) {
            http.setRequestMethod("GET");
            http.setDoOutput(false);
        }
        else {
            http.setRequestMethod("POST");
            http.setDoOutput(true);
        }
        http.setRequestProperty("Content-Type", "application/json");
        //http.addRequestProperty("Accept", "application/json");
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
}
