package com.example.smartbudget.DAO.relational;

import com.example.smartbudget.DAO.ExpenditureDao;
import com.example.smartbudget.DAO.StatementExecutor;
import com.example.smartbudget.Exceptions.DataAccessException;
import com.example.smartbudget.Model.Expenditure;
import com.example.smartbudget.Model.User;

public class ExpenditureSqlDao extends SqlDao implements ExpenditureDao {

    public ExpenditureSqlDao(StatementExecutor executor) {
        super(executor);
    }

    // Expenditure(ExpenditureID, CategoryID, ExpenditureDescription, ExpenditureAmount -- real,
    // ExpenditureYear -- TEXT, ExpenditureMonth, ExpenditureDay)
    // Foreign Key CategoryID references Category



    @Override
    public String getTableStatement() {
        return
                "expenditure_id TEXT PRIMARY KEY,\n" + "category_id TEXT NOT NULL,\n" +
                "expenditure_description TEXT,\n" + "expenditure_amount REAL NOT NULL,\n" +
                "expenditure_year TEXT NOT NULL,\n" + "expenditure_month TEXT NOT NULL,\n"
                        + "expenditure_day TEXT NOT NULL,\n" +
                        "FOREIGN KEY(category_id) REFERENCES category(category_id)";
    }

    @Override
    protected String getTableName() {
        return "expenditure";
    }

    @Override
    public boolean createExpenditure(Expenditure expenditure) {
        //insert into user (user_id, user_name, user_password) values ('','','',);
        String sql = "INSERT INTO " + getTableName() + " (expenditure_id, category_id, " +
                "expenditure_description, expenditure_amount, expenditure_year, expenditure_month," +
                "expenditure_day)" +
                " VALUES ('" + expenditure.getId() + "','" + expenditure.getCategory() + "','" + expenditure.getDescription()
                + "','" + expenditure.getAmount() + "','" + expenditure.getYear() + "','" + expenditure.getMonth() + "','" +
                expenditure.getDay() + "');";
        try {
            return insert(sql) > 0;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
    }
}
