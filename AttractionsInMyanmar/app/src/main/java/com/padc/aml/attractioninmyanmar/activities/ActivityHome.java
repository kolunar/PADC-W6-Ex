package com.padc.aml.attractioninmyanmar.activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.padc.aml.attractioninmyanmar.R;
import com.padc.aml.attractioninmyanmar.fragments.LoginFragment;
import com.padc.aml.attractioninmyanmar.fragments.RegisterFragment;

public class ActivityHome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private FrameLayout flContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        Menu leftMenu = navigationView.getMenu();
        navigationView.setNavigationItemSelectedListener(this);
        flContainer = (FrameLayout) findViewById(R.id.fl_container);

        LoginFragment login_fragment = new LoginFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, login_fragment)
                .commit();

        if(findViewById(R.id.fl_container_2) != null) {
            RegisterFragment register_fragment = new RegisterFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container_2, register_fragment)
                    .commit();
        }
    }

    private void navigateToLogin() {
        if(findViewById(R.id.fl_container_2) == null) {
            LoginFragment login_fragment = new LoginFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, login_fragment)
                    .commit();
        }
    }

    private void navigateToRegister() {
        if(findViewById(R.id.fl_container_2) == null) {
            RegisterFragment register_fragment = new RegisterFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, register_fragment)
                    .commit();
        }
    }

    @Override
    public boolean onNavigationItemSelected(final MenuItem menuItem) {
        menuItem.setChecked(true);

        drawerLayout.closeDrawers();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (menuItem.getItemId()) {
                    case R.id.left_menu_login:
                        navigateToLogin();
                        break;
                    case R.id.left_menu_register:
                        navigateToRegister();
                        break;
                }
            }
        }, 100); //to close drawer smoothly.

        return true;
    }

}
