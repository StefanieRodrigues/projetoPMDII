package com.example.projetopdmii;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class TelaHome extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private ActionBarDrawerToggle toggler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.iddrawer), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        drawerLayout = findViewById(R.id.iddrawer);
        navigationView = findViewById(R.id.idnavigation);
        toolbar = findViewById(R.id.toolbar2);
        toggler = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggler);
        toggler.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.idhome){
                    drawerLayout.closeDrawers();
                    return false;
                }
                if (menuItem.getItemId() == R.id.idtela02){
                    drawerLayout.closeDrawers();
                    startActivity(new Intent(TelaHome.this, Tela02.class));
                    return true;
                }
                if (menuItem.getItemId() == R.id.idtela03){
                    drawerLayout.closeDrawers();
                    startActivity(new Intent(TelaHome.this, Tela03.class));
                    return true;
                }
                return false;
            }
        });
    }
}