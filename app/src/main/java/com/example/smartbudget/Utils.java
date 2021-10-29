package com.example.smartbudget;

import android.content.Context;
import android.view.View;
import android.widget.PopupMenu;

public class Utils {
    public static void showPopup(Context activity, View v, int rMenu, PopupMenu.OnMenuItemClickListener context){
        PopupMenu popup = new PopupMenu(activity, v);
        popup.setOnMenuItemClickListener(context);
        popup.inflate(rMenu);
        popup.show();
    }
}
