package com.example.smartbudget.DAO;

import com.example.smartbudget.DAO.relational.SqlDao;
import com.example.smartbudget.DAO.relational.DatabaseSqlManager;
import com.example.smartbudget.Model.Category;
import com.example.smartbudget.Model.Expenditure;

import java.util.List;

public interface ExpenditureDao {
    void createExpenditure(Expenditure expenditure, Category category);
    List<Expenditure> getExpendituresForYear(Expenditure expenditure, Category category);
    List<Expenditure> getExpendituresAll(Expenditure expenditure, Category category);
}
