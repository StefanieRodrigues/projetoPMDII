package com.example.projetopdmii;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Tela03 extends AppCompatActivity implements View.OnClickListener {
    private ViewPager2 viewPager;
    private ArrayList<Slide> lista;
    private TextView texto;

    private Button b;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela03);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.linear3), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        toolbar = findViewById(R.id.toolbar4);
        setSupportActionBar(toolbar);

        texto = findViewById(R.id.textView6);
        viewPager = findViewById(R.id.viewpager);
        lista = new ArrayList<Slide>();
        lista.add(new Slide("Slide 1", R.drawable.bode2, "Música: In the Morning ,\n Gênero: Pop,\n Cantor: Chapéuzinho\n"));
        lista.add(new Slide("Slide 2", R.drawable.mj_1, "Música: Ancient Song,\n Gênero: Rock ,\n Cantor: Mj Hihi,\n"));
        lista.add(new Slide("Slide 3", R.drawable.brancaneve, "Música: Why Babe Why,\n Gênero: Pop,\n Cantor: Brancona,\n"));
        lista.add(new Slide("Slide 4", R.drawable.pinkpie, "Música: Mukbang,\n Gênero: Trap,\n Cantor: Pinkpie,\n"));
        lista.add(new Slide("Slide 5", R.drawable.mjmeme, "Música: Paradise,\n Gênero: Pop,\n Cantor: Aiouque,\n"));
        SlideAdapter adapter = new SlideAdapter(lista, texto);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                texto.setText(lista.get(position).getTexto());

            }
        });
        viewPager.setAdapter(adapter);
        b = findViewById(R.id.button);
        b.setOnClickListener(this);

        drawerLayout = findViewById(R.id.iddrawer3);
        navigationView = findViewById(R.id.navigationView2);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.idhome){
                    drawerLayout.closeDrawers();
                    startActivity(new Intent(Tela03.this, TelaHome.class));
                    return false;
                }
                if (menuItem.getItemId() == R.id.idtela02){
                    drawerLayout.closeDrawers();
                    startActivity(new Intent(Tela03.this, Tela02.class));
                    return true;
                }
                if (menuItem.getItemId() == R.id.idtela03){
                    drawerLayout.closeDrawers();
                    return true;
                }

                return false;
            }
        });
    }

    @Override
    public void onClick(View view) {

       this.finish();
    }
}