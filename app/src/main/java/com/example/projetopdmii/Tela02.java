package com.example.projetopdmii;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Tela02 extends AppCompatActivity implements MediaPlayer.OnCompletionListener, SeekBar.OnSeekBarChangeListener, Runnable, View.OnClickListener {
    private Toolbar toolbar;
    private MediaPlayer mediaPlayer;
    private SeekBar seekbar;
    private Handler handler;

    private int musica, indiceLista;
    private ArrayList<Playlist> lista;
    private CardView card1,card2, card3, card4, card5;
    private TextView textoMusicaSeleciona, textoMusicaTocando, placarTempoAtual, placarTempoRestante;
    private ImageView imgPreview, imgNext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela02);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        toolbar = findViewById(R.id.toolbar);
        //Atribui a toolbar o poder de ActionBar
        setSupportActionBar(toolbar);
        //habilita o botão de voltar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        seekbar = findViewById(R.id.seekBar);
        seekbar.setOnSeekBarChangeListener(this);
        handler = new Handler();




        musica = R.raw.forrodofarol_quincasmoreira;
        lista = new ArrayList<Playlist>();
        lista.add(new Playlist("In The Morning", R.raw.morning));
        lista.add(new Playlist("Ancient Song", R.raw.musica1));
        lista.add(new Playlist("Why Babe Why", R.raw.whybabe));
        lista.add(new Playlist("Mukbang", R.raw.mukbang));
        lista.add(new Playlist("Paradise", R.raw.paradise));

        card1 = findViewById(R.id.card1);
        card1.setOnClickListener(this);
        card2 = findViewById(R.id.card2);
        card2.setOnClickListener(this);
        card3 = findViewById(R.id.card3);
        card3.setOnClickListener(this);
        card4 = findViewById(R.id.card4);
        card4.setOnClickListener(this);
        card5 = findViewById(R.id.card5);
        card5.setOnClickListener(this);
        textoMusicaSeleciona = findViewById(R.id.textView);
        textoMusicaTocando = findViewById(R.id.textView2);

        imgPreview = findViewById(R.id.imageView);
        imgPreview.setOnClickListener(this);
        imgNext = findViewById(R.id.imageView7);
        imgNext.setOnClickListener(this);

        placarTempoAtual = findViewById(R.id.textView4);
        placarTempoRestante = findViewById(R.id.textView3);


    }
    public String formatarTempo(int tempo){
        int segundos = tempo/1000;
        int minutos = segundos/60;
        segundos = segundos%60;
        String tempoFormatado = String.format("%02d:%02d", minutos, segundos);
        return tempoFormatado;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            finish();
        }
        if (id == R.id.id001) {
           play();

        }
        if (id == R.id.id003){
            stop();
        }
        if (id == R.id.id002){
            if (mediaPlayer != null && mediaPlayer.isPlaying()){
                mediaPlayer.pause();
            }
        }
        return false;
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        handler.removeCallbacks(this);
        mediaPlayer.release();
        this.mediaPlayer = null;
        seekbar.setProgress(0);
        indiceLista ++;
        if (indiceLista >= lista.size()){
            indiceLista = 0;
        }
        textoMusicaSeleciona.setText("Música selecionada: "+lista.get(indiceLista).getNome());
        stop();
        play();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        if (mediaPlayer != null) {
            mediaPlayer.seekTo(seekBar.getProgress());
        }

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void run() {
        if (mediaPlayer!= null) {
            int tempoAtual = mediaPlayer.getCurrentPosition();
            int duracao = mediaPlayer.getDuration();
            int tempoRestante = duracao - tempoAtual;
            placarTempoAtual.setText(formatarTempo(tempoAtual));
            placarTempoRestante.setText("-" + formatarTempo(tempoRestante));
            seekbar.setProgress(mediaPlayer.getCurrentPosition());
            seekbar.postDelayed(this, 1000);
        }
    }

    public void play (){
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, lista.get(indiceLista).getMusica());
            //textoMusicaTocando.setText("Música tocando: "+lista.get(indiceLista).getNome());
            toolbar.setTitle(lista.get(indiceLista).getNome());
            int X = indiceLista;
            X++;
            toolbar.setSubtitle(Integer.toString(X)+" de " + Integer.toString(lista.size()));
            mediaPlayer.setOnCompletionListener(this);
            seekbar.setMax(mediaPlayer.getDuration());
            handler.post(this);
            mediaPlayer.start();
        }else if (!mediaPlayer.isPlaying()){
            mediaPlayer.start();
            handler.post(this);
        }
    }

    public void stop(){
        if (mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }


    @Override
    public void onClick(View view) {
        if (view == card1){
            indiceLista = 0;
            textoMusicaSeleciona.setText("Música Selecionada: "+lista.get(indiceLista).getNome());
            musica = lista.get(indiceLista).getMusica();

        }
        if (view == card2){
            indiceLista = 1;
            textoMusicaSeleciona.setText("Música Selecionada: "+lista.get(indiceLista).getNome());
            musica = lista.get(indiceLista).getMusica();

        }
        if (view == card3){
            indiceLista = 2;
            textoMusicaSeleciona.setText("Música Selecionada: "+lista.get(indiceLista).getNome());
            musica = lista.get(indiceLista).getMusica();

        }
        if (view == card4){
            indiceLista = 3;
            textoMusicaSeleciona.setText("Música Selecionada: "+lista.get(indiceLista).getNome());
            musica = lista.get(indiceLista).getMusica();

        }
        if (view == card5){
            indiceLista = 4;
            textoMusicaSeleciona.setText("Música Selecionada: "+lista.get(indiceLista).getNome());
            musica = lista.get(indiceLista).getMusica();

        }
        if (view == imgPreview){
            indiceLista --;
            if (indiceLista <0){
                indiceLista = lista.size()-1;
            }
            textoMusicaSeleciona.setText("Música selecionada: "+lista.get(indiceLista).getNome());
            stop();
            play();
        }
        if (view == imgNext){
          indiceLista++;
          if(indiceLista >= lista.size()){
              indiceLista = 0;
          }
          textoMusicaSeleciona.setText("Música selecionada: "+lista.get(indiceLista).getNome());
            stop();
            play();
        }
    }
}
