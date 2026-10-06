package com.example.projetopdmii;

public class Slide {
    private String nome;
    private int imagem;
    private String texto;


    public Slide(String nome, int imagem, String texto){
        this.nome = nome;
        this.imagem = imagem;
        this.texto = texto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
