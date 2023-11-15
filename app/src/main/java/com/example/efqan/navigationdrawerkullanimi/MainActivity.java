package com.example.efqan.navigationdrawerkullanimi;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private Toolbar toolbar;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigationView);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);

        NavigationUI.setupWithNavController(navigationView,navHostFragment.getNavController());

        toolbar.setTitle("Alatoranliq");


        ActionBarDrawerToggle toggle =
                new ActionBarDrawerToggle(this,drawer,toolbar,0,0);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        View basliq = navigationView.inflateHeaderView(R.layout.navigation_basliq);
        TextView textViewBasliq = basliq.findViewById(R.id.textViewBasliq);
        textViewBasliq.setText("Salam!");

    }

    @Override
    public void onBackPressed() {

        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }

    }
}