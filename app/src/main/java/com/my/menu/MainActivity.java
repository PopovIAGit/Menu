package com.my.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.my.menu.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private PopupMenu popupMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);

    popupMenu = new PopupMenu(this, activityMainBinding.text123);

    popupMenu.inflate(R.menu.popup);
        popupMenu.setOnMenuItemClickListener(this::onTextContextMenuItem);
        activityMainBinding.text123.setOnClickListener(v->popupMenu.show());


    }

    public boolean onTextContextMenuItem (MenuItem item){
            switch (item.getItemId()){

                case R.id.popup_blue:  activityMainBinding.text123.setTextColor(Color.BLUE); break;
                case R.id.popup_green: activityMainBinding.text123.setTextColor(Color.GREEN); break;
                case R.id.popup_red: activityMainBinding.text123.setTextColor(Color.RED); break;

            }
            return false;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.menu_add:
                Log.d("happy", "menu Add");
                return true;
            case R.id.menu_history:
                Log.d("happy", "menu history");
                return true;
            case R.id.menu_del:
                Log.d("happy", "menu del");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}