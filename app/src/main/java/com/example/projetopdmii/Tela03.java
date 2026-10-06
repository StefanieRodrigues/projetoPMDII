package com.example.projetopdmii;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class Tela03 extends AppCompatActivity implements View.OnClickListener {
    private ViewPager2 viewPager;
    private ArrayList<Slide> lista;
    private TextView texto;

    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela03);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.iddrawer), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
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
    }

    @Override
    public void onClick(View view) {

       this.finish();
    }
}