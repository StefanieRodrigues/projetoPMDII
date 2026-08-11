package com.example.projetopdmii;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.Toolbar;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class tela02 extends AppCompatActivity implements MediaPlayer.OnCompletionListener, SeekBar.OnSeekBarChangeListener, Runnable {
    private Toolbar toolbar;
    private MediaPlayer mediaPlayer;
    private SeekBar seekbar;
    private Handler handler;


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
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            finish();
        }
        if (id == R.id.id001) {
            if (mediaPlayer == null) {
               mediaPlayer = MediaPlayer.create(this, R.raw.forrodofarol_quincasmoreira);
               mediaPlayer.setOnCompletionListener(this);
               seekbar.setMax(mediaPlayer.getDuration());
               handler.post(this);
               mediaPlayer.start();
            }else if (!mediaPlayer.isPlaying()){
                mediaPlayer.start();
            }

        }
        if (id == R.id.id003){
            if (mediaPlayer != null){
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
            }
        }
        if (id == R.id.id002){
            if (mediaPlayer != null && mediaPlayer.isPlaying()){
                mediaPlayer.pause();
            }
        }
        return false;
    }
    public boolean onCreateOptions(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        mediaPlayer.release();
        mediaPlayer = null;
        seekbar.setProgress(0);
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
            seekbar.setProgress(mediaPlayer.getCurrentPosition());
            seekbar.postDelayed(this, 1000);
        }
    }
}