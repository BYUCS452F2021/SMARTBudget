package com.example.smartbudget.DAO;

import com.example.smartbudget.DAO.relational.SqlDao;
import com.example.smartbudget.DAO.relational.DatabaseSqlManager;
import com.example.smartbudget.Model.Expenditure;

public interface ExpenditureDao {

    boolean createExpenditure(Expenditure expenditure);
}
