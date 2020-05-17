package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
private BottomNavigationView navigationView;
private FrameLayout frameLayout;
private account account;
private  refresh refresh;
private  search search;
private setting setting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView=findViewById(R.id.nav);

        frameLayout=findViewById(R.id.frame);
        account=new account();
        refresh=new refresh();
        search=new search();
        setting=new setting();
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.account:
                        navigationView.setItemBackgroundResource(R.color.colorAccent);
                        setfragment(account);
                        return true;

                    case R.id.refresh:
                        navigationView.setItemBackgroundResource(R.color.colorPrimary);
                        setfragment(refresh);
                        return true;


                    case R.id.search:
                        navigationView.setItemBackgroundResource(R.color.colorAccent);
                        setfragment(search);
                        return true;

                    case R.id.setting:
                        navigationView.setItemBackgroundResource(R.color.colorPrimary);
                        setfragment(setting);
                        return true;

                    default:
                        return false;
                }
            }

            public void setfragment(Fragment fragment) {
                FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame,fragment);
                fragmentTransaction.commit();
            }
        });

    }



}
