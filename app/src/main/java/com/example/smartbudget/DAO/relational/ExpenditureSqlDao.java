package com.example.smartbudget.DAO.relational;

import android.database.Cursor;

import com.example.smartbudget.DAO.ExpenditureDao;
import com.example.smartbudget.DAO.StatementExecutor;
import com.example.smartbudget.Exceptions.DataAccessException;
import com.example.smartbudget.Model.Budget;
import com.example.smartbudget.Model.Category;
import com.example.smartbudget.Model.Expenditure;
import com.example.smartbudget.Model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ExpenditureSqlDao extends SqlDao implements ExpenditureDao {

    public ExpenditureSqlDao(StatementExecutor executor) {
        super(executor);
    }

    @Override
    public String getTableStatement() {
        return  "expenditure_id TEXT PRIMARY KEY,\n" +
                "category_id TEXT NOT NULL,\n" +
                "expenditure_description TEXT,\n" +
                "expenditure_amount REAL NOT NULL,\n" +
                "expenditure_year TEXT NOT NULL,\n" +
                "expenditure_month TEXT NOT NULL,\n" +
                "expenditure_day TEXT NOT NULL,\n" +
                "FOREIGN KEY(category_id) REFERENCES category(category_id)";
    }

    @Override
    protected String getTableName() {
        return "expenditure";
    }

    @Override
    public void createExpenditure(Expenditure expenditure, Category category) {
        //insert into user (user_id, user_name, user_password) values ('','','',);
        String sql = "INSERT INTO " + getTableName() + " (expenditure_id, category_id, " +
                "expenditure_description, expenditure_amount, expenditure_year, expenditure_month," +
                "expenditure_day)" +
                " VALUES ('" + expenditure.getId() + "','" + category.getId() + "','" + expenditure.getDescription()
                + "','" + expenditure.getAmount() + "','" + expenditure.getYear() + "','" + expenditure.getMonth() + "','" +
                expenditure.getDay() + "');";
        try {
            insert(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Expenditure> getExpendituresForYear(Expenditure expenditure, Category category) {
        // join with the category table and figure out what
        String sql = "SELECT * FROM " + getTableName() + " WHERE budget_id='" + expenditure.getId() + "';";
        List<Expenditure> expenditures = new ArrayList<>();
        Cursor result = (Cursor) executor.executeQuery(sql);
        while (result.moveToNext()){
            expenditures.add(
                    new Expenditure(
                    UUID.fromString(result.getString(0)),
                    result.getString(1),
                    result.getFloat(2),
                    result.getInt(3),
                    result.getInt(4),
                    result.getInt(5)
            ));
        }
        return expenditures;
    }

    @Override
    public List<Expenditure> getExpendituresAll(Expenditure expenditure, Category category) {
        return null;
    }

    // also needs an update
    // look up SQL update syntax (take in an Expenditure)

}
