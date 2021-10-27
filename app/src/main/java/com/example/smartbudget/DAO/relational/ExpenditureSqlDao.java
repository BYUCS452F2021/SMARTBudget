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
    public void createExpenditure(Expenditure expenditure) {
        //insert into user (user_id, user_name, user_password) values ('','','',);
        String sql = "INSERT INTO " + getTableName() + " (expenditure_id, category_id, " +
                "expenditure_description, expenditure_amount, expenditure_year, expenditure_month," +
                "expenditure_day)" +
                " VALUES ('" + expenditure.getId() + "','" + expenditure.getCategory().getId() + "','" + expenditure.getDescription()
                + "','" + expenditure.getAmount() + "','" + expenditure.getYear() + "','" + expenditure.getMonth() + "','" +
                expenditure.getDay() + "');";
        try {
            insert(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     *  SELECT DISTINCT * FROM expenditure
     * 	JOIN category ON expenditure.category_id = category.category_id
     * 	WHERE....
     */
    @Override
    public List<Expenditure> getExpendituresForDay(Budget budget, int year, int month, int day) {
        String sql = "SELECT DISTINCT * FROM " + getTableName() +
                "JOIN category ON " + getTableName() + ".category_id = category.category_id" +
                " WHERE category.budget_id='" + budget.getBudgetID() + "' AND " +
                getTableName() + ".expenditure_year='" + year + "' AND " +
                getTableName() + ".expenditure_month='" + month + "' AND " +
                getTableName() + ".expenditure_day='" + day + "';";
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
                    result.getInt(5),
                            new Category(UUID.fromString(result.getString(6)),
                                    result.getString(7),
                                    result.getFloat(8))
            ));
        }
        return expenditures;
    }

    @Override
    public List<Expenditure> getExpendituresAll(Budget budget) {
        String sql = "SELECT DISTINCT * FROM " + getTableName() +
                "JOIN category ON " + getTableName() + ".category_id = category.category_id" +
                " WHERE category.budget_id='" + budget.getBudgetID() + "';";
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
                            result.getInt(5),
                            new Category(UUID.fromString(result.getString(6)),
                                    result.getString(7),
                                    result.getFloat(8))
                    ));
        }
        return expenditures;
    }

    // also needs an update
    // look up SQL update syntax (take in an Expenditure)

}
