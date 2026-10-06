package com.example.projetopdmii;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SlideAdapter extends RecyclerView.Adapter<SlideHolder>{
    private ArrayList<Slide> lista;
    private TextView texto;

    public SlideAdapter(ArrayList<Slide> lista){

        this.lista = lista;
    }
    public SlideAdapter(ArrayList<Slide> lista, TextView texto){

        this.lista = lista;
        this.texto = texto;
    }
    @NonNull
    @Override
    public SlideHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.layout, parent, false);
        return new SlideHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull SlideHolder holder, int position) {
        holder.titulo.setText(lista.get(position).getNome());
        holder.imagem.setImageResource(lista.get(position).getImagem());


    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
