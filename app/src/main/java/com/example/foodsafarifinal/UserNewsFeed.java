package com.example.foodsafarifinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
/**User newsfeed main class**/
public class UserNewsFeed extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_news_feed);

        toolbar = findViewById(R.id.toolbar_user_feed);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Menu");

        drawer = findViewById(R.id.user_nav_drawer);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MenuFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_menu);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_menu:
                toolbar.setTitle(R.string.fragment_home);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MenuFragment()).commit();
                break;
            case R.id.nav_my_orders:
                toolbar.setTitle(R.string.fragment_my_order);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MyOrderFragment()).commit();
                break;
            case R.id.nav_my_profile:
                toolbar.setTitle(R.string.fragment_my_profile);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MyProfileFragment()).commit();
                break;
            case R.id.nav_discount:
                toolbar.setTitle(R.string.fragment_discount);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DiscountFragment()).commit();
                break;
            case R.id.nav_help_line:
                toolbar.setTitle(R.string.fragment_helpline);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HelpLineFragnent()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }


}
