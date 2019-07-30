package com.example.sos;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class contacts extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        BottomNavigationView topView = findViewById(R.id.nav_view_top) ;
        topView.setOnNavigationItemSelectedListener(this);

          topView.getMenu() .getItem(1).setChecked(true);




        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(contacts.this,add_contact.class);
                startActivity(intent);


            }
        });

    }


    private boolean loadFragemt(Fragment fragment)
    {
        if(fragment!=null)
        {
            getSupportFragmentManager() .beginTransaction() .replace(R.id.frame_container,fragment).commit() ;
            return true;
        }
        return false;


    }
    public void openMainActivity()
    {  Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void openSetting()
    {  Intent intent = new Intent(this,Setting.class);
        startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment =null;
        switch (menuItem.getItemId())
        {
            case R.id.navigation_home :
                openMainActivity();
                break;
            case R.id.navigation_rescue:
                fragment = new rescuefragment() ;
                break;
            case R.id.navigation_contacts:
                break;
            case R.id.navigation_setting:
                openSetting();
                break;

        }
        return loadFragemt(fragment);
    }


}

