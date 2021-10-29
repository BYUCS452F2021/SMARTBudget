package com.example.smartbudget.Presenter;

import com.example.smartbudget.Response.DeleteCategoryResponse;
import com.example.smartbudget.Response.GetCategoriesResponse;

public interface GetCategoriesPresenter {
    void categoriesLoaded(GetCategoriesResponse response);
    void categoryDeleted(DeleteCategoryResponse response);
}
